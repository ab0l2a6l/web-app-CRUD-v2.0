package model.repository;

import model.domain.Person;

import java.util.List;

public interface PersonDB {
    void insert(Person person)throws Exception;
    void delete(long id)throws Exception;
    void update(Person person) throws Exception;
    List<Person> selectAll()throws Exception;
    void commit()throws Exception;
}
