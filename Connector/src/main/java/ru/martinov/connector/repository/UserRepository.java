package ru.martinov.connector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.martinov.connector.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
