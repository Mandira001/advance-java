package com.lpu.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.lpu.StudentManagement.entity.Student;
import com.lpu.StudentManagement.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student createStudent(@RequestBody Student s){
        return service.saveStudent(s);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        return service.getStudentById(id).orElseThrow();
    }

    @GetMapping
    public Page<Student> getAllStudents(Pageable pageable){
        return service.getAllStudents(pageable);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id,@RequestBody Student s){
        return service.updateStudent(id, s);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        service.deleteStudent(id);
        return "Deleted Successfully";
    }

    @PostMapping("/upload/{id}")
    public Student uploadFiles(
            @PathVariable int id,
            @RequestParam("profileImage") MultipartFile profileImage,
            @RequestParam("assignmentFile") MultipartFile assignmentFile
    ) throws Exception {

        return service.uploadFiles(id, profileImage, assignmentFile);
    }

    @GetMapping("/download/profile/{id}")
    public byte[] downloadProfileImage(@PathVariable int id){

        Student student = service.getStudentById(id).orElseThrow();

        return student.getProfileImage();
    }

    @GetMapping("/download/assignment/{id}")
    public byte[] downloadAssignment(@PathVariable int id){

        Student student = service.getStudentById(id).orElseThrow();

        return student.getAssignmentfile();
    }
}
