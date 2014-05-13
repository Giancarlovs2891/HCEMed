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
@Table(name = "CirugiaPlastica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CirugiaPlastica.findAll", query = "SELECT c FROM CirugiaPlastica c ORDER BY c.idCirugiaPlastica"),
    @NamedQuery(name = "CirugiaPlastica.findByIdPaciente", query = "SELECT c FROM CirugiaPlastica c WHERE c.idPaciente = :idPaciente ORDER BY c.idCirugiaPlastica DESC"),
    @NamedQuery(name = "CirugiaPlastica.findByIdPacienteAndFecha", query = "SELECT c FROM CirugiaPlastica c WHERE c.idPaciente = :idPaciente AND c.fechaCreacionCp = :fecha ORDER BY c.idCirugiaPlastica DESC"),
    @NamedQuery(name = "CirugiaPlastica.findByIdCirugiaPlastica", query = "SELECT c FROM CirugiaPlastica c WHERE c.idCirugiaPlastica = :idCirugiaPlastica"),
    @NamedQuery(name = "CirugiaPlastica.findByEsteticaCabezaCuello", query = "SELECT c FROM CirugiaPlastica c WHERE c.esteticaCabezaCuello = :esteticaCabezaCuello"),
    @NamedQuery(name = "CirugiaPlastica.findByAlopecia", query = "SELECT c FROM CirugiaPlastica c WHERE c.alopecia = :alopecia"),
    @NamedQuery(name = "CirugiaPlastica.findByCaidaDeCabello", query = "SELECT c FROM CirugiaPlastica c WHERE c.caidaDeCabello = :caidaDeCabello"),
    @NamedQuery(name = "CirugiaPlastica.findByEdadInicioDebilitamientoCapilar", query = "SELECT c FROM CirugiaPlastica c WHERE c.edadInicioDebilitamientoCapilar = :edadInicioDebilitamientoCapilar"),
    @NamedQuery(name = "CirugiaPlastica.findByEdadInicioCaidaCapilar", query = "SELECT c FROM CirugiaPlastica c WHERE c.edadInicioCaidaCapilar = :edadInicioCaidaCapilar"),
    @NamedQuery(name = "CirugiaPlastica.findByEstabilizada", query = "SELECT c FROM CirugiaPlastica c WHERE c.estabilizada = :estabilizada"),
    @NamedQuery(name = "CirugiaPlastica.findByAntecedentesFamiliares", query = "SELECT c FROM CirugiaPlastica c WHERE c.antecedentesFamiliares = :antecedentesFamiliares"),
    @NamedQuery(name = "CirugiaPlastica.findByTratamientosPrevios", query = "SELECT c FROM CirugiaPlastica c WHERE c.tratamientosPrevios = :tratamientosPrevios"),
    @NamedQuery(name = "CirugiaPlastica.findByCortes", query = "SELECT c FROM CirugiaPlastica c WHERE c.cortes = :cortes"),
    @NamedQuery(name = "CirugiaPlastica.findByColor", query = "SELECT c FROM CirugiaPlastica c WHERE c.color = :color"),
    @NamedQuery(name = "CirugiaPlastica.findByEspesorCabello", query = "SELECT c FROM CirugiaPlastica c WHERE c.espesorCabello = :espesorCabello"),
    @NamedQuery(name = "CirugiaPlastica.findByEstructura", query = "SELECT c FROM CirugiaPlastica c WHERE c.estructura = :estructura"),
    @NamedQuery(name = "CirugiaPlastica.findByPoros", query = "SELECT c FROM CirugiaPlastica c WHERE c.poros = :poros"),
    @NamedQuery(name = "CirugiaPlastica.findByEspesorCueroCabelludo", query = "SELECT c FROM CirugiaPlastica c WHERE c.espesorCueroCabelludo = :espesorCueroCabelludo"),
    @NamedQuery(name = "CirugiaPlastica.findByFlexibilidadCueroCabelludo", query = "SELECT c FROM CirugiaPlastica c WHERE c.flexibilidadCueroCabelludo = :flexibilidadCueroCabelludo"),
    @NamedQuery(name = "CirugiaPlastica.findByCicatrices", query = "SELECT c FROM CirugiaPlastica c WHERE c.cicatrices = :cicatrices"),
    @NamedQuery(name = "CirugiaPlastica.findByPullTest", query = "SELECT c FROM CirugiaPlastica c WHERE c.pullTest = :pullTest"),
    @NamedQuery(name = "CirugiaPlastica.findByComponentesPsiquicos", query = "SELECT c FROM CirugiaPlastica c WHERE c.componentesPsiquicos = :componentesPsiquicos"),
    @NamedQuery(name = "CirugiaPlastica.findByDensidadZonaFrontal", query = "SELECT c FROM CirugiaPlastica c WHERE c.densidadZonaFrontal = :densidadZonaFrontal"),
    @NamedQuery(name = "CirugiaPlastica.findByDensidadZonaOccipital", query = "SELECT c FROM CirugiaPlastica c WHERE c.densidadZonaOccipital = :densidadZonaOccipital"),
    @NamedQuery(name = "CirugiaPlastica.findByDensidadZonaTemporal", query = "SELECT c FROM CirugiaPlastica c WHERE c.densidadZonaTemporal = :densidadZonaTemporal"),
    @NamedQuery(name = "CirugiaPlastica.findByDensidadZonaParietal", query = "SELECT c FROM CirugiaPlastica c WHERE c.densidadZonaParietal = :densidadZonaParietal"),
    @NamedQuery(name = "CirugiaPlastica.findByPerdidaZona", query = "SELECT c FROM CirugiaPlastica c WHERE c.perdidaZona = :perdidaZona"),
    @NamedQuery(name = "CirugiaPlastica.findByTipoAlopeciaNoCicatricial", query = "SELECT c FROM CirugiaPlastica c WHERE c.tipoAlopeciaNoCicatricial = :tipoAlopeciaNoCicatricial"),
    @NamedQuery(name = "CirugiaPlastica.findByOtroTipoDeAlopeciaNoCicatricial", query = "SELECT c FROM CirugiaPlastica c WHERE c.otroTipoDeAlopeciaNoCicatricial = :otroTipoDeAlopeciaNoCicatricial"),
    @NamedQuery(name = "CirugiaPlastica.findByTipoAlopeciaCicatricial", query = "SELECT c FROM CirugiaPlastica c WHERE c.tipoAlopeciaCicatricial = :tipoAlopeciaCicatricial"),
    @NamedQuery(name = "CirugiaPlastica.findByOtroTipoAlopeciaCicatricial", query = "SELECT c FROM CirugiaPlastica c WHERE c.otroTipoAlopeciaCicatricial = :otroTipoAlopeciaCicatricial"),
    @NamedQuery(name = "CirugiaPlastica.findByGradoDeAlopeciaHombre", query = "SELECT c FROM CirugiaPlastica c WHERE c.gradoDeAlopeciaHombre = :gradoDeAlopeciaHombre"),
    @NamedQuery(name = "CirugiaPlastica.findByGradoDeAlopeciaMujer", query = "SELECT c FROM CirugiaPlastica c WHERE c.gradoDeAlopeciaMujer = :gradoDeAlopeciaMujer"),
    @NamedQuery(name = "CirugiaPlastica.findByFacial", query = "SELECT c FROM CirugiaPlastica c WHERE c.facial = :facial"),
    @NamedQuery(name = "CirugiaPlastica.findByAntropometriaFrente", query = "SELECT c FROM CirugiaPlastica c WHERE c.antropometriaFrente = :antropometriaFrente"),
    @NamedQuery(name = "CirugiaPlastica.findByAntropometriaPerfil", query = "SELECT c FROM CirugiaPlastica c WHERE c.antropometriaPerfil = :antropometriaPerfil"),
    @NamedQuery(name = "CirugiaPlastica.findByFrente", query = "SELECT c FROM CirugiaPlastica c WHERE c.frente = :frente"),
    @NamedQuery(name = "CirugiaPlastica.findByZonaPeriorbitaria", query = "SELECT c FROM CirugiaPlastica c WHERE c.zonaPeriorbitaria = :zonaPeriorbitaria"),
    @NamedQuery(name = "CirugiaPlastica.findByRegionMalar", query = "SELECT c FROM CirugiaPlastica c WHERE c.regionMalar = :regionMalar"),
    @NamedQuery(name = "CirugiaPlastica.findByRegionMandibular", query = "SELECT c FROM CirugiaPlastica c WHERE c.regionMandibular = :regionMandibular"),
    @NamedQuery(name = "CirugiaPlastica.findByAuricular", query = "SELECT c FROM CirugiaPlastica c WHERE c.auricular = :auricular"),
    @NamedQuery(name = "CirugiaPlastica.findByNasal", query = "SELECT c FROM CirugiaPlastica c WHERE c.nasal = :nasal"),
    @NamedQuery(name = "CirugiaPlastica.findByPeriBucal", query = "SELECT c FROM CirugiaPlastica c WHERE c.periBucal = :periBucal"),
    @NamedQuery(name = "CirugiaPlastica.findByMentoniana", query = "SELECT c FROM CirugiaPlastica c WHERE c.mentoniana = :mentoniana"),
    @NamedQuery(name = "CirugiaPlastica.findByCervical", query = "SELECT c FROM CirugiaPlastica c WHERE c.cervical = :cervical"),
    @NamedQuery(name = "CirugiaPlastica.findByEsteticaCorporal", query = "SELECT c FROM CirugiaPlastica c WHERE c.esteticaCorporal = :esteticaCorporal"),
    @NamedQuery(name = "CirugiaPlastica.findByRegionToracicaAnterior", query = "SELECT c FROM CirugiaPlastica c WHERE c.regionToracicaAnterior = :regionToracicaAnterior"),
    @NamedQuery(name = "CirugiaPlastica.findByAntecedentesMamarios", query = "SELECT c FROM CirugiaPlastica c WHERE c.antecedentesMamarios = :antecedentesMamarios"),
    @NamedQuery(name = "CirugiaPlastica.findByMamografias", query = "SELECT c FROM CirugiaPlastica c WHERE c.mamografias = :mamografias"),
    @NamedQuery(name = "CirugiaPlastica.findByAutoexamen", query = "SELECT c FROM CirugiaPlastica c WHERE c.autoexamen = :autoexamen"),
    @NamedQuery(name = "CirugiaPlastica.findByVolumenMamarioDerecho", query = "SELECT c FROM CirugiaPlastica c WHERE c.volumenMamarioDerecho = :volumenMamarioDerecho"),
    @NamedQuery(name = "CirugiaPlastica.findByHipertrofiaVolumenMamarioDerecho", query = "SELECT c FROM CirugiaPlastica c WHERE c.hipertrofiaVolumenMamarioDerecho = :hipertrofiaVolumenMamarioDerecho"),
    @NamedQuery(name = "CirugiaPlastica.findByVolumenMamarioIzquierdo", query = "SELECT c FROM CirugiaPlastica c WHERE c.volumenMamarioIzquierdo = :volumenMamarioIzquierdo"),
    @NamedQuery(name = "CirugiaPlastica.findByHipertrofiaVolumenMamarioIzquierdo", query = "SELECT c FROM CirugiaPlastica c WHERE c.hipertrofiaVolumenMamarioIzquierdo = :hipertrofiaVolumenMamarioIzquierdo"),
    @NamedQuery(name = "CirugiaPlastica.findByFormaMamariaDerecha", query = "SELECT c FROM CirugiaPlastica c WHERE c.formaMamariaDerecha = :formaMamariaDerecha"),
    @NamedQuery(name = "CirugiaPlastica.findByFormaMamariaIzquierda", query = "SELECT c FROM CirugiaPlastica c WHERE c.formaMamariaIzquierda = :formaMamariaIzquierda"),
    @NamedQuery(name = "CirugiaPlastica.findByPtosisMamaria", query = "SELECT c FROM CirugiaPlastica c WHERE c.ptosisMamaria = :ptosisMamaria"),
    @NamedQuery(name = "CirugiaPlastica.findByClasificacionPtosisRegnoult", query = "SELECT c FROM CirugiaPlastica c WHERE c.clasificacionPtosisRegnoult = :clasificacionPtosisRegnoult"),
    @NamedQuery(name = "CirugiaPlastica.findByTipoPielDerecha", query = "SELECT c FROM CirugiaPlastica c WHERE c.tipoPielDerecha = :tipoPielDerecha"),
    @NamedQuery(name = "CirugiaPlastica.findByTipoPielIzquierda", query = "SELECT c FROM CirugiaPlastica c WHERE c.tipoPielIzquierda = :tipoPielIzquierda"),
    @NamedQuery(name = "CirugiaPlastica.findBySensibilidadPezonDerecho", query = "SELECT c FROM CirugiaPlastica c WHERE c.sensibilidadPezonDerecho = :sensibilidadPezonDerecho"),
    @NamedQuery(name = "CirugiaPlastica.findBySensibilidadPezonIzquierdo", query = "SELECT c FROM CirugiaPlastica c WHERE c.sensibilidadPezonIzquierdo = :sensibilidadPezonIzquierdo"),
    @NamedQuery(name = "CirugiaPlastica.findByDiametroComplejoAreola", query = "SELECT c FROM CirugiaPlastica c WHERE c.diametroComplejoAreola = :diametroComplejoAreola"),
    @NamedQuery(name = "CirugiaPlastica.findByDiagramaPosicionDerecho", query = "SELECT c FROM CirugiaPlastica c WHERE c.diagramaPosicionDerecho = :diagramaPosicionDerecho"),
    @NamedQuery(name = "CirugiaPlastica.findByBaseMamariaDerecho", query = "SELECT c FROM CirugiaPlastica c WHERE c.baseMamariaDerecho = :baseMamariaDerecho"),
    @NamedQuery(name = "CirugiaPlastica.findByMedidaToraxDerecho", query = "SELECT c FROM CirugiaPlastica c WHERE c.medidaToraxDerecho = :medidaToraxDerecho"),
    @NamedQuery(name = "CirugiaPlastica.findByDiagramaPosicionIzquierdo", query = "SELECT c FROM CirugiaPlastica c WHERE c.diagramaPosicionIzquierdo = :diagramaPosicionIzquierdo"),
    @NamedQuery(name = "CirugiaPlastica.findByBaseMamariaIzquierdo", query = "SELECT c FROM CirugiaPlastica c WHERE c.baseMamariaIzquierdo = :baseMamariaIzquierdo"),
    @NamedQuery(name = "CirugiaPlastica.findByMedidaToraxIzquierdo", query = "SELECT c FROM CirugiaPlastica c WHERE c.medidaToraxIzquierdo = :medidaToraxIzquierdo"),
    @NamedQuery(name = "CirugiaPlastica.findByDiagnosticoMamario", query = "SELECT c FROM CirugiaPlastica c WHERE c.diagnosticoMamario = :diagnosticoMamario"),
    @NamedQuery(name = "CirugiaPlastica.findByOtrosDiagnosticosMamarios", query = "SELECT c FROM CirugiaPlastica c WHERE c.otrosDiagnosticosMamarios = :otrosDiagnosticosMamarios"),
    @NamedQuery(name = "CirugiaPlastica.findByPlanTratamientoMamario", query = "SELECT c FROM CirugiaPlastica c WHERE c.planTratamientoMamario = :planTratamientoMamario"),
    @NamedQuery(name = "CirugiaPlastica.findByGinecomastia", query = "SELECT c FROM CirugiaPlastica c WHERE c.ginecomastia = :ginecomastia"),
    @NamedQuery(name = "CirugiaPlastica.findByClasificacionWiesman", query = "SELECT c FROM CirugiaPlastica c WHERE c.clasificacionWiesman = :clasificacionWiesman"),
    @NamedQuery(name = "CirugiaPlastica.findByTipoGinecomastia", query = "SELECT c FROM CirugiaPlastica c WHERE c.tipoGinecomastia = :tipoGinecomastia"),
    @NamedQuery(name = "CirugiaPlastica.findByAbdomen", query = "SELECT c FROM CirugiaPlastica c WHERE c.abdomen = :abdomen"),
    @NamedQuery(name = "CirugiaPlastica.findByClasificacionMatarasso", query = "SELECT c FROM CirugiaPlastica c WHERE c.clasificacionMatarasso = :clasificacionMatarasso"),
    @NamedQuery(name = "CirugiaPlastica.findByEspalda", query = "SELECT c FROM CirugiaPlastica c WHERE c.espalda = :espalda"),
    @NamedQuery(name = "CirugiaPlastica.findByGluteos", query = "SELECT c FROM CirugiaPlastica c WHERE c.gluteos = :gluteos"),
    @NamedQuery(name = "CirugiaPlastica.findByAsimetria", query = "SELECT c FROM CirugiaPlastica c WHERE c.asimetria = :asimetria"),
    @NamedQuery(name = "CirugiaPlastica.findBySecuelasTrauma", query = "SELECT c FROM CirugiaPlastica c WHERE c.secuelasTrauma = :secuelasTrauma"),
    @NamedQuery(name = "CirugiaPlastica.findByExtremidadesSuperiores", query = "SELECT c FROM CirugiaPlastica c WHERE c.extremidadesSuperiores = :extremidadesSuperiores"),
    @NamedQuery(name = "CirugiaPlastica.findByDepositoGrasaMinimoModeradoMinimaLaxitud", query = "SELECT c FROM CirugiaPlastica c WHERE c.depositoGrasaMinimoModeradoMinimaLaxitud = :depositoGrasaMinimoModeradoMinimaLaxitud"),
    @NamedQuery(name = "CirugiaPlastica.findByDepositoGrasaGeneralizadaModeradaLaxitud", query = "SELECT c FROM CirugiaPlastica c WHERE c.depositoGrasaGeneralizadaModeradaLaxitud = :depositoGrasaGeneralizadaModeradaLaxitud"),
    @NamedQuery(name = "CirugiaPlastica.findByObesidadGeneralizadaSeveraLaxitud", query = "SELECT c FROM CirugiaPlastica c WHERE c.obesidadGeneralizadaSeveraLaxitud = :obesidadGeneralizadaSeveraLaxitud"),
    @NamedQuery(name = "CirugiaPlastica.findByMinimaGrasaSubcutaneaExtensaLaxitud", query = "SELECT c FROM CirugiaPlastica c WHERE c.minimaGrasaSubcutaneaExtensaLaxitud = :minimaGrasaSubcutaneaExtensaLaxitud"),
    @NamedQuery(name = "CirugiaPlastica.findByExtremidadesInferiores", query = "SELECT c FROM CirugiaPlastica c WHERE c.extremidadesInferiores = :extremidadesInferiores"),
    @NamedQuery(name = "CirugiaPlastica.findByReconstructivaCabezaCuello", query = "SELECT c FROM CirugiaPlastica c WHERE c.reconstructivaCabezaCuello = :reconstructivaCabezaCuello"),
    @NamedQuery(name = "CirugiaPlastica.findByReconstructivaCorporal", query = "SELECT c FROM CirugiaPlastica c WHERE c.reconstructivaCorporal = :reconstructivaCorporal"),
    @NamedQuery(name = "CirugiaPlastica.findByFechaCreacionCp", query = "SELECT c FROM CirugiaPlastica c WHERE c.fechaCreacionCp = :fechaCreacionCp"),
    @NamedQuery(name = "CirugiaPlastica.findByHoraCreacionCp", query = "SELECT c FROM CirugiaPlastica c WHERE c.horaCreacionCp = :horaCreacionCp"),
    @NamedQuery(name = "CirugiaPlastica.findByIdUsuario", query = "SELECT c FROM CirugiaPlastica c WHERE c.idUsuario = :idUsuario")})
