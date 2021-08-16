package com.tarnet.deneme;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "context.xml",
                "hibernate-config.xml");

        UsersRepository usersRepository = applicationContext.getBean(UsersRepository.class);

        usersRepository.insert();

        //usersRepository.delete();

        //usersRepository.list();
    }
}