package ru.martinov.connector.kafka.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEvent implements Serializable {

//    @JsonAlias("id")
    private Long id;

//    @JsonAlias("name")
    private String name;

//    @JsonAlias("email")
    private String email;
}
