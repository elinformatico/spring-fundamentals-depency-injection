package org.learning.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MainExamplesBeansUsingXMLConfigFiles {

    public static void main(String[] args) {

        //SpringMainClass.creatingBeanByBeanFactoryDeprecated();
        //MainExamplesBeansUsingXMLConfigFiles.creatingBeanByBeanFactory();
        //SpringMainClass.creatingBeanByApplicationContext();
        //SpringMainClass.exampleOneCreatingBean();
        //MainExamplesBeansUsingXMLConfigFiles.invokingInitDestroyBeanMethods();
        MainExamplesBeansUsingXMLConfigFiles.populatingBeanXMLConfigFile();
    }

    public static void creatingBeanByBeanFactoryDeprecated() {

        // Normal Java Object Construction
        Person myObjPersonByConstructor = new Person();
        System.out.println("Object Initialized via Constructor: \n\n" + myObjPersonByConstructor);

        // IoC container --> Bean Factory
        System.out.println("Object Initialized via BeanFactory:");

        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        Person myPersonBean = (Person) beanFactory.getBean("myBean");

        System.out.println("Object Injected via XmlBeanFactory (Deprecated): \n\n" + myPersonBean);
    }

    public static void creatingBeanByBeanFactory() {

        Resource resource = new ClassPathResource("applicationContext.xml");

        BeanDefinitionRegistry beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanReader = new XmlBeanDefinitionReader(beanFactory);
        beanReader.loadBeanDefinitions(resource);

        // In this case when we are using BeanFactory, the beans creation are lazy, those are create just after invoke
        // the getBean method, so the Beans have not been initialized,
        // We can confirm commenting the below line and see if the constructor is not executed.
        Person personBean = (Person) ((DefaultListableBeanFactory) beanFactory).getBean("myPersonBean");

        System.out.println("Bean created via XmlBeanDefinition: \n\n" + personBean);
    }

    public static void creatingBeanByApplicationContext() {

        // Way 1 to inject a Bean in two line of code using "ApplicationContext" class
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person myPersonBean = (Person) appContext.getBean("myPersonBean");

        // Way 2 to Inject a Bean using the "BeanFactory" class, due ApplicationContext is an extension of BeanFactory
        // we can use it
        BeanFactory beanFactory = (BeanFactory) appContext;
        Person myPersonBeanByBeanFactory = (Person) beanFactory.getBean("myPersonBean");

        System.out.println("Bean created by ApplicationContext class: \n\n" + myPersonBean);
        System.out.println("Bean created by BeanFactory class: \n\n" + myPersonBeanByBeanFactory);
    }

    public static void exampleOneCreatingBean(){

        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person myPersonBean = (Person) appContext.getBean("myPersonBean");

        myPersonBean.setAge(45);
        myPersonBean.setName("Karla Yuriza");
        myPersonBean.setLastName("Espiritu");
        myPersonBean.setProfession("QA Engineer");

        // Creating another Bean object to refer to the same Bean
        Person mySecondPersonBean = appContext.getBean("mySecondBean", Person.class);
        mySecondPersonBean.setName("Maria");
        mySecondPersonBean.setLastName("Concepcion");
        mySecondPersonBean.setAge(26);
        mySecondPersonBean.setProfession("Chemical");

        System.out.println("First Bean: " + myPersonBean + "\n");
        System.out.println("Second Bean: " + mySecondPersonBean + "\n");
    }

    public static void invokingInitDestroyBeanMethods() {

        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person myFirstPersonBean = (Person) appContext.getBean("myPersonBean");
        Person mySecondPersonBean = (Person) appContext.getBean("myPersonBean");

        mySecondPersonBean.setName("Maria");
        mySecondPersonBean.setLastName("Concepcion");
        mySecondPersonBean.setAge(26);
        mySecondPersonBean.setProfession("Chemical");

        System.out.println("First Bean: " + myFirstPersonBean + "\n");
        System.out.println("Second Bean: " + mySecondPersonBean + "\n");

        /* To the method .close() it is necessary use the "ClassPathXmlApplicationContext" on left declaration
        * like ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        * instead of "ApplicationContext", and this will invoke the destroyBeanMethdos.
        * */
        appContext.close();
    }

    public static void populatingBeanXMLConfigFile() {

        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person myFirstPersonBean = (Person) appContext.getBean("myPersonBean");
        Person mySecondPersonBean = (Person) appContext.getBean("mySecondPersonBean");

        System.out.println("First Bean: " + myFirstPersonBean + "\n");
        System.out.println("Second Bean: " + mySecondPersonBean + "\n");

        appContext.close();

    }
}