package com.nhnacademy.edu.springframework;


import org.springframework.beans.factory.annotation.Autowired;

public class EmailMessageSender implements MessageSender {
    @Autowired
    public EmailMessageSender(){
        System.out.println("+ EmailMessageSender is created");
    }
    public void destroy(){
        System.out.println("destroy method called EmailMessageSender");
    }
    @Override
    public boolean sendMessage(User user, String message) {
        System.out.println("Email Message Sent to " + user.getEmail() + " : " + message);

        return true;
    }
}
