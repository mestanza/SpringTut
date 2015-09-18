package demo.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne

import static javax.persistence.FetchType.LAZY

/**
 * Created by luis on 9/17/15.
 */
@Entity
class Address {
    @Id
    @GeneratedValue
    Long id
    String street
    String city
    String province
    String country
    String postalCode

    @OneToOne(fetch=LAZY, mappedBy="address")
    Employee owner
}
