/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saludtec.jpa;

import com.saludtec.entidades.UsuariosHcemed;

/**
 *
 * @author saintec
 */
public interface UsuariosEjb {
    
    UsuariosHcemed login(String user, String pass)throws Exception;
    
    UsuariosHcemed traer(Integer idUsuario);
}
