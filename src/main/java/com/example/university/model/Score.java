package com.example.university.model;

public class Score {
    private Long id;
    private Integer id_student;
    private Integer id_course;
    private Integer quiz_score;
    private Integer exam_score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdStudent() {
        return id_student;
    }

    public void setIdStudent(Integer idStudent) {
        this.id_student = idStudent;
    }

    public Integer getIdCourse() {
        return id_course;
    }

    public void setIdCourse(Integer idCourse) {
        this.id_course = idCourse;
    }

    public Integer getQuizScore() {
        return quiz_score;
    }

    public void setQuizScore(Integer quizScore) {
        this.quiz_score = quizScore;
    }

    public Integer getExamScore() {
        return exam_score;
    }

    public void setExamScore(Integer examScore) {
        this.exam_score = examScore;
    }
}
