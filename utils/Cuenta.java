package ar.edu.utn.frbb.tup.utils;

import java.time.LocalDateTime;

public class Cuenta {
    String nombre;
    LocalDateTime fechaCreacion;
    int balance;

    //Contructor Cuenta con parametros
    public Cuenta(String nombre, LocalDateTime fechaCreacion, int balance) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.balance = balance;
    }

    //Contructor Cuenta sin parametros
    public Cuenta() {
        this.nombre = "";
        this.fechaCreacion = LocalDateTime.now();
        this.balance = 0;
    }


    //Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public Cuenta setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Cuenta setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public int getBalance() {
        return balance;
    }

    public Cuenta setBalance(int balance) {
        this.balance = balance;
        return this;
    }
}