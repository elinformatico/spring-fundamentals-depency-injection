package org.learning.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @Configuration
// @ComponentScan(basePackages = "org.learning.spring")
@Configuration
public class PersonBeanConfig {

    /*
     * If we don't include the property name of the bean, Spring will take the name of the method, so if
     * we include it, Spring will take the name of the property "name"
     * */
    @Bean(name = "myFirstBeanPerson", initMethod = "initBean", destroyMethod = "destroyBean")
    public Person PersonBean() {
        return  new Person();
    }

    @Bean(name = "mySecondBeanPerson", initMethod = "initBean", destroyMethod = "destroyBean")
    public Person SecondPersonBean() {
        return new Person();
    }

    @Bean(name = "anotherBeanObject", initMethod = "initBean", destroyMethod = "destroyBean")
    public Person AnotherBeanObject() {

        Person person = new Person();
        person.setName("Armando");
        person.setLastName("Perez Espinoza");
        person.setProfession("Professional Design");
        person.setAge(39);

        return person;
    }
}
