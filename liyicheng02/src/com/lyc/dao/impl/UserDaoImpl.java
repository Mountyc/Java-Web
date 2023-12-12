package com.lyc.dao.impl;

import com.lyc.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("-----UserDao save User----");
        int i = 1/0; //异常测试

    }
}
