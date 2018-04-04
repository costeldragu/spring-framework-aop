package com.enva.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitorAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(MonitorAspect.class);

    @Pointcut("execution(* *(..))")
    public void anyPublicOperation() {
    }

    @Pointcut("execution(* com.enva.service.*Service.*(..))")
    public void anyPublicServiceOperation() {
    }

    @Pointcut("execution(* com.enva.service.*Repository.*(..))")
    public void anyPublicRepositoryOperation() {
    }


    @Before("anyPublicOperation()")
    public void beforeAnyPublicOperation(final JoinPoint joinPoint) {
        // LOGGER.info("beforeAnyPublicOperation executed on {}", joinPoint.getSignature().getName());
    }

    @After("anyPublicOperation()")
    public void afterAnyPublicOperation(final JoinPoint joinPoint) {
        //  LOGGER.info("afterAnyPublicOperation executed {}", joinPoint.getSignature().getName());
    }

    @Before("anyPublicServiceOperation()")
    public void beforePublicServiceOperation(final JoinPoint joinPoint) {
//        LOGGER.info("BeforeAnyPublicServiceOperation executed {}", joinPoint.getSignature().getName());
    }

    @After("anyPublicServiceOperation()")
    public void afterPublicServiceOperation(final JoinPoint joinPoint) {
        //      LOGGER.info("AfterAnyPublicServiceOperation executed {}", joinPoint.getSignature().getName());
    }

    @Around("anyPublicServiceOperation()")
    public Object aroundPublicServiceOperation(final ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("aroundPublicServiceOperation executed {}", joinPoint.getSignature().getName());
//        return new UserModel("hackUser", "hackUsser@email.com", "21234565"); //null; //
        return joinPoint.proceed();
    }

    @AfterThrowing(pointcut = "anyPublicOperation()", throwing = "error")
    public void recoverAfterThisException(final Throwable error) {
        LOGGER.info("recoverAfterThisException executed {}", error);
    }
}
