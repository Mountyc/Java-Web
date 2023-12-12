package com.lyc.mybatis.service.impl;

import com.lyc.mybatis.dao.IStudentDao;
import com.lyc.mybatis.pojo.Student;
import com.lyc.mybatis.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao studentDao;

    @Override
    public List<Student> selectAllStudent() {
        return studentDao.selectAllStudent();
    }

    @Override
    public Student selectStudentById(int stuId) {
        return studentDao.selectStudentById(stuId);
    }

    @Override
    public void insertStudent(Student student) {
        studentDao.insertStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public void deleteStudentById(int stuId) {
        studentDao.deleteStudentById(stuId);
    }
}
