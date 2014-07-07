/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.jpa;

import com.saludtec.entidades.Diagnosticos;
import com.saludtec.entidades.Pacientes;
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
public class DiagnosticosImpl implements DiagnosticosEjb {

    @PersistenceContext(unitName = "HCEMedPU")
    EntityManager em;

    @Override
    public Diagnosticos crear(Diagnosticos diagnostico) {
        try {
            em.persist(diagnostico);
        } catch (Exception ex) {
            Logger.getLogger(Diagnosticos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return diagnostico;
    }

    @Override
    public List<Diagnosticos> listar(Integer idPaciente, String fecha) {
        Query query = em.createNamedQuery("Diagnosticos.findByIdPacienteAndFecha");
        Pacientes paciente = em.find(Pacientes.class, idPaciente);
        query.setParameter("idPaciente", paciente);
        query.setParameter("fecha", fecha);
        return query.getResultList();
    }
}
