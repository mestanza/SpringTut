package demo.models

import javax.persistence.*

/**
 * Created by luis on 9/18/15.
 */
@Entity
class Phone {
    @Id
    @GeneratedValue
    Long id

    String type
    String number
    String areaCode

    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="OWNER_ID")
    Employee owner
}
