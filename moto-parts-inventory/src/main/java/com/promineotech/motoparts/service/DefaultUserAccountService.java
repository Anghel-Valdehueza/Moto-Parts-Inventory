package com.promineotech.motoparts.service;

import com.promineotech.motoparts.dao.UserAccountDao;
import com.promineotech.motoparts.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserAccountService implements UserAccountService{

    @Autowired
    private UserAccountDao userAccountDao;
    @Override
    public User addUserAccount(User user) {
        return userAccountDao.addUserAccount(user);
    }
}
