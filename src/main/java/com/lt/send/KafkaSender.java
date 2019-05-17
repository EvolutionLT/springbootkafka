package com.lt.send;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lt.bean.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author evolution
 * @title: KafkaSender
 * @projectName springbootkafka
 * @description: TODO 消息生产者
 * @date 2019-05-16 12:53
 */
@Component
@Slf4j
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();


    //发送消息的方法
    public void  send(){
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("+++++++++++++++++++++  message = {}", gson.toJson(message));
        //topic 不需要创建  自动会创建
        kafkaTemplate.send("test1", gson.toJson(message));
    }

}
