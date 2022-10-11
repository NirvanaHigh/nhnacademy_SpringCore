package com.nhnacademy.edu.springframework;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main{
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = new User("b@b.com", "010");

        context.getBean("messageSendService", MessageSendService.class).doSendMessage(user, "this is message");
//        System.out.println("----------");
//        context.getBean("emailMessageSender", MessageSender.class).sendMessage(user,"this is message");
//        context.getBean("emailMessageSender", MessageSender.class).sendMessage(user,"this is message");
//        System.out.println("----------");
//        context.getBean("smsMessageSender", MessageSender.class).sendMessage(user,"this is message");
//        context.getBean("smsMessageSender", MessageSender.class).sendMessage(user,"this is message");
//        System.out.println("----------");
//
        context.close();
    }
}
