package com.keroles.kafka.controllers;

import com.keroles.kafka.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
    private final KafkaTemplate<String, OrderDto> kafkaTemplate;
    private final KafkaTemplate<String, String> kafkaStringTemplate;

    @GetMapping("/send")
    public String send() {
        OrderDto dto = new OrderDto();
        dto.setOrderId("random code " + Math.random());
        dto.setPrice(Math.random());
        CompletableFuture<SendResult<String, OrderDto>> result = kafkaTemplate.send("orders", dto);
        return "Hello World";
    }

    @GetMapping("/send-string")
    public String sendString() {

        CompletableFuture<SendResult<String, String>> result = kafkaStringTemplate.send("strings", "{this is message}");
        return "Hello World";
    }
}
