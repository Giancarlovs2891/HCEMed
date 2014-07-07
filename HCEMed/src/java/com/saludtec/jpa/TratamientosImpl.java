package com.saludtec.jpa;

import com.saludtec.entidades.PacientesHcemed;
import com.saludtec.entidades.TratamientosHcemed;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author saintec
 */
@Stateless
public class TratamientosImpl implements TratamientosEjb {

    @PersistenceContext(unitName = "HCEMedPU")
    EntityManager em;

    @Override
    public TratamientosHcemed crear(TratamientosHcemed tratamiento) {
        try {
            em.persist(tratamiento);
        } catch (Exception ex) {
            Logger.getLogger(TratamientosHcemed.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tratamiento;
    }

    @Override
    public void eliminar(Integer idTratamiento) {
        TratamientosHcemed tratamiento;
        try {
            tratamiento = em.find(TratamientosHcemed.class, idTratamiento);
            if (tratamiento != null) {
                em.remove(tratamiento);
            }
        } catch (Exception ex) {
            Logger.getLogger(GaleriaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public TratamientosHcemed traer(Integer idPaciente,String fecha) {
        Query query = em.createNamedQuery("Tratamientos.findByIdPacienteAndFecha");
        query.setParameter("fechaTratamiento", fecha);
        PacientesHcemed paciente = em.find(PacientesHcemed.class, idPaciente);
        query.setParameter("idPaciente", paciente);
        List<TratamientosHcemed> tratamiento = query.getResultList();
        return tratamiento.get(tratamiento.size()-1);
    }

    @Override
    public List<TratamientosHcemed> listar(Integer idPaciente, String fecha) {
        Query query = em.createNamedQuery("Tratamientos.findByIdPacienteAndFecha");
        PacientesHcemed paciente = em.find(PacientesHcemed.class, idPaciente);
        query.setParameter("idPaciente", paciente);
        query.setParameter("fechaTratamiento", fecha);
        return query.getResultList();
    }

}
