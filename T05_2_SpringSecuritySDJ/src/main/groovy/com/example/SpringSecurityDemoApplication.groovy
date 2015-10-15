package com.example

import com.example.models.Role
import com.example.models.User
import com.example.repositories.RolesRepository
import com.example.repositories.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SpringSecurityDemoApplication implements CommandLineRunner {

    @Autowired UsersRepository usersRepository

    static void main(String[] args) {
        SpringApplication.run SpringSecurityDemoApplication, args
    }

    @Override
    void run(String... args) throws Exception {
        def adminRole =
        usersRepository.save([
                new User(username: 'admin', password: 'admin',
                    authorities: [new Role(authority: 'ADMIN')]),
                new User(username: 'user', password: 'user',
                    authorities: [new Role(authority: 'USER')])
        ])
    }
}
