package demo.repositories

import demo.DemoApplication
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

import javax.transaction.Transactional

/**
 * Created by luis on 9/17/15.
 */
@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(classes = DemoApplication)
@WebAppConfiguration
class EmployeeRepositoryTest {
    @Autowired EmployeeRepository er

    @Test
    @Transactional
    void findOne() {
        def employee = er.findOne(1L)

        println employee.address.country
    }

    @Test
    void findOneByAddress_Country() {
        def emplyee = er.findOneByAddress_Country('country1')

        println emplyee.address.country
    }
}
