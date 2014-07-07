/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.jpa;

import com.saludtec.entidades.DescripcionPlanDeTratamiento;
import com.saludtec.entidades.PlanesDeTratamiento;
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
public class DescripcionPlanDeTratamientoImpl implements DescripcionPlanDeTratamientoEjb {

    @PersistenceContext(unitName = "HCEMedPU")
    EntityManager em;

    @Override
    public DescripcionPlanDeTratamiento crear(DescripcionPlanDeTratamiento descripcionPlanTratamiento) {
        try {
            em.persist(descripcionPlanTratamiento);
        } catch (Exception ex) {
            Logger.getLogger(DescripcionPlanDeTratamiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return descripcionPlanTratamiento;
    }

    @Override
    public List<DescripcionPlanDeTratamiento> listar(Integer idPlanTratamiento) {
        Query query = em.createNamedQuery("DescripcionPlanDeTratamiento.findByIdPlanTratamiento");
        PlanesDeTratamiento planTratamiento = em.find(PlanesDeTratamiento.class, idPlanTratamiento);
        query.setParameter("idPlanTratamiento", planTratamiento);
        return query.getResultList();
    }

}
