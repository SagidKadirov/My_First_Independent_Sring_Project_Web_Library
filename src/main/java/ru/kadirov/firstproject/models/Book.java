package ru.kadirov.firstproject.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Book {
    private int id;

    @NotEmpty(message = "Book name shouldn't be empty")
    @Size(min = 1, max = 100, message = "Name size should be between 1 and 200 characters")
    private String title;

    @NotEmpty(message = "Author shouldn't be empty")
    @Size(min = 1, max = 100, message = "Author name size should be between 1 and 200 characters")
    private String author;

    @NotEmpty(message = "book year shouldn't be empty")
    @Pattern(regexp = "\\d\\d\\d\\d", message = "The year should be like this format: 1999")
    private int year;

    public Book() {
    }

    public Book(String author, int id, String title, int year) {
        this.author = author;
        this.id = id;
        this.title = title;
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
