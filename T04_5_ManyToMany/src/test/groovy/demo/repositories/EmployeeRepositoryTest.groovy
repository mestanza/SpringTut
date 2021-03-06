package demo.repositories

import demo.DemoApplication
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

import javax.transaction.Transactional

import static org.junit.Assert.assertEquals

/**
 * Created by luis on 9/17/15.
 */
@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(classes = DemoApplication)
@WebAppConfiguration
class EmployeeRepositoryTest {
    @Autowired EmployeeRepository er

    @Test
    void findOne() {
        def employee = er.findOne(1L)

        assertEquals employee.firstName, 'fname1'
    }


    @Test
    @Transactional
    void findOneTransactional() {
        def employee = er.findOne(1L)

        assertEquals employee.address.country, 'country1'
    }

    @Test
    void findOneByAddress_Country() {
        def employee = er.findOneByAddress_Country('country1')

        assertEquals employee.address.country, 'country1'
    }

    @Test
    @Transactional
    void findOneByPhones_Number() {
        def employee = er.findOneByPhones_Number('55555')

        assertEquals employee.phones[0].number, '55555'
        assertEquals employee.phones[1].number, '66666'
    }

    @Test
    @Transactional
    void findByProjects_Name() {
        def employees = er.findByProjects_Name('project1')

        assertEquals employees[0].projects[0].name, 'project1'
        assertEquals employees[1].projects[0].name, 'project1'
    }
}
