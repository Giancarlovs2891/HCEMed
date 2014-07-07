/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saludtec.jpa;

import com.saludtec.entidades.Galeria;
import java.util.List;

/**
 *
 * @author saintec
 */
public interface GaleriaEjb {
    
    Galeria crear(Galeria foto);

    Galeria editar(Galeria foto);

    void eliminar(Integer idFoto);

    Galeria traer(Integer idFoto);

    List<Galeria> listar(Integer idPaciente);
    
    List<Galeria> lis();
    
}
