package demo

import demo.models.Person
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by luis on 8/27/15.
 */
interface PersonRepository extends JpaRepository<Person, Integer> {

}