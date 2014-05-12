/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.db;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author saintec
 */
@WebServlet(name = "HCEMedSqlDbWeb", urlPatterns = {"/HCEDb"})
public class HCEMedSqlDbWeb extends HttpServlet {

    @EJB
    HCEMedSqlDb ejb;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //TABLA PACIENTES
            String pacientes = "CREATE TABLE IF NOT EXISTS `Pacientes` ("
                    + "`idPaciente` int(11) NOT NULL AUTO_INCREMENT,  "
                    + "`alertaMedica` longtext COLLATE utf8_spanish_ci,  "
                    + "`nombrePaciente` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`foto` longtext COLLATE utf8_spanish_ci,  "
                    + "`apellidoPaciente` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`fechaNacimientoPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`tipoIdentificacionPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`identificacionPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`estadoPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`estadoCivilPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`sexoPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`razaPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`ocupacionPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`telefonoPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`celularPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`emailPaciente` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`paisPaciente` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`departamentoPaciente` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`ciudadPaciente` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`nacionalidadPaciente` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`direccionPaciente` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`zonaResidencialPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`codigoPostalPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`estratoPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`companiaSeguroPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`tipoVinculacionPaciente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`nombreRepresentante` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`apellidoRepresentante` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`tipoIdentificacionRepresentante` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`identificacionRepresentante` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`telefonoRepresentante` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`parentescoRepresentante` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`nombreEmergencia` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`telefonoEmergencia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`parentescoEmergencia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`nombreReferido` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`fechaCreacion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`horaCreacion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,  "
                    + "`idUsuario` int(11) DEFAULT NULL,  "
                    + "PRIMARY KEY (`idPaciente`)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;";
            out.println(ejb.crear(pacientes, "Pacientes") + "<br>");

