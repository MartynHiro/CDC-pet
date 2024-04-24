package ru.martinov.connector.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import ru.martinov.connector.domain.dto.KafkaUserMessage;
import ru.martinov.connector.domain.entity.User;
import ru.martinov.connector.domain.mapper.MessageMapper;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, KafkaUserMessage> kafkaTemplate;
    private final MessageMapper messageMapper;

    @Value(value = "${spring.kafka.topic-name}")
    private String topicName;

    public void sendMessageToKafka(User user) {
        CompletableFuture<SendResult<String, KafkaUserMessage>> resultFuture = kafkaTemplate
                .send(topicName, messageMapper.convertUserIntoKafkaMessage(user));

        checkMessageSending(resultFuture);
    }

    private void checkMessageSending(CompletableFuture<SendResult<String, KafkaUserMessage>> future) {
        future.whenComplete((result, exception) -> {
            if (exception == null) {
                log.info("Сообщение было отправлено в топик {} с оффсетом {}", topicName, result.getRecordMetadata().offset());
            } else {
                log.error("Не получилось отправить сообщение в топик {}", topicName);
            }
        });
    }
}
