package com.nhnacademy.edu.springframework;

import org.springframework.beans.factory.annotation.Autowired;

public class SmsMessageSender implements MessageSender{
    @Autowired
    public SmsMessageSender(){
        System.out.println("+ SmsMessageSender is created");
    }

    public void init(){
        System.out.println("init method called in SmsMessageSender");
    }
    @Override
    public boolean sendMessage(User user, String message) {
        System.out.println("SMS Message Sent to " + user.getPhoneNumber() + " : " + message);

        return true;
    }
}
