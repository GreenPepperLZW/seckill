package com.lzw.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : lzw
 * @date : 2022/3/23
 * @since : 1.0
 */
@SpringBootApplication
@MapperScan("com.lzw.seckill.pojo")
public class SeckillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillApplication.class, args);
    }
}
