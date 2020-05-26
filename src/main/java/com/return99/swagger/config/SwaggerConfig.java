package com.return99.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.service.ApiInfo.DEFAULT_CONTACT;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

    // 配置了Swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment) {

        // 这是要显示的Swagger环境
        Profiles profiles = Profiles.of("dev","test");

        // 获取项目的环境：
        boolean flag = environment.acceptsProfiles(profiles);
        System.out.println(flag);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("return996")
                .enable(true)
                .select()
                // RequestHandlerSelectors 配置要扫描的接口方式
                // basePackage:指定要扫描的包
                // any():扫描全部
                // none():不扫描
                // withClassAnnotation: 扫描类上的注解,参数是一个注解的反射对象
                // withMethodAnnotation: 扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.return99.swagger.controller"))
                // paths() 过滤什么路径
                //.paths(PathSelectors.ant("/return99/**"))
                .build();
    }

    // 配置Swagger信息=apiInfo
    private ApiInfo apiInfo() {

        Contact contact = new Contact("return996", "https://www.bytedance.com/zh", "2208604865@qq.com");

        return new ApiInfo(
                "return996的SwaggerAPI文档",
                "即使再小的帆也能远航",
                "1.0",
                "https://www.baidu.com",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
