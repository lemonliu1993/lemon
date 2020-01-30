package com.lemon.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * Created by lemoon on 20/1/30 上午9:54
 */
//切面类
@Aspect
public class LogAspects {

    //抽取公共的切入点表达式
    //1.本类引用
    //2.其他的切面引用
    @Pointcut("execution(public int com.lemon.aop.MathCalculator.*(..))")
    public void pointCut(){

    }


    //@Before在目标方法之前切入：切入点表达式(指定在哪个方法切入)
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
//        System.out.println("除法运行...参数列表是:{}");
        Object[] args = joinPoint.getArgs();
        System.out.println(""+joinPoint.getSignature().getName()+"运行...@Before：参数列表是:{"+ Arrays.asList(args)+"}");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(""+joinPoint.getSignature().getName()+"结束...");
    }

    //*** JoinPoint 这个参数必须放在参数的第一位，否则Spring也无法识别
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(""+joinPoint.getSignature().getName()+"正常返回...运行结果是:{"+result+"}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void logException(JoinPoint joinPoint,Exception e){
        System.out.println(""+joinPoint.getSignature().getName()+"异常...异常信息:{"+e+"}");
    }
}
