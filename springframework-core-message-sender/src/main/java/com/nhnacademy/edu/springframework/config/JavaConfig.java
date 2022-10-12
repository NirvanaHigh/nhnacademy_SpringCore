package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.EmailMessageSender;
import com.nhnacademy.edu.springframework.MessageSendService;
import com.nhnacademy.edu.springframework.MessageSender;
import com.nhnacademy.edu.springframework.SmsMessageSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    public MessageSender smsMessageSender(){
        return new SmsMessageSender();
    }

    @Bean
    public MessageSender emailMessageSender(){
        return new EmailMessageSender();
    }

    @Bean
    public MessageSendService messageSendService(){
        return new MessageSendService(smsMessageSender(), "kim");
    }
}
