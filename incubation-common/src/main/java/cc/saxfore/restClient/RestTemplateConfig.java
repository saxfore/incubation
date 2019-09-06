package cc.saxfore.restClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 项目名称：incubation
 * 类 名 称：RestTemplateConfig
 * 类 描 述：TODO
 * 创建时间：2019/9/6 11:29 AM
 * 创 建 人：wangjiang
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
//        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        httpRequestFactory.setConnectionRequestTimeout(8000);
//        httpRequestFactory.setConnectTimeout(8000);
//        httpRequestFactory.setReadTimeout(8000);

        SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
        httpRequestFactory.setConnectTimeout(8000);
        httpRequestFactory.setReadTimeout(8000);
        return new RestTemplate(httpRequestFactory);
    }
}
