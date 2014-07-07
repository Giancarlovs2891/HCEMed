/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.jpa;

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
public class ExamenFisicoImpl implements ExamenFisicoEjb {

    @PersistenceContext(unitName = "HCEMedPU")
    EntityManager em;

    @Override
    public ExamenFisico crear(ExamenFisico examenFisico) {
        try {
            em.persist(examenFisico);
        } catch (Exception ex) {
            Logger.getLogger(ExamenFisico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return examenFisico;
    }

    @Override
    public ExamenFisico traer(Integer idPaciente,String fecha) {
        Query query = em.createNamedQuery("ExamenFisico.findByIdPacienteAndFecha");
        query.setParameter("fecha", fecha);
        PacientesHcemed paciente = em.find(PacientesHcemed.class, idPaciente);
        query.setParameter("idPaciente", paciente);
        List<ExamenFisico> examenFisico = query.getResultList();
        return examenFisico.get(0);
    }

    @Override
    public ExamenFisico traerUltimo(Integer idPaciente) {
        Query query = em.createNamedQuery("ExamenFisico.findByIdPaciente");
        PacientesHcemed paciente = em.find(PacientesHcemed.class, idPaciente);
        query.setParameter("idPaciente", paciente);
        List<ExamenFisico> examenFisicoList = query.getResultList();
        ExamenFisico examenFisico = null;
        if(examenFisicoList.size()>0){
            examenFisico=examenFisicoList.get(0);
        }
        return examenFisico;
    }

}
