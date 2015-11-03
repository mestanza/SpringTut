package com.example

import com.example.models.Role
import com.example.models.User
import com.example.repositories.RolesRepository
import com.example.repositories.UsersRepository
import org.h2.server.web.WebServlet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.embedded.ServletRegistrationBean
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringSecurityDemoApplication implements CommandLineRunner {

    @Autowired UsersRepository usersRepository

    static void main(String[] args) {
        SpringApplication.run SpringSecurityDemoApplication, args
    }

    @Override
    void run(String... args) throws Exception {
        usersRepository.save([
                new User(username: 'admin', password: 'admin',
                    authorities: [new Role(authority: 'ADMIN')]),
                new User(username: 'user', password: 'user',
                    authorities: [new Role(authority: 'USER')])
        ])
    }

    @Bean
    ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet())
        registrationBean.addUrlMappings("/console/*")
        registrationBean
    }
}
