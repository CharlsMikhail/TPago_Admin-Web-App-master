package com.tpago.tpago_admin.service.impl;

import com.tpago.tpago_admin.service.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OperacionServiceImpl implements OperacionService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> findOperaciones(LocalDate fecha, LocalDate fechaInicio, LocalDate fechaFin, Long idOperacion, String num_cuenta_origen) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT o.id_operacion, p.dni_persona, o.num_cuenta_origen, CONCAT(p.primer_nombre, ' ', p.segundo_nombre, ' ', p.ape_paterno, ' ', p.ape_materno) AS nombre_completo, ");
        sql.append("o.num_cuenta_destino, o.fecha_operacion ");
        sql.append("FROM operacion o ");
        sql.append("JOIN cuenta_usuario cu ON o.num_cuenta_origen = cu.num_movil ");
        sql.append("JOIN usuario u ON cu.dni_persona = u.dni_persona ");
        sql.append("JOIN persona p ON u.dni_persona = p.dni_persona ");
        sql.append("WHERE 1=1 ");

        List<Object> params = new ArrayList<>();
        if (fecha != null) {
            sql.append("AND o.fecha_operacion = ? ");
            params.add(java.sql.Date.valueOf(fecha));
        }
        if (fechaInicio != null) {
            sql.append("AND o.fecha_operacion >= ? ");
            params.add(java.sql.Date.valueOf(fechaInicio));
        }
        if (fechaFin != null) {
            sql.append("AND o.fecha_operacion <= ? ");
            params.add(java.sql.Date.valueOf(fechaFin));
        }
        if (idOperacion != null) {
            sql.append("AND o.id_operacion = ? ");
            params.add(idOperacion);
        }
        if (num_cuenta_origen != null && !num_cuenta_origen.isEmpty()) {
            sql.append("AND o.num_cuenta_origen = ? ");
            params.add(num_cuenta_origen);
        }

        return jdbcTemplate.queryForList(sql.toString(), params.toArray());
    }

}
