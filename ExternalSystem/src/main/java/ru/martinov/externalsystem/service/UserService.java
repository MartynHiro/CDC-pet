package ru.martinov.externalsystem.service;

import org.springframework.stereotype.Service;
import ru.martinov.externalsystem.domain.dto.MessageFromUserDto;
import ru.martinov.externalsystem.domain.dto.ResponseForUserDto;

@Service
public interface UserService {
    ResponseForUserDto saveUser(MessageFromUserDto messageFromUserDto);
}
