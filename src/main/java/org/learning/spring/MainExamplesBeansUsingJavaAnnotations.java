package org.learning.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainExamplesBeansUsingJavaAnnotations {

    public static void main(String[] args) {
        //MainExamplesBeansUsingJavaAnnotations.creatingBeansByAnnotations();
        MainExamplesBeansUsingJavaAnnotations.creatingBeanPreparedWithInformation();
    }

    public static void creatingBeansByAnnotations() {

        // ApplicationContext appContext = new AnnotationConfigApplicationContext(PersonBeanConfig.class);
        // AnnotationConfigApplicationContext have the .close() method that Invoke the init and destroy bean methods
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(PersonBeanConfig.class);

        //Person myFirstPersonBean = appContext.getBean(Person.class);
        Person myFirstPersonBean = appContext.getBean("myFirstBeanPerson", Person.class);

        myFirstPersonBean.setName("Armando");
        myFirstPersonBean.setLastName("Perez Espinoza");
        myFirstPersonBean.setProfession("Professional Design");
        myFirstPersonBean.setAge(39);

        Person mySecondPerson = appContext.getBean("mySecondBeanPerson", Person.class);

        System.out.println("My First Person Bean: " + myFirstPersonBean + "\n");
        System.out.println("My Second Person Bean" + mySecondPerson);

        appContext.close();
    }

    public static void creatingBeanPreparedWithInformation() {

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(PersonBeanConfig.class);
        Person person = appContext.getBean("anotherBeanObject", Person.class);

        System.out.println("Another Bean Object: " + person);
        appContext.close();
    }

}
