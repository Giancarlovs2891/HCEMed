/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.jpa;

import com.saludtec.entidades.hcemed.Anamnesis;

/**
 *
 * @author saintec
 */
public interface AnamnesisEjb {

    Anamnesis crear(Anamnesis anamnesis);

    Anamnesis traer(Integer idPaciente, String fecha);

    Anamnesis traerUltimo(Integer idPaciente);

}
