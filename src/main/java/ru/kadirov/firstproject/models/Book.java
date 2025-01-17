package ru.kadirov.firstproject.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Book {
    private int id;

    @NotEmpty(message = "Book name shouldn't be empty")
    @Size(min = 1, max = 100, message = "Name size should be between 1 and 200 characters")
    private String title;

    @NotEmpty(message = "Author shouldn't be empty")
    @Size(min = 1, max = 100, message = "Author name size should be between 1 and 200 characters")
    private String author;

    @Min(value=1000, message = "Year of production must be older than 1500")
    private int year;

    public Book() {
    }

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
