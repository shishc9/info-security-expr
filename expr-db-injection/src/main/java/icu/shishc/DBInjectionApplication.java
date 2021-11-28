package icu.shishc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: ShiShc
 * @desc:
 */
@SpringBootApplication
@MapperScan("icu.shishc.mapper")
public class DBInjectionApplication {
    public static void main(String[] args) {
        SpringApplication.run(DBInjectionApplication.class, args);
    }
}
