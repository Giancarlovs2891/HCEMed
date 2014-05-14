/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.jpa;

import com.saludtec.entidades.Pacientes;
import com.saludtec.entidades.Tratamientos;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author saintec
 */
@Stateless
public class TratamientosImpl implements TratamientosEjb {

    @PersistenceContext(unitName = "HCEMedPU")
    EntityManager em;

    @Override
    public Tratamientos crear(Tratamientos tratamiento) {
        try {
            em.persist(tratamiento);
        } catch (Exception ex) {
            Logger.getLogger(Tratamientos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tratamiento;
    }

    @Override
    public void eliminar(Integer idTratamiento) {
        Tratamientos tratamiento;
        try {
            tratamiento = em.find(Tratamientos.class, idTratamiento);
            if (tratamiento != null) {
                em.remove(tratamiento);
            }
        } catch (Exception ex) {
            Logger.getLogger(GaleriaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Tratamientos traer(Integer idPaciente,String fecha) {
        Query query = em.createNamedQuery("Tratamientos.findByIdPacienteAndFecha");
        query.setParameter("fechaTratamiento", fecha);
        Pacientes paciente = em.find(Pacientes.class, idPaciente);
        query.setParameter("idPaciente", paciente);
        List<Tratamientos> tratamiento = query.getResultList();
        return tratamiento.get(tratamiento.size()-1);
    }

    @Override
    public List<Tratamientos> listar(Integer idPaciente, String fecha) {
        Query query = em.createNamedQuery("Tratamientos.findByIdPacienteAndFecha");
        Pacientes paciente = em.find(Pacientes.class, idPaciente);
        query.setParameter("idPaciente", paciente);
        query.setParameter("fechaTratamiento", fecha);
        return query.getResultList();
    }

}
