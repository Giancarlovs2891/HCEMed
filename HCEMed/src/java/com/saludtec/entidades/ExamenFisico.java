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
@Table(name = "ExamenFisico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExamenFisico.findAll", query = "SELECT e FROM ExamenFisico e ORDER BY e.idExamenFisico"),
    @NamedQuery(name = "ExamenFisico.findByIdPaciente", query = "SELECT e FROM ExamenFisico e WHERE e.idPaciente = :idPaciente ORDER BY e.idExamenFisico DESC"),
    @NamedQuery(name = "ExamenFisico.findByIdExamenFisico", query = "SELECT e FROM ExamenFisico e WHERE e.idExamenFisico = :idExamenFisico"),
    @NamedQuery(name = "ExamenFisico.findByTensionArterial", query = "SELECT e FROM ExamenFisico e WHERE e.tensionArterial = :tensionArterial"),
    @NamedQuery(name = "ExamenFisico.findByPeso", query = "SELECT e FROM ExamenFisico e WHERE e.peso = :peso"),
    @NamedQuery(name = "ExamenFisico.findByCintura", query = "SELECT e FROM ExamenFisico e WHERE e.cintura = :cintura"),
    @NamedQuery(name = "ExamenFisico.findByPulso", query = "SELECT e FROM ExamenFisico e WHERE e.pulso = :pulso"),
    @NamedQuery(name = "ExamenFisico.findByTalla", query = "SELECT e FROM ExamenFisico e WHERE e.talla = :talla"),
    @NamedQuery(name = "ExamenFisico.findByCadera", query = "SELECT e FROM ExamenFisico e WHERE e.cadera = :cadera"),
    @NamedQuery(name = "ExamenFisico.findByFrecuenciaRespiratoria", query = "SELECT e FROM ExamenFisico e WHERE e.frecuenciaRespiratoria = :frecuenciaRespiratoria"),
    @NamedQuery(name = "ExamenFisico.findByBmi", query = "SELECT e FROM ExamenFisico e WHERE e.bmi = :bmi"),
    @NamedQuery(name = "ExamenFisico.findByIndiceCintCad", query = "SELECT e FROM ExamenFisico e WHERE e.indiceCintCad = :indiceCintCad"),
    @NamedQuery(name = "ExamenFisico.findByPiel", query = "SELECT e FROM ExamenFisico e WHERE e.piel = :piel"),
    @NamedQuery(name = "ExamenFisico.findByOjos", query = "SELECT e FROM ExamenFisico e WHERE e.ojos = :ojos"),
    @NamedQuery(name = "ExamenFisico.findByOidosNarizGarganta", query = "SELECT e FROM ExamenFisico e WHERE e.oidosNarizGarganta = :oidosNarizGarganta"),
    @NamedQuery(name = "ExamenFisico.findByCuello", query = "SELECT e FROM ExamenFisico e WHERE e.cuello = :cuello"),
    @NamedQuery(name = "ExamenFisico.findByTorax", query = "SELECT e FROM ExamenFisico e WHERE e.torax = :torax"),
    @NamedQuery(name = "ExamenFisico.findByCardiovascular", query = "SELECT e FROM ExamenFisico e WHERE e.cardiovascular = :cardiovascular"),
    @NamedQuery(name = "ExamenFisico.findByRespiratorios", query = "SELECT e FROM ExamenFisico e WHERE e.respiratorios = :respiratorios"),
    @NamedQuery(name = "ExamenFisico.findByAbdomen", query = "SELECT e FROM ExamenFisico e WHERE e.abdomen = :abdomen"),
    @NamedQuery(name = "ExamenFisico.findByGenitourinario", query = "SELECT e FROM ExamenFisico e WHERE e.genitourinario = :genitourinario"),
    @NamedQuery(name = "ExamenFisico.findByExtremidades", query = "SELECT e FROM ExamenFisico e WHERE e.extremidades = :extremidades"),
    @NamedQuery(name = "ExamenFisico.findBySistemaNerviosoCentral", query = "SELECT e FROM ExamenFisico e WHERE e.sistemaNerviosoCentral = :sistemaNerviosoCentral"),
    @NamedQuery(name = "ExamenFisico.findByAdenopatias", query = "SELECT e FROM ExamenFisico e WHERE e.adenopatias = :adenopatias"),
    @NamedQuery(name = "ExamenFisico.findByOtros", query = "SELECT e FROM ExamenFisico e WHERE e.otros = :otros"),
    @NamedQuery(name = "ExamenFisico.findByFechaCreacionEf", query = "SELECT e FROM ExamenFisico e WHERE e.fechaCreacionEf = :fechaCreacionEf ORDER BY e.idExamenFisico"),
    @NamedQuery(name = "ExamenFisico.findByHoraCreacionEf", query = "SELECT e FROM ExamenFisico e WHERE e.horaCreacionEf = :horaCreacionEf"),
    @NamedQuery(name = "ExamenFisico.findByIdUsuario", query = "SELECT e FROM ExamenFisico e WHERE e.idUsuario = :idUsuario")})
