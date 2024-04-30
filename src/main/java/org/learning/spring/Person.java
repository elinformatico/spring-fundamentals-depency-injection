package org.learning.spring;

import org.springframework.stereotype.Component;

/*
* Component represent a class whose instances
* can be injected into another object.
*
* We need to use along the below configuration in PersonBeanConfig.java
*
* @Configuration
* @ComponentScan(basePackages = "org.learning.spring")
* **/
//@Component  // --> it's works if we comment this line
public class Person {

    private String name = "Jose Noe";
    private String lastName = "Hernandez Vivanco";
    private int age = 38;
    private String profession = "Software Engineer";

    public Person() {
        System.out.println("Creating Person [" + this.name + "] Object");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Person { " +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", profession='" + profession + '\'' +
                '}';
    }

    public void initBean() throws Exception {
        System.out.println("Person bean has been instantiated inside initBean() method");
    }

    public void destroyBean() throws Exception {
        System.out.println("Person bean has been destroyed inside destroyBean() method()");
    }
}
