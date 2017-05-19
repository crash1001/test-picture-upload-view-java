/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.picture.demo.dao;

import com.picture.demo.model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        List<User> users = session.createCriteria(User.class).list();
        
        session.close();
        return users;
    }

    @Override
    public User findById(Long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        
        session.saveOrUpdate(user);
        
        session.getTransaction().commit();
        
        session.close();
        
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        
        session.delete(user);
        
        session.getTransaction().commit();
        
        session.close();
    }
    
}
