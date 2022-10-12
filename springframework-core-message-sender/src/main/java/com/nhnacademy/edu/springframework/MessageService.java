package com.nhnacademy.edu.springframework;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MessageService {
    private List<MessageSender> messageSenders;

    public MessageService(){}

    @Autowired
    public MessageService(List<MessageSender> messageSenders){
        this.messageSenders = messageSenders;
    }

    public void doSendMessage(User user, String message){
        messageSenders.forEach(m -> m.sendMessage(user, message));

    }
}
