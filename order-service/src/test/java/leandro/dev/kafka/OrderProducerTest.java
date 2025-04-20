package leandro.dev.kafka;

import leandro.dev.base_domains.dto.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderProducerTest {

    private KafkaTemplate<String, OrderEvent> kafkaTemplate;
    private NewTopic topic;
    private OrderProducer orderProducer;

    @BeforeEach
    void setUp() {
        kafkaTemplate = mock(KafkaTemplate.class);
        topic = new NewTopic("order-topic", 1, (short) 1);
        orderProducer = new OrderProducer(topic, kafkaTemplate);
    }

    @Test
    void testSendMessage() {
        // Arrange
        OrderEvent event = new OrderEvent();
        event.setEventId("1234");
        event.setStatus("PLACED");
        event.setMessage("Pedido criado com sucesso");

        // Act
        orderProducer.sendMessage(event);

        // Assert
        ArgumentCaptor<Message<OrderEvent>> messageCaptor = ArgumentCaptor.forClass(Message.class);
        verify(kafkaTemplate, times(1)).send(messageCaptor.capture());

        Message<OrderEvent> capturedMessage = messageCaptor.getValue();
        assertEquals(event, capturedMessage.getPayload());
        assertEquals(topic.name(), capturedMessage.getHeaders().get("kafka_topic"));
    }
}
