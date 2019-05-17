package com.lt.custom;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author evolution
 * @title: KafkaReceiver
 * @projectName springbootkafka
 * @description: TODO
 * @date 2019-05-17 14:50
 */
@Component
@Slf4j
public class KafkaReceiver {


    @KafkaListener(topics = {"test1"})
    public void listen(ConsumerRecord<?, ?> record) {

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println("----------------- record =" + record);
            System.out.println("------------------ message =" + message);
        }

    }

}
