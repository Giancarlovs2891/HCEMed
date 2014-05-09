/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saludtec.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author saintec
 */
@Entity
@Table(name = "PlanesDeTratamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanesDeTratamiento.findAll", query = "SELECT p FROM PlanesDeTratamiento p"),
    @NamedQuery(name = "PlanesDeTratamiento.findByIdPaciente", query = "SELECT p FROM PlanesDeTratamiento p WHERE p.idPaciente = :idPaciente ORDER BY p.idPlanDeTratamiento DESC"),
    @NamedQuery(name = "PlanesDeTratamiento.findByIdPlanDeTratamiento", query = "SELECT p FROM PlanesDeTratamiento p WHERE p.idPlanDeTratamiento = :idPlanDeTratamiento"),
    @NamedQuery(name = "PlanesDeTratamiento.findByFechaPlanTratamiento", query = "SELECT p FROM PlanesDeTratamiento p WHERE p.fechaPlanTratamiento = :fechaPlanTratamiento"),
    @NamedQuery(name = "PlanesDeTratamiento.findByImpuestoPlanTratamiento", query = "SELECT p FROM PlanesDeTratamiento p WHERE p.impuestoPlanTratamiento = :impuestoPlanTratamiento"),
    @NamedQuery(name = "PlanesDeTratamiento.findByValorPlanTratamiento", query = "SELECT p FROM PlanesDeTratamiento p WHERE p.valorPlanTratamiento = :valorPlanTratamiento"),
    @NamedQuery(name = "PlanesDeTratamiento.findByPagadoPlanTratamiento", query = "SELECT p FROM PlanesDeTratamiento p WHERE p.pagadoPlanTratamiento = :pagadoPlanTratamiento"),
    @NamedQuery(name = "PlanesDeTratamiento.findByIdUsuario", query = "SELECT p FROM PlanesDeTratamiento p WHERE p.idUsuario = :idUsuario")})
public class PlanesDeTratamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPlanDeTratamiento")
    private Integer idPlanDeTratamiento;
    @Size(max = 45)
    @Column(name = "fechaPlanTratamiento")
    private String fechaPlanTratamiento;
    @Size(max = 45)
    @Column(name = "impuestoPlanTratamiento")
    private String impuestoPlanTratamiento;
    @Size(max = 45)
    @Column(name = "valorPlanTratamiento")
    private String valorPlanTratamiento;
    @Size(max = 45)
    @Column(name = "pagadoPlanTratamiento")
    private String pagadoPlanTratamiento;
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pacientes idPaciente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlanTratamiento", fetch = FetchType.LAZY)
    private List<DescripcionPlanDeTratamiento> descripcionPlanDeTratamientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlanTratamiento", fetch = FetchType.LAZY)
    private List<Pagos> pagosList;

    public PlanesDeTratamiento() {
    }

    public PlanesDeTratamiento(Integer idPlanDeTratamiento) {
        this.idPlanDeTratamiento = idPlanDeTratamiento;
    }

    public Integer getIdPlanDeTratamiento() {
        return idPlanDeTratamiento;
    }

    public void setIdPlanDeTratamiento(Integer idPlanDeTratamiento) {
        this.idPlanDeTratamiento = idPlanDeTratamiento;
    }

    public String getFechaPlanTratamiento() {
        return fechaPlanTratamiento;
    }

    public void setFechaPlanTratamiento(String fechaPlanTratamiento) {
        this.fechaPlanTratamiento = fechaPlanTratamiento;
    }

    public String getImpuestoPlanTratamiento() {
        return impuestoPlanTratamiento;
    }

    public void setImpuestoPlanTratamiento(String impuestoPlanTratamiento) {
        this.impuestoPlanTratamiento = impuestoPlanTratamiento;
    }

    public String getValorPlanTratamiento() {
        return valorPlanTratamiento;
    }

    public void setValorPlanTratamiento(String valorPlanTratamiento) {
        this.valorPlanTratamiento = valorPlanTratamiento;
    }

    public String getPagadoPlanTratamiento() {
        return pagadoPlanTratamiento;
    }

    public void setPagadoPlanTratamiento(String pagadoPlanTratamiento) {
        this.pagadoPlanTratamiento = pagadoPlanTratamiento;
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

    @XmlTransient
    public List<DescripcionPlanDeTratamiento> getDescripcionPlanDeTratamientoList() {
        return descripcionPlanDeTratamientoList;
    }

    public void setDescripcionPlanDeTratamientoList(List<DescripcionPlanDeTratamiento> descripcionPlanDeTratamientoList) {
        this.descripcionPlanDeTratamientoList = descripcionPlanDeTratamientoList;
    }

    @XmlTransient
    public List<Pagos> getPagosList() {
        return pagosList;
    }

    public void setPagosList(List<Pagos> pagosList) {
        this.pagosList = pagosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlanDeTratamiento != null ? idPlanDeTratamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanesDeTratamiento)) {
            return false;
        }
        PlanesDeTratamiento other = (PlanesDeTratamiento) object;
        if ((this.idPlanDeTratamiento == null && other.idPlanDeTratamiento != null) || (this.idPlanDeTratamiento != null && !this.idPlanDeTratamiento.equals(other.idPlanDeTratamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.saludtec.entidades.PlanesDeTratamiento[ idPlanDeTratamiento=" + idPlanDeTratamiento + " ]";
    }
    
}
