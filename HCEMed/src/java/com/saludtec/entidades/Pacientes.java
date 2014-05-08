/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saludtec.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "Pacientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p"),
    @NamedQuery(name = "Pacientes.findByIdPaciente", query = "SELECT p FROM Pacientes p WHERE p.idPaciente = :idPaciente"),
    @NamedQuery(name = "Pacientes.findByNombrePaciente", query = "SELECT p FROM Pacientes p WHERE p.nombrePaciente = :nombrePaciente"),
    @NamedQuery(name = "Pacientes.findByApellidoPaciente", query = "SELECT p FROM Pacientes p WHERE p.apellidoPaciente = :apellidoPaciente"),
    @NamedQuery(name = "Pacientes.findByFechaNacimientoPaciente", query = "SELECT p FROM Pacientes p WHERE p.fechaNacimientoPaciente = :fechaNacimientoPaciente"),
    @NamedQuery(name = "Pacientes.findByTipoIdentificacionPaciente", query = "SELECT p FROM Pacientes p WHERE p.tipoIdentificacionPaciente = :tipoIdentificacionPaciente"),
    @NamedQuery(name = "Pacientes.findByIdentificacionPaciente", query = "SELECT p FROM Pacientes p WHERE p.identificacionPaciente = :identificacionPaciente"),
    @NamedQuery(name = "Pacientes.findByEstadoPaciente", query = "SELECT p FROM Pacientes p WHERE p.estadoPaciente = :estadoPaciente"),
    @NamedQuery(name = "Pacientes.findByEstadoCivilPaciente", query = "SELECT p FROM Pacientes p WHERE p.estadoCivilPaciente = :estadoCivilPaciente"),
    @NamedQuery(name = "Pacientes.findBySexoPaciente", query = "SELECT p FROM Pacientes p WHERE p.sexoPaciente = :sexoPaciente"),
    @NamedQuery(name = "Pacientes.findByRazaPaciente", query = "SELECT p FROM Pacientes p WHERE p.razaPaciente = :razaPaciente"),
    @NamedQuery(name = "Pacientes.findByOcupacionPaciente", query = "SELECT p FROM Pacientes p WHERE p.ocupacionPaciente = :ocupacionPaciente"),
    @NamedQuery(name = "Pacientes.findByTelefonoPaciente", query = "SELECT p FROM Pacientes p WHERE p.telefonoPaciente = :telefonoPaciente"),
    @NamedQuery(name = "Pacientes.findByCelularPaciente", query = "SELECT p FROM Pacientes p WHERE p.celularPaciente = :celularPaciente"),
    @NamedQuery(name = "Pacientes.findByEmailPaciente", query = "SELECT p FROM Pacientes p WHERE p.emailPaciente = :emailPaciente"),
    @NamedQuery(name = "Pacientes.findByPaisPaciente", query = "SELECT p FROM Pacientes p WHERE p.paisPaciente = :paisPaciente"),
    @NamedQuery(name = "Pacientes.findByDepartamentoPaciente", query = "SELECT p FROM Pacientes p WHERE p.departamentoPaciente = :departamentoPaciente"),
    @NamedQuery(name = "Pacientes.findByCiudadPaciente", query = "SELECT p FROM Pacientes p WHERE p.ciudadPaciente = :ciudadPaciente"),
    @NamedQuery(name = "Pacientes.findByNacionalidadPaciente", query = "SELECT p FROM Pacientes p WHERE p.nacionalidadPaciente = :nacionalidadPaciente"),
    @NamedQuery(name = "Pacientes.findByDireccionPaciente", query = "SELECT p FROM Pacientes p WHERE p.direccionPaciente = :direccionPaciente"),
    @NamedQuery(name = "Pacientes.findByZonaResidencialPaciente", query = "SELECT p FROM Pacientes p WHERE p.zonaResidencialPaciente = :zonaResidencialPaciente"),
    @NamedQuery(name = "Pacientes.findByCodigoPostalPaciente", query = "SELECT p FROM Pacientes p WHERE p.codigoPostalPaciente = :codigoPostalPaciente"),
    @NamedQuery(name = "Pacientes.findByEstratoPaciente", query = "SELECT p FROM Pacientes p WHERE p.estratoPaciente = :estratoPaciente"),
    @NamedQuery(name = "Pacientes.findByCompaniaSeguroPaciente", query = "SELECT p FROM Pacientes p WHERE p.companiaSeguroPaciente = :companiaSeguroPaciente"),
    @NamedQuery(name = "Pacientes.findByTipoVinculacionPaciente", query = "SELECT p FROM Pacientes p WHERE p.tipoVinculacionPaciente = :tipoVinculacionPaciente"),
    @NamedQuery(name = "Pacientes.findByNombreRepresentante", query = "SELECT p FROM Pacientes p WHERE p.nombreRepresentante = :nombreRepresentante"),
    @NamedQuery(name = "Pacientes.findByApellidoRepresentante", query = "SELECT p FROM Pacientes p WHERE p.apellidoRepresentante = :apellidoRepresentante"),
    @NamedQuery(name = "Pacientes.findByTipoIdentificacionRepresentante", query = "SELECT p FROM Pacientes p WHERE p.tipoIdentificacionRepresentante = :tipoIdentificacionRepresentante"),
    @NamedQuery(name = "Pacientes.findByIdentificacionRepresentante", query = "SELECT p FROM Pacientes p WHERE p.identificacionRepresentante = :identificacionRepresentante"),
    @NamedQuery(name = "Pacientes.findByTelefonoRepresentante", query = "SELECT p FROM Pacientes p WHERE p.telefonoRepresentante = :telefonoRepresentante"),
    @NamedQuery(name = "Pacientes.findByParentescoRepresentante", query = "SELECT p FROM Pacientes p WHERE p.parentescoRepresentante = :parentescoRepresentante"),
    @NamedQuery(name = "Pacientes.findByNombreEmergencia", query = "SELECT p FROM Pacientes p WHERE p.nombreEmergencia = :nombreEmergencia"),
    @NamedQuery(name = "Pacientes.findByTelefonoEmergencia", query = "SELECT p FROM Pacientes p WHERE p.telefonoEmergencia = :telefonoEmergencia"),
    @NamedQuery(name = "Pacientes.findByParentescoEmergencia", query = "SELECT p FROM Pacientes p WHERE p.parentescoEmergencia = :parentescoEmergencia"),
    @NamedQuery(name = "Pacientes.findByNombreReferido", query = "SELECT p FROM Pacientes p WHERE p.nombreReferido = :nombreReferido"),
    @NamedQuery(name = "Pacientes.findByFechaCreacion", query = "SELECT p FROM Pacientes p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Pacientes.findByHoraCreacion", query = "SELECT p FROM Pacientes p WHERE p.horaCreacion = :horaCreacion"),
    @NamedQuery(name = "Pacientes.findByIdUsuario", query = "SELECT p FROM Pacientes p WHERE p.idUsuario = :idUsuario")})
