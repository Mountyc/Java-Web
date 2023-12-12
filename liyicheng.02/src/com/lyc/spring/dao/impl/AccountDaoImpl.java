package com.lyc.spring.dao.impl;

import com.lyc.spring.dao.AccountDao;
import com.lyc.spring.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public double getMoney(String username) {

        List<Account> list = jdbcTemplate.query("select * from account where username=?",
                new Object[]{username},
                new BeanPropertyRowMapper<>(Account.class));
        if(list.size()>0) {
            return list.get(0).getMoney();
        }
        return -1;
    }

    @Override
    public void addMoney(String username, double money) {
        System.out.println(username+"转入"+money);
        jdbcTemplate.update("update account set money =money + ? where username = ?",
                new Object[]{new Double(money),username});
    }

    @Override
    public void subMoney(String username, double money) {
        System.out.println(username+"转出"+money);
        jdbcTemplate.update("update account set money =money - ? where username = ?",
                new Object[]{new Double(money),username});
    }

    @Override
    public void transMoney(String source, String target, double money) {
        if(getMoney(source)<money) {
            throw new RuntimeException(source+"账户余额不足！");
        }
        System.out.println("----开始转账-----");
        subMoney(source, money);
        //int i= 1/0;
        addMoney(target, money);
        System.out.println("----转账完成----");
    }
}
