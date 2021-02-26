package cn.bcsoft.demo1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * GameDataAspect
 * 环绕
 * @author blackchen @ 2020/12/3 16:22
 */
@Aspect
@Component
public class GameDataAspect {
    /**
     * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
     * 通过@Pointcut注解声明频繁使用的切点表达式
     */
    @Pointcut("execution(public * cn.bcsoft.demo1.controller.AOPController.durant(int)) && args(point))")
    public void gameDataAspect(int point){

    }

    /**
     * @description  使用环绕通知
     */
    @Around("gameDataAspect(point)")
    public void doAroundGameData(ProceedingJoinPoint pjp, int point) throws Throwable {
        try{
            System.out.println("球星上场前热身！--环绕");
            pjp.proceed();
            System.out.println("球星本场得到" + point + "分 --环绕" );
        } catch (Throwable e) {
            System.out.println("异常通知：球迷要求退票！--环绕");
        }
    }
}
