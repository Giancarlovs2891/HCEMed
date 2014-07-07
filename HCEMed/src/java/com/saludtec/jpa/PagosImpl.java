/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.jpa;

import com.saludtec.entidades.hcemed.Pagos;
import com.saludtec.entidades.hcemed.PlanesDeTratamiento;
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
public class PagosImpl implements PagosEjb {

    @PersistenceContext(unitName = "HCEMedPU")
    EntityManager em;

    @Override
    public Pagos crear(Pagos pago) {
        try {
            em.persist(pago);
        } catch (Exception ex) {
            Logger.getLogger(PlanesDeTratamiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pago;
    }

    @Override
    public List<Pagos> listar(Integer idPlanTratamiento) {
        Query query = em.createNamedQuery("Pagos.findByIdPlanTratamiento");
        PlanesDeTratamiento planTratamiento = em.find(PlanesDeTratamiento.class, idPlanTratamiento);
        query.setParameter("idPlanTratamiento", planTratamiento);
        return query.getResultList();
    }

}
