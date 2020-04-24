package com.spring.kafka.consumer.controller;

import com.spring.kafka.consumer.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@EnableKafka
@RestController
public class ConsumerController {

    Logger logger = LoggerFactory.getLogger(ConsumerController.class);
    public static final String TOPIC = "DATA";

    @KafkaListener(topics = TOPIC, groupId = "consumer-group", containerFactory = "concurrentKafkaListenerContainerFactory")
    public void recieveMessage(String employee)
    {
        logger.info("Consumed message "+ String.valueOf(employee));
    }

}
