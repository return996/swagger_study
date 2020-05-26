package com.return99.swagger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwaggerDemoApplication {

    private static final Logger log = LoggerFactory.getLogger( SwaggerDemoApplication.class );

    public static void main(String[] args) {

        log.info("=============== INFO信息提示 ===============");
        log.info("=============== INFO信息提示 ===============");
        log.info("=============== INFO信息提示 ===============");
        log.info("=============== INFO信息提示 ===============");
        log.info("=============== INFO信息提示 ===============");

        log.warn("=============== WARN信息提示 ===============");
        log.warn("=============== WARN信息提示 ===============");
        log.warn("=============== WARN信息提示 ===============");
        log.warn("=============== WARN信息提示 ===============");
        log.warn("=============== WARN信息提示 ===============");

        SpringApplication.run(SwaggerDemoApplication.class, args);
    }

}
