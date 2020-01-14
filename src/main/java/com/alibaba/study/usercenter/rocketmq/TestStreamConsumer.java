package com.alibaba.study.usercenter.rocketmq;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

/**
 * @Author: wjy
 * @Date: 2020/1/14 23:46
 */
@Service
public class TestStreamConsumer {

    @StreamListener(Sink.INPUT)
    public void receive(String messageBody) {
        System.out.println(messageBody);
    }
}
