package com.cloud.framework.order.web;

import com.cloud.framework.order.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/message")
public class OrderMessageController {


    @Autowired
    public MessageService messageService;

    @RequestMapping("/send")
    public String send(@RequestParam("message")String message){
        messageService.sendMessage(message);
        return "success";
    }


}
