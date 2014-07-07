/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.jpa;

import com.saludtec.entidades.CirugiaPlastica;
import com.saludtec.entidades.ExamenFisico;
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
public class CirugiaPlasticaImpl implements CirugiaPlasticaEjb {

    @PersistenceContext(unitName = "HCEMedPU")
    EntityManager em;

    @Override
    public CirugiaPlastica crear(CirugiaPlastica cirugiaPlastica) {
        try {
            em.persist(cirugiaPlastica);
        } catch (Exception ex) {
            Logger.getLogger(ExamenFisico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cirugiaPlastica;
    }

    @Override
    public CirugiaPlastica traer(Integer idPaciente, String fecha) {
        Query query = em.createNamedQuery("CirugiaPlastica.findByIdPacienteAndFecha");
        query.setParameter("fecha", fecha);
        PacientesHcemed paciente = em.find(PacientesHcemed.class, idPaciente);
        query.setParameter("idPaciente", paciente);
        List<CirugiaPlastica> cirugiaPlastica = query.getResultList();
        return cirugiaPlastica.get(0);
    }

    @Override
    public CirugiaPlastica traerUltimo(Integer idPaciente) {
        Query query = em.createNamedQuery("CirugiaPlastica.findByIdPaciente");
        PacientesHcemed paciente = em.find(PacientesHcemed.class, idPaciente);
        query.setParameter("idPaciente", paciente);
        List<CirugiaPlastica> cirugiaPlasticaList = query.getResultList();
        CirugiaPlastica cirugiaPlastica = null;
        if (cirugiaPlasticaList.size() > 0) {
            cirugiaPlastica = cirugiaPlasticaList.get(0);
        }
        return cirugiaPlastica;
    }

}
