package com.fizzy.wevote.controller;

import com.fizzy.wevote.data.UserRepository;
import com.fizzy.wevote.entity.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/user", produces = "application/json")
@CrossOrigin
public class UserController {
    private final UserRepository userRepository;
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("register")
    public String processRegistration(User user){
        userRepository.save(user);
        return "成功";
    }

    @GetMapping("/login")
    public String login(User user){
        User user1 = userRepository.findByUsername(user.getUsername());
        if(user1 != null){
            if(user1.getPassword().equals(user.getPassword())){
                return "成功";
            }
            else {
                return "失败";
            }
        }
        return "失败";
    }

    @CrossOrigin
    @GetMapping("allUser")
    public Iterable<User> allUserPage(){
        PageRequest page = PageRequest.of(0,3);
        return userRepository.findAll(page);
    }
}
