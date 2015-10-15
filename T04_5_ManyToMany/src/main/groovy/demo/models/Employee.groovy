package demo.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.NamedAttributeNode
import javax.persistence.NamedEntityGraph
import javax.persistence.NamedEntityGraphs
import javax.persistence.OneToMany
import javax.persistence.OneToOne

import static javax.persistence.FetchType.EAGER
import static javax.persistence.FetchType.LAZY

/**
 * Created by luis on 9/17/15.
 */
@Entity
@NamedEntityGraphs([
    @NamedEntityGraph(name = "Employee.address",
            attributeNodes = @NamedAttributeNode("address")),
    @NamedEntityGraph(name = "Employee.phones",
            attributeNodes = @NamedAttributeNode("phones"))
])
class Employee {
    @Id
    @GeneratedValue
    Long id
    String firstName
    String lastName
    BigDecimal salary

    @OneToOne(fetch=LAZY)
//    @JoinColumn(name="ADDRESS_ID")
    Address address

    @OneToMany(mappedBy="owner")
    List<Phone> phones

    @ManyToMany
//    @JoinTable(
//            name="EMP_PROJ",
//            joinColumns=[@JoinColumn(name="EMP_ID", referencedColumnName="ID")],
//            inverseJoinColumns=[@JoinColumn(name="PROJ_ID", referencedColumnName="ID")])
    List<Project> projects
}
