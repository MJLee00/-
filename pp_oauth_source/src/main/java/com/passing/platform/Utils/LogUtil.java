package com.passing.platform.Utils;

import com.passing.platform.Utils.Annotations.OperatorLogAnnotation;
import com.passing.platform.domain.Log;
import com.passing.platform.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class LogUtil {

    @Autowired
    private LogService logService;
//    @Pointcut("execution(* com.passing.com.passing.com.passing.platform.service.impl.*.*(..))")
    @Pointcut("@annotation(com.passing.platform.Utils.Annotations.OperatorLogAnnotation)")
    private  void pointcut1(){}

    //使用pointcut1提取出公共方法，并且在声明了annotation的方法上创建动态代理对象
    @AfterReturning("pointcut1()")
    public  void printLog(final JoinPoint joinPoint)throws Throwable{

        MethodSignature signature=(MethodSignature)joinPoint.getSignature();
        OperatorLogAnnotation operatorLogAnnotation=(OperatorLogAnnotation)signature.getMethod().getAnnotation(OperatorLogAnnotation.class);
        Log log=new Log();
        if(operatorLogAnnotation!=null){
            System.out.print("打印日志:detail="+operatorLogAnnotation.detail()+"level="+operatorLogAnnotation.level());
            log.setDetail(operatorLogAnnotation.detail());
            log.setLevel(operatorLogAnnotation.level());
        }

        log.setCreatetime(new Date());


        logService.insert(log);
    }
}
