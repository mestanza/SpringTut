package com.example.repositories

import com.example.models.User
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by luis on 10/14/15.
 */
interface UsersRepository extends JpaRepository<User, Integer> {

    User findOneByUsername(String username)
}