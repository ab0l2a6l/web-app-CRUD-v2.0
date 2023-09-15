package model.service;

import model.domain.Person;

import java.util.List;

public interface PersonService {
    void insert(Person person);
    void delete(long id);
    void update(Person person);
    List<Person> selectAll();
}
