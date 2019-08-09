package cc.saxfore.incubation.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 项目名称：incubation
 * 类 名 称：InterceptorConfiguration
 * 创建时间：2019/8/9 5:17 PM
 * 创 建 人：wangjiang
 * 类 描 述：springboot1.x: InterceptorConfiguration extends WebMvcConfigurerAdapter
 * 类 描 述：springboot2.x: InterceptorConfiguration implements WebMvcConfigurer
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;
    @Autowired
    ApiInterceptor apiInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/incubation/user/*");
        registry.addInterceptor(apiInterceptor).addPathPatterns("/incubation/api/*");
    }
}
