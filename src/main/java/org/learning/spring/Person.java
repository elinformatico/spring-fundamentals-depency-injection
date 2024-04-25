package org.learning.spring;

public class Person {

    public Person() {
        System.out.println("Creating Person Object");
    }
    private String name = "Jose Noe";
    private String lastName = "Hernandez Vivanco";
    private int age = 38;
    private String profession = "Software Engineer";

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
}
