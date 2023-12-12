package com.lyc.spring.dao;

public interface AccountDao {
    double getMoney(String username);

    void addMoney(String username, double money);

    void subMoney(String username, double money);

    void transMoney(String source, String target, double money);
}
