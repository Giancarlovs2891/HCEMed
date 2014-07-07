/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.jpa;

import com.saludtec.entidades.hcemed.PacientesHcemed;
import com.saludtec.entidades.hcemed.UsuariosHcemed;
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
    public PacientesHcemed crear(PacientesHcemed paciente) {
        try {
            em.persist(paciente);
        } catch (Exception ex) {
            Logger.getLogger(PacientesHcemed.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paciente;
    }

    @Override
    public PacientesHcemed editar(PacientesHcemed paciente) {
        try {
            if (em.find(PacientesHcemed.class, paciente.getIdPaciente()) != null) {
                em.merge(paciente);
            }
        } catch (Exception ex) {
            Logger.getLogger(PacientesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paciente;
    }

    @Override
    public void eliminar(Integer idPaciente) {
        PacientesHcemed paciente;
        try {
            paciente = em.find(PacientesHcemed.class, idPaciente);
            if (paciente != null) {
                em.remove(paciente);
            }
        } catch (Exception ex) {
            Logger.getLogger(PacientesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public PacientesHcemed traer(Integer idPaciente) {
        return em.find(PacientesHcemed.class, idPaciente);
    }

    @Override
    public PacientesHcemed traer(String identificacionPaciente) {
        Query query = em.createNamedQuery("Pacientes.findByIdentificacionPaciente");
        query.setParameter("identificacionPaciente", identificacionPaciente);
        List<PacientesHcemed> paciente = query.getResultList();
        return paciente.get(0);
    }

    @Override
    public List<PacientesHcemed> listar() {
        Query query = em.createNamedQuery("Pacientes.findAll");
        return query.getResultList();
    }

    @Override
    public List<PacientesHcemed> listar(PacientesHcemed like) {
        Query query = em.createNamedQuery("Pacientes.like");
        query.setParameter("nombrePaciente", "%" + like.getNombrePaciente() + "%");
        query.setParameter("apellidoPaciente", "%" + like.getApellidoPaciente() + "%");
        query.setParameter("identificacionPaciente", "%" + like.getIdentificacionPaciente() + "%");
        return query.getResultList();
    }

    @Override
    public List<PacientesHcemed> listar(Integer idUsuario) {
        Query query = em.createNamedQuery("Pacientes.findByIdUsuario");
        UsuariosHcemed usuario = em.find(UsuariosHcemed.class, idUsuario);
        query.setParameter("idUsuario", usuario);
        return query.getResultList();
    }

}
