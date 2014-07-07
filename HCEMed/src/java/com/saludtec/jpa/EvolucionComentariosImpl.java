/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.jpa;

import com.saludtec.entidades.EvolucionComentarios;
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
public class EvolucionComentariosImpl implements EvolucionComentariosEjb {

    @PersistenceContext(unitName = "HCEMedPU")
    EntityManager em;

    @Override
    public EvolucionComentarios crear(EvolucionComentarios evolucionComentario) {
        try {
            em.persist(evolucionComentario);
        } catch (Exception ex) {
            Logger.getLogger(EvolucionComentarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return evolucionComentario;
    }

    @Override
    public List<EvolucionComentarios> listar(Integer idPaciente, String fecha) {
        Query query = em.createNamedQuery("EvolucionComentarios.findByIdPacienteAndFecha");
        PacientesHcemed paciente = em.find(PacientesHcemed.class, idPaciente);
        query.setParameter("idPaciente", paciente);
        query.setParameter("fecha", fecha);
        return query.getResultList();
    }

}
