package com.promineotech.motoparts.controller;


import com.promineotech.motoparts.entity.User;
import com.promineotech.motoparts.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultUserAccountsController implements UserAccountsController {

    @Autowired
    UserAccountService userAccountService;
    @Override
    public User addUserAccount(User user) {
        return userAccountService.addUserAccount(user);
    }
}
