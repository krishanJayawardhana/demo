package com.example.demo;

import com.example.demo.dao.UserEntity;
import com.example.demo.dao.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntityUserController {

    @Autowired
    private UserService userService;



    @GetMapping("/userEnt")
    public UserEntity getUser() {

        return userService.getUser("kamal");
    }

}
