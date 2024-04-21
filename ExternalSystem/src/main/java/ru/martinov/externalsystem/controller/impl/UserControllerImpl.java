package ru.martinov.externalsystem.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.martinov.externalsystem.controller.UserController;
import ru.martinov.externalsystem.domain.dto.MessageFromUserDto;
import ru.martinov.externalsystem.domain.dto.ResponseForUserDto;
import ru.martinov.externalsystem.service.UserService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    @ResponseStatus(HttpStatus.OK)
    public ResponseForUserDto addUser(@RequestBody MessageFromUserDto messageFromUserDto) {
        log.info("Запрос на добавление от пользователя {} получен", messageFromUserDto.name());
        return userService.saveUser(messageFromUserDto);
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public ResponseForUserDto deleteUser(@PathVariable Long id) {
        log.info("Запрос на удаление от пользователя с id {} получен", id);
        return userService.deleteUser(id);
    }
}
