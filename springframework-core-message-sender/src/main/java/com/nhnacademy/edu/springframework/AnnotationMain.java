package com.nhnacademy.edu.springframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework.config");
        // 여러 config class를 사용하는 경우 context 파라미터에 class 하나를 주는 것이 아니라 패키지로 줘야함

        MessageSendService messageSendService =
                MessageSendService.class.cast(context.getBean("messageSendService"));

        User user = new User("b@b.com", "010");
        messageSendService.doSendMessage(user, "this is message");
        context.getBean("messageSendService", MessageSendService.class).doSendMessage(user, "this is message");
    }
}
