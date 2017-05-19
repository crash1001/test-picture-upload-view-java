/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.picture.demo.service;

import com.picture.demo.model.User;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ROOT
 */
public interface UserService {
    List<User> findAll();
    User findById(Long id);
    void save(User user, MultipartFile file);
    void delete(User user);
}
