/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.jpa;

import com.saludtec.entidades.hcemed.PacientesHcemed;
import com.saludtec.entidades.hcemed.PlanesDeTratamiento;
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
public class PlanesDeTratamientoImpl implements PlanesDeTratamientoEjb {

    @PersistenceContext(unitName = "HCEMedPU")
    EntityManager em;

    @Override
    public PlanesDeTratamiento crear(PlanesDeTratamiento planTratamiento) {
        try {
            em.persist(planTratamiento);
        } catch (Exception ex) {
            Logger.getLogger(PlanesDeTratamiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return planTratamiento;
    }

    @Override
    public PlanesDeTratamiento editar(PlanesDeTratamiento planTratamiento) {
        try {
            if (em.find(PlanesDeTratamiento.class, planTratamiento.getIdPlanDeTratamiento()) != null) {
                em.merge(planTratamiento);
            }
        } catch (Exception ex) {
            Logger.getLogger(PacientesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return planTratamiento;
    }

    @Override
    public PlanesDeTratamiento traer(Integer idTratamiento) {
        return em.find(PlanesDeTratamiento.class, idTratamiento);
    }

    @Override
    public List<PlanesDeTratamiento> listar(Integer idPaciente) {
        Query query = em.createNamedQuery("PlanesDeTratamiento.findByIdPaciente");
        PacientesHcemed paciente = em.find(PacientesHcemed.class, idPaciente);
        query.setParameter("idPaciente", paciente);
        return query.getResultList();
    }
    
    @Override
    public List<PlanesDeTratamiento> listar(Integer idPaciente, String fecha) {
        Query query = em.createNamedQuery("PlanesDeTratamiento.findByIdPacienteAndFecha");
        PacientesHcemed paciente = em.find(PacientesHcemed.class, idPaciente);
        query.setParameter("idPaciente", paciente);
        query.setParameter("fecha", fecha);
        return query.getResultList();
    }

}
