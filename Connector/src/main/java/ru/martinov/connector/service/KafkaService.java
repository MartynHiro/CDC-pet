package ru.martinov.connector.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.martinov.connector.domain.entity.User;
import ru.martinov.connector.kafka.KafkaProducer;
import ru.martinov.connector.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KafkaService {

    private final UserRepository userRepository;
    private final KafkaProducer kafkaProducer;

    @Scheduled(fixedRate = 3000)
    public void checkOutbox() {
        List<User> users = userRepository.findAllByIsSendFalseOrderById();
        sendToKafka(users);
    }

    private void sendToKafka(List<User> users) {
        kafkaProducer.sendMessageToKafka(users);
    }
}
