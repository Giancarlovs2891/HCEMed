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
@Table(name = "Evolucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evolucion.findAll", query = "SELECT e FROM Evolucion e"),
    @NamedQuery(name = "Evolucion.findByIdPaciente", query = "SELECT e FROM Evolucion e WHERE e.idPaciente = :idPaciente ORDER BY e.idEvolucion DESC"),
    @NamedQuery(name = "Evolucion.findByIdEvolucion", query = "SELECT e FROM Evolucion e WHERE e.idEvolucion = :idEvolucion"),
    @NamedQuery(name = "Evolucion.findByNombreModulo", query = "SELECT e FROM Evolucion e WHERE e.nombreModulo = :nombreModulo"),
    @NamedQuery(name = "Evolucion.findByFecha", query = "SELECT e FROM Evolucion e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Evolucion.findByHora", query = "SELECT e FROM Evolucion e WHERE e.hora = :hora"),
    @NamedQuery(name = "Evolucion.findByIdUsuario", query = "SELECT e FROM Evolucion e WHERE e.idUsuario = :idUsuario")})
public class Evolucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEvolucion")
    private Integer idEvolucion;
    @Size(max = 100)
    @Column(name = "nombreModulo")
    private String nombreModulo;
    @Size(max = 45)
    @Column(name = "fecha")
    private String fecha;
    @Size(max = 45)
    @Column(name = "hora")
    private String hora;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "evolucion")
    private String evolucion;
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pacientes idPaciente;

    public Evolucion() {
    }

    public Evolucion(Integer idEvolucion) {
        this.idEvolucion = idEvolucion;
    }

    public Integer getIdEvolucion() {
        return idEvolucion;
    }

    public void setIdEvolucion(Integer idEvolucion) {
        this.idEvolucion = idEvolucion;
    }

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEvolucion() {
        return evolucion;
    }

    public void setEvolucion(String evolucion) {
        this.evolucion = evolucion;
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
        hash += (idEvolucion != null ? idEvolucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evolucion)) {
            return false;
        }
        Evolucion other = (Evolucion) object;
        if ((this.idEvolucion == null && other.idEvolucion != null) || (this.idEvolucion != null && !this.idEvolucion.equals(other.idEvolucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.saludtec.entidades.Evolucion[ idEvolucion=" + idEvolucion + " ]";
    }

}
