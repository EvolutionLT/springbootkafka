package com.lt.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author evolution
 * @title: Message
 * @projectName springbootkafka
 * @description: TODO
 * @date 2019-05-16 12:52
 * @ltd：思为
 */
@Data
public class Message {
    private Long id;    //id

    private String msg; //消息

    private Date sendTime;  //时间戳
}
