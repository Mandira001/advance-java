package com.lpu.StudentManagement.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lpu.StudentManagement.entity.Student;
import com.lpu.StudentManagement.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    @PreAuthorize("hasRole('ADMIN')")
    public Student saveStudent(Student s) {
        return repo.save(s);
    }

    @PostAuthorize("hasRole('ADMIN') || (returnObject.isPresent() && returnObject.get().email == authentication.name)")
    @Cacheable("students")
    public Optional<Student> getStudentById(int id){
        return repo.findById(id);
    }

    public Page<Student> getAllStudents(Pageable pageable){
        return repo.findAll(pageable);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Student updateStudent(int id, Student s) {

        Student existing = repo.findById(id).orElseThrow();

        existing.setName(s.getName());
        existing.setEmail(s.getEmail());
        existing.setCourse(s.getCourse());
        existing.setMarks(s.getMarks());

        return repo.save(existing);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteStudent(int id){
        repo.deleteById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Student uploadFiles(int id, MultipartFile profileImage, MultipartFile assignmentFile) throws IOException {

        Student student = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if(profileImage != null){
            student.setProfileImage(profileImage.getBytes());
        }

        if(assignmentFile != null){
            student.setAssignmentfile(assignmentFile.getBytes());
        }

        return repo.save(student);
    }
}