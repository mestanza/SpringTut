package demo.repositories

import demo.models.Phone
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by luis on 9/18/15.
 */
interface PhoneRepository extends JpaRepository<Phone, Long> {

}