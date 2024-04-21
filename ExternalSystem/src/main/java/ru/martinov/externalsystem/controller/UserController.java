package ru.martinov.externalsystem.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.martinov.externalsystem.domain.dto.MessageFromUserDto;
import ru.martinov.externalsystem.domain.dto.ResponseForUserDto;
import ru.martinov.externalsystem.exception.handler.GlobalExceptionHandler;

@Tag(name = "UserController", description = "Для работы с сущностью пользователя")
@RestController
@RequestMapping("/api_v1/user")
public interface UserController {
    String OK = "OK";
    String CODE_OK = "200";
    String BAD_REQUEST = "BAD REQUEST";
    String CODE_BAD_REQUEST = "400";
    String INTERNAL_SERVER_ERROR = "Внутренняя ошибка сервера";
    String CODE_INTERNAL_SERVER_ERROR = "500";

    @ApiResponse(responseCode = CODE_OK, description = OK,
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseForUserDto.class))})
    @ApiResponse(responseCode = CODE_BAD_REQUEST, description = BAD_REQUEST,
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = GlobalExceptionHandler.ErrorResponse.class))})
    @ApiResponse(responseCode = CODE_INTERNAL_SERVER_ERROR, description = INTERNAL_SERVER_ERROR,
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = GlobalExceptionHandler.ErrorResponse.class))})
    @PostMapping
    ResponseForUserDto addUser(@RequestBody MessageFromUserDto messageFromUserDto);

    @ApiResponse(responseCode = CODE_OK, description = OK,
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseForUserDto.class))})
    @ApiResponse(responseCode = CODE_BAD_REQUEST, description = BAD_REQUEST,
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = GlobalExceptionHandler.ErrorResponse.class))})
    @ApiResponse(responseCode = CODE_INTERNAL_SERVER_ERROR, description = INTERNAL_SERVER_ERROR,
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = GlobalExceptionHandler.ErrorResponse.class))})
    @DeleteMapping("/{id}")
    ResponseForUserDto deleteUser(@PathVariable Long id);
}
