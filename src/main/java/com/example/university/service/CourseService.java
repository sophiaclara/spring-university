package com.example.university.service;

import com.example.university.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private List<Course> courses = new ArrayList<>();
    private Long nextId = 1L;

    public List<Course> getAllCourses() {
        return courses;
    }

    public Optional<Course> getCourseById(Long id) {
        return courses.stream().filter(course -> course.getId().equals(id)).findFirst();
    }

    public Course createCourse(Course course) {
        course.setId(nextId);
        courses.add(course);
        nextId++;
        return course;
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        Optional<Course> existingCourse = getCourseById(id);
        if (existingCourse.isPresent()) {
            Course course = existingCourse.get();
            course.setName(updatedCourse.getName());
            return course;
        }
        return null;
    }

    public void deleteCourse(Long id) {
        courses.removeIf(course -> course.getId().equals(id));
    }
}
