package cc.saxfore.interceptor;

import cc.saxfore.annotation.IBApiURL;
import cc.saxfore.utils.IBRespResult;
import cc.saxfore.utils.IBStringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 项目名称：incubation
 * 类 名 称：ApiInterceptor
 * 类 描 述：TODO
 * 创建时间：2019/8/9 5:23 PM
 * 创 建 人：wangjiang
 */
@Component
public class ApiInterceptor extends HandlerInterceptorAdapter {
    private static final Logger log = LoggerFactory.getLogger(ApiInterceptor.class);
    private static final String specialToken = "incubation";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("ApiInterceptor preHandle ...");

        IBApiURL apiURL = null;
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            apiURL = method.getMethodAnnotation(IBApiURL.class);
        }

        if (apiURL != null) {
            String accessToken = request.getParameter("accessToken");
            if (IBStringUtil.isBlank(accessToken) || !specialToken.equalsIgnoreCase(accessToken)) {
                IBRespResult.fail(response, "您无权访问该地址！");
                return false;
            }
        }

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("ApiInterceptor postHandle ...");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("ApiInterceptor afterCompletion ...");
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("ApiInterceptor afterConcurrentHandlingStarted ...");
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

}
