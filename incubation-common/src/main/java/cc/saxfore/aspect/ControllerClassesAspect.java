package cc.saxfore.aspect;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 项目名称：incubation
 * 类 名 称：ApiAspect
 * 类 描 述：TODO
 * 创建时间：2019/8/11 6:24 PM
 * 创 建 人：wangjiang
 */
@Aspect
@Component
public class ControllerClassesAspect {
    private static final Logger log = LoggerFactory.getLogger(ControllerClassesAspect.class);

    @Pointcut("execution(* cc.saxfore.incubation.cc.saxfore.controller..*.*(..))")
    public void controllerClasses() {

    }

    /**
     * 进入方法之前
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("controllerClasses()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        log.info("ControllerClassesAspect doBefore ...");

        String clazzName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        String reqArgs = Arrays.toString(joinPoint.getArgs());

        log.info("ControllerClassesAspect doBefore 调用方法: {}.{}", clazzName, methodName);
        log.info("ControllerClassesAspect doBefore 请求参数: {}", reqArgs);
    }

    /**
     * 返回结果之前
     *
     * @param obj
     * @throws Throwable
     */
    @AfterReturning(returning = "obj", pointcut = "controllerClasses()")
    public void doAfterReturning(JoinPoint joinPoint, Object obj) throws Throwable {
        log.info("ControllerClassesAspect doAfterReturning ...");

        String clazzName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        String reqArgs = Arrays.toString(joinPoint.getArgs());
        String returnResult = new Gson().toJson(obj);

        log.info("ControllerClassesAspect doAfterReturning 调用方法: {}.{}", clazzName, methodName);
        log.info("ControllerClassesAspect doAfterReturning 返回结果: {}", returnResult);
    }

    /**
     * 调用异常
     *
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(value = "controllerClasses()", throwing = "exception")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        log.info("ControllerClassesAspect doAfterThrowing ...");

        String clazzName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        String reqArgs = Arrays.toString(joinPoint.getArgs());

        log.info("ControllerClassesAspect doAfterThrowing 调用方法: {}.{} 发生异常...", clazzName, methodName);
    }

    /**
     * 环绕通知
     *
     * @param proceedingJoinPoint
     * @return
     */
    @Around(value = "controllerClasses()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("ControllerClassesAspect doAroundAdvice ...");

        String clazzName = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        log.info("ControllerClassesAspect doAroundAdvice 环绕通知的目标方法: {}.{}", clazzName, methodName);

        try {
            Object obj = proceedingJoinPoint.proceed();
            log.info("ControllerClassesAspect doAroundAdvice 环绕通知返回：{}", new Gson().toJson(obj));
            return obj;

        } catch (Throwable throwable) {

            throwable.printStackTrace();
        }

        return null;
    }

}
