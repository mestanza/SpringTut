package demo.restcontrollers

import demo.PersonRepository
import demo.models.Person
import org.springframework.beans.factory.annotation.Autowired
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

    @Autowired
    PersonRepository pr;

    @RequestMapping("/{id}")
    public Person findOne(@PathVariable int id) {
        pr.findOne id
    }

    @RequestMapping
    public List<Person> findAll() {
        pr.findAll()
    }

    @RequestMapping(method = POST)
    public Person insert(@RequestBody Person person) {
        pr.save(person)
    }


    @RequestMapping(method = PUT)
    public Person update(@RequestBody Person person) {
        pr.save(person)
    }

    @RequestMapping(value = '/{id}', method = DELETE)
    public void delete(@PathVariable Integer id) {
        pr.delete(id)
    }
}
