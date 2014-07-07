/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.web;

import com.saludtec.entidades.hcemed.Anamnesis;
import com.saludtec.entidades.hcemed.PacientesHcemed;
import com.saludtec.jpa.AnamnesisEjb;
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
@WebServlet(name = "AnamnesisWeb", urlPatterns = {"/Anamnesis/*"})
public class AnamnesisWeb extends HttpServlet {

    @EJB
    AnamnesisEjb ejbAnamnesis;
    @EJB
    PacientesEjb ejbPacientes;
    JSONObject obj;
    JSONArray objArray;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String servicio = request.getRequestURI().replace("/HCEMed/Anamnesis/", "");
            switch (servicio) {
                case "guardar":
                    guardarAnamnesis(request).writeJSONString(out);
                    break;

                case "traerUltimo":
                    traerUltimoAnamnesis(request).writeJSONString(out);
                    break;

                case "traerFecha":
                    traerAnamnesisFecha(request).writeJSONString(out);
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

    private JSONArray guardarAnamnesis(HttpServletRequest request) {
        Anamnesis anamnesis = new Anamnesis();
        PacientesHcemed paciente = ejbPacientes.traer(Integer.parseInt(request.getParameter("idPaciente")));
        anamnesis.setIdPaciente(paciente);
        anamnesis.setMotivoConsulta(request.getParameter("motivoConsulta"));
        anamnesis.setHistoriaEnfermedadActual(request.getParameter("historiaEnfermedadActual"));
        anamnesis.setBajoMedicacion(request.getParameter("bajoMedicacion"));
        anamnesis.setBajoMedicacionComentarios(request.getParameter("bajoMedicacionComentarios"));
        anamnesis.setAlergia(request.getParameter("alergia"));
        anamnesis.setHepatitis(request.getParameter("hepatitis"));
        anamnesis.setVih(request.getParameter("vih"));
        anamnesis.setAnemia(request.getParameter("anemia"));
        anamnesis.setHerpes(request.getParameter("herpes"));
        anamnesis.setEnfermedadRenal(request.getParameter("enfermedadRenal"));
        anamnesis.setArtritis(request.getParameter("artritis"));
        anamnesis.setUlcerasOrales(request.getParameter("ulcerasOrales"));
        anamnesis.setAsma(request.getParameter("asma"));
        anamnesis.setDiabetes(request.getParameter("diabetes"));
        anamnesis.setHemorragias(request.getParameter("hemorragias"));
        anamnesis.setProblemasEndocrinos(request.getParameter("problemasEndocrinos"));
        anamnesis.setFiebreReumatica(request.getParameter("fiebreReumatica"));
        anamnesis.setCancer(request.getParameter("cancer"));
        anamnesis.setProblemasPsicologicos(request.getParameter("problemasPsicologicos"));
        anamnesis.setProblemasTiroideos(request.getParameter("problemasTiroideos"));
        anamnesis.setProblemasCardiacos(request.getParameter("problemasCardiacos"));
        anamnesis.setEpilepsia(request.getParameter("epilepsia"));
        anamnesis.setTuberculosis(request.getParameter("tuberculosis"));
        anamnesis.setOsteoporosis(request.getParameter("osteoporosis"));
        anamnesis.setHipertension(request.getParameter("hipertension"));
        anamnesis.setProblemasPsiquiatricos(request.getParameter("problemasPsiquiatricos"));
        //ANTECEDENTES PATOLOGICOS//ANTECEDENTES PATOLOGICOS
        //ALERGIA//ALERGIA
        anamnesis.setFechaDiagnosticoAlergia(request.getParameter("fechaDiagnosticoAlergia"));
        anamnesis.setTratamientoAlergia(request.getParameter("tratamientoAlergia"));
        anamnesis.setInicioTratamientoAlergia(request.getParameter("inicioTratamientoAlergia"));
        anamnesis.setHastaTratamientoAlergia(request.getParameter("hastaTratamientoAlergia"));
        anamnesis.setMedicacionAlergia(request.getParameter("medicacionAlergia"));
        anamnesis.setComentariosAlergia(request.getParameter("comentariosAlergia"));
        //HEPATITIS//HEPATITIS
        anamnesis.setFechaDiagnosticoHepatitis(request.getParameter("fechaDiagnosticoHepatitis"));
        anamnesis.setTratamientoHepatitis(request.getParameter("tratamientoHepatitis"));
        anamnesis.setInicioTratamientoHepatitis(request.getParameter("inicioTratamientoHepatitis"));
        anamnesis.setHastaTratamientoHepatitis(request.getParameter("hastaTratamientoHepatitis"));
        anamnesis.setMedicacionHepatitis(request.getParameter("medicacionHepatitis"));
        anamnesis.setComentariosHepatitis(request.getParameter("comentariosHepatitis"));
        //VIH//VIH
        anamnesis.setFechaDiagnosticoVih(request.getParameter("fechaDiagnosticoVih"));
        anamnesis.setTratamientoVih(request.getParameter("tratamientoVih"));
        anamnesis.setInicioTratamientoVih(request.getParameter("inicioTratamientoVih"));
        anamnesis.setHastaTratamientoVih(request.getParameter("hastaTratamientoVih"));
        anamnesis.setMedicacionVih(request.getParameter("medicacionVih"));
        anamnesis.setComentariosVih(request.getParameter("comentariosVih"));
        //ANEMIA//ANEMIA
        anamnesis.setFechaDiagnosticoAnemia(request.getParameter("fechaDiagnosticoAnemia"));
        anamnesis.setTratamientoAnemia(request.getParameter("tratamientoAnemia"));
        anamnesis.setInicioTratamientoAnemia(request.getParameter("inicioTratamientoAnemia"));
        anamnesis.setHastaTratamientoAnemia(request.getParameter("hastaTratamientoAnemia"));
        anamnesis.setMedicacionAnemia(request.getParameter("medicacionAnemia"));
        anamnesis.setComentariosAnemia(request.getParameter("comentariosAnemia"));
        //HERPES//HERPES
        anamnesis.setFechaDiagnosticoHerpes(request.getParameter("fechaDiagnosticoHerpes"));
        anamnesis.setTratamientoHerpes(request.getParameter("tratamientoHerpes"));
        anamnesis.setInicioTratamientoHerpes(request.getParameter("inicioTratamientoHerpes"));
        anamnesis.setHastaTratamientoHerpes(request.getParameter("hastaTratamientoHerpes"));
        anamnesis.setMedicacionHerpes(request.getParameter("medicacionHerpes"));
        anamnesis.setComentariosHerpes(request.getParameter("comentariosHerpes"));
        //ENFERMEDAD RENAL//ENFERMEDAD RENAL
        anamnesis.setFechaDiagnosticoEnfermedadRenal(request.getParameter("fechaDiagnosticoEnfermedadRenal"));
        anamnesis.setTratamientoEnfermedadRenal(request.getParameter("tratamientoEnfermedadRenal"));
        anamnesis.setInicioTratamientoEnfermedadRenal(request.getParameter("inicioTratamientoEnfermedadRenal"));
        anamnesis.setHastaTratamientoEnfermedadRenal(request.getParameter("hastaTratamientoEnfermedadRenal"));
        anamnesis.setMedicacionEnfermedadRenal(request.getParameter("medicacionEnfermedadRenal"));
        anamnesis.setComentariosEnfermedadRenal(request.getParameter("comentariosEnfermedadRenal"));
        //ARTRITIS//ARTRITIS
        anamnesis.setFechaDiagnosticoArtritis(request.getParameter("fechaDiagnosticoArtritis"));
        anamnesis.setTratamientoArtritis(request.getParameter("tratamientoArtritis"));
        anamnesis.setInicioTratamientoArtritis(request.getParameter("inicioTratamientoArtritis"));
        anamnesis.setHastaTratamientoArtritis(request.getParameter("hastaTratamientoArtritis"));
        anamnesis.setMedicacionArtritis(request.getParameter("medicacionArtritis"));
        anamnesis.setComentariosArtritis(request.getParameter("comentariosArtritis"));
        //ULCERAS ORALES//ULCERAS ORALES
        anamnesis.setFechaDiagnosticoUlcerasOrales(request.getParameter("fechaDiagnosticoUlcerasOrales"));
        anamnesis.setTratamientoUlcerasOrales(request.getParameter("tratamientoUlcerasOrales"));
        anamnesis.setInicioTratamientoUlcerasOrales(request.getParameter("inicioTratamientoUlcerasOrales"));
        anamnesis.setHastaTratamientoUlcerasOrales(request.getParameter("hastaTratamientoUlcerasOrales"));
        anamnesis.setMedicacionUlcerasOrales(request.getParameter("medicacionUlcerasOrales"));
        anamnesis.setComentariosUlcerasOrales(request.getParameter("comentariosUlcerasOrales"));
        //ASMA//ASMA
        anamnesis.setFechaDiagnosticoAsma(request.getParameter("fechaDiagnosticoAsma"));
        anamnesis.setTratamientoAsma(request.getParameter("tratamientoAsma"));
        anamnesis.setInicioTratamientoAsma(request.getParameter("inicioTratamientoAsma"));
        anamnesis.setHastaTratamientoAsma(request.getParameter("hastaTratamientoAsma"));
        anamnesis.setMedicacionAsma(request.getParameter("medicacionAsma"));
        anamnesis.setComentariosAsma(request.getParameter("comentariosAsma"));
        //DIABETES//DIABETES
        anamnesis.setFechaDiagnosticoDiabetes(request.getParameter("fechaDiagnosticoDiabetes"));
        anamnesis.setTratamientoDiabetes(request.getParameter("tratamientoDiabetes"));
        anamnesis.setInicioTratamientoDiabetes(request.getParameter("inicioTratamientoDiabetes"));
        anamnesis.setHastaTratamientoDiabetes(request.getParameter("hastaTratamientoDiabetes"));
        anamnesis.setMedicacionDiabetes(request.getParameter("medicacionDiabetes"));
        anamnesis.setComentariosDiabetes(request.getParameter("comentariosDiabetes"));
        //HEMORRAGIAS//HEMORRAGIAS
        anamnesis.setFechaDiagnosticoHemorragias(request.getParameter("fechaDiagnosticoHemorragias"));
        anamnesis.setTratamientoHemorragias(request.getParameter("tratamientoHemorragias"));
        anamnesis.setInicioTratamientoHemorragias(request.getParameter("inicioTratamientoHemorragias"));
        anamnesis.setHastaTratamientoHemorragias(request.getParameter("hastaTratamientoHemorragias"));
        anamnesis.setMedicacionHemorragias(request.getParameter("medicacionHemorragias"));
        anamnesis.setComentariosHemorragias(request.getParameter("comentariosHemorragias"));
        //PROBLEMAS ENDOCRINOS//PROBLEMAS ENDOCRINOS
        anamnesis.setFechaDiagnosticoProblemasEndocrinos(request.getParameter("fechaDiagnosticoProblemasEndocrinos"));
        anamnesis.setTratamientoProblemasEndocrinos(request.getParameter("tratamientoProblemasEndocrinos"));
        anamnesis.setInicioTratamientoProblemasEndocrinos(request.getParameter("inicioTratamientoProblemasEndocrinos"));
        anamnesis.setHastaTratamientoProblemasEndocrinos(request.getParameter("hastaTratamientoProblemasEndocrinos"));
        anamnesis.setMedicacionProblemasEndocrinos(request.getParameter("medicacionProblemasEndocrinos"));
        anamnesis.setComentariosProblemasEndocrinos(request.getParameter("comentariosProblemasEndocrinos"));
        //FIEBRE REUMATICA//FIEBRE REUMATICA
        anamnesis.setFechaDiagnosticoFiebreReumatica(request.getParameter("fechaDiagnosticoFiebreReumatica"));
        anamnesis.setTratamientoFiebreReumatica(request.getParameter("tratamientoFiebreReumatica"));
        anamnesis.setInicioTratamientoFiebreReumatica(request.getParameter("inicioTratamientoFiebreReumatica"));
        anamnesis.setHastaTratamientoFiebreReumatica(request.getParameter("hastaTratamientoFiebreReumatica"));
        anamnesis.setMedicacionFiebreReumatica(request.getParameter("medicacionFiebreReumatica"));
        anamnesis.setComentariosFiebreReumatica(request.getParameter("comentariosFiebreReumatica"));
        //CANCER//CANCER
        anamnesis.setFechaDiagnosticoCancer(request.getParameter("fechaDiagnosticoCancer"));
        anamnesis.setTratamientoCancer(request.getParameter("tratamientoCancer"));
        anamnesis.setInicioTratamientoCancer(request.getParameter("inicioTratamientoCancer"));
        anamnesis.setHastaTratamientoCancer(request.getParameter("hastaTratamientoCancer"));
        anamnesis.setMedicacionCancer(request.getParameter("medicacionCancer"));
        anamnesis.setComentariosCancer(request.getParameter("comentariosCancer"));
        //PROBLEMAS PSICOLOGICOS//PROBLEMAS PSICOLOGICOS
        anamnesis.setFechaDiagnosticoProblemasPsicologicos(request.getParameter("fechaDiagnosticoProblemasPsicologicos"));
        anamnesis.setTratamientoProblemasPsicologicos(request.getParameter("tratamientoProblemasPsicologicos"));
        anamnesis.setInicioTratamientoProblemasPsicologicos(request.getParameter("inicioTratamientoProblemasPsicologicos"));
        anamnesis.setHastaTratamientoProblemasPsicologicos(request.getParameter("hastaTratamientoProblemasPsicologicos"));
        anamnesis.setMedicacionProblemasPsicologicos(request.getParameter("medicacionProblemasPsicologicos"));
        anamnesis.setComentariosProblemasPsicologicos(request.getParameter("comentariosProblemasPsicologicos"));
        //PROBLEMAS TIROIDEOS//PROBLEMAS TIROIDEOS
        anamnesis.setFechaDiagnosticoProblemasTiroideos(request.getParameter("fechaDiagnosticoProblemasTiroideos"));
        anamnesis.setTratamientoProblemasTiroideos(request.getParameter("tratamientoProblemasTiroideos"));
        anamnesis.setInicioTratamientoProblemasTiroideos(request.getParameter("inicioTratamientoProblemasTiroideos"));
        anamnesis.setHastaTratamientoProblemasTiroideos(request.getParameter("hastaTratamientoProblemasTiroideos"));
        anamnesis.setMedicacionProblemasTiroideos(request.getParameter("medicacionProblemasTiroideos"));
        anamnesis.setComentariosProblemasTiroideos(request.getParameter("comentariosProblemasTiroideos"));
        //PROBLEMAS CARDIACOS//PROBLEMAS CARDIACOS
        anamnesis.setFechaDiagnosticoProblemasCardiacos(request.getParameter("fechaDiagnosticoProblemasCardiacos"));
        anamnesis.setTratamientoProblemasCardiacos(request.getParameter("tratamientoProblemasCardiacos"));
        anamnesis.setInicioTratamientoProblemasCardiacos(request.getParameter("inicioTratamientoProblemasCardiacos"));
        anamnesis.setHastaTratamientoProblemasCardiacos(request.getParameter("hastaTratamientoProblemasCardiacos"));
        anamnesis.setMedicacionProblemasCardiacos(request.getParameter("medicacionProblemasCardiacos"));
        anamnesis.setComentariosProblemasCardiacos(request.getParameter("comentariosProblemasCardiacos"));
        //EPILEPSIAS//EPILEPSIAS
        anamnesis.setFechaDiagnosticoEpilepsia(request.getParameter("fechaDiagnosticoEpilepsia"));
        anamnesis.setTratamientoEpilepsia(request.getParameter("tratamientoEpilepsia"));
        anamnesis.setInicioTratamientoEpilepsia(request.getParameter("inicioTratamientoEpilepsia"));
        anamnesis.setHastaTratamientoEpilepsia(request.getParameter("hastaTratamientoEpilepsia"));
        anamnesis.setMedicacionEpilepsia(request.getParameter("medicacionEpilepsia"));
        anamnesis.setComentariosEpilepsia(request.getParameter("comentariosEpilepsia"));
        //TUBERCULOSIS//TUBERCULOSIS
        anamnesis.setFechaDiagnosticoTuberculosis(request.getParameter("fechaDiagnosticoTuberculosis"));
        anamnesis.setTratamientoTuberculosis(request.getParameter("tratamientoTuberculosis"));
        anamnesis.setInicioTratamientoTuberculosis(request.getParameter("inicioTratamientoTuberculosis"));
        anamnesis.setHastaTratamientoTuberculosis(request.getParameter("hastaTratamientoTuberculosis"));
        anamnesis.setMedicacionTuberculosis(request.getParameter("medicacionTuberculosis"));
        anamnesis.setComentariosTuberculosis(request.getParameter("comentariosTuberculosis"));
        //OSTEOPOROSIS//OSTEOPOROSIS
        anamnesis.setFechaDiagnosticoOsteoporosis(request.getParameter("fechaDiagnosticoOsteoporosis"));
        anamnesis.setTratamientoOsteoporosis(request.getParameter("tratamientoOsteoporosis"));
        anamnesis.setInicioTratamientoOsteoporosis(request.getParameter("inicioTratamientoOsteoporosis"));
        anamnesis.setHastaTratamientoOsteoporosis(request.getParameter("hastaTratamientoOsteoporosis"));
        anamnesis.setMedicacionOsteoporosis(request.getParameter("medicacionOsteoporosis"));
        anamnesis.setComentariosOsteoporosis(request.getParameter("comentariosOsteoporosis"));
        //HIPERTENSION//HIPERTENSION
        anamnesis.setFechaDiagnosticoHipertension(request.getParameter("fechaDiagnosticoHipertension"));
        anamnesis.setTratamientoHipertension(request.getParameter("tratamientoHipertension"));
        anamnesis.setInicioTratamientoHipertension(request.getParameter("inicioTratamientoHipertension"));
        anamnesis.setHastaTratamientoHipertension(request.getParameter("hastaTratamientoHipertension"));
        anamnesis.setMedicacionHipertension(request.getParameter("medicacionHipertension"));
        anamnesis.setComentariosHipertension(request.getParameter("comentariosHipertension"));
        //PROBLEMAS PSIQUIATRICOS//PROBLEMAS PSIQUIATRICOS
        anamnesis.setFechaDiagnosticoProblemasPsiquiatricos(request.getParameter("fechaDiagnosticoProblemasPsiquiatricos"));
        anamnesis.setTratamientoProblemasPsiquiatricos(request.getParameter("tratamientoProblemasPsiquiatricos"));
        anamnesis.setInicioTratamientoProblemasPsiquiatricos(request.getParameter("inicioTratamientoProblemasPsiquiatricos"));
        anamnesis.setHastaTratamientoProblemasPsiquiatricos(request.getParameter("hastaTratamientoProblemasPsiquiatricos"));
        anamnesis.setMedicacionProblemasPsiquiatricos(request.getParameter("medicacionProblemasPsiquiatricos"));
        anamnesis.setComentariosProblemasPsiquiatricos(request.getParameter("comentariosProblemasPsiquiatricos"));
        //ANTECEDENTES TRAUMATOLOGICOS//ANTECEDENTES TRAUMATOLOGICOS
        anamnesis.setFractura(request.getParameter("fractura"));
        anamnesis.setFechaFractura(request.getParameter("fechaFractura"));
        anamnesis.setCadera(request.getParameter("cadera"));
        anamnesis.setTobillo(request.getParameter("tobillo"));
        anamnesis.setFemur(request.getParameter("femur"));
        anamnesis.setMuneca(request.getParameter("muneca"));
        anamnesis.setAntebrazo(request.getParameter("antebrazo"));
        anamnesis.setVertebra(request.getParameter("vertebra"));
        anamnesis.setColumna(request.getParameter("columna"));
        anamnesis.setOtraFractura(request.getParameter("otraFractura"));
        anamnesis.setOtraFracturaComentarios(request.getParameter("otraFracturaComentarios"));
        anamnesis.setCausaFractura(request.getParameter("causaFractura"));
        anamnesis.setRecuperacionPostFractura(request.getParameter("recuperacionPostFractura"));
        anamnesis.setIncapacidadTotal(request.getParameter("incapacidadTotal"));
        anamnesis.setUnidadIncapacidadTotal(request.getParameter("unidadIncapacidadTotal"));
        anamnesis.setOtrosAntecedentesTraumatologicos(request.getParameter("otrosAntecedentesTraumatologicos"));
        //ANTECEDENTES GINECOLOGICOS//ANTECEDENTES GINECOLOGICOS
        anamnesis.setMenarquia(request.getParameter("menarquia"));
        anamnesis.setMenopausia(request.getParameter("menopausia"));
        anamnesis.setHisterectomia(request.getParameter("histerectomia"));
        anamnesis.setEmbarazos(request.getParameter("embarazos"));
        anamnesis.setPartos(request.getParameter("partos"));
        anamnesis.setAbortos(request.getParameter("abortos"));
        anamnesis.setHijosVivos(request.getParameter("hijosVivos"));
        anamnesis.setCiclos(request.getParameter("ciclos"));
        anamnesis.setUr(request.getParameter("ur"));
        anamnesis.setInfertilidad(request.getParameter("infertilidad"));
        anamnesis.setLactancia(request.getParameter("lactancia"));
        anamnesis.setTotalLactancia(request.getParameter("totalLactancia"));
        anamnesis.setEdadDeLosHijos(request.getParameter("edadDeLosHijos"));
        //HABITOS//HABITOS
        anamnesis.setTabaquismo(request.getParameter("tabaquismo"));
        anamnesis.setFumadorPasivo(request.getParameter("fumadorPasivo"));
        anamnesis.setFumaDesde(request.getParameter("fumaDesde"));
        anamnesis.setFrecuenciaTabaquismo(request.getParameter("frecuenciaTabaquismo"));
        anamnesis.setLicor(request.getParameter("licor"));
        anamnesis.setFrecuenciaLicor(request.getParameter("frecuenciaLicor"));
        anamnesis.setCerveza(request.getParameter("cerveza"));
        anamnesis.setVino(request.getParameter("vino"));
        anamnesis.setRon(request.getParameter("ron"));
        anamnesis.setWhiskey(request.getParameter("whiskey"));
        anamnesis.setAguardiente(request.getParameter("aguardiente"));
        anamnesis.setOtrosLicores(request.getParameter("otrosLicores"));
        anamnesis.setCafe(request.getParameter("cafe"));
        anamnesis.setFrecuenciaCafe(request.getParameter("frecuenciaCafe"));
        anamnesis.setOtroCafe(request.getParameter("otroCafe"));
        anamnesis.setInicioCafe(request.getParameter("inicioCafe"));
        anamnesis.setLecheDerivados(request.getParameter("lecheDerivados"));
        anamnesis.setFrecuenciaLecheDerivados(request.getParameter("frecuenciaLecheDerivados"));
        anamnesis.setOtroLecheDerivado(request.getParameter("otroLecheDerivado"));
        anamnesis.setInicioLecheDerivado(request.getParameter("inicioLecheDerivado"));
        anamnesis.setFrutasFrescas(request.getParameter("frutasFrescas"));
        anamnesis.setQueClasesFrutasFrescas(request.getParameter("queClasesFrutasFrescas"));
        anamnesis.setPorcionesFrutasFrescas(request.getParameter("porcionesFrutasFrescas"));
        anamnesis.setRealizaEjercicio(request.getParameter("realizaEjercicio"));
        anamnesis.setFrecuenciaEjercicio(request.getParameter("frecuenciaEjercicio"));
        anamnesis.setPescados(request.getParameter("pescados"));
        anamnesis.setPescadoRio(request.getParameter("pescadoRio"));
        anamnesis.setClasePescadoRio(request.getParameter("clasePescadoRio"));
        anamnesis.setVecesPescadoRio(request.getParameter("vecesPescadoRio"));
        anamnesis.setDesdePescadoRio(request.getParameter("desdePescadoRio"));
        anamnesis.setFrecuenciaPescadoRio(request.getParameter("frecuenciaPescadoRio"));
        anamnesis.setHastaPescadoRio(request.getParameter("hastaPescadoRio"));
        anamnesis.setPescadoMar(request.getParameter("pescadoMar"));
        anamnesis.setBlanco(request.getParameter("blanco"));
        anamnesis.setClasePescadoMarBlanco(request.getParameter("clasePescadoMarBlanco"));
        anamnesis.setVecesPescadoMarBlanco(request.getParameter("vecesPescadoMarBlanco"));
        anamnesis.setDesdePescadoMarBlanco(request.getParameter("desdePescadoMarBlanco"));
        anamnesis.setFrecuenciaPescadoMarBlanco(request.getParameter("frecuenciaPescadoMarBlanco"));
        anamnesis.setHastaPescadoMarblanco(request.getParameter("hastaPescadoMarblanco"));
        anamnesis.setAzules(request.getParameter("azules"));
        anamnesis.setClasePescadoMarAzules(request.getParameter("clasePescadoMarAzules"));
        anamnesis.setVecesPescadoMarAzules(request.getParameter("vecesPescadoMarAzules"));
        anamnesis.setDesdePescadoMarAzules(request.getParameter("desdePescadoMarAzules"));
        anamnesis.setFrecuenciaPescadoMarAzules(request.getParameter("frecuenciaPescadoMarAzules"));
        anamnesis.setHastaPescadoMarAzules(request.getParameter("hastaPescadoMarAzules"));
        anamnesis.setAntecedentesQuirurgicos(request.getParameter("antecedentesQuirurgicos"));
        anamnesis.setOtrosTratamientosAntecedentesQuirurgicos(request.getParameter("otrosTratamientosAntecedentesQuirurgicos"));
        anamnesis.setComentariosAntecedentesQuirurgicos(request.getParameter("comentariosAntecedentesQuirurgicos"));
//ANTECEDENTES FAMILIARES//ANTECEDENTES FAMILIARES
        anamnesis.setDiabetesPadre(request.getParameter("diabetesPadre"));
        anamnesis.setDiabetesMadre(request.getParameter("diabetesMadre"));
        anamnesis.setDiabetesHijo(request.getParameter("diabetesHijo"));
        anamnesis.setDiabetesTioP(request.getParameter("diabetesTioP"));
        anamnesis.setDiabetesTioM(request.getParameter("diabetesTioM"));
        anamnesis.setDiabetesHnos(request.getParameter("diabetesHnos"));
        anamnesis.setDiabetesAbueloP(request.getParameter("diabetesAbueloP"));
        anamnesis.setDiabetesAbueloM(request.getParameter("diabetesAbueloM"));
        anamnesis.setDiabetesNinguno(request.getParameter("diabetesNinguno"));
        anamnesis.setObesidadPadre(request.getParameter("obesidadPadre"));
        anamnesis.setObesidadMadre(request.getParameter("obesidadMadre"));
        anamnesis.setObesidadHijo(request.getParameter("obesidadHijo"));
        anamnesis.setObesidadTioP(request.getParameter("obesidadTioP"));
        anamnesis.setObesidadTioM(request.getParameter("obesidadTioM"));
        anamnesis.setObesidadHnos(request.getParameter("obesidadHnos"));
        anamnesis.setObesidadAbueloP(request.getParameter("obesidadAbueloP"));
        anamnesis.setObesidadAbueloM(request.getParameter("obesidadAbueloM"));
        anamnesis.setObesidadNinguno(request.getParameter("obesidadNinguno"));
        anamnesis.setColesterolPadre(request.getParameter("colesterolPadre"));
        anamnesis.setColesterolMadre(request.getParameter("colesterolMadre"));
        anamnesis.setColesterolHijo(request.getParameter("colesterolHijo"));
        anamnesis.setColesterolTioP(request.getParameter("colesterolTioP"));
        anamnesis.setColesterolTioM(request.getParameter("colesterolTioM"));
        anamnesis.setColesterolHnos(request.getParameter("colesterolHnos"));
        anamnesis.setColesterolAbueloP(request.getParameter("colesterolAbueloP"));
        anamnesis.setColesterolAbueloM(request.getParameter("colesterolAbueloM"));
        anamnesis.setColesterolNinguno(request.getParameter("colesterolNinguno"));
        anamnesis.setTrigliceridosPadre(request.getParameter("trigliceridosPadre"));
        anamnesis.setTrigliceridosMadre(request.getParameter("trigliceridosMadre"));
        anamnesis.setTrigliceridosHijo(request.getParameter("trigliceridosHijo"));
        anamnesis.setTrigliceridosTioP(request.getParameter("trigliceridosTioP"));
        anamnesis.setTrigliceridosTioM(request.getParameter("trigliceridosTioM"));
        anamnesis.setTrigliceridosHnos(request.getParameter("trigliceridosHnos"));
        anamnesis.setTrigliceridosAbueloP(request.getParameter("trigliceridosAbueloP"));
        anamnesis.setTrigliceridosAbueloM(request.getParameter("trigliceridosAbueloM"));
        anamnesis.setTrigliceridosNinguno(request.getParameter("trigliceridosNinguno"));
        anamnesis.setInfartosPadre(request.getParameter("infartosPadre"));
        anamnesis.setInfartosMadre(request.getParameter("infartosMadre"));
        anamnesis.setInfartosHijo(request.getParameter("infartosHijo"));
        anamnesis.setInfartosTioP(request.getParameter("infartosTioP"));
        anamnesis.setInfartosTioM(request.getParameter("infartosTioM"));
        anamnesis.setInfartosHnos(request.getParameter("infartosHnos"));
        anamnesis.setInfartosAbueloP(request.getParameter("infartosAbueloP"));
        anamnesis.setInfartosAbueloM(request.getParameter("infartosAbueloM"));
        anamnesis.setInfartosNinguno(request.getParameter("infartosNinguno"));
        anamnesis.setHipertensionPadre(request.getParameter("hipertensionPadre"));
        anamnesis.setHipertensionMadre(request.getParameter("hipertensionMadre"));
        anamnesis.setHipertensionHijo(request.getParameter("hipertensionHijo"));
        anamnesis.setHipertensionTioP(request.getParameter("hipertensionTioP"));
        anamnesis.setHipertensionTioM(request.getParameter("hipertensionTioM"));
        anamnesis.setHipertensionHnos(request.getParameter("hipertensionHnos"));
        anamnesis.setHipertensionAbueloP(request.getParameter("hipertensionAbueloP"));
        anamnesis.setHipertensionAbueloM(request.getParameter("hipertensionAbueloM"));
        anamnesis.setHipertensionNinguno(request.getParameter("hipertensionNinguno"));
        anamnesis.setCancerPadre(request.getParameter("cancerPadre"));
        anamnesis.setCancerMadre(request.getParameter("cancerMadre"));
        anamnesis.setCancerHijo(request.getParameter("cancerHijo"));
        anamnesis.setCancerTioP(request.getParameter("cancerTioP"));
        anamnesis.setCancerTioM(request.getParameter("cancerTioM"));
        anamnesis.setCancerHnos(request.getParameter("cancerHnos"));
        anamnesis.setCancerAbueloP(request.getParameter("cancerAbueloP"));
        anamnesis.setCancerAbueloM(request.getParameter("cancerAbueloM"));
        anamnesis.setCancerNinguno(request.getParameter("cancerNinguno"));
        anamnesis.setOsteoporosisPadre(request.getParameter("osteoporosisPadre"));
        anamnesis.setOsteoporosisMadre(request.getParameter("osteoporosisMadre"));
        anamnesis.setOsteoporosisHijo(request.getParameter("osteoporosisHijo"));
        anamnesis.setOsteoporosisTioP(request.getParameter("osteoporosisTioP"));
        anamnesis.setOsteoporosisTioM(request.getParameter("osteoporosisTioM"));
        anamnesis.setOsteoporosisHnos(request.getParameter("osteoporosisHnos"));
        anamnesis.setOsteoporosisAbueloP(request.getParameter("osteoporosisAbueloP"));
        anamnesis.setOsteoporosisAbueloM(request.getParameter("osteoporosisAbueloM"));
        anamnesis.setOsteoporosisNinguno(request.getParameter("osteoporosisNinguno"));
        anamnesis.setOtrosPadre(request.getParameter("otrosPadre"));
        anamnesis.setOtrosMadre(request.getParameter("otrosMadre"));
        anamnesis.setOtrosHijo(request.getParameter("otrosHijo"));
        anamnesis.setOtrosTioP(request.getParameter("otrosTioP"));
        anamnesis.setOtrosTioM(request.getParameter("otrosTioM"));
        anamnesis.setOtrosHnos(request.getParameter("otrosHnos"));
        anamnesis.setOtrosAbueloP(request.getParameter("otrosAbueloP"));
        anamnesis.setOtrosAbueloM(request.getParameter("otrosAbueloM"));
        anamnesis.setOtrosNinguno(request.getParameter("otrosNinguno"));
        anamnesis.setOtrosComentariosTablaAntecedentesFamiliares(request.getParameter("otrosComentariosTablaAntecedentesFamiliares"));
//CREACION//CREACION
        anamnesis.setFechaCreacionAn(request.getParameter("fechaCreacionAn"));
        anamnesis.setHoraCreacionAn(request.getParameter("horaCreacionAn"));
        anamnesis.setIdUsuario(Integer.parseInt(request.getSession().getAttribute("usuario").toString()));//RECORDAR QUE ESTE VALOR ESTA QUEMADO Y HAY QUE CAMBIARLO CUANDO SE CREE LA TABLA USUARIOS
        anamnesis = ejbAnamnesis.crear(anamnesis);
        obj = new JSONObject();
        objArray = new JSONArray();
        if (anamnesis != null) {
            obj.put("idFoto", anamnesis.getIdPaciente());
            objArray.add(obj);
        } else {
            obj.put("error", "no se pudo guardar anamnesis");
            objArray.add(obj);
        }
        return objArray;
    }

    private JSONArray traerUltimoAnamnesis(HttpServletRequest request) {
        Anamnesis anamnesis = ejbAnamnesis.traerUltimo(Integer.parseInt(request.getParameter("idPaciente")));
        obj = new JSONObject();
        objArray = new JSONArray();
        if (anamnesis != null) {
            obj.put("idAnamnesis", anamnesis.getIdAnamnesis());
            obj.put("idPaciente", anamnesis.getIdPaciente().getIdPaciente());
            obj.put("motivoConsulta", anamnesis.getMotivoConsulta());
            obj.put("historiaEnfermedadActual", anamnesis.getHistoriaEnfermedadActual());
            obj.put("bajoMedicacion", anamnesis.getBajoMedicacion());
            obj.put("bajoMedicacionComentarios", anamnesis.getBajoMedicacionComentarios());
            obj.put("alergia", anamnesis.getAlergia());
            obj.put("hepatitis", anamnesis.getHepatitis());
            obj.put("vih", anamnesis.getVih());
            obj.put("anemia", anamnesis.getAnemia());
            obj.put("herpes", anamnesis.getHerpes());
            obj.put("enfermedadRenal", anamnesis.getEnfermedadRenal());
            obj.put("artritis", anamnesis.getArtritis());
            obj.put("ulcerasOrales", anamnesis.getUlcerasOrales());
            obj.put("asma", anamnesis.getAsma());
            obj.put("diabetes", anamnesis.getDiabetes());
            obj.put("hemorragias", anamnesis.getHemorragias());
            obj.put("problemasEndocrinos", anamnesis.getProblemasEndocrinos());
            obj.put("fiebreReumatica", anamnesis.getFiebreReumatica());
            obj.put("cancer", anamnesis.getCancer());
            obj.put("problemasPsicologicos", anamnesis.getProblemasPsicologicos());
            obj.put("problemasTiroideos", anamnesis.getProblemasTiroideos());
            obj.put("problemasCardiacos", anamnesis.getProblemasCardiacos());
            obj.put("epilepsia", anamnesis.getEpilepsia());
            obj.put("tuberculosis", anamnesis.getTuberculosis());
            obj.put("osteoporosis", anamnesis.getOsteoporosis());
            obj.put("hipertension", anamnesis.getHipertension());
            obj.put("problemasPsiquiatricos", anamnesis.getProblemasPsiquiatricos());
//ANTECEDENTES PATOLOGICOS//ANTECEDENTES PATOLOGICOS//ANTECEDENTES PATOLOGICOS
//ALERGIA//ALERGIA//ALERGIA
            obj.put("fechaDiagnosticoAlergia", anamnesis.getFechaDiagnosticoAlergia());
            obj.put("tratamientoAlergia", anamnesis.getTratamientoAlergia());
            obj.put("inicioTratamientoAlergia", anamnesis.getInicioTratamientoAlergia());
            obj.put("hastaTratamientoAlergia", anamnesis.getHastaTratamientoAlergia());
            obj.put("medicacionAlergia", anamnesis.getMedicacionAlergia());
            obj.put("comentariosAlergia", anamnesis.getComentariosAlergia());
//HEPATITIS//HEPATITIS//HEPATITIS
            obj.put("fechaDiagnosticoHepatitis", anamnesis.getFechaDiagnosticoHepatitis());
            obj.put("tratamientoHepatitis", anamnesis.getTratamientoHepatitis());
            obj.put("inicioTratamientoHepatitis", anamnesis.getInicioTratamientoHepatitis());
            obj.put("hastaTratamientoHepatitis", anamnesis.getHastaTratamientoHepatitis());
            obj.put("medicacionHepatitis", anamnesis.getMedicacionHepatitis());
            obj.put("comentariosHepatitis", anamnesis.getComentariosHepatitis());
//VIH//VIH//VIH
            obj.put("fechaDiagnosticoVih", anamnesis.getFechaDiagnosticoVih());
            obj.put("tratamientoVih", anamnesis.getTratamientoVih());
            obj.put("inicioTratamientoVih", anamnesis.getInicioTratamientoVih());
            obj.put("hastaTratamientoVih", anamnesis.getHastaTratamientoVih());
            obj.put("medicacionVih", anamnesis.getMedicacionVih());
            obj.put("comentariosVih", anamnesis.getComentariosVih());
//ANEMIA//ANEMIA//ANEMIA
            obj.put("fechaDiagnosticoAnemia", anamnesis.getFechaDiagnosticoAnemia());
            obj.put("tratamientoAnemia", anamnesis.getTratamientoAnemia());
            obj.put("inicioTratamientoAnemia", anamnesis.getInicioTratamientoAnemia());
            obj.put("hastaTratamientoAnemia", anamnesis.getHastaTratamientoAnemia());
            obj.put("medicacionAnemia", anamnesis.getMedicacionAnemia());
            obj.put("comentariosAnemia", anamnesis.getComentariosAnemia());
//HERPES//HERPES//HERPES
            obj.put("fechaDiagnosticoHerpes", anamnesis.getFechaDiagnosticoHerpes());
            obj.put("tratamientoHerpes", anamnesis.getTratamientoHerpes());
            obj.put("inicioTratamientoHerpes", anamnesis.getInicioTratamientoHerpes());
            obj.put("hastaTratamientoHerpes", anamnesis.getHastaTratamientoHerpes());
            obj.put("medicacionHerpes", anamnesis.getMedicacionHerpes());
            obj.put("comentariosHerpes", anamnesis.getComentariosHerpes());
//ENFERMEDAD RENAL//ENFERMEDAD RENAL//ENFERMEDAD RENAL
            obj.put("fechaDiagnosticoEnfermedadRenal", anamnesis.getFechaDiagnosticoEnfermedadRenal());
            obj.put("tratamientoEnfermedadRenal", anamnesis.getTratamientoEnfermedadRenal());
            obj.put("inicioTratamientoEnfermedadRenal", anamnesis.getInicioTratamientoEnfermedadRenal());
            obj.put("hastaTratamientoEnfermedadRenal", anamnesis.getHastaTratamientoEnfermedadRenal());
            obj.put("medicacionEnfermedadRenal", anamnesis.getMedicacionEnfermedadRenal());
            obj.put("comentariosEnfermedadRenal", anamnesis.getComentariosEnfermedadRenal());
//ARTRITIS//ARTRITIS//ARTRITIS
            obj.put("fechaDiagnosticoArtritis", anamnesis.getFechaDiagnosticoArtritis());
            obj.put("tratamientoArtritis", anamnesis.getTratamientoArtritis());
            obj.put("inicioTratamientoArtritis", anamnesis.getInicioTratamientoArtritis());
            obj.put("hastaTratamientoArtritis", anamnesis.getHastaTratamientoArtritis());
            obj.put("medicacionArtritis", anamnesis.getMedicacionArtritis());
            obj.put("comentariosArtritis", anamnesis.getComentariosArtritis());
//ULCERAS ORALES//ULCERAS ORALES//ULCERAS ORALES
            obj.put("fechaDiagnosticoUlcerasOrales", anamnesis.getFechaDiagnosticoUlcerasOrales());
            obj.put("tratamientoUlcerasOrales", anamnesis.getTratamientoUlcerasOrales());
            obj.put("inicioTratamientoUlcerasOrales", anamnesis.getInicioTratamientoUlcerasOrales());
            obj.put("hastaTratamientoUlcerasOrales", anamnesis.getHastaTratamientoUlcerasOrales());
            obj.put("medicacionUlcerasOrales", anamnesis.getMedicacionUlcerasOrales());
            obj.put("comentariosUlcerasOrales", anamnesis.getComentariosUlcerasOrales());
//ASMA//ASMA//ASMA
            obj.put("fechaDiagnosticoAsma", anamnesis.getFechaDiagnosticoAsma());
            obj.put("tratamientoAsma", anamnesis.getTratamientoAsma());
            obj.put("inicioTratamientoAsma", anamnesis.getInicioTratamientoAsma());
            obj.put("hastaTratamientoAsma", anamnesis.getHastaTratamientoAsma());
            obj.put("medicacionAsma", anamnesis.getMedicacionAsma());
            obj.put("comentariosAsma", anamnesis.getComentariosAsma());
//DIABETES//DIABETES//DIABETES
            obj.put("fechaDiagnosticoDiabetes", anamnesis.getFechaDiagnosticoDiabetes());
            obj.put("tratamientoDiabetes", anamnesis.getTratamientoDiabetes());
            obj.put("inicioTratamientoDiabetes", anamnesis.getInicioTratamientoDiabetes());
            obj.put("hastaTratamientoDiabetes", anamnesis.getHastaTratamientoDiabetes());
            obj.put("medicacionDiabetes", anamnesis.getMedicacionDiabetes());
            obj.put("comentariosDiabetes", anamnesis.getComentariosDiabetes());
//HEMORRAGIAS//HEMORRAGIAS//HEMORRAGIAS
            obj.put("fechaDiagnosticoHemorragias", anamnesis.getFechaDiagnosticoHemorragias());
            obj.put("tratamientoHemorragias", anamnesis.getTratamientoHemorragias());
            obj.put("inicioTratamientoHemorragias", anamnesis.getInicioTratamientoHemorragias());
            obj.put("hastaTratamientoHemorragias", anamnesis.getHastaTratamientoHemorragias());
            obj.put("medicacionHemorragias", anamnesis.getMedicacionHemorragias());
            obj.put("comentariosHemorragias", anamnesis.getComentariosHemorragias());
//PROBLEMAS ENDOCRINOS//PROBLEMAS ENDOCRINOS//PROBLEMAS ENDOCRINOS
            obj.put("fechaDiagnosticoProblemasEndocrinos", anamnesis.getFechaDiagnosticoProblemasEndocrinos());
            obj.put("tratamientoProblemasEndocrinos", anamnesis.getTratamientoProblemasEndocrinos());
            obj.put("inicioTratamientoProblemasEndocrinos", anamnesis.getInicioTratamientoProblemasEndocrinos());
            obj.put("hastaTratamientoProblemasEndocrinos", anamnesis.getHastaTratamientoProblemasEndocrinos());
            obj.put("medicacionProblemasEndocrinos", anamnesis.getMedicacionProblemasEndocrinos());
            obj.put("comentariosProblemasEndocrinos", anamnesis.getComentariosProblemasEndocrinos());
//FIEBRE REUMATICA//FIEBRE REUMATICA//FIEBRE REUMATICA
            obj.put("fechaDiagnosticoFiebreReumatica", anamnesis.getFechaDiagnosticoFiebreReumatica());
            obj.put("tratamientoFiebreReumatica", anamnesis.getTratamientoFiebreReumatica());
            obj.put("inicioTratamientoFiebreReumatica", anamnesis.getInicioTratamientoFiebreReumatica());
            obj.put("hastaTratamientoFiebreReumatica", anamnesis.getHastaTratamientoFiebreReumatica());
            obj.put("medicacionFiebreReumatica", anamnesis.getMedicacionFiebreReumatica());
            obj.put("comentariosFiebreReumatica", anamnesis.getComentariosFiebreReumatica());
//CANCER//CANCER//CANCER
            obj.put("fechaDiagnosticoCancer", anamnesis.getFechaDiagnosticoCancer());
            obj.put("tratamientoCancer", anamnesis.getTratamientoCancer());
            obj.put("inicioTratamientoCancer", anamnesis.getInicioTratamientoCancer());
            obj.put("hastaTratamientoCancer", anamnesis.getHastaTratamientoCancer());
            obj.put("medicacionCancer", anamnesis.getMedicacionCancer());
            obj.put("comentariosCancer", anamnesis.getComentariosCancer());
//PROBLEMAS PSICOLOGICOS//PROBLEMAS PSICOLOGICOS//PROBLEMAS PSICOLOGICOS
            obj.put("fechaDiagnosticoProblemasPsicologicos", anamnesis.getFechaDiagnosticoProblemasPsicologicos());
            obj.put("tratamientoProblemasPsicologicos", anamnesis.getTratamientoProblemasPsicologicos());
            obj.put("inicioTratamientoProblemasPsicologicos", anamnesis.getInicioTratamientoProblemasPsicologicos());
            obj.put("hastaTratamientoProblemasPsicologicos", anamnesis.getHastaTratamientoProblemasPsicologicos());
            obj.put("medicacionProblemasPsicologicos", anamnesis.getMedicacionProblemasPsicologicos());
            obj.put("comentariosProblemasPsicologicos", anamnesis.getComentariosProblemasPsicologicos());
//PROBLEMAS TIROIDEOS//PROBLEMAS TIROIDEOS//PROBLEMAS TIROIDEOS
            obj.put("fechaDiagnosticoProblemasTiroideos", anamnesis.getFechaDiagnosticoProblemasTiroideos());
            obj.put("tratamientoProblemasTiroideos", anamnesis.getTratamientoProblemasTiroideos());
            obj.put("inicioTratamientoProblemasTiroideos", anamnesis.getInicioTratamientoProblemasTiroideos());
            obj.put("hastaTratamientoProblemasTiroideos", anamnesis.getHastaTratamientoProblemasTiroideos());
            obj.put("medicacionProblemasTiroideos", anamnesis.getMedicacionProblemasTiroideos());
            obj.put("comentariosProblemasTiroideos", anamnesis.getComentariosProblemasTiroideos());
//PROBLEMAS CARDIACOS//PROBLEMAS CARDIACOS//PROBLEMAS CARDIACOS
            obj.put("fechaDiagnosticoProblemasCardiacos", anamnesis.getFechaDiagnosticoProblemasCardiacos());
            obj.put("tratamientoProblemasCardiacos", anamnesis.getTratamientoProblemasCardiacos());
            obj.put("inicioTratamientoProblemasCardiacos", anamnesis.getInicioTratamientoProblemasCardiacos());
            obj.put("hastaTratamientoProblemasCardiacos", anamnesis.getHastaTratamientoProblemasCardiacos());
            obj.put("medicacionProblemasCardiacos", anamnesis.getMedicacionProblemasCardiacos());
            obj.put("comentariosProblemasCardiacos", anamnesis.getComentariosProblemasCardiacos());
//EPILEPSIAS//EPILEPSIAS//EPILEPSIAS
            obj.put("fechaDiagnosticoEpilepsia", anamnesis.getFechaDiagnosticoEpilepsia());
            obj.put("tratamientoEpilepsia", anamnesis.getTratamientoEpilepsia());
            obj.put("inicioTratamientoEpilepsia", anamnesis.getInicioTratamientoEpilepsia());
            obj.put("hastaTratamientoEpilepsia", anamnesis.getHastaTratamientoEpilepsia());
            obj.put("medicacionEpilepsia", anamnesis.getMedicacionEpilepsia());
            obj.put("comentariosEpilepsia", anamnesis.getComentariosEpilepsia());
//TUBERCULOSIS//TUBERCULOSIS//TUBERCULOSIS
            obj.put("fechaDiagnosticoTuberculosis", anamnesis.getFechaDiagnosticoTuberculosis());
            obj.put("tratamientoTuberculosis", anamnesis.getTratamientoTuberculosis());
            obj.put("inicioTratamientoTuberculosis", anamnesis.getInicioTratamientoTuberculosis());
            obj.put("hastaTratamientoTuberculosis", anamnesis.getHastaTratamientoTuberculosis());
            obj.put("medicacionTuberculosis", anamnesis.getMedicacionTuberculosis());
            obj.put("comentariosTuberculosis", anamnesis.getComentariosTuberculosis());
//OSTEOPOROSIS//OSTEOPOROSIS//OSTEOPOROSIS
            obj.put("fechaDiagnosticoOsteoporosis", anamnesis.getFechaDiagnosticoOsteoporosis());
            obj.put("tratamientoOsteoporosis", anamnesis.getTratamientoOsteoporosis());
            obj.put("inicioTratamientoOsteoporosis", anamnesis.getInicioTratamientoOsteoporosis());
            obj.put("hastaTratamientoOsteoporosis", anamnesis.getHastaTratamientoOsteoporosis());
            obj.put("medicacionOsteoporosis", anamnesis.getMedicacionOsteoporosis());
            obj.put("comentariosOsteoporosis", anamnesis.getComentariosOsteoporosis());
//HIPERTENSION//HIPERTENSION//HIPERTENSION
            obj.put("fechaDiagnosticoHipertension", anamnesis.getFechaDiagnosticoHipertension());
            obj.put("tratamientoHipertension", anamnesis.getTratamientoHipertension());
            obj.put("inicioTratamientoHipertension", anamnesis.getInicioTratamientoHipertension());
            obj.put("hastaTratamientoHipertension", anamnesis.getHastaTratamientoHipertension());
            obj.put("medicacionHipertension", anamnesis.getMedicacionHipertension());
            obj.put("comentariosHipertension", anamnesis.getComentariosHipertension());
//PROBLEMAS PSIQUIATRICOS//PROBLEMAS PSIQUIATRICOS//PROBLEMAS PSIQUIATRICOS
            obj.put("fechaDiagnosticoProblemasPsiquiatricos", anamnesis.getFechaDiagnosticoProblemasPsiquiatricos());
            obj.put("tratamientoProblemasPsiquiatricos", anamnesis.getTratamientoProblemasPsiquiatricos());
            obj.put("inicioTratamientoProblemasPsiquiatricos", anamnesis.getInicioTratamientoProblemasPsiquiatricos());
            obj.put("hastaTratamientoProblemasPsiquiatricos", anamnesis.getHastaTratamientoProblemasPsiquiatricos());
            obj.put("medicacionProblemasPsiquiatricos", anamnesis.getMedicacionProblemasPsiquiatricos());
            obj.put("comentariosProblemasPsiquiatricos", anamnesis.getComentariosProblemasPsiquiatricos());
//ANTECEDENTES TRAUMATOLOGICOS//ANTECEDENTES TRAUMATOLOGICOS//ANTECEDENTES TRAUMATOLOGICOS
            obj.put("fractura", anamnesis.getFractura());
            obj.put("fechaFractura", anamnesis.getFechaFractura());
            obj.put("cadera", anamnesis.getCadera());
            obj.put("tobillo", anamnesis.getTobillo());
            obj.put("femur", anamnesis.getFemur());
            obj.put("muneca", anamnesis.getMuneca());
            obj.put("antebrazo", anamnesis.getAntebrazo());
            obj.put("vertebra", anamnesis.getVertebra());
            obj.put("columna", anamnesis.getColumna());
            obj.put("otraFractura", anamnesis.getOtraFractura());
            obj.put("otraFracturaComentarios", anamnesis.getOtraFracturaComentarios());
            obj.put("causaFractura", anamnesis.getCausaFractura());
            obj.put("recuperacionPostFractura", anamnesis.getRecuperacionPostFractura());
            obj.put("incapacidadTotal", anamnesis.getIncapacidadTotal());
            obj.put("unidadIncapacidadTotal", anamnesis.getUnidadIncapacidadTotal());
            obj.put("otrosAntecedentesTraumatologicos", anamnesis.getOtrosAntecedentesTraumatologicos());
//ANTECEDENTES GINECOLOGICOS//ANTECEDENTES GINECOLOGICOS//ANTECEDENTES GINECOLOGICOS
            obj.put("menarquia", anamnesis.getMenarquia());
            obj.put("menopausia", anamnesis.getMenopausia());
            obj.put("histerectomia", anamnesis.getHisterectomia());
            obj.put("embarazos", anamnesis.getEmbarazos());
            obj.put("partos", anamnesis.getPartos());
            obj.put("abortos", anamnesis.getAbortos());
            obj.put("hijosVivos", anamnesis.getHijosVivos());
            obj.put("ciclos", anamnesis.getCiclos());
            obj.put("ur", anamnesis.getUr());
            obj.put("infertilidad", anamnesis.getInfertilidad());
            obj.put("lactancia", anamnesis.getLactancia());
            obj.put("totalLactancia", anamnesis.getTotalLactancia());
            obj.put("edadDeLosHijos", anamnesis.getEdadDeLosHijos());
//HABITOS//HABITOS//HABITOS
            obj.put("tabaquismo", anamnesis.getTabaquismo());
            obj.put("fumadorPasivo", anamnesis.getFumadorPasivo());
            obj.put("fumaDesde", anamnesis.getFumaDesde());
            obj.put("frecuenciaTabaquismo", anamnesis.getFrecuenciaTabaquismo());
            obj.put("licor", anamnesis.getLicor());
            obj.put("frecuenciaLicor", anamnesis.getFrecuenciaLicor());
            obj.put("cerveza", anamnesis.getCerveza());
            obj.put("vino", anamnesis.getVino());
            obj.put("ron", anamnesis.getRon());
            obj.put("whiskey", anamnesis.getWhiskey());
            obj.put("aguardiente", anamnesis.getAguardiente());
            obj.put("otrosLicores", anamnesis.getOtrosLicores());
            obj.put("cafe", anamnesis.getCafe());
            obj.put("frecuenciaCafe", anamnesis.getFrecuenciaCafe());
            obj.put("otroCafe", anamnesis.getOtroCafe());
            obj.put("inicioCafe", anamnesis.getInicioCafe());
            obj.put("lecheDerivados", anamnesis.getLecheDerivados());
            obj.put("frecuenciaLecheDerivados", anamnesis.getFrecuenciaLecheDerivados());
            obj.put("otroLecheDerivado", anamnesis.getOtroLecheDerivado());
            obj.put("inicioLecheDerivado", anamnesis.getInicioLecheDerivado());
            obj.put("frutasFrescas", anamnesis.getFrutasFrescas());
            obj.put("queClasesFrutasFrescas", anamnesis.getQueClasesFrutasFrescas());
            obj.put("porcionesFrutasFrescas", anamnesis.getPorcionesFrutasFrescas());
            obj.put("realizaEjercicio", anamnesis.getRealizaEjercicio());
            obj.put("frecuenciaEjercicio", anamnesis.getFrecuenciaEjercicio());
            obj.put("pescados", anamnesis.getPescados());
            obj.put("pescadoRio", anamnesis.getPescadoRio());
            obj.put("clasePescadoRio", anamnesis.getClasePescadoRio());
            obj.put("vecesPescadoRio", anamnesis.getVecesPescadoRio());
            obj.put("desdePescadoRio", anamnesis.getDesdePescadoRio());
            obj.put("frecuenciaPescadoRio", anamnesis.getFrecuenciaPescadoRio());
            obj.put("hastaPescadoRio", anamnesis.getHastaPescadoRio());
            obj.put("pescadoMar", anamnesis.getPescadoMar());
            obj.put("blanco", anamnesis.getBlanco());
            obj.put("clasePescadoMarBlanco", anamnesis.getClasePescadoMarBlanco());
            obj.put("vecesPescadoMarBlanco", anamnesis.getVecesPescadoMarBlanco());
            obj.put("desdePescadoMarBlanco", anamnesis.getDesdePescadoMarBlanco());
            obj.put("frecuenciaPescadoMarBlanco", anamnesis.getFrecuenciaPescadoMarBlanco());
            obj.put("hastaPescadoMarblanco", anamnesis.getHastaPescadoMarblanco());
            obj.put("azules", anamnesis.getAzules());
            obj.put("clasePescadoMarAzules", anamnesis.getClasePescadoMarAzules());
            obj.put("vecesPescadoMarAzules", anamnesis.getVecesPescadoMarAzules());
            obj.put("desdePescadoMarAzules", anamnesis.getDesdePescadoMarAzules());
            obj.put("frecuenciaPescadoMarAzules", anamnesis.getFrecuenciaPescadoMarAzules());
            obj.put("hastaPescadoMarAzules", anamnesis.getHastaPescadoMarAzules());
            obj.put("antecedentesQuirurgicos", anamnesis.getAntecedentesQuirurgicos());
            obj.put("otrosTratamientosAntecedentesQuirurgicos", anamnesis.getOtrosTratamientosAntecedentesQuirurgicos());
            obj.put("comentariosAntecedentesQuirurgicos", anamnesis.getComentariosAntecedentesQuirurgicos());
//ANTECEDENTES FAMILIARES//ANTECEDENTES FAMILIARES//ANTECEDENTES FAMILIARES
            obj.put("diabetesPadre", anamnesis.getDiabetesPadre());
            obj.put("diabetesMadre", anamnesis.getDiabetesMadre());
            obj.put("diabetesHijo", anamnesis.getDiabetesHijo());
            obj.put("diabetesTioP", anamnesis.getDiabetesTioP());
            obj.put("diabetesTioM", anamnesis.getDiabetesTioM());
            obj.put("diabetesHnos", anamnesis.getDiabetesHnos());
            obj.put("diabetesAbueloP", anamnesis.getDiabetesAbueloP());
            obj.put("diabetesAbueloM", anamnesis.getDiabetesAbueloM());
            obj.put("diabetesNinguno", anamnesis.getDiabetesNinguno());
            obj.put("obesidadPadre", anamnesis.getObesidadPadre());
            obj.put("obesidadMadre", anamnesis.getObesidadMadre());
            obj.put("obesidadHijo", anamnesis.getObesidadHijo());
            obj.put("obesidadTioP", anamnesis.getObesidadTioP());
            obj.put("obesidadTioM", anamnesis.getObesidadTioM());
            obj.put("obesidadHnos", anamnesis.getObesidadHnos());
            obj.put("obesidadAbueloP", anamnesis.getObesidadAbueloP());
            obj.put("obesidadAbueloM", anamnesis.getObesidadAbueloM());
            obj.put("obesidadNinguno", anamnesis.getObesidadNinguno());
            obj.put("colesterolPadre", anamnesis.getColesterolPadre());
            obj.put("colesterolMadre", anamnesis.getColesterolMadre());
            obj.put("colesterolHijo", anamnesis.getColesterolHijo());
            obj.put("colesterolTioP", anamnesis.getColesterolTioP());
            obj.put("colesterolTioM", anamnesis.getColesterolTioM());
            obj.put("colesterolHnos", anamnesis.getColesterolHnos());
            obj.put("colesterolAbueloP", anamnesis.getColesterolAbueloP());
            obj.put("colesterolAbueloM", anamnesis.getColesterolAbueloM());
            obj.put("colesterolNinguno", anamnesis.getColesterolNinguno());
            obj.put("trigliceridosPadre", anamnesis.getTrigliceridosPadre());
            obj.put("trigliceridosMadre", anamnesis.getTrigliceridosMadre());
            obj.put("trigliceridosHijo", anamnesis.getTrigliceridosHijo());
            obj.put("trigliceridosTioP", anamnesis.getTrigliceridosTioP());
            obj.put("trigliceridosTioM", anamnesis.getTrigliceridosTioM());
            obj.put("trigliceridosHnos", anamnesis.getTrigliceridosHnos());
            obj.put("trigliceridosAbueloP", anamnesis.getTrigliceridosAbueloP());
            obj.put("trigliceridosAbueloM", anamnesis.getTrigliceridosAbueloM());
            obj.put("trigliceridosNinguno", anamnesis.getTrigliceridosNinguno());
            obj.put("infartosPadre", anamnesis.getInfartosPadre());
            obj.put("infartosMadre", anamnesis.getInfartosMadre());
            obj.put("infartosHijo", anamnesis.getInfartosHijo());
            obj.put("infartosTioP", anamnesis.getInfartosTioP());
            obj.put("infartosTioM", anamnesis.getInfartosTioM());
            obj.put("infartosHnos", anamnesis.getInfartosHnos());
            obj.put("infartosAbueloP", anamnesis.getInfartosAbueloP());
            obj.put("infartosAbueloM", anamnesis.getInfartosAbueloM());
            obj.put("infartosNinguno", anamnesis.getInfartosNinguno());
            obj.put("hipertensionPadre", anamnesis.getHipertensionPadre());
            obj.put("hipertensionMadre", anamnesis.getHipertensionMadre());
            obj.put("hipertensionHijo", anamnesis.getHipertensionHijo());
            obj.put("hipertensionTioP", anamnesis.getHipertensionTioP());
            obj.put("hipertensionTioM", anamnesis.getHipertensionTioM());
            obj.put("hipertensionHnos", anamnesis.getHipertensionHnos());
            obj.put("hipertensionAbueloP", anamnesis.getHipertensionAbueloP());
            obj.put("hipertensionAbueloM", anamnesis.getHipertensionAbueloM());
            obj.put("hipertensionNinguno", anamnesis.getHipertensionNinguno());
            obj.put("cancerPadre", anamnesis.getCancerPadre());
            obj.put("cancerMadre", anamnesis.getCancerMadre());
            obj.put("cancerHijo", anamnesis.getCancerHijo());
            obj.put("cancerTioP", anamnesis.getCancerTioP());
            obj.put("cancerTioM", anamnesis.getCancerTioM());
            obj.put("cancerHnos", anamnesis.getCancerHnos());
            obj.put("cancerAbueloP", anamnesis.getCancerAbueloP());
            obj.put("cancerAbueloM", anamnesis.getCancerAbueloM());
            obj.put("cancerNinguno", anamnesis.getCancerNinguno());
            obj.put("osteoporosisPadre", anamnesis.getOsteoporosisPadre());
            obj.put("osteoporosisMadre", anamnesis.getOsteoporosisMadre());
            obj.put("osteoporosisHijo", anamnesis.getOsteoporosisHijo());
            obj.put("osteoporosisTioP", anamnesis.getOsteoporosisTioP());
            obj.put("osteoporosisTioM", anamnesis.getOsteoporosisTioM());
            obj.put("osteoporosisHnos", anamnesis.getOsteoporosisHnos());
            obj.put("osteoporosisAbueloP", anamnesis.getOsteoporosisAbueloP());
            obj.put("osteoporosisAbueloM", anamnesis.getOsteoporosisAbueloM());
            obj.put("osteoporosisNinguno", anamnesis.getOsteoporosisNinguno());
            obj.put("otrosPadre", anamnesis.getOtrosPadre());
            obj.put("otrosMadre", anamnesis.getOtrosMadre());
            obj.put("otrosHijo", anamnesis.getOtrosHijo());
            obj.put("otrosTioP", anamnesis.getOtrosTioP());
            obj.put("otrosTioM", anamnesis.getOtrosTioM());
            obj.put("otrosHnos", anamnesis.getOtrosHnos());
            obj.put("otrosAbueloP", anamnesis.getOtrosAbueloP());
            obj.put("otrosAbueloM", anamnesis.getOtrosAbueloM());
            obj.put("otrosNinguno", anamnesis.getOtrosNinguno());
            obj.put("otrosComentariosTablaAntecedentesFamiliares", anamnesis.getOtrosComentariosTablaAntecedentesFamiliares());
//CREACION//CREACION//CREACION
            obj.put("fechaCreacionAn", anamnesis.getFechaCreacionAn());
            obj.put("horaCreacionAn", anamnesis.getHoraCreacionAn());
            objArray.add(obj);
        }
        return objArray;
    }

    private JSONArray traerAnamnesisFecha(HttpServletRequest request) {
        Anamnesis anamnesis = ejbAnamnesis.traer(Integer.parseInt(request.getParameter("idPaciente")),request.getParameter("fecha"));
        obj = new JSONObject();
        objArray = new JSONArray();
        if (anamnesis != null) {
            obj.put("idAnamnesis", anamnesis.getIdAnamnesis());
            obj.put("idPaciente", anamnesis.getIdPaciente().getIdPaciente());
            obj.put("motivoConsulta", anamnesis.getMotivoConsulta());
            obj.put("historiaEnfermedadActual", anamnesis.getHistoriaEnfermedadActual());
            obj.put("bajoMedicacion", anamnesis.getBajoMedicacion());
            obj.put("bajoMedicacionComentarios", anamnesis.getBajoMedicacionComentarios());
            obj.put("alergia", anamnesis.getAlergia());
            obj.put("hepatitis", anamnesis.getHepatitis());
            obj.put("vih", anamnesis.getVih());
            obj.put("anemia", anamnesis.getAnemia());
            obj.put("herpes", anamnesis.getHerpes());
            obj.put("enfermedadRenal", anamnesis.getEnfermedadRenal());
            obj.put("artritis", anamnesis.getArtritis());
            obj.put("ulcerasOrales", anamnesis.getUlcerasOrales());
            obj.put("asma", anamnesis.getAsma());
            obj.put("diabetes", anamnesis.getDiabetes());
            obj.put("hemorragias", anamnesis.getHemorragias());
            obj.put("problemasEndocrinos", anamnesis.getProblemasEndocrinos());
            obj.put("fiebreReumatica", anamnesis.getFiebreReumatica());
            obj.put("cancer", anamnesis.getCancer());
            obj.put("problemasPsicologicos", anamnesis.getProblemasPsicologicos());
            obj.put("problemasTiroideos", anamnesis.getProblemasTiroideos());
            obj.put("problemasCardiacos", anamnesis.getProblemasCardiacos());
            obj.put("epilepsia", anamnesis.getEpilepsia());
            obj.put("tuberculosis", anamnesis.getTuberculosis());
            obj.put("osteoporosis", anamnesis.getOsteoporosis());
            obj.put("hipertension", anamnesis.getHipertension());
            obj.put("problemasPsiquiatricos", anamnesis.getProblemasPsiquiatricos());
//ANTECEDENTES PATOLOGICOS//ANTECEDENTES PATOLOGICOS//ANTECEDENTES PATOLOGICOS
//ALERGIA//ALERGIA//ALERGIA
            obj.put("fechaDiagnosticoAlergia", anamnesis.getFechaDiagnosticoAlergia());
            obj.put("tratamientoAlergia", anamnesis.getTratamientoAlergia());
            obj.put("inicioTratamientoAlergia", anamnesis.getInicioTratamientoAlergia());
            obj.put("hastaTratamientoAlergia", anamnesis.getHastaTratamientoAlergia());
            obj.put("medicacionAlergia", anamnesis.getMedicacionAlergia());
            obj.put("comentariosAlergia", anamnesis.getComentariosAlergia());
//HEPATITIS//HEPATITIS//HEPATITIS
            obj.put("fechaDiagnosticoHepatitis", anamnesis.getFechaDiagnosticoHepatitis());
            obj.put("tratamientoHepatitis", anamnesis.getTratamientoHepatitis());
            obj.put("inicioTratamientoHepatitis", anamnesis.getInicioTratamientoHepatitis());
            obj.put("hastaTratamientoHepatitis", anamnesis.getHastaTratamientoHepatitis());
            obj.put("medicacionHepatitis", anamnesis.getMedicacionHepatitis());
            obj.put("comentariosHepatitis", anamnesis.getComentariosHepatitis());
//VIH//VIH//VIH
            obj.put("fechaDiagnosticoVih", anamnesis.getFechaDiagnosticoVih());
            obj.put("tratamientoVih", anamnesis.getTratamientoVih());
            obj.put("inicioTratamientoVih", anamnesis.getInicioTratamientoVih());
            obj.put("hastaTratamientoVih", anamnesis.getHastaTratamientoVih());
            obj.put("medicacionVih", anamnesis.getMedicacionVih());
            obj.put("comentariosVih", anamnesis.getComentariosVih());
//ANEMIA//ANEMIA//ANEMIA
            obj.put("fechaDiagnosticoAnemia", anamnesis.getFechaDiagnosticoAnemia());
            obj.put("tratamientoAnemia", anamnesis.getTratamientoAnemia());
            obj.put("inicioTratamientoAnemia", anamnesis.getInicioTratamientoAnemia());
            obj.put("hastaTratamientoAnemia", anamnesis.getHastaTratamientoAnemia());
            obj.put("medicacionAnemia", anamnesis.getMedicacionAnemia());
            obj.put("comentariosAnemia", anamnesis.getComentariosAnemia());
//HERPES//HERPES//HERPES
            obj.put("fechaDiagnosticoHerpes", anamnesis.getFechaDiagnosticoHerpes());
            obj.put("tratamientoHerpes", anamnesis.getTratamientoHerpes());
            obj.put("inicioTratamientoHerpes", anamnesis.getInicioTratamientoHerpes());
            obj.put("hastaTratamientoHerpes", anamnesis.getHastaTratamientoHerpes());
            obj.put("medicacionHerpes", anamnesis.getMedicacionHerpes());
            obj.put("comentariosHerpes", anamnesis.getComentariosHerpes());
//ENFERMEDAD RENAL//ENFERMEDAD RENAL//ENFERMEDAD RENAL
            obj.put("fechaDiagnosticoEnfermedadRenal", anamnesis.getFechaDiagnosticoEnfermedadRenal());
            obj.put("tratamientoEnfermedadRenal", anamnesis.getTratamientoEnfermedadRenal());
            obj.put("inicioTratamientoEnfermedadRenal", anamnesis.getInicioTratamientoEnfermedadRenal());
            obj.put("hastaTratamientoEnfermedadRenal", anamnesis.getHastaTratamientoEnfermedadRenal());
            obj.put("medicacionEnfermedadRenal", anamnesis.getMedicacionEnfermedadRenal());
            obj.put("comentariosEnfermedadRenal", anamnesis.getComentariosEnfermedadRenal());
//ARTRITIS//ARTRITIS//ARTRITIS
            obj.put("fechaDiagnosticoArtritis", anamnesis.getFechaDiagnosticoArtritis());
            obj.put("tratamientoArtritis", anamnesis.getTratamientoArtritis());
            obj.put("inicioTratamientoArtritis", anamnesis.getInicioTratamientoArtritis());
            obj.put("hastaTratamientoArtritis", anamnesis.getHastaTratamientoArtritis());
            obj.put("medicacionArtritis", anamnesis.getMedicacionArtritis());
            obj.put("comentariosArtritis", anamnesis.getComentariosArtritis());
//ULCERAS ORALES//ULCERAS ORALES//ULCERAS ORALES
            obj.put("fechaDiagnosticoUlcerasOrales", anamnesis.getFechaDiagnosticoUlcerasOrales());
            obj.put("tratamientoUlcerasOrales", anamnesis.getTratamientoUlcerasOrales());
            obj.put("inicioTratamientoUlcerasOrales", anamnesis.getInicioTratamientoUlcerasOrales());
            obj.put("hastaTratamientoUlcerasOrales", anamnesis.getHastaTratamientoUlcerasOrales());
            obj.put("medicacionUlcerasOrales", anamnesis.getMedicacionUlcerasOrales());
            obj.put("comentariosUlcerasOrales", anamnesis.getComentariosUlcerasOrales());
//ASMA//ASMA//ASMA
            obj.put("fechaDiagnosticoAsma", anamnesis.getFechaDiagnosticoAsma());
            obj.put("tratamientoAsma", anamnesis.getTratamientoAsma());
            obj.put("inicioTratamientoAsma", anamnesis.getInicioTratamientoAsma());
            obj.put("hastaTratamientoAsma", anamnesis.getHastaTratamientoAsma());
            obj.put("medicacionAsma", anamnesis.getMedicacionAsma());
            obj.put("comentariosAsma", anamnesis.getComentariosAsma());
//DIABETES//DIABETES//DIABETES
            obj.put("fechaDiagnosticoDiabetes", anamnesis.getFechaDiagnosticoDiabetes());
            obj.put("tratamientoDiabetes", anamnesis.getTratamientoDiabetes());
            obj.put("inicioTratamientoDiabetes", anamnesis.getInicioTratamientoDiabetes());
            obj.put("hastaTratamientoDiabetes", anamnesis.getHastaTratamientoDiabetes());
            obj.put("medicacionDiabetes", anamnesis.getMedicacionDiabetes());
            obj.put("comentariosDiabetes", anamnesis.getComentariosDiabetes());
//HEMORRAGIAS//HEMORRAGIAS//HEMORRAGIAS
            obj.put("fechaDiagnosticoHemorragias", anamnesis.getFechaDiagnosticoHemorragias());
            obj.put("tratamientoHemorragias", anamnesis.getTratamientoHemorragias());
            obj.put("inicioTratamientoHemorragias", anamnesis.getInicioTratamientoHemorragias());
            obj.put("hastaTratamientoHemorragias", anamnesis.getHastaTratamientoHemorragias());
            obj.put("medicacionHemorragias", anamnesis.getMedicacionHemorragias());
            obj.put("comentariosHemorragias", anamnesis.getComentariosHemorragias());
//PROBLEMAS ENDOCRINOS//PROBLEMAS ENDOCRINOS//PROBLEMAS ENDOCRINOS
            obj.put("fechaDiagnosticoProblemasEndocrinos", anamnesis.getFechaDiagnosticoProblemasEndocrinos());
            obj.put("tratamientoProblemasEndocrinos", anamnesis.getTratamientoProblemasEndocrinos());
            obj.put("inicioTratamientoProblemasEndocrinos", anamnesis.getInicioTratamientoProblemasEndocrinos());
            obj.put("hastaTratamientoProblemasEndocrinos", anamnesis.getHastaTratamientoProblemasEndocrinos());
            obj.put("medicacionProblemasEndocrinos", anamnesis.getMedicacionProblemasEndocrinos());
            obj.put("comentariosProblemasEndocrinos", anamnesis.getComentariosProblemasEndocrinos());
//FIEBRE REUMATICA//FIEBRE REUMATICA//FIEBRE REUMATICA
            obj.put("fechaDiagnosticoFiebreReumatica", anamnesis.getFechaDiagnosticoFiebreReumatica());
            obj.put("tratamientoFiebreReumatica", anamnesis.getTratamientoFiebreReumatica());
            obj.put("inicioTratamientoFiebreReumatica", anamnesis.getInicioTratamientoFiebreReumatica());
            obj.put("hastaTratamientoFiebreReumatica", anamnesis.getHastaTratamientoFiebreReumatica());
            obj.put("medicacionFiebreReumatica", anamnesis.getMedicacionFiebreReumatica());
            obj.put("comentariosFiebreReumatica", anamnesis.getComentariosFiebreReumatica());
//CANCER//CANCER//CANCER
            obj.put("fechaDiagnosticoCancer", anamnesis.getFechaDiagnosticoCancer());
            obj.put("tratamientoCancer", anamnesis.getTratamientoCancer());
            obj.put("inicioTratamientoCancer", anamnesis.getInicioTratamientoCancer());
            obj.put("hastaTratamientoCancer", anamnesis.getHastaTratamientoCancer());
            obj.put("medicacionCancer", anamnesis.getMedicacionCancer());
            obj.put("comentariosCancer", anamnesis.getComentariosCancer());
//PROBLEMAS PSICOLOGICOS//PROBLEMAS PSICOLOGICOS//PROBLEMAS PSICOLOGICOS
            obj.put("fechaDiagnosticoProblemasPsicologicos", anamnesis.getFechaDiagnosticoProblemasPsicologicos());
            obj.put("tratamientoProblemasPsicologicos", anamnesis.getTratamientoProblemasPsicologicos());
            obj.put("inicioTratamientoProblemasPsicologicos", anamnesis.getInicioTratamientoProblemasPsicologicos());
            obj.put("hastaTratamientoProblemasPsicologicos", anamnesis.getHastaTratamientoProblemasPsicologicos());
            obj.put("medicacionProblemasPsicologicos", anamnesis.getMedicacionProblemasPsicologicos());
            obj.put("comentariosProblemasPsicologicos", anamnesis.getComentariosProblemasPsicologicos());
//PROBLEMAS TIROIDEOS//PROBLEMAS TIROIDEOS//PROBLEMAS TIROIDEOS
            obj.put("fechaDiagnosticoProblemasTiroideos", anamnesis.getFechaDiagnosticoProblemasTiroideos());
            obj.put("tratamientoProblemasTiroideos", anamnesis.getTratamientoProblemasTiroideos());
            obj.put("inicioTratamientoProblemasTiroideos", anamnesis.getInicioTratamientoProblemasTiroideos());
            obj.put("hastaTratamientoProblemasTiroideos", anamnesis.getHastaTratamientoProblemasTiroideos());
            obj.put("medicacionProblemasTiroideos", anamnesis.getMedicacionProblemasTiroideos());
            obj.put("comentariosProblemasTiroideos", anamnesis.getComentariosProblemasTiroideos());
//PROBLEMAS CARDIACOS//PROBLEMAS CARDIACOS//PROBLEMAS CARDIACOS
            obj.put("fechaDiagnosticoProblemasCardiacos", anamnesis.getFechaDiagnosticoProblemasCardiacos());
            obj.put("tratamientoProblemasCardiacos", anamnesis.getTratamientoProblemasCardiacos());
            obj.put("inicioTratamientoProblemasCardiacos", anamnesis.getInicioTratamientoProblemasCardiacos());
            obj.put("hastaTratamientoProblemasCardiacos", anamnesis.getHastaTratamientoProblemasCardiacos());
            obj.put("medicacionProblemasCardiacos", anamnesis.getMedicacionProblemasCardiacos());
            obj.put("comentariosProblemasCardiacos", anamnesis.getComentariosProblemasCardiacos());
//EPILEPSIAS//EPILEPSIAS//EPILEPSIAS
            obj.put("fechaDiagnosticoEpilepsia", anamnesis.getFechaDiagnosticoEpilepsia());
            obj.put("tratamientoEpilepsia", anamnesis.getTratamientoEpilepsia());
            obj.put("inicioTratamientoEpilepsia", anamnesis.getInicioTratamientoEpilepsia());
            obj.put("hastaTratamientoEpilepsia", anamnesis.getHastaTratamientoEpilepsia());
            obj.put("medicacionEpilepsia", anamnesis.getMedicacionEpilepsia());
            obj.put("comentariosEpilepsia", anamnesis.getComentariosEpilepsia());
//TUBERCULOSIS//TUBERCULOSIS//TUBERCULOSIS
            obj.put("fechaDiagnosticoTuberculosis", anamnesis.getFechaDiagnosticoTuberculosis());
            obj.put("tratamientoTuberculosis", anamnesis.getTratamientoTuberculosis());
            obj.put("inicioTratamientoTuberculosis", anamnesis.getInicioTratamientoTuberculosis());
            obj.put("hastaTratamientoTuberculosis", anamnesis.getHastaTratamientoTuberculosis());
            obj.put("medicacionTuberculosis", anamnesis.getMedicacionTuberculosis());
            obj.put("comentariosTuberculosis", anamnesis.getComentariosTuberculosis());
//OSTEOPOROSIS//OSTEOPOROSIS//OSTEOPOROSIS
            obj.put("fechaDiagnosticoOsteoporosis", anamnesis.getFechaDiagnosticoOsteoporosis());
            obj.put("tratamientoOsteoporosis", anamnesis.getTratamientoOsteoporosis());
            obj.put("inicioTratamientoOsteoporosis", anamnesis.getInicioTratamientoOsteoporosis());
            obj.put("hastaTratamientoOsteoporosis", anamnesis.getHastaTratamientoOsteoporosis());
            obj.put("medicacionOsteoporosis", anamnesis.getMedicacionOsteoporosis());
            obj.put("comentariosOsteoporosis", anamnesis.getComentariosOsteoporosis());
//HIPERTENSION//HIPERTENSION//HIPERTENSION
            obj.put("fechaDiagnosticoHipertension", anamnesis.getFechaDiagnosticoHipertension());
            obj.put("tratamientoHipertension", anamnesis.getTratamientoHipertension());
            obj.put("inicioTratamientoHipertension", anamnesis.getInicioTratamientoHipertension());
            obj.put("hastaTratamientoHipertension", anamnesis.getHastaTratamientoHipertension());
            obj.put("medicacionHipertension", anamnesis.getMedicacionHipertension());
            obj.put("comentariosHipertension", anamnesis.getComentariosHipertension());
//PROBLEMAS PSIQUIATRICOS//PROBLEMAS PSIQUIATRICOS//PROBLEMAS PSIQUIATRICOS
            obj.put("fechaDiagnosticoProblemasPsiquiatricos", anamnesis.getFechaDiagnosticoProblemasPsiquiatricos());
            obj.put("tratamientoProblemasPsiquiatricos", anamnesis.getTratamientoProblemasPsiquiatricos());
            obj.put("inicioTratamientoProblemasPsiquiatricos", anamnesis.getInicioTratamientoProblemasPsiquiatricos());
            obj.put("hastaTratamientoProblemasPsiquiatricos", anamnesis.getHastaTratamientoProblemasPsiquiatricos());
            obj.put("medicacionProblemasPsiquiatricos", anamnesis.getMedicacionProblemasPsiquiatricos());
            obj.put("comentariosProblemasPsiquiatricos", anamnesis.getComentariosProblemasPsiquiatricos());
//ANTECEDENTES TRAUMATOLOGICOS//ANTECEDENTES TRAUMATOLOGICOS//ANTECEDENTES TRAUMATOLOGICOS
            obj.put("fractura", anamnesis.getFractura());
            obj.put("fechaFractura", anamnesis.getFechaFractura());
            obj.put("cadera", anamnesis.getCadera());
            obj.put("tobillo", anamnesis.getTobillo());
            obj.put("femur", anamnesis.getFemur());
            obj.put("muneca", anamnesis.getMuneca());
            obj.put("antebrazo", anamnesis.getAntebrazo());
            obj.put("vertebra", anamnesis.getVertebra());
            obj.put("columna", anamnesis.getColumna());
            obj.put("otraFractura", anamnesis.getOtraFractura());
            obj.put("otraFracturaComentarios", anamnesis.getOtraFracturaComentarios());
            obj.put("causaFractura", anamnesis.getCausaFractura());
            obj.put("recuperacionPostFractura", anamnesis.getRecuperacionPostFractura());
            obj.put("incapacidadTotal", anamnesis.getIncapacidadTotal());
            obj.put("unidadIncapacidadTotal", anamnesis.getUnidadIncapacidadTotal());
            obj.put("otrosAntecedentesTraumatologicos", anamnesis.getOtrosAntecedentesTraumatologicos());
//ANTECEDENTES GINECOLOGICOS//ANTECEDENTES GINECOLOGICOS//ANTECEDENTES GINECOLOGICOS
            obj.put("menarquia", anamnesis.getMenarquia());
            obj.put("menopausia", anamnesis.getMenopausia());
            obj.put("histerectomia", anamnesis.getHisterectomia());
            obj.put("embarazos", anamnesis.getEmbarazos());
            obj.put("partos", anamnesis.getPartos());
            obj.put("abortos", anamnesis.getAbortos());
            obj.put("hijosVivos", anamnesis.getHijosVivos());
            obj.put("ciclos", anamnesis.getCiclos());
            obj.put("ur", anamnesis.getUr());
            obj.put("infertilidad", anamnesis.getInfertilidad());
            obj.put("lactancia", anamnesis.getLactancia());
            obj.put("totalLactancia", anamnesis.getTotalLactancia());
            obj.put("edadDeLosHijos", anamnesis.getEdadDeLosHijos());
//HABITOS//HABITOS//HABITOS
            obj.put("tabaquismo", anamnesis.getTabaquismo());
            obj.put("fumadorPasivo", anamnesis.getFumadorPasivo());
            obj.put("fumaDesde", anamnesis.getFumaDesde());
            obj.put("frecuenciaTabaquismo", anamnesis.getFrecuenciaTabaquismo());
            obj.put("licor", anamnesis.getLicor());
            obj.put("frecuenciaLicor", anamnesis.getFrecuenciaLicor());
            obj.put("cerveza", anamnesis.getCerveza());
            obj.put("vino", anamnesis.getVino());
            obj.put("ron", anamnesis.getRon());
            obj.put("whiskey", anamnesis.getWhiskey());
            obj.put("aguardiente", anamnesis.getAguardiente());
            obj.put("otrosLicores", anamnesis.getOtrosLicores());
            obj.put("cafe", anamnesis.getCafe());
            obj.put("frecuenciaCafe", anamnesis.getFrecuenciaCafe());
            obj.put("otroCafe", anamnesis.getOtroCafe());
            obj.put("inicioCafe", anamnesis.getInicioCafe());
            obj.put("lecheDerivados", anamnesis.getLecheDerivados());
            obj.put("frecuenciaLecheDerivados", anamnesis.getFrecuenciaLecheDerivados());
            obj.put("otroLecheDerivado", anamnesis.getOtroLecheDerivado());
            obj.put("inicioLecheDerivado", anamnesis.getInicioLecheDerivado());
            obj.put("frutasFrescas", anamnesis.getFrutasFrescas());
            obj.put("queClasesFrutasFrescas", anamnesis.getQueClasesFrutasFrescas());
            obj.put("porcionesFrutasFrescas", anamnesis.getPorcionesFrutasFrescas());
            obj.put("realizaEjercicio", anamnesis.getRealizaEjercicio());
            obj.put("frecuenciaEjercicio", anamnesis.getFrecuenciaEjercicio());
            obj.put("pescados", anamnesis.getPescados());
            obj.put("pescadoRio", anamnesis.getPescadoRio());
            obj.put("clasePescadoRio", anamnesis.getClasePescadoRio());
            obj.put("vecesPescadoRio", anamnesis.getVecesPescadoRio());
            obj.put("desdePescadoRio", anamnesis.getDesdePescadoRio());
            obj.put("frecuenciaPescadoRio", anamnesis.getFrecuenciaPescadoRio());
            obj.put("hastaPescadoRio", anamnesis.getHastaPescadoRio());
            obj.put("pescadoMar", anamnesis.getPescadoMar());
            obj.put("blanco", anamnesis.getBlanco());
            obj.put("clasePescadoMarBlanco", anamnesis.getClasePescadoMarBlanco());
            obj.put("vecesPescadoMarBlanco", anamnesis.getVecesPescadoMarBlanco());
            obj.put("desdePescadoMarBlanco", anamnesis.getDesdePescadoMarBlanco());
            obj.put("frecuenciaPescadoMarBlanco", anamnesis.getFrecuenciaPescadoMarBlanco());
            obj.put("hastaPescadoMarblanco", anamnesis.getHastaPescadoMarblanco());
            obj.put("azules", anamnesis.getAzules());
            obj.put("clasePescadoMarAzules", anamnesis.getClasePescadoMarAzules());
            obj.put("vecesPescadoMarAzules", anamnesis.getVecesPescadoMarAzules());
            obj.put("desdePescadoMarAzules", anamnesis.getDesdePescadoMarAzules());
            obj.put("frecuenciaPescadoMarAzules", anamnesis.getFrecuenciaPescadoMarAzules());
            obj.put("hastaPescadoMarAzules", anamnesis.getHastaPescadoMarAzules());
            obj.put("antecedentesQuirurgicos", anamnesis.getAntecedentesQuirurgicos());
            obj.put("otrosTratamientosAntecedentesQuirurgicos", anamnesis.getOtrosTratamientosAntecedentesQuirurgicos());
            obj.put("comentariosAntecedentesQuirurgicos", anamnesis.getComentariosAntecedentesQuirurgicos());
//ANTECEDENTES FAMILIARES//ANTECEDENTES FAMILIARES//ANTECEDENTES FAMILIARES
            obj.put("diabetesPadre", anamnesis.getDiabetesPadre());
            obj.put("diabetesMadre", anamnesis.getDiabetesMadre());
            obj.put("diabetesHijo", anamnesis.getDiabetesHijo());
            obj.put("diabetesTioP", anamnesis.getDiabetesTioP());
            obj.put("diabetesTioM", anamnesis.getDiabetesTioM());
            obj.put("diabetesHnos", anamnesis.getDiabetesHnos());
            obj.put("diabetesAbueloP", anamnesis.getDiabetesAbueloP());
            obj.put("diabetesAbueloM", anamnesis.getDiabetesAbueloM());
            obj.put("diabetesNinguno", anamnesis.getDiabetesNinguno());
            obj.put("obesidadPadre", anamnesis.getObesidadPadre());
            obj.put("obesidadMadre", anamnesis.getObesidadMadre());
            obj.put("obesidadHijo", anamnesis.getObesidadHijo());
            obj.put("obesidadTioP", anamnesis.getObesidadTioP());
            obj.put("obesidadTioM", anamnesis.getObesidadTioM());
            obj.put("obesidadHnos", anamnesis.getObesidadHnos());
            obj.put("obesidadAbueloP", anamnesis.getObesidadAbueloP());
            obj.put("obesidadAbueloM", anamnesis.getObesidadAbueloM());
            obj.put("obesidadNinguno", anamnesis.getObesidadNinguno());
            obj.put("colesterolPadre", anamnesis.getColesterolPadre());
            obj.put("colesterolMadre", anamnesis.getColesterolMadre());
            obj.put("colesterolHijo", anamnesis.getColesterolHijo());
            obj.put("colesterolTioP", anamnesis.getColesterolTioP());
            obj.put("colesterolTioM", anamnesis.getColesterolTioM());
            obj.put("colesterolHnos", anamnesis.getColesterolHnos());
            obj.put("colesterolAbueloP", anamnesis.getColesterolAbueloP());
            obj.put("colesterolAbueloM", anamnesis.getColesterolAbueloM());
            obj.put("colesterolNinguno", anamnesis.getColesterolNinguno());
            obj.put("trigliceridosPadre", anamnesis.getTrigliceridosPadre());
            obj.put("trigliceridosMadre", anamnesis.getTrigliceridosMadre());
            obj.put("trigliceridosHijo", anamnesis.getTrigliceridosHijo());
            obj.put("trigliceridosTioP", anamnesis.getTrigliceridosTioP());
            obj.put("trigliceridosTioM", anamnesis.getTrigliceridosTioM());
            obj.put("trigliceridosHnos", anamnesis.getTrigliceridosHnos());
            obj.put("trigliceridosAbueloP", anamnesis.getTrigliceridosAbueloP());
            obj.put("trigliceridosAbueloM", anamnesis.getTrigliceridosAbueloM());
            obj.put("trigliceridosNinguno", anamnesis.getTrigliceridosNinguno());
            obj.put("infartosPadre", anamnesis.getInfartosPadre());
            obj.put("infartosMadre", anamnesis.getInfartosMadre());
            obj.put("infartosHijo", anamnesis.getInfartosHijo());
            obj.put("infartosTioP", anamnesis.getInfartosTioP());
            obj.put("infartosTioM", anamnesis.getInfartosTioM());
            obj.put("infartosHnos", anamnesis.getInfartosHnos());
            obj.put("infartosAbueloP", anamnesis.getInfartosAbueloP());
            obj.put("infartosAbueloM", anamnesis.getInfartosAbueloM());
            obj.put("infartosNinguno", anamnesis.getInfartosNinguno());
            obj.put("hipertensionPadre", anamnesis.getHipertensionPadre());
            obj.put("hipertensionMadre", anamnesis.getHipertensionMadre());
            obj.put("hipertensionHijo", anamnesis.getHipertensionHijo());
            obj.put("hipertensionTioP", anamnesis.getHipertensionTioP());
            obj.put("hipertensionTioM", anamnesis.getHipertensionTioM());
            obj.put("hipertensionHnos", anamnesis.getHipertensionHnos());
            obj.put("hipertensionAbueloP", anamnesis.getHipertensionAbueloP());
            obj.put("hipertensionAbueloM", anamnesis.getHipertensionAbueloM());
            obj.put("hipertensionNinguno", anamnesis.getHipertensionNinguno());
            obj.put("cancerPadre", anamnesis.getCancerPadre());
            obj.put("cancerMadre", anamnesis.getCancerMadre());
            obj.put("cancerHijo", anamnesis.getCancerHijo());
            obj.put("cancerTioP", anamnesis.getCancerTioP());
            obj.put("cancerTioM", anamnesis.getCancerTioM());
            obj.put("cancerHnos", anamnesis.getCancerHnos());
            obj.put("cancerAbueloP", anamnesis.getCancerAbueloP());
            obj.put("cancerAbueloM", anamnesis.getCancerAbueloM());
            obj.put("cancerNinguno", anamnesis.getCancerNinguno());
            obj.put("osteoporosisPadre", anamnesis.getOsteoporosisPadre());
            obj.put("osteoporosisMadre", anamnesis.getOsteoporosisMadre());
            obj.put("osteoporosisHijo", anamnesis.getOsteoporosisHijo());
            obj.put("osteoporosisTioP", anamnesis.getOsteoporosisTioP());
            obj.put("osteoporosisTioM", anamnesis.getOsteoporosisTioM());
            obj.put("osteoporosisHnos", anamnesis.getOsteoporosisHnos());
            obj.put("osteoporosisAbueloP", anamnesis.getOsteoporosisAbueloP());
            obj.put("osteoporosisAbueloM", anamnesis.getOsteoporosisAbueloM());
            obj.put("osteoporosisNinguno", anamnesis.getOsteoporosisNinguno());
            obj.put("otrosPadre", anamnesis.getOtrosPadre());
            obj.put("otrosMadre", anamnesis.getOtrosMadre());
            obj.put("otrosHijo", anamnesis.getOtrosHijo());
            obj.put("otrosTioP", anamnesis.getOtrosTioP());
            obj.put("otrosTioM", anamnesis.getOtrosTioM());
            obj.put("otrosHnos", anamnesis.getOtrosHnos());
            obj.put("otrosAbueloP", anamnesis.getOtrosAbueloP());
            obj.put("otrosAbueloM", anamnesis.getOtrosAbueloM());
            obj.put("otrosNinguno", anamnesis.getOtrosNinguno());
            obj.put("otrosComentariosTablaAntecedentesFamiliares", anamnesis.getOtrosComentariosTablaAntecedentesFamiliares());
//CREACION//CREACION//CREACION
            obj.put("fechaCreacionAn", anamnesis.getFechaCreacionAn());
            obj.put("horaCreacionAn", anamnesis.getHoraCreacionAn());
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