            //TABLA ANAMNESIS
            String anamnesis = "CREATE TABLE IF NOT EXISTS `Anamnesis` ("
                    + "`idAnamnesis` int(11) NOT NULL AUTO_INCREMENT, "
                    + "`idPaciente` int(11) DEFAULT NULL, "
                    + "`motivoConsulta` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`historiaEnfermedadActual` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`bajoMedicacion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`bajoMedicacionComentarios` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`alergia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hepatitis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`vih` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`anemia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`herpes` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`enfermedadRenal` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`artritis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`ulcerasOrales` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`asma` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`diabetes` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hemorragias` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`problemasEndocrinos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fiebreReumatica` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`cancer` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`problemasPsicologicos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`problemasTiroideos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`problemasCardiacos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`epilepsia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tuberculosis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`osteoporosis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hipertension` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`problemasPsiquiatricos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoAlergia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoAlergia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoAlergia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoAlergia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionAlergia` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosAlergia` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoHepatitis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoHepatitis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoHepatitis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoHepatitis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionHepatitis` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosHepatitis` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoVih` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoVih` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoVih` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoVih` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionVih` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosVih` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoAnemia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoAnemia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoAnemia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoAnemia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionAnemia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosAnemia` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoHerpes` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoHerpes` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoHerpes` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoHerpes` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionHerpes` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosHerpes` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoEnfermedadRenal` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoEnfermedadRenal` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoEnfermedadRenal` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoEnfermedadRenal` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionEnfermedadRenal` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosEnfermedadRenal` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoArtritis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoArtritis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoArtritis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoArtritis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionArtritis` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosArtritis` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoUlcerasOrales` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoUlcerasOrales` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoUlcerasOrales` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoUlcerasOrales` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionUlcerasOrales` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosUlcerasOrales` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoAsma` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoAsma` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoAsma` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoAsma` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionAsma` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosAsma` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoDiabetes` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoDiabetes` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoDiabetes` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoDiabetes` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionDiabetes` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosDiabetes` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoHemorragias` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoHemorragias` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoHemorragias` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoHemorragias` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionHemorragias` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosHemorragias` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoProblemasEndocrinos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoProblemasEndocrinos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoProblemasEndocrinos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoProblemasEndocrinos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionProblemasEndocrinos` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosProblemasEndocrinos` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoFiebreReumatica` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoFiebreReumatica` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoFiebreReumatica` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoFiebreReumatica` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionFiebreReumatica` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosFiebreReumatica` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoCancer` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoCancer` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoCancer` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoCancer` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionCancer` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosCancer` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoProblemasPsicologicos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoProblemasPsicologicos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoProblemasPsicologicos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoProblemasPsicologicos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionProblemasPsicologicos` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosProblemasPsicologicos` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoProblemasTiroideos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoProblemasTiroideos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoProblemasTiroideos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoProblemasTiroideos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionProblemasTiroideos` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosProblemasTiroideos` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoProblemasCardiacos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoProblemasCardiacos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoProblemasCardiacos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoProblemasCardiacos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionProblemasCardiacos` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosProblemasCardiacos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoEpilepsia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoEpilepsia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoEpilepsia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoEpilepsia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionEpilepsia` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosEpilepsia` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoTuberculosis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoTuberculosis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoTuberculosis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoTuberculosis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionTuberculosis` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosTuberculosis` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoOsteoporosis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoOsteoporosis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoOsteoporosis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoOsteoporosis` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionOsteoporosis` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosOsteoporosis` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoHipertension` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoHipertension` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoHipertension` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoHipertension` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionHipertension` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosHipertension` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaDiagnosticoProblemasPsiquiatricos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tratamientoProblemasPsiquiatricos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioTratamientoProblemasPsiquiatricos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaTratamientoProblemasPsiquiatricos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`medicacionProblemasPsiquiatricos` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosProblemasPsiquiatricos` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fractura` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaFractura` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`cadera` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tobillo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`femur` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`muneca` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`antebrazo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`vertebra` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`columna` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`otraFractura` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`otraFracturaComentarios` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`causaFractura` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`recuperacionPostFractura` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`incapacidadTotal` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`unidadIncapacidadTotal` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`otrosAntecedentesTraumatologicos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`menarquia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`menopausia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`histerectomia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`embarazos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`partos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`abortos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hijosVivos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`ciclos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`ur` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`infertilidad` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`lactancia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`totalLactancia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`edadDeLosHijos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`tabaquismo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fumadorPasivo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fumaDesde` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`frecuenciaTabaquismo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`licor` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`frecuenciaLicor` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`cerveza` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`vino` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`ron` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`whiskey` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`aguardiente` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`otrosLicores` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`cafe` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`frecuenciaCafe` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`otroCafe` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioCafe` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`lecheDerivados` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`frecuenciaLecheDerivados` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`otroLecheDerivado` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`inicioLecheDerivado` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`frutasFrescas` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`queClasesFrutasFrescas` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`porcionesFrutasFrescas` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`realizaEjercicio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`frecuenciaEjercicio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`pescados` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`pescadoRio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`clasePescadoRio` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`vecesPescadoRio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`desdePescadoRio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`frecuenciaPescadoRio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaPescadoRio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`pescadoMar` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`blanco` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`clasePescadoMarBlanco` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`vecesPescadoMarBlanco` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`desdePescadoMarBlanco` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`frecuenciaPescadoMarBlanco` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaPescadoMarblanco` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`azules` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`clasePescadoMarAzules` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`vecesPescadoMarAzules` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`desdePescadoMarAzules` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`frecuenciaPescadoMarAzules` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hastaPescadoMarAzules` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`antecedentesQuirurgicos` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`otrosTratamientosAntecedentesQuirurgicos` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`comentariosAntecedentesQuirurgicos` longtext COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`diabetesPadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`diabetesMadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`diabetesHijo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`diabetesTioP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`diabetesTioM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`diabetesHnos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`diabetesAbueloP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`diabetesAbueloM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`diabetesNinguno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`obesidadPadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`obesidadMadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`obesidadHijo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`obesidadTioP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`obesidadTioM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`obesidadHnos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`obesidadAbueloP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`obesidadAbueloM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`obesidadNinguno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`colesterolPadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`colesterolMadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`colesterolHijo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`colesterolTioP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`colesterolTioM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`colesterolHnos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`colesterolAbueloP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`colesterolAbueloM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`colesterolNinguno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`trigliceridosPadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`trigliceridosMadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`trigliceridosHijo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`trigliceridosTioP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`trigliceridosTioM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`trigliceridosHnos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`trigliceridosAbueloP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`trigliceridosAbueloM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`trigliceridosNinguno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`infartosPadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`infartosMadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`infartosHijo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`infartosTioP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`infartosTioM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`infartosHnos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`infartosAbueloP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`infartosAbueloM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`infartosNinguno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hipertensionPadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hipertensionMadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hipertensionHijo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hipertensionTioP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hipertensionTioM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hipertensionHnos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hipertensionAbueloP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hipertensionAbueloM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`hipertensionNinguno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`cancerPadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`cancerMadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`cancerHijo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`cancerTioP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`cancerTioM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`cancerHnos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`cancerAbueloP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`cancerAbueloM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`cancerNinguno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`osteoporosisPadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`osteoporosisMadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`osteoporosisHijo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`osteoporosisTioP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`osteoporosisTioM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`osteoporosisHnos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`osteoporosisAbueloP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`osteoporosisAbueloM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`osteoporosisNinguno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`otrosPadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`otrosMadre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`otrosHijo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`otrosTioP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`otrosTioM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`otrosHnos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`otrosAbueloP` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`otrosAbueloM` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`otrosNinguno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`fechaCreacionAn` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`horaCreacionAn` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, "
                    + "`idUsuario` int(11) DEFAULT NULL, "
                    + "PRIMARY KEY (`idAnamnesis`)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;";
            
