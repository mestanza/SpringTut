package demo.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany

/**
 * Created by luis on 9/18/15.
 */
@Entity
class Project {
    @Id
    @GeneratedValue
    Long id
    String name

    @ManyToMany(mappedBy="projects")
    List<Employee> employees
}
