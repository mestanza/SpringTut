package demo.repositories

import demo.models.Address
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by luis on 9/17/15.
 */
interface AddressRepository extends JpaRepository<Address, Long> {
}
