package ru.martinov.externalsystem.exception.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.martinov.externalsystem.exception.UserAlreadyExistsException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse wrongMessageToKafkaException(HttpServletRequest request,
                                                      UserAlreadyExistsException exception) {
        return ErrorResponse.builder()
                .detail("Пользователь с почтой " + exception.getMessage() + " уже существует")
                .request(request.getMethod() + " " + request.getRequestURI())
                .time(getTime())
                .build();
    }

    private String getTime() {
        String datePattern = "dd-MM-yyyy HH:mm:ss";
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(datePattern));
    }

    @Builder
    public record ErrorResponse(String detail, String request, String time) {
    }
}
