package model.service;

import model.domain.Person;
import model.repository.PersonDB;
import model.repository.PersonDBImpl;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements PersonService {
    private PersonDB personDB ;

    @Override
    public void save(Person person) throws Exception {
        personDB = new PersonDBImpl();
        personDB.insert(person);
        personDB.commit();
    }

    @Override
    public void remove(long id) throws Exception {
        personDB = new PersonDBImpl();
        personDB.delete(id);
        personDB.commit();
    }

    @Override
    public void update(Person person) throws Exception {
        personDB = new PersonDBImpl();
        personDB.update(person);
        personDB.commit();
    }

    @Override
    public List<Person> findAll() throws Exception {
        personDB = new PersonDBImpl();
        List<Person> people = new ArrayList<>();
        return  personDB.selectAll();
    }
}
