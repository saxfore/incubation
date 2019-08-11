package cc.saxfore.incubation.convert;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 项目名称：incubation
 * 类 名 称：HttpStringConverter
 * 类 描 述：TODO
 * 创建时间：2019/8/11 4:46 PM
 * 创 建 人：wangjiang
 */
@Configuration
public class HttpStringConverter implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        converters.add(stringHttpMessageConverter);
    }
}
