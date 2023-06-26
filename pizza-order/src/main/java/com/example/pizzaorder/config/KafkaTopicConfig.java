package com.example.pizzaorder.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("topic-1").build();
    }

    @Bean
    public NewTopic dlqTopic() {
        return TopicBuilder.name("dlq-topic").build();
    }
}
