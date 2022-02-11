package com.ztxue.admin;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author ztxue
 */
@SpringBootApplication
@EnableWebMvc
@EnableCaching
@EnableAsync
@EnableTransactionManagement
@MapperScan({"com.ztxue.admin.mapper"})
@EnableDiscoveryClient
@EnableFeignClients
public class AdminWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminWebApplication.class, args);
        System.out.println("=============服务启动完成->8000=============");
    }

}
