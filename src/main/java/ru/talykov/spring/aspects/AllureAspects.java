package ru.talykov.spring.aspects;

import com.google.gson.Gson;
import io.qameta.allure.Allure;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AllureAspects {

  Gson gson = new Gson();

  @Pointcut("execution(public * ru.talykov.spring.testservice.api.rest.api.TestServiceApi..*(..))")
  private void allRestMethods() {}

  @Around("allRestMethods()")
  public Object attachRestRequestAndResponse(ProceedingJoinPoint proceedingJoinPoint)
      throws Throwable {
    proceedingJoinPoint.getSignature();

    Allure.addAttachment(
        "Request", "text/json", gson.toJson(Arrays.toString(proceedingJoinPoint.getArgs())));

    var result = proceedingJoinPoint.proceed();

    Allure.addAttachment("Response", "text/json", gson.toJson(result));

    return result;
  }
}
