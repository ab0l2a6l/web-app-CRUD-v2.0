package model.repository;

import common.JDBC;
import common.WrapperClass;
import model.domain.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonDBImpl implements PersonDB , AutoCloseable{
    private Connection connection;
    private PreparedStatement preparedStatement;
    public PersonDBImpl(){
        try {
            connection = JDBC.getConnection();
        } catch (Exception e) {
            WrapperClass.get(e);
        }
    }
    @Override
    public void insert(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("insert into person(id,name,family)values (?,?,?)");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.setString(2,person.getName());
        preparedStatement.setString(3,person.getFamily());
        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(long id) throws Exception {
        preparedStatement = connection.prepareStatement("delete *  from person where id = ?");
        preparedStatement.setLong(1,id);
        preparedStatement.executeUpdate();
    }

    @Override
    public void update(Person person) throws Exception {
        preparedStatement= connection.prepareStatement("update person set name = ? , family =? where id = ?");
        preparedStatement.setString(1,person.getName());
        preparedStatement.setString(2, person.getFamily());
        preparedStatement.setLong(3,person.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public List<Person> selectAll() throws Exception {
        List<Person> people = new ArrayList<>();
        preparedStatement = connection.prepareStatement("select  * from person");
        ResultSet set = preparedStatement.executeQuery();
        while (set.next()){
            Person person = new Person();
            person.setId(set.getLong("id"));
            person.setName(set.getString("name"));
            person.setFamily(set.getString("family"));
            people.add(person);
        }
        return people;
    }

    @Override
    public void close() throws Exception {
        connection.close();
        preparedStatement.close();
    }
}
