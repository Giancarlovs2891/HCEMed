/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saludtec.jpa;

import com.saludtec.entidades.PlanesDeTratamiento;
import java.util.List;

/**
 *
 * @author saintec
 */
public interface PlanesDeTratamientoEjb {
    
    PlanesDeTratamiento crear(PlanesDeTratamiento planTratamiento);
    
    PlanesDeTratamiento editar(PlanesDeTratamiento planTratamiento);
    
    PlanesDeTratamiento traer(Integer idTratamiento);
    
    List<PlanesDeTratamiento> listar(Integer idPaciente);
    
    List<PlanesDeTratamiento> listar(Integer idPaciente, String fecha);
    
}
