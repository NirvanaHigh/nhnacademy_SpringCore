package com.nhnacademy.edu.springframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework");
        // 여러 config class를 사용하는 경우 context 파라미터에 class 하나를 주는 것이 아니라 패키지로 줘야함
        // basePackages를 그냥 넓게 잡는게 낫다

        MessageSendService messageSendService = context.getBean(MessageSendService.class);

        User user = new User("김재용", "010");
        messageSendService.doSendMessage(user, "안녕하세요");

//       context.getBean("messageSendService", MessageSendService.class).doSendMessage(user, "this is message");


    }
}
