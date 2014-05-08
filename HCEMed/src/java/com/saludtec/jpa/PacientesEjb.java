/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.jpa;

import com.saludtec.entidades.Pacientes;
import java.util.List;

/**
 *
 * @author saintec
 */
public interface PacientesEjb {

    Pacientes crear(Pacientes paciente);

    Pacientes editar(Pacientes paciente);

    void eliminar(Integer id);

    Pacientes traerPacientes(Integer id);

    List<Pacientes> traerPacientes();

    List<Pacientes> traerPacientes(Pacientes like);

}
