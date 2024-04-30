package org.learning.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainExamplesBeansUsingJavaAnnotations {

    public static void main(String[] args) {

        ApplicationContext appContext = new AnnotationConfigApplicationContext(PersonBeanConfig.class);
        //Person myFirstPersonBean = appContext.getBean(Person.class);
        Person myFirstPersonBean = appContext.getBean("myFirstBeanPerson", Person.class);

        myFirstPersonBean.setName("Armando");
        myFirstPersonBean.setLastName("Perez Espinoza");
        myFirstPersonBean.setProfession("Professional Design");
        myFirstPersonBean.setAge(39);

        Person mySecondPerson = appContext.getBean("mySecondBeanPerson", Person.class);

        System.out.println("My First Person Bean: " + myFirstPersonBean + "\n");
        System.out.println("My Second Person Bean" + mySecondPerson);

    }
}
