package com.service;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.entity.UserEntity;


@Service
public class SignUpService {
    @Autowired
    UserDao userDao;

    public void signUp(String userName, String password) {
        UserEntity user = new UserEntity();
        user.setUserName(userName);
        String encryptPassword = getEncrpytedPassword(password);
        user.setPassword(encryptPassword);
        userDao.insert(user);
    }

    public String getEncrpytedPassword(String string) {
        return (String) Base64.getEncoder().encodeToString(string.getBytes());
    }

}
