package ru.martinov.externalsystem.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Модель данных для ответа пользователю")
public record ResponseForUserDto(
        @Schema(description = "Текст сообщения пользователю")
        @NotBlank(message = "answerMessage не может быть пустым")
        @NotNull(message = "answerMessage не может быть пустым")
        String answerMessage) {
}
