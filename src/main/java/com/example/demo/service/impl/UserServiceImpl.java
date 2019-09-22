package com.example.demo.service.impl;

import com.example.demo.dao.UserEntity;
import com.example.demo.dao.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity getUser(String userId){

        UserEntity userEntity = userRepository.getOne(userId);
        System.out.printf(userEntity.getName());
        return userEntity;
    }





}
