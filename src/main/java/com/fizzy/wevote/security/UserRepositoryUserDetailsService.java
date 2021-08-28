package com.fizzy.wevote.security;

import com.fizzy.wevote.data.UserRepository;
import com.fizzy.wevote.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {
    private final UserRepository userRepo;

    @Autowired
    public UserRepositoryUserDetailsService(UserRepository userRepo){
        this.userRepo = userRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user != null){
            return user;
        }
        throw new UsernameNotFoundException("用户 '" + username + "' 不存在");
    }
}
