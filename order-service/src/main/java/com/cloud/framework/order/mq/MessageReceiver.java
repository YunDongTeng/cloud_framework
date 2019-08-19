package com.cloud.framework.order.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

@EnableBinding({Sink.class, Source.class})
public class MessageReceiver {


    private static Logger logger = LoggerFactory.getLogger(MessageReceiver.class);

    @StreamListener(Sink.INPUT)
    public void receive(Object obj){
        logger.info("message:"+obj);
    }
}
