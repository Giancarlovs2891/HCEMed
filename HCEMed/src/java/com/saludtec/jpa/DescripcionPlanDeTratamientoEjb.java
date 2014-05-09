/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.jpa;

import com.saludtec.entidades.DescripcionPlanDeTratamiento;
import java.util.List;

/**
 *
 * @author saintec
 */
public interface DescripcionPlanDeTratamientoEjb {

    DescripcionPlanDeTratamiento crear(DescripcionPlanDeTratamiento descripcionPlanTratamiento);

    List<DescripcionPlanDeTratamiento> listar(Integer idPlanTratamiento);
    
}
