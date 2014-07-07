/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saludtec.jpa;

import com.saludtec.entidades.hcemed.EvolucionComentarios;
import java.util.List;

/**
 *
 * @author saintec
 */
public interface EvolucionComentariosEjb {
    
    EvolucionComentarios crear (EvolucionComentarios evolucionComentario);
    
    List<EvolucionComentarios> listar(Integer idPaciente, String fecha);    
    
}
