package com.roberto.pruebatecnica.persistence;

import com.roberto.pruebatecnica.exceptions.NonexistentEntityException;
import com.roberto.pruebatecnica.model.Empleado;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que se encarga de la logica de negocio y la capa de persistencia.
 * En este caso de empleados
 * 
 * los metodos que realizan cambios en la base de datos informan de si se han relaizado 
 * los cambios con exito o no y devuelven un boolean para mostrar por consola el error
 */
public class ControladoraPersistencia {

    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();

    public boolean crearEmpleado(Empleado empleado) {
        try {
            empleadoJpa.crearEmpleado(empleado);
            return true; 
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Empleado> listadoEmpleados() {
        return empleadoJpa.findEmpleadoEntities();
    }

    public Empleado buscarEmpleado(int id) {
        return empleadoJpa.findEmpleado(id);
    }

    public boolean eliminarEmpleado(int id) {
        try {
            empleadoJpa.borrarEmpleado(id);
            return true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean modificarEmpleado(Empleado empleado) {
        try {
            empleadoJpa.editarEmpleado(empleado);
             return true;
        } catch (Exception ex) {            
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
    }

}
