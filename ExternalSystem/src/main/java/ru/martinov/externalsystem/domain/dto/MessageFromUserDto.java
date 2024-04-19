package ru.martinov.externalsystem.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Модель данных полученных от пользователя")
public record MessageFromUserDto(
        @Schema(description = "Имя пользователя")
        @NotBlank(message = "name не может быть пустым")
        @NotNull(message = "name не может быть пустым")
        String name,
        @Schema(description = "Почта пользователя")
        @NotBlank(message = "email не может быть пустым")
        @NotNull(message = "email не может быть пустым")
        String email) {
}
