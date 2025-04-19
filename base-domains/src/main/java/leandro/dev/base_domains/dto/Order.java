package leandro.dev.base_domains.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    @JsonProperty("order_id")
    private String orderId;

    @NotBlank(message = "O nome do item não pode estar em branco.")
    @JsonProperty("name")
    private String name;

    @PositiveOrZero(message = "A quantidade deve ser zero ou positiva.")
    @JsonProperty("qty")
    private int qty;

    @NotNull(message = "O preço não pode ser nulo.")
    @PositiveOrZero(message = "O preço deve ser zero ou positivo.")
    @JsonProperty("price")
    private BigDecimal price;
}
