package com.wuyinai.wuyipicturebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.wuyinai.wuyipicturebackend.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)//通过SPringAOP提供对当前代理对象的访问。
public class WuyiPictureBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WuyiPictureBackendApplication.class, args);
    }

}
