package com.example.demo.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableSwaggerBootstrapUI
@Configuration
public class Swagger2Config {

    @Bean(value = "ApiSwagger")
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("分组名称模块")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))//分组api所属位置
                .paths(PathSelectors.any())
                .build().enable(true);
    }
//    @Bean(value = "validationApiSwagger2")
//    public Docket validationApiSwagger2() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .groupName("Validation模块2")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))//分组api所属位置
//                .paths(PathSelectors.any())
//                .build().enable(true);
//    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .version("1.0")
                .build();
    }
}
