/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.entidades.hcemed;

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
@Table(name = "EvolucionComentarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvolucionComentarios.findAll", query = "SELECT e FROM EvolucionComentarios e"),
    @NamedQuery(name = "EvolucionComentarios.findByIdEvolucionComentario", query = "SELECT e FROM EvolucionComentarios e WHERE e.idEvolucionComentario = :idEvolucionComentario"),
    @NamedQuery(name = "EvolucionComentarios.findByFecha", query = "SELECT e FROM EvolucionComentarios e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "EvolucionComentarios.findByHora", query = "SELECT e FROM EvolucionComentarios e WHERE e.hora = :hora"),
    @NamedQuery(name = "EvolucionComentarios.findByIdUsuario", query = "SELECT e FROM EvolucionComentarios e WHERE e.idUsuario = :idUsuario"),
    @NamedQuery(name = "EvolucionComentarios.findByIdPacienteAndFecha", query = "SELECT e FROM EvolucionComentarios e WHERE e.idPaciente = :idPaciente AND e.fecha = :fecha ORDER BY e.idEvolucionComentario DESC")})
public class EvolucionComentarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEvolucionComentario")
    private Integer idEvolucionComentario;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "firma")
    private String firma;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentario")
    private String comentario;
    @Size(max = 45)
    @Column(name = "fecha")
    private String fecha;
    @Size(max = 45)
    @Column(name = "hora")
    private String hora;
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    @ManyToOne(fetch = FetchType.LAZY)
    private PacientesHcemed idPaciente;

    public EvolucionComentarios() {
    }

    public EvolucionComentarios(Integer idEvolucionComentario) {
        this.idEvolucionComentario = idEvolucionComentario;
    }

    public Integer getIdEvolucionComentario() {
        return idEvolucionComentario;
    }

    public void setIdEvolucionComentario(Integer idEvolucionComentario) {
        this.idEvolucionComentario = idEvolucionComentario;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public PacientesHcemed getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(PacientesHcemed idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvolucionComentario != null ? idEvolucionComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvolucionComentarios)) {
            return false;
        }
        EvolucionComentarios other = (EvolucionComentarios) object;
        if ((this.idEvolucionComentario == null && other.idEvolucionComentario != null) || (this.idEvolucionComentario != null && !this.idEvolucionComentario.equals(other.idEvolucionComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.saludtec.entidades.EvolucionComentarios[ idEvolucionComentario=" + idEvolucionComentario + " ]";
    }

}
