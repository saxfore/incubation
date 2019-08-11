package cc.saxfore.incubation.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * 项目名称：incubation
 * 类 名 称：IBRequestListener
 * 类 描 述：TODO
 * 创建时间：2019/8/11 11:27 AM
 * 创 建 人：wangjiang
 */

@WebListener
public class IBRequestListener implements ServletRequestListener {
    private static final Logger log = LoggerFactory.getLogger(IBRequestListener.class);

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("IBRequestListener requestInitialized ...");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("IBRequestListener requestDestroyed ...");
    }
}
