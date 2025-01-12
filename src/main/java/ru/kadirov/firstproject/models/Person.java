package ru.kadirov.firstproject.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Person {
private int id;
@NotEmpty(message = "The name shouldn't be empty")
@Size(min = 1, max = 200, message = "The name size should be between 1 and 200 characters")
@Pattern(regexp = "[A-Z]\\w+ [A-Z]\\w+ [A-Z]\\w+", message = "The full name should be like this format: Kadirov Sagid Timurovich")
private String full_name;
@NotEmpty(message = "The age shouldn't be empty")
@Pattern(regexp = "\\d\\d\\d\\d", message = "Year should be like this format: 1999")
private int birth_age;

    public Person(int birth_age, String full_name, int id) {
        this.birth_age = birth_age;
        this.full_name = full_name;
        this.id = id;
    }

    public Person() {
    }


    public int getBirth_age() {
        return birth_age;
    }

    public void setBirth_age(int birth_age) {
        this.birth_age = birth_age;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name( String full_name) {
        this.full_name = full_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

