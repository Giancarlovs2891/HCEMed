/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saludtec.db;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author saludtec
 */
@Stateless
public class HCEMedSqlDb {
    
    @PersistenceContext(unitName = "HCEMedPU")
    EntityManager em;
 
    
    public String crear(String sql, String tabla) {
        String respeuesta = tabla + " creada";
        Query query = em.createNativeQuery(sql);
        query.executeUpdate();
        return respeuesta;
    }       
    
}
