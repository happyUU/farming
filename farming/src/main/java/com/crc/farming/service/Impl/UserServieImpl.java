package com.crc.farming.service.Impl;

import com.crc.farming.dao.UserDao;
import com.crc.farming.pojo.User;
import com.crc.farming.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServieImpl implements UserService {

    @Autowired(required = false)
    UserDao userDao;

    @Override
    public boolean insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User logincheck(String name, String password) {
        return userDao.logincheck(name, password);
    }

    @Override
    public boolean updateUserById(String name, String tel, String email,String address, Integer id) {
        return userDao.updateUserById(name,tel,email,address,id);
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public boolean updateUserPassWordById(String password, Integer id) {
        return userDao.updateUserPassWordById(password,id);
    }
}
