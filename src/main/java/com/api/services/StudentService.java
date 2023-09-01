package com.api.services;

import com.api.entity.Student;

import java.util.List;


public interface StudentService {

    Student createStudent(Student student);

    List<Student> findAllStudent();

    Student findBySid(int sid);

    Student deleteBySid(int sid);

    Student updateStudent(Student student);

    List<Student> findStudentByHisName(String name);
}
