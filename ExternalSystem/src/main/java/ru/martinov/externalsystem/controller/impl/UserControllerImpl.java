package ru.martinov.externalsystem.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
        log.info("Сообщение от пользователя {} получено", messageFromUserDto.name());
        return userService.saveUser(messageFromUserDto);
    }
}
