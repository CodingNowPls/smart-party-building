package com.ruoyi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 启动程序
 *
 * @author ruoyi
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RuoYiApplication {

    @Value("${server.port}")
    private Long serverPort;

    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        // 打印端口
        ConfigurableApplicationContext context = SpringApplication.run(RuoYiApplication.class, args);
        RuoYiApplication application = context.getBean(RuoYiApplication.class);
        // 打印端口
        System.out.println("http://localhost:" + application.serverPort);
    }
}