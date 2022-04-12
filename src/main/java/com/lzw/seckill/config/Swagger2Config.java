package com.lzw.seckill.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 指定扫描的包路径来定义指定要建立API的目录。
     * @return
     */
    @Bean
    public Docket coreApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(adminApiInfo())
                .groupName("seckillApi")
                .select()
                .apis(RequestHandlerSelectors.any())
                //只显示admin下面的路径
//                .paths(Predicates.and(PathSelectors.regex("/seckill/.*")))
                .build();
    }

    private ApiInfo adminApiInfo(){
        return new ApiInfoBuilder()
                .title("秒杀案例--api文档")
                .description("秒杀案例学习接口描述")
                .version("1.0")
                .contact(new Contact("lzw","http://www.lizuowei.com",""))
                .build();
    }

    /**
     * 基本使用说明
     * 访问路径；http://ip:port/swagger-ui.html
     *
     * @Api：用在类上，说明该类的作用。
     * @ApiOperation：注解来给API增加方法说明。
     * @ApiParam：定义在参数上
     * @ApiResponses：用于表示一组响应
     * @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
     *  code：数字，例如400
     *  message：信息，例如"请求参数没填好"
     *  response：抛出异常的类
     *
     * @ApiModel：描述一个Model的信息（一般用在请求参数无法使用@ApiImplicitParam注解进行描述的时候）
     *
     * @ApiModelProperty：描述一个model的属性
     *
     * @ApiImplicitParams: 用在方法上包含一组参数说明。
     *
     * @ApiImplicitParam：用来注解来给方法入参增加说明。
     * ————————————————
     */
}
