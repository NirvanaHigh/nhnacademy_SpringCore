package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
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
    public MessageSender doorayMessageSender(){
        return new DoorayMessageSender();
    }

    @Bean
    public MessageSendService messageSendService(){
        return new MessageSendService(doorayMessageSender(), "kim");
    }
}
