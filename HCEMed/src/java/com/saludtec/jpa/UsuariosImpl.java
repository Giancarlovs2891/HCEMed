/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.jpa;

import com.saludtec.entidades.hcemed.UsuariosHcemed;
import com.saludtec.utilidades.EncriptacionMD5;
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
public class UsuariosImpl implements UsuariosEjb {

    @PersistenceContext(unitName = "HCEMedPU")
    EntityManager em;

    @Override
    public UsuariosHcemed login(String user, String pass) throws Exception{
        Query query = em.createNamedQuery("Usuarios.findByLogin");
        query.setParameter("usuarioLogin", user);
        query.setParameter("contrasenaLogin", EncriptacionMD5.encriptar(pass));
        List<UsuariosHcemed> usuario = query.getResultList();
        return usuario.get(0);
    }

    @Override
    public UsuariosHcemed traer(Integer idUsuario) {
        return em.find(UsuariosHcemed.class, idUsuario);
    }

}
