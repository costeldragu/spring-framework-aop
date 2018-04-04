package com.enva.aspects;

import com.enva.aspects.service.UserService;
import com.enva.aspects.service.impl.DefaultUserServiceImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class IntroductionAspect {

    @DeclareParents(value = "com.enva.service.*+", defaultImpl = DefaultUserServiceImpl.class)
    public static UserService userService;
}
