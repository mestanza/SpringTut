package demo.repositories

import demo.models.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

/**
 *
 * Created by luis on 8/27/15.
 */
interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query('FROM Person p WHERE p.name = ?')
    Person findOneByName(String name)

//    @Query('FROM Person p WHERE p.name = :name AND p.age > :age')
//    Person findOneByNameAndAgeGreaterThan(@Param('name') String name, @Param('age') Integer age)

    @Query(value = 'SELECT * FROM Person p WHERE p.name = ? AND p.age > ?', nativeQuery = true)
    Person findOneByNameAndAgeGreaterThan(String name, Integer age)
}