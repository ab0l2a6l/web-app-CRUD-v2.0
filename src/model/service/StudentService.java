package model.service;


import model.domain.Student;

import java.util.List;

public interface StudentService {
    void save(Student student)throws Exception;
    void remove(long id)throws Exception;
    void update(Student student)throws Exception;
    List<Student> findAll()throws Exception;
}
