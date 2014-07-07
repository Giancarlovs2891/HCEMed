/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.jpa;

import com.saludtec.entidades.TratamientosHcemed;
import java.util.List;

/**
 *
 * @author saintec
 */
public interface TratamientosEjb {

    TratamientosHcemed crear(TratamientosHcemed tratamiento);

    void eliminar(Integer idTratamiento);

    TratamientosHcemed traer(Integer idPaciente, String fecha);

    List<TratamientosHcemed> listar(Integer idPaciente, String fecha);

}
