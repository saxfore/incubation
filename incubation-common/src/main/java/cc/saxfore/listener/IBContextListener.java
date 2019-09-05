package cc.saxfore.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 项目名称：incubation
 * 类 名 称：IBContextListener
 * 类 描 述：TODO
 * 创建时间：2019/8/11 11:41 AM
 * 创 建 人：wangjiang
 */
@WebListener
public class IBContextListener implements ServletContextListener {
    private static final Logger log = LoggerFactory.getLogger(IBContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("IBContextListener contextInitialized ...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("IBContextListener contextDestroyed ...");
    }

}
