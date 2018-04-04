package com.enva;

import com.enva.aspects.service.UserService;
import com.enva.config.JavaConfig;
import com.enva.model.UserModel;
import com.enva.service.SpringUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(final String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);

        SpringUserService springUserService = applicationContext.getBean(SpringUserService.class);

        UserModel user1 = new UserModel("user1", "user1@user.com", "123456");
        UserModel user2 = new UserModel("user1", "user1@user.com", "123456");
        UserModel user3 = new UserModel("user1", "user1@user.com", "123456");


        LOGGER.info("{}", springUserService.saveUser(user1));
        LOGGER.info("{}", springUserService.saveUser(user2));
        LOGGER.info("{}", springUserService.saveUser(user3));

        ((UserService) springUserService).deleteUser(user1);


        LOGGER.info("All users \n {}", springUserService.listAllUsers());
    }
}
