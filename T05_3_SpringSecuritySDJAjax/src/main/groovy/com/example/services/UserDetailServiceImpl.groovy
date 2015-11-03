package com.example.services

import com.example.repositories.UsersRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by luis on 10/14/15.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UsersRepository usersRepository

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        usersRepository.findOneByUsername(username)
    }
}
