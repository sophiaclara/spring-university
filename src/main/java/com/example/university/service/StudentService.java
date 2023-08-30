package com.example.university.service;

import com.example.university.model.Student;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();
    private Long nextId = 1L;

    public List<Student> getAllStudents() {
        return students;
    }

    public Optional<Student> getStudentById(Long id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst();
    }

    public Student createStudent(Student student) {
        student.setId(nextId);
        students.add(student);
        nextId++;
        return student;
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Optional<Student> existingStudent = getStudentById(id);
        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            student.setName(updatedStudent.getName());
            student.setMajor(updatedStudent.getMajor());
            return student;
        }
        return null;
    }

    public void deleteStudent(Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }
}
