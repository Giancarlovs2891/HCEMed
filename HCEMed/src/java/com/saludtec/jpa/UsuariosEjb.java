/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saludtec.jpa;

import com.saludtec.entidades.Usuarios;

/**
 *
 * @author saintec
 */
public interface UsuariosEjb {
    
    Usuarios login(String user, String pass);
    
    Usuarios traer(Integer idUsuario);
}
