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
        String userName = user.getName();
        CompletableFuture<SendResult<String, KafkaUserMessage>> resultFuture = kafkaTemplate
                .send(topicName, messageMapper.convertUserIntoKafkaMessage(user));

        checkMessageSending(resultFuture, userName);
    }

    private void checkMessageSending(CompletableFuture<SendResult<String, KafkaUserMessage>> future, String userName) {
        future.whenComplete((result, exception) -> {
            if (exception == null) {
                log.info("Сообщение пользователя {} было отправлено в топик {} с оффсетом {}",
                        userName, topicName, result.getRecordMetadata().offset());
            } else {
                log.error("У пользователя {} не получилось отправить сообщение в топик {}", userName, topicName);
                throw new KafkaNotAvailableException(userName);
            }
        });
    }
}
