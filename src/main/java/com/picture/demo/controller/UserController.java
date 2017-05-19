/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.picture.demo.controller;

import com.picture.demo.model.User;
import com.picture.demo.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ROOT
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    
    //Home page - index of all pictures
    @RequestMapping("/")
    public String listPhotos(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user/index";
    }
    
    //Upload a new picture
    @RequestMapping(value = "/users", method =RequestMethod.POST) 
    public String addGif(@Valid User user, @RequestParam MultipartFile file, RedirectAttributes redirectAttributes) {
        userService.save(user, file);
        
        return String.format("redirect:/users/%s", user.getId());
    }
    
    //Form for uploading a new GIF
    @RequestMapping("/upload")
    public String formNewUser(Model model) {
        
        if(!model.containsAttribute("user")) {
            model.addAttribute("user", new User());
        }
        
        model.addAttribute("action", "/users");
        
        model.addAttribute("heading", "Upload");
        
        model.addAttribute("submit", "Add");
        
        return "user/form";
    }
    
    //Display a picture
    @RequestMapping("/users/{userId}")
    public String userDetails(@PathVariable Long userId, Model model) {
        User user = userService.findById(userId);
        model.addAttribute("user", user);
        return "user/details";
    }
    
    
    //  Get image data
    @RequestMapping("/users/{userId}.gif")
    @ResponseBody
    public byte[] gifImage(@PathVariable Long userId) {
        // TODO: Return image data as byte array of the GIF whose id is gifId
        return userService.findById(userId).getPhoto();
    }
}
