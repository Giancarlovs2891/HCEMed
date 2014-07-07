/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.jpa;

import com.saludtec.entidades.PacientesHcemed;
import java.util.List;

/**
 *
 * @author saintec
 */
public interface PacientesEjb {

    PacientesHcemed crear(PacientesHcemed paciente);

    PacientesHcemed editar(PacientesHcemed paciente);

    void eliminar(Integer idPaciente);

    PacientesHcemed traer(Integer idPaciente);
    
    PacientesHcemed traer(String identificacionPaciente);

    List<PacientesHcemed> listar();

    List<PacientesHcemed> listar(PacientesHcemed like);
    
    List<PacientesHcemed> listar(Integer idUsuario);

}
