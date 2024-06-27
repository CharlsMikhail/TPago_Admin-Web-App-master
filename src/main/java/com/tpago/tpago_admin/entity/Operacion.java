package com.tpago.tpago_admin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

public class Operacion {

    private Long id_operacion;
    private String numCuentaOrigen;
    private String numCuentaDestino;
    private Date fechaOperacion;
    private Integer montoOperacion;

    public Long getId_operacion() {
        return id_operacion;
    }

    public void setId_operacion(Long id_operacion) {
        this.id_operacion = id_operacion;
    }

    public String getNumCuentaOrigen() {
        return numCuentaOrigen;
    }

    public void setNumCuentaOrigen(String numCuentaOrigen) {
        this.numCuentaOrigen = numCuentaOrigen;
    }

    public String getNumCuentaDestino() {
        return numCuentaDestino;
    }

    public void setNumCuentaDestino(String numCuentaDestino) {
        this.numCuentaDestino = numCuentaDestino;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public Integer getMontoOperacion() {
        return montoOperacion;
    }

    public void setMontoOperacion(Integer montoOperacion) {
        this.montoOperacion = montoOperacion;
    }
}