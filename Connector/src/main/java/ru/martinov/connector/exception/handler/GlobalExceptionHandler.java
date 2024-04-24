package ru.martinov.connector.exception.handler;

import lombok.Builder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(KafkaException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorResponse wrongMessageToKafkaException(HttpServletRequest request,
//                                                      KafkaException exception) {
//        return ErrorResponse.builder()
//                .detail("Сообщение не было отправлено в топик кафки: " + exception.getMessage())
//                .request(request.getMethod() + " " + request.getRequestURI())
//                .time(getTime())
//                .build();
//    }

    private String getTime() {
        String datePattern = "dd-MM-yyyy HH:mm:ss";
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(datePattern));
    }

    @Builder
    public record ErrorResponse(String detail, String request, String time) {
    }
}
