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
public class CdcEvent implements Serializable {

    private CdcPayload payload;

    public char getOperationType() {
        return payload.getOp();
    }
}
