package demo.restcontrollers

import demo.models.Person
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.DELETE
import static org.springframework.web.bind.annotation.RequestMethod.POST
import static org.springframework.web.bind.annotation.RequestMethod.PUT

/**
 *
 * Created by luis on 8/27/15.
 */
@RestController
@RequestMapping("/persons")
public class PersonRestController {

    @RequestMapping("/{id}")
    public Person findOne(@PathVariable int id) {
        println id
        new Person(id: 1, name: 'luis', age: 20)
    }

    @RequestMapping
    public List<Person> findAll() {
        [
                new Person(id: 1, name: 'luis', age: 20),
                new Person(id: 2, name: 'person2', age: 30)
        ]
    }

    @RequestMapping(value = '/{id}', method = POST)
    public Person insert(@PathVariable Integer id, @RequestBody Person person) {
        person.id = id
        person
    }


    @RequestMapping(method = PUT)
    public Person update(@RequestBody Person person) {
        person
    }

    @RequestMapping(value = '/{id}', method = DELETE)
    public void delete(@PathVariable Integer id) {

    }
}
