
package com.roberto.pruebatecnica.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * en este caso el id he supuesto que va a ser autogenerado en la base de datos
 * de ahi que haya un constructor sin id
 * 
 */
@Entity
public class Empleado implements Serializable {         
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private String cargo;
    private double salario;
    private LocalDateTime fechaInicio;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String cargo, LocalDateTime fechaInicio, double salario) {       
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.fechaInicio = fechaInicio;
        this.salario = salario;
    }       

    public Empleado(int id, String nombre, String apellido, String cargo, double salario, LocalDateTime fechaInicio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.salario = salario;
        this.fechaInicio = fechaInicio;
    }        
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id = " + id + " / nombre = " + nombre + " / apellido = " + apellido + " / cargo = " + cargo + " / salario = " + salario + " / fechaInicio = " + fechaInicio + '}';
    }
    
    
    
}
