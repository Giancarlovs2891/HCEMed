/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saludtec.jpa;

import com.saludtec.entidades.hcemed.Evolucion;
import java.util.List;

/**
 *
 * @author saintec
 */
public interface EvolucionEjb {
    
    Evolucion crear(Evolucion evolucion);
    
    List<Evolucion> listar(Integer idPaciente);
    
}
