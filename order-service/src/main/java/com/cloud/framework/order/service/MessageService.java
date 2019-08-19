package com.cloud.framework.order.service;

import com.cloud.framework.order.mq.sender.SinkSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(value = {SinkSender.class})
public class MessageService{

    @Autowired
    private SinkSender sender;

    public void sendMessage(String message) {
        sender.output().send(MessageBuilder.withPayload("Message:"+message).build());
    }
}
