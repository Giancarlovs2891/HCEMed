/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.jpa;

import com.saludtec.entidades.CirugiaPlastica;

/**
 *
 * @author saintec
 */
public interface CirugiaPlasticaEjb {

    CirugiaPlastica crear(CirugiaPlastica cirugiaPlastica);

    CirugiaPlastica traer(Integer idPaciente, String fecha);

    CirugiaPlastica traerUltimo(Integer idPaciente);

}
