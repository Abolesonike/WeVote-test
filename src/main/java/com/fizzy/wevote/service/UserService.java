package com.fizzy.wevote.service;


import com.fizzy.wevote.data.UserRepository;
import com.fizzy.wevote.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public User findUserById(Long id){
        return userRepository.findUserById(id);
    }
}
