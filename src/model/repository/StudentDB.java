package model.repository;

import model.domain.Student;

import java.util.List;

public interface StudentDB {
    void insert(Student student)throws Exception;
    void delete(long id)throws Exception;
    void update(Student student) throws Exception;
    List<Student> selectAll()throws Exception;
    void commit()throws Exception;
}
