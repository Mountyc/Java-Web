package com.lyc.mybatis.service;

import com.lyc.mybatis.pojo.Student;

import java.util.List;

public interface IStudentService {
    List<Student> selectAllStudent();
    Student selectStudentById(int stuId);
    void insertStudent(Student student);
    void updateStudent(Student student);
    void deleteStudentById(int stuId);
}
