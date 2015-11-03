package com.example.controllers

import com.example.models.User
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by luis on 11/2/15.
 */
@RestController
class LoginController {

    @RequestMapping('session-user')
    User getSessionUser(@AuthenticationPrincipal User user) {
        user
    }
}
