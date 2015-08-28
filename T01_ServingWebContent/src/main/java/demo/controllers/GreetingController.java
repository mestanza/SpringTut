/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.controllers;

import demo.models.SystemUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author luis
 */
@Controller
@RequestMapping("/greeting")
public class GreetingController {
    
    @RequestMapping
    public String index(Model model, @RequestParam(defaultValue = "World") String name) {
        model.addAttribute("name", name);
        SystemUser su = new SystemUser(1, "luis", "123");
        model.addAttribute("su", su);
        return "greeting";
    }
    
}
