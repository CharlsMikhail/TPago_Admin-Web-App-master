package com.tpago.tpago_admin.controller;

import com.tpago.tpago_admin.service.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class OperacionController {

    @Autowired
    private OperacionService operacionService;

    @GetMapping("/operaciones")
    public String getOperaciones(
            @RequestParam(required = false) Long idOperacion,
            @RequestParam(required = false) LocalDate fecha,
            @RequestParam(required = false) LocalDate fechaInicio,
            @RequestParam(required = false) LocalDate fechaFin,
            @RequestParam(required = false) String num_cuenta_origen,
            Model model) {

        List<Map<String, Object>> operaciones = operacionService.findOperaciones(fecha, fechaInicio, fechaFin, idOperacion, num_cuenta_origen);
        model.addAttribute("operaciones", operaciones);

        return "operaciones";
    }



}
