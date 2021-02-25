package it.academy.main;

import it.academy.pojo.Person;
import it.academy.util.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        System.out.println(context.getBean(Person.class));

    }
}
