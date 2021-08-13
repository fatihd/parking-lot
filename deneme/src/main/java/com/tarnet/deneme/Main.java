package com.tarnet.deneme;

import com.tarnet.domain.ZzzMaster;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "context.xml",
                "hibernate-config.xml");

        Greeter greeter = applicationContext.getBean(Greeter.class);
        Excluded excluded = applicationContext.getBean(Excluded.class);

        greeter.greet();

        MasterRepository repository = applicationContext.getBean(MasterRepository.class);

//        repository.insert();

//        repository.update();

//        repository.delete();

//        repository.list();
//        repository.showOne();

    }
}