public class CirugiaPlastica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCirugiaPlastica")
    private Integer idCirugiaPlastica;
    @Size(max = 45)
    @Column(name = "esteticaCabezaCuello")
    private String esteticaCabezaCuello;
    @Size(max = 45)
    @Column(name = "alopecia")
    private String alopecia;
    @Size(max = 45)
    @Column(name = "caidaDeCabello")
    private String caidaDeCabello;
    @Size(max = 45)
    @Column(name = "edadInicioDebilitamientoCapilar")
    private String edadInicioDebilitamientoCapilar;
    @Size(max = 45)
    @Column(name = "edadInicioCaidaCapilar")
    private String edadInicioCaidaCapilar;
    @Size(max = 45)
    @Column(name = "estabilizada")
    private String estabilizada;
    @Size(max = 45)
    @Column(name = "antecedentesFamiliares")
    private String antecedentesFamiliares;
    @Size(max = 45)
    @Column(name = "tratamientosPrevios")
    private String tratamientosPrevios;
    @Size(max = 45)
    @Column(name = "cortes")
    private String cortes;
    @Size(max = 45)
    @Column(name = "color")
    private String color;
    @Size(max = 45)
    @Column(name = "espesorCabello")
    private String espesorCabello;
    @Size(max = 45)
    @Column(name = "estructura")
    private String estructura;
    @Size(max = 45)
    @Column(name = "poros")
    private String poros;
    @Size(max = 45)
    @Column(name = "espesorCueroCabelludo")
    private String espesorCueroCabelludo;
    @Size(max = 45)
    @Column(name = "flexibilidadCueroCabelludo")
    private String flexibilidadCueroCabelludo;
    @Size(max = 45)
    @Column(name = "cicatrices")
    private String cicatrices;
    @Size(max = 45)
    @Column(name = "pullTest")
    private String pullTest;
    @Size(max = 45)
    @Column(name = "componentesPsiquicos")
    private String componentesPsiquicos;
    @Size(max = 45)
    @Column(name = "densidadZonaFrontal")
    private String densidadZonaFrontal;
    @Size(max = 45)
    @Column(name = "densidadZonaOccipital")
    private String densidadZonaOccipital;
    @Size(max = 45)
    @Column(name = "densidadZonaTemporal")
    private String densidadZonaTemporal;
    @Size(max = 45)
    @Column(name = "densidadZonaParietal")
    private String densidadZonaParietal;
    @Size(max = 45)
    @Column(name = "perdidaZona")
    private String perdidaZona;
    @Size(max = 45)
    @Column(name = "tipoAlopeciaNoCicatricial")
    private String tipoAlopeciaNoCicatricial;
    @Size(max = 45)
    @Column(name = "otroTipoDeAlopeciaNoCicatricial")
    private String otroTipoDeAlopeciaNoCicatricial;
    @Size(max = 45)
    @Column(name = "tipoAlopeciaCicatricial")
    private String tipoAlopeciaCicatricial;
    @Size(max = 45)
    @Column(name = "otroTipoAlopeciaCicatricial")
    private String otroTipoAlopeciaCicatricial;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "expectativasPaciente")
    private String expectativasPaciente;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "propuestasTerapeuticas")
    private String propuestasTerapeuticas;
    @Size(max = 45)
    @Column(name = "gradoDeAlopeciaHombre")
    private String gradoDeAlopeciaHombre;
    @Size(max = 45)
    @Column(name = "gradoDeAlopeciaMujer")
    private String gradoDeAlopeciaMujer;
    @Size(max = 45)
    @Column(name = "facial")
    private String facial;
    @Size(max = 45)
    @Column(name = "antropometriaFrente")
    private String antropometriaFrente;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosAntropometriaFrente")
    private String comentariosAntropometriaFrente;
    @Size(max = 45)
    @Column(name = "antropometriaPerfil")
    private String antropometriaPerfil;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosAntropometriaPerfil")
    private String comentariosAntropometriaPerfil;
    @Size(max = 45)
    @Column(name = "frente")
    private String frente;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosFrente")
    private String comentariosFrente;
    @Size(max = 45)
    @Column(name = "zonaPeriorbitaria")
    private String zonaPeriorbitaria;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosZonaPeriorbitaria")
    private String comentariosZonaPeriorbitaria;
    @Size(max = 45)
    @Column(name = "regionMalar")
    private String regionMalar;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosRegionMalar")
    private String comentariosRegionMalar;
    @Size(max = 45)
    @Column(name = "regionMandibular")
    private String regionMandibular;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosRegionMandibular")
    private String comentariosRegionMandibular;
    @Size(max = 45)
    @Column(name = "auricular")
    private String auricular;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosAuricular")
    private String comentariosAuricular;
    @Size(max = 45)
    @Column(name = "nasal")
    private String nasal;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosNasal")
    private String comentariosNasal;
    @Size(max = 45)
    @Column(name = "periBucal")
    private String periBucal;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosPeriBucal")
    private String comentariosPeriBucal;
    @Size(max = 45)
    @Column(name = "mentoniana")
    private String mentoniana;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosMentoniana")
    private String comentariosMentoniana;
    @Size(max = 45)
    @Column(name = "cervical")
    private String cervical;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosCervical")
    private String comentariosCervical;
    @Size(max = 45)
    @Column(name = "esteticaCorporal")
    private String esteticaCorporal;
    @Size(max = 45)
    @Column(name = "regionToracicaAnterior")
    private String regionToracicaAnterior;
    @Size(max = 45)
    @Column(name = "antecedentesMamarios")
    private String antecedentesMamarios;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosAntecedentesMamarios")
    private String comentariosAntecedentesMamarios;
    @Size(max = 45)
    @Column(name = "mamografias")
    private String mamografias;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosMamografias")
    private String comentariosMamografias;
    @Size(max = 45)
    @Column(name = "autoexamen")
    private String autoexamen;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosAutoexamen")
    private String comentariosAutoexamen;
    @Size(max = 45)
    @Column(name = "volumenMamarioDerecho")
    private String volumenMamarioDerecho;
    @Size(max = 45)
    @Column(name = "hipertrofiaVolumenMamarioDerecho")
    private String hipertrofiaVolumenMamarioDerecho;
    @Size(max = 45)
    @Column(name = "volumenMamarioIzquierdo")
    private String volumenMamarioIzquierdo;
    @Size(max = 45)
    @Column(name = "hipertrofiaVolumenMamarioIzquierdo")
    private String hipertrofiaVolumenMamarioIzquierdo;
    @Size(max = 45)
    @Column(name = "formaMamariaDerecha")
    private String formaMamariaDerecha;
    @Size(max = 45)
    @Column(name = "formaMamariaIzquierda")
    private String formaMamariaIzquierda;
    @Size(max = 45)
    @Column(name = "ptosisMamaria")
    private String ptosisMamaria;
    @Size(max = 45)
    @Column(name = "clasificacionPtosisRegnoult")
    private String clasificacionPtosisRegnoult;
    @Size(max = 45)
    @Column(name = "tipoPielDerecha")
    private String tipoPielDerecha;
    @Size(max = 45)
    @Column(name = "tipoPielIzquierda")
    private String tipoPielIzquierda;
    @Size(max = 45)
    @Column(name = "sensibilidadPezonDerecho")
    private String sensibilidadPezonDerecho;
    @Size(max = 45)
    @Column(name = "sensibilidadPezonIzquierdo")
    private String sensibilidadPezonIzquierdo;
    @Size(max = 45)
    @Column(name = "diametroComplejoAreola")
    private String diametroComplejoAreola;
    @Size(max = 45)
    @Column(name = "diagramaPosicionDerecho")
    private String diagramaPosicionDerecho;
    @Size(max = 45)
    @Column(name = "baseMamariaDerecho")
    private String baseMamariaDerecho;
    @Size(max = 45)
    @Column(name = "medidaToraxDerecho")
    private String medidaToraxDerecho;
    @Size(max = 45)
    @Column(name = "diagramaPosicionIzquierdo")
    private String diagramaPosicionIzquierdo;
    @Size(max = 45)
    @Column(name = "baseMamariaIzquierdo")
    private String baseMamariaIzquierdo;
    @Size(max = 45)
    @Column(name = "medidaToraxIzquierdo")
    private String medidaToraxIzquierdo;
    @Size(max = 45)
    @Column(name = "diagnosticoMamario")
    private String diagnosticoMamario;
    @Size(max = 45)
    @Column(name = "otrosDiagnosticosMamarios")
    private String otrosDiagnosticosMamarios;
    @Size(max = 45)
    @Column(name = "planTratamientoMamario")
    private String planTratamientoMamario;
    @Size(max = 45)
    @Column(name = "ginecomastia")
    private String ginecomastia;
    @Size(max = 45)
    @Column(name = "clasificacionWiesman")
    private String clasificacionWiesman;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "antecedentesGinecomastia")
    private String antecedentesGinecomastia;
    @Size(max = 45)
    @Column(name = "tipoGinecomastia")
    private String tipoGinecomastia;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosTipoGinecomastia")
    private String comentariosTipoGinecomastia;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "pectorales")
    private String pectorales;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "otrosDiagnosticosGinecomastia")
    private String otrosDiagnosticosGinecomastia;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "planTratamientoGinecomastia")
    private String planTratamientoGinecomastia;
    @Size(max = 45)
    @Column(name = "abdomen")
    private String abdomen;
    @Size(max = 45)
    @Column(name = "clasificacionMatarasso")
    private String clasificacionMatarasso;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosAbdomen")
    private String comentariosAbdomen;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "diagnosticoAbdomen")
    private String diagnosticoAbdomen;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "planTratamientoAbdomen")
    private String planTratamientoAbdomen;
    @Size(max = 45)
    @Column(name = "espalda")
    private String espalda;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosEspalda")
    private String comentariosEspalda;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "diagnosticoEspalda")
    private String diagnosticoEspalda;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "planTratamientoEspalda")
    private String planTratamientoEspalda;
    @Size(max = 45)
    @Column(name = "gluteos")
    private String gluteos;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "volumenGluteos")
    private String volumenGluteos;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "posicionGluteos")
    private String posicionGluteos;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "formaGluteos")
    private String formaGluteos;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "caracteristicasPielGluteos")
    private String caracteristicasPielGluteos;
    @Size(max = 45)
    @Column(name = "asimetria")
    private String asimetria;
    @Size(max = 45)
    @Column(name = "secuelasTrauma")
    private String secuelasTrauma;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosGluteos")
    private String comentariosGluteos;
    @Size(max = 45)
    @Column(name = "extremidadesSuperiores")
    private String extremidadesSuperiores;
    @Size(max = 45)
    @Column(name = "depositoGrasaMinimoModeradoMinimaLaxitud")
    private String depositoGrasaMinimoModeradoMinimaLaxitud;
    @Size(max = 45)
    @Column(name = "depositoGrasaGeneralizadaModeradaLaxitud")
    private String depositoGrasaGeneralizadaModeradaLaxitud;
    @Size(max = 45)
    @Column(name = "obesidadGeneralizadaSeveraLaxitud")
    private String obesidadGeneralizadaSeveraLaxitud;
    @Size(max = 45)
    @Column(name = "minimaGrasaSubcutaneaExtensaLaxitud")
    private String minimaGrasaSubcutaneaExtensaLaxitud;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosExtremidadesSuperiores")
    private String comentariosExtremidadesSuperiores;
    @Size(max = 45)
    @Column(name = "extremidadesInferiores")
    private String extremidadesInferiores;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosExtremidadesInferiores")
    private String comentariosExtremidadesInferiores;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "diagnosticoExtremidadesInferiores")
    private String diagnosticoExtremidadesInferiores;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "planTratamientoExtremidadesInferiores")
    private String planTratamientoExtremidadesInferiores;
    @Size(max = 45)
    @Column(name = "reconstructivaCabezaCuello")
    private String reconstructivaCabezaCuello;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosReconstructivaCabezaCuello")
    private String comentariosReconstructivaCabezaCuello;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "diagnosticoReconstructivaCabezaCuello")
    private String diagnosticoReconstructivaCabezaCuello;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "planTratamientoReconstructivaCabezaCuello")
    private String planTratamientoReconstructivaCabezaCuello;
    @Size(max = 45)
    @Column(name = "reconstructivaCorporal")
    private String reconstructivaCorporal;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosReconstructivaCorporal")
    private String comentariosReconstructivaCorporal;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "diagnosticoReconstructivaCorporal")
    private String diagnosticoReconstructivaCorporal;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "planTratamientoReconstructivaCorporal")
    private String planTratamientoReconstructivaCorporal;
    @Size(max = 45)
    @Column(name = "fechaCreacionCp")
    private String fechaCreacionCp;
    @Size(max = 45)
    @Column(name = "horaCreacionCp")
    private String horaCreacionCp;
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentarioOtroColor")
    private String comentarioOtroColor;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "otraEstructura")
    private String otraEstructura;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "otroComponentePsiquico")
    private String otroComponentePsiquico;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "otraPerdidaZona")
    private String otraPerdidaZona;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "otroFormaMamariaDerecha")
    private String otroFormaMamariaDerecha;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "otroFormaMamariaIzquierda")
    private String otroFormaMamariaIzquierda;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "otroTipoDePielDerecha")
    private String otroTipoDePielDerecha;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "otroTipoDePielIzquierda")
    private String otroTipoDePielIzquierda;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "otraSensibilidadDerechaPezon")
    private String otraSensibilidadDerechaPezon;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "otraSensibilidadIzquierdaPezon")
    private String otraSensibilidadIzquierdaPezon;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "diametroComplejoAreolaDerecho")
    private String diametroComplejoAreolaDerecho;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "diametroComplejoAreolaIzquierdo")
    private String diametroComplejoAreolaIzquierdo;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "pronosticoMamario")
    private String pronosticoMamario;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "pronosticoAbdomen")
    private String pronosticoAbdomen;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "valoracionGenitourinaria")
    private String valoracionGenitourinaria;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosValoracionGenitourinaria")
    private String comentariosValoracionGenitourinaria;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "pronosticoEspalda")
    private String pronosticoEspalda;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "diagnosticoExtremidadesSuperiores")
    private String diagnosticoExtremidadesSuperiores;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "pronosticoExtremidadesSuperiores")
    private String pronosticoExtremidadesSuperiores;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "planTratamientoExtremidadesSuperiores")
    private String planTratamientoExtremidadesSuperiores;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "pronosticoExtremidadesInferiores")
    private String pronosticoExtremidadesInferiores;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "pronosticoReconstructivaCabezaCuello")
    private String pronosticoReconstructivaCabezaCuello;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "pronosticoReconstructivaCorporal")
    private String pronosticoReconstructivaCorporal;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "otroTipoGinecomastia")
    private String otroTipoGinecomastia;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "pronosticoGinecomastia")
    private String pronosticoGinecomastia;
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pacientes idPaciente;

    public CirugiaPlastica() {
    }

    public CirugiaPlastica(Integer idCirugiaPlastica) {
        this.idCirugiaPlastica = idCirugiaPlastica;
    }

    public Integer getIdCirugiaPlastica() {
        return idCirugiaPlastica;
    }

    public void setIdCirugiaPlastica(Integer idCirugiaPlastica) {
        this.idCirugiaPlastica = idCirugiaPlastica;
    }

    public String getEsteticaCabezaCuello() {
        return esteticaCabezaCuello;
    }

    public void setEsteticaCabezaCuello(String esteticaCabezaCuello) {
        this.esteticaCabezaCuello = esteticaCabezaCuello;
    }

    public String getAlopecia() {
        return alopecia;
    }

    public void setAlopecia(String alopecia) {
        this.alopecia = alopecia;
    }

    public String getCaidaDeCabello() {
        return caidaDeCabello;
    }

    public void setCaidaDeCabello(String caidaDeCabello) {
        this.caidaDeCabello = caidaDeCabello;
    }

    public String getEdadInicioDebilitamientoCapilar() {
        return edadInicioDebilitamientoCapilar;
    }

    public void setEdadInicioDebilitamientoCapilar(String edadInicioDebilitamientoCapilar) {
        this.edadInicioDebilitamientoCapilar = edadInicioDebilitamientoCapilar;
    }

    public String getEdadInicioCaidaCapilar() {
        return edadInicioCaidaCapilar;
    }

    public void setEdadInicioCaidaCapilar(String edadInicioCaidaCapilar) {
        this.edadInicioCaidaCapilar = edadInicioCaidaCapilar;
    }

    public String getEstabilizada() {
        return estabilizada;
    }

    public void setEstabilizada(String estabilizada) {
        this.estabilizada = estabilizada;
    }

    public String getAntecedentesFamiliares() {
        return antecedentesFamiliares;
    }

    public void setAntecedentesFamiliares(String antecedentesFamiliares) {
        this.antecedentesFamiliares = antecedentesFamiliares;
    }

    public String getTratamientosPrevios() {
        return tratamientosPrevios;
    }

    public void setTratamientosPrevios(String tratamientosPrevios) {
        this.tratamientosPrevios = tratamientosPrevios;
    }

    public String getCortes() {
        return cortes;
    }

    public void setCortes(String cortes) {
        this.cortes = cortes;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEspesorCabello() {
        return espesorCabello;
    }

    public void setEspesorCabello(String espesorCabello) {
        this.espesorCabello = espesorCabello;
    }

    public String getEstructura() {
        return estructura;
    }

    public void setEstructura(String estructura) {
        this.estructura = estructura;
    }

    public String getPoros() {
        return poros;
    }

    public void setPoros(String poros) {
        this.poros = poros;
    }

    public String getEspesorCueroCabelludo() {
        return espesorCueroCabelludo;
    }

    public void setEspesorCueroCabelludo(String espesorCueroCabelludo) {
        this.espesorCueroCabelludo = espesorCueroCabelludo;
    }

    public String getFlexibilidadCueroCabelludo() {
        return flexibilidadCueroCabelludo;
    }

    public void setFlexibilidadCueroCabelludo(String flexibilidadCueroCabelludo) {
        this.flexibilidadCueroCabelludo = flexibilidadCueroCabelludo;
    }

    public String getCicatrices() {
        return cicatrices;
    }

    public void setCicatrices(String cicatrices) {
        this.cicatrices = cicatrices;
    }

    public String getPullTest() {
        return pullTest;
    }

    public void setPullTest(String pullTest) {
        this.pullTest = pullTest;
    }

    public String getComponentesPsiquicos() {
        return componentesPsiquicos;
    }

    public void setComponentesPsiquicos(String componentesPsiquicos) {
        this.componentesPsiquicos = componentesPsiquicos;
    }

    public String getDensidadZonaFrontal() {
        return densidadZonaFrontal;
    }

    public void setDensidadZonaFrontal(String densidadZonaFrontal) {
        this.densidadZonaFrontal = densidadZonaFrontal;
    }

    public String getDensidadZonaOccipital() {
        return densidadZonaOccipital;
    }

    public void setDensidadZonaOccipital(String densidadZonaOccipital) {
        this.densidadZonaOccipital = densidadZonaOccipital;
    }

    public String getDensidadZonaTemporal() {
        return densidadZonaTemporal;
    }

    public void setDensidadZonaTemporal(String densidadZonaTemporal) {
        this.densidadZonaTemporal = densidadZonaTemporal;
    }

    public String getDensidadZonaParietal() {
        return densidadZonaParietal;
    }

    public void setDensidadZonaParietal(String densidadZonaParietal) {
        this.densidadZonaParietal = densidadZonaParietal;
    }

    public String getPerdidaZona() {
        return perdidaZona;
    }

    public void setPerdidaZona(String perdidaZona) {
        this.perdidaZona = perdidaZona;
    }

    public String getTipoAlopeciaNoCicatricial() {
        return tipoAlopeciaNoCicatricial;
    }

    public void setTipoAlopeciaNoCicatricial(String tipoAlopeciaNoCicatricial) {
        this.tipoAlopeciaNoCicatricial = tipoAlopeciaNoCicatricial;
    }

    public String getOtroTipoDeAlopeciaNoCicatricial() {
        return otroTipoDeAlopeciaNoCicatricial;
    }

    public void setOtroTipoDeAlopeciaNoCicatricial(String otroTipoDeAlopeciaNoCicatricial) {
        this.otroTipoDeAlopeciaNoCicatricial = otroTipoDeAlopeciaNoCicatricial;
    }

    public String getTipoAlopeciaCicatricial() {
        return tipoAlopeciaCicatricial;
    }

    public void setTipoAlopeciaCicatricial(String tipoAlopeciaCicatricial) {
        this.tipoAlopeciaCicatricial = tipoAlopeciaCicatricial;
    }

    public String getOtroTipoAlopeciaCicatricial() {
        return otroTipoAlopeciaCicatricial;
    }

    public void setOtroTipoAlopeciaCicatricial(String otroTipoAlopeciaCicatricial) {
        this.otroTipoAlopeciaCicatricial = otroTipoAlopeciaCicatricial;
    }

    public String getExpectativasPaciente() {
        return expectativasPaciente;
    }

    public void setExpectativasPaciente(String expectativasPaciente) {
        this.expectativasPaciente = expectativasPaciente;
    }

    public String getPropuestasTerapeuticas() {
        return propuestasTerapeuticas;
    }

    public void setPropuestasTerapeuticas(String propuestasTerapeuticas) {
        this.propuestasTerapeuticas = propuestasTerapeuticas;
    }

    public String getGradoDeAlopeciaHombre() {
        return gradoDeAlopeciaHombre;
    }

    public void setGradoDeAlopeciaHombre(String gradoDeAlopeciaHombre) {
        this.gradoDeAlopeciaHombre = gradoDeAlopeciaHombre;
    }

    public String getGradoDeAlopeciaMujer() {
        return gradoDeAlopeciaMujer;
    }

    public void setGradoDeAlopeciaMujer(String gradoDeAlopeciaMujer) {
        this.gradoDeAlopeciaMujer = gradoDeAlopeciaMujer;
    }

    public String getFacial() {
        return facial;
    }

    public void setFacial(String facial) {
        this.facial = facial;
    }

    public String getAntropometriaFrente() {
        return antropometriaFrente;
    }

    public void setAntropometriaFrente(String antropometriaFrente) {
        this.antropometriaFrente = antropometriaFrente;
    }

    public String getComentariosAntropometriaFrente() {
        return comentariosAntropometriaFrente;
    }

    public void setComentariosAntropometriaFrente(String comentariosAntropometriaFrente) {
        this.comentariosAntropometriaFrente = comentariosAntropometriaFrente;
    }

    public String getAntropometriaPerfil() {
        return antropometriaPerfil;
    }

    public void setAntropometriaPerfil(String antropometriaPerfil) {
        this.antropometriaPerfil = antropometriaPerfil;
    }

    public String getComentariosAntropometriaPerfil() {
        return comentariosAntropometriaPerfil;
    }

    public void setComentariosAntropometriaPerfil(String comentariosAntropometriaPerfil) {
        this.comentariosAntropometriaPerfil = comentariosAntropometriaPerfil;
    }

    public String getFrente() {
        return frente;
    }

    public void setFrente(String frente) {
        this.frente = frente;
    }

    public String getComentariosFrente() {
        return comentariosFrente;
    }

    public void setComentariosFrente(String comentariosFrente) {
        this.comentariosFrente = comentariosFrente;
    }

    public String getZonaPeriorbitaria() {
        return zonaPeriorbitaria;
    }

    public void setZonaPeriorbitaria(String zonaPeriorbitaria) {
        this.zonaPeriorbitaria = zonaPeriorbitaria;
    }

    public String getComentariosZonaPeriorbitaria() {
        return comentariosZonaPeriorbitaria;
    }

    public void setComentariosZonaPeriorbitaria(String comentariosZonaPeriorbitaria) {
        this.comentariosZonaPeriorbitaria = comentariosZonaPeriorbitaria;
    }

    public String getRegionMalar() {
        return regionMalar;
    }

    public void setRegionMalar(String regionMalar) {
        this.regionMalar = regionMalar;
    }

    public String getComentariosRegionMalar() {
        return comentariosRegionMalar;
    }

    public void setComentariosRegionMalar(String comentariosRegionMalar) {
        this.comentariosRegionMalar = comentariosRegionMalar;
    }

    public String getRegionMandibular() {
        return regionMandibular;
    }

    public void setRegionMandibular(String regionMandibular) {
        this.regionMandibular = regionMandibular;
    }

    public String getComentariosRegionMandibular() {
        return comentariosRegionMandibular;
    }

    public void setComentariosRegionMandibular(String comentariosRegionMandibular) {
        this.comentariosRegionMandibular = comentariosRegionMandibular;
    }

    public String getAuricular() {
        return auricular;
    }

    public void setAuricular(String auricular) {
        this.auricular = auricular;
    }

    public String getComentariosAuricular() {
        return comentariosAuricular;
    }

    public void setComentariosAuricular(String comentariosAuricular) {
        this.comentariosAuricular = comentariosAuricular;
    }

    public String getNasal() {
        return nasal;
    }

    public void setNasal(String nasal) {
        this.nasal = nasal;
    }

    public String getComentariosNasal() {
        return comentariosNasal;
    }

    public void setComentariosNasal(String comentariosNasal) {
        this.comentariosNasal = comentariosNasal;
    }

    public String getPeriBucal() {
        return periBucal;
    }

    public void setPeriBucal(String periBucal) {
        this.periBucal = periBucal;
    }

    public String getComentariosPeriBucal() {
        return comentariosPeriBucal;
    }

    public void setComentariosPeriBucal(String comentariosPeriBucal) {
        this.comentariosPeriBucal = comentariosPeriBucal;
    }

    public String getMentoniana() {
        return mentoniana;
    }

    public void setMentoniana(String mentoniana) {
        this.mentoniana = mentoniana;
    }

    public String getComentariosMentoniana() {
        return comentariosMentoniana;
    }

    public void setComentariosMentoniana(String comentariosMentoniana) {
        this.comentariosMentoniana = comentariosMentoniana;
    }

    public String getCervical() {
        return cervical;
    }

    public void setCervical(String cervical) {
        this.cervical = cervical;
    }

    public String getComentariosCervical() {
        return comentariosCervical;
    }

    public void setComentariosCervical(String comentariosCervical) {
        this.comentariosCervical = comentariosCervical;
    }

    public String getEsteticaCorporal() {
        return esteticaCorporal;
    }

    public void setEsteticaCorporal(String esteticaCorporal) {
        this.esteticaCorporal = esteticaCorporal;
    }

    public String getRegionToracicaAnterior() {
        return regionToracicaAnterior;
    }

    public void setRegionToracicaAnterior(String regionToracicaAnterior) {
        this.regionToracicaAnterior = regionToracicaAnterior;
    }

    public String getAntecedentesMamarios() {
        return antecedentesMamarios;
    }

    public void setAntecedentesMamarios(String antecedentesMamarios) {
        this.antecedentesMamarios = antecedentesMamarios;
    }

    public String getComentariosAntecedentesMamarios() {
        return comentariosAntecedentesMamarios;
    }

    public void setComentariosAntecedentesMamarios(String comentariosAntecedentesMamarios) {
        this.comentariosAntecedentesMamarios = comentariosAntecedentesMamarios;
    }

    public String getMamografias() {
        return mamografias;
    }

    public void setMamografias(String mamografias) {
        this.mamografias = mamografias;
    }

    public String getComentariosMamografias() {
        return comentariosMamografias;
    }

    public void setComentariosMamografias(String comentariosMamografias) {
        this.comentariosMamografias = comentariosMamografias;
    }

    public String getAutoexamen() {
        return autoexamen;
    }

    public void setAutoexamen(String autoexamen) {
        this.autoexamen = autoexamen;
    }

    public String getComentariosAutoexamen() {
        return comentariosAutoexamen;
    }

    public void setComentariosAutoexamen(String comentariosAutoexamen) {
        this.comentariosAutoexamen = comentariosAutoexamen;
    }

    public String getVolumenMamarioDerecho() {
        return volumenMamarioDerecho;
    }

    public void setVolumenMamarioDerecho(String volumenMamarioDerecho) {
        this.volumenMamarioDerecho = volumenMamarioDerecho;
    }

    public String getHipertrofiaVolumenMamarioDerecho() {
        return hipertrofiaVolumenMamarioDerecho;
    }

    public void setHipertrofiaVolumenMamarioDerecho(String hipertrofiaVolumenMamarioDerecho) {
        this.hipertrofiaVolumenMamarioDerecho = hipertrofiaVolumenMamarioDerecho;
    }

    public String getVolumenMamarioIzquierdo() {
        return volumenMamarioIzquierdo;
    }

    public void setVolumenMamarioIzquierdo(String volumenMamarioIzquierdo) {
        this.volumenMamarioIzquierdo = volumenMamarioIzquierdo;
    }

    public String getHipertrofiaVolumenMamarioIzquierdo() {
        return hipertrofiaVolumenMamarioIzquierdo;
    }

    public void setHipertrofiaVolumenMamarioIzquierdo(String hipertrofiaVolumenMamarioIzquierdo) {
        this.hipertrofiaVolumenMamarioIzquierdo = hipertrofiaVolumenMamarioIzquierdo;
    }

    public String getFormaMamariaDerecha() {
        return formaMamariaDerecha;
    }

    public void setFormaMamariaDerecha(String formaMamariaDerecha) {
        this.formaMamariaDerecha = formaMamariaDerecha;
    }

    public String getFormaMamariaIzquierda() {
        return formaMamariaIzquierda;
    }

    public void setFormaMamariaIzquierda(String formaMamariaIzquierda) {
        this.formaMamariaIzquierda = formaMamariaIzquierda;
    }

    public String getPtosisMamaria() {
        return ptosisMamaria;
    }

    public void setPtosisMamaria(String ptosisMamaria) {
        this.ptosisMamaria = ptosisMamaria;
    }

    public String getClasificacionPtosisRegnoult() {
        return clasificacionPtosisRegnoult;
    }

    public void setClasificacionPtosisRegnoult(String clasificacionPtosisRegnoult) {
        this.clasificacionPtosisRegnoult = clasificacionPtosisRegnoult;
    }

    public String getTipoPielDerecha() {
        return tipoPielDerecha;
    }

    public void setTipoPielDerecha(String tipoPielDerecha) {
        this.tipoPielDerecha = tipoPielDerecha;
    }

    public String getTipoPielIzquierda() {
        return tipoPielIzquierda;
    }

    public void setTipoPielIzquierda(String tipoPielIzquierda) {
        this.tipoPielIzquierda = tipoPielIzquierda;
    }

    public String getSensibilidadPezonDerecho() {
        return sensibilidadPezonDerecho;
    }

    public void setSensibilidadPezonDerecho(String sensibilidadPezonDerecho) {
        this.sensibilidadPezonDerecho = sensibilidadPezonDerecho;
    }

    public String getSensibilidadPezonIzquierdo() {
        return sensibilidadPezonIzquierdo;
    }

    public void setSensibilidadPezonIzquierdo(String sensibilidadPezonIzquierdo) {
        this.sensibilidadPezonIzquierdo = sensibilidadPezonIzquierdo;
    }

    public String getDiametroComplejoAreola() {
        return diametroComplejoAreola;
    }

    public void setDiametroComplejoAreola(String diametroComplejoAreola) {
        this.diametroComplejoAreola = diametroComplejoAreola;
    }

    public String getDiagramaPosicionDerecho() {
        return diagramaPosicionDerecho;
    }

    public void setDiagramaPosicionDerecho(String diagramaPosicionDerecho) {
        this.diagramaPosicionDerecho = diagramaPosicionDerecho;
    }

    public String getBaseMamariaDerecho() {
        return baseMamariaDerecho;
    }

    public void setBaseMamariaDerecho(String baseMamariaDerecho) {
        this.baseMamariaDerecho = baseMamariaDerecho;
    }

    public String getMedidaToraxDerecho() {
        return medidaToraxDerecho;
    }

    public void setMedidaToraxDerecho(String medidaToraxDerecho) {
        this.medidaToraxDerecho = medidaToraxDerecho;
    }

    public String getDiagramaPosicionIzquierdo() {
        return diagramaPosicionIzquierdo;
    }

    public void setDiagramaPosicionIzquierdo(String diagramaPosicionIzquierdo) {
        this.diagramaPosicionIzquierdo = diagramaPosicionIzquierdo;
    }

    public String getBaseMamariaIzquierdo() {
        return baseMamariaIzquierdo;
    }

    public void setBaseMamariaIzquierdo(String baseMamariaIzquierdo) {
        this.baseMamariaIzquierdo = baseMamariaIzquierdo;
    }

    public String getMedidaToraxIzquierdo() {
        return medidaToraxIzquierdo;
    }

    public void setMedidaToraxIzquierdo(String medidaToraxIzquierdo) {
        this.medidaToraxIzquierdo = medidaToraxIzquierdo;
    }

    public String getDiagnosticoMamario() {
        return diagnosticoMamario;
    }

    public void setDiagnosticoMamario(String diagnosticoMamario) {
        this.diagnosticoMamario = diagnosticoMamario;
    }

    public String getOtrosDiagnosticosMamarios() {
        return otrosDiagnosticosMamarios;
    }

    public void setOtrosDiagnosticosMamarios(String otrosDiagnosticosMamarios) {
        this.otrosDiagnosticosMamarios = otrosDiagnosticosMamarios;
    }

    public String getPlanTratamientoMamario() {
        return planTratamientoMamario;
    }

    public void setPlanTratamientoMamario(String planTratamientoMamario) {
        this.planTratamientoMamario = planTratamientoMamario;
    }

    public String getGinecomastia() {
        return ginecomastia;
    }

    public void setGinecomastia(String ginecomastia) {
        this.ginecomastia = ginecomastia;
    }

    public String getClasificacionWiesman() {
        return clasificacionWiesman;
    }

    public void setClasificacionWiesman(String clasificacionWiesman) {
        this.clasificacionWiesman = clasificacionWiesman;
    }

    public String getAntecedentesGinecomastia() {
        return antecedentesGinecomastia;
    }

    public void setAntecedentesGinecomastia(String antecedentesGinecomastia) {
        this.antecedentesGinecomastia = antecedentesGinecomastia;
    }

    public String getTipoGinecomastia() {
        return tipoGinecomastia;
    }

    public void setTipoGinecomastia(String tipoGinecomastia) {
        this.tipoGinecomastia = tipoGinecomastia;
    }

    public String getComentariosTipoGinecomastia() {
        return comentariosTipoGinecomastia;
    }

    public void setComentariosTipoGinecomastia(String comentariosTipoGinecomastia) {
        this.comentariosTipoGinecomastia = comentariosTipoGinecomastia;
    }

    public String getPectorales() {
        return pectorales;
    }

    public void setPectorales(String pectorales) {
        this.pectorales = pectorales;
    }

    public String getOtrosDiagnosticosGinecomastia() {
        return otrosDiagnosticosGinecomastia;
    }

    public void setOtrosDiagnosticosGinecomastia(String otrosDiagnosticosGinecomastia) {
        this.otrosDiagnosticosGinecomastia = otrosDiagnosticosGinecomastia;
    }

    public String getPlanTratamientoGinecomastia() {
        return planTratamientoGinecomastia;
    }

    public void setPlanTratamientoGinecomastia(String planTratamientoGinecomastia) {
        this.planTratamientoGinecomastia = planTratamientoGinecomastia;
    }

    public String getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(String abdomen) {
        this.abdomen = abdomen;
    }

    public String getClasificacionMatarasso() {
        return clasificacionMatarasso;
    }

    public void setClasificacionMatarasso(String clasificacionMatarasso) {
        this.clasificacionMatarasso = clasificacionMatarasso;
    }

    public String getComentariosAbdomen() {
        return comentariosAbdomen;
    }

    public void setComentariosAbdomen(String comentariosAbdomen) {
        this.comentariosAbdomen = comentariosAbdomen;
    }

    public String getDiagnosticoAbdomen() {
        return diagnosticoAbdomen;
    }

    public void setDiagnosticoAbdomen(String diagnosticoAbdomen) {
        this.diagnosticoAbdomen = diagnosticoAbdomen;
    }

    public String getPlanTratamientoAbdomen() {
        return planTratamientoAbdomen;
    }

    public void setPlanTratamientoAbdomen(String planTratamientoAbdomen) {
        this.planTratamientoAbdomen = planTratamientoAbdomen;
    }

    public String getEspalda() {
        return espalda;
    }

    public void setEspalda(String espalda) {
        this.espalda = espalda;
    }

    public String getComentariosEspalda() {
        return comentariosEspalda;
    }

    public void setComentariosEspalda(String comentariosEspalda) {
        this.comentariosEspalda = comentariosEspalda;
    }

    public String getDiagnosticoEspalda() {
        return diagnosticoEspalda;
    }

    public void setDiagnosticoEspalda(String diagnosticoEspalda) {
        this.diagnosticoEspalda = diagnosticoEspalda;
    }

    public String getPlanTratamientoEspalda() {
        return planTratamientoEspalda;
    }

    public void setPlanTratamientoEspalda(String planTratamientoEspalda) {
        this.planTratamientoEspalda = planTratamientoEspalda;
    }

    public String getGluteos() {
        return gluteos;
    }

    public void setGluteos(String gluteos) {
        this.gluteos = gluteos;
    }

    public String getVolumenGluteos() {
        return volumenGluteos;
    }

    public void setVolumenGluteos(String volumenGluteos) {
        this.volumenGluteos = volumenGluteos;
    }

    public String getPosicionGluteos() {
        return posicionGluteos;
    }

    public void setPosicionGluteos(String posicionGluteos) {
        this.posicionGluteos = posicionGluteos;
    }

    public String getFormaGluteos() {
        return formaGluteos;
    }

    public void setFormaGluteos(String formaGluteos) {
        this.formaGluteos = formaGluteos;
    }

    public String getCaracteristicasPielGluteos() {
        return caracteristicasPielGluteos;
    }

    public void setCaracteristicasPielGluteos(String caracteristicasPielGluteos) {
        this.caracteristicasPielGluteos = caracteristicasPielGluteos;
    }

    public String getAsimetria() {
        return asimetria;
    }

    public void setAsimetria(String asimetria) {
        this.asimetria = asimetria;
    }

    public String getSecuelasTrauma() {
        return secuelasTrauma;
    }

    public void setSecuelasTrauma(String secuelasTrauma) {
        this.secuelasTrauma = secuelasTrauma;
    }

    public String getComentariosGluteos() {
        return comentariosGluteos;
    }

    public void setComentariosGluteos(String comentariosGluteos) {
        this.comentariosGluteos = comentariosGluteos;
    }

    public String getExtremidadesSuperiores() {
        return extremidadesSuperiores;
    }

    public void setExtremidadesSuperiores(String extremidadesSuperiores) {
        this.extremidadesSuperiores = extremidadesSuperiores;
    }

    public String getDepositoGrasaMinimoModeradoMinimaLaxitud() {
        return depositoGrasaMinimoModeradoMinimaLaxitud;
    }

    public void setDepositoGrasaMinimoModeradoMinimaLaxitud(String depositoGrasaMinimoModeradoMinimaLaxitud) {
        this.depositoGrasaMinimoModeradoMinimaLaxitud = depositoGrasaMinimoModeradoMinimaLaxitud;
    }

    public String getDepositoGrasaGeneralizadaModeradaLaxitud() {
        return depositoGrasaGeneralizadaModeradaLaxitud;
    }

    public void setDepositoGrasaGeneralizadaModeradaLaxitud(String depositoGrasaGeneralizadaModeradaLaxitud) {
        this.depositoGrasaGeneralizadaModeradaLaxitud = depositoGrasaGeneralizadaModeradaLaxitud;
    }

    public String getObesidadGeneralizadaSeveraLaxitud() {
        return obesidadGeneralizadaSeveraLaxitud;
    }

    public void setObesidadGeneralizadaSeveraLaxitud(String obesidadGeneralizadaSeveraLaxitud) {
        this.obesidadGeneralizadaSeveraLaxitud = obesidadGeneralizadaSeveraLaxitud;
    }

    public String getMinimaGrasaSubcutaneaExtensaLaxitud() {
        return minimaGrasaSubcutaneaExtensaLaxitud;
    }

    public void setMinimaGrasaSubcutaneaExtensaLaxitud(String minimaGrasaSubcutaneaExtensaLaxitud) {
        this.minimaGrasaSubcutaneaExtensaLaxitud = minimaGrasaSubcutaneaExtensaLaxitud;
    }

    public String getComentariosExtremidadesSuperiores() {
        return comentariosExtremidadesSuperiores;
    }

    public void setComentariosExtremidadesSuperiores(String comentariosExtremidadesSuperiores) {
        this.comentariosExtremidadesSuperiores = comentariosExtremidadesSuperiores;
    }

    public String getExtremidadesInferiores() {
        return extremidadesInferiores;
    }

    public void setExtremidadesInferiores(String extremidadesInferiores) {
        this.extremidadesInferiores = extremidadesInferiores;
    }

    public String getComentariosExtremidadesInferiores() {
        return comentariosExtremidadesInferiores;
    }

    public void setComentariosExtremidadesInferiores(String comentariosExtremidadesInferiores) {
        this.comentariosExtremidadesInferiores = comentariosExtremidadesInferiores;
    }

    public String getDiagnosticoExtremidadesInferiores() {
        return diagnosticoExtremidadesInferiores;
    }

    public void setDiagnosticoExtremidadesInferiores(String diagnosticoExtremidadesInferiores) {
        this.diagnosticoExtremidadesInferiores = diagnosticoExtremidadesInferiores;
    }

    public String getPlanTratamientoExtremidadesInferiores() {
        return planTratamientoExtremidadesInferiores;
    }

    public void setPlanTratamientoExtremidadesInferiores(String planTratamientoExtremidadesInferiores) {
        this.planTratamientoExtremidadesInferiores = planTratamientoExtremidadesInferiores;
    }

    public String getReconstructivaCabezaCuello() {
        return reconstructivaCabezaCuello;
    }

    public void setReconstructivaCabezaCuello(String reconstructivaCabezaCuello) {
        this.reconstructivaCabezaCuello = reconstructivaCabezaCuello;
    }

    public String getComentariosReconstructivaCabezaCuello() {
        return comentariosReconstructivaCabezaCuello;
    }

    public void setComentariosReconstructivaCabezaCuello(String comentariosReconstructivaCabezaCuello) {
        this.comentariosReconstructivaCabezaCuello = comentariosReconstructivaCabezaCuello;
    }

    public String getDiagnosticoReconstructivaCabezaCuello() {
        return diagnosticoReconstructivaCabezaCuello;
    }

    public void setDiagnosticoReconstructivaCabezaCuello(String diagnosticoReconstructivaCabezaCuello) {
        this.diagnosticoReconstructivaCabezaCuello = diagnosticoReconstructivaCabezaCuello;
    }

    public String getPlanTratamientoReconstructivaCabezaCuello() {
        return planTratamientoReconstructivaCabezaCuello;
    }

    public void setPlanTratamientoReconstructivaCabezaCuello(String planTratamientoReconstructivaCabezaCuello) {
        this.planTratamientoReconstructivaCabezaCuello = planTratamientoReconstructivaCabezaCuello;
    }

    public String getReconstructivaCorporal() {
        return reconstructivaCorporal;
    }

    public void setReconstructivaCorporal(String reconstructivaCorporal) {
        this.reconstructivaCorporal = reconstructivaCorporal;
    }

    public String getComentariosReconstructivaCorporal() {
        return comentariosReconstructivaCorporal;
    }

    public void setComentariosReconstructivaCorporal(String comentariosReconstructivaCorporal) {
        this.comentariosReconstructivaCorporal = comentariosReconstructivaCorporal;
    }

    public String getDiagnosticoReconstructivaCorporal() {
        return diagnosticoReconstructivaCorporal;
    }

    public void setDiagnosticoReconstructivaCorporal(String diagnosticoReconstructivaCorporal) {
        this.diagnosticoReconstructivaCorporal = diagnosticoReconstructivaCorporal;
    }

    public String getPlanTratamientoReconstructivaCorporal() {
        return planTratamientoReconstructivaCorporal;
    }

    public void setPlanTratamientoReconstructivaCorporal(String planTratamientoReconstructivaCorporal) {
        this.planTratamientoReconstructivaCorporal = planTratamientoReconstructivaCorporal;
    }

    public String getFechaCreacionCp() {
        return fechaCreacionCp;
    }

    public void setFechaCreacionCp(String fechaCreacionCp) {
        this.fechaCreacionCp = fechaCreacionCp;
    }

    public String getHoraCreacionCp() {
        return horaCreacionCp;
    }

    public void setHoraCreacionCp(String horaCreacionCp) {
        this.horaCreacionCp = horaCreacionCp;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getComentarioOtroColor() {
        return comentarioOtroColor;
    }

    public void setComentarioOtroColor(String comentarioOtroColor) {
        this.comentarioOtroColor = comentarioOtroColor;
    }

    public String getOtraEstructura() {
        return otraEstructura;
    }

    public void setOtraEstructura(String otraEstructura) {
        this.otraEstructura = otraEstructura;
    }

    public String getOtroComponentePsiquico() {
        return otroComponentePsiquico;
    }

    public void setOtroComponentePsiquico(String otroComponentePsiquico) {
        this.otroComponentePsiquico = otroComponentePsiquico;
    }

    public String getOtraPerdidaZona() {
        return otraPerdidaZona;
    }

    public void setOtraPerdidaZona(String otraPerdidaZona) {
        this.otraPerdidaZona = otraPerdidaZona;
    }

    public String getOtroFormaMamariaDerecha() {
        return otroFormaMamariaDerecha;
    }

    public void setOtroFormaMamariaDerecha(String otroFormaMamariaDerecha) {
        this.otroFormaMamariaDerecha = otroFormaMamariaDerecha;
    }

    public String getOtroFormaMamariaIzquierda() {
        return otroFormaMamariaIzquierda;
    }

    public void setOtroFormaMamariaIzquierda(String otroFormaMamariaIzquierda) {
        this.otroFormaMamariaIzquierda = otroFormaMamariaIzquierda;
    }

    public String getOtroTipoDePielDerecha() {
        return otroTipoDePielDerecha;
    }

    public void setOtroTipoDePielDerecha(String otroTipoDePielDerecha) {
        this.otroTipoDePielDerecha = otroTipoDePielDerecha;
    }

    public String getOtroTipoDePielIzquierda() {
        return otroTipoDePielIzquierda;
    }

    public void setOtroTipoDePielIzquierda(String otroTipoDePielIzquierda) {
        this.otroTipoDePielIzquierda = otroTipoDePielIzquierda;
    }

    public String getOtraSensibilidadDerechaPezon() {
        return otraSensibilidadDerechaPezon;
    }

    public void setOtraSensibilidadDerechaPezon(String otraSensibilidadDerechaPezon) {
        this.otraSensibilidadDerechaPezon = otraSensibilidadDerechaPezon;
    }

    public String getOtraSensibilidadIzquierdaPezon() {
        return otraSensibilidadIzquierdaPezon;
    }

    public void setOtraSensibilidadIzquierdaPezon(String otraSensibilidadIzquierdaPezon) {
        this.otraSensibilidadIzquierdaPezon = otraSensibilidadIzquierdaPezon;
    }

    public String getDiametroComplejoAreolaDerecho() {
        return diametroComplejoAreolaDerecho;
    }

    public void setDiametroComplejoAreolaDerecho(String diametroComplejoAreolaDerecho) {
        this.diametroComplejoAreolaDerecho = diametroComplejoAreolaDerecho;
    }

    public String getDiametroComplejoAreolaIzquierdo() {
        return diametroComplejoAreolaIzquierdo;
    }

    public void setDiametroComplejoAreolaIzquierdo(String diametroComplejoAreolaIzquierdo) {
        this.diametroComplejoAreolaIzquierdo = diametroComplejoAreolaIzquierdo;
    }

    public String getPronosticoMamario() {
        return pronosticoMamario;
    }

    public void setPronosticoMamario(String pronosticoMamario) {
        this.pronosticoMamario = pronosticoMamario;
    }

    public String getPronosticoAbdomen() {
        return pronosticoAbdomen;
    }

    public void setPronosticoAbdomen(String pronosticoAbdomen) {
        this.pronosticoAbdomen = pronosticoAbdomen;
    }

    public String getValoracionGenitourinaria() {
        return valoracionGenitourinaria;
    }

    public void setValoracionGenitourinaria(String valoracionGenitourinaria) {
        this.valoracionGenitourinaria = valoracionGenitourinaria;
    }

    public String getComentariosValoracionGenitourinaria() {
        return comentariosValoracionGenitourinaria;
    }

    public void setComentariosValoracionGenitourinaria(String comentariosValoracionGenitourinaria) {
        this.comentariosValoracionGenitourinaria = comentariosValoracionGenitourinaria;
    }

    public String getPronosticoEspalda() {
        return pronosticoEspalda;
    }

    public void setPronosticoEspalda(String pronosticoEspalda) {
        this.pronosticoEspalda = pronosticoEspalda;
    }

    public String getDiagnosticoExtremidadesSuperiores() {
        return diagnosticoExtremidadesSuperiores;
    }

    public void setDiagnosticoExtremidadesSuperiores(String diagnosticoExtremidadesSuperiores) {
        this.diagnosticoExtremidadesSuperiores = diagnosticoExtremidadesSuperiores;
    }

    public String getPronosticoExtremidadesSuperiores() {
        return pronosticoExtremidadesSuperiores;
    }

    public void setPronosticoExtremidadesSuperiores(String pronosticoExtremidadesSuperiores) {
        this.pronosticoExtremidadesSuperiores = pronosticoExtremidadesSuperiores;
    }

    public String getPlanTratamientoExtremidadesSuperiores() {
        return planTratamientoExtremidadesSuperiores;
    }

    public void setPlanTratamientoExtremidadesSuperiores(String planTratamientoExtremidadesSuperiores) {
        this.planTratamientoExtremidadesSuperiores = planTratamientoExtremidadesSuperiores;
    }

    public String getPronosticoExtremidadesInferiores() {
        return pronosticoExtremidadesInferiores;
    }

    public void setPronosticoExtremidadesInferiores(String pronosticoExtremidadesInferiores) {
        this.pronosticoExtremidadesInferiores = pronosticoExtremidadesInferiores;
    }

    public String getPronosticoReconstructivaCabezaCuello() {
        return pronosticoReconstructivaCabezaCuello;
    }

    public void setPronosticoReconstructivaCabezaCuello(String pronosticoReconstructivaCabezaCuello) {
        this.pronosticoReconstructivaCabezaCuello = pronosticoReconstructivaCabezaCuello;
    }

    public String getPronosticoReconstructivaCorporal() {
        return pronosticoReconstructivaCorporal;
    }

    public void setPronosticoReconstructivaCorporal(String pronosticoReconstructivaCorporal) {
        this.pronosticoReconstructivaCorporal = pronosticoReconstructivaCorporal;
    }

    public String getOtroTipoGinecomastia() {
        return otroTipoGinecomastia;
    }

    public void setOtroTipoGinecomastia(String otroTipoGinecomastia) {
        this.otroTipoGinecomastia = otroTipoGinecomastia;
    }

    public String getPronosticoGinecomastia() {
        return pronosticoGinecomastia;
    }

    public void setPronosticoGinecomastia(String pronosticoGinecomastia) {
        this.pronosticoGinecomastia = pronosticoGinecomastia;
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
        hash += (idCirugiaPlastica != null ? idCirugiaPlastica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CirugiaPlastica)) {
            return false;
        }
        CirugiaPlastica other = (CirugiaPlastica) object;
        if ((this.idCirugiaPlastica == null && other.idCirugiaPlastica != null) || (this.idCirugiaPlastica != null && !this.idCirugiaPlastica.equals(other.idCirugiaPlastica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.saludtec.entidades.CirugiaPlastica[ idCirugiaPlastica=" + idCirugiaPlastica + " ]";
    }

}
