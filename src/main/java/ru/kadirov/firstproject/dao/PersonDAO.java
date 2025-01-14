package ru.kadirov.firstproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.kadirov.firstproject.models.Person;

import java.util.List;
import java.util.Optional;

@Component
@PropertySource("classpath:database.properties")
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index(){
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id){
        return jdbcTemplate.query("SELECT * FROM person WHERE person_id=?",new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream()
                .findAny()
                .orElse(null);
    }
public Optional<Person> getPersonByFullName(String fullName){
        return jdbcTemplate.query("SELECT * FROM person WHERE fullname=?",new BeanPropertyRowMapper<>(Person.class),fullName)
                .stream()
                .findAny();
}
    public void save(Person person){
        jdbcTemplate.update("INSERT INTO person(full_name, birth_year) values (?,?)", person.getFullName(),person.getYearOfBirth());
    }
    public void update(int id, Person updatedPerson){
        jdbcTemplate.update("UPDATE person SET full_name=?,birth_year=? WHERE person_id=?", updatedPerson.getFullName(),updatedPerson.getYearOfBirth(),id);
    }
    public void delete(int id){
        jdbcTemplate.update("DELETE FROM person WHERE person_id=?",id);
    }

}
