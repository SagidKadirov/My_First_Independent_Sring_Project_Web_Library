package ru.kadirov.firstproject.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Person {
private int id;

@NotEmpty(message = "The name shouldn't be empty")
@Size(min = 1, max = 100, message = "The name size should be between 1 and 200 characters")
private String fullName;

@NotEmpty(message = "The age shouldn't be empty")
private int yearOfBirth;

    public Person(int yearOfBirth, String fullName, int id) {
        this.yearOfBirth = yearOfBirth;
        this.fullName = fullName;
        this.id = id;
    }

    public Person() {
    }


    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

