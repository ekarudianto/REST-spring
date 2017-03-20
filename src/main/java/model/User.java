package main.java.model;

import org.springframework.data.annotation.Id;

public class User {
    @Id private String id;

    private int age;
    private String name;
    private String country;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public int setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public String setCountry(String country) {
        this.country = country;
    }
}