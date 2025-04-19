package leandro.dev.service;

import leandro.dev.base_domains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
    private final JavaMailSender mailSender;

    @Value("${app.email.default-recipient:orders@company.com}")
    private String defaultRecipient;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendOrderNotification(OrderEvent event) {
        String subject = "Order Update - ID: " + event.getOrder().getOrderId();
        String body = buildEmailBody(event);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(defaultRecipient); // Usa email padrão
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
        LOGGER.info("Order notification sent for order {}", event.getOrder().getOrderId());
    }

    private String buildEmailBody(OrderEvent event) {
        return String.format("""
            Order Notification (Internal)
            ----------------------------
            Order ID: %s
            Status: %s
            Message: %s
            Product: %s
            Quantity: %d
            Total: %.2f
            
            Action required: Please contact customer for updates.
            """,
                event.getOrder().getOrderId(),
                event.getStatus(),
                event.getMessage(),
                event.getOrder().getName(), // Assumindo que Order tem getName()
                event.getOrder().getQty(),
                event.getOrder().getPrice());
    }
}