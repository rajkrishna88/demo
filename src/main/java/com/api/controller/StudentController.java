package com.api.controller;

import com.api.entity.Student;
import com.api.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Student> createNewStudent(@RequestBody Student student){
        Student newStudent=studentService.createStudent(student);
       return new ResponseEntity<>(newStudent, HttpStatus.OK);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> allStudent = studentService.findAllStudent();
    return new ResponseEntity<>(allStudent,HttpStatus.OK);
    }
    @GetMapping("/{sid}")
    public ResponseEntity<Student> getStudentByID(@PathVariable("sid") int sid){
        Student bySid = studentService.findBySid(sid);
        return new ResponseEntity<>(bySid,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{sid}")
    public ResponseEntity<Student> deleteById(@PathVariable("sid") int sid){
        return new ResponseEntity<>(studentService.deleteBySid(sid),HttpStatus.OK);
    }
    @PutMapping("/update/{sid}")
    public ResponseEntity<Student> updateStudentUsingSid(@PathVariable("sid") int sid, @RequestBody Student student){
        student.setSid(sid);
        return new ResponseEntity<>(studentService.updateStudent(student),HttpStatus.OK);
    }
    @GetMapping("/getByName/{name}")
        public ResponseEntity<List<Student>> getStudentByName(@PathVariable("name") String name){
        List<Student> studentByHisName = studentService.findStudentByHisName(name);
        return new ResponseEntity<>(studentByHisName,HttpStatus.OK);

    }

}
