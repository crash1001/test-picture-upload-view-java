/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.picture.demo.dao;

import com.picture.demo.model.User;
import java.util.List;

/**
 *
 * @author ROOT
 */
public interface UserDao {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    void delete(User user);
}
