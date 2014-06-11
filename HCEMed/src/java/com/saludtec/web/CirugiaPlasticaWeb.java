/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.web;

import com.saludtec.entidades.CirugiaPlastica;
import com.saludtec.entidades.Pacientes;
import com.saludtec.jpa.CirugiaPlasticaEjb;
import com.saludtec.jpa.PacientesEjb;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author saintec
 */
@WebServlet(name = "CirugiaPlasticaWeb", urlPatterns = {"/CirugiaPlastica/*"})
public class CirugiaPlasticaWeb extends HttpServlet {

    @EJB
    CirugiaPlasticaEjb ejbCirugiaPlastica;
    @EJB
    PacientesEjb ejbPacientes;
    JSONObject obj;
    JSONArray objArray;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String servicio = request.getRequestURI().replace("/HCEMed/CirugiaPlastica/", "");
            switch (servicio) {
                case "guardar":
                    guardarCirugiaPlastica(request).writeJSONString(out);
                    break;

                case "traerUltimo":
                    traerUltimoCirugiaPlastica(request).writeJSONString(out);
                    break;

                case "traerFecha":
                    traerCirugiaPlasticaFecha(request).writeJSONString(out);
                    break;

                default:
                    obj = new JSONObject();
                    objArray = new JSONArray();
                    obj.put("error", "404 - El servicio " + servicio + " no existe");
                    objArray.add(obj);
                    objArray.writeJSONString(out);
                    break;
            }
        }
    }

    private JSONArray guardarCirugiaPlastica(HttpServletRequest request) {
        CirugiaPlastica cirugiaPlastica = new CirugiaPlastica();
        Pacientes paciente = ejbPacientes.traer(Integer.parseInt(request.getParameter("idPaciente")));
        cirugiaPlastica.setIdPaciente(paciente);
//-----------------ESTETICA CABEZA CUELLO----------------->//-----------------ESTETICA CABEZA CUELLO----------------->
        cirugiaPlastica.setEsteticaCabezaCuello(request.getParameter("esteticaCabezaCuello"));
//ALOPECIA----->//ALOPECIA----->
        cirugiaPlastica.setAlopecia(request.getParameter("alopecia"));
        cirugiaPlastica.setCaidaDeCabello(request.getParameter("caidaDeCabello"));
        cirugiaPlastica.setEdadInicioDebilitamientoCapilar(request.getParameter("edadInicioDebilitamientoCapilar"));
        cirugiaPlastica.setEdadInicioCaidaCapilar(request.getParameter("edadInicioCaidaCapilar"));
        cirugiaPlastica.setEstabilizada(request.getParameter("estabilizada"));
        cirugiaPlastica.setAntecedentesFamiliares(request.getParameter("antecedentesFamiliares"));
        cirugiaPlastica.setTratamientosPrevios(request.getParameter("tratamientosPrevios"));
        cirugiaPlastica.setCortes(request.getParameter("cortes"));
        cirugiaPlastica.setColor(request.getParameter("color"));
        cirugiaPlastica.setComentarioOtroColor(request.getParameter("comentarioOtroColor"));
        cirugiaPlastica.setEspesorCabello(request.getParameter("espesorCabello"));
        cirugiaPlastica.setEstructura(request.getParameter("estructura"));
        cirugiaPlastica.setOtraEstructura(request.getParameter("otraEstructura"));
        cirugiaPlastica.setPoros(request.getParameter("poros"));
        cirugiaPlastica.setEspesorCueroCabelludo(request.getParameter("espesorCueroCabelludo"));
        cirugiaPlastica.setFlexibilidadCueroCabelludo(request.getParameter("flexibilidadCueroCabelludo"));
        cirugiaPlastica.setCicatrices(request.getParameter("cicatrices"));
        cirugiaPlastica.setPullTest(request.getParameter("pullTest"));
        cirugiaPlastica.setComponentesPsiquicos(request.getParameter("componentesPsiquicos"));
        cirugiaPlastica.setOtroComponentePsiquico(request.getParameter("otroComponentePsiquico"));
        cirugiaPlastica.setDensidadZonaFrontal(request.getParameter("densidadZonaFrontal"));
        cirugiaPlastica.setDensidadZonaOccipital(request.getParameter("densidadZonaOccipital"));
        cirugiaPlastica.setDensidadZonaTemporal(request.getParameter("densidadZonaTemporal"));
        cirugiaPlastica.setDensidadZonaParietal(request.getParameter("densidadZonaParietal"));
        cirugiaPlastica.setPerdidaZona(request.getParameter("perdidaZona"));
        cirugiaPlastica.setOtraPerdidaZona(request.getParameter("otraPerdidaZona"));
        cirugiaPlastica.setTipoAlopeciaNoCicatricial(request.getParameter("tipoAlopeciaNoCicatricial"));
        cirugiaPlastica.setOtroTipoDeAlopeciaNoCicatricial(request.getParameter("otroTipoDeAlopeciaNoCicatricial"));
        cirugiaPlastica.setTipoAlopeciaCicatricial(request.getParameter("tipoAlopeciaCicatricial"));
        cirugiaPlastica.setOtroTipoAlopeciaCicatricial(request.getParameter("otroTipoAlopeciaCicatricial"));
        cirugiaPlastica.setExpectativasPaciente(request.getParameter("expectativasPaciente"));
        cirugiaPlastica.setPropuestasTerapeuticas(request.getParameter("propuestasTerapeuticas"));
        cirugiaPlastica.setGradoDeAlopeciaHombre(request.getParameter("gradoDeAlopeciaHombre"));
        cirugiaPlastica.setGradoDeAlopeciaMujer(request.getParameter("gradoDeAlopeciaMujer"));
//FACIAL------------->//FACIAL------------->
        cirugiaPlastica.setFacial(request.getParameter("facial"));
        cirugiaPlastica.setAntropometriaFrente(request.getParameter("antropometriaFrente"));
        cirugiaPlastica.setComentariosAntropometriaFrente(request.getParameter("comentariosAntropometriaFrente"));
        cirugiaPlastica.setAntropometriaPerfil(request.getParameter("antropometriaPerfil"));
        cirugiaPlastica.setComentariosAntropometriaPerfil(request.getParameter("comentariosAntropometriaPerfil"));
        cirugiaPlastica.setFrente(request.getParameter("frente"));
        cirugiaPlastica.setComentariosFrente(request.getParameter("comentariosFrente"));
        cirugiaPlastica.setZonaPeriorbitaria(request.getParameter("zonaPeriorbitaria"));
        cirugiaPlastica.setComentariosZonaPeriorbitaria(request.getParameter("comentariosZonaPeriorbitaria"));
        cirugiaPlastica.setRegionMalar(request.getParameter("regionMalar"));
        cirugiaPlastica.setComentariosRegionMalar(request.getParameter("comentariosRegionMalar"));
        cirugiaPlastica.setRegionMandibular(request.getParameter("regionMandibular"));
        cirugiaPlastica.setComentariosRegionMandibular(request.getParameter("comentariosRegionMandibular"));
        cirugiaPlastica.setAuricular(request.getParameter("auricular"));
        cirugiaPlastica.setComentariosAuricular(request.getParameter("comentariosAuricular"));
        cirugiaPlastica.setNasal(request.getParameter("nasal"));
        cirugiaPlastica.setComentariosNasal(request.getParameter("comentariosNasal"));
        cirugiaPlastica.setPeriBucal(request.getParameter("periBucal"));
        cirugiaPlastica.setComentariosPeriBucal(request.getParameter("comentariosPeriBucal"));
        cirugiaPlastica.setMentoniana(request.getParameter("mentoniana"));
        cirugiaPlastica.setComentariosMentoniana(request.getParameter("comentariosMentoniana"));
        cirugiaPlastica.setCervical(request.getParameter("cervical"));
        cirugiaPlastica.setComentariosCervical(request.getParameter("comentariosCervical"));
//-----------------ESTETICA CORPORAL----------------->//-----------------ESTETICA CORPORAL----------------->
        cirugiaPlastica.setEsteticaCorporal(request.getParameter("esteticaCorporal"));
//REGION TORACICA ANTERIOR---------->//REGION TORACICA ANTERIOR---------->
        cirugiaPlastica.setRegionToracicaAnterior(request.getParameter("regionToracicaAnterior"));
//MUJER--------------->//MUJER--------------->
        cirugiaPlastica.setAntecedentesMamarios(request.getParameter("antecedentesMamarios"));
        cirugiaPlastica.setComentariosAntecedentesMamarios(request.getParameter("comentariosAntecedentesMamarios"));
        cirugiaPlastica.setMamografias(request.getParameter("mamografias"));
        cirugiaPlastica.setComentariosMamografias(request.getParameter("comentariosMamografias"));
        cirugiaPlastica.setAutoexamen(request.getParameter("autoexamen"));
        cirugiaPlastica.setComentariosAutoexamen(request.getParameter("comentariosAutoexamen"));
        cirugiaPlastica.setVolumenMamarioDerecho(request.getParameter("volumenMamarioDerecho"));
        cirugiaPlastica.setHipertrofiaVolumenMamarioDerecho(request.getParameter("hipertrofiaVolumenMamarioDerecho"));
        cirugiaPlastica.setVolumenMamarioIzquierdo(request.getParameter("volumenMamarioIzquierdo"));
        cirugiaPlastica.setHipertrofiaVolumenMamarioIzquierdo(request.getParameter("hipertrofiaVolumenMamarioIzquierdo"));
        cirugiaPlastica.setFormaMamariaDerecha(request.getParameter("formaMamariaDerecha"));
        cirugiaPlastica.setOtroFormaMamariaDerecha(request.getParameter("otroFormaMamariaDerecha"));
        cirugiaPlastica.setFormaMamariaIzquierda(request.getParameter("formaMamariaIzquierda"));
        cirugiaPlastica.setOtroFormaMamariaIzquierda(request.getParameter("otroFormaMamariaIzquierda"));
        cirugiaPlastica.setPtosisMamaria(request.getParameter("ptosisMamaria"));
        cirugiaPlastica.setClasificacionPtosisRegnoult(request.getParameter("clasificacionPtosisRegnoult"));
        cirugiaPlastica.setGradoPtosisRegnault(request.getParameter("gradoPtosisRegnault"));      
        cirugiaPlastica.setTipoPielDerecha(request.getParameter("tipoPielDerecha"));
        cirugiaPlastica.setOtroTipoDePielDerecha(request.getParameter("otroTipoDePielDerecha"));
        cirugiaPlastica.setTipoPielIzquierda(request.getParameter("tipoPielIzquierda"));
        cirugiaPlastica.setOtroTipoDePielIzquierda(request.getParameter("otroTipoDePielIzquierda"));
        cirugiaPlastica.setSensibilidadPezonDerecho(request.getParameter("sensibilidadPezonDerecho"));
        cirugiaPlastica.setOtraSensibilidadDerechaPezon(request.getParameter("otraSensibilidadDerechaPezon"));
        cirugiaPlastica.setSensibilidadPezonIzquierdo(request.getParameter("sensibilidadPezonIzquierdo"));
        cirugiaPlastica.setOtraSensibilidadIzquierdaPezon(request.getParameter("otraSensibilidadIzquierdaPezon"));
        cirugiaPlastica.setDiametroComplejoAreolaDerecho(request.getParameter("diametroComplejoAreolaDerecho"));
        cirugiaPlastica.setDiametroComplejoAreolaIzquierdo(request.getParameter("diametroComplejoAreolaIzquierdo"));
        cirugiaPlastica.setDiagramaPosicionDerecho(request.getParameter("diagramaPosicionDerecho"));
        cirugiaPlastica.setBaseMamariaDerecho(request.getParameter("baseMamariaDerecho"));
        cirugiaPlastica.setMedidaToraxDerecho(request.getParameter("medidaToraxDerecho"));
        cirugiaPlastica.setDiagramaPosicionIzquierdo(request.getParameter("diagramaPosicionIzquierdo"));
        cirugiaPlastica.setBaseMamariaIzquierdo(request.getParameter("baseMamariaIzquierdo"));
        cirugiaPlastica.setMedidaToraxIzquierdo(request.getParameter("medidaToraxIzquierdo"));
        cirugiaPlastica.setDiagnosticoMamario(request.getParameter("diagnosticoMamario"));
        cirugiaPlastica.setOtrosDiagnosticosMamarios(request.getParameter("otrosDiagnosticosMamarios"));
        cirugiaPlastica.setPronosticoMamario(request.getParameter("pronosticoMamario"));
        cirugiaPlastica.setPlanTratamientoMamario(request.getParameter("planTratamientoMamario"));
//HOMBRES--------------->//HOMBRES--------------->
        cirugiaPlastica.setGinecomastia(request.getParameter("ginecomastia"));
        cirugiaPlastica.setClasificacionWiesman(request.getParameter("clasificacionWiesman"));
        cirugiaPlastica.setAntecedentesGinecomastia(request.getParameter("antecedentesGinecomastia"));
        cirugiaPlastica.setTipoGinecomastia(request.getParameter("tipoGinecomastia"));
        cirugiaPlastica.setOtroTipoGinecomastia(request.getParameter("otroTipoGinecomastia"));
        cirugiaPlastica.setComentariosTipoGinecomastia(request.getParameter("comentariosTipoGinecomastia"));
        cirugiaPlastica.setPectorales(request.getParameter("pectorales"));
        cirugiaPlastica.setOtrosDiagnosticosGinecomastia(request.getParameter("otrosDiagnosticosGinecomastia"));
        cirugiaPlastica.setPronosticoGinecomastia(request.getParameter("pronosticoGinecomastia"));
        cirugiaPlastica.setPlanTratamientoGinecomastia(request.getParameter("planTratamientoGinecomastia"));
//ABDOMEN----------------->//ABDOMEN----------------->
        cirugiaPlastica.setAbdomen(request.getParameter("abdomen"));
        cirugiaPlastica.setClasificacionMatarasso(request.getParameter("clasificacionMatarasso"));
        cirugiaPlastica.setComentariosAbdomen(request.getParameter("comentariosAbdomen"));
        cirugiaPlastica.setDiagnosticoAbdomen(request.getParameter("diagnosticoAbdomen"));
        cirugiaPlastica.setPronosticoAbdomen(request.getParameter("pronosticoAbdomen"));
        cirugiaPlastica.setPlanTratamientoAbdomen(request.getParameter("planTratamientoAbdomen"));
//VALORACION GENITOURINARIA--------------->//VALORACION GENITOURINARIA--------------->
        cirugiaPlastica.setValoracionGenitourinaria(request.getParameter("valoracionGenitourinaria"));
        cirugiaPlastica.setComentariosValoracionGenitourinaria(request.getParameter("comentariosValoracionGenitourinaria"));
//ESPALDA--------------------->//ESPALDA--------------------->
        cirugiaPlastica.setEspalda(request.getParameter("espalda"));
        cirugiaPlastica.setComentariosEspalda(request.getParameter("comentariosEspalda"));
        cirugiaPlastica.setDiagnosticoEspalda(request.getParameter("diagnosticoEspalda"));
        cirugiaPlastica.setPronosticoEspalda(request.getParameter("pronosticoEspalda"));
        cirugiaPlastica.setPlanTratamientoEspalda(request.getParameter("planTratamientoEspalda"));
//GLUTEOS---------------------->//GLUTEOS---------------------->
        cirugiaPlastica.setGluteos(request.getParameter("gluteos"));
        cirugiaPlastica.setVolumenGluteos(request.getParameter("volumenGluteos"));
        cirugiaPlastica.setPosicionGluteos(request.getParameter("posicionGluteos"));
        cirugiaPlastica.setFormaGluteos(request.getParameter("formaGluteos"));
        cirugiaPlastica.setCaracteristicasPielGluteos(request.getParameter("caracteristicasPielGluteos"));
        cirugiaPlastica.setAsimetria(request.getParameter("asimetria"));
        cirugiaPlastica.setSecuelasTrauma(request.getParameter("secuelasTrauma"));
        cirugiaPlastica.setComentariosGluteos(request.getParameter("comentariosGluteos"));
//EXTREMIDADES SUPERIORES--------------------->//EXTREMIDADES SUPERIORES--------------------->
        cirugiaPlastica.setExtremidadesSuperiores(request.getParameter("extremidadesSuperiores"));
        cirugiaPlastica.setDepositoGrasaMinimoModeradoMinimaLaxitud(request.getParameter("depositoGrasaMinimoModeradoMinimaLaxitud"));
        cirugiaPlastica.setDepositoGrasaGeneralizadaModeradaLaxitud(request.getParameter("depositoGrasaGeneralizadaModeradaLaxitud"));
        cirugiaPlastica.setObesidadGeneralizadaSeveraLaxitud(request.getParameter("obesidadGeneralizadaSeveraLaxitud"));
        cirugiaPlastica.setMinimaGrasaSubcutaneaExtensaLaxitud(request.getParameter("minimaGrasaSubcutaneaExtensaLaxitud"));
        cirugiaPlastica.setComentariosExtremidadesSuperiores(request.getParameter("comentariosExtremidadesSuperiores"));
        cirugiaPlastica.setDiagnosticoExtremidadesSuperiores(request.getParameter("diagnosticoExtremidadesSuperiores"));
        cirugiaPlastica.setPronosticoExtremidadesSuperiores(request.getParameter("pronosticoExtremidadesSuperiores"));
        cirugiaPlastica.setPlanTratamientoExtremidadesSuperiores(request.getParameter("planTratamientoExtremidadesSuperiores"));
//EXTREMIDADES INFERIORES------------------------>//EXTREMIDADES INFERIORES------------------------>
        cirugiaPlastica.setExtremidadesInferiores(request.getParameter("extremidadesInferiores"));
        cirugiaPlastica.setComentariosExtremidadesInferiores(request.getParameter("comentariosExtremidadesInferiores"));
        cirugiaPlastica.setDiagnosticoExtremidadesInferiores(request.getParameter("diagnosticoExtremidadesInferiores"));
        cirugiaPlastica.setPronosticoExtremidadesInferiores(request.getParameter("pronosticoExtremidadesInferiores"));
        cirugiaPlastica.setPlanTratamientoExtremidadesInferiores(request.getParameter("planTratamientoExtremidadesInferiores"));
//-----------------RECONSTRUCTIVA CABEZA CUELLO----------------->//-----------------RECONSTRUCTIVA CABEZA CUELLO----------------->
        cirugiaPlastica.setReconstructivaCabezaCuello(request.getParameter("reconstructivaCabezaCuello"));
        cirugiaPlastica.setComentariosReconstructivaCabezaCuello(request.getParameter("comentariosReconstructivaCabezaCuello"));
        cirugiaPlastica.setDiagnosticoReconstructivaCabezaCuello(request.getParameter("diagnosticoReconstructivaCabezaCuello"));
        cirugiaPlastica.setPronosticoReconstructivaCabezaCuello(request.getParameter("pronosticoReconstructivaCabezaCuello"));
        cirugiaPlastica.setPlanTratamientoReconstructivaCabezaCuello(request.getParameter("planTratamientoReconstructivaCabezaCuello"));
//-----------------RECONSTRUCTIVA CORPORAL-------------------->//-----------------RECONSTRUCTIVA CORPORAL-------------------->
        cirugiaPlastica.setReconstructivaCorporal(request.getParameter("reconstructivaCorporal"));
        cirugiaPlastica.setComentariosReconstructivaCorporal(request.getParameter("comentariosReconstructivaCorporal"));
        cirugiaPlastica.setDiagnosticoReconstructivaCorporal(request.getParameter("diagnosticoReconstructivaCorporal"));
        cirugiaPlastica.setPronosticoReconstructivaCorporal(request.getParameter("pronosticoReconstructivaCorporal"));
        cirugiaPlastica.setPlanTratamientoReconstructivaCorporal(request.getParameter("planTratamientoReconstructivaCorporal"));
        cirugiaPlastica.setFechaCreacionCp(request.getParameter("fechaCreacionCp"));
        cirugiaPlastica.setHoraCreacionCp(request.getParameter("horaCreacionCp"));
        cirugiaPlastica.setIdUsuario(Integer.parseInt(request.getSession().getAttribute("usuario").toString()));//RECORDAR QUE ESTE VALOR ESTA QUEMADO Y HAY QUE CAMBIARLO CUANDO SE CREE LA TABLA USUARIOS
        cirugiaPlastica = ejbCirugiaPlastica.crear(cirugiaPlastica);
        obj = new JSONObject();
        objArray = new JSONArray();
        if (cirugiaPlastica != null) {
            obj.put("idCirugiaPlastica", cirugiaPlastica.getIdCirugiaPlastica());
            objArray.add(obj);
        } else {
            obj.put("error", "no se pudo guardar la cirugia plastica    ");
            objArray.add(obj);
        }
        return objArray;
    }

    private JSONArray traerUltimoCirugiaPlastica(HttpServletRequest request) {
        CirugiaPlastica cirugiaPlastica = ejbCirugiaPlastica.traerUltimo(Integer.parseInt(request.getParameter("idPaciente")));
        obj = new JSONObject();
        objArray = new JSONArray();
        if (cirugiaPlastica != null) {
            obj.put("idCirugiaPlastica", cirugiaPlastica.getIdCirugiaPlastica());
            obj.put("idPaciente", cirugiaPlastica.getIdPaciente().getIdPaciente());
//-----------------ESTETICA CABEZA CUELLO----------------->//-----------------ESTETICA CABEZA CUELLO----------------->
            obj.put("esteticaCabezaCuello", cirugiaPlastica.getEsteticaCabezaCuello());
//ALOPECIA----->//ALOPECIA----->
            obj.put("alopecia", cirugiaPlastica.getAlopecia());
            obj.put("caidaDeCabello", cirugiaPlastica.getCaidaDeCabello());
            obj.put("edadInicioDebilitamientoCapilar", cirugiaPlastica.getEdadInicioDebilitamientoCapilar());
            obj.put("edadInicioCaidaCapilar", cirugiaPlastica.getEdadInicioCaidaCapilar());
            obj.put("estabilizada", cirugiaPlastica.getEstabilizada());
            obj.put("antecedentesFamiliares", cirugiaPlastica.getAntecedentesFamiliares());
            obj.put("tratamientosPrevios", cirugiaPlastica.getTratamientosPrevios());
            obj.put("cortes", cirugiaPlastica.getCortes());
            obj.put("color", cirugiaPlastica.getColor());
            obj.put("comentarioOtroColor", cirugiaPlastica.getComentarioOtroColor());
            obj.put("espesorCabello", cirugiaPlastica.getEspesorCabello());
            obj.put("estructura", cirugiaPlastica.getEstructura());
            obj.put("otraEstructura", cirugiaPlastica.getOtraEstructura());
            obj.put("poros", cirugiaPlastica.getPoros());
            obj.put("espesorCueroCabelludo", cirugiaPlastica.getEspesorCueroCabelludo());
            obj.put("flexibilidadCueroCabelludo", cirugiaPlastica.getFlexibilidadCueroCabelludo());
            obj.put("cicatrices", cirugiaPlastica.getCicatrices());
            obj.put("pullTest", cirugiaPlastica.getPullTest());
            obj.put("componentesPsiquicos", cirugiaPlastica.getComponentesPsiquicos());
            obj.put("otroComponentePsiquico", cirugiaPlastica.getOtroComponentePsiquico());
            obj.put("densidadZonaFrontal", cirugiaPlastica.getDensidadZonaFrontal());
            obj.put("densidadZonaOccipital", cirugiaPlastica.getDensidadZonaOccipital());
            obj.put("densidadZonaTemporal", cirugiaPlastica.getDensidadZonaTemporal());
            obj.put("densidadZonaParietal", cirugiaPlastica.getDensidadZonaParietal());
            obj.put("perdidaZona", cirugiaPlastica.getPerdidaZona());
            obj.put("otraPerdidaZona", cirugiaPlastica.getOtraPerdidaZona());
            obj.put("tipoAlopeciaNoCicatricial", cirugiaPlastica.getTipoAlopeciaNoCicatricial());
            obj.put("otroTipoDeAlopeciaNoCicatricial", cirugiaPlastica.getOtroTipoDeAlopeciaNoCicatricial());
            obj.put("tipoAlopeciaCicatricial", cirugiaPlastica.getTipoAlopeciaCicatricial());
            obj.put("otroTipoAlopeciaCicatricial", cirugiaPlastica.getOtroTipoAlopeciaCicatricial());
            obj.put("expectativasPaciente", cirugiaPlastica.getExpectativasPaciente());
            obj.put("propuestasTerapeuticas", cirugiaPlastica.getPropuestasTerapeuticas());
            obj.put("gradoDeAlopeciaHombre", cirugiaPlastica.getGradoDeAlopeciaHombre());
            obj.put("gradoDeAlopeciaMujer", cirugiaPlastica.getGradoDeAlopeciaMujer());
//FACIAL------------->//FACIAL------------->
            obj.put("facial", cirugiaPlastica.getFacial());
            obj.put("antropometriaFrente", cirugiaPlastica.getAntropometriaFrente());
            obj.put("comentariosAntropometriaFrente", cirugiaPlastica.getComentariosAntropometriaFrente());
            obj.put("antropometriaPerfil", cirugiaPlastica.getAntropometriaPerfil());
            obj.put("comentariosAntropometriaPerfil", cirugiaPlastica.getComentariosAntropometriaPerfil());
            obj.put("frente", cirugiaPlastica.getFrente());
            obj.put("comentariosFrente", cirugiaPlastica.getComentariosFrente());
            obj.put("zonaPeriorbitaria", cirugiaPlastica.getZonaPeriorbitaria());
            obj.put("comentariosZonaPeriorbitaria", cirugiaPlastica.getComentariosZonaPeriorbitaria());
            obj.put("regionMalar", cirugiaPlastica.getRegionMalar());
            obj.put("comentariosRegionMalar", cirugiaPlastica.getComentariosRegionMalar());
            obj.put("regionMandibular", cirugiaPlastica.getRegionMandibular());
            obj.put("comentariosRegionMandibular", cirugiaPlastica.getComentariosRegionMandibular());
            obj.put("auricular", cirugiaPlastica.getAuricular());
            obj.put("comentariosAuricular", cirugiaPlastica.getComentariosAuricular());
            obj.put("nasal", cirugiaPlastica.getNasal());
            obj.put("comentariosNasal", cirugiaPlastica.getComentariosNasal());
            obj.put("periBucal", cirugiaPlastica.getPeriBucal());
            obj.put("comentariosPeriBucal", cirugiaPlastica.getComentariosPeriBucal());
            obj.put("mentoniana", cirugiaPlastica.getMentoniana());
            obj.put("comentariosMentoniana", cirugiaPlastica.getComentariosMentoniana());
            obj.put("cervical", cirugiaPlastica.getCervical());
            obj.put("comentariosCervical", cirugiaPlastica.getComentariosCervical());
//-----------------ESTETICA CORPORAL----------------->//-----------------ESTETICA CORPORAL----------------->
            obj.put("esteticaCorporal", cirugiaPlastica.getEsteticaCorporal());
//REGION TORACICA ANTERIOR---------->//REGION TORACICA ANTERIOR---------->
            obj.put("regionToracicaAnterior", cirugiaPlastica.getRegionToracicaAnterior());
//MUJER--------------->//MUJER--------------->
            obj.put("antecedentesMamarios", cirugiaPlastica.getAntecedentesMamarios());
            obj.put("comentariosAntecedentesMamarios", cirugiaPlastica.getComentariosAntecedentesMamarios());
            obj.put("mamografias", cirugiaPlastica.getMamografias());
            obj.put("comentariosMamografias", cirugiaPlastica.getComentariosMamografias());
            obj.put("autoexamen", cirugiaPlastica.getAutoexamen());
            obj.put("comentariosAutoexamen", cirugiaPlastica.getComentariosAutoexamen());
            obj.put("volumenMamarioDerecho", cirugiaPlastica.getVolumenMamarioDerecho());
            obj.put("hipertrofiaVolumenMamarioDerecho", cirugiaPlastica.getHipertrofiaVolumenMamarioDerecho());
            obj.put("volumenMamarioIzquierdo", cirugiaPlastica.getVolumenMamarioIzquierdo());
            obj.put("hipertrofiaVolumenMamarioIzquierdo", cirugiaPlastica.getHipertrofiaVolumenMamarioIzquierdo());
            obj.put("formaMamariaDerecha", cirugiaPlastica.getFormaMamariaDerecha());
            obj.put("otroFormaMamariaDerecha", cirugiaPlastica.getOtroFormaMamariaDerecha());
            obj.put("formaMamariaIzquierda", cirugiaPlastica.getFormaMamariaIzquierda());
            obj.put("otroFormaMamariaIzquierda", cirugiaPlastica.getOtroFormaMamariaIzquierda());
            obj.put("ptosisMamaria", cirugiaPlastica.getPtosisMamaria());
            obj.put("clasificacionPtosisRegnoult", cirugiaPlastica.getClasificacionPtosisRegnoult());
            obj.put("gradoPtosisRegnault", cirugiaPlastica.getGradoPtosisRegnault());
            obj.put("tipoPielDerecha", cirugiaPlastica.getTipoPielDerecha());
            obj.put("otroTipoDePielDerecha", cirugiaPlastica.getOtroTipoDePielDerecha());
            obj.put("tipoPielIzquierda", cirugiaPlastica.getTipoPielIzquierda());
            obj.put("otroTipoDePielIzquierda", cirugiaPlastica.getOtroTipoDePielIzquierda());
            obj.put("sensibilidadPezonDerecho", cirugiaPlastica.getSensibilidadPezonDerecho());
            obj.put("otraSensibilidadDerechaPezon", cirugiaPlastica.getOtraSensibilidadDerechaPezon());
            obj.put("sensibilidadPezonIzquierdo", cirugiaPlastica.getSensibilidadPezonIzquierdo());
            obj.put("otraSensibilidadIzquierdaPezon", cirugiaPlastica.getOtraSensibilidadIzquierdaPezon());
            obj.put("diametroComplejoAreolaDerecho", cirugiaPlastica.getDiametroComplejoAreolaDerecho());
            obj.put("diametroComplejoAreolaIzquierdo", cirugiaPlastica.getDiametroComplejoAreolaIzquierdo());
            obj.put("diagramaPosicionDerecho", cirugiaPlastica.getDiagramaPosicionDerecho());
            obj.put("baseMamariaDerecho", cirugiaPlastica.getBaseMamariaDerecho());
            obj.put("medidaToraxDerecho", cirugiaPlastica.getMedidaToraxDerecho());
            obj.put("diagramaPosicionIzquierdo", cirugiaPlastica.getDiagramaPosicionIzquierdo());
            obj.put("baseMamariaIzquierdo", cirugiaPlastica.getBaseMamariaIzquierdo());
            obj.put("medidaToraxIzquierdo", cirugiaPlastica.getMedidaToraxIzquierdo());
            obj.put("diagnosticoMamario", cirugiaPlastica.getDiagnosticoMamario());
            obj.put("otrosDiagnosticosMamarios", cirugiaPlastica.getOtrosDiagnosticosMamarios());
            obj.put("pronosticoMamario", cirugiaPlastica.getPronosticoMamario());
            obj.put("planTratamientoMamario", cirugiaPlastica.getPlanTratamientoMamario());
//HOMBRES--------------->//HOMBRES--------------->
            obj.put("ginecomastia", cirugiaPlastica.getGinecomastia());
            obj.put("clasificacionWiesman", cirugiaPlastica.getClasificacionWiesman());
            obj.put("antecedentesGinecomastia", cirugiaPlastica.getAntecedentesGinecomastia());
            obj.put("tipoGinecomastia", cirugiaPlastica.getTipoGinecomastia());
            obj.put("otroTipoGinecomastia", cirugiaPlastica.getOtroTipoGinecomastia());
            obj.put("comentariosTipoGinecomastia", cirugiaPlastica.getComentariosTipoGinecomastia());
            obj.put("pectorales", cirugiaPlastica.getPectorales());
            obj.put("otrosDiagnosticosGinecomastia", cirugiaPlastica.getOtrosDiagnosticosGinecomastia());
            obj.put("pronosticoGinecomastia", cirugiaPlastica.getPronosticoGinecomastia());
            obj.put("planTratamientoGinecomastia", cirugiaPlastica.getPlanTratamientoGinecomastia());
//ABDOMEN----------------->//ABDOMEN----------------->
            obj.put("abdomen", cirugiaPlastica.getAbdomen());
            obj.put("clasificacionMatarasso", cirugiaPlastica.getClasificacionMatarasso());
            obj.put("comentariosAbdomen", cirugiaPlastica.getComentariosAbdomen());
            obj.put("diagnosticoAbdomen", cirugiaPlastica.getDiagnosticoAbdomen());
            obj.put("pronosticoAbdomen", cirugiaPlastica.getPronosticoAbdomen());
            obj.put("planTratamientoAbdomen", cirugiaPlastica.getPlanTratamientoAbdomen());
//VALORACION GENITOURINARIA--------------->//VALORACION GENITOURINARIA--------------->
            obj.put("valoracionGenitourinaria", cirugiaPlastica.getValoracionGenitourinaria());
            obj.put("comentariosValoracionGenitourinaria", cirugiaPlastica.getComentariosValoracionGenitourinaria());
//ESPALDA--------------------->//ESPALDA--------------------->
            obj.put("espalda", cirugiaPlastica.getEspalda());
            obj.put("comentariosEspalda", cirugiaPlastica.getComentariosEspalda());
            obj.put("diagnosticoEspalda", cirugiaPlastica.getDiagnosticoEspalda());
            obj.put("pronosticoEspalda", cirugiaPlastica.getPronosticoEspalda());
            obj.put("planTratamientoEspalda", cirugiaPlastica.getPlanTratamientoEspalda());
//GLUTEOS---------------------->//GLUTEOS---------------------->
            obj.put("gluteos", cirugiaPlastica.getGluteos());
            obj.put("volumenGluteos", cirugiaPlastica.getVolumenGluteos());
            obj.put("posicionGluteos", cirugiaPlastica.getPosicionGluteos());
            obj.put("formaGluteos", cirugiaPlastica.getFormaGluteos());
            obj.put("caracteristicasPielGluteos", cirugiaPlastica.getCaracteristicasPielGluteos());
            obj.put("asimetria", cirugiaPlastica.getAsimetria());
            obj.put("secuelasTrauma", cirugiaPlastica.getSecuelasTrauma());
            obj.put("comentariosGluteos", cirugiaPlastica.getComentariosGluteos());
//EXTREMIDADES SUPERIORES--------------------->//EXTREMIDADES SUPERIORES--------------------->
            obj.put("extremidadesSuperiores", cirugiaPlastica.getExtremidadesSuperiores());
            obj.put("depositoGrasaMinimoModeradoMinimaLaxitud", cirugiaPlastica.getDepositoGrasaMinimoModeradoMinimaLaxitud());
            obj.put("depositoGrasaGeneralizadaModeradaLaxitud", cirugiaPlastica.getDepositoGrasaGeneralizadaModeradaLaxitud());
            obj.put("obesidadGeneralizadaSeveraLaxitud", cirugiaPlastica.getObesidadGeneralizadaSeveraLaxitud());
            obj.put("minimaGrasaSubcutaneaExtensaLaxitud", cirugiaPlastica.getMinimaGrasaSubcutaneaExtensaLaxitud());
            obj.put("comentariosExtremidadesSuperiores", cirugiaPlastica.getComentariosExtremidadesSuperiores());
            obj.put("diagnosticoExtremidadesSuperiores", cirugiaPlastica.getDiagnosticoExtremidadesSuperiores());
            obj.put("pronosticoExtremidadesSuperiores", cirugiaPlastica.getPronosticoExtremidadesSuperiores());
            obj.put("planTratamientoExtremidadesSuperiores", cirugiaPlastica.getPlanTratamientoExtremidadesSuperiores());
//EXTREMIDADES INFERIORES------------------------>//EXTREMIDADES INFERIORES------------------------>
            obj.put("extremidadesInferiores", cirugiaPlastica.getExtremidadesInferiores());
            obj.put("comentariosExtremidadesInferiores", cirugiaPlastica.getComentariosExtremidadesInferiores());
            obj.put("diagnosticoExtremidadesInferiores", cirugiaPlastica.getDiagnosticoExtremidadesInferiores());
            obj.put("pronosticoExtremidadesInferiores", cirugiaPlastica.getPronosticoExtremidadesInferiores());
            obj.put("planTratamientoExtremidadesInferiores", cirugiaPlastica.getPlanTratamientoExtremidadesInferiores());
//-----------------RECONSTRUCTIVA CABEZA CUELLO----------------->//-----------------RECONSTRUCTIVA CABEZA CUELLO----------------->
            obj.put("reconstructivaCabezaCuello", cirugiaPlastica.getReconstructivaCabezaCuello());
            obj.put("comentariosReconstructivaCabezaCuello", cirugiaPlastica.getComentariosReconstructivaCabezaCuello());
            obj.put("diagnosticoReconstructivaCabezaCuello", cirugiaPlastica.getDiagnosticoReconstructivaCabezaCuello());
            obj.put("pronosticoReconstructivaCabezaCuello", cirugiaPlastica.getPronosticoReconstructivaCabezaCuello());
            obj.put("planTratamientoReconstructivaCabezaCuello", cirugiaPlastica.getPlanTratamientoReconstructivaCabezaCuello());
//-----------------RECONSTRUCTIVA CORPORAL-------------------->//-----------------RECONSTRUCTIVA CORPORAL-------------------->
            obj.put("reconstructivaCorporal", cirugiaPlastica.getReconstructivaCorporal());
            obj.put("comentariosReconstructivaCorporal", cirugiaPlastica.getComentariosReconstructivaCorporal());
            obj.put("diagnosticoReconstructivaCorporal", cirugiaPlastica.getDiagnosticoReconstructivaCorporal());
            obj.put("pronosticoReconstructivaCorporal", cirugiaPlastica.getPronosticoReconstructivaCorporal());
            obj.put("planTratamientoReconstructivaCorporal", cirugiaPlastica.getPlanTratamientoReconstructivaCorporal());
            obj.put("fechaCreacionCp", cirugiaPlastica.getFechaCreacionCp());
            obj.put("horaCreacionCp", cirugiaPlastica.getHoraCreacionCp());
            objArray.add(obj);
        }
        return objArray;
    }

    private JSONArray traerCirugiaPlasticaFecha(HttpServletRequest request) {
        CirugiaPlastica cirugiaPlastica = ejbCirugiaPlastica.traer(Integer.parseInt(request.getParameter("idPaciente")), request.getParameter("fecha"));
        obj = new JSONObject();
        objArray = new JSONArray();
        if (cirugiaPlastica != null) {
            obj.put("idCirugiaPlastica", cirugiaPlastica.getIdCirugiaPlastica());
            obj.put("idPaciente", cirugiaPlastica.getIdPaciente().getIdPaciente());
//-----------------ESTETICA CABEZA CUELLO----------------->//-----------------ESTETICA CABEZA CUELLO----------------->
            obj.put("esteticaCabezaCuello", cirugiaPlastica.getEsteticaCabezaCuello());
//ALOPECIA----->//ALOPECIA----->
            obj.put("alopecia", cirugiaPlastica.getAlopecia());
            obj.put("caidaDeCabello", cirugiaPlastica.getCaidaDeCabello());
            obj.put("edadInicioDebilitamientoCapilar", cirugiaPlastica.getEdadInicioDebilitamientoCapilar());
            obj.put("edadInicioCaidaCapilar", cirugiaPlastica.getEdadInicioCaidaCapilar());
            obj.put("estabilizada", cirugiaPlastica.getEstabilizada());
            obj.put("antecedentesFamiliares", cirugiaPlastica.getAntecedentesFamiliares());
            obj.put("tratamientosPrevios", cirugiaPlastica.getTratamientosPrevios());
            obj.put("cortes", cirugiaPlastica.getCortes());
            obj.put("color", cirugiaPlastica.getColor());
            obj.put("comentarioOtroColor", cirugiaPlastica.getComentarioOtroColor());
            obj.put("espesorCabello", cirugiaPlastica.getEspesorCabello());
            obj.put("estructura", cirugiaPlastica.getEstructura());
            obj.put("otraEstructura", cirugiaPlastica.getOtraEstructura());
            obj.put("poros", cirugiaPlastica.getPoros());
            obj.put("espesorCueroCabelludo", cirugiaPlastica.getEspesorCueroCabelludo());
            obj.put("flexibilidadCueroCabelludo", cirugiaPlastica.getFlexibilidadCueroCabelludo());
            obj.put("cicatrices", cirugiaPlastica.getCicatrices());
            obj.put("pullTest", cirugiaPlastica.getPullTest());
            obj.put("componentesPsiquicos", cirugiaPlastica.getComponentesPsiquicos());
            obj.put("otroComponentePsiquico", cirugiaPlastica.getOtroComponentePsiquico());
            obj.put("densidadZonaFrontal", cirugiaPlastica.getDensidadZonaFrontal());
            obj.put("densidadZonaOccipital", cirugiaPlastica.getDensidadZonaOccipital());
            obj.put("densidadZonaTemporal", cirugiaPlastica.getDensidadZonaTemporal());
            obj.put("densidadZonaParietal", cirugiaPlastica.getDensidadZonaParietal());
            obj.put("perdidaZona", cirugiaPlastica.getPerdidaZona());
            obj.put("otraPerdidaZona", cirugiaPlastica.getOtraPerdidaZona());
            obj.put("tipoAlopeciaNoCicatricial", cirugiaPlastica.getTipoAlopeciaNoCicatricial());
            obj.put("otroTipoDeAlopeciaNoCicatricial", cirugiaPlastica.getOtroTipoDeAlopeciaNoCicatricial());
            obj.put("tipoAlopeciaCicatricial", cirugiaPlastica.getTipoAlopeciaCicatricial());
            obj.put("otroTipoAlopeciaCicatricial", cirugiaPlastica.getOtroTipoAlopeciaCicatricial());
            obj.put("expectativasPaciente", cirugiaPlastica.getExpectativasPaciente());
            obj.put("propuestasTerapeuticas", cirugiaPlastica.getPropuestasTerapeuticas());
            obj.put("gradoDeAlopeciaHombre", cirugiaPlastica.getGradoDeAlopeciaHombre());
            obj.put("gradoDeAlopeciaMujer", cirugiaPlastica.getGradoDeAlopeciaMujer());
//FACIAL------------->//FACIAL------------->
            obj.put("facial", cirugiaPlastica.getFacial());
            obj.put("antropometriaFrente", cirugiaPlastica.getAntropometriaFrente());
            obj.put("comentariosAntropometriaFrente", cirugiaPlastica.getComentariosAntropometriaFrente());
            obj.put("antropometriaPerfil", cirugiaPlastica.getAntropometriaPerfil());
            obj.put("comentariosAntropometriaPerfil", cirugiaPlastica.getComentariosAntropometriaPerfil());
            obj.put("frente", cirugiaPlastica.getFrente());
            obj.put("comentariosFrente", cirugiaPlastica.getComentariosFrente());
            obj.put("zonaPeriorbitaria", cirugiaPlastica.getZonaPeriorbitaria());
            obj.put("comentariosZonaPeriorbitaria", cirugiaPlastica.getComentariosZonaPeriorbitaria());
            obj.put("regionMalar", cirugiaPlastica.getRegionMalar());
            obj.put("comentariosRegionMalar", cirugiaPlastica.getComentariosRegionMalar());
            obj.put("regionMandibular", cirugiaPlastica.getRegionMandibular());
            obj.put("comentariosRegionMandibular", cirugiaPlastica.getComentariosRegionMandibular());
            obj.put("auricular", cirugiaPlastica.getAuricular());
            obj.put("comentariosAuricular", cirugiaPlastica.getComentariosAuricular());
            obj.put("nasal", cirugiaPlastica.getNasal());
            obj.put("comentariosNasal", cirugiaPlastica.getComentariosNasal());
            obj.put("periBucal", cirugiaPlastica.getPeriBucal());
            obj.put("comentariosPeriBucal", cirugiaPlastica.getComentariosPeriBucal());
            obj.put("mentoniana", cirugiaPlastica.getMentoniana());
            obj.put("comentariosMentoniana", cirugiaPlastica.getComentariosMentoniana());
            obj.put("cervical", cirugiaPlastica.getCervical());
            obj.put("comentariosCervical", cirugiaPlastica.getComentariosCervical());
//-----------------ESTETICA CORPORAL----------------->//-----------------ESTETICA CORPORAL----------------->
            obj.put("esteticaCorporal", cirugiaPlastica.getEsteticaCorporal());
//REGION TORACICA ANTERIOR---------->//REGION TORACICA ANTERIOR---------->
            obj.put("regionToracicaAnterior", cirugiaPlastica.getRegionToracicaAnterior());
//MUJER--------------->//MUJER--------------->
            obj.put("antecedentesMamarios", cirugiaPlastica.getAntecedentesMamarios());
            obj.put("comentariosAntecedentesMamarios", cirugiaPlastica.getComentariosAntecedentesMamarios());
            obj.put("mamografias", cirugiaPlastica.getMamografias());
            obj.put("comentariosMamografias", cirugiaPlastica.getComentariosMamografias());
            obj.put("autoexamen", cirugiaPlastica.getAutoexamen());
            obj.put("comentariosAutoexamen", cirugiaPlastica.getComentariosAutoexamen());
            obj.put("volumenMamarioDerecho", cirugiaPlastica.getVolumenMamarioDerecho());
            obj.put("hipertrofiaVolumenMamarioDerecho", cirugiaPlastica.getHipertrofiaVolumenMamarioDerecho());
            obj.put("volumenMamarioIzquierdo", cirugiaPlastica.getVolumenMamarioIzquierdo());
            obj.put("hipertrofiaVolumenMamarioIzquierdo", cirugiaPlastica.getHipertrofiaVolumenMamarioIzquierdo());
            obj.put("formaMamariaDerecha", cirugiaPlastica.getFormaMamariaDerecha());
            obj.put("otroFormaMamariaDerecha", cirugiaPlastica.getOtroFormaMamariaDerecha());
            obj.put("formaMamariaIzquierda", cirugiaPlastica.getFormaMamariaIzquierda());
            obj.put("otroFormaMamariaIzquierda", cirugiaPlastica.getOtroFormaMamariaIzquierda());
            obj.put("ptosisMamaria", cirugiaPlastica.getPtosisMamaria());
            obj.put("clasificacionPtosisRegnoult", cirugiaPlastica.getClasificacionPtosisRegnoult());
            obj.put("tipoPielDerecha", cirugiaPlastica.getTipoPielDerecha());
            obj.put("otroTipoDePielDerecha", cirugiaPlastica.getOtroTipoDePielDerecha());
            obj.put("tipoPielIzquierda", cirugiaPlastica.getTipoPielIzquierda());
            obj.put("otroTipoDePielIzquierda", cirugiaPlastica.getOtroTipoDePielIzquierda());
            obj.put("sensibilidadPezonDerecho", cirugiaPlastica.getSensibilidadPezonDerecho());
            obj.put("otraSensibilidadDerechaPezon", cirugiaPlastica.getOtraSensibilidadDerechaPezon());
            obj.put("sensibilidadPezonIzquierdo", cirugiaPlastica.getSensibilidadPezonIzquierdo());
            obj.put("otraSensibilidadIzquierdaPezon", cirugiaPlastica.getOtraSensibilidadIzquierdaPezon());
            obj.put("diametroComplejoAreolaDerecho", cirugiaPlastica.getDiametroComplejoAreolaDerecho());
            obj.put("diametroComplejoAreolaIzquierdo", cirugiaPlastica.getDiametroComplejoAreolaIzquierdo());
            obj.put("diagramaPosicionDerecho", cirugiaPlastica.getDiagramaPosicionDerecho());
            obj.put("baseMamariaDerecho", cirugiaPlastica.getBaseMamariaDerecho());
            obj.put("medidaToraxDerecho", cirugiaPlastica.getMedidaToraxDerecho());
            obj.put("diagramaPosicionIzquierdo", cirugiaPlastica.getDiagramaPosicionIzquierdo());
            obj.put("baseMamariaIzquierdo", cirugiaPlastica.getBaseMamariaIzquierdo());
            obj.put("medidaToraxIzquierdo", cirugiaPlastica.getMedidaToraxIzquierdo());
            obj.put("diagnosticoMamario", cirugiaPlastica.getDiagnosticoMamario());
            obj.put("otrosDiagnosticosMamarios", cirugiaPlastica.getOtrosDiagnosticosMamarios());
            obj.put("pronosticoMamario", cirugiaPlastica.getPronosticoMamario());
            obj.put("planTratamientoMamario", cirugiaPlastica.getPlanTratamientoMamario());
//HOMBRES--------------->//HOMBRES--------------->
            obj.put("ginecomastia", cirugiaPlastica.getGinecomastia());
            obj.put("clasificacionWiesman", cirugiaPlastica.getClasificacionWiesman());
            obj.put("antecedentesGinecomastia", cirugiaPlastica.getAntecedentesGinecomastia());
            obj.put("tipoGinecomastia", cirugiaPlastica.getTipoGinecomastia());
            obj.put("otroTipoGinecomastia", cirugiaPlastica.getOtroTipoGinecomastia());
            obj.put("comentariosTipoGinecomastia", cirugiaPlastica.getComentariosTipoGinecomastia());
            obj.put("pectorales", cirugiaPlastica.getPectorales());
            obj.put("otrosDiagnosticosGinecomastia", cirugiaPlastica.getOtrosDiagnosticosGinecomastia());
            obj.put("pronosticoGinecomastia", cirugiaPlastica.getPronosticoGinecomastia());
            obj.put("planTratamientoGinecomastia", cirugiaPlastica.getPlanTratamientoGinecomastia());
//ABDOMEN----------------->//ABDOMEN----------------->
            obj.put("abdomen", cirugiaPlastica.getAbdomen());
            obj.put("clasificacionMatarasso", cirugiaPlastica.getClasificacionMatarasso());
            obj.put("comentariosAbdomen", cirugiaPlastica.getComentariosAbdomen());
            obj.put("diagnosticoAbdomen", cirugiaPlastica.getDiagnosticoAbdomen());
            obj.put("pronosticoAbdomen", cirugiaPlastica.getPronosticoAbdomen());
            obj.put("planTratamientoAbdomen", cirugiaPlastica.getPlanTratamientoAbdomen());
//VALORACION GENITOURINARIA--------------->//VALORACION GENITOURINARIA--------------->
            obj.put("valoracionGenitourinaria", cirugiaPlastica.getValoracionGenitourinaria());
            obj.put("comentariosValoracionGenitourinaria", cirugiaPlastica.getComentariosValoracionGenitourinaria());
//ESPALDA--------------------->//ESPALDA--------------------->
            obj.put("espalda", cirugiaPlastica.getEspalda());
            obj.put("comentariosEspalda", cirugiaPlastica.getComentariosEspalda());
            obj.put("diagnosticoEspalda", cirugiaPlastica.getDiagnosticoEspalda());
            obj.put("pronosticoEspalda", cirugiaPlastica.getPronosticoEspalda());
            obj.put("planTratamientoEspalda", cirugiaPlastica.getPlanTratamientoEspalda());
//GLUTEOS---------------------->//GLUTEOS---------------------->
            obj.put("gluteos", cirugiaPlastica.getGluteos());
            obj.put("volumenGluteos", cirugiaPlastica.getVolumenGluteos());
            obj.put("posicionGluteos", cirugiaPlastica.getPosicionGluteos());
            obj.put("formaGluteos", cirugiaPlastica.getFormaGluteos());
            obj.put("caracteristicasPielGluteos", cirugiaPlastica.getCaracteristicasPielGluteos());
            obj.put("asimetria", cirugiaPlastica.getAsimetria());
            obj.put("secuelasTrauma", cirugiaPlastica.getSecuelasTrauma());
            obj.put("comentariosGluteos", cirugiaPlastica.getComentariosGluteos());
//EXTREMIDADES SUPERIORES--------------------->//EXTREMIDADES SUPERIORES--------------------->
            obj.put("extremidadesSuperiores", cirugiaPlastica.getExtremidadesSuperiores());
            obj.put("depositoGrasaMinimoModeradoMinimaLaxitud", cirugiaPlastica.getDepositoGrasaMinimoModeradoMinimaLaxitud());
            obj.put("depositoGrasaGeneralizadaModeradaLaxitud", cirugiaPlastica.getDepositoGrasaGeneralizadaModeradaLaxitud());
            obj.put("obesidadGeneralizadaSeveraLaxitud", cirugiaPlastica.getObesidadGeneralizadaSeveraLaxitud());
            obj.put("minimaGrasaSubcutaneaExtensaLaxitud", cirugiaPlastica.getMinimaGrasaSubcutaneaExtensaLaxitud());
            obj.put("comentariosExtremidadesSuperiores", cirugiaPlastica.getComentariosExtremidadesSuperiores());
            obj.put("diagnosticoExtremidadesSuperiores", cirugiaPlastica.getDiagnosticoExtremidadesSuperiores());
            obj.put("pronosticoExtremidadesSuperiores", cirugiaPlastica.getPronosticoExtremidadesSuperiores());
            obj.put("planTratamientoExtremidadesSuperiores", cirugiaPlastica.getPlanTratamientoExtremidadesSuperiores());
//EXTREMIDADES INFERIORES------------------------>//EXTREMIDADES INFERIORES------------------------>
            obj.put("extremidadesInferiores", cirugiaPlastica.getExtremidadesInferiores());
            obj.put("comentariosExtremidadesInferiores", cirugiaPlastica.getComentariosExtremidadesInferiores());
            obj.put("diagnosticoExtremidadesInferiores", cirugiaPlastica.getDiagnosticoExtremidadesInferiores());
            obj.put("pronosticoExtremidadesInferiores", cirugiaPlastica.getPronosticoExtremidadesInferiores());
            obj.put("planTratamientoExtremidadesInferiores", cirugiaPlastica.getPlanTratamientoExtremidadesInferiores());
//-----------------RECONSTRUCTIVA CABEZA CUELLO----------------->//-----------------RECONSTRUCTIVA CABEZA CUELLO----------------->
            obj.put("reconstructivaCabezaCuello", cirugiaPlastica.getReconstructivaCabezaCuello());
            obj.put("comentariosReconstructivaCabezaCuello", cirugiaPlastica.getComentariosReconstructivaCabezaCuello());
            obj.put("diagnosticoReconstructivaCabezaCuello", cirugiaPlastica.getDiagnosticoReconstructivaCabezaCuello());
            obj.put("pronosticoReconstructivaCabezaCuello", cirugiaPlastica.getPronosticoReconstructivaCabezaCuello());
            obj.put("planTratamientoReconstructivaCabezaCuello", cirugiaPlastica.getPlanTratamientoReconstructivaCabezaCuello());
//-----------------RECONSTRUCTIVA CORPORAL-------------------->//-----------------RECONSTRUCTIVA CORPORAL-------------------->
            obj.put("reconstructivaCorporal", cirugiaPlastica.getReconstructivaCorporal());
            obj.put("comentariosReconstructivaCorporal", cirugiaPlastica.getComentariosReconstructivaCorporal());
            obj.put("diagnosticoReconstructivaCorporal", cirugiaPlastica.getDiagnosticoReconstructivaCorporal());
            obj.put("pronosticoReconstructivaCorporal", cirugiaPlastica.getPronosticoReconstructivaCorporal());
            obj.put("planTratamientoReconstructivaCorporal", cirugiaPlastica.getPlanTratamientoReconstructivaCorporal());
            obj.put("fechaCreacionCp", cirugiaPlastica.getFechaCreacionCp());
            obj.put("horaCreacionCp", cirugiaPlastica.getHoraCreacionCp());
            objArray.add(obj);
        }
        return objArray;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
