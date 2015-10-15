package demo.repositories

import demo.models.Employee
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.QueryHints

import javax.persistence.QueryHint

import static org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.FETCH
import static org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.LOAD

/**
 * Created by luis on 9/17/15.
 */
interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    @Query('FROM Employee e JOIN FETCH e.address a WHERE e.address.country = ?')
    @EntityGraph(value = "Employee.address", type = LOAD)
    Employee findOneByAddress_Country(String country)

//    @EntityGraph(value = "Employee.phones")
//    @Query('FROM Employee e JOIN e.phones p WHERE p.number = ?')
    Employee findOneByPhones_Number(String phoneNumber)

    List<Employee> findByProjects_Name(String projectName)
}