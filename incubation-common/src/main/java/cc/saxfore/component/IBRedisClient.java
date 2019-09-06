package cc.saxfore.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 项目名称：incubation
 * 类 名 称：IBRedisUtil
 * 类 描 述：TODO
 * 创建时间：2019/9/6 10:32 AM
 * 创 建 人：wangjiang
 */
@Component
public class IBRedisClient {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void set(String key, String field, Object value) {
        redisTemplate.opsForHash().put(key, field, value);
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public Object get(String key, String field) {
        return redisTemplate.opsForHash().get(key, field);
    }

}
