package com.keroles.kafka.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {
    private String orderId;
    private Double price;

    @Override
    public String toString() {
        return "{" +
                "\"orderId\":\"" + orderId + "\"," +
                "\"price\":" + price +
                "}";
    }
}
