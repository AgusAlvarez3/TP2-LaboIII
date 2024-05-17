package ar.edu.utn.frbb.tup.utils;

import java.time.LocalDateTime;

public class TipoMovimiento {
    String tipoMovimiento;
    double monto;
    LocalDateTime fechaMovimiento;

    // Constructor con parametros 
    public TipoMovimiento(String tipoMovimiento, double monto, LocalDateTime fechaMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
        this.monto = monto;
        this.fechaMovimiento = fechaMovimiento;
    }

    // Constructor sin parametros 
    public TipoMovimiento() {
        this.tipoMovimiento = "";
        this.monto = 0;
        this.fechaMovimiento = LocalDateTime.now();
    }

    //Getters and Setters
    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(LocalDateTime fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }    

    

}
