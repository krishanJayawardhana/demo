package com.example.demo.service;

import com.example.demo.dao.UserEntity;
import com.example.demo.dao.UserRepository;
import org.springframework.boot.ApplicationRunner;

public interface UserService {

    UserEntity getUser(String userId);

}
