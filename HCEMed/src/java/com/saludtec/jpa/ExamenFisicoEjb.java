/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.jpa;

import com.saludtec.entidades.ExamenFisico;

/**
 *
 * @author saintec
 */
public interface ExamenFisicoEjb {

    ExamenFisico crear(ExamenFisico examenFisico);

    ExamenFisico traer(Integer idPaciente, String fecha);

    ExamenFisico traerUltimo(Integer idPaciente);

}
