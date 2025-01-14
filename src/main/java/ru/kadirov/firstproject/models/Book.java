package ru.kadirov.firstproject.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Book {
    private int book_id;

    private Integer person_id;
    @NotEmpty(message = "Book name shouldn't be empty")
    @Size(min = 1, max = 200, message = "Name size should be between 1 and 200 characters")
    private String book_name;
    @NotEmpty(message = "Author shouldn't be empty")
    @Size(min = 1, max = 200, message = "Author name size should be between 1 and 200 characters")
    private String book_author;
    @NotEmpty(message = "book year shouldn't be empty")
    @Pattern(regexp = "\\d\\d\\d\\d", message = "The year should be like this format: 1999")
    private int book_year;

    public Book() {
    }

    public Book(String book_author, int book_id, String book_name, int book_year, Integer person_id) {
        this.book_author = book_author;
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_year = book_year;
        this.person_id = person_id;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author (String book_author) {
        this.book_author = book_author;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public int getBook_year() {
        return book_year;
    }

    public void setBook_year(int book_year) {
        this.book_year = book_year;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }
}
