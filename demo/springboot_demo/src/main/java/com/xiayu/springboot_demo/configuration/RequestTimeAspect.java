package com.xiayu.springboot_demo.configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/10/28 16:01
 */

@Aspect
@Component
public class RequestTimeAspect {
    Logger logger = LoggerFactory.getLogger(getClass());

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private static final String sep = "|";
    private static final String reqLog = "reqLog";


    @Around("execution(* com.xiayu.*.controller.*Controller.*(..))")
    public Object method(final ProceedingJoinPoint pjp) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String url = request.getRequestURI();

        Date time = new Date();
        try {
            //前置通知

            //事件
            final Object object = pjp.proceed();
            return object;
        } catch (Exception e) {
            throw e;
        } finally {
            //后置通知
            //求出该方法的运行时间
            long useTime = System.currentTimeMillis() - time.getTime();
            //获取参数
            final Object[] args = pjp.getArgs();
            StringBuilder log = new StringBuilder();
           // log.append(dateFormat.format(time)).append(sep);
            log.append("url=").append(sep);
            log.append(url).append(sep);
            log.append(useTime).append(sep);
            log.append("args=");
            for(Object arg : args) {
                log.append(sep).append(arg);
            }
//            System.out.println(log.toString());
            logger.info(log.toString());
        }
    }
}
