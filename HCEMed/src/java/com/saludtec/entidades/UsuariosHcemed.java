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
@Table(name = "Usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuarios.findByNombreUsuario", query = "SELECT u FROM Usuarios u WHERE u.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "Usuarios.findByApellidoUsuario", query = "SELECT u FROM Usuarios u WHERE u.apellidoUsuario = :apellidoUsuario"),
    @NamedQuery(name = "Usuarios.findByUsuarioLogin", query = "SELECT u FROM Usuarios u WHERE u.usuarioLogin = :usuarioLogin"),
    @NamedQuery(name = "Usuarios.findByContrasenaLogin", query = "SELECT u FROM Usuarios u WHERE u.contrasenaLogin = :contrasenaLogin"),
    @NamedQuery(name = "Usuarios.findByLogin", query = "SELECT u FROM Usuarios u WHERE u.usuarioLogin = :usuarioLogin AND u.contrasenaLogin = :contrasenaLogin")})
public class UsuariosHcemed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Size(max = 200)
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    @Size(max = 200)
    @Column(name = "apellidoUsuario")
    private String apellidoUsuario;
    @Size(max = 200)
    @Column(name = "usuarioLogin")
    private String usuarioLogin;
    @Size(max = 200)
    @Column(name = "contrasenaLogin")
    private String contrasenaLogin;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<PacientesHcemed> pacientesList;

    public UsuariosHcemed() {
    }

    public UsuariosHcemed(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getContrasenaLogin() {
        return contrasenaLogin;
    }

    public void setContrasenaLogin(String contrasenaLogin) {
        this.contrasenaLogin = contrasenaLogin;
    }

    @XmlTransient
    public List<PacientesHcemed> getPacientesList() {
        return pacientesList;
    }

    public void setPacientesList(List<PacientesHcemed> pacientesList) {
        this.pacientesList = pacientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosHcemed)) {
            return false;
        }
        UsuariosHcemed other = (UsuariosHcemed) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.saludtec.entidades.Usuarios[ idUsuario=" + idUsuario + " ]";
    }

}