public class ExamenFisico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idExamenFisico")
    private Integer idExamenFisico;
    @Size(max = 45)
    @Column(name = "tensionArterial")
    private String tensionArterial;
    @Size(max = 45)
    @Column(name = "peso")
    private String peso;
    @Size(max = 45)
    @Column(name = "cintura")
    private String cintura;
    @Size(max = 45)
    @Column(name = "pulso")
    private String pulso;
    @Size(max = 45)
    @Column(name = "talla")
    private String talla;
    @Size(max = 45)
    @Column(name = "cadera")
    private String cadera;
    @Size(max = 45)
    @Column(name = "frecuenciaRespiratoria")
    private String frecuenciaRespiratoria;
    @Size(max = 45)
    @Column(name = "bmi")
    private String bmi;
    @Size(max = 45)
    @Column(name = "indiceCintCad")
    private String indiceCintCad;
    @Size(max = 45)
    @Column(name = "piel")
    private String piel;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "pielComentarioEf")
    private String pielComentarioEf;
    @Size(max = 45)
    @Column(name = "ojos")
    private String ojos;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "ojosComentarioEf")
    private String ojosComentarioEf;
    @Size(max = 45)
    @Column(name = "oidosNarizGarganta")
    private String oidosNarizGarganta;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "oidosNarizGargantaComentarioEf")
    private String oidosNarizGargantaComentarioEf;
    @Size(max = 45)
    @Column(name = "cuello")
    private String cuello;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "cuelloComentarioEf")
    private String cuelloComentarioEf;
    @Size(max = 45)
    @Column(name = "torax")
    private String torax;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "toraxComentarioEf")
    private String toraxComentarioEf;
    @Size(max = 45)
    @Column(name = "cardiovascular")
    private String cardiovascular;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "cardiovascularComentarioEf")
    private String cardiovascularComentarioEf;
    @Size(max = 45)
    @Column(name = "respiratorios")
    private String respiratorios;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "respiratoriosComentarioEf")
    private String respiratoriosComentarioEf;
    @Size(max = 45)
    @Column(name = "abdomen")
    private String abdomen;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "abdomenComentarioEf")
    private String abdomenComentarioEf;
    @Size(max = 45)
    @Column(name = "genitourinario")
    private String genitourinario;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "genitourinarioComentarioEf")
    private String genitourinarioComentarioEf;
    @Size(max = 45)
    @Column(name = "extremidades")
    private String extremidades;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "extremidadesComentarioEf")
    private String extremidadesComentarioEf;
    @Size(max = 45)
    @Column(name = "sistemaNerviosoCentral")
    private String sistemaNerviosoCentral;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "sistemaNerviosoCentralComentarioEf")
    private String sistemaNerviosoCentralComentarioEf;
    @Size(max = 45)
    @Column(name = "adenopatias")
    private String adenopatias;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "adenopatiasComentarioEf")
    private String adenopatiasComentarioEf;
    @Size(max = 45)
    @Column(name = "otros")
    private String otros;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "otrosComentarioEf")
    private String otrosComentarioEf;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosEf")
    private String comentariosEf;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "condicionEf")
    private String condicionEf;
    @Size(max = 45)
    @Column(name = "fechaCreacionEf")
    private String fechaCreacionEf;
    @Size(max = 45)
    @Column(name = "horaCreacionEf")
    private String horaCreacionEf;
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pacientes idPaciente;

    public ExamenFisico() {
    }

    public ExamenFisico(Integer idExamenFisico) {
        this.idExamenFisico = idExamenFisico;
    }

    public Integer getIdExamenFisico() {
        return idExamenFisico;
    }

    public void setIdExamenFisico(Integer idExamenFisico) {
        this.idExamenFisico = idExamenFisico;
    }

    public String getTensionArterial() {
        return tensionArterial;
    }

    public void setTensionArterial(String tensionArterial) {
        this.tensionArterial = tensionArterial;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getCintura() {
        return cintura;
    }

    public void setCintura(String cintura) {
        this.cintura = cintura;
    }

    public String getPulso() {
        return pulso;
    }

    public void setPulso(String pulso) {
        this.pulso = pulso;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getCadera() {
        return cadera;
    }

    public void setCadera(String cadera) {
        this.cadera = cadera;
    }

    public String getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    public void setFrecuenciaRespiratoria(String frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getIndiceCintCad() {
        return indiceCintCad;
    }

    public void setIndiceCintCad(String indiceCintCad) {
        this.indiceCintCad = indiceCintCad;
    }

    public String getPiel() {
        return piel;
    }

    public void setPiel(String piel) {
        this.piel = piel;
    }

    public String getPielComentarioEf() {
        return pielComentarioEf;
    }

    public void setPielComentarioEf(String pielComentarioEf) {
        this.pielComentarioEf = pielComentarioEf;
    }

    public String getOjos() {
        return ojos;
    }

    public void setOjos(String ojos) {
        this.ojos = ojos;
    }

    public String getOjosComentarioEf() {
        return ojosComentarioEf;
    }

    public void setOjosComentarioEf(String ojosComentarioEf) {
        this.ojosComentarioEf = ojosComentarioEf;
    }

    public String getOidosNarizGarganta() {
        return oidosNarizGarganta;
    }

    public void setOidosNarizGarganta(String oidosNarizGarganta) {
        this.oidosNarizGarganta = oidosNarizGarganta;
    }

    public String getOidosNarizGargantaComentarioEf() {
        return oidosNarizGargantaComentarioEf;
    }

    public void setOidosNarizGargantaComentarioEf(String oidosNarizGargantaComentarioEf) {
        this.oidosNarizGargantaComentarioEf = oidosNarizGargantaComentarioEf;
    }

    public String getCuello() {
        return cuello;
    }

    public void setCuello(String cuello) {
        this.cuello = cuello;
    }

    public String getCuelloComentarioEf() {
        return cuelloComentarioEf;
    }

    public void setCuelloComentarioEf(String cuelloComentarioEf) {
        this.cuelloComentarioEf = cuelloComentarioEf;
    }

    public String getTorax() {
        return torax;
    }

    public void setTorax(String torax) {
        this.torax = torax;
    }

    public String getToraxComentarioEf() {
        return toraxComentarioEf;
    }

    public void setToraxComentarioEf(String toraxComentarioEf) {
        this.toraxComentarioEf = toraxComentarioEf;
    }

    public String getCardiovascular() {
        return cardiovascular;
    }

    public void setCardiovascular(String cardiovascular) {
        this.cardiovascular = cardiovascular;
    }

    public String getCardiovascularComentarioEf() {
        return cardiovascularComentarioEf;
    }

    public void setCardiovascularComentarioEf(String cardiovascularComentarioEf) {
        this.cardiovascularComentarioEf = cardiovascularComentarioEf;
    }

    public String getRespiratorios() {
        return respiratorios;
    }

    public void setRespiratorios(String respiratorios) {
        this.respiratorios = respiratorios;
    }

    public String getRespiratoriosComentarioEf() {
        return respiratoriosComentarioEf;
    }

    public void setRespiratoriosComentarioEf(String respiratoriosComentarioEf) {
        this.respiratoriosComentarioEf = respiratoriosComentarioEf;
    }

    public String getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(String abdomen) {
        this.abdomen = abdomen;
    }

    public String getAbdomenComentarioEf() {
        return abdomenComentarioEf;
    }

    public void setAbdomenComentarioEf(String abdomenComentarioEf) {
        this.abdomenComentarioEf = abdomenComentarioEf;
    }

    public String getGenitourinario() {
        return genitourinario;
    }

    public void setGenitourinario(String genitourinario) {
        this.genitourinario = genitourinario;
    }

    public String getGenitourinarioComentarioEf() {
        return genitourinarioComentarioEf;
    }

    public void setGenitourinarioComentarioEf(String genitourinarioComentarioEf) {
        this.genitourinarioComentarioEf = genitourinarioComentarioEf;
    }

    public String getExtremidades() {
        return extremidades;
    }

    public void setExtremidades(String extremidades) {
        this.extremidades = extremidades;
    }

    public String getExtremidadesComentarioEf() {
        return extremidadesComentarioEf;
    }

    public void setExtremidadesComentarioEf(String extremidadesComentarioEf) {
        this.extremidadesComentarioEf = extremidadesComentarioEf;
    }

    public String getSistemaNerviosoCentral() {
        return sistemaNerviosoCentral;
    }

    public void setSistemaNerviosoCentral(String sistemaNerviosoCentral) {
        this.sistemaNerviosoCentral = sistemaNerviosoCentral;
    }

    public String getSistemaNerviosoCentralComentarioEf() {
        return sistemaNerviosoCentralComentarioEf;
    }

    public void setSistemaNerviosoCentralComentarioEf(String sistemaNerviosoCentralComentarioEf) {
        this.sistemaNerviosoCentralComentarioEf = sistemaNerviosoCentralComentarioEf;
    }

    public String getAdenopatias() {
        return adenopatias;
    }

    public void setAdenopatias(String adenopatias) {
        this.adenopatias = adenopatias;
    }

    public String getAdenopatiasComentarioEf() {
        return adenopatiasComentarioEf;
    }

    public void setAdenopatiasComentarioEf(String adenopatiasComentarioEf) {
        this.adenopatiasComentarioEf = adenopatiasComentarioEf;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public String getOtrosComentarioEf() {
        return otrosComentarioEf;
    }

    public void setOtrosComentarioEf(String otrosComentarioEf) {
        this.otrosComentarioEf = otrosComentarioEf;
    }

    public String getComentariosEf() {
        return comentariosEf;
    }

    public void setComentariosEf(String comentariosEf) {
        this.comentariosEf = comentariosEf;
    }

    public String getCondicionEf() {
        return condicionEf;
    }

    public void setCondicionEf(String condicionEf) {
        this.condicionEf = condicionEf;
    }

    public String getFechaCreacionEf() {
        return fechaCreacionEf;
    }

    public void setFechaCreacionEf(String fechaCreacionEf) {
        this.fechaCreacionEf = fechaCreacionEf;
    }

    public String getHoraCreacionEf() {
        return horaCreacionEf;
    }

    public void setHoraCreacionEf(String horaCreacionEf) {
        this.horaCreacionEf = horaCreacionEf;
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
        hash += (idExamenFisico != null ? idExamenFisico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamenFisico)) {
            return false;
        }
        ExamenFisico other = (ExamenFisico) object;
        if ((this.idExamenFisico == null && other.idExamenFisico != null) || (this.idExamenFisico != null && !this.idExamenFisico.equals(other.idExamenFisico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.saludtec.entidades.ExamenFisico[ idExamenFisico=" + idExamenFisico + " ]";
    }
    
}
