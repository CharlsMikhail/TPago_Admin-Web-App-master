// src/main/java/com/tpago/tpago_admin/controller/HomeController.java
package com.tpago.tpago_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "operaciones"; // nombre de la vista Thymeleaf
    }
}
