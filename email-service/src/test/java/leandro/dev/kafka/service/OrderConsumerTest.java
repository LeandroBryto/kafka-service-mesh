package leandro.dev.kafka.service;

import leandro.dev.base_domains.dto.OrderEvent;
import leandro.dev.kafka.OrderConsumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

class OrderConsumerTest {

    private Logger logger;
    private OrderConsumer orderConsumer;

    @BeforeEach
    void setUp() {
        logger = mock(Logger.class);
        orderConsumer = new OrderConsumerTestable(logger);
    }

    @Test
    void testConsumeLogsReceivedOrderEvent() {

        OrderEvent event = new OrderEvent();
        event.setEventId("1111");
        event.setStatus("PLACED");
        event.setMessage("Pedido criado");


        orderConsumer.consume(event);


        verify(logger).info(String.format("Order event received in email service => %s", event.toString()));
    }


    static class OrderConsumerTestable extends OrderConsumer {
        private final Logger customLogger;

        public OrderConsumerTestable(Logger logger) {
            this.customLogger = logger;
        }

        @Override
        public void consume(OrderEvent event) {
            customLogger.info(String.format("Order event received in email service => %s", event.toString()));
        }
    }
}
