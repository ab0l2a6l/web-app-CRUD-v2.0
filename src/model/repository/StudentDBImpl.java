package model.repository;

import common.JDBC;
import model.domain.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDBImpl implements StudentDB , AutoCloseable{
    private Connection connection;
    private PreparedStatement preparedStatement;
    public StudentDBImpl()throws Exception{
        JDBC.getConnection();
        connection.setAutoCommit(false);
    }
    @Override
    public void insert(Student student) throws Exception {
        preparedStatement = connection.prepareStatement("insert into stundent (id, name, family)values(?,?,?)");
        preparedStatement.setLong(1,student.getId());
        preparedStatement.setString(2,student.getName());
        preparedStatement.setString(3,student.getFamily());
        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(long id) throws Exception {
        preparedStatement = connection.prepareStatement("delete from student where id = ?");
        preparedStatement.setLong(1,id);
        preparedStatement.executeUpdate();
    }

    @Override
    public void update(Student student) throws Exception {
        preparedStatement = connection.prepareStatement("update student set name = ? , family = ? where id = ?");
        preparedStatement.setString(1,student.getName());
        preparedStatement.setString(2,student.getFamily());
        preparedStatement.setLong(3,student.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public List<Student> selectAll() throws Exception {
        List<Student> students = new ArrayList<>();
        preparedStatement = connection.prepareStatement("select * from student");
        ResultSet set = preparedStatement.executeQuery();
        while (set.next()){
            Student student = new Student();
            student.setId(set.getLong("id"));
            student.setName(set.getString("name"));
            student.setFamily(set.getString("family"));
            students.add(student);
        }
        return students;
    }

    @Override
    public void commit() throws Exception {
        connection.commit();
    }

    @Override
    public void close() throws Exception {
        connection.close();
        preparedStatement.close();
    }
}