public class Pacientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPaciente")
    private Integer idPaciente;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "alertaMedica")
    private String alertaMedica;
    @Size(max = 100)
    @Column(name = "nombrePaciente")
    private String nombrePaciente;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "foto")
    private String foto;
    @Size(max = 100)
    @Column(name = "apellidoPaciente")
    private String apellidoPaciente;
    @Size(max = 45)
    @Column(name = "fechaNacimientoPaciente")
    private String fechaNacimientoPaciente;
    @Size(max = 45)
    @Column(name = "tipoIdentificacionPaciente")
    private String tipoIdentificacionPaciente;
    @Size(max = 45)
    @Column(name = "identificacionPaciente")
    private String identificacionPaciente;
    @Size(max = 45)
    @Column(name = "estadoPaciente")
    private String estadoPaciente;
    @Size(max = 45)
    @Column(name = "estadoCivilPaciente")
    private String estadoCivilPaciente;
    @Size(max = 45)
    @Column(name = "sexoPaciente")
    private String sexoPaciente;
    @Size(max = 45)
    @Column(name = "razaPaciente")
    private String razaPaciente;
    @Size(max = 45)
    @Column(name = "ocupacionPaciente")
    private String ocupacionPaciente;
    @Size(max = 45)
    @Column(name = "telefonoPaciente")
    private String telefonoPaciente;
    @Size(max = 45)
    @Column(name = "celularPaciente")
    private String celularPaciente;
    @Size(max = 100)
    @Column(name = "emailPaciente")
    private String emailPaciente;
    @Size(max = 100)
    @Column(name = "paisPaciente")
    private String paisPaciente;
    @Size(max = 100)
    @Column(name = "departamentoPaciente")
    private String departamentoPaciente;
    @Size(max = 100)
    @Column(name = "ciudadPaciente")
    private String ciudadPaciente;
    @Size(max = 100)
    @Column(name = "nacionalidadPaciente")
    private String nacionalidadPaciente;
    @Size(max = 100)
    @Column(name = "direccionPaciente")
    private String direccionPaciente;
    @Size(max = 45)
    @Column(name = "zonaResidencialPaciente")
    private String zonaResidencialPaciente;
    @Size(max = 45)
    @Column(name = "codigoPostalPaciente")
    private String codigoPostalPaciente;
    @Size(max = 45)
    @Column(name = "estratoPaciente")
    private String estratoPaciente;
    @Size(max = 45)
    @Column(name = "companiaSeguroPaciente")
    private String companiaSeguroPaciente;
    @Size(max = 45)
    @Column(name = "tipoVinculacionPaciente")
    private String tipoVinculacionPaciente;
    @Size(max = 100)
    @Column(name = "nombreRepresentante")
    private String nombreRepresentante;
    @Size(max = 45)
    @Column(name = "apellidoRepresentante")
    private String apellidoRepresentante;
    @Size(max = 45)
    @Column(name = "tipoIdentificacionRepresentante")
    private String tipoIdentificacionRepresentante;
    @Size(max = 45)
    @Column(name = "identificacionRepresentante")
    private String identificacionRepresentante;
    @Size(max = 45)
    @Column(name = "telefonoRepresentante")
    private String telefonoRepresentante;
    @Size(max = 45)
    @Column(name = "parentescoRepresentante")
    private String parentescoRepresentante;
    @Size(max = 150)
    @Column(name = "nombreEmergencia")
    private String nombreEmergencia;
    @Size(max = 45)
    @Column(name = "telefonoEmergencia")
    private String telefonoEmergencia;
    @Size(max = 45)
    @Column(name = "parentescoEmergencia")
    private String parentescoEmergencia;
    @Size(max = 150)
    @Column(name = "nombreReferido")
    private String nombreReferido;
    @Size(max = 45)
    @Column(name = "fechaCreacion")
    private String fechaCreacion;
    @Size(max = 45)
    @Column(name = "horaCreacion")
    private String horaCreacion;
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @OneToMany(mappedBy = "idPaciente", fetch = FetchType.LAZY)
    private List<ExamenFisico> examenFisicoList;
    @OneToMany(mappedBy = "idPaciente", fetch = FetchType.LAZY)
    private List<CirugiaPlastica> cirugiaPlasticaList;
    @OneToMany(mappedBy = "idPaciente", fetch = FetchType.LAZY)
    private List<Anamnesis> anamnesisList;

    public Pacientes() {
    }

    public Pacientes(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getAlertaMedica() {
        return alertaMedica;
    }

    public void setAlertaMedica(String alertaMedica) {
        this.alertaMedica = alertaMedica;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getApellidoPaciente() {
        return apellidoPaciente;
    }

    public void setApellidoPaciente(String apellidoPaciente) {
        this.apellidoPaciente = apellidoPaciente;
    }

    public String getFechaNacimientoPaciente() {
        return fechaNacimientoPaciente;
    }

    public void setFechaNacimientoPaciente(String fechaNacimientoPaciente) {
        this.fechaNacimientoPaciente = fechaNacimientoPaciente;
    }

    public String getTipoIdentificacionPaciente() {
        return tipoIdentificacionPaciente;
    }

    public void setTipoIdentificacionPaciente(String tipoIdentificacionPaciente) {
        this.tipoIdentificacionPaciente = tipoIdentificacionPaciente;
    }

    public String getIdentificacionPaciente() {
        return identificacionPaciente;
    }

    public void setIdentificacionPaciente(String identificacionPaciente) {
        this.identificacionPaciente = identificacionPaciente;
    }

    public String getEstadoPaciente() {
        return estadoPaciente;
    }

    public void setEstadoPaciente(String estadoPaciente) {
        this.estadoPaciente = estadoPaciente;
    }

    public String getEstadoCivilPaciente() {
        return estadoCivilPaciente;
    }

    public void setEstadoCivilPaciente(String estadoCivilPaciente) {
        this.estadoCivilPaciente = estadoCivilPaciente;
    }

    public String getSexoPaciente() {
        return sexoPaciente;
    }

    public void setSexoPaciente(String sexoPaciente) {
        this.sexoPaciente = sexoPaciente;
    }

    public String getRazaPaciente() {
        return razaPaciente;
    }

    public void setRazaPaciente(String razaPaciente) {
        this.razaPaciente = razaPaciente;
    }

    public String getOcupacionPaciente() {
        return ocupacionPaciente;
    }

    public void setOcupacionPaciente(String ocupacionPaciente) {
        this.ocupacionPaciente = ocupacionPaciente;
    }

    public String getTelefonoPaciente() {
        return telefonoPaciente;
    }

    public void setTelefonoPaciente(String telefonoPaciente) {
        this.telefonoPaciente = telefonoPaciente;
    }

    public String getCelularPaciente() {
        return celularPaciente;
    }

    public void setCelularPaciente(String celularPaciente) {
        this.celularPaciente = celularPaciente;
    }

    public String getEmailPaciente() {
        return emailPaciente;
    }

    public void setEmailPaciente(String emailPaciente) {
        this.emailPaciente = emailPaciente;
    }

    public String getPaisPaciente() {
        return paisPaciente;
    }

    public void setPaisPaciente(String paisPaciente) {
        this.paisPaciente = paisPaciente;
    }

    public String getDepartamentoPaciente() {
        return departamentoPaciente;
    }

    public void setDepartamentoPaciente(String departamentoPaciente) {
        this.departamentoPaciente = departamentoPaciente;
    }

    public String getCiudadPaciente() {
        return ciudadPaciente;
    }

    public void setCiudadPaciente(String ciudadPaciente) {
        this.ciudadPaciente = ciudadPaciente;
    }

    public String getNacionalidadPaciente() {
        return nacionalidadPaciente;
    }

    public void setNacionalidadPaciente(String nacionalidadPaciente) {
        this.nacionalidadPaciente = nacionalidadPaciente;
    }

    public String getDireccionPaciente() {
        return direccionPaciente;
    }

    public void setDireccionPaciente(String direccionPaciente) {
        this.direccionPaciente = direccionPaciente;
    }

    public String getZonaResidencialPaciente() {
        return zonaResidencialPaciente;
    }

    public void setZonaResidencialPaciente(String zonaResidencialPaciente) {
        this.zonaResidencialPaciente = zonaResidencialPaciente;
    }

    public String getCodigoPostalPaciente() {
        return codigoPostalPaciente;
    }

    public void setCodigoPostalPaciente(String codigoPostalPaciente) {
        this.codigoPostalPaciente = codigoPostalPaciente;
    }

    public String getEstratoPaciente() {
        return estratoPaciente;
    }

    public void setEstratoPaciente(String estratoPaciente) {
        this.estratoPaciente = estratoPaciente;
    }

    public String getCompaniaSeguroPaciente() {
        return companiaSeguroPaciente;
    }

    public void setCompaniaSeguroPaciente(String companiaSeguroPaciente) {
        this.companiaSeguroPaciente = companiaSeguroPaciente;
    }

    public String getTipoVinculacionPaciente() {
        return tipoVinculacionPaciente;
    }

    public void setTipoVinculacionPaciente(String tipoVinculacionPaciente) {
        this.tipoVinculacionPaciente = tipoVinculacionPaciente;
    }

    public String getNombreRepresentante() {
        return nombreRepresentante;
    }

    public void setNombreRepresentante(String nombreRepresentante) {
        this.nombreRepresentante = nombreRepresentante;
    }

    public String getApellidoRepresentante() {
        return apellidoRepresentante;
    }

    public void setApellidoRepresentante(String apellidoRepresentante) {
        this.apellidoRepresentante = apellidoRepresentante;
    }

    public String getTipoIdentificacionRepresentante() {
        return tipoIdentificacionRepresentante;
    }

    public void setTipoIdentificacionRepresentante(String tipoIdentificacionRepresentante) {
        this.tipoIdentificacionRepresentante = tipoIdentificacionRepresentante;
    }

    public String getIdentificacionRepresentante() {
        return identificacionRepresentante;
    }

    public void setIdentificacionRepresentante(String identificacionRepresentante) {
        this.identificacionRepresentante = identificacionRepresentante;
    }

    public String getTelefonoRepresentante() {
        return telefonoRepresentante;
    }

    public void setTelefonoRepresentante(String telefonoRepresentante) {
        this.telefonoRepresentante = telefonoRepresentante;
    }

    public String getParentescoRepresentante() {
        return parentescoRepresentante;
    }

    public void setParentescoRepresentante(String parentescoRepresentante) {
        this.parentescoRepresentante = parentescoRepresentante;
    }

    public String getNombreEmergencia() {
        return nombreEmergencia;
    }

    public void setNombreEmergencia(String nombreEmergencia) {
        this.nombreEmergencia = nombreEmergencia;
    }

    public String getTelefonoEmergencia() {
        return telefonoEmergencia;
    }

    public void setTelefonoEmergencia(String telefonoEmergencia) {
        this.telefonoEmergencia = telefonoEmergencia;
    }

    public String getParentescoEmergencia() {
        return parentescoEmergencia;
    }

    public void setParentescoEmergencia(String parentescoEmergencia) {
        this.parentescoEmergencia = parentescoEmergencia;
    }

    public String getNombreReferido() {
        return nombreReferido;
    }

    public void setNombreReferido(String nombreReferido) {
        this.nombreReferido = nombreReferido;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getHoraCreacion() {
        return horaCreacion;
    }

    public void setHoraCreacion(String horaCreacion) {
        this.horaCreacion = horaCreacion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<ExamenFisico> getExamenFisicoList() {
        return examenFisicoList;
    }

    public void setExamenFisicoList(List<ExamenFisico> examenFisicoList) {
        this.examenFisicoList = examenFisicoList;
    }

    @XmlTransient
    public List<CirugiaPlastica> getCirugiaPlasticaList() {
        return cirugiaPlasticaList;
    }

    public void setCirugiaPlasticaList(List<CirugiaPlastica> cirugiaPlasticaList) {
        this.cirugiaPlasticaList = cirugiaPlasticaList;
    }

    @XmlTransient
    public List<Anamnesis> getAnamnesisList() {
        return anamnesisList;
    }

    public void setAnamnesisList(List<Anamnesis> anamnesisList) {
        this.anamnesisList = anamnesisList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaciente != null ? idPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.idPaciente == null && other.idPaciente != null) || (this.idPaciente != null && !this.idPaciente.equals(other.idPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.saludtec.entidades.Pacientes[ idPaciente=" + idPaciente + " ]";
    }
    
}
