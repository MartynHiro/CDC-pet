package ru.martinov.connector.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.martinov.connector.domain.entity.User;
import ru.martinov.connector.repository.UserRepository;
import ru.martinov.connector.util.Operation;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void processEvent(Map<String, Object> userData, Operation operation) {
        final ObjectMapper mapper = new ObjectMapper();
        final User user = mapper.convertValue(userData, User.class);

        if (Operation.DELETE.name().equals(operation.name())) {
            userRepository.deleteById(user.getId());
        } else {
            userRepository.save(user);
        }
    }
}
