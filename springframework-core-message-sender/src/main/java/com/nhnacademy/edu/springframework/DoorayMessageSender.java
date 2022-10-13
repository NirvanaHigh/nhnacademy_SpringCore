package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class DoorayMessageSender implements MessageSender{
    private String url = "https://hook.dooray.com/services/3036349505739914786/3371740733259172017/cdnzcggTTWmx2GtusEMUJw";

    @Autowired
    public DoorayMessageSender(){}

    @Override
    public boolean sendMessage(User user, String message) {
        new DoorayHookSender(new RestTemplate(), this.url)
                .send(DoorayHook.builder()
                        .botName(user.getEmail())
                        .text(message)
                        .build());

        return true;
    }
}
