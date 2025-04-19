package leandro.dev.kafka;

import leandro.dev.base_domains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(OrderEvent event) {
        try {
            if (event == null || event.getOrder() == null || event.getOrder().getOrderId() == null) {
                LOGGER.warn("Evento de pedido inválido recebido no serviço de estoque: {}", event);
                return;
            }

            LOGGER.info("Order event received in stock service => {}", event.toString());


        } catch (Exception e) {
            LOGGER.error("Erro ao processar evento de pedido no serviço de estoque", e);
        }
    }


}
