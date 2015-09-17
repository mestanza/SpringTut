package demo

import demo.models.Person
import demo.repositories.PersonRepository
import org.h2.server.web.WebServlet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.embedded.ServletRegistrationBean
import org.springframework.context.annotation.Bean

@SpringBootApplication
class T05QueriesSdjApplication implements CommandLineRunner {

    static void main(String[] args) {
        SpringApplication.run T05QueriesSdjApplication, args
    }

    @Autowired PersonRepository pr

    @Override
    void run(String... args) throws Exception {

        pr.save([
                new Person(name: 'person1', age: 21),
                new Person(name: 'person2', age: 22),
                new Person(name: 'person3', age: 23)
        ])
    }


    @Bean
    ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet())
        registrationBean.addUrlMappings("/console/*")
        registrationBean
    }

}
