package com.example.repositories

import com.example.models.Role
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by luis on 10/14/15.
 */
interface RolesRepository extends JpaRepository<Role, Integer> {

}
