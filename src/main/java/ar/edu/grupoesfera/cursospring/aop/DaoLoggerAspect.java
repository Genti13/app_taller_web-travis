package ar.edu.grupoesfera.cursospring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class DaoLoggerAspect {

    @Before("execution(* ar.edu.grupoesfera.cursospring.dao.*.*(..))")
    public void before() {
        System.out.println("Antes de la ejecucion");
    }

    @AfterReturning(
            pointcut = "execution(* ar.edu.grupoesfera.cursospring.dao.*.*(..))",
            returning = "result")
    public void after(JoinPoint joinPoint, Object result) {
        System.out.println("Despues de la ejecucion");
        System.out.println("se ejecuto : " + joinPoint.getSignature().getName());
        System.out.println("y el valor de retorno fue : " + result);
    }

    @AfterThrowing(
            pointcut = "execution(* ar.edu.grupoesfera.cursospring.dao.*.*(..))",
            throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

        System.out.println("ocurrio un error!");
        System.out.println("se ejecuto  : " + joinPoint.getSignature().getName());
        System.out.println("Y el error fue : " + error);
    }

    @Around("execution(* ar.edu.grupoesfera.cursospring.dao.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Ejecutando el around!");
        System.out.println("metodo : " + joinPoint.getSignature().getName());
        System.out.println("argumentos : " + Arrays.toString(joinPoint.getArgs()));

        System.out.println("around before");
        Object returnValue = joinPoint.proceed();
        System.out.println("around after!");
        return returnValue;
    }
}
