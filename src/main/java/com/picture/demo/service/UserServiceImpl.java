/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.picture.demo.service;

import com.picture.demo.dao.UserDao;
import com.picture.demo.model.User;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

   @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public void save(User user, MultipartFile file) {
        try {
            user.setPhoto(file.getBytes());
            userDao.save(user);
        } catch (IOException ex) {
            System.err.println("Unable to get byte array from uploaded file.");
        }
    }
    
}
