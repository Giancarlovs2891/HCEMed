/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saludtec.jpa;

import com.saludtec.entidades.Galeria;
import com.saludtec.entidades.Pacientes;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author saintec
 */
@Stateless
public class GaleriaImpl implements GaleriaEjb{

   @PersistenceContext(unitName = "HCEMedPU")
    EntityManager em;

    @Override
    public Galeria crear(Galeria foto) {
        try {
            em.persist(foto);
        } catch (Exception ex) {
            Logger.getLogger(Galeria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return foto;
    }

    @Override
    public Galeria editar(Galeria foto) {
        try {
            if (em.find(Galeria.class, foto.getIdFoto()) != null) {
                em.merge(foto);
            }
        } catch (Exception ex) {
            Logger.getLogger(GaleriaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return foto;
    }

    @Override
    public void eliminar(Integer id) {
        Galeria foto;
        try {
            foto = em.find(Galeria.class, id);
            if (foto != null) {
                em.remove(foto);
            }
        } catch (Exception ex) {
            Logger.getLogger(GaleriaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Galeria traer(Integer idFoto) {
        return em.find(Galeria.class, idFoto);
    }

    @Override
    public List<Galeria> listar(Integer idPaciente) {
        Pacientes paciente = em.find(Pacientes.class, idPaciente);
        return paciente.getGaleriaList();
    }
    
}
