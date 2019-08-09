package cc.saxfore.incubation.interceptor;

import cc.saxfore.incubation.common.IBRespResult;
import cc.saxfore.incubation.common.IBServletRespResult;
import cc.saxfore.incubation.common.IBStringUtil;
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

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String accessToken = request.getParameter("accessToken");

        // 没有登录
        boolean isLogin = (IBStringUtil.isNotBlank(username) && IBStringUtil.isNotBlank(password)) || IBStringUtil.isNotBlank(accessToken);
        if (!isLogin) {
            IBServletRespResult.success(response, IBRespResult.fail("请先登录！"));
        }

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

}
