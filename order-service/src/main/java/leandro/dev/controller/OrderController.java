package leandro.dev.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import leandro.dev.base_domains.dto.Order;
import leandro.dev.base_domains.dto.OrderEvent;
import leandro.dev.kafka.OrderProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }
    @Operation(
            summary = "Cria um novo pedido e envia para o Kafka",
            description = "Este endpoint cria um novo pedido, gera um evento e o envia para o Kafka com status pendente."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping("/orders")
    public ResponseEntity<String> placeOrder(@Valid @RequestBody Order order) {
        // Gerar ID único para o pedido
        order.setOrderId(UUID.randomUUID().toString());

        // Criar evento de pedido
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("Order is in pending state");
        orderEvent.setTimestamp(LocalDateTime.now());
        orderEvent.setEventId(UUID.randomUUID().toString());
        orderEvent.setOrder(order);

        // Enviar evento para o Kafka
        orderProducer.sendMessage(orderEvent);

        // Retornar resposta estruturada
        return ResponseEntity.ok("Order placed successfully with ID: " + order.getOrderId());
    }
}
