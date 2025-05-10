package com.keroles.kafka;

import com.keroles.kafka.dto.OrderDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
//import com.keroles.kafka.configs.KafkaProducerConfig.OrderDto;

@Service
public class KafkaListeners {

//    @KafkaListener(topics = "orders", groupId = "group-id")
//    public void listen(OrderDto data) {
//        System.out.println("--------------------------------");
//        System.out.println("Received message: " + data.toString());
//        System.out.println("--------------------------------");
//    }

    @KafkaListener(topics = "orders")
    public void listenKarros(String data) {
        System.out.println("--------------------------------");
        System.out.println("Received message: " + data);
        System.out.println("--------------------------------");
    }

    @KafkaListener(topics = "strings")
    public void listenStrings(String data) {
        System.out.println("--------------------------------");
        System.out.println("Received message: " + data);
        System.out.println("--------------------------------");
    }
}
