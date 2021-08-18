package com.tarnet.deneme;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "context.xml",
                "hibernate-config.xml");

        UserRepository userRepository = applicationContext.getBean(UserRepository.class);

        userRepository.insert();

        //userRepository.delete();

        //userRepository.list();
    }
}