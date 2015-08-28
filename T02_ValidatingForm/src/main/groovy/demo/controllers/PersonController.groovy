package demo.controllers

import demo.models.Person
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import javax.validation.Valid

/**
 *
 * Created by luis on 8/25/15.
 */
@Controller
@RequestMapping('/persons')
class PersonController {
    @RequestMapping("/form")
    public String showForm(Person person) {
        "form"
    }

    @RequestMapping(value="/form", method=RequestMethod.POST)
    public String checkPersonInfo(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form"
        }
        "results"
    }
}
