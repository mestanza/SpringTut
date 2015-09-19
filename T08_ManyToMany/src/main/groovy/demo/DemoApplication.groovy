package demo

import demo.models.Address
import demo.models.Employee
import demo.models.Person
import demo.models.Phone
import demo.models.Project
import demo.repositories.AddressRepository
import demo.repositories.EmployeeRepository
import demo.repositories.PersonRepository
import demo.repositories.PhoneRepository
import demo.repositories.ProjectRepository
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

    @Autowired
    PersonRepository pr
    @Autowired
    EmployeeRepository er
    @Autowired
    AddressRepository ar
    @Autowired
    PhoneRepository phr

    @Autowired
    ProjectRepository prr

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
                        salary: new BigDecimal('111'),
                        address: ar.save(new Address(
                                city: 'city1',
                                country: 'country1',
                                street: 'street1',
                                postalCode: 'postalCode1',
                                province: 'province1'
                        ))
                ),
                new Employee(
                        firstName: 'fname2',
                        lastName: 'lname2',
                        salary: new BigDecimal('222')),
                new Employee(
                        firstName: 'fname3',
                        lastName: 'lname3',
                        salary: new BigDecimal('333'))
        ])

        phr.save([
                new Phone(number: '11111', areaCode: '111', type: 'home', owner: employees[0]),
                new Phone(number: '22222', areaCode: '222', type: 'work', owner: employees[0]),
                new Phone(number: '33333', areaCode: '333', type: 'home', owner: employees[1]),
                new Phone(number: '44444', areaCode: '444', type: 'work', owner: employees[1]),
                new Phone(number: '55555', areaCode: '555', type: 'home', owner: employees[2]),
                new Phone(number: '66666', areaCode: '666', type: 'work', owner: employees[2])
        ])

        def projects = prr.save([
                new Project(name: 'project1'),
                new Project(name: 'project2'),
                new Project(name: 'project3'),
        ])

        employees[0].projects = [projects[0], projects[1]]
        employees[1].projects = [projects[1], projects[2]]
        employees[2].projects = [projects[0], projects[2]]
        er.save(employees)
    }


    @Bean
    ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet())
        registrationBean.addUrlMappings("/console/*")
        registrationBean
    }

}
