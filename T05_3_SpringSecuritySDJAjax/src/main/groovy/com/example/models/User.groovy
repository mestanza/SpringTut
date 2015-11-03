package com.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by luis on 10/14/15.
 */
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue
    Integer id

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Collection<Role> authorities

    @NotEmpty
    @JsonIgnore
    String password

    @NotEmpty
    String username

    boolean accountNonExpired = true
    boolean accountNonLocked = true
    boolean credentialsNonExpired = true
    boolean enabled = true
}
