package ru.talykov.spring.aspects;

import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Slf4j
@Aspect
@Component
public class AllureAspects {

    @Pointcut("execution(public * ru.talykov.spring.testservice.api.rest.TestServiceApi..*(..))")
    private void allRestMethods(){}

    @Around("allRestMethods()")
    public Object attachRestRequestAndResponse(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        proceedingJoinPoint.getSignature();

        Allure.addAttachment("REST request: ", "text/plain", Arrays.toString(proceedingJoinPoint.getArgs()));

        var result = proceedingJoinPoint.proceed();

        Allure.addAttachment("REST response: ", "text/plain", result.toString());

        return result;
    }
}
