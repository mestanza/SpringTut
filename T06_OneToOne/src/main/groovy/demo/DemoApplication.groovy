package demo

import demo.models.Address
import demo.models.Employee
import demo.models.Person
import demo.repositories.AddressRepository
import demo.repositories.EmployeeRepository
import demo.repositories.PersonRepository
import org.h2.server.web.WebServlet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.embedded.ServletRegistrationBean
import org.springframework.context.annotation.Bean

@SpringBootApplication
class DemoApplication implements CommandLineRunner {

    static void main(String[] args) {
        SpringApplication.run DemoApplication, args
    }

    @Autowired PersonRepository pr
    @Autowired EmployeeRepository er
    @Autowired AddressRepository ar

    @Override
    void run(String... args) throws Exception {

        pr.save([
                new Person(name: 'person1', age: 21),
                new Person(name: 'person2', age: 22),
                new Person(name: 'person3', age: 23)
        ])

        def employees = er.save([
                new Employee(
                        firstName: 'fname1',
                        lastName: 'lname1',
                        salary: new BigDecimal('111')
                ),
                new Employee(firstName: 'fname2', lastName: 'lname2', salary: new BigDecimal('222')),
                new Employee(firstName: 'fname3', lastName: 'lname3', salary: new BigDecimal('333'))
        ])

        def address1 = ar.save(new Address(
                        city: 'city1',
                        country: 'country1',
                        street: 'street1',
                        postalCode: 'postalCode1',
                        province: 'province1',
                        owner: employees[0]
                ))

        employees[0].address = address1

        er.save(employees[0])
    }


    @Bean
    ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet())
        registrationBean.addUrlMappings("/console/*")
        registrationBean
    }

}
