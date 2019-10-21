package com.atguigu.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.atguigu.cache.mapper")
@SpringBootApplication
@EnableCaching
public class Spingboot01CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spingboot01CacheApplication.class, args);
    }

}
