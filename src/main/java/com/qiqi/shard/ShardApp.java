package com.qiqi.shard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 启动类
 *
 * @author zhongqichun
 * @since 2021/10/15
 */
@RestController
@SpringBootApplication
public class ShardApp {
    @Resource
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(ShardApp.class, args);
    }

    @GetMapping("/ctx")
    String ctx() {
        return applicationContext.getApplicationName();
    }
}
