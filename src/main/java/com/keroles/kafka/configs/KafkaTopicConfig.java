package com.keroles.kafka.configs;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic newTopic() {
        return TopicBuilder.name("orders")
                .build();
    }

    @Bean
    public NewTopic anotherTopic() {
        return TopicBuilder.name("anotherTopic")
                .build();
    }
}
