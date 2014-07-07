/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.jpa;

import com.saludtec.entidades.hcemed.Anamnesis;
import com.saludtec.entidades.hcemed.ExamenFisico;
import com.saludtec.entidades.hcemed.PacientesHcemed;
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
public class AnamnesisImpl implements AnamnesisEjb {

    @PersistenceContext(unitName = "HCEMedPU")
    EntityManager em;

    @Override
    public Anamnesis crear(Anamnesis anamnesis) {
        try {
            em.persist(anamnesis);
        } catch (Exception ex) {
            Logger.getLogger(ExamenFisico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return anamnesis;
    }

    @Override
    public Anamnesis traer(Integer idPaciente, String fecha) {
        Query query = em.createNamedQuery("Anamnesis.findByIdPacienteAndFecha");
        query.setParameter("fecha", fecha);
        PacientesHcemed paciente = em.find(PacientesHcemed.class, idPaciente);
        query.setParameter("idPaciente", paciente);
        List<Anamnesis> anamnesis = query.getResultList();
        return anamnesis.get(0);
    }

    @Override
    public Anamnesis traerUltimo(Integer idPaciente) {
        Query query = em.createNamedQuery("Anamnesis.findByIdPaciente");
        PacientesHcemed paciente = em.find(PacientesHcemed.class, idPaciente);
        query.setParameter("idPaciente", paciente);
        List<Anamnesis> anamnesisList = query.getResultList();
        Anamnesis anamnesis = null;
        if (anamnesisList.size()>0) {
            anamnesis = anamnesisList.get(0);
        }
        return anamnesis;
    }

}
