/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.jpa;

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
 * @author saludtec
 */
@Stateless
public class PacientesImpl implements PacientesEjb {

    @PersistenceContext(unitName = "HCEMedPU")
    EntityManager em;

    @Override
    public Pacientes crear(Pacientes paciente) {
        try {
            em.persist(paciente);
        } catch (Exception ex) {
            Logger.getLogger(Pacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paciente;
    }

    @Override
    public Pacientes editar(Pacientes paciente) {
        try {
            if (em.find(Pacientes.class, paciente.getIdPaciente()) != null) {
                em.merge(paciente);
            }
        } catch (Exception ex) {
            Logger.getLogger(PacientesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paciente;
    }

    @Override
    public void eliminar(Integer id) {
        Pacientes paciente;
        try {
            paciente = em.find(Pacientes.class, id);
            if (paciente != null) {
                em.remove(paciente);
            }
        } catch (Exception ex) {
            Logger.getLogger(PacientesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Pacientes traerPacientes(Integer id) {
        return em.find(Pacientes.class, id);
    }

    @Override
    public List<Pacientes> listarPacientes() {
        Query query = em.createNamedQuery("Pacientes.findAll");
        return query.getResultList();
    }

    @Override
    public List<Pacientes> listarPacientes(Pacientes like) {
        Query query =  em.createNamedQuery("Pacientes.like");
        query.setParameter("nombrePaciente", like.getNombrePaciente());
        query.setParameter("apellidoPaciente", like.getApellidoPaciente());
        query.setParameter("identificacionPaciente", like.getIdentificacionPaciente());
        return query.getResultList();
    }

}
