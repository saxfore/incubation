package cc.saxfore.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 项目名称：incubation
 * 类 名 称：IBRequestListener
 * 类 描 述：TODO
 * 创建时间：2019/8/11 11:27 AM
 * 创 建 人：wangjiang
 */

@WebListener
public class IBSessionListener implements HttpSessionListener {
    private static final Logger log = LoggerFactory.getLogger(IBSessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("IBSessionListener sessionCreated ...");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("IBSessionListener sessionDestroyed ...");
    }
}
