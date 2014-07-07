/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saludtec.jpa;

import com.saludtec.entidades.hcemed.Diagnosticos;
import java.util.List;

/**
 *
 * @author saintec
 */
public interface DiagnosticosEjb {
    
    Diagnosticos crear(Diagnosticos diagnostico);
    
    List<Diagnosticos> listar(Integer idPaciente, String fecha);
    
}
