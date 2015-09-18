package demo.repositories

import demo.models.Employee
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

import static org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.LOAD

/**
 * Created by luis on 9/17/15.
 */
interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    @Query('FROM Employee e JOIN FETCH e.address a WHERE e.address.country = ?')
    @EntityGraph(value = "Employee.address", type = LOAD)
    Employee findOneByAddress_Country(String country)
}