            out.println(ejb.crear(anamnesis, "Anamnesis") + "<br>");
            
            //TABLA CIRUGIA PLASTICA
            String cirugiaPlastica = "CREATE TABLE IF NOT EXISTS `CirugiaPlastica` ( `idCirugiaPlastica` int(11) NOT NULL AUTO_INCREMENT, `idPaciente` int(11) DEFAULT NULL, `esteticaCabezaCuello`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `alopecia`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `caidaDeCabello`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `edadInicioDebilitamientoCapilar`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `edadInicioCaidaCapilar`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `estabilizada`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `antecedentesFamiliares`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `tratamientosPrevios`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `cortes`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `color`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `espesorCabello`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `estructura`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `poros`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `espesorCueroCabelludo`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `flexibilidadCueroCabelludo`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `cicatrices`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `pullTest`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `componentesPsiquicos`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `densidadZonaFrontal`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `densidadZonaOccipital`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `densidadZonaTemporal`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `densidadZonaParietal`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `perdidaZona`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `tipoAlopeciaNoCicatricial`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `otroTipoDeAlopeciaNoCicatricial`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `tipoAlopeciaCicatricial`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `otroTipoAlopeciaCicatricial`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `expectativasPaciente` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `propuestasTerapeuticas` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `gradoDeAlopeciaHombre`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `gradoDeAlopeciaMujer`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `facial`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `antropometriaFrente`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosAntropometriaFrente` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `antropometriaPerfil`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosAntropometriaPerfil` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `frente`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosFrente` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `zonaPeriorbitaria`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosZonaPeriorbitaria` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `regionMalar`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosRegionMalar` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `regionMandibular`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosRegionMandibular` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `auricular`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosAuricular` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `nasal`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosNasal` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `periBucal`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosPeriBucal` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `mentoniana`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosMentoniana` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `cervical`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosCervical` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `esteticaCorporal`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `regionToracicaAnterior`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `antecedentesMamarios`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosAntecedentesMamarios` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `mamografias`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosMamografias` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `autoexamen`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosAutoexamen` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `volumenMamarioDerecho`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `hipertrofiaVolumenMamarioDerecho`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `volumenMamarioIzquierdo`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `hipertrofiaVolumenMamarioIzquierdo`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `formaMamariaDerecha`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `formaMamariaIzquierda`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `ptosisMamaria`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `clasificacionPtosisRegnoult`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `tipoPielDerecha`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `tipoPielIzquierda`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `sensibilidadPezonDerecho`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `sensibilidadPezonIzquierdo`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `diametroComplejoAreola`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `diagramaPosicionDerecho`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `baseMamariaDerecho`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `medidaToraxDerecho`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `diagramaPosicionIzquierdo`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `baseMamariaIzquierdo`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `medidaToraxIzquierdo`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `diagnosticoMamario`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `otrosDiagnosticosMamarios`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `planTratamientoMamario`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `ginecomastia`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `clasificacionWiesman`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `antecedentesGinecomastia` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `tipoGinecomastia`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosTipoGinecomastia` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `pectorales` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `otrosDiagnosticosGinecomastia` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `planTratamientoGinecomastia` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `abdomen`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `clasificacionMatarasso`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosAbdomen` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `diagnosticoAbdomen` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `planTratamientoAbdomen` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `espalda`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosEspalda` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `diagnosticoEspalda` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `planTratamientoEspalda` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `gluteos`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `volumenGluteos` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `posicionGluteos` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `formaGluteos` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `caracteristicasPielGluteos` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `asimetria`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `secuelasTrauma`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosGluteos` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `extremidadesSuperiores`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `depositoGrasaMinimoModeradoMinimaLaxitud`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `depositoGrasaGeneralizadaModeradaLaxitud`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `obesidadGeneralizadaSeveraLaxitud`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `minimaGrasaSubcutaneaExtensaLaxitud`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosExtremidadesSuperiores` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `extremidadesInferiores`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosExtremidadesInferiores` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `diagnosticoExtremidadesInferiores` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `planTratamientoExtremidadesInferiores` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `reconstructivaCabezaCuello`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosReconstructivaCabezaCuello` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `diagnosticoReconstructivaCabezaCuello` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `planTratamientoReconstructivaCabezaCuello` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `reconstructivaCorporal`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosReconstructivaCorporal` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `diagnosticoReconstructivaCorporal` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `planTratamientoReconstructivaCorporal` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `fechaCreacionCp`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `horaCreacionCp\"`  varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `idUsuario` int(11) DEFAULT NULL,   PRIMARY KEY (`idCirugiaPlastica`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;";
            out.println(ejb.crear(cirugiaPlastica, "Cirugia plastica") + "<br>");
            //TABLA EXAMEN FISICO
            String examenFisico = "CREATE TABLE IF NOT EXISTS `ExamenFisico` ( `idExamenFisico` int(11) AUTO_INCREMENT, `idPaciente` int(11) DEFAULT NULL, `tensionArterial` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `peso` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `cintura` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `pulso` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `talla` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `cadera` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `frecuenciaRespiratoria` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `bmi` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `indiceCintCad` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `piel` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `pielComentarioEf` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `ojos` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `ojosComentarioEf` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `oidosNarizGarganta` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `oidosNarizGargantaComentarioEf` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `cuello` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `cuelloComentarioEf` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `torax` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `toraxComentarioEf` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `cardiovascular` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `cardiovascularComentarioEf` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `respiratorios` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `respiratoriosComentarioEf` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `abdomen` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `abdomenComentarioEf` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `genitourinario` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `genitourinarioComentarioEf` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `extremidades` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `extremidadesComentarioEf` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `sistemaNerviosoCentral` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `sistemaNerviosoCentralComentarioEf` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `adenopatias` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `adenopatiasComentarioEf` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `otros` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `otrosComentarioEf` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `comentariosEf` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `condicionEf` longtext COLLATE utf8_spanish_ci DEFAULT NULL, `fechaCreacionEf` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `horaCreacionEf` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `idUsuario` int(11) DEFAULT NULL,  PRIMARY KEY (`idExamenFisico`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;";
            out.println(ejb.crear(examenFisico, "Examen fisico") + "<br>");
            //TABLA GALERIA
            String galeria = "CREATE TABLE IF NOT EXISTS `Galeria` ( `idFoto` int(11) NOT NULL AUTO_INCREMENT, `idPaciente` int(11) DEFAULT NULL, `foto` longtext COLLATE utf8_spanish_ci, `fecha` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `hora` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL, `idUsuario` int(11) DEFAULT NULL, PRIMARY KEY (`idFoto`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;";
            out.println(ejb.crear(galeria, "Galeria") + "<br>");

        } catch (EJBException e) {
            System.out.println("Mensaje de error de crear tablas: " + e.getMessage());
        }
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
