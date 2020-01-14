package com.alibaba.study.usercenter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.alibaba.study")
@SpringBootTest
class UserCenterApplicationTests {

    @Test
    void contextLoads() {
    }

}
