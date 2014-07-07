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
@Table(name = "Anamnesis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anamnesis.findAll", query = "SELECT a FROM Anamnesis a"),
    @NamedQuery(name = "Anamnesis.findByIdPaciente", query = "SELECT a FROM Anamnesis a WHERE a.idPaciente = :idPaciente ORDER BY a.idAnamnesis DESC"),
    @NamedQuery(name = "Anamnesis.findByIdPacienteAndFecha", query = "SELECT a FROM Anamnesis a WHERE a.idPaciente = :idPaciente AND a.fechaCreacionAn = :fecha ORDER BY a.idAnamnesis DESC"),
    @NamedQuery(name = "Anamnesis.findByIdAnamnesis", query = "SELECT a FROM Anamnesis a WHERE a.idAnamnesis = :idAnamnesis"),
    @NamedQuery(name = "Anamnesis.findByMotivoConsulta", query = "SELECT a FROM Anamnesis a WHERE a.motivoConsulta = :motivoConsulta"),
    @NamedQuery(name = "Anamnesis.findByHistoriaEnfermedadActual", query = "SELECT a FROM Anamnesis a WHERE a.historiaEnfermedadActual = :historiaEnfermedadActual"),
    @NamedQuery(name = "Anamnesis.findByBajoMedicacion", query = "SELECT a FROM Anamnesis a WHERE a.bajoMedicacion = :bajoMedicacion"),
    @NamedQuery(name = "Anamnesis.findByAlergia", query = "SELECT a FROM Anamnesis a WHERE a.alergia = :alergia"),
    @NamedQuery(name = "Anamnesis.findByHepatitis", query = "SELECT a FROM Anamnesis a WHERE a.hepatitis = :hepatitis"),
    @NamedQuery(name = "Anamnesis.findByVih", query = "SELECT a FROM Anamnesis a WHERE a.vih = :vih"),
    @NamedQuery(name = "Anamnesis.findByAnemia", query = "SELECT a FROM Anamnesis a WHERE a.anemia = :anemia"),
    @NamedQuery(name = "Anamnesis.findByHerpes", query = "SELECT a FROM Anamnesis a WHERE a.herpes = :herpes"),
    @NamedQuery(name = "Anamnesis.findByEnfermedadRenal", query = "SELECT a FROM Anamnesis a WHERE a.enfermedadRenal = :enfermedadRenal"),
    @NamedQuery(name = "Anamnesis.findByArtritis", query = "SELECT a FROM Anamnesis a WHERE a.artritis = :artritis"),
    @NamedQuery(name = "Anamnesis.findByUlcerasOrales", query = "SELECT a FROM Anamnesis a WHERE a.ulcerasOrales = :ulcerasOrales"),
    @NamedQuery(name = "Anamnesis.findByAsma", query = "SELECT a FROM Anamnesis a WHERE a.asma = :asma"),
    @NamedQuery(name = "Anamnesis.findByDiabetes", query = "SELECT a FROM Anamnesis a WHERE a.diabetes = :diabetes"),
    @NamedQuery(name = "Anamnesis.findByHemorragias", query = "SELECT a FROM Anamnesis a WHERE a.hemorragias = :hemorragias"),
    @NamedQuery(name = "Anamnesis.findByProblemasEndocrinos", query = "SELECT a FROM Anamnesis a WHERE a.problemasEndocrinos = :problemasEndocrinos"),
    @NamedQuery(name = "Anamnesis.findByFiebreReumatica", query = "SELECT a FROM Anamnesis a WHERE a.fiebreReumatica = :fiebreReumatica"),
    @NamedQuery(name = "Anamnesis.findByCancer", query = "SELECT a FROM Anamnesis a WHERE a.cancer = :cancer"),
    @NamedQuery(name = "Anamnesis.findByProblemasPsicologicos", query = "SELECT a FROM Anamnesis a WHERE a.problemasPsicologicos = :problemasPsicologicos"),
    @NamedQuery(name = "Anamnesis.findByProblemasTiroideos", query = "SELECT a FROM Anamnesis a WHERE a.problemasTiroideos = :problemasTiroideos"),
    @NamedQuery(name = "Anamnesis.findByProblemasCardiacos", query = "SELECT a FROM Anamnesis a WHERE a.problemasCardiacos = :problemasCardiacos"),
    @NamedQuery(name = "Anamnesis.findByEpilepsia", query = "SELECT a FROM Anamnesis a WHERE a.epilepsia = :epilepsia"),
    @NamedQuery(name = "Anamnesis.findByTuberculosis", query = "SELECT a FROM Anamnesis a WHERE a.tuberculosis = :tuberculosis"),
    @NamedQuery(name = "Anamnesis.findByOsteoporosis", query = "SELECT a FROM Anamnesis a WHERE a.osteoporosis = :osteoporosis"),
    @NamedQuery(name = "Anamnesis.findByHipertension", query = "SELECT a FROM Anamnesis a WHERE a.hipertension = :hipertension"),
    @NamedQuery(name = "Anamnesis.findByProblemasPsiquiatricos", query = "SELECT a FROM Anamnesis a WHERE a.problemasPsiquiatricos = :problemasPsiquiatricos"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoAlergia", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoAlergia = :fechaDiagnosticoAlergia"),
    @NamedQuery(name = "Anamnesis.findByTratamientoAlergia", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoAlergia = :tratamientoAlergia"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoAlergia", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoAlergia = :inicioTratamientoAlergia"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoAlergia", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoAlergia = :hastaTratamientoAlergia"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoHepatitis", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoHepatitis = :fechaDiagnosticoHepatitis"),
    @NamedQuery(name = "Anamnesis.findByTratamientoHepatitis", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoHepatitis = :tratamientoHepatitis"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoHepatitis", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoHepatitis = :inicioTratamientoHepatitis"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoHepatitis", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoHepatitis = :hastaTratamientoHepatitis"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoVih", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoVih = :fechaDiagnosticoVih"),
    @NamedQuery(name = "Anamnesis.findByTratamientoVih", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoVih = :tratamientoVih"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoVih", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoVih = :inicioTratamientoVih"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoVih", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoVih = :hastaTratamientoVih"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoAnemia", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoAnemia = :fechaDiagnosticoAnemia"),
    @NamedQuery(name = "Anamnesis.findByTratamientoAnemia", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoAnemia = :tratamientoAnemia"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoAnemia", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoAnemia = :inicioTratamientoAnemia"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoAnemia", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoAnemia = :hastaTratamientoAnemia"),
    @NamedQuery(name = "Anamnesis.findByMedicacionAnemia", query = "SELECT a FROM Anamnesis a WHERE a.medicacionAnemia = :medicacionAnemia"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoHerpes", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoHerpes = :fechaDiagnosticoHerpes"),
    @NamedQuery(name = "Anamnesis.findByTratamientoHerpes", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoHerpes = :tratamientoHerpes"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoHerpes", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoHerpes = :inicioTratamientoHerpes"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoHerpes", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoHerpes = :hastaTratamientoHerpes"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoEnfermedadRenal", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoEnfermedadRenal = :fechaDiagnosticoEnfermedadRenal"),
    @NamedQuery(name = "Anamnesis.findByTratamientoEnfermedadRenal", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoEnfermedadRenal = :tratamientoEnfermedadRenal"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoEnfermedadRenal", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoEnfermedadRenal = :inicioTratamientoEnfermedadRenal"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoEnfermedadRenal", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoEnfermedadRenal = :hastaTratamientoEnfermedadRenal"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoArtritis", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoArtritis = :fechaDiagnosticoArtritis"),
    @NamedQuery(name = "Anamnesis.findByTratamientoArtritis", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoArtritis = :tratamientoArtritis"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoArtritis", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoArtritis = :inicioTratamientoArtritis"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoArtritis", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoArtritis = :hastaTratamientoArtritis"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoUlcerasOrales", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoUlcerasOrales = :fechaDiagnosticoUlcerasOrales"),
    @NamedQuery(name = "Anamnesis.findByTratamientoUlcerasOrales", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoUlcerasOrales = :tratamientoUlcerasOrales"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoUlcerasOrales", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoUlcerasOrales = :inicioTratamientoUlcerasOrales"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoUlcerasOrales", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoUlcerasOrales = :hastaTratamientoUlcerasOrales"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoAsma", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoAsma = :fechaDiagnosticoAsma"),
    @NamedQuery(name = "Anamnesis.findByTratamientoAsma", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoAsma = :tratamientoAsma"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoAsma", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoAsma = :inicioTratamientoAsma"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoAsma", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoAsma = :hastaTratamientoAsma"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoDiabetes", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoDiabetes = :fechaDiagnosticoDiabetes"),
    @NamedQuery(name = "Anamnesis.findByTratamientoDiabetes", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoDiabetes = :tratamientoDiabetes"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoDiabetes", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoDiabetes = :inicioTratamientoDiabetes"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoDiabetes", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoDiabetes = :hastaTratamientoDiabetes"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoHemorragias", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoHemorragias = :fechaDiagnosticoHemorragias"),
    @NamedQuery(name = "Anamnesis.findByTratamientoHemorragias", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoHemorragias = :tratamientoHemorragias"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoHemorragias", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoHemorragias = :inicioTratamientoHemorragias"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoHemorragias", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoHemorragias = :hastaTratamientoHemorragias"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoProblemasEndocrinos", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoProblemasEndocrinos = :fechaDiagnosticoProblemasEndocrinos"),
    @NamedQuery(name = "Anamnesis.findByTratamientoProblemasEndocrinos", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoProblemasEndocrinos = :tratamientoProblemasEndocrinos"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoProblemasEndocrinos", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoProblemasEndocrinos = :inicioTratamientoProblemasEndocrinos"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoProblemasEndocrinos", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoProblemasEndocrinos = :hastaTratamientoProblemasEndocrinos"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoFiebreReumatica", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoFiebreReumatica = :fechaDiagnosticoFiebreReumatica"),
    @NamedQuery(name = "Anamnesis.findByTratamientoFiebreReumatica", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoFiebreReumatica = :tratamientoFiebreReumatica"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoFiebreReumatica", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoFiebreReumatica = :inicioTratamientoFiebreReumatica"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoFiebreReumatica", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoFiebreReumatica = :hastaTratamientoFiebreReumatica"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoCancer", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoCancer = :fechaDiagnosticoCancer"),
    @NamedQuery(name = "Anamnesis.findByTratamientoCancer", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoCancer = :tratamientoCancer"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoCancer", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoCancer = :inicioTratamientoCancer"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoCancer", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoCancer = :hastaTratamientoCancer"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoProblemasPsicologicos", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoProblemasPsicologicos = :fechaDiagnosticoProblemasPsicologicos"),
    @NamedQuery(name = "Anamnesis.findByTratamientoProblemasPsicologicos", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoProblemasPsicologicos = :tratamientoProblemasPsicologicos"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoProblemasPsicologicos", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoProblemasPsicologicos = :inicioTratamientoProblemasPsicologicos"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoProblemasPsicologicos", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoProblemasPsicologicos = :hastaTratamientoProblemasPsicologicos"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoProblemasTiroideos", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoProblemasTiroideos = :fechaDiagnosticoProblemasTiroideos"),
    @NamedQuery(name = "Anamnesis.findByTratamientoProblemasTiroideos", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoProblemasTiroideos = :tratamientoProblemasTiroideos"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoProblemasTiroideos", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoProblemasTiroideos = :inicioTratamientoProblemasTiroideos"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoProblemasTiroideos", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoProblemasTiroideos = :hastaTratamientoProblemasTiroideos"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoProblemasCardiacos", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoProblemasCardiacos = :fechaDiagnosticoProblemasCardiacos"),
    @NamedQuery(name = "Anamnesis.findByTratamientoProblemasCardiacos", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoProblemasCardiacos = :tratamientoProblemasCardiacos"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoProblemasCardiacos", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoProblemasCardiacos = :inicioTratamientoProblemasCardiacos"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoProblemasCardiacos", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoProblemasCardiacos = :hastaTratamientoProblemasCardiacos"),
    @NamedQuery(name = "Anamnesis.findByComentariosProblemasCardiacos", query = "SELECT a FROM Anamnesis a WHERE a.comentariosProblemasCardiacos = :comentariosProblemasCardiacos"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoEpilepsia", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoEpilepsia = :fechaDiagnosticoEpilepsia"),
    @NamedQuery(name = "Anamnesis.findByTratamientoEpilepsia", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoEpilepsia = :tratamientoEpilepsia"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoEpilepsia", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoEpilepsia = :inicioTratamientoEpilepsia"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoEpilepsia", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoEpilepsia = :hastaTratamientoEpilepsia"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoTuberculosis", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoTuberculosis = :fechaDiagnosticoTuberculosis"),
    @NamedQuery(name = "Anamnesis.findByTratamientoTuberculosis", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoTuberculosis = :tratamientoTuberculosis"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoTuberculosis", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoTuberculosis = :inicioTratamientoTuberculosis"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoTuberculosis", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoTuberculosis = :hastaTratamientoTuberculosis"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoOsteoporosis", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoOsteoporosis = :fechaDiagnosticoOsteoporosis"),
    @NamedQuery(name = "Anamnesis.findByTratamientoOsteoporosis", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoOsteoporosis = :tratamientoOsteoporosis"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoOsteoporosis", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoOsteoporosis = :inicioTratamientoOsteoporosis"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoOsteoporosis", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoOsteoporosis = :hastaTratamientoOsteoporosis"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoHipertension", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoHipertension = :fechaDiagnosticoHipertension"),
    @NamedQuery(name = "Anamnesis.findByTratamientoHipertension", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoHipertension = :tratamientoHipertension"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoHipertension", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoHipertension = :inicioTratamientoHipertension"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoHipertension", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoHipertension = :hastaTratamientoHipertension"),
    @NamedQuery(name = "Anamnesis.findByFechaDiagnosticoProblemasPsiquiatricos", query = "SELECT a FROM Anamnesis a WHERE a.fechaDiagnosticoProblemasPsiquiatricos = :fechaDiagnosticoProblemasPsiquiatricos"),
    @NamedQuery(name = "Anamnesis.findByTratamientoProblemasPsiquiatricos", query = "SELECT a FROM Anamnesis a WHERE a.tratamientoProblemasPsiquiatricos = :tratamientoProblemasPsiquiatricos"),
    @NamedQuery(name = "Anamnesis.findByInicioTratamientoProblemasPsiquiatricos", query = "SELECT a FROM Anamnesis a WHERE a.inicioTratamientoProblemasPsiquiatricos = :inicioTratamientoProblemasPsiquiatricos"),
    @NamedQuery(name = "Anamnesis.findByHastaTratamientoProblemasPsiquiatricos", query = "SELECT a FROM Anamnesis a WHERE a.hastaTratamientoProblemasPsiquiatricos = :hastaTratamientoProblemasPsiquiatricos"),
    @NamedQuery(name = "Anamnesis.findByFractura", query = "SELECT a FROM Anamnesis a WHERE a.fractura = :fractura"),
    @NamedQuery(name = "Anamnesis.findByFechaFractura", query = "SELECT a FROM Anamnesis a WHERE a.fechaFractura = :fechaFractura"),
    @NamedQuery(name = "Anamnesis.findByCadera", query = "SELECT a FROM Anamnesis a WHERE a.cadera = :cadera"),
    @NamedQuery(name = "Anamnesis.findByTobillo", query = "SELECT a FROM Anamnesis a WHERE a.tobillo = :tobillo"),
    @NamedQuery(name = "Anamnesis.findByFemur", query = "SELECT a FROM Anamnesis a WHERE a.femur = :femur"),
    @NamedQuery(name = "Anamnesis.findByMuneca", query = "SELECT a FROM Anamnesis a WHERE a.muneca = :muneca"),
    @NamedQuery(name = "Anamnesis.findByAntebrazo", query = "SELECT a FROM Anamnesis a WHERE a.antebrazo = :antebrazo"),
    @NamedQuery(name = "Anamnesis.findByVertebra", query = "SELECT a FROM Anamnesis a WHERE a.vertebra = :vertebra"),
    @NamedQuery(name = "Anamnesis.findByColumna", query = "SELECT a FROM Anamnesis a WHERE a.columna = :columna"),
    @NamedQuery(name = "Anamnesis.findByOtraFractura", query = "SELECT a FROM Anamnesis a WHERE a.otraFractura = :otraFractura"),
    @NamedQuery(name = "Anamnesis.findByCausaFractura", query = "SELECT a FROM Anamnesis a WHERE a.causaFractura = :causaFractura"),
    @NamedQuery(name = "Anamnesis.findByRecuperacionPostFractura", query = "SELECT a FROM Anamnesis a WHERE a.recuperacionPostFractura = :recuperacionPostFractura"),
    @NamedQuery(name = "Anamnesis.findByIncapacidadTotal", query = "SELECT a FROM Anamnesis a WHERE a.incapacidadTotal = :incapacidadTotal"),
    @NamedQuery(name = "Anamnesis.findByUnidadIncapacidadTotal", query = "SELECT a FROM Anamnesis a WHERE a.unidadIncapacidadTotal = :unidadIncapacidadTotal"),
    @NamedQuery(name = "Anamnesis.findByOtrosAntecedentesTraumatologicos", query = "SELECT a FROM Anamnesis a WHERE a.otrosAntecedentesTraumatologicos = :otrosAntecedentesTraumatologicos"),
    @NamedQuery(name = "Anamnesis.findByMenarquia", query = "SELECT a FROM Anamnesis a WHERE a.menarquia = :menarquia"),
    @NamedQuery(name = "Anamnesis.findByMenopausia", query = "SELECT a FROM Anamnesis a WHERE a.menopausia = :menopausia"),
    @NamedQuery(name = "Anamnesis.findByHisterectomia", query = "SELECT a FROM Anamnesis a WHERE a.histerectomia = :histerectomia"),
    @NamedQuery(name = "Anamnesis.findByEmbarazos", query = "SELECT a FROM Anamnesis a WHERE a.embarazos = :embarazos"),
    @NamedQuery(name = "Anamnesis.findByPartos", query = "SELECT a FROM Anamnesis a WHERE a.partos = :partos"),
    @NamedQuery(name = "Anamnesis.findByAbortos", query = "SELECT a FROM Anamnesis a WHERE a.abortos = :abortos"),
    @NamedQuery(name = "Anamnesis.findByHijosVivos", query = "SELECT a FROM Anamnesis a WHERE a.hijosVivos = :hijosVivos"),
    @NamedQuery(name = "Anamnesis.findByCiclos", query = "SELECT a FROM Anamnesis a WHERE a.ciclos = :ciclos"),
    @NamedQuery(name = "Anamnesis.findByUr", query = "SELECT a FROM Anamnesis a WHERE a.ur = :ur"),
    @NamedQuery(name = "Anamnesis.findByInfertilidad", query = "SELECT a FROM Anamnesis a WHERE a.infertilidad = :infertilidad"),
    @NamedQuery(name = "Anamnesis.findByLactancia", query = "SELECT a FROM Anamnesis a WHERE a.lactancia = :lactancia"),
    @NamedQuery(name = "Anamnesis.findByTotalLactancia", query = "SELECT a FROM Anamnesis a WHERE a.totalLactancia = :totalLactancia"),
    @NamedQuery(name = "Anamnesis.findByEdadDeLosHijos", query = "SELECT a FROM Anamnesis a WHERE a.edadDeLosHijos = :edadDeLosHijos"),
    @NamedQuery(name = "Anamnesis.findByTabaquismo", query = "SELECT a FROM Anamnesis a WHERE a.tabaquismo = :tabaquismo"),
    @NamedQuery(name = "Anamnesis.findByFumadorPasivo", query = "SELECT a FROM Anamnesis a WHERE a.fumadorPasivo = :fumadorPasivo"),
    @NamedQuery(name = "Anamnesis.findByFumaDesde", query = "SELECT a FROM Anamnesis a WHERE a.fumaDesde = :fumaDesde"),
    @NamedQuery(name = "Anamnesis.findByFrecuenciaTabaquismo", query = "SELECT a FROM Anamnesis a WHERE a.frecuenciaTabaquismo = :frecuenciaTabaquismo"),
    @NamedQuery(name = "Anamnesis.findByLicor", query = "SELECT a FROM Anamnesis a WHERE a.licor = :licor"),
    @NamedQuery(name = "Anamnesis.findByFrecuenciaLicor", query = "SELECT a FROM Anamnesis a WHERE a.frecuenciaLicor = :frecuenciaLicor"),
    @NamedQuery(name = "Anamnesis.findByCerveza", query = "SELECT a FROM Anamnesis a WHERE a.cerveza = :cerveza"),
    @NamedQuery(name = "Anamnesis.findByVino", query = "SELECT a FROM Anamnesis a WHERE a.vino = :vino"),
    @NamedQuery(name = "Anamnesis.findByRon", query = "SELECT a FROM Anamnesis a WHERE a.ron = :ron"),
    @NamedQuery(name = "Anamnesis.findByWhiskey", query = "SELECT a FROM Anamnesis a WHERE a.whiskey = :whiskey"),
    @NamedQuery(name = "Anamnesis.findByAguardiente", query = "SELECT a FROM Anamnesis a WHERE a.aguardiente = :aguardiente"),
    @NamedQuery(name = "Anamnesis.findByOtrosLicores", query = "SELECT a FROM Anamnesis a WHERE a.otrosLicores = :otrosLicores"),
    @NamedQuery(name = "Anamnesis.findByCafe", query = "SELECT a FROM Anamnesis a WHERE a.cafe = :cafe"),
    @NamedQuery(name = "Anamnesis.findByFrecuenciaCafe", query = "SELECT a FROM Anamnesis a WHERE a.frecuenciaCafe = :frecuenciaCafe"),
    @NamedQuery(name = "Anamnesis.findByOtroCafe", query = "SELECT a FROM Anamnesis a WHERE a.otroCafe = :otroCafe"),
    @NamedQuery(name = "Anamnesis.findByInicioCafe", query = "SELECT a FROM Anamnesis a WHERE a.inicioCafe = :inicioCafe"),
    @NamedQuery(name = "Anamnesis.findByLecheDerivados", query = "SELECT a FROM Anamnesis a WHERE a.lecheDerivados = :lecheDerivados"),
    @NamedQuery(name = "Anamnesis.findByFrecuenciaLecheDerivados", query = "SELECT a FROM Anamnesis a WHERE a.frecuenciaLecheDerivados = :frecuenciaLecheDerivados"),
    @NamedQuery(name = "Anamnesis.findByOtroLecheDerivado", query = "SELECT a FROM Anamnesis a WHERE a.otroLecheDerivado = :otroLecheDerivado"),
    @NamedQuery(name = "Anamnesis.findByInicioLecheDerivado", query = "SELECT a FROM Anamnesis a WHERE a.inicioLecheDerivado = :inicioLecheDerivado"),
    @NamedQuery(name = "Anamnesis.findByFrutasFrescas", query = "SELECT a FROM Anamnesis a WHERE a.frutasFrescas = :frutasFrescas"),
    @NamedQuery(name = "Anamnesis.findByPorcionesFrutasFrescas", query = "SELECT a FROM Anamnesis a WHERE a.porcionesFrutasFrescas = :porcionesFrutasFrescas"),
    @NamedQuery(name = "Anamnesis.findByRealizaEjercicio", query = "SELECT a FROM Anamnesis a WHERE a.realizaEjercicio = :realizaEjercicio"),
    @NamedQuery(name = "Anamnesis.findByFrecuenciaEjercicio", query = "SELECT a FROM Anamnesis a WHERE a.frecuenciaEjercicio = :frecuenciaEjercicio"),
    @NamedQuery(name = "Anamnesis.findByPescados", query = "SELECT a FROM Anamnesis a WHERE a.pescados = :pescados"),
    @NamedQuery(name = "Anamnesis.findByPescadoRio", query = "SELECT a FROM Anamnesis a WHERE a.pescadoRio = :pescadoRio"),
    @NamedQuery(name = "Anamnesis.findByVecesPescadoRio", query = "SELECT a FROM Anamnesis a WHERE a.vecesPescadoRio = :vecesPescadoRio"),
    @NamedQuery(name = "Anamnesis.findByDesdePescadoRio", query = "SELECT a FROM Anamnesis a WHERE a.desdePescadoRio = :desdePescadoRio"),
    @NamedQuery(name = "Anamnesis.findByFrecuenciaPescadoRio", query = "SELECT a FROM Anamnesis a WHERE a.frecuenciaPescadoRio = :frecuenciaPescadoRio"),
    @NamedQuery(name = "Anamnesis.findByHastaPescadoRio", query = "SELECT a FROM Anamnesis a WHERE a.hastaPescadoRio = :hastaPescadoRio"),
    @NamedQuery(name = "Anamnesis.findByPescadoMar", query = "SELECT a FROM Anamnesis a WHERE a.pescadoMar = :pescadoMar"),
    @NamedQuery(name = "Anamnesis.findByBlanco", query = "SELECT a FROM Anamnesis a WHERE a.blanco = :blanco"),
    @NamedQuery(name = "Anamnesis.findByVecesPescadoMarBlanco", query = "SELECT a FROM Anamnesis a WHERE a.vecesPescadoMarBlanco = :vecesPescadoMarBlanco"),
    @NamedQuery(name = "Anamnesis.findByDesdePescadoMarBlanco", query = "SELECT a FROM Anamnesis a WHERE a.desdePescadoMarBlanco = :desdePescadoMarBlanco"),
    @NamedQuery(name = "Anamnesis.findByFrecuenciaPescadoMarBlanco", query = "SELECT a FROM Anamnesis a WHERE a.frecuenciaPescadoMarBlanco = :frecuenciaPescadoMarBlanco"),
    @NamedQuery(name = "Anamnesis.findByHastaPescadoMarblanco", query = "SELECT a FROM Anamnesis a WHERE a.hastaPescadoMarblanco = :hastaPescadoMarblanco"),
    @NamedQuery(name = "Anamnesis.findByAzules", query = "SELECT a FROM Anamnesis a WHERE a.azules = :azules"),
    @NamedQuery(name = "Anamnesis.findByVecesPescadoMarAzules", query = "SELECT a FROM Anamnesis a WHERE a.vecesPescadoMarAzules = :vecesPescadoMarAzules"),
    @NamedQuery(name = "Anamnesis.findByDesdePescadoMarAzules", query = "SELECT a FROM Anamnesis a WHERE a.desdePescadoMarAzules = :desdePescadoMarAzules"),
    @NamedQuery(name = "Anamnesis.findByFrecuenciaPescadoMarAzules", query = "SELECT a FROM Anamnesis a WHERE a.frecuenciaPescadoMarAzules = :frecuenciaPescadoMarAzules"),
    @NamedQuery(name = "Anamnesis.findByHastaPescadoMarAzules", query = "SELECT a FROM Anamnesis a WHERE a.hastaPescadoMarAzules = :hastaPescadoMarAzules"),
    @NamedQuery(name = "Anamnesis.findByDiabetesPadre", query = "SELECT a FROM Anamnesis a WHERE a.diabetesPadre = :diabetesPadre"),
    @NamedQuery(name = "Anamnesis.findByDiabetesMadre", query = "SELECT a FROM Anamnesis a WHERE a.diabetesMadre = :diabetesMadre"),
    @NamedQuery(name = "Anamnesis.findByDiabetesHijo", query = "SELECT a FROM Anamnesis a WHERE a.diabetesHijo = :diabetesHijo"),
    @NamedQuery(name = "Anamnesis.findByDiabetesTioP", query = "SELECT a FROM Anamnesis a WHERE a.diabetesTioP = :diabetesTioP"),
    @NamedQuery(name = "Anamnesis.findByDiabetesTioM", query = "SELECT a FROM Anamnesis a WHERE a.diabetesTioM = :diabetesTioM"),
    @NamedQuery(name = "Anamnesis.findByDiabetesHnos", query = "SELECT a FROM Anamnesis a WHERE a.diabetesHnos = :diabetesHnos"),
    @NamedQuery(name = "Anamnesis.findByDiabetesAbueloP", query = "SELECT a FROM Anamnesis a WHERE a.diabetesAbueloP = :diabetesAbueloP"),
    @NamedQuery(name = "Anamnesis.findByDiabetesAbueloM", query = "SELECT a FROM Anamnesis a WHERE a.diabetesAbueloM = :diabetesAbueloM"),
    @NamedQuery(name = "Anamnesis.findByDiabetesNinguno", query = "SELECT a FROM Anamnesis a WHERE a.diabetesNinguno = :diabetesNinguno"),
    @NamedQuery(name = "Anamnesis.findByObesidadPadre", query = "SELECT a FROM Anamnesis a WHERE a.obesidadPadre = :obesidadPadre"),
    @NamedQuery(name = "Anamnesis.findByObesidadMadre", query = "SELECT a FROM Anamnesis a WHERE a.obesidadMadre = :obesidadMadre"),
    @NamedQuery(name = "Anamnesis.findByObesidadHijo", query = "SELECT a FROM Anamnesis a WHERE a.obesidadHijo = :obesidadHijo"),
    @NamedQuery(name = "Anamnesis.findByObesidadTioP", query = "SELECT a FROM Anamnesis a WHERE a.obesidadTioP = :obesidadTioP"),
    @NamedQuery(name = "Anamnesis.findByObesidadTioM", query = "SELECT a FROM Anamnesis a WHERE a.obesidadTioM = :obesidadTioM"),
    @NamedQuery(name = "Anamnesis.findByObesidadHnos", query = "SELECT a FROM Anamnesis a WHERE a.obesidadHnos = :obesidadHnos"),
    @NamedQuery(name = "Anamnesis.findByObesidadAbueloP", query = "SELECT a FROM Anamnesis a WHERE a.obesidadAbueloP = :obesidadAbueloP"),
    @NamedQuery(name = "Anamnesis.findByObesidadAbueloM", query = "SELECT a FROM Anamnesis a WHERE a.obesidadAbueloM = :obesidadAbueloM"),
    @NamedQuery(name = "Anamnesis.findByObesidadNinguno", query = "SELECT a FROM Anamnesis a WHERE a.obesidadNinguno = :obesidadNinguno"),
    @NamedQuery(name = "Anamnesis.findByColesterolPadre", query = "SELECT a FROM Anamnesis a WHERE a.colesterolPadre = :colesterolPadre"),
    @NamedQuery(name = "Anamnesis.findByColesterolMadre", query = "SELECT a FROM Anamnesis a WHERE a.colesterolMadre = :colesterolMadre"),
    @NamedQuery(name = "Anamnesis.findByColesterolHijo", query = "SELECT a FROM Anamnesis a WHERE a.colesterolHijo = :colesterolHijo"),
    @NamedQuery(name = "Anamnesis.findByColesterolTioP", query = "SELECT a FROM Anamnesis a WHERE a.colesterolTioP = :colesterolTioP"),
    @NamedQuery(name = "Anamnesis.findByColesterolTioM", query = "SELECT a FROM Anamnesis a WHERE a.colesterolTioM = :colesterolTioM"),
    @NamedQuery(name = "Anamnesis.findByColesterolHnos", query = "SELECT a FROM Anamnesis a WHERE a.colesterolHnos = :colesterolHnos"),
    @NamedQuery(name = "Anamnesis.findByColesterolAbueloP", query = "SELECT a FROM Anamnesis a WHERE a.colesterolAbueloP = :colesterolAbueloP"),
    @NamedQuery(name = "Anamnesis.findByColesterolAbueloM", query = "SELECT a FROM Anamnesis a WHERE a.colesterolAbueloM = :colesterolAbueloM"),
    @NamedQuery(name = "Anamnesis.findByColesterolNinguno", query = "SELECT a FROM Anamnesis a WHERE a.colesterolNinguno = :colesterolNinguno"),
    @NamedQuery(name = "Anamnesis.findByTrigliceridosPadre", query = "SELECT a FROM Anamnesis a WHERE a.trigliceridosPadre = :trigliceridosPadre"),
    @NamedQuery(name = "Anamnesis.findByTrigliceridosMadre", query = "SELECT a FROM Anamnesis a WHERE a.trigliceridosMadre = :trigliceridosMadre"),
    @NamedQuery(name = "Anamnesis.findByTrigliceridosHijo", query = "SELECT a FROM Anamnesis a WHERE a.trigliceridosHijo = :trigliceridosHijo"),
    @NamedQuery(name = "Anamnesis.findByTrigliceridosTioP", query = "SELECT a FROM Anamnesis a WHERE a.trigliceridosTioP = :trigliceridosTioP"),
    @NamedQuery(name = "Anamnesis.findByTrigliceridosTioM", query = "SELECT a FROM Anamnesis a WHERE a.trigliceridosTioM = :trigliceridosTioM"),
    @NamedQuery(name = "Anamnesis.findByTrigliceridosHnos", query = "SELECT a FROM Anamnesis a WHERE a.trigliceridosHnos = :trigliceridosHnos"),
    @NamedQuery(name = "Anamnesis.findByTrigliceridosAbueloP", query = "SELECT a FROM Anamnesis a WHERE a.trigliceridosAbueloP = :trigliceridosAbueloP"),
    @NamedQuery(name = "Anamnesis.findByTrigliceridosAbueloM", query = "SELECT a FROM Anamnesis a WHERE a.trigliceridosAbueloM = :trigliceridosAbueloM"),
    @NamedQuery(name = "Anamnesis.findByTrigliceridosNinguno", query = "SELECT a FROM Anamnesis a WHERE a.trigliceridosNinguno = :trigliceridosNinguno"),
    @NamedQuery(name = "Anamnesis.findByInfartosPadre", query = "SELECT a FROM Anamnesis a WHERE a.infartosPadre = :infartosPadre"),
    @NamedQuery(name = "Anamnesis.findByInfartosMadre", query = "SELECT a FROM Anamnesis a WHERE a.infartosMadre = :infartosMadre"),
    @NamedQuery(name = "Anamnesis.findByInfartosHijo", query = "SELECT a FROM Anamnesis a WHERE a.infartosHijo = :infartosHijo"),
    @NamedQuery(name = "Anamnesis.findByInfartosTioP", query = "SELECT a FROM Anamnesis a WHERE a.infartosTioP = :infartosTioP"),
    @NamedQuery(name = "Anamnesis.findByInfartosTioM", query = "SELECT a FROM Anamnesis a WHERE a.infartosTioM = :infartosTioM"),
    @NamedQuery(name = "Anamnesis.findByInfartosHnos", query = "SELECT a FROM Anamnesis a WHERE a.infartosHnos = :infartosHnos"),
    @NamedQuery(name = "Anamnesis.findByInfartosAbueloP", query = "SELECT a FROM Anamnesis a WHERE a.infartosAbueloP = :infartosAbueloP"),
    @NamedQuery(name = "Anamnesis.findByInfartosAbueloM", query = "SELECT a FROM Anamnesis a WHERE a.infartosAbueloM = :infartosAbueloM"),
    @NamedQuery(name = "Anamnesis.findByInfartosNinguno", query = "SELECT a FROM Anamnesis a WHERE a.infartosNinguno = :infartosNinguno"),
    @NamedQuery(name = "Anamnesis.findByHipertensionPadre", query = "SELECT a FROM Anamnesis a WHERE a.hipertensionPadre = :hipertensionPadre"),
    @NamedQuery(name = "Anamnesis.findByHipertensionMadre", query = "SELECT a FROM Anamnesis a WHERE a.hipertensionMadre = :hipertensionMadre"),
    @NamedQuery(name = "Anamnesis.findByHipertensionHijo", query = "SELECT a FROM Anamnesis a WHERE a.hipertensionHijo = :hipertensionHijo"),
    @NamedQuery(name = "Anamnesis.findByHipertensionTioP", query = "SELECT a FROM Anamnesis a WHERE a.hipertensionTioP = :hipertensionTioP"),
    @NamedQuery(name = "Anamnesis.findByHipertensionTioM", query = "SELECT a FROM Anamnesis a WHERE a.hipertensionTioM = :hipertensionTioM"),
    @NamedQuery(name = "Anamnesis.findByHipertensionHnos", query = "SELECT a FROM Anamnesis a WHERE a.hipertensionHnos = :hipertensionHnos"),
    @NamedQuery(name = "Anamnesis.findByHipertensionAbueloP", query = "SELECT a FROM Anamnesis a WHERE a.hipertensionAbueloP = :hipertensionAbueloP"),
    @NamedQuery(name = "Anamnesis.findByHipertensionAbueloM", query = "SELECT a FROM Anamnesis a WHERE a.hipertensionAbueloM = :hipertensionAbueloM"),
    @NamedQuery(name = "Anamnesis.findByHipertensionNinguno", query = "SELECT a FROM Anamnesis a WHERE a.hipertensionNinguno = :hipertensionNinguno"),
    @NamedQuery(name = "Anamnesis.findByCancerPadre", query = "SELECT a FROM Anamnesis a WHERE a.cancerPadre = :cancerPadre"),
    @NamedQuery(name = "Anamnesis.findByCancerMadre", query = "SELECT a FROM Anamnesis a WHERE a.cancerMadre = :cancerMadre"),
    @NamedQuery(name = "Anamnesis.findByCancerHijo", query = "SELECT a FROM Anamnesis a WHERE a.cancerHijo = :cancerHijo"),
    @NamedQuery(name = "Anamnesis.findByCancerTioP", query = "SELECT a FROM Anamnesis a WHERE a.cancerTioP = :cancerTioP"),
    @NamedQuery(name = "Anamnesis.findByCancerTioM", query = "SELECT a FROM Anamnesis a WHERE a.cancerTioM = :cancerTioM"),
    @NamedQuery(name = "Anamnesis.findByCancerHnos", query = "SELECT a FROM Anamnesis a WHERE a.cancerHnos = :cancerHnos"),
    @NamedQuery(name = "Anamnesis.findByCancerAbueloP", query = "SELECT a FROM Anamnesis a WHERE a.cancerAbueloP = :cancerAbueloP"),
    @NamedQuery(name = "Anamnesis.findByCancerAbueloM", query = "SELECT a FROM Anamnesis a WHERE a.cancerAbueloM = :cancerAbueloM"),
    @NamedQuery(name = "Anamnesis.findByCancerNinguno", query = "SELECT a FROM Anamnesis a WHERE a.cancerNinguno = :cancerNinguno"),
    @NamedQuery(name = "Anamnesis.findByOsteoporosisPadre", query = "SELECT a FROM Anamnesis a WHERE a.osteoporosisPadre = :osteoporosisPadre"),
    @NamedQuery(name = "Anamnesis.findByOsteoporosisMadre", query = "SELECT a FROM Anamnesis a WHERE a.osteoporosisMadre = :osteoporosisMadre"),
    @NamedQuery(name = "Anamnesis.findByOsteoporosisHijo", query = "SELECT a FROM Anamnesis a WHERE a.osteoporosisHijo = :osteoporosisHijo"),
    @NamedQuery(name = "Anamnesis.findByOsteoporosisTioP", query = "SELECT a FROM Anamnesis a WHERE a.osteoporosisTioP = :osteoporosisTioP"),
    @NamedQuery(name = "Anamnesis.findByOsteoporosisTioM", query = "SELECT a FROM Anamnesis a WHERE a.osteoporosisTioM = :osteoporosisTioM"),
    @NamedQuery(name = "Anamnesis.findByOsteoporosisHnos", query = "SELECT a FROM Anamnesis a WHERE a.osteoporosisHnos = :osteoporosisHnos"),
    @NamedQuery(name = "Anamnesis.findByOsteoporosisAbueloP", query = "SELECT a FROM Anamnesis a WHERE a.osteoporosisAbueloP = :osteoporosisAbueloP"),
    @NamedQuery(name = "Anamnesis.findByOsteoporosisAbueloM", query = "SELECT a FROM Anamnesis a WHERE a.osteoporosisAbueloM = :osteoporosisAbueloM"),
    @NamedQuery(name = "Anamnesis.findByOsteoporosisNinguno", query = "SELECT a FROM Anamnesis a WHERE a.osteoporosisNinguno = :osteoporosisNinguno"),
    @NamedQuery(name = "Anamnesis.findByOtrosPadre", query = "SELECT a FROM Anamnesis a WHERE a.otrosPadre = :otrosPadre"),
    @NamedQuery(name = "Anamnesis.findByOtrosMadre", query = "SELECT a FROM Anamnesis a WHERE a.otrosMadre = :otrosMadre"),
    @NamedQuery(name = "Anamnesis.findByOtrosHijo", query = "SELECT a FROM Anamnesis a WHERE a.otrosHijo = :otrosHijo"),
    @NamedQuery(name = "Anamnesis.findByOtrosTioP", query = "SELECT a FROM Anamnesis a WHERE a.otrosTioP = :otrosTioP"),
    @NamedQuery(name = "Anamnesis.findByOtrosTioM", query = "SELECT a FROM Anamnesis a WHERE a.otrosTioM = :otrosTioM"),
    @NamedQuery(name = "Anamnesis.findByOtrosHnos", query = "SELECT a FROM Anamnesis a WHERE a.otrosHnos = :otrosHnos"),
    @NamedQuery(name = "Anamnesis.findByOtrosAbueloP", query = "SELECT a FROM Anamnesis a WHERE a.otrosAbueloP = :otrosAbueloP"),
    @NamedQuery(name = "Anamnesis.findByOtrosAbueloM", query = "SELECT a FROM Anamnesis a WHERE a.otrosAbueloM = :otrosAbueloM"),
    @NamedQuery(name = "Anamnesis.findByOtrosNinguno", query = "SELECT a FROM Anamnesis a WHERE a.otrosNinguno = :otrosNinguno"),
    @NamedQuery(name = "Anamnesis.findByFechaCreacionAn", query = "SELECT a FROM Anamnesis a WHERE a.fechaCreacionAn = :fechaCreacionAn"),
    @NamedQuery(name = "Anamnesis.findByHoraCreacionAn", query = "SELECT a FROM Anamnesis a WHERE a.horaCreacionAn = :horaCreacionAn"),
    @NamedQuery(name = "Anamnesis.findByIdUsuario", query = "SELECT a FROM Anamnesis a WHERE a.idUsuario = :idUsuario")})
public class Anamnesis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAnamnesis")
    private Integer idAnamnesis;
    @Size(max = 45)
    @Column(name = "motivoConsulta")
    private String motivoConsulta;
    @Size(max = 45)
    @Column(name = "historiaEnfermedadActual")
    private String historiaEnfermedadActual;
    @Size(max = 45)
    @Column(name = "bajoMedicacion")
    private String bajoMedicacion;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "bajoMedicacionComentarios")
    private String bajoMedicacionComentarios;
    @Size(max = 45)
    @Column(name = "alergia")
    private String alergia;
    @Size(max = 45)
    @Column(name = "hepatitis")
    private String hepatitis;
    @Size(max = 45)
    @Column(name = "vih")
    private String vih;
    @Size(max = 45)
    @Column(name = "anemia")
    private String anemia;
    @Size(max = 45)
    @Column(name = "herpes")
    private String herpes;
    @Size(max = 45)
    @Column(name = "enfermedadRenal")
    private String enfermedadRenal;
    @Size(max = 45)
    @Column(name = "artritis")
    private String artritis;
    @Size(max = 45)
    @Column(name = "ulcerasOrales")
    private String ulcerasOrales;
    @Size(max = 45)
    @Column(name = "asma")
    private String asma;
    @Size(max = 45)
    @Column(name = "diabetes")
    private String diabetes;
    @Size(max = 45)
    @Column(name = "hemorragias")
    private String hemorragias;
    @Size(max = 45)
    @Column(name = "problemasEndocrinos")
    private String problemasEndocrinos;
    @Size(max = 45)
    @Column(name = "fiebreReumatica")
    private String fiebreReumatica;
    @Size(max = 45)
    @Column(name = "cancer")
    private String cancer;
    @Size(max = 45)
    @Column(name = "problemasPsicologicos")
    private String problemasPsicologicos;
    @Size(max = 45)
    @Column(name = "problemasTiroideos")
    private String problemasTiroideos;
    @Size(max = 45)
    @Column(name = "problemasCardiacos")
    private String problemasCardiacos;
    @Size(max = 45)
    @Column(name = "epilepsia")
    private String epilepsia;
    @Size(max = 45)
    @Column(name = "tuberculosis")
    private String tuberculosis;
    @Size(max = 45)
    @Column(name = "osteoporosis")
    private String osteoporosis;
    @Size(max = 45)
    @Column(name = "hipertension")
    private String hipertension;
    @Size(max = 45)
    @Column(name = "problemasPsiquiatricos")
    private String problemasPsiquiatricos;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoAlergia")
    private String fechaDiagnosticoAlergia;
    @Size(max = 45)
    @Column(name = "tratamientoAlergia")
    private String tratamientoAlergia;
    @Size(max = 45)
    @Column(name = "inicioTratamientoAlergia")
    private String inicioTratamientoAlergia;
    @Size(max = 45)
    @Column(name = "hastaTratamientoAlergia")
    private String hastaTratamientoAlergia;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "medicacionAlergia")
    private String medicacionAlergia;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosAlergia")
    private String comentariosAlergia;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoHepatitis")
    private String fechaDiagnosticoHepatitis;
    @Size(max = 45)
    @Column(name = "tratamientoHepatitis")
    private String tratamientoHepatitis;
    @Size(max = 45)
    @Column(name = "inicioTratamientoHepatitis")
    private String inicioTratamientoHepatitis;
    @Size(max = 45)
    @Column(name = "hastaTratamientoHepatitis")
    private String hastaTratamientoHepatitis;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "medicacionHepatitis")
    private String medicacionHepatitis;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosHepatitis")
    private String comentariosHepatitis;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoVih")
    private String fechaDiagnosticoVih;
    @Size(max = 45)
    @Column(name = "tratamientoVih")
    private String tratamientoVih;
    @Size(max = 45)
    @Column(name = "inicioTratamientoVih")
    private String inicioTratamientoVih;
    @Size(max = 45)
    @Column(name = "hastaTratamientoVih")
    private String hastaTratamientoVih;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "medicacionVih")
    private String medicacionVih;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosVih")
    private String comentariosVih;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoAnemia")
    private String fechaDiagnosticoAnemia;
    @Size(max = 45)
    @Column(name = "tratamientoAnemia")
    private String tratamientoAnemia;
    @Size(max = 45)
    @Column(name = "inicioTratamientoAnemia")
    private String inicioTratamientoAnemia;
    @Size(max = 45)
    @Column(name = "hastaTratamientoAnemia")
    private String hastaTratamientoAnemia;
    @Size(max = 45)
    @Column(name = "medicacionAnemia")
    private String medicacionAnemia;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosAnemia")
    private String comentariosAnemia;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoHerpes")
    private String fechaDiagnosticoHerpes;
    @Size(max = 45)
    @Column(name = "tratamientoHerpes")
    private String tratamientoHerpes;
    @Size(max = 45)
    @Column(name = "inicioTratamientoHerpes")
    private String inicioTratamientoHerpes;
    @Size(max = 45)
    @Column(name = "hastaTratamientoHerpes")
    private String hastaTratamientoHerpes;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "medicacionHerpes")
    private String medicacionHerpes;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosHerpes")
    private String comentariosHerpes;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoEnfermedadRenal")
    private String fechaDiagnosticoEnfermedadRenal;
    @Size(max = 45)
    @Column(name = "tratamientoEnfermedadRenal")
    private String tratamientoEnfermedadRenal;
    @Size(max = 45)
    @Column(name = "inicioTratamientoEnfermedadRenal")
    private String inicioTratamientoEnfermedadRenal;
    @Size(max = 45)
    @Column(name = "hastaTratamientoEnfermedadRenal")
    private String hastaTratamientoEnfermedadRenal;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "medicacionEnfermedadRenal")
    private String medicacionEnfermedadRenal;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosEnfermedadRenal")
    private String comentariosEnfermedadRenal;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoArtritis")
    private String fechaDiagnosticoArtritis;
    @Size(max = 45)
    @Column(name = "tratamientoArtritis")
    private String tratamientoArtritis;
    @Size(max = 45)
    @Column(name = "inicioTratamientoArtritis")
    private String inicioTratamientoArtritis;
    @Size(max = 45)
    @Column(name = "hastaTratamientoArtritis")
    private String hastaTratamientoArtritis;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "medicacionArtritis")
    private String medicacionArtritis;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosArtritis")
    private String comentariosArtritis;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoUlcerasOrales")
    private String fechaDiagnosticoUlcerasOrales;
    @Size(max = 45)
    @Column(name = "tratamientoUlcerasOrales")
    private String tratamientoUlcerasOrales;
    @Size(max = 45)
    @Column(name = "inicioTratamientoUlcerasOrales")
    private String inicioTratamientoUlcerasOrales;
    @Size(max = 45)
    @Column(name = "hastaTratamientoUlcerasOrales")
    private String hastaTratamientoUlcerasOrales;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "medicacionUlcerasOrales")
    private String medicacionUlcerasOrales;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosUlcerasOrales")
    private String comentariosUlcerasOrales;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoAsma")
    private String fechaDiagnosticoAsma;
    @Size(max = 45)
    @Column(name = "tratamientoAsma")
    private String tratamientoAsma;
    @Size(max = 45)
    @Column(name = "inicioTratamientoAsma")
    private String inicioTratamientoAsma;
    @Size(max = 45)
    @Column(name = "hastaTratamientoAsma")
    private String hastaTratamientoAsma;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "medicacionAsma")
    private String medicacionAsma;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosAsma")
    private String comentariosAsma;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoDiabetes")
    private String fechaDiagnosticoDiabetes;
    @Size(max = 45)
    @Column(name = "tratamientoDiabetes")
    private String tratamientoDiabetes;
    @Size(max = 45)
    @Column(name = "inicioTratamientoDiabetes")
    private String inicioTratamientoDiabetes;
    @Size(max = 45)
    @Column(name = "hastaTratamientoDiabetes")
    private String hastaTratamientoDiabetes;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "medicacionDiabetes")
    private String medicacionDiabetes;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosDiabetes")
    private String comentariosDiabetes;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoHemorragias")
    private String fechaDiagnosticoHemorragias;
    @Size(max = 45)
    @Column(name = "tratamientoHemorragias")
    private String tratamientoHemorragias;
    @Size(max = 45)
    @Column(name = "inicioTratamientoHemorragias")
    private String inicioTratamientoHemorragias;
    @Size(max = 45)
    @Column(name = "hastaTratamientoHemorragias")
    private String hastaTratamientoHemorragias;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "medicacionHemorragias")
    private String medicacionHemorragias;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosHemorragias")
    private String comentariosHemorragias;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoProblemasEndocrinos")
    private String fechaDiagnosticoProblemasEndocrinos;
    @Size(max = 45)
    @Column(name = "tratamientoProblemasEndocrinos")
    private String tratamientoProblemasEndocrinos;
    @Size(max = 45)
    @Column(name = "inicioTratamientoProblemasEndocrinos")
    private String inicioTratamientoProblemasEndocrinos;
    @Size(max = 45)
    @Column(name = "hastaTratamientoProblemasEndocrinos")
    private String hastaTratamientoProblemasEndocrinos;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "medicacionProblemasEndocrinos")
    private String medicacionProblemasEndocrinos;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosProblemasEndocrinos")
    private String comentariosProblemasEndocrinos;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoFiebreReumatica")
    private String fechaDiagnosticoFiebreReumatica;
    @Size(max = 45)
    @Column(name = "tratamientoFiebreReumatica")
    private String tratamientoFiebreReumatica;
    @Size(max = 45)
    @Column(name = "inicioTratamientoFiebreReumatica")
    private String inicioTratamientoFiebreReumatica;
    @Size(max = 45)
    @Column(name = "hastaTratamientoFiebreReumatica")
    private String hastaTratamientoFiebreReumatica;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "medicacionFiebreReumatica")
    private String medicacionFiebreReumatica;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosFiebreReumatica")
    private String comentariosFiebreReumatica;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoCancer")
    private String fechaDiagnosticoCancer;
    @Size(max = 45)
    @Column(name = "tratamientoCancer")
    private String tratamientoCancer;
    @Size(max = 45)
    @Column(name = "inicioTratamientoCancer")
    private String inicioTratamientoCancer;
    @Size(max = 45)
    @Column(name = "hastaTratamientoCancer")
    private String hastaTratamientoCancer;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "medicacionCancer")
    private String medicacionCancer;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosCancer")
    private String comentariosCancer;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoProblemasPsicologicos")
    private String fechaDiagnosticoProblemasPsicologicos;
    @Size(max = 45)
    @Column(name = "tratamientoProblemasPsicologicos")
    private String tratamientoProblemasPsicologicos;
    @Size(max = 45)
    @Column(name = "inicioTratamientoProblemasPsicologicos")
    private String inicioTratamientoProblemasPsicologicos;
    @Size(max = 45)
    @Column(name = "hastaTratamientoProblemasPsicologicos")
    private String hastaTratamientoProblemasPsicologicos;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "medicacionProblemasPsicologicos")
    private String medicacionProblemasPsicologicos;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosProblemasPsicologicos")
    private String comentariosProblemasPsicologicos;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoProblemasTiroideos")
    private String fechaDiagnosticoProblemasTiroideos;
    @Size(max = 45)
    @Column(name = "tratamientoProblemasTiroideos")
    private String tratamientoProblemasTiroideos;
    @Size(max = 45)
    @Column(name = "inicioTratamientoProblemasTiroideos")
    private String inicioTratamientoProblemasTiroideos;
    @Size(max = 45)
    @Column(name = "hastaTratamientoProblemasTiroideos")
    private String hastaTratamientoProblemasTiroideos;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "medicacionProblemasTiroideos")
    private String medicacionProblemasTiroideos;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosProblemasTiroideos")
    private String comentariosProblemasTiroideos;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoProblemasCardiacos")
    private String fechaDiagnosticoProblemasCardiacos;
    @Size(max = 45)
    @Column(name = "tratamientoProblemasCardiacos")
    private String tratamientoProblemasCardiacos;
    @Size(max = 45)
    @Column(name = "inicioTratamientoProblemasCardiacos")
    private String inicioTratamientoProblemasCardiacos;
    @Size(max = 45)
    @Column(name = "hastaTratamientoProblemasCardiacos")
    private String hastaTratamientoProblemasCardiacos;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "medicacionProblemasCardiacos")
    private String medicacionProblemasCardiacos;
    @Size(max = 45)
    @Column(name = "comentariosProblemasCardiacos")
    private String comentariosProblemasCardiacos;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoEpilepsia")
    private String fechaDiagnosticoEpilepsia;
    @Size(max = 45)
    @Column(name = "tratamientoEpilepsia")
    private String tratamientoEpilepsia;
    @Size(max = 45)
    @Column(name = "inicioTratamientoEpilepsia")
    private String inicioTratamientoEpilepsia;
    @Size(max = 45)
    @Column(name = "hastaTratamientoEpilepsia")
    private String hastaTratamientoEpilepsia;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "medicacionEpilepsia")
    private String medicacionEpilepsia;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosEpilepsia")
    private String comentariosEpilepsia;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoTuberculosis")
    private String fechaDiagnosticoTuberculosis;
    @Size(max = 45)
    @Column(name = "tratamientoTuberculosis")
    private String tratamientoTuberculosis;
    @Size(max = 45)
    @Column(name = "inicioTratamientoTuberculosis")
    private String inicioTratamientoTuberculosis;
    @Size(max = 45)
    @Column(name = "hastaTratamientoTuberculosis")
    private String hastaTratamientoTuberculosis;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "medicacionTuberculosis")
    private String medicacionTuberculosis;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosTuberculosis")
    private String comentariosTuberculosis;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoOsteoporosis")
    private String fechaDiagnosticoOsteoporosis;
    @Size(max = 45)
    @Column(name = "tratamientoOsteoporosis")
    private String tratamientoOsteoporosis;
    @Size(max = 45)
    @Column(name = "inicioTratamientoOsteoporosis")
    private String inicioTratamientoOsteoporosis;
    @Size(max = 45)
    @Column(name = "hastaTratamientoOsteoporosis")
    private String hastaTratamientoOsteoporosis;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "medicacionOsteoporosis")
    private String medicacionOsteoporosis;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosOsteoporosis")
    private String comentariosOsteoporosis;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoHipertension")
    private String fechaDiagnosticoHipertension;
    @Size(max = 45)
    @Column(name = "tratamientoHipertension")
    private String tratamientoHipertension;
    @Size(max = 45)
    @Column(name = "inicioTratamientoHipertension")
    private String inicioTratamientoHipertension;
    @Size(max = 45)
    @Column(name = "hastaTratamientoHipertension")
    private String hastaTratamientoHipertension;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "medicacionHipertension")
    private String medicacionHipertension;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosHipertension")
    private String comentariosHipertension;
    @Size(max = 45)
    @Column(name = "fechaDiagnosticoProblemasPsiquiatricos")
    private String fechaDiagnosticoProblemasPsiquiatricos;
    @Size(max = 45)
    @Column(name = "tratamientoProblemasPsiquiatricos")
    private String tratamientoProblemasPsiquiatricos;
    @Size(max = 45)
    @Column(name = "inicioTratamientoProblemasPsiquiatricos")
    private String inicioTratamientoProblemasPsiquiatricos;
    @Size(max = 45)
    @Column(name = "hastaTratamientoProblemasPsiquiatricos")
    private String hastaTratamientoProblemasPsiquiatricos;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "medicacionProblemasPsiquiatricos")
    private String medicacionProblemasPsiquiatricos;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosProblemasPsiquiatricos")
    private String comentariosProblemasPsiquiatricos;
    @Size(max = 45)
    @Column(name = "fractura")
    private String fractura;
    @Size(max = 45)
    @Column(name = "fechaFractura")
    private String fechaFractura;
    @Size(max = 45)
    @Column(name = "cadera")
    private String cadera;
    @Size(max = 45)
    @Column(name = "tobillo")
    private String tobillo;
    @Size(max = 45)
    @Column(name = "femur")
    private String femur;
    @Size(max = 45)
    @Column(name = "muneca")
    private String muneca;
    @Size(max = 45)
    @Column(name = "antebrazo")
    private String antebrazo;
    @Size(max = 45)
    @Column(name = "vertebra")
    private String vertebra;
    @Size(max = 45)
    @Column(name = "columna")
    private String columna;
    @Size(max = 45)
    @Column(name = "otraFractura")
    private String otraFractura;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "otraFracturaComentarios")
    private String otraFracturaComentarios;
    @Size(max = 45)
    @Column(name = "causaFractura")
    private String causaFractura;
    @Size(max = 45)
    @Column(name = "recuperacionPostFractura")
    private String recuperacionPostFractura;
    @Size(max = 45)
    @Column(name = "incapacidadTotal")
    private String incapacidadTotal;
    @Size(max = 45)
    @Column(name = "unidadIncapacidadTotal")
    private String unidadIncapacidadTotal;
    @Size(max = 45)
    @Column(name = "otrosAntecedentesTraumatologicos")
    private String otrosAntecedentesTraumatologicos;
    @Size(max = 45)
    @Column(name = "menarquia")
    private String menarquia;
    @Size(max = 45)
    @Column(name = "menopausia")
    private String menopausia;
    @Size(max = 45)
    @Column(name = "histerectomia")
    private String histerectomia;
    @Size(max = 45)
    @Column(name = "embarazos")
    private String embarazos;
    @Size(max = 45)
    @Column(name = "partos")
    private String partos;
    @Size(max = 45)
    @Column(name = "abortos")
    private String abortos;
    @Size(max = 45)
    @Column(name = "hijosVivos")
    private String hijosVivos;
    @Size(max = 45)
    @Column(name = "ciclos")
    private String ciclos;
    @Size(max = 45)
    @Column(name = "ur")
    private String ur;
    @Size(max = 45)
    @Column(name = "infertilidad")
    private String infertilidad;
    @Size(max = 45)
    @Column(name = "lactancia")
    private String lactancia;
    @Size(max = 45)
    @Column(name = "totalLactancia")
    private String totalLactancia;
    @Size(max = 45)
    @Column(name = "edadDeLosHijos")
    private String edadDeLosHijos;
    @Size(max = 45)
    @Column(name = "tabaquismo")
    private String tabaquismo;
    @Size(max = 45)
    @Column(name = "fumadorPasivo")
    private String fumadorPasivo;
    @Size(max = 45)
    @Column(name = "fumaDesde")
    private String fumaDesde;
    @Size(max = 45)
    @Column(name = "frecuenciaTabaquismo")
    private String frecuenciaTabaquismo;
    @Size(max = 45)
    @Column(name = "licor")
    private String licor;
    @Size(max = 45)
    @Column(name = "frecuenciaLicor")
    private String frecuenciaLicor;
    @Size(max = 45)
    @Column(name = "cerveza")
    private String cerveza;
    @Size(max = 45)
    @Column(name = "vino")
    private String vino;
    @Size(max = 45)
    @Column(name = "ron")
    private String ron;
    @Size(max = 45)
    @Column(name = "whiskey")
    private String whiskey;
    @Size(max = 45)
    @Column(name = "aguardiente")
    private String aguardiente;
    @Size(max = 45)
    @Column(name = "otrosLicores")
    private String otrosLicores;
    @Size(max = 45)
    @Column(name = "cafe")
    private String cafe;
    @Size(max = 45)
    @Column(name = "frecuenciaCafe")
    private String frecuenciaCafe;
    @Size(max = 45)
    @Column(name = "otroCafe")
    private String otroCafe;
    @Size(max = 45)
    @Column(name = "inicioCafe")
    private String inicioCafe;
    @Size(max = 45)
    @Column(name = "lecheDerivados")
    private String lecheDerivados;
    @Size(max = 45)
    @Column(name = "frecuenciaLecheDerivados")
    private String frecuenciaLecheDerivados;
    @Size(max = 45)
    @Column(name = "otroLecheDerivado")
    private String otroLecheDerivado;
    @Size(max = 45)
    @Column(name = "inicioLecheDerivado")
    private String inicioLecheDerivado;
    @Size(max = 45)
    @Column(name = "frutasFrescas")
    private String frutasFrescas;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "queClasesFrutasFrescas")
    private String queClasesFrutasFrescas;
    @Size(max = 45)
    @Column(name = "porcionesFrutasFrescas")
    private String porcionesFrutasFrescas;
    @Size(max = 45)
    @Column(name = "realizaEjercicio")
    private String realizaEjercicio;
    @Size(max = 45)
    @Column(name = "frecuenciaEjercicio")
    private String frecuenciaEjercicio;
    @Size(max = 45)
    @Column(name = "pescados")
    private String pescados;
    @Size(max = 45)
    @Column(name = "pescadoRio")
    private String pescadoRio;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "clasePescadoRio")
    private String clasePescadoRio;
    @Size(max = 45)
    @Column(name = "vecesPescadoRio")
    private String vecesPescadoRio;
    @Size(max = 45)
    @Column(name = "desdePescadoRio")
    private String desdePescadoRio;
    @Size(max = 45)
    @Column(name = "frecuenciaPescadoRio")
    private String frecuenciaPescadoRio;
    @Size(max = 45)
    @Column(name = "hastaPescadoRio")
    private String hastaPescadoRio;
    @Size(max = 45)
    @Column(name = "pescadoMar")
    private String pescadoMar;
    @Size(max = 45)
    @Column(name = "blanco")
    private String blanco;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "clasePescadoMarBlanco")
    private String clasePescadoMarBlanco;
    @Size(max = 45)
    @Column(name = "vecesPescadoMarBlanco")
    private String vecesPescadoMarBlanco;
    @Size(max = 45)
    @Column(name = "desdePescadoMarBlanco")
    private String desdePescadoMarBlanco;
    @Size(max = 45)
    @Column(name = "frecuenciaPescadoMarBlanco")
    private String frecuenciaPescadoMarBlanco;
    @Size(max = 45)
    @Column(name = "hastaPescadoMarblanco")
    private String hastaPescadoMarblanco;
    @Size(max = 45)
    @Column(name = "azules")
    private String azules;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "clasePescadoMarAzules")
    private String clasePescadoMarAzules;
    @Size(max = 45)
    @Column(name = "vecesPescadoMarAzules")
    private String vecesPescadoMarAzules;
    @Size(max = 45)
    @Column(name = "desdePescadoMarAzules")
    private String desdePescadoMarAzules;
    @Size(max = 45)
    @Column(name = "frecuenciaPescadoMarAzules")
    private String frecuenciaPescadoMarAzules;
    @Size(max = 45)
    @Column(name = "hastaPescadoMarAzules")
    private String hastaPescadoMarAzules;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "antecedentesQuirurgicos")
    private String antecedentesQuirurgicos;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "otrosTratamientosAntecedentesQuirurgicos")
    private String otrosTratamientosAntecedentesQuirurgicos;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentariosAntecedentesQuirurgicos")
    private String comentariosAntecedentesQuirurgicos;
    @Size(max = 45)
    @Column(name = "diabetesPadre")
    private String diabetesPadre;
    @Size(max = 45)
    @Column(name = "diabetesMadre")
    private String diabetesMadre;
    @Size(max = 45)
    @Column(name = "diabetesHijo")
    private String diabetesHijo;
    @Size(max = 45)
    @Column(name = "diabetesTioP")
    private String diabetesTioP;
    @Size(max = 45)
    @Column(name = "diabetesTioM")
    private String diabetesTioM;
    @Size(max = 45)
    @Column(name = "diabetesHnos")
    private String diabetesHnos;
    @Size(max = 45)
    @Column(name = "diabetesAbueloP")
    private String diabetesAbueloP;
    @Size(max = 45)
    @Column(name = "diabetesAbueloM")
    private String diabetesAbueloM;
    @Size(max = 45)
    @Column(name = "diabetesNinguno")
    private String diabetesNinguno;
    @Size(max = 45)
    @Column(name = "obesidadPadre")
    private String obesidadPadre;
    @Size(max = 45)
    @Column(name = "obesidadMadre")
    private String obesidadMadre;
    @Size(max = 45)
    @Column(name = "obesidadHijo")
    private String obesidadHijo;
    @Size(max = 45)
    @Column(name = "obesidadTioP")
    private String obesidadTioP;
    @Size(max = 45)
    @Column(name = "obesidadTioM")
    private String obesidadTioM;
    @Size(max = 45)
    @Column(name = "obesidadHnos")
    private String obesidadHnos;
    @Size(max = 45)
    @Column(name = "obesidadAbueloP")
    private String obesidadAbueloP;
    @Size(max = 45)
    @Column(name = "obesidadAbueloM")
    private String obesidadAbueloM;
    @Size(max = 45)
    @Column(name = "obesidadNinguno")
    private String obesidadNinguno;
    @Size(max = 45)
    @Column(name = "colesterolPadre")
    private String colesterolPadre;
    @Size(max = 45)
    @Column(name = "colesterolMadre")
    private String colesterolMadre;
    @Size(max = 45)
    @Column(name = "colesterolHijo")
    private String colesterolHijo;
    @Size(max = 45)
    @Column(name = "colesterolTioP")
    private String colesterolTioP;
    @Size(max = 45)
    @Column(name = "colesterolTioM")
    private String colesterolTioM;
    @Size(max = 45)
    @Column(name = "colesterolHnos")
    private String colesterolHnos;
    @Size(max = 45)
    @Column(name = "colesterolAbueloP")
    private String colesterolAbueloP;
    @Size(max = 45)
    @Column(name = "colesterolAbueloM")
    private String colesterolAbueloM;
    @Size(max = 45)
    @Column(name = "colesterolNinguno")
    private String colesterolNinguno;
    @Size(max = 45)
    @Column(name = "trigliceridosPadre")
    private String trigliceridosPadre;
    @Size(max = 45)
    @Column(name = "trigliceridosMadre")
    private String trigliceridosMadre;
    @Size(max = 45)
    @Column(name = "trigliceridosHijo")
    private String trigliceridosHijo;
    @Size(max = 45)
    @Column(name = "trigliceridosTioP")
    private String trigliceridosTioP;
    @Size(max = 45)
    @Column(name = "trigliceridosTioM")
    private String trigliceridosTioM;
    @Size(max = 45)
    @Column(name = "trigliceridosHnos")
    private String trigliceridosHnos;
    @Size(max = 45)
    @Column(name = "trigliceridosAbueloP")
    private String trigliceridosAbueloP;
    @Size(max = 45)
    @Column(name = "trigliceridosAbueloM")
    private String trigliceridosAbueloM;
    @Size(max = 45)
    @Column(name = "trigliceridosNinguno")
    private String trigliceridosNinguno;
    @Size(max = 45)
    @Column(name = "infartosPadre")
    private String infartosPadre;
    @Size(max = 45)
    @Column(name = "infartosMadre")
    private String infartosMadre;
    @Size(max = 45)
    @Column(name = "infartosHijo")
    private String infartosHijo;
    @Size(max = 45)
    @Column(name = "infartosTioP")
    private String infartosTioP;
    @Size(max = 45)
    @Column(name = "infartosTioM")
    private String infartosTioM;
    @Size(max = 45)
    @Column(name = "infartosHnos")
    private String infartosHnos;
    @Size(max = 45)
    @Column(name = "infartosAbueloP")
    private String infartosAbueloP;
    @Size(max = 45)
    @Column(name = "infartosAbueloM")
    private String infartosAbueloM;
    @Size(max = 45)
    @Column(name = "infartosNinguno")
    private String infartosNinguno;
    @Size(max = 45)
    @Column(name = "hipertensionPadre")
    private String hipertensionPadre;
    @Size(max = 45)
    @Column(name = "hipertensionMadre")
    private String hipertensionMadre;
    @Size(max = 45)
    @Column(name = "hipertensionHijo")
    private String hipertensionHijo;
    @Size(max = 45)
    @Column(name = "hipertensionTioP")
    private String hipertensionTioP;
    @Size(max = 45)
    @Column(name = "hipertensionTioM")
    private String hipertensionTioM;
    @Size(max = 45)
    @Column(name = "hipertensionHnos")
    private String hipertensionHnos;
    @Size(max = 45)
    @Column(name = "hipertensionAbueloP")
    private String hipertensionAbueloP;
    @Size(max = 45)
    @Column(name = "hipertensionAbueloM")
    private String hipertensionAbueloM;
    @Size(max = 45)
    @Column(name = "hipertensionNinguno")
    private String hipertensionNinguno;
    @Size(max = 45)
    @Column(name = "cancerPadre")
    private String cancerPadre;
    @Size(max = 45)
    @Column(name = "cancerMadre")
    private String cancerMadre;
    @Size(max = 45)
    @Column(name = "cancerHijo")
    private String cancerHijo;
    @Size(max = 45)
    @Column(name = "cancerTioP")
    private String cancerTioP;
    @Size(max = 45)
    @Column(name = "cancerTioM")
    private String cancerTioM;
    @Size(max = 45)
    @Column(name = "cancerHnos")
    private String cancerHnos;
    @Size(max = 45)
    @Column(name = "cancerAbueloP")
    private String cancerAbueloP;
    @Size(max = 45)
    @Column(name = "cancerAbueloM")
    private String cancerAbueloM;
    @Size(max = 45)
    @Column(name = "cancerNinguno")
    private String cancerNinguno;
    @Size(max = 45)
    @Column(name = "osteoporosisPadre")
    private String osteoporosisPadre;
    @Size(max = 45)
    @Column(name = "osteoporosisMadre")
    private String osteoporosisMadre;
    @Size(max = 45)
    @Column(name = "osteoporosisHijo")
    private String osteoporosisHijo;
    @Size(max = 45)
    @Column(name = "osteoporosisTioP")
    private String osteoporosisTioP;
    @Size(max = 45)
    @Column(name = "osteoporosisTioM")
    private String osteoporosisTioM;
    @Size(max = 45)
    @Column(name = "osteoporosisHnos")
    private String osteoporosisHnos;
    @Size(max = 45)
    @Column(name = "osteoporosisAbueloP")
    private String osteoporosisAbueloP;
    @Size(max = 45)
    @Column(name = "osteoporosisAbueloM")
    private String osteoporosisAbueloM;
    @Size(max = 45)
    @Column(name = "osteoporosisNinguno")
    private String osteoporosisNinguno;
    @Size(max = 45)
    @Column(name = "otrosPadre")
    private String otrosPadre;
    @Size(max = 45)
    @Column(name = "otrosMadre")
    private String otrosMadre;
    @Size(max = 45)
    @Column(name = "otrosHijo")
    private String otrosHijo;
    @Size(max = 45)
    @Column(name = "otrosTioP")
    private String otrosTioP;
    @Size(max = 45)
    @Column(name = "otrosTioM")
    private String otrosTioM;
    @Size(max = 45)
    @Column(name = "otrosHnos")
    private String otrosHnos;
    @Size(max = 45)
    @Column(name = "otrosAbueloP")
    private String otrosAbueloP;
    @Size(max = 45)
    @Column(name = "otrosAbueloM")
    private String otrosAbueloM;
    @Size(max = 45)
    @Column(name = "otrosNinguno")
    private String otrosNinguno;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "otrosComentariosTablaAntecedentesFamiliares")
    private String otrosComentariosTablaAntecedentesFamiliares;
    @Size(max = 45)
    @Column(name = "fechaCreacionAn")
    private String fechaCreacionAn;
    @Size(max = 45)
    @Column(name = "horaCreacionAn")
    private String horaCreacionAn;
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    @ManyToOne(fetch = FetchType.LAZY)
    private PacientesHcemed idPaciente;

    public Anamnesis() {
    }

    public Anamnesis(Integer idAnamnesis) {
        this.idAnamnesis = idAnamnesis;
    }

    public Integer getIdAnamnesis() {
        return idAnamnesis;
    }

    public void setIdAnamnesis(Integer idAnamnesis) {
        this.idAnamnesis = idAnamnesis;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getHistoriaEnfermedadActual() {
        return historiaEnfermedadActual;
    }

    public void setHistoriaEnfermedadActual(String historiaEnfermedadActual) {
        this.historiaEnfermedadActual = historiaEnfermedadActual;
    }

    public String getBajoMedicacion() {
        return bajoMedicacion;
    }

    public void setBajoMedicacion(String bajoMedicacion) {
        this.bajoMedicacion = bajoMedicacion;
    }

    public String getBajoMedicacionComentarios() {
        return bajoMedicacionComentarios;
    }

    public void setBajoMedicacionComentarios(String bajoMedicacionComentarios) {
        this.bajoMedicacionComentarios = bajoMedicacionComentarios;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public String getHepatitis() {
        return hepatitis;
    }

    public void setHepatitis(String hepatitis) {
        this.hepatitis = hepatitis;
    }

    public String getVih() {
        return vih;
    }

    public void setVih(String vih) {
        this.vih = vih;
    }

    public String getAnemia() {
        return anemia;
    }

    public void setAnemia(String anemia) {
        this.anemia = anemia;
    }

    public String getHerpes() {
        return herpes;
    }

    public void setHerpes(String herpes) {
        this.herpes = herpes;
    }

    public String getEnfermedadRenal() {
        return enfermedadRenal;
    }

    public void setEnfermedadRenal(String enfermedadRenal) {
        this.enfermedadRenal = enfermedadRenal;
    }

    public String getArtritis() {
        return artritis;
    }

    public void setArtritis(String artritis) {
        this.artritis = artritis;
    }

    public String getUlcerasOrales() {
        return ulcerasOrales;
    }

    public void setUlcerasOrales(String ulcerasOrales) {
        this.ulcerasOrales = ulcerasOrales;
    }

    public String getAsma() {
        return asma;
    }

    public void setAsma(String asma) {
        this.asma = asma;
    }

    public String getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes;
    }

    public String getHemorragias() {
        return hemorragias;
    }

    public void setHemorragias(String hemorragias) {
        this.hemorragias = hemorragias;
    }

    public String getProblemasEndocrinos() {
        return problemasEndocrinos;
    }

    public void setProblemasEndocrinos(String problemasEndocrinos) {
        this.problemasEndocrinos = problemasEndocrinos;
    }

    public String getFiebreReumatica() {
        return fiebreReumatica;
    }

    public void setFiebreReumatica(String fiebreReumatica) {
        this.fiebreReumatica = fiebreReumatica;
    }

    public String getCancer() {
        return cancer;
    }

    public void setCancer(String cancer) {
        this.cancer = cancer;
    }

    public String getProblemasPsicologicos() {
        return problemasPsicologicos;
    }

    public void setProblemasPsicologicos(String problemasPsicologicos) {
        this.problemasPsicologicos = problemasPsicologicos;
    }

    public String getProblemasTiroideos() {
        return problemasTiroideos;
    }

    public void setProblemasTiroideos(String problemasTiroideos) {
        this.problemasTiroideos = problemasTiroideos;
    }

    public String getProblemasCardiacos() {
        return problemasCardiacos;
    }

    public void setProblemasCardiacos(String problemasCardiacos) {
        this.problemasCardiacos = problemasCardiacos;
    }

    public String getEpilepsia() {
        return epilepsia;
    }

    public void setEpilepsia(String epilepsia) {
        this.epilepsia = epilepsia;
    }

    public String getTuberculosis() {
        return tuberculosis;
    }

    public void setTuberculosis(String tuberculosis) {
        this.tuberculosis = tuberculosis;
    }

    public String getOsteoporosis() {
        return osteoporosis;
    }

    public void setOsteoporosis(String osteoporosis) {
        this.osteoporosis = osteoporosis;
    }

    public String getHipertension() {
        return hipertension;
    }

    public void setHipertension(String hipertension) {
        this.hipertension = hipertension;
    }

    public String getProblemasPsiquiatricos() {
        return problemasPsiquiatricos;
    }

    public void setProblemasPsiquiatricos(String problemasPsiquiatricos) {
        this.problemasPsiquiatricos = problemasPsiquiatricos;
    }

    public String getFechaDiagnosticoAlergia() {
        return fechaDiagnosticoAlergia;
    }

    public void setFechaDiagnosticoAlergia(String fechaDiagnosticoAlergia) {
        this.fechaDiagnosticoAlergia = fechaDiagnosticoAlergia;
    }

    public String getTratamientoAlergia() {
        return tratamientoAlergia;
    }

    public void setTratamientoAlergia(String tratamientoAlergia) {
        this.tratamientoAlergia = tratamientoAlergia;
    }

    public String getInicioTratamientoAlergia() {
        return inicioTratamientoAlergia;
    }

    public void setInicioTratamientoAlergia(String inicioTratamientoAlergia) {
        this.inicioTratamientoAlergia = inicioTratamientoAlergia;
    }

    public String getHastaTratamientoAlergia() {
        return hastaTratamientoAlergia;
    }

    public void setHastaTratamientoAlergia(String hastaTratamientoAlergia) {
        this.hastaTratamientoAlergia = hastaTratamientoAlergia;
    }

    public String getMedicacionAlergia() {
        return medicacionAlergia;
    }

    public void setMedicacionAlergia(String medicacionAlergia) {
        this.medicacionAlergia = medicacionAlergia;
    }

    public String getComentariosAlergia() {
        return comentariosAlergia;
    }

    public void setComentariosAlergia(String comentariosAlergia) {
        this.comentariosAlergia = comentariosAlergia;
    }

    public String getFechaDiagnosticoHepatitis() {
        return fechaDiagnosticoHepatitis;
    }

    public void setFechaDiagnosticoHepatitis(String fechaDiagnosticoHepatitis) {
        this.fechaDiagnosticoHepatitis = fechaDiagnosticoHepatitis;
    }

    public String getTratamientoHepatitis() {
        return tratamientoHepatitis;
    }

    public void setTratamientoHepatitis(String tratamientoHepatitis) {
        this.tratamientoHepatitis = tratamientoHepatitis;
    }

    public String getInicioTratamientoHepatitis() {
        return inicioTratamientoHepatitis;
    }

    public void setInicioTratamientoHepatitis(String inicioTratamientoHepatitis) {
        this.inicioTratamientoHepatitis = inicioTratamientoHepatitis;
    }

    public String getHastaTratamientoHepatitis() {
        return hastaTratamientoHepatitis;
    }

    public void setHastaTratamientoHepatitis(String hastaTratamientoHepatitis) {
        this.hastaTratamientoHepatitis = hastaTratamientoHepatitis;
    }

    public String getMedicacionHepatitis() {
        return medicacionHepatitis;
    }

    public void setMedicacionHepatitis(String medicacionHepatitis) {
        this.medicacionHepatitis = medicacionHepatitis;
    }

    public String getComentariosHepatitis() {
        return comentariosHepatitis;
    }

    public void setComentariosHepatitis(String comentariosHepatitis) {
        this.comentariosHepatitis = comentariosHepatitis;
    }

    public String getFechaDiagnosticoVih() {
        return fechaDiagnosticoVih;
    }

    public void setFechaDiagnosticoVih(String fechaDiagnosticoVih) {
        this.fechaDiagnosticoVih = fechaDiagnosticoVih;
    }

    public String getTratamientoVih() {
        return tratamientoVih;
    }

    public void setTratamientoVih(String tratamientoVih) {
        this.tratamientoVih = tratamientoVih;
    }

    public String getInicioTratamientoVih() {
        return inicioTratamientoVih;
    }

    public void setInicioTratamientoVih(String inicioTratamientoVih) {
        this.inicioTratamientoVih = inicioTratamientoVih;
    }

    public String getHastaTratamientoVih() {
        return hastaTratamientoVih;
    }

    public void setHastaTratamientoVih(String hastaTratamientoVih) {
        this.hastaTratamientoVih = hastaTratamientoVih;
    }

    public String getMedicacionVih() {
        return medicacionVih;
    }

    public void setMedicacionVih(String medicacionVih) {
        this.medicacionVih = medicacionVih;
    }

    public String getComentariosVih() {
        return comentariosVih;
    }

    public void setComentariosVih(String comentariosVih) {
        this.comentariosVih = comentariosVih;
    }

    public String getFechaDiagnosticoAnemia() {
        return fechaDiagnosticoAnemia;
    }

    public void setFechaDiagnosticoAnemia(String fechaDiagnosticoAnemia) {
        this.fechaDiagnosticoAnemia = fechaDiagnosticoAnemia;
    }

    public String getTratamientoAnemia() {
        return tratamientoAnemia;
    }

    public void setTratamientoAnemia(String tratamientoAnemia) {
        this.tratamientoAnemia = tratamientoAnemia;
    }

    public String getInicioTratamientoAnemia() {
        return inicioTratamientoAnemia;
    }

    public void setInicioTratamientoAnemia(String inicioTratamientoAnemia) {
        this.inicioTratamientoAnemia = inicioTratamientoAnemia;
    }

    public String getHastaTratamientoAnemia() {
        return hastaTratamientoAnemia;
    }

    public void setHastaTratamientoAnemia(String hastaTratamientoAnemia) {
        this.hastaTratamientoAnemia = hastaTratamientoAnemia;
    }

    public String getMedicacionAnemia() {
        return medicacionAnemia;
    }

    public void setMedicacionAnemia(String medicacionAnemia) {
        this.medicacionAnemia = medicacionAnemia;
    }

    public String getComentariosAnemia() {
        return comentariosAnemia;
    }

    public void setComentariosAnemia(String comentariosAnemia) {
        this.comentariosAnemia = comentariosAnemia;
    }

    public String getFechaDiagnosticoHerpes() {
        return fechaDiagnosticoHerpes;
    }

    public void setFechaDiagnosticoHerpes(String fechaDiagnosticoHerpes) {
        this.fechaDiagnosticoHerpes = fechaDiagnosticoHerpes;
    }

    public String getTratamientoHerpes() {
        return tratamientoHerpes;
    }

    public void setTratamientoHerpes(String tratamientoHerpes) {
        this.tratamientoHerpes = tratamientoHerpes;
    }

    public String getInicioTratamientoHerpes() {
        return inicioTratamientoHerpes;
    }

    public void setInicioTratamientoHerpes(String inicioTratamientoHerpes) {
        this.inicioTratamientoHerpes = inicioTratamientoHerpes;
    }

    public String getHastaTratamientoHerpes() {
        return hastaTratamientoHerpes;
    }

    public void setHastaTratamientoHerpes(String hastaTratamientoHerpes) {
        this.hastaTratamientoHerpes = hastaTratamientoHerpes;
    }

    public String getMedicacionHerpes() {
        return medicacionHerpes;
    }

    public void setMedicacionHerpes(String medicacionHerpes) {
        this.medicacionHerpes = medicacionHerpes;
    }

    public String getComentariosHerpes() {
        return comentariosHerpes;
    }

    public void setComentariosHerpes(String comentariosHerpes) {
        this.comentariosHerpes = comentariosHerpes;
    }

    public String getFechaDiagnosticoEnfermedadRenal() {
        return fechaDiagnosticoEnfermedadRenal;
    }

    public void setFechaDiagnosticoEnfermedadRenal(String fechaDiagnosticoEnfermedadRenal) {
        this.fechaDiagnosticoEnfermedadRenal = fechaDiagnosticoEnfermedadRenal;
    }

    public String getTratamientoEnfermedadRenal() {
        return tratamientoEnfermedadRenal;
    }

    public void setTratamientoEnfermedadRenal(String tratamientoEnfermedadRenal) {
        this.tratamientoEnfermedadRenal = tratamientoEnfermedadRenal;
    }

    public String getInicioTratamientoEnfermedadRenal() {
        return inicioTratamientoEnfermedadRenal;
    }

    public void setInicioTratamientoEnfermedadRenal(String inicioTratamientoEnfermedadRenal) {
        this.inicioTratamientoEnfermedadRenal = inicioTratamientoEnfermedadRenal;
    }

    public String getHastaTratamientoEnfermedadRenal() {
        return hastaTratamientoEnfermedadRenal;
    }

    public void setHastaTratamientoEnfermedadRenal(String hastaTratamientoEnfermedadRenal) {
        this.hastaTratamientoEnfermedadRenal = hastaTratamientoEnfermedadRenal;
    }

    public String getMedicacionEnfermedadRenal() {
        return medicacionEnfermedadRenal;
    }

    public void setMedicacionEnfermedadRenal(String medicacionEnfermedadRenal) {
        this.medicacionEnfermedadRenal = medicacionEnfermedadRenal;
    }

    public String getComentariosEnfermedadRenal() {
        return comentariosEnfermedadRenal;
    }

    public void setComentariosEnfermedadRenal(String comentariosEnfermedadRenal) {
        this.comentariosEnfermedadRenal = comentariosEnfermedadRenal;
    }

    public String getFechaDiagnosticoArtritis() {
        return fechaDiagnosticoArtritis;
    }

    public void setFechaDiagnosticoArtritis(String fechaDiagnosticoArtritis) {
        this.fechaDiagnosticoArtritis = fechaDiagnosticoArtritis;
    }

    public String getTratamientoArtritis() {
        return tratamientoArtritis;
    }

    public void setTratamientoArtritis(String tratamientoArtritis) {
        this.tratamientoArtritis = tratamientoArtritis;
    }

    public String getInicioTratamientoArtritis() {
        return inicioTratamientoArtritis;
    }

    public void setInicioTratamientoArtritis(String inicioTratamientoArtritis) {
        this.inicioTratamientoArtritis = inicioTratamientoArtritis;
    }

    public String getHastaTratamientoArtritis() {
        return hastaTratamientoArtritis;
    }

    public void setHastaTratamientoArtritis(String hastaTratamientoArtritis) {
        this.hastaTratamientoArtritis = hastaTratamientoArtritis;
    }

    public String getMedicacionArtritis() {
        return medicacionArtritis;
    }

    public void setMedicacionArtritis(String medicacionArtritis) {
        this.medicacionArtritis = medicacionArtritis;
    }

    public String getComentariosArtritis() {
        return comentariosArtritis;
    }

    public void setComentariosArtritis(String comentariosArtritis) {
        this.comentariosArtritis = comentariosArtritis;
    }

    public String getFechaDiagnosticoUlcerasOrales() {
        return fechaDiagnosticoUlcerasOrales;
    }

    public void setFechaDiagnosticoUlcerasOrales(String fechaDiagnosticoUlcerasOrales) {
        this.fechaDiagnosticoUlcerasOrales = fechaDiagnosticoUlcerasOrales;
    }

    public String getTratamientoUlcerasOrales() {
        return tratamientoUlcerasOrales;
    }

    public void setTratamientoUlcerasOrales(String tratamientoUlcerasOrales) {
        this.tratamientoUlcerasOrales = tratamientoUlcerasOrales;
    }

    public String getInicioTratamientoUlcerasOrales() {
        return inicioTratamientoUlcerasOrales;
    }

    public void setInicioTratamientoUlcerasOrales(String inicioTratamientoUlcerasOrales) {
        this.inicioTratamientoUlcerasOrales = inicioTratamientoUlcerasOrales;
    }

    public String getHastaTratamientoUlcerasOrales() {
        return hastaTratamientoUlcerasOrales;
    }

    public void setHastaTratamientoUlcerasOrales(String hastaTratamientoUlcerasOrales) {
        this.hastaTratamientoUlcerasOrales = hastaTratamientoUlcerasOrales;
    }

    public String getMedicacionUlcerasOrales() {
        return medicacionUlcerasOrales;
    }

    public void setMedicacionUlcerasOrales(String medicacionUlcerasOrales) {
        this.medicacionUlcerasOrales = medicacionUlcerasOrales;
    }

    public String getComentariosUlcerasOrales() {
        return comentariosUlcerasOrales;
    }

    public void setComentariosUlcerasOrales(String comentariosUlcerasOrales) {
        this.comentariosUlcerasOrales = comentariosUlcerasOrales;
    }

    public String getFechaDiagnosticoAsma() {
        return fechaDiagnosticoAsma;
    }

    public void setFechaDiagnosticoAsma(String fechaDiagnosticoAsma) {
        this.fechaDiagnosticoAsma = fechaDiagnosticoAsma;
    }

    public String getTratamientoAsma() {
        return tratamientoAsma;
    }

    public void setTratamientoAsma(String tratamientoAsma) {
        this.tratamientoAsma = tratamientoAsma;
    }

    public String getInicioTratamientoAsma() {
        return inicioTratamientoAsma;
    }

    public void setInicioTratamientoAsma(String inicioTratamientoAsma) {
        this.inicioTratamientoAsma = inicioTratamientoAsma;
    }

    public String getHastaTratamientoAsma() {
        return hastaTratamientoAsma;
    }

    public void setHastaTratamientoAsma(String hastaTratamientoAsma) {
        this.hastaTratamientoAsma = hastaTratamientoAsma;
    }

    public String getMedicacionAsma() {
        return medicacionAsma;
    }

    public void setMedicacionAsma(String medicacionAsma) {
        this.medicacionAsma = medicacionAsma;
    }

    public String getComentariosAsma() {
        return comentariosAsma;
    }

    public void setComentariosAsma(String comentariosAsma) {
        this.comentariosAsma = comentariosAsma;
    }

    public String getFechaDiagnosticoDiabetes() {
        return fechaDiagnosticoDiabetes;
    }

    public void setFechaDiagnosticoDiabetes(String fechaDiagnosticoDiabetes) {
        this.fechaDiagnosticoDiabetes = fechaDiagnosticoDiabetes;
    }

    public String getTratamientoDiabetes() {
        return tratamientoDiabetes;
    }

    public void setTratamientoDiabetes(String tratamientoDiabetes) {
        this.tratamientoDiabetes = tratamientoDiabetes;
    }

    public String getInicioTratamientoDiabetes() {
        return inicioTratamientoDiabetes;
    }

    public void setInicioTratamientoDiabetes(String inicioTratamientoDiabetes) {
        this.inicioTratamientoDiabetes = inicioTratamientoDiabetes;
    }

    public String getHastaTratamientoDiabetes() {
        return hastaTratamientoDiabetes;
    }

    public void setHastaTratamientoDiabetes(String hastaTratamientoDiabetes) {
        this.hastaTratamientoDiabetes = hastaTratamientoDiabetes;
    }

    public String getMedicacionDiabetes() {
        return medicacionDiabetes;
    }

    public void setMedicacionDiabetes(String medicacionDiabetes) {
        this.medicacionDiabetes = medicacionDiabetes;
    }

    public String getComentariosDiabetes() {
        return comentariosDiabetes;
    }

    public void setComentariosDiabetes(String comentariosDiabetes) {
        this.comentariosDiabetes = comentariosDiabetes;
    }

    public String getFechaDiagnosticoHemorragias() {
        return fechaDiagnosticoHemorragias;
    }

    public void setFechaDiagnosticoHemorragias(String fechaDiagnosticoHemorragias) {
        this.fechaDiagnosticoHemorragias = fechaDiagnosticoHemorragias;
    }

    public String getTratamientoHemorragias() {
        return tratamientoHemorragias;
    }

    public void setTratamientoHemorragias(String tratamientoHemorragias) {
        this.tratamientoHemorragias = tratamientoHemorragias;
    }

    public String getInicioTratamientoHemorragias() {
        return inicioTratamientoHemorragias;
    }

    public void setInicioTratamientoHemorragias(String inicioTratamientoHemorragias) {
        this.inicioTratamientoHemorragias = inicioTratamientoHemorragias;
    }

    public String getHastaTratamientoHemorragias() {
        return hastaTratamientoHemorragias;
    }

    public void setHastaTratamientoHemorragias(String hastaTratamientoHemorragias) {
        this.hastaTratamientoHemorragias = hastaTratamientoHemorragias;
    }

    public String getMedicacionHemorragias() {
        return medicacionHemorragias;
    }

    public void setMedicacionHemorragias(String medicacionHemorragias) {
        this.medicacionHemorragias = medicacionHemorragias;
    }

    public String getComentariosHemorragias() {
        return comentariosHemorragias;
    }

    public void setComentariosHemorragias(String comentariosHemorragias) {
        this.comentariosHemorragias = comentariosHemorragias;
    }

    public String getFechaDiagnosticoProblemasEndocrinos() {
        return fechaDiagnosticoProblemasEndocrinos;
    }

    public void setFechaDiagnosticoProblemasEndocrinos(String fechaDiagnosticoProblemasEndocrinos) {
        this.fechaDiagnosticoProblemasEndocrinos = fechaDiagnosticoProblemasEndocrinos;
    }

    public String getTratamientoProblemasEndocrinos() {
        return tratamientoProblemasEndocrinos;
    }

    public void setTratamientoProblemasEndocrinos(String tratamientoProblemasEndocrinos) {
        this.tratamientoProblemasEndocrinos = tratamientoProblemasEndocrinos;
    }

    public String getInicioTratamientoProblemasEndocrinos() {
        return inicioTratamientoProblemasEndocrinos;
    }

    public void setInicioTratamientoProblemasEndocrinos(String inicioTratamientoProblemasEndocrinos) {
        this.inicioTratamientoProblemasEndocrinos = inicioTratamientoProblemasEndocrinos;
    }

    public String getHastaTratamientoProblemasEndocrinos() {
        return hastaTratamientoProblemasEndocrinos;
    }

    public void setHastaTratamientoProblemasEndocrinos(String hastaTratamientoProblemasEndocrinos) {
        this.hastaTratamientoProblemasEndocrinos = hastaTratamientoProblemasEndocrinos;
    }

    public String getMedicacionProblemasEndocrinos() {
        return medicacionProblemasEndocrinos;
    }

    public void setMedicacionProblemasEndocrinos(String medicacionProblemasEndocrinos) {
        this.medicacionProblemasEndocrinos = medicacionProblemasEndocrinos;
    }

    public String getComentariosProblemasEndocrinos() {
        return comentariosProblemasEndocrinos;
    }

    public void setComentariosProblemasEndocrinos(String comentariosProblemasEndocrinos) {
        this.comentariosProblemasEndocrinos = comentariosProblemasEndocrinos;
    }

    public String getFechaDiagnosticoFiebreReumatica() {
        return fechaDiagnosticoFiebreReumatica;
    }

    public void setFechaDiagnosticoFiebreReumatica(String fechaDiagnosticoFiebreReumatica) {
        this.fechaDiagnosticoFiebreReumatica = fechaDiagnosticoFiebreReumatica;
    }

    public String getTratamientoFiebreReumatica() {
        return tratamientoFiebreReumatica;
    }

    public void setTratamientoFiebreReumatica(String tratamientoFiebreReumatica) {
        this.tratamientoFiebreReumatica = tratamientoFiebreReumatica;
    }

    public String getInicioTratamientoFiebreReumatica() {
        return inicioTratamientoFiebreReumatica;
    }

    public void setInicioTratamientoFiebreReumatica(String inicioTratamientoFiebreReumatica) {
        this.inicioTratamientoFiebreReumatica = inicioTratamientoFiebreReumatica;
    }

    public String getHastaTratamientoFiebreReumatica() {
        return hastaTratamientoFiebreReumatica;
    }

    public void setHastaTratamientoFiebreReumatica(String hastaTratamientoFiebreReumatica) {
        this.hastaTratamientoFiebreReumatica = hastaTratamientoFiebreReumatica;
    }

    public String getMedicacionFiebreReumatica() {
        return medicacionFiebreReumatica;
    }

    public void setMedicacionFiebreReumatica(String medicacionFiebreReumatica) {
        this.medicacionFiebreReumatica = medicacionFiebreReumatica;
    }

    public String getComentariosFiebreReumatica() {
        return comentariosFiebreReumatica;
    }

    public void setComentariosFiebreReumatica(String comentariosFiebreReumatica) {
        this.comentariosFiebreReumatica = comentariosFiebreReumatica;
    }

    public String getFechaDiagnosticoCancer() {
        return fechaDiagnosticoCancer;
    }

    public void setFechaDiagnosticoCancer(String fechaDiagnosticoCancer) {
        this.fechaDiagnosticoCancer = fechaDiagnosticoCancer;
    }

    public String getTratamientoCancer() {
        return tratamientoCancer;
    }

    public void setTratamientoCancer(String tratamientoCancer) {
        this.tratamientoCancer = tratamientoCancer;
    }

    public String getInicioTratamientoCancer() {
        return inicioTratamientoCancer;
    }

    public void setInicioTratamientoCancer(String inicioTratamientoCancer) {
        this.inicioTratamientoCancer = inicioTratamientoCancer;
    }

    public String getHastaTratamientoCancer() {
        return hastaTratamientoCancer;
    }

    public void setHastaTratamientoCancer(String hastaTratamientoCancer) {
        this.hastaTratamientoCancer = hastaTratamientoCancer;
    }

    public String getMedicacionCancer() {
        return medicacionCancer;
    }

    public void setMedicacionCancer(String medicacionCancer) {
        this.medicacionCancer = medicacionCancer;
    }

    public String getComentariosCancer() {
        return comentariosCancer;
    }

    public void setComentariosCancer(String comentariosCancer) {
        this.comentariosCancer = comentariosCancer;
    }

    public String getFechaDiagnosticoProblemasPsicologicos() {
        return fechaDiagnosticoProblemasPsicologicos;
    }

    public void setFechaDiagnosticoProblemasPsicologicos(String fechaDiagnosticoProblemasPsicologicos) {
        this.fechaDiagnosticoProblemasPsicologicos = fechaDiagnosticoProblemasPsicologicos;
    }

    public String getTratamientoProblemasPsicologicos() {
        return tratamientoProblemasPsicologicos;
    }

    public void setTratamientoProblemasPsicologicos(String tratamientoProblemasPsicologicos) {
        this.tratamientoProblemasPsicologicos = tratamientoProblemasPsicologicos;
    }

    public String getInicioTratamientoProblemasPsicologicos() {
        return inicioTratamientoProblemasPsicologicos;
    }

    public void setInicioTratamientoProblemasPsicologicos(String inicioTratamientoProblemasPsicologicos) {
        this.inicioTratamientoProblemasPsicologicos = inicioTratamientoProblemasPsicologicos;
    }

    public String getHastaTratamientoProblemasPsicologicos() {
        return hastaTratamientoProblemasPsicologicos;
    }

    public void setHastaTratamientoProblemasPsicologicos(String hastaTratamientoProblemasPsicologicos) {
        this.hastaTratamientoProblemasPsicologicos = hastaTratamientoProblemasPsicologicos;
    }

    public String getMedicacionProblemasPsicologicos() {
        return medicacionProblemasPsicologicos;
    }

    public void setMedicacionProblemasPsicologicos(String medicacionProblemasPsicologicos) {
        this.medicacionProblemasPsicologicos = medicacionProblemasPsicologicos;
    }

    public String getComentariosProblemasPsicologicos() {
        return comentariosProblemasPsicologicos;
    }

    public void setComentariosProblemasPsicologicos(String comentariosProblemasPsicologicos) {
        this.comentariosProblemasPsicologicos = comentariosProblemasPsicologicos;
    }

    public String getFechaDiagnosticoProblemasTiroideos() {
        return fechaDiagnosticoProblemasTiroideos;
    }

    public void setFechaDiagnosticoProblemasTiroideos(String fechaDiagnosticoProblemasTiroideos) {
        this.fechaDiagnosticoProblemasTiroideos = fechaDiagnosticoProblemasTiroideos;
    }

    public String getTratamientoProblemasTiroideos() {
        return tratamientoProblemasTiroideos;
    }

    public void setTratamientoProblemasTiroideos(String tratamientoProblemasTiroideos) {
        this.tratamientoProblemasTiroideos = tratamientoProblemasTiroideos;
    }

    public String getInicioTratamientoProblemasTiroideos() {
        return inicioTratamientoProblemasTiroideos;
    }

    public void setInicioTratamientoProblemasTiroideos(String inicioTratamientoProblemasTiroideos) {
        this.inicioTratamientoProblemasTiroideos = inicioTratamientoProblemasTiroideos;
    }

    public String getHastaTratamientoProblemasTiroideos() {
        return hastaTratamientoProblemasTiroideos;
    }

    public void setHastaTratamientoProblemasTiroideos(String hastaTratamientoProblemasTiroideos) {
        this.hastaTratamientoProblemasTiroideos = hastaTratamientoProblemasTiroideos;
    }

    public String getMedicacionProblemasTiroideos() {
        return medicacionProblemasTiroideos;
    }

    public void setMedicacionProblemasTiroideos(String medicacionProblemasTiroideos) {
        this.medicacionProblemasTiroideos = medicacionProblemasTiroideos;
    }

    public String getComentariosProblemasTiroideos() {
        return comentariosProblemasTiroideos;
    }

    public void setComentariosProblemasTiroideos(String comentariosProblemasTiroideos) {
        this.comentariosProblemasTiroideos = comentariosProblemasTiroideos;
    }

    public String getFechaDiagnosticoProblemasCardiacos() {
        return fechaDiagnosticoProblemasCardiacos;
    }

    public void setFechaDiagnosticoProblemasCardiacos(String fechaDiagnosticoProblemasCardiacos) {
        this.fechaDiagnosticoProblemasCardiacos = fechaDiagnosticoProblemasCardiacos;
    }

    public String getTratamientoProblemasCardiacos() {
        return tratamientoProblemasCardiacos;
    }

    public void setTratamientoProblemasCardiacos(String tratamientoProblemasCardiacos) {
        this.tratamientoProblemasCardiacos = tratamientoProblemasCardiacos;
    }

    public String getInicioTratamientoProblemasCardiacos() {
        return inicioTratamientoProblemasCardiacos;
    }

    public void setInicioTratamientoProblemasCardiacos(String inicioTratamientoProblemasCardiacos) {
        this.inicioTratamientoProblemasCardiacos = inicioTratamientoProblemasCardiacos;
    }

    public String getHastaTratamientoProblemasCardiacos() {
        return hastaTratamientoProblemasCardiacos;
    }

    public void setHastaTratamientoProblemasCardiacos(String hastaTratamientoProblemasCardiacos) {
        this.hastaTratamientoProblemasCardiacos = hastaTratamientoProblemasCardiacos;
    }

    public String getMedicacionProblemasCardiacos() {
        return medicacionProblemasCardiacos;
    }

    public void setMedicacionProblemasCardiacos(String medicacionProblemasCardiacos) {
        this.medicacionProblemasCardiacos = medicacionProblemasCardiacos;
    }

    public String getComentariosProblemasCardiacos() {
        return comentariosProblemasCardiacos;
    }

    public void setComentariosProblemasCardiacos(String comentariosProblemasCardiacos) {
        this.comentariosProblemasCardiacos = comentariosProblemasCardiacos;
    }

    public String getFechaDiagnosticoEpilepsia() {
        return fechaDiagnosticoEpilepsia;
    }

    public void setFechaDiagnosticoEpilepsia(String fechaDiagnosticoEpilepsia) {
        this.fechaDiagnosticoEpilepsia = fechaDiagnosticoEpilepsia;
    }

    public String getTratamientoEpilepsia() {
        return tratamientoEpilepsia;
    }

    public void setTratamientoEpilepsia(String tratamientoEpilepsia) {
        this.tratamientoEpilepsia = tratamientoEpilepsia;
    }

    public String getInicioTratamientoEpilepsia() {
        return inicioTratamientoEpilepsia;
    }

    public void setInicioTratamientoEpilepsia(String inicioTratamientoEpilepsia) {
        this.inicioTratamientoEpilepsia = inicioTratamientoEpilepsia;
    }

    public String getHastaTratamientoEpilepsia() {
        return hastaTratamientoEpilepsia;
    }

    public void setHastaTratamientoEpilepsia(String hastaTratamientoEpilepsia) {
        this.hastaTratamientoEpilepsia = hastaTratamientoEpilepsia;
    }

    public String getMedicacionEpilepsia() {
        return medicacionEpilepsia;
    }

    public void setMedicacionEpilepsia(String medicacionEpilepsia) {
        this.medicacionEpilepsia = medicacionEpilepsia;
    }

    public String getComentariosEpilepsia() {
        return comentariosEpilepsia;
    }

    public void setComentariosEpilepsia(String comentariosEpilepsia) {
        this.comentariosEpilepsia = comentariosEpilepsia;
    }

    public String getFechaDiagnosticoTuberculosis() {
        return fechaDiagnosticoTuberculosis;
    }

    public void setFechaDiagnosticoTuberculosis(String fechaDiagnosticoTuberculosis) {
        this.fechaDiagnosticoTuberculosis = fechaDiagnosticoTuberculosis;
    }

    public String getTratamientoTuberculosis() {
        return tratamientoTuberculosis;
    }

    public void setTratamientoTuberculosis(String tratamientoTuberculosis) {
        this.tratamientoTuberculosis = tratamientoTuberculosis;
    }

    public String getInicioTratamientoTuberculosis() {
        return inicioTratamientoTuberculosis;
    }

    public void setInicioTratamientoTuberculosis(String inicioTratamientoTuberculosis) {
        this.inicioTratamientoTuberculosis = inicioTratamientoTuberculosis;
    }

    public String getHastaTratamientoTuberculosis() {
        return hastaTratamientoTuberculosis;
    }

    public void setHastaTratamientoTuberculosis(String hastaTratamientoTuberculosis) {
        this.hastaTratamientoTuberculosis = hastaTratamientoTuberculosis;
    }

    public String getMedicacionTuberculosis() {
        return medicacionTuberculosis;
    }

    public void setMedicacionTuberculosis(String medicacionTuberculosis) {
        this.medicacionTuberculosis = medicacionTuberculosis;
    }

    public String getComentariosTuberculosis() {
        return comentariosTuberculosis;
    }

    public void setComentariosTuberculosis(String comentariosTuberculosis) {
        this.comentariosTuberculosis = comentariosTuberculosis;
    }

    public String getFechaDiagnosticoOsteoporosis() {
        return fechaDiagnosticoOsteoporosis;
    }

    public void setFechaDiagnosticoOsteoporosis(String fechaDiagnosticoOsteoporosis) {
        this.fechaDiagnosticoOsteoporosis = fechaDiagnosticoOsteoporosis;
    }

    public String getTratamientoOsteoporosis() {
        return tratamientoOsteoporosis;
    }

    public void setTratamientoOsteoporosis(String tratamientoOsteoporosis) {
        this.tratamientoOsteoporosis = tratamientoOsteoporosis;
    }

    public String getInicioTratamientoOsteoporosis() {
        return inicioTratamientoOsteoporosis;
    }

    public void setInicioTratamientoOsteoporosis(String inicioTratamientoOsteoporosis) {
        this.inicioTratamientoOsteoporosis = inicioTratamientoOsteoporosis;
    }

    public String getHastaTratamientoOsteoporosis() {
        return hastaTratamientoOsteoporosis;
    }

    public void setHastaTratamientoOsteoporosis(String hastaTratamientoOsteoporosis) {
        this.hastaTratamientoOsteoporosis = hastaTratamientoOsteoporosis;
    }

    public String getMedicacionOsteoporosis() {
        return medicacionOsteoporosis;
    }

    public void setMedicacionOsteoporosis(String medicacionOsteoporosis) {
        this.medicacionOsteoporosis = medicacionOsteoporosis;
    }

    public String getComentariosOsteoporosis() {
        return comentariosOsteoporosis;
    }

    public void setComentariosOsteoporosis(String comentariosOsteoporosis) {
        this.comentariosOsteoporosis = comentariosOsteoporosis;
    }

    public String getFechaDiagnosticoHipertension() {
        return fechaDiagnosticoHipertension;
    }

    public void setFechaDiagnosticoHipertension(String fechaDiagnosticoHipertension) {
        this.fechaDiagnosticoHipertension = fechaDiagnosticoHipertension;
    }

    public String getTratamientoHipertension() {
        return tratamientoHipertension;
    }

    public void setTratamientoHipertension(String tratamientoHipertension) {
        this.tratamientoHipertension = tratamientoHipertension;
    }

    public String getInicioTratamientoHipertension() {
        return inicioTratamientoHipertension;
    }

    public void setInicioTratamientoHipertension(String inicioTratamientoHipertension) {
        this.inicioTratamientoHipertension = inicioTratamientoHipertension;
    }

    public String getHastaTratamientoHipertension() {
        return hastaTratamientoHipertension;
    }

    public void setHastaTratamientoHipertension(String hastaTratamientoHipertension) {
        this.hastaTratamientoHipertension = hastaTratamientoHipertension;
    }

    public String getMedicacionHipertension() {
        return medicacionHipertension;
    }

    public void setMedicacionHipertension(String medicacionHipertension) {
        this.medicacionHipertension = medicacionHipertension;
    }

    public String getComentariosHipertension() {
        return comentariosHipertension;
    }

    public void setComentariosHipertension(String comentariosHipertension) {
        this.comentariosHipertension = comentariosHipertension;
    }

    public String getFechaDiagnosticoProblemasPsiquiatricos() {
        return fechaDiagnosticoProblemasPsiquiatricos;
    }

    public void setFechaDiagnosticoProblemasPsiquiatricos(String fechaDiagnosticoProblemasPsiquiatricos) {
        this.fechaDiagnosticoProblemasPsiquiatricos = fechaDiagnosticoProblemasPsiquiatricos;
    }

    public String getTratamientoProblemasPsiquiatricos() {
        return tratamientoProblemasPsiquiatricos;
    }

    public void setTratamientoProblemasPsiquiatricos(String tratamientoProblemasPsiquiatricos) {
        this.tratamientoProblemasPsiquiatricos = tratamientoProblemasPsiquiatricos;
    }

    public String getInicioTratamientoProblemasPsiquiatricos() {
        return inicioTratamientoProblemasPsiquiatricos;
    }

    public void setInicioTratamientoProblemasPsiquiatricos(String inicioTratamientoProblemasPsiquiatricos) {
        this.inicioTratamientoProblemasPsiquiatricos = inicioTratamientoProblemasPsiquiatricos;
    }

    public String getHastaTratamientoProblemasPsiquiatricos() {
        return hastaTratamientoProblemasPsiquiatricos;
    }

    public void setHastaTratamientoProblemasPsiquiatricos(String hastaTratamientoProblemasPsiquiatricos) {
        this.hastaTratamientoProblemasPsiquiatricos = hastaTratamientoProblemasPsiquiatricos;
    }

    public String getMedicacionProblemasPsiquiatricos() {
        return medicacionProblemasPsiquiatricos;
    }

    public void setMedicacionProblemasPsiquiatricos(String medicacionProblemasPsiquiatricos) {
        this.medicacionProblemasPsiquiatricos = medicacionProblemasPsiquiatricos;
    }

    public String getComentariosProblemasPsiquiatricos() {
        return comentariosProblemasPsiquiatricos;
    }

    public void setComentariosProblemasPsiquiatricos(String comentariosProblemasPsiquiatricos) {
        this.comentariosProblemasPsiquiatricos = comentariosProblemasPsiquiatricos;
    }

    public String getFractura() {
        return fractura;
    }

    public void setFractura(String fractura) {
        this.fractura = fractura;
    }

    public String getFechaFractura() {
        return fechaFractura;
    }

    public void setFechaFractura(String fechaFractura) {
        this.fechaFractura = fechaFractura;
    }

    public String getCadera() {
        return cadera;
    }

    public void setCadera(String cadera) {
        this.cadera = cadera;
    }

    public String getTobillo() {
        return tobillo;
    }

    public void setTobillo(String tobillo) {
        this.tobillo = tobillo;
    }

    public String getFemur() {
        return femur;
    }

    public void setFemur(String femur) {
        this.femur = femur;
    }

    public String getMuneca() {
        return muneca;
    }

    public void setMuneca(String muneca) {
        this.muneca = muneca;
    }

    public String getAntebrazo() {
        return antebrazo;
    }

    public void setAntebrazo(String antebrazo) {
        this.antebrazo = antebrazo;
    }

    public String getVertebra() {
        return vertebra;
    }

    public void setVertebra(String vertebra) {
        this.vertebra = vertebra;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public String getOtraFractura() {
        return otraFractura;
    }

    public void setOtraFractura(String otraFractura) {
        this.otraFractura = otraFractura;
    }

    public String getOtraFracturaComentarios() {
        return otraFracturaComentarios;
    }

    public void setOtraFracturaComentarios(String otraFracturaComentarios) {
        this.otraFracturaComentarios = otraFracturaComentarios;
    }

    public String getCausaFractura() {
        return causaFractura;
    }

    public void setCausaFractura(String causaFractura) {
        this.causaFractura = causaFractura;
    }

    public String getRecuperacionPostFractura() {
        return recuperacionPostFractura;
    }

    public void setRecuperacionPostFractura(String recuperacionPostFractura) {
        this.recuperacionPostFractura = recuperacionPostFractura;
    }

    public String getIncapacidadTotal() {
        return incapacidadTotal;
    }

    public void setIncapacidadTotal(String incapacidadTotal) {
        this.incapacidadTotal = incapacidadTotal;
    }

    public String getUnidadIncapacidadTotal() {
        return unidadIncapacidadTotal;
    }

    public void setUnidadIncapacidadTotal(String unidadIncapacidadTotal) {
        this.unidadIncapacidadTotal = unidadIncapacidadTotal;
    }

    public String getOtrosAntecedentesTraumatologicos() {
        return otrosAntecedentesTraumatologicos;
    }

    public void setOtrosAntecedentesTraumatologicos(String otrosAntecedentesTraumatologicos) {
        this.otrosAntecedentesTraumatologicos = otrosAntecedentesTraumatologicos;
    }

    public String getMenarquia() {
        return menarquia;
    }

    public void setMenarquia(String menarquia) {
        this.menarquia = menarquia;
    }

    public String getMenopausia() {
        return menopausia;
    }

    public void setMenopausia(String menopausia) {
        this.menopausia = menopausia;
    }

    public String getHisterectomia() {
        return histerectomia;
    }

    public void setHisterectomia(String histerectomia) {
        this.histerectomia = histerectomia;
    }

    public String getEmbarazos() {
        return embarazos;
    }

    public void setEmbarazos(String embarazos) {
        this.embarazos = embarazos;
    }

    public String getPartos() {
        return partos;
    }

    public void setPartos(String partos) {
        this.partos = partos;
    }

    public String getAbortos() {
        return abortos;
    }

    public void setAbortos(String abortos) {
        this.abortos = abortos;
    }

    public String getHijosVivos() {
        return hijosVivos;
    }

    public void setHijosVivos(String hijosVivos) {
        this.hijosVivos = hijosVivos;
    }

    public String getCiclos() {
        return ciclos;
    }

    public void setCiclos(String ciclos) {
        this.ciclos = ciclos;
    }

    public String getUr() {
        return ur;
    }

    public void setUr(String ur) {
        this.ur = ur;
    }

    public String getInfertilidad() {
        return infertilidad;
    }

    public void setInfertilidad(String infertilidad) {
        this.infertilidad = infertilidad;
    }

    public String getLactancia() {
        return lactancia;
    }

    public void setLactancia(String lactancia) {
        this.lactancia = lactancia;
    }

    public String getTotalLactancia() {
        return totalLactancia;
    }

    public void setTotalLactancia(String totalLactancia) {
        this.totalLactancia = totalLactancia;
    }

    public String getEdadDeLosHijos() {
        return edadDeLosHijos;
    }

    public void setEdadDeLosHijos(String edadDeLosHijos) {
        this.edadDeLosHijos = edadDeLosHijos;
    }

    public String getTabaquismo() {
        return tabaquismo;
    }

    public void setTabaquismo(String tabaquismo) {
        this.tabaquismo = tabaquismo;
    }

    public String getFumadorPasivo() {
        return fumadorPasivo;
    }

    public void setFumadorPasivo(String fumadorPasivo) {
        this.fumadorPasivo = fumadorPasivo;
    }

    public String getFumaDesde() {
        return fumaDesde;
    }

    public void setFumaDesde(String fumaDesde) {
        this.fumaDesde = fumaDesde;
    }

    public String getFrecuenciaTabaquismo() {
        return frecuenciaTabaquismo;
    }

    public void setFrecuenciaTabaquismo(String frecuenciaTabaquismo) {
        this.frecuenciaTabaquismo = frecuenciaTabaquismo;
    }

    public String getLicor() {
        return licor;
    }

    public void setLicor(String licor) {
        this.licor = licor;
    }

    public String getFrecuenciaLicor() {
        return frecuenciaLicor;
    }

    public void setFrecuenciaLicor(String frecuenciaLicor) {
        this.frecuenciaLicor = frecuenciaLicor;
    }

    public String getCerveza() {
        return cerveza;
    }

    public void setCerveza(String cerveza) {
        this.cerveza = cerveza;
    }

    public String getVino() {
        return vino;
    }

    public void setVino(String vino) {
        this.vino = vino;
    }

    public String getRon() {
        return ron;
    }

    public void setRon(String ron) {
        this.ron = ron;
    }

    public String getWhiskey() {
        return whiskey;
    }

    public void setWhiskey(String whiskey) {
        this.whiskey = whiskey;
    }

    public String getAguardiente() {
        return aguardiente;
    }

    public void setAguardiente(String aguardiente) {
        this.aguardiente = aguardiente;
    }

    public String getOtrosLicores() {
        return otrosLicores;
    }

    public void setOtrosLicores(String otrosLicores) {
        this.otrosLicores = otrosLicores;
    }

    public String getCafe() {
        return cafe;
    }

    public void setCafe(String cafe) {
        this.cafe = cafe;
    }

    public String getFrecuenciaCafe() {
        return frecuenciaCafe;
    }

    public void setFrecuenciaCafe(String frecuenciaCafe) {
        this.frecuenciaCafe = frecuenciaCafe;
    }

    public String getOtroCafe() {
        return otroCafe;
    }

    public void setOtroCafe(String otroCafe) {
        this.otroCafe = otroCafe;
    }

    public String getInicioCafe() {
        return inicioCafe;
    }

    public void setInicioCafe(String inicioCafe) {
        this.inicioCafe = inicioCafe;
    }

    public String getLecheDerivados() {
        return lecheDerivados;
    }

    public void setLecheDerivados(String lecheDerivados) {
        this.lecheDerivados = lecheDerivados;
    }

    public String getFrecuenciaLecheDerivados() {
        return frecuenciaLecheDerivados;
    }

    public void setFrecuenciaLecheDerivados(String frecuenciaLecheDerivados) {
        this.frecuenciaLecheDerivados = frecuenciaLecheDerivados;
    }

    public String getOtroLecheDerivado() {
        return otroLecheDerivado;
    }

    public void setOtroLecheDerivado(String otroLecheDerivado) {
        this.otroLecheDerivado = otroLecheDerivado;
    }

    public String getInicioLecheDerivado() {
        return inicioLecheDerivado;
    }

    public void setInicioLecheDerivado(String inicioLecheDerivado) {
        this.inicioLecheDerivado = inicioLecheDerivado;
    }

    public String getFrutasFrescas() {
        return frutasFrescas;
    }

    public void setFrutasFrescas(String frutasFrescas) {
        this.frutasFrescas = frutasFrescas;
    }

    public String getQueClasesFrutasFrescas() {
        return queClasesFrutasFrescas;
    }

    public void setQueClasesFrutasFrescas(String queClasesFrutasFrescas) {
        this.queClasesFrutasFrescas = queClasesFrutasFrescas;
    }

    public String getPorcionesFrutasFrescas() {
        return porcionesFrutasFrescas;
    }

    public void setPorcionesFrutasFrescas(String porcionesFrutasFrescas) {
        this.porcionesFrutasFrescas = porcionesFrutasFrescas;
    }

    public String getRealizaEjercicio() {
        return realizaEjercicio;
    }

    public void setRealizaEjercicio(String realizaEjercicio) {
        this.realizaEjercicio = realizaEjercicio;
    }

    public String getFrecuenciaEjercicio() {
        return frecuenciaEjercicio;
    }

    public void setFrecuenciaEjercicio(String frecuenciaEjercicio) {
        this.frecuenciaEjercicio = frecuenciaEjercicio;
    }

    public String getPescados() {
        return pescados;
    }

    public void setPescados(String pescados) {
        this.pescados = pescados;
    }

    public String getPescadoRio() {
        return pescadoRio;
    }

    public void setPescadoRio(String pescadoRio) {
        this.pescadoRio = pescadoRio;
    }

    public String getClasePescadoRio() {
        return clasePescadoRio;
    }

    public void setClasePescadoRio(String clasePescadoRio) {
        this.clasePescadoRio = clasePescadoRio;
    }

    public String getVecesPescadoRio() {
        return vecesPescadoRio;
    }

    public void setVecesPescadoRio(String vecesPescadoRio) {
        this.vecesPescadoRio = vecesPescadoRio;
    }

    public String getDesdePescadoRio() {
        return desdePescadoRio;
    }

    public void setDesdePescadoRio(String desdePescadoRio) {
        this.desdePescadoRio = desdePescadoRio;
    }

    public String getFrecuenciaPescadoRio() {
        return frecuenciaPescadoRio;
    }

    public void setFrecuenciaPescadoRio(String frecuenciaPescadoRio) {
        this.frecuenciaPescadoRio = frecuenciaPescadoRio;
    }

    public String getHastaPescadoRio() {
        return hastaPescadoRio;
    }

    public void setHastaPescadoRio(String hastaPescadoRio) {
        this.hastaPescadoRio = hastaPescadoRio;
    }

    public String getPescadoMar() {
        return pescadoMar;
    }

    public void setPescadoMar(String pescadoMar) {
        this.pescadoMar = pescadoMar;
    }

    public String getBlanco() {
        return blanco;
    }

    public void setBlanco(String blanco) {
        this.blanco = blanco;
    }

    public String getClasePescadoMarBlanco() {
        return clasePescadoMarBlanco;
    }

    public void setClasePescadoMarBlanco(String clasePescadoMarBlanco) {
        this.clasePescadoMarBlanco = clasePescadoMarBlanco;
    }

    public String getVecesPescadoMarBlanco() {
        return vecesPescadoMarBlanco;
    }

    public void setVecesPescadoMarBlanco(String vecesPescadoMarBlanco) {
        this.vecesPescadoMarBlanco = vecesPescadoMarBlanco;
    }

    public String getDesdePescadoMarBlanco() {
        return desdePescadoMarBlanco;
    }

    public void setDesdePescadoMarBlanco(String desdePescadoMarBlanco) {
        this.desdePescadoMarBlanco = desdePescadoMarBlanco;
    }

    public String getFrecuenciaPescadoMarBlanco() {
        return frecuenciaPescadoMarBlanco;
    }

    public void setFrecuenciaPescadoMarBlanco(String frecuenciaPescadoMarBlanco) {
        this.frecuenciaPescadoMarBlanco = frecuenciaPescadoMarBlanco;
    }

    public String getHastaPescadoMarblanco() {
        return hastaPescadoMarblanco;
    }

    public void setHastaPescadoMarblanco(String hastaPescadoMarblanco) {
        this.hastaPescadoMarblanco = hastaPescadoMarblanco;
    }

    public String getAzules() {
        return azules;
    }

    public void setAzules(String azules) {
        this.azules = azules;
    }

    public String getClasePescadoMarAzules() {
        return clasePescadoMarAzules;
    }

    public void setClasePescadoMarAzules(String clasePescadoMarAzules) {
        this.clasePescadoMarAzules = clasePescadoMarAzules;
    }

    public String getVecesPescadoMarAzules() {
        return vecesPescadoMarAzules;
    }

    public void setVecesPescadoMarAzules(String vecesPescadoMarAzules) {
        this.vecesPescadoMarAzules = vecesPescadoMarAzules;
    }

    public String getDesdePescadoMarAzules() {
        return desdePescadoMarAzules;
    }

    public void setDesdePescadoMarAzules(String desdePescadoMarAzules) {
        this.desdePescadoMarAzules = desdePescadoMarAzules;
    }

    public String getFrecuenciaPescadoMarAzules() {
        return frecuenciaPescadoMarAzules;
    }

    public void setFrecuenciaPescadoMarAzules(String frecuenciaPescadoMarAzules) {
        this.frecuenciaPescadoMarAzules = frecuenciaPescadoMarAzules;
    }

    public String getHastaPescadoMarAzules() {
        return hastaPescadoMarAzules;
    }

    public void setHastaPescadoMarAzules(String hastaPescadoMarAzules) {
        this.hastaPescadoMarAzules = hastaPescadoMarAzules;
    }

    public String getAntecedentesQuirurgicos() {
        return antecedentesQuirurgicos;
    }

    public void setAntecedentesQuirurgicos(String antecedentesQuirurgicos) {
        this.antecedentesQuirurgicos = antecedentesQuirurgicos;
    }

    public String getOtrosTratamientosAntecedentesQuirurgicos() {
        return otrosTratamientosAntecedentesQuirurgicos;
    }

    public void setOtrosTratamientosAntecedentesQuirurgicos(String otrosTratamientosAntecedentesQuirurgicos) {
        this.otrosTratamientosAntecedentesQuirurgicos = otrosTratamientosAntecedentesQuirurgicos;
    }

    public String getComentariosAntecedentesQuirurgicos() {
        return comentariosAntecedentesQuirurgicos;
    }

    public void setComentariosAntecedentesQuirurgicos(String comentariosAntecedentesQuirurgicos) {
        this.comentariosAntecedentesQuirurgicos = comentariosAntecedentesQuirurgicos;
    }

    public String getDiabetesPadre() {
        return diabetesPadre;
    }

    public void setDiabetesPadre(String diabetesPadre) {
        this.diabetesPadre = diabetesPadre;
    }

    public String getDiabetesMadre() {
        return diabetesMadre;
    }

    public void setDiabetesMadre(String diabetesMadre) {
        this.diabetesMadre = diabetesMadre;
    }

    public String getDiabetesHijo() {
        return diabetesHijo;
    }

    public void setDiabetesHijo(String diabetesHijo) {
        this.diabetesHijo = diabetesHijo;
    }

    public String getDiabetesTioP() {
        return diabetesTioP;
    }

    public void setDiabetesTioP(String diabetesTioP) {
        this.diabetesTioP = diabetesTioP;
    }

    public String getDiabetesTioM() {
        return diabetesTioM;
    }

    public void setDiabetesTioM(String diabetesTioM) {
        this.diabetesTioM = diabetesTioM;
    }

    public String getDiabetesHnos() {
        return diabetesHnos;
    }

    public void setDiabetesHnos(String diabetesHnos) {
        this.diabetesHnos = diabetesHnos;
    }

    public String getDiabetesAbueloP() {
        return diabetesAbueloP;
    }

    public void setDiabetesAbueloP(String diabetesAbueloP) {
        this.diabetesAbueloP = diabetesAbueloP;
    }

    public String getDiabetesAbueloM() {
        return diabetesAbueloM;
    }

    public void setDiabetesAbueloM(String diabetesAbueloM) {
        this.diabetesAbueloM = diabetesAbueloM;
    }

    public String getDiabetesNinguno() {
        return diabetesNinguno;
    }

    public void setDiabetesNinguno(String diabetesNinguno) {
        this.diabetesNinguno = diabetesNinguno;
    }

    public String getObesidadPadre() {
        return obesidadPadre;
    }

    public void setObesidadPadre(String obesidadPadre) {
        this.obesidadPadre = obesidadPadre;
    }

    public String getObesidadMadre() {
        return obesidadMadre;
    }

    public void setObesidadMadre(String obesidadMadre) {
        this.obesidadMadre = obesidadMadre;
    }

    public String getObesidadHijo() {
        return obesidadHijo;
    }

    public void setObesidadHijo(String obesidadHijo) {
        this.obesidadHijo = obesidadHijo;
    }

    public String getObesidadTioP() {
        return obesidadTioP;
    }

    public void setObesidadTioP(String obesidadTioP) {
        this.obesidadTioP = obesidadTioP;
    }

    public String getObesidadTioM() {
        return obesidadTioM;
    }

    public void setObesidadTioM(String obesidadTioM) {
        this.obesidadTioM = obesidadTioM;
    }

    public String getObesidadHnos() {
        return obesidadHnos;
    }

    public void setObesidadHnos(String obesidadHnos) {
        this.obesidadHnos = obesidadHnos;
    }

    public String getObesidadAbueloP() {
        return obesidadAbueloP;
    }

    public void setObesidadAbueloP(String obesidadAbueloP) {
        this.obesidadAbueloP = obesidadAbueloP;
    }

    public String getObesidadAbueloM() {
        return obesidadAbueloM;
    }

    public void setObesidadAbueloM(String obesidadAbueloM) {
        this.obesidadAbueloM = obesidadAbueloM;
    }

    public String getObesidadNinguno() {
        return obesidadNinguno;
    }

    public void setObesidadNinguno(String obesidadNinguno) {
        this.obesidadNinguno = obesidadNinguno;
    }

    public String getColesterolPadre() {
        return colesterolPadre;
    }

    public void setColesterolPadre(String colesterolPadre) {
        this.colesterolPadre = colesterolPadre;
    }

    public String getColesterolMadre() {
        return colesterolMadre;
    }

    public void setColesterolMadre(String colesterolMadre) {
        this.colesterolMadre = colesterolMadre;
    }

    public String getColesterolHijo() {
        return colesterolHijo;
    }

    public void setColesterolHijo(String colesterolHijo) {
        this.colesterolHijo = colesterolHijo;
    }

    public String getColesterolTioP() {
        return colesterolTioP;
    }

    public void setColesterolTioP(String colesterolTioP) {
        this.colesterolTioP = colesterolTioP;
    }

    public String getColesterolTioM() {
        return colesterolTioM;
    }

    public void setColesterolTioM(String colesterolTioM) {
        this.colesterolTioM = colesterolTioM;
    }

    public String getColesterolHnos() {
        return colesterolHnos;
    }

    public void setColesterolHnos(String colesterolHnos) {
        this.colesterolHnos = colesterolHnos;
    }

    public String getColesterolAbueloP() {
        return colesterolAbueloP;
    }

    public void setColesterolAbueloP(String colesterolAbueloP) {
        this.colesterolAbueloP = colesterolAbueloP;
    }

    public String getColesterolAbueloM() {
        return colesterolAbueloM;
    }

    public void setColesterolAbueloM(String colesterolAbueloM) {
        this.colesterolAbueloM = colesterolAbueloM;
    }

    public String getColesterolNinguno() {
        return colesterolNinguno;
    }

    public void setColesterolNinguno(String colesterolNinguno) {
        this.colesterolNinguno = colesterolNinguno;
    }

    public String getTrigliceridosPadre() {
        return trigliceridosPadre;
    }

    public void setTrigliceridosPadre(String trigliceridosPadre) {
        this.trigliceridosPadre = trigliceridosPadre;
    }

    public String getTrigliceridosMadre() {
        return trigliceridosMadre;
    }

    public void setTrigliceridosMadre(String trigliceridosMadre) {
        this.trigliceridosMadre = trigliceridosMadre;
    }

    public String getTrigliceridosHijo() {
        return trigliceridosHijo;
    }

    public void setTrigliceridosHijo(String trigliceridosHijo) {
        this.trigliceridosHijo = trigliceridosHijo;
    }

    public String getTrigliceridosTioP() {
        return trigliceridosTioP;
    }

    public void setTrigliceridosTioP(String trigliceridosTioP) {
        this.trigliceridosTioP = trigliceridosTioP;
    }

    public String getTrigliceridosTioM() {
        return trigliceridosTioM;
    }

    public void setTrigliceridosTioM(String trigliceridosTioM) {
        this.trigliceridosTioM = trigliceridosTioM;
    }

    public String getTrigliceridosHnos() {
        return trigliceridosHnos;
    }

    public void setTrigliceridosHnos(String trigliceridosHnos) {
        this.trigliceridosHnos = trigliceridosHnos;
    }

    public String getTrigliceridosAbueloP() {
        return trigliceridosAbueloP;
    }

    public void setTrigliceridosAbueloP(String trigliceridosAbueloP) {
        this.trigliceridosAbueloP = trigliceridosAbueloP;
    }

    public String getTrigliceridosAbueloM() {
        return trigliceridosAbueloM;
    }

    public void setTrigliceridosAbueloM(String trigliceridosAbueloM) {
        this.trigliceridosAbueloM = trigliceridosAbueloM;
    }

    public String getTrigliceridosNinguno() {
        return trigliceridosNinguno;
    }

    public void setTrigliceridosNinguno(String trigliceridosNinguno) {
        this.trigliceridosNinguno = trigliceridosNinguno;
    }

    public String getInfartosPadre() {
        return infartosPadre;
    }

    public void setInfartosPadre(String infartosPadre) {
        this.infartosPadre = infartosPadre;
    }

    public String getInfartosMadre() {
        return infartosMadre;
    }

    public void setInfartosMadre(String infartosMadre) {
        this.infartosMadre = infartosMadre;
    }

    public String getInfartosHijo() {
        return infartosHijo;
    }

    public void setInfartosHijo(String infartosHijo) {
        this.infartosHijo = infartosHijo;
    }

    public String getInfartosTioP() {
        return infartosTioP;
    }

    public void setInfartosTioP(String infartosTioP) {
        this.infartosTioP = infartosTioP;
    }

    public String getInfartosTioM() {
        return infartosTioM;
    }

    public void setInfartosTioM(String infartosTioM) {
        this.infartosTioM = infartosTioM;
    }

    public String getInfartosHnos() {
        return infartosHnos;
    }

    public void setInfartosHnos(String infartosHnos) {
        this.infartosHnos = infartosHnos;
    }

    public String getInfartosAbueloP() {
        return infartosAbueloP;
    }

    public void setInfartosAbueloP(String infartosAbueloP) {
        this.infartosAbueloP = infartosAbueloP;
    }

    public String getInfartosAbueloM() {
        return infartosAbueloM;
    }

    public void setInfartosAbueloM(String infartosAbueloM) {
        this.infartosAbueloM = infartosAbueloM;
    }

    public String getInfartosNinguno() {
        return infartosNinguno;
    }

    public void setInfartosNinguno(String infartosNinguno) {
        this.infartosNinguno = infartosNinguno;
    }

    public String getHipertensionPadre() {
        return hipertensionPadre;
    }

    public void setHipertensionPadre(String hipertensionPadre) {
        this.hipertensionPadre = hipertensionPadre;
    }

    public String getHipertensionMadre() {
        return hipertensionMadre;
    }

    public void setHipertensionMadre(String hipertensionMadre) {
        this.hipertensionMadre = hipertensionMadre;
    }

    public String getHipertensionHijo() {
        return hipertensionHijo;
    }

    public void setHipertensionHijo(String hipertensionHijo) {
        this.hipertensionHijo = hipertensionHijo;
    }

    public String getHipertensionTioP() {
        return hipertensionTioP;
    }

    public void setHipertensionTioP(String hipertensionTioP) {
        this.hipertensionTioP = hipertensionTioP;
    }

    public String getHipertensionTioM() {
        return hipertensionTioM;
    }

    public void setHipertensionTioM(String hipertensionTioM) {
        this.hipertensionTioM = hipertensionTioM;
    }

    public String getHipertensionHnos() {
        return hipertensionHnos;
    }

    public void setHipertensionHnos(String hipertensionHnos) {
        this.hipertensionHnos = hipertensionHnos;
    }

    public String getHipertensionAbueloP() {
        return hipertensionAbueloP;
    }

    public void setHipertensionAbueloP(String hipertensionAbueloP) {
        this.hipertensionAbueloP = hipertensionAbueloP;
    }

    public String getHipertensionAbueloM() {
        return hipertensionAbueloM;
    }

    public void setHipertensionAbueloM(String hipertensionAbueloM) {
        this.hipertensionAbueloM = hipertensionAbueloM;
    }

    public String getHipertensionNinguno() {
        return hipertensionNinguno;
    }

    public void setHipertensionNinguno(String hipertensionNinguno) {
        this.hipertensionNinguno = hipertensionNinguno;
    }

    public String getCancerPadre() {
        return cancerPadre;
    }

    public void setCancerPadre(String cancerPadre) {
        this.cancerPadre = cancerPadre;
    }

    public String getCancerMadre() {
        return cancerMadre;
    }

    public void setCancerMadre(String cancerMadre) {
        this.cancerMadre = cancerMadre;
    }

    public String getCancerHijo() {
        return cancerHijo;
    }

    public void setCancerHijo(String cancerHijo) {
        this.cancerHijo = cancerHijo;
    }

    public String getCancerTioP() {
        return cancerTioP;
    }

    public void setCancerTioP(String cancerTioP) {
        this.cancerTioP = cancerTioP;
    }

    public String getCancerTioM() {
        return cancerTioM;
    }

    public void setCancerTioM(String cancerTioM) {
        this.cancerTioM = cancerTioM;
    }

    public String getCancerHnos() {
        return cancerHnos;
    }

    public void setCancerHnos(String cancerHnos) {
        this.cancerHnos = cancerHnos;
    }

    public String getCancerAbueloP() {
        return cancerAbueloP;
    }

    public void setCancerAbueloP(String cancerAbueloP) {
        this.cancerAbueloP = cancerAbueloP;
    }

    public String getCancerAbueloM() {
        return cancerAbueloM;
    }

    public void setCancerAbueloM(String cancerAbueloM) {
        this.cancerAbueloM = cancerAbueloM;
    }

    public String getCancerNinguno() {
        return cancerNinguno;
    }

    public void setCancerNinguno(String cancerNinguno) {
        this.cancerNinguno = cancerNinguno;
    }

    public String getOsteoporosisPadre() {
        return osteoporosisPadre;
    }

    public void setOsteoporosisPadre(String osteoporosisPadre) {
        this.osteoporosisPadre = osteoporosisPadre;
    }

    public String getOsteoporosisMadre() {
        return osteoporosisMadre;
    }

    public void setOsteoporosisMadre(String osteoporosisMadre) {
        this.osteoporosisMadre = osteoporosisMadre;
    }

    public String getOsteoporosisHijo() {
        return osteoporosisHijo;
    }

    public void setOsteoporosisHijo(String osteoporosisHijo) {
        this.osteoporosisHijo = osteoporosisHijo;
    }

    public String getOsteoporosisTioP() {
        return osteoporosisTioP;
    }

    public void setOsteoporosisTioP(String osteoporosisTioP) {
        this.osteoporosisTioP = osteoporosisTioP;
    }

    public String getOsteoporosisTioM() {
        return osteoporosisTioM;
    }

    public void setOsteoporosisTioM(String osteoporosisTioM) {
        this.osteoporosisTioM = osteoporosisTioM;
    }

    public String getOsteoporosisHnos() {
        return osteoporosisHnos;
    }

    public void setOsteoporosisHnos(String osteoporosisHnos) {
        this.osteoporosisHnos = osteoporosisHnos;
    }

    public String getOsteoporosisAbueloP() {
        return osteoporosisAbueloP;
    }

    public void setOsteoporosisAbueloP(String osteoporosisAbueloP) {
        this.osteoporosisAbueloP = osteoporosisAbueloP;
    }

    public String getOsteoporosisAbueloM() {
        return osteoporosisAbueloM;
    }

    public void setOsteoporosisAbueloM(String osteoporosisAbueloM) {
        this.osteoporosisAbueloM = osteoporosisAbueloM;
    }

    public String getOsteoporosisNinguno() {
        return osteoporosisNinguno;
    }

    public void setOsteoporosisNinguno(String osteoporosisNinguno) {
        this.osteoporosisNinguno = osteoporosisNinguno;
    }

    public String getOtrosPadre() {
        return otrosPadre;
    }

    public void setOtrosPadre(String otrosPadre) {
        this.otrosPadre = otrosPadre;
    }

    public String getOtrosMadre() {
        return otrosMadre;
    }

    public void setOtrosMadre(String otrosMadre) {
        this.otrosMadre = otrosMadre;
    }

    public String getOtrosHijo() {
        return otrosHijo;
    }

    public void setOtrosHijo(String otrosHijo) {
        this.otrosHijo = otrosHijo;
    }

    public String getOtrosTioP() {
        return otrosTioP;
    }

    public void setOtrosTioP(String otrosTioP) {
        this.otrosTioP = otrosTioP;
    }

    public String getOtrosTioM() {
        return otrosTioM;
    }

    public void setOtrosTioM(String otrosTioM) {
        this.otrosTioM = otrosTioM;
    }

    public String getOtrosHnos() {
        return otrosHnos;
    }

    public void setOtrosHnos(String otrosHnos) {
        this.otrosHnos = otrosHnos;
    }

    public String getOtrosAbueloP() {
        return otrosAbueloP;
    }

    public void setOtrosAbueloP(String otrosAbueloP) {
        this.otrosAbueloP = otrosAbueloP;
    }

    public String getOtrosAbueloM() {
        return otrosAbueloM;
    }

    public void setOtrosAbueloM(String otrosAbueloM) {
        this.otrosAbueloM = otrosAbueloM;
    }

    public String getOtrosNinguno() {
        return otrosNinguno;
    }

    public void setOtrosNinguno(String otrosNinguno) {
        this.otrosNinguno = otrosNinguno;
    }

    public String getOtrosComentariosTablaAntecedentesFamiliares() {
        return otrosComentariosTablaAntecedentesFamiliares;
    }

    public void setOtrosComentariosTablaAntecedentesFamiliares(String otrosComentariosTablaAntecedentesFamiliares) {
        this.otrosComentariosTablaAntecedentesFamiliares = otrosComentariosTablaAntecedentesFamiliares;
    }

    public String getFechaCreacionAn() {
        return fechaCreacionAn;
    }

    public void setFechaCreacionAn(String fechaCreacionAn) {
        this.fechaCreacionAn = fechaCreacionAn;
    }

    public String getHoraCreacionAn() {
        return horaCreacionAn;
    }

    public void setHoraCreacionAn(String horaCreacionAn) {
        this.horaCreacionAn = horaCreacionAn;
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
        hash += (idAnamnesis != null ? idAnamnesis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anamnesis)) {
            return false;
        }
        Anamnesis other = (Anamnesis) object;
        if ((this.idAnamnesis == null && other.idAnamnesis != null) || (this.idAnamnesis != null && !this.idAnamnesis.equals(other.idAnamnesis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.saludtec.entidades.Anamnesis[ idAnamnesis=" + idAnamnesis + " ]";
    }

}
