/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saludtec.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author saintec
 */
@Entity
@Table(name = "Tratamientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tratamientos.findAll", query = "SELECT t FROM Tratamientos t"),
    @NamedQuery(name = "Tratamientos.findByIdTratamiento", query = "SELECT t FROM Tratamientos t WHERE t.idTratamiento = :idTratamiento"),
    @NamedQuery(name = "Tratamientos.findByFechaTratamiento", query = "SELECT t FROM Tratamientos t WHERE t.fechaTratamiento = :fechaTratamiento"),
    @NamedQuery(name = "Tratamientos.findByHoraTratamiento", query = "SELECT t FROM Tratamientos t WHERE t.horaTratamiento = :horaTratamiento"),
    @NamedQuery(name = "Tratamientos.findByIdUsuario", query = "SELECT t FROM Tratamientos t WHERE t.idUsuario = :idUsuario"),
    @NamedQuery(name = "Tratamientos.findByIdPacienteAndFecha", query = "SELECT t FROM Tratamientos t WHERE t.idPaciente = :idPaciente AND t.fechaTratamiento = :fechaTratamiento ORDER BY t.idTratamiento ASC")})
public class Tratamientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTratamiento")
    private Integer idTratamiento;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "desTratamiento")
    private String desTratamiento;
    @Size(max = 45)
    @Column(name = "fechaTratamiento")
    private String fechaTratamiento;
    @Size(max = 45)
    @Column(name = "horaTratamiento")
    private String horaTratamiento;
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pacientes idPaciente;

    public Tratamientos() {
    }

    public Tratamientos(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public Integer getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getDesTratamiento() {
        return desTratamiento;
    }

    public void setDesTratamiento(String desTratamiento) {
        this.desTratamiento = desTratamiento;
    }

    public String getFechaTratamiento() {
        return fechaTratamiento;
    }

    public void setFechaTratamiento(String fechaTratamiento) {
        this.fechaTratamiento = fechaTratamiento;
    }

    public String getHoraTratamiento() {
        return horaTratamiento;
    }

    public void setHoraTratamiento(String horaTratamiento) {
        this.horaTratamiento = horaTratamiento;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Pacientes getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Pacientes idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTratamiento != null ? idTratamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tratamientos)) {
            return false;
        }
        Tratamientos other = (Tratamientos) object;
        if ((this.idTratamiento == null && other.idTratamiento != null) || (this.idTratamiento != null && !this.idTratamiento.equals(other.idTratamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.saludtec.entidades.Tratamientos[ idTratamiento=" + idTratamiento + " ]";
    }
    
}
