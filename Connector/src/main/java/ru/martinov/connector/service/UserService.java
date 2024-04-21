package ru.martinov.connector.service;

import io.debezium.data.Envelope;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.martinov.connector.domain.entity.User;
import ru.martinov.connector.repository.UserRepository;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void replicateData(Map<String, Object> eventMap, Envelope.Operation operation) {
        final User currentUser = mapToUser(eventMap);

        if (Envelope.Operation.DELETE == operation) {
            log.info("Был принят евент удаления пользователя");
            userRepository.deleteById(currentUser.getId());
        } else {
            log.info("Был принят евент добавления / изменения");
            userRepository.save(currentUser);
        }
    }

    private User mapToUser(Map<String, Object> eventMap) {
        User userFromEvent = new User();

        if (eventMap.containsKey("id") && eventMap.get("id") instanceof Long id) {
            userFromEvent.setId(id);
        }

        if (eventMap.containsKey("name") && eventMap.get("name") instanceof String name) {
            userFromEvent.setName(name);
        }

        if (eventMap.containsKey("email") && eventMap.get("email") instanceof String email) {
            userFromEvent.setEmail(email);
        }
        log.info("Сформирован пользователь из евента");
        return userFromEvent;
    }
}
