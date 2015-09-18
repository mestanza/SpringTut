package demo.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.NamedAttributeNode
import javax.persistence.NamedEntityGraph
import javax.persistence.OneToOne

import static javax.persistence.FetchType.EAGER
import static javax.persistence.FetchType.LAZY

/**
 * Created by luis on 9/17/15.
 */
@Entity
@NamedEntityGraph(name = "Employee.address",
        attributeNodes = @NamedAttributeNode("address"))
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
}
