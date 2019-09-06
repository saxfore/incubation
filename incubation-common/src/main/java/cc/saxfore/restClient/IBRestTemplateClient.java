package cc.saxfore.restClient;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 项目名称：ikms
 * 类 名 称：RestTemplateClient
 * 类 描 述：TODO
 * 创建时间：2019/8/4 5:06 PM
 * 创 建 人：wangjiang
 */
@Component
public class IBRestTemplateClient {
    private static final Logger logger = LoggerFactory.getLogger(IBRestTemplateClient.class);

    @Autowired
    private RestTemplate restTemplate;

    public String httpGet(String reqUrl, Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        sb.append(reqUrl).append("?");
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        logger.info("--------- httpGet reqUrl:{}", reqUrl.toString());
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(sb.toString(), String.class);
        logger.info("--------- httpGet response: code={}, body={}", responseEntity.getStatusCode(), responseEntity.getBody());
        return responseEntity.getStatusCode() == HttpStatus.OK ? responseEntity.getBody() : "";
    }

    public String httpPost(String reqUrl, Map<String, Object> params) {
        JSONObject requestBody = new JSONObject(params);
        logger.info("--------- httpPost reqUrl:{}", reqUrl);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(reqUrl, (Object) requestBody, String.class);
        logger.info("--------- httpPost response: code={}, body={}", responseEntity.getStatusCode(), responseEntity.getBody());
        return responseEntity.getStatusCode() == HttpStatus.OK ? responseEntity.getBody() : "";
    }

    public String httpPost(String reqUrl, Map<String, Object> params, MediaType mediaType) {

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                map.add(entry.getKey(), entry.getValue());
            }
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);

        logger.info("--------- httpPost url:{}, request:{}", reqUrl, request);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(reqUrl, request, String.class);
        logger.info("--------- httpPost response: code={}, body={}", responseEntity.getStatusCode(), responseEntity.getBody());
        return responseEntity.getStatusCode() == HttpStatus.OK ? responseEntity.getBody() : "";
    }

    public String httpPostJson(String reqUrl, String params) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> request = new HttpEntity<String>(params, headers);

        logger.info("--------- httpPost url:{}, request:{}", reqUrl, request);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(reqUrl, request, String.class);
        logger.info("--------- httpPost response: code={}, body={}", responseEntity.getStatusCode(), responseEntity.getBody());
        return responseEntity.getStatusCode() == HttpStatus.OK ? responseEntity.getBody() : "";
    }

}
