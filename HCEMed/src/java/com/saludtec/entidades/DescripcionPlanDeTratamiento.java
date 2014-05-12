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
@Table(name = "descripcionPlanDeTratamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescripcionPlanDeTratamiento.findAll", query = "SELECT d FROM DescripcionPlanDeTratamiento d"),
    @NamedQuery(name = "DescripcionPlanDeTratamiento.findByIdPlanTratamiento", query = "SELECT d FROM DescripcionPlanDeTratamiento d WHERE d.idPlanTratamiento = :idPlanTratamiento ORDER BY d.idDescripcionPlanTratamiento ASC"),
    @NamedQuery(name = "DescripcionPlanDeTratamiento.findByIdDescripcionPlanTratamiento", query = "SELECT d FROM DescripcionPlanDeTratamiento d WHERE d.idDescripcionPlanTratamiento = :idDescripcionPlanTratamiento"),
    @NamedQuery(name = "DescripcionPlanDeTratamiento.findByValorDescripcionPlanTratamiento", query = "SELECT d FROM DescripcionPlanDeTratamiento d WHERE d.valorDescripcionPlanTratamiento = :valorDescripcionPlanTratamiento"),
    @NamedQuery(name = "DescripcionPlanDeTratamiento.findByIdUsuario", query = "SELECT d FROM DescripcionPlanDeTratamiento d WHERE d.idUsuario = :idUsuario")})
public class DescripcionPlanDeTratamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDescripcionPlanTratamiento")
    private Integer idDescripcionPlanTratamiento;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "textoDescripcionPlanTratamiento")
    private String textoDescripcionPlanTratamiento;
    @Size(max = 45)
    @Column(name = "valorDescripcionPlanTratamiento")
    private String valorDescripcionPlanTratamiento;
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @JoinColumn(name = "idPlanTratamiento", referencedColumnName = "idPlanDeTratamiento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PlanesDeTratamiento idPlanTratamiento;

    public DescripcionPlanDeTratamiento() {
    }

    public DescripcionPlanDeTratamiento(Integer idDescripcionPlanTratamiento) {
        this.idDescripcionPlanTratamiento = idDescripcionPlanTratamiento;
    }

    public Integer getIdDescripcionPlanTratamiento() {
        return idDescripcionPlanTratamiento;
    }

    public void setIdDescripcionPlanTratamiento(Integer idDescripcionPlanTratamiento) {
        this.idDescripcionPlanTratamiento = idDescripcionPlanTratamiento;
    }

    public String getTextoDescripcionPlanTratamiento() {
        return textoDescripcionPlanTratamiento;
    }

    public void setTextoDescripcionPlanTratamiento(String textoDescripcionPlanTratamiento) {
        this.textoDescripcionPlanTratamiento = textoDescripcionPlanTratamiento;
    }

    public String getValorDescripcionPlanTratamiento() {
        return valorDescripcionPlanTratamiento;
    }

    public void setValorDescripcionPlanTratamiento(String valorDescripcionPlanTratamiento) {
        this.valorDescripcionPlanTratamiento = valorDescripcionPlanTratamiento;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public PlanesDeTratamiento getIdPlanTratamiento() {
        return idPlanTratamiento;
    }

    public void setIdPlanTratamiento(PlanesDeTratamiento idPlanTratamiento) {
        this.idPlanTratamiento = idPlanTratamiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDescripcionPlanTratamiento != null ? idDescripcionPlanTratamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescripcionPlanDeTratamiento)) {
            return false;
        }
        DescripcionPlanDeTratamiento other = (DescripcionPlanDeTratamiento) object;
        if ((this.idDescripcionPlanTratamiento == null && other.idDescripcionPlanTratamiento != null) || (this.idDescripcionPlanTratamiento != null && !this.idDescripcionPlanTratamiento.equals(other.idDescripcionPlanTratamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.saludtec.entidades.DescripcionPlanDeTratamiento[ idDescripcionPlanTratamiento=" + idDescripcionPlanTratamiento + " ]";
    }
    
}
