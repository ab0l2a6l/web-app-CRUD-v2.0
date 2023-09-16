package model.service;

import model.domain.Student;
import model.repository.PersonDB;
import model.repository.PersonDBImpl;
import model.repository.StudentDB;
import model.repository.StudentDBImpl;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    StudentDB studentDB;
    @Override
    public void save(Student student) throws Exception {
        studentDB = new StudentDBImpl();
        studentDB.insert(student);
        studentDB.commit();
    }

    @Override
    public void remove(long id) throws Exception {
        studentDB = new StudentDBImpl();
        studentDB.delete(id);
        studentDB.commit();
    }

    @Override
    public void update(Student student) throws Exception {
        studentDB = new StudentDBImpl();
        studentDB.update(student);
        studentDB.commit();
    }

    @Override
    public List<Student> findAll() throws Exception {
        return new StudentDBImpl().selectAll();
    }
}
