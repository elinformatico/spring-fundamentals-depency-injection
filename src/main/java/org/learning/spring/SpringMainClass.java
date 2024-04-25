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

public class SpringMainClass {

    public static void main(String[] args) {

        //SpringMainClass.creatingBeanByBeanFactoryDeprecated();
        //SpringMainClass.creatingBeanByBeanFactory();
        SpringMainClass.creatingBeanByApplicationContext();
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

        Person personBean = (Person) ((DefaultListableBeanFactory) beanFactory).getBean("myPersonBean");

        System.out.println("Bean created via XmlBeanDefinition: \n\n" + personBean);
    }

    public static void creatingBeanByApplicationContext() {

        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person myPersonBean = (Person) appContext.getBean("myPersonBean");

        System.out.println("Bean created by ApplicationContext class: \n\n" + myPersonBean);
    }
}