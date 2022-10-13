package com.nhnacademy.edu.springframework;


import com.nhnacademy.edu.springframework.annotation.SMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageSendService {
    private MessageSender messageSender;
    private String name;

    public MessageSendService(){}
    @Autowired
    public MessageSendService(@SMS("smsMessageSender") MessageSender messageSender,
                            @Value("${sms.from}") String name){
        this.messageSender = messageSender;
        this.name = name;
    }

    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public boolean doSendMessage(User user, String message){
    //    System.out.println("from " + this.name);
        messageSender.sendMessage(user, message);

        return true;
    }
}
