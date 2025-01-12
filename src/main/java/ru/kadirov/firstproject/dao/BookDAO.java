package ru.kadirov.firstproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.kadirov.firstproject.models.Book;

import java.util.List;

@Component
@PropertySource("classpath:database.properties")
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index(){
        return jdbcTemplate.query("SELECT * FROM book",new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id){
        return jdbcTemplate.query("SELECT * FROM book WHERE book_id=?", new Object[]{id},new BeanPropertyRowMapper<>(Book.class))
                .stream()
                .findAny()
                .orElse(null);
    }
    public void save(Book book){
        jdbcTemplate.update("INSERT INTO book(book_name, book_author,book_year) VALUES ?,?,?",book.getBook_name(),book.getBook_author(),book.getBook_year());
    }
    public void update(int id, Book updatedBook){
        jdbcTemplate.update("UPDATE book SET book_name=?, book_author=?, book_year=? WHERE book_id=?", updatedBook.getBook_name(), updatedBook.getBook_author(), updatedBook.getBook_year(),id);
    }
    public void delete(int id){
        jdbcTemplate.update("DELETE FROM book WHERE book_id=?", id);
    }
}
