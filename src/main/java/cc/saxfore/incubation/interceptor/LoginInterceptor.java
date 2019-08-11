package cc.saxfore.incubation.interceptor;

import cc.saxfore.incubation.common.IBRespResult;
import cc.saxfore.incubation.common.IBStringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 项目名称：incubation
 * 类 名 称：LoginInterceptor
 * 类 描 述：TODO
 * 创建时间：2019/8/9 5:23 PM
 * 创 建 人：wangjiang
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
    private static final String specialToken = "incubation";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("LoginInterceptor preHandle ...");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String accessToken = request.getParameter("accessToken");

        // 没有登录
        boolean isLogin = (IBStringUtil.isNotBlank(username) && IBStringUtil.isNotBlank(password)) || specialToken.equals(accessToken);
        if (!isLogin) {
            IBRespResult.fail(response, "请先登录！");
        }

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("LoginInterceptor postHandle ...");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("LoginInterceptor afterCompletion ...");
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("LoginInterceptor afterConcurrentHandlingStarted ...");
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

}
