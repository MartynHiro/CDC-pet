package ru.martinov.connector.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import ru.martinov.connector.domain.dto.KafkaUserMessage;
import ru.martinov.connector.domain.entity.User;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MessageMapper {
    KafkaUserMessage convertUserIntoKafkaMessage(User user);
}
