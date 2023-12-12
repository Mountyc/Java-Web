package com.lyc.spring.service.impl;

import com.lyc.spring.dao.AccountDao;
import com.lyc.spring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED,
        isolation = Isolation.READ_COMMITTED,
        rollbackFor = Exception.class)
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public double getMoney(String username) {
        return accountDao.getMoney(username);
    }

    @Override
    public void addMoney(String username, double money) {
        accountDao.addMoney(username, money);
    }

    @Override
    public void subMoney(String username, double money) {
        accountDao.subMoney(username, money);
    }

    @Override
    public void transMoney(String source, String target, double money) {
        accountDao.transMoney(source, target, money);
    }
}
