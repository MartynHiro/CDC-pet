package ru.martinov.connector.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель данных для сообщения кафки на основе сущности User")
public record KafkaUserMessage(Long id,
                               String name,
                               String email)  {
}
