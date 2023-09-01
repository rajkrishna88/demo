package com.api.services;

import com.api.entity.Student;
import com.api.exception.ResourceNotFoundException;
import com.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public Student createStudent(Student student) {
    return studentRepository.save(student);
  }

  @Override
  public List<Student> findAllStudent() {
    return studentRepository.findAll();
  }

  @Override
  public Student findBySid(int sid) {
    Optional<Student> byId = studentRepository.findById(sid);
    Student student = byId.get();
      return student;
}

  @Override
  public Student deleteBySid(int sid) {
    Optional<Student> byId = studentRepository.findById(sid);
    Student student = byId.get();
    if (student!=null){
      studentRepository.deleteById(sid);
      return student;
    }else {
      throw new ResourceNotFoundException("given id is not valid");
    }
  }

  @Override
  public Student updateStudent(Student student) {
    Optional<Student> byId = studentRepository.findById(student.getSid());
    if (byId.isPresent()){
      Student student1 = byId.get();
      student1.setSid(student.getSid());
      student1.setName(student.getName());
      student1.setCity(student.getCity());
      student1.setNum(student.getNum());
      studentRepository.save(student1);
    return student1;
    }else {
      throw new ResourceNotFoundException("Given id is not valid");
    }
  }

  @Override
  public List<Student> findStudentByHisName(String name) {
    List<Student> byName = studentRepository.getByName(name);
    return byName;
  }
}