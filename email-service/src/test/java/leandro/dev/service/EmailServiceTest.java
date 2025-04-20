package leandro.dev.service;

import leandro.dev.base_domains.dto.Order;
import leandro.dev.base_domains.dto.OrderEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class EmailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EmailService emailService;

    @BeforeEach
    void setup() {
        // Define o destinatário padrão para teste
        ReflectionTestUtils.setField(emailService, "defaultRecipient", "teste@exemplo.com");
    }

    @Test
    void testSendOrderNotification() {
        // Criação de pedido falso
        Order order = new Order();
        order.setOrderId("12345");
        order.setName("Produto Teste");
        order.setQty(2);
        order.setPrice(BigDecimal.valueOf(50.0));

        OrderEvent event = new OrderEvent();
        event.setOrder(order);
        event.setStatus("PROCESSING");
        event.setMessage("Pedido em andamento");

        // Chamada do método real
        emailService.sendOrderNotification(event);

        // Verificação de envio
        ArgumentCaptor<SimpleMailMessage> captor = ArgumentCaptor.forClass(SimpleMailMessage.class);
        verify(mailSender, times(1)).send(captor.capture());

        SimpleMailMessage sentMessage = captor.getValue();
        assert sentMessage.getTo()[0].equals("teste@exemplo.com");
        assert sentMessage.getSubject().contains("Order Update - ID: 12345");
        assert sentMessage.getText().contains("Produto Teste");
    }
}
