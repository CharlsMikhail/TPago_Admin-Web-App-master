package com.tpago.tpago_admin.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Lógica para manejar el error
        return "error"; // nombre de la vista Thymeleaf para la página de error
    }
}
