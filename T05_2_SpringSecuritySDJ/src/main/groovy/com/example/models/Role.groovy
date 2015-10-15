package com.example.models

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 *
 * Created by luis on 10/14/15.
 */
@Entity
public class Role implements GrantedAuthority{
    @Id
    @GeneratedValue
    Integer id

    @NotEmpty
    String authority
}
