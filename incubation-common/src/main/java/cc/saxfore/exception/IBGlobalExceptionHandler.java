package cc.saxfore.exception;

import cc.saxfore.utils.IBRespResult;
import cc.saxfore.model.IBResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 项目名称：incubation
 * 类 名 称：GlobalExceptionHandler
 * 创建时间：2019/8/11 12:10 PM
 * 创 建 人：wangjiang
 * 类 描 述：@RestControllerAdvice只返回数据；@ControllerAdvice可返回视图
 */
@ControllerAdvice
public class IBGlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(IBGlobalExceptionHandler.class);

    /**
     * 处理controller层抛出的异常
     * 类注解使用@RestControllerAdvice则方法上可省略@ResponseBody
     *
     * @param request
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public IBResponse dohandler(HttpServletRequest request, Exception e) {
        String reqUrl = request.getRequestURI();
        log.info("----请求异常:{}, 信息：{} ----", reqUrl, e.getMessage());
        log.error("异常信息:", e);
        return IBRespResult.error(e.getMessage());
    }

}
