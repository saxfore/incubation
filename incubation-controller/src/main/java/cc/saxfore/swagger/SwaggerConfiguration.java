package cc.saxfore.swagger;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 项目名称：incubation
 * 类 名 称：SwaggerConfiguration
 * 创建时间：2019/8/12 5:21 PM
 * 创 建 人：wangjiang
 *
 * @Api：修饰整个类，描述Controller的作用
 * @ApiOperation：描述一个类的一个方法，或者说一个接口
 * @ApiParam：单个参数描述
 * @ApiModel：用对象来接收参数
 * @ApiProperty：用对象接收参数时，描述对象的一个字段
 * @ApiResponse：HTTP响应其中1个描述
 * @ApiResponses：HTTP响应整体描述
 * @ApiIgnore：使用该注解忽略这个API
 * @ApiError ：发生错误返回的信息
 * @ApiImplicitParam：一个请求参数
 * @ApiImplicitParams：多个请求参数
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Value("${swagger.enable}")
    private boolean swaggerEnable;
    @Value("${swagger.apis.basePackage}")
    private String swaggerBasePackage;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerEnable)
                .apiInfo(apiInfo())
                .select()
                .apis(basePackage(swaggerBasePackage))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("api文档")
                .description("restful 风格接口")
                .termsOfServiceUrl("")
                .version("1.0")
                //.contact(new Contact("hello", "url", "email"))
                .build();
    }

    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
        return input -> {
            for (String strPackage : basePackage.split(";")) {
                return input.getPackage().getName().startsWith(strPackage);
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }

}