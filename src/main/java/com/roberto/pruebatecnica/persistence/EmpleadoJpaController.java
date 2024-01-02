
package com.roberto.pruebatecnica.persistence;

import com.roberto.pruebatecnica.exceptions.NonexistentEntityException;
import com.roberto.pruebatecnica.model.Empleado;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.NonexistentConversationException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

public class EmpleadoJpaController implements Serializable{

    public EmpleadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
     public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public EmpleadoJpaController() {
        emf = Persistence.createEntityManagerFactory("empleadoJpaPU");
    }
    
    public void crearEmpleado (Empleado empleado){
         EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(empleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void editarEmpleado (Empleado empleado) throws NonexistentConversationException, NonexistentEntityException{
         EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            empleado = em.merge(empleado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = empleado.getId();
                if (findEmpleado(id) == null) {
                    throw new NonexistentEntityException("El empleado con " + id + " no existe.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }   
    
    public void borrarEmpleado (int id) throws NonexistentConversationException, NonexistentEntityException{
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado empleado;
            try {
                empleado = em.getReference(Empleado.class, id);
                empleado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El empleado con " + id + " ya no existe", enfe);
            }
            em.remove(empleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    /**
     * Metodo que busca un empleado por su id ya que es la clave primaria
     * 
     */
    public Empleado findEmpleado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleado.class, id);
        } finally {
            em.close();
        }
    }
    
    /**
     * Este metodo se encarga de mostrar los empleados con un cargo en especifico
     *      
     */
    public List <Empleado> findEmpleadosByCargo(String cargo) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Empleado> query = em.createQuery("SELECT e FROM Empleado e WHERE e.cargo = :cargo", Empleado.class);
            query.setParameter("cargo", cargo);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    /**
     * Metodo para pasar la lista de todos los empleados guardados
     * 
     */
    public List<Empleado> findEmpleadoEntities() {
         EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleado.class));
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }   
}
