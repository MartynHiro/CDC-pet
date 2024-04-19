package ru.martinov.connector.kafka.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.martinov.connector.kafka.event.CdcEvent;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventConsumer {

    @KafkaListener(topics = "users_events", id = "internal-consumer")
    public void processEvent(@Payload(required = false) CdcEvent event) {

        log.info("Поймал! {}", event.toString());





//        switch (event.getOperationType()) {
//            case 'c', 'r', 'u' -> {
//                var product = event.getPayload().getAfter();
//                updateStockService.updateStock(product.getId(), product.getQuantityLeft());
//            }
//            case 'd' -> {
//                var productIdToDelete = event.getPayload().getBefore().getId();
//                deleteStockService.deleteByProductId(productIdToDelete);
//            }
//        }
    }
}
