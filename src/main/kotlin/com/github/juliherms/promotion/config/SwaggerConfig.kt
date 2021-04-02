package com.github.juliherms.promotion.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * This class responsible to configure Swagger
 */
@Configuration
@EnableSwagger2
class SwaggerConfig {

    /**
     * Method responsible to configure and setup operations in swagger
     */
    @Bean
    fun promotionApi() =
         Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.juliherms.promotion"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData())


    /**
     * Method responsible to return API information
     */
    private fun metaData() =
         ApiInfoBuilder()
                .title("API Promotions")
                .description("API responsible to manage promotions")
                .version("1.0.0")
                .build()

}