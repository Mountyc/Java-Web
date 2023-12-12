package com.lyc.spring.service;

public interface AccountService {
    double getMoney(String username);
    void addMoney(String username, double money);
    void subMoney(String username, double money);
    void transMoney(String source, String target, double money);
}
