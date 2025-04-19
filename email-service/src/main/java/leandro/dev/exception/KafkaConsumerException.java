package leandro.dev.exception;



import leandro.dev.base_domains.dto.OrderEvent;

public class KafkaConsumerException extends RuntimeException {
    private final OrderEvent failedEvent;

    public KafkaConsumerException(String message, Throwable cause, OrderEvent failedEvent) {
        super(message, cause);
        this.failedEvent = failedEvent;
    }

    public OrderEvent getFailedEvent() {
        return failedEvent;
    }
}