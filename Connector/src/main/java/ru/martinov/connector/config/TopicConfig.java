package ru.martinov.connector.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

    @Value("${spring.kafka.topic-name}")
    private String userTopicName;
    @Bean
    NewTopic userTopic() {
        return TopicBuilder
                .name(userTopicName)
                .partitions(1)
                .build();
    }
}
