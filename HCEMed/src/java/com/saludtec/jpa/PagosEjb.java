/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saludtec.jpa;

import com.saludtec.entidades.Pagos;
import java.util.List;

/**
 *
 * @author saintec
 */
public interface PagosEjb {
    
    Pagos crear(Pagos pago);
    
    List<Pagos> listar(Integer idPlanTratamiento);
}
