package ru.martinov.externalsystem.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.martinov.externalsystem.domain.dto.MessageFromUserDto;
import ru.martinov.externalsystem.domain.dto.ResponseForUserDto;
import ru.martinov.externalsystem.domain.entity.User;
import ru.martinov.externalsystem.exception.UserAlreadyExistsException;
import ru.martinov.externalsystem.repository.UserRepository;
import ru.martinov.externalsystem.service.UserService;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final String SUCCESSFUL_MESSAGE = "Пользователь был успешно сохранен";

    private final UserRepository userRepository;

    @Override
    @Transactional
    public ResponseForUserDto saveUser(MessageFromUserDto messageFromUserDto) {
        String email = messageFromUserDto.email();
        userRepository
                .findByEmail(email)
                .ifPresentOrElse(user -> {
                    log.error("Пользователь {} уже существует", email);
                    throw new UserAlreadyExistsException(email);
                }, () -> createUser(messageFromUserDto));
        return new ResponseForUserDto(SUCCESSFUL_MESSAGE);
    }

    private void createUser(MessageFromUserDto messageFromUserDto) {
        String email = messageFromUserDto.email();
        var user = User.builder()
                .name(messageFromUserDto.name())
                .email(email)
                .build();
        userRepository.save(user);
        log.info("Пользователь {} успешно создан", email);
    }
}
