package com.lyc.mybatis.dao;

import com.lyc.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentDao")
@Mapper
public interface IStudentDao {
    List<Student> selectAllStudent();
    Student selectStudentById(int stuId);
    void insertStudent(Student student);
    void updateStudent(Student student);
    void deleteStudentById(int stuId);
}
