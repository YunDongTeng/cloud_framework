package com.cloud.framework.order.mq.sender;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SinkSender {

    String OUTPUT = "input";

    @Output(SinkSender.OUTPUT)
    MessageChannel output();

}
