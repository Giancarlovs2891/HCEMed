/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saludtec.jpa;

import com.saludtec.entidades.Tratamientos;
import java.util.List;

/**
 *
 * @author saintec
 */
public interface TratamientosEjb {
    
    Tratamientos crear(Tratamientos tratamiento);
    
    void eliminar(Integer idTratamiento);
    
    List<Tratamientos> listar(Integer idPaciente, String fecha);   
    
    
}
