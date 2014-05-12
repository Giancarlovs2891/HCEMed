/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.jpa;

import com.saludtec.entidades.Usuarios;
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
    public Usuarios login(String user, String pass) {
        Query query = em.createNamedQuery("Usuarios.findByUsuarioLogin");
        query.setParameter("usuarioLogin", user);
        List<Usuarios> verificarUsuario = query.getResultList();
        Usuarios usuario = new Usuarios();
        if (verificarUsuario != null) {
            try {
                if (verificarUsuario.get(0).getContrasenaLogin().equals(EncriptacionMD5.encriptar(pass))) {
                    usuario = verificarUsuario.get(0);
                }
            } catch (Exception ex) {
                Logger.getLogger(UsuariosImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuario;
    }

    @Override
    public Usuarios traer(Integer idUsuario) {
        Query query = em.createNamedQuery("Usuarios.findByIdUsuario");
        query.setParameter("idUsuario", idUsuario);
        List<Usuarios> usuario =query.getResultList();
        return usuario.get(0);
    }

}
