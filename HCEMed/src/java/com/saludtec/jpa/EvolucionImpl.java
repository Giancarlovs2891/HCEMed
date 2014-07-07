/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.jpa;

import com.saludtec.entidades.Evolucion;
import com.saludtec.entidades.PacientesHcemed;
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
public class EvolucionImpl implements EvolucionEjb {

    @PersistenceContext(unitName = "HCEMedPU")
    EntityManager em;

    @Override
    public Evolucion crear(Evolucion evolucion) {
        try {
            em.persist(evolucion);
        } catch (Exception ex) {
            Logger.getLogger(Evolucion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return evolucion;
    }

    @Override
    public List<Evolucion> listar(Integer idPaciente) {
        Query query = em.createNamedQuery("Evolucion.findByIdPaciente");
        PacientesHcemed paciente = em.find(PacientesHcemed.class, idPaciente);
        query.setParameter("idPaciente", paciente);
        return query.getResultList();
    }

}
