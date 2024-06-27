package com.tpago.tpago_admin.service;

import com.tpago.tpago_admin.entity.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OperacionService {
    List<Map<String, Object>> findOperaciones(LocalDate fecha, LocalDate fechaInicio, LocalDate fechaFin, Long idOperacion, String num_cuenta_origen);
}
