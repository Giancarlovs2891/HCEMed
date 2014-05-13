/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.web;

import com.saludtec.entidades.ExamenFisico;
import com.saludtec.entidades.Pacientes;
import com.saludtec.jpa.ExamenFisicoEjb;
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
@WebServlet(name = "ExamenFisicoWeb", urlPatterns = {"/ExamenFisico/*"})
public class ExamenFisicoWeb extends HttpServlet {

    @EJB
    ExamenFisicoEjb ejbExamenFisico;
    @EJB
    PacientesEjb ejbPacientes;
    JSONObject obj;
    JSONArray objArray;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String servicio = request.getRequestURI().replace("/HCEMed/ExamenFisico/", "");
            switch (servicio) {
                case "guardar":
                    guardarExamenFisico(request).writeJSONString(out);
                    break;

                case "traerUltimo":
                    traerUltimoExamenFisico(request).writeJSONString(out);
                    break;

                case "traerFecha":
                    traerExamenFisicoFecha(request).writeJSONString(out);
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

    private JSONArray guardarExamenFisico(HttpServletRequest request) {
        ExamenFisico examenFisico = new ExamenFisico();
        Pacientes paciente = ejbPacientes.traer(Integer.parseInt(request.getParameter("idPaciente")));
        examenFisico.setIdPaciente(paciente);
        examenFisico.setTensionArterial(request.getParameter("tensionArterial"));
        examenFisico.setPeso(request.getParameter("peso"));
        examenFisico.setCintura(request.getParameter("cintura"));
        examenFisico.setPulso(request.getParameter("pulso"));
        examenFisico.setTalla(request.getParameter("talla"));
        examenFisico.setCadera(request.getParameter("cadera"));
        examenFisico.setFrecuenciaRespiratoria(request.getParameter("frecuenciaRespiratoria"));
        examenFisico.setBmi(request.getParameter("bmi"));
        examenFisico.setIndiceCintCad(request.getParameter("indiceCintCad"));
        examenFisico.setPiel(request.getParameter("piel"));
        examenFisico.setPielComentarioEf(request.getParameter("pielComentarioEf"));
        examenFisico.setOjos(request.getParameter("ojos"));
        examenFisico.setOjosComentarioEf(request.getParameter("ojosComentarioEf"));
        examenFisico.setOidosNarizGarganta(request.getParameter("oidosNarizGarganta"));
        examenFisico.setOidosNarizGargantaComentarioEf(request.getParameter("oidosNarizGargantaComentarioEf"));
        examenFisico.setCuello(request.getParameter("cuello"));
        examenFisico.setCuelloComentarioEf(request.getParameter("cuelloComentarioEf"));
        examenFisico.setTorax(request.getParameter("torax"));
        examenFisico.setToraxComentarioEf(request.getParameter("toraxComentarioEf"));
        examenFisico.setCardiovascular(request.getParameter("cardiovascular"));
        examenFisico.setCardiovascularComentarioEf(request.getParameter("cardiovascularComentarioEf"));
        examenFisico.setRespiratorios(request.getParameter("respiratorios"));
        examenFisico.setRespiratoriosComentarioEf(request.getParameter("respiratoriosComentarioEf"));
        examenFisico.setAbdomen(request.getParameter("abdomen"));
        examenFisico.setAbdomenComentarioEf(request.getParameter("abdomenComentarioEf"));
        examenFisico.setGenitourinario(request.getParameter("genitourinario"));
        examenFisico.setGenitourinarioComentarioEf(request.getParameter("genitourinarioComentarioEf"));
        examenFisico.setExtremidades(request.getParameter("extremidades"));
        examenFisico.setExtremidadesComentarioEf(request.getParameter("extremidadesComentarioEf"));
        examenFisico.setSistemaNerviosoCentral(request.getParameter("sistemaNerviosoCentral"));
        examenFisico.setSistemaNerviosoCentralComentarioEf(request.getParameter("sistemaNerviosoCentralComentarioEf"));
        examenFisico.setAdenopatias(request.getParameter("adenopatias"));
        examenFisico.setAdenopatiasComentarioEf(request.getParameter("adenopatiasComentarioEf"));
        examenFisico.setOtros(request.getParameter("otros"));
        examenFisico.setOtrosComentarioEf(request.getParameter("otrosComentarioEf"));
        examenFisico.setComentariosEf(request.getParameter("comentariosEf"));
        examenFisico.setCondicionEf(request.getParameter("condicionEf"));
        examenFisico.setFechaCreacionEf(request.getParameter("fechaCreacionEf"));
        examenFisico.setHoraCreacionEf(request.getParameter("horaCreacionEf"));
        examenFisico.setIdUsuario(Integer.parseInt(request.getSession().getAttribute("usuario").toString()));//RECORDAR QUE ESTE VALOR ESTA QUEMADO Y HAY QUE CAMBIARLO CUANDO SE CREE LA TABLA USUARIOS
        examenFisico = ejbExamenFisico.crear(examenFisico);
        obj = new JSONObject();
        objArray = new JSONArray();
        if (examenFisico != null) {
            obj.put("idExamenFisico", examenFisico.getIdExamenFisico());
            objArray.add(obj);
        } else {
            obj.put("error", "no se pudo guardar el examen fisico");
            objArray.add(obj);
        }
        return objArray;
    }

    private JSONArray traerUltimoExamenFisico(HttpServletRequest request) {
        ExamenFisico examenFisico = ejbExamenFisico.traerUltimo(Integer.parseInt(request.getParameter("idPaciente")));
        obj = new JSONObject();
        objArray = new JSONArray();
        if (examenFisico != null) {
            obj.put("idExamenFisico", examenFisico.getIdExamenFisico());
            obj.put("idPaciente", examenFisico.getIdPaciente().getIdPaciente());
            obj.put("tensionArterial", examenFisico.getTensionArterial());
            obj.put("peso", examenFisico.getPeso());
            obj.put("cintura", examenFisico.getCintura());
            obj.put("pulso", examenFisico.getPulso());
            obj.put("talla", examenFisico.getTalla());
            obj.put("cadera", examenFisico.getCadera());
            obj.put("frecuenciaRespirarotia", examenFisico.getFrecuenciaRespiratoria());
            obj.put("bmi", examenFisico.getBmi());
            obj.put("indiceCintCad", examenFisico.getIndiceCintCad());
            obj.put("piel", examenFisico.getPiel());
            obj.put("pielComentariosEf", examenFisico.getPielComentarioEf());
            obj.put("ojos", examenFisico.getOjos());
            obj.put("ojosComentariosEf", examenFisico.getOjosComentarioEf());
            obj.put("oidosNarizGarganta", examenFisico.getOidosNarizGarganta());
            obj.put("oidosNarizGargantaComentariosEf", examenFisico.getOidosNarizGargantaComentarioEf());
            obj.put("cuello", examenFisico.getCuello());
            obj.put("cuelloComentariosEf", examenFisico.getCuelloComentarioEf());
            obj.put("torax", examenFisico.getTorax());
            obj.put("toraxComentariosEf", examenFisico.getToraxComentarioEf());
            obj.put("cardiovascular", examenFisico.getCardiovascular());
            obj.put("cardiovascularComentariosEf", examenFisico.getCardiovascularComentarioEf());
            obj.put("respiratorios", examenFisico.getRespiratorios());
            obj.put("respiratoriosComentariosEf", examenFisico.getRespiratoriosComentarioEf());
            obj.put("abdomen", examenFisico.getAbdomen());
            obj.put("abdomenComentariosEf", examenFisico.getAbdomenComentarioEf());
            obj.put("genitourinario", examenFisico.getGenitourinario());
            obj.put("genitourinarioComentariosEf", examenFisico.getGenitourinarioComentarioEf());
            obj.put("extremidades", examenFisico.getExtremidades());
            obj.put("extremidadesComentariosEf", examenFisico.getExtremidadesComentarioEf());
            obj.put("sistemaNerviosoCentral", examenFisico.getSistemaNerviosoCentral());
            obj.put("sistemaNerviosoCentralComentariosEf", examenFisico.getSistemaNerviosoCentralComentarioEf());
            obj.put("adenopatias", examenFisico.getAdenopatias());
            obj.put("adenopatiasComentariosEf", examenFisico.getAdenopatiasComentarioEf());
            obj.put("otros", examenFisico.getOtros());
            obj.put("otrosComentariosEf", examenFisico.getOtrosComentarioEf());
            obj.put("comentariosEf", examenFisico.getComentariosEf());
            obj.put("condicionEf", examenFisico.getCondicionEf());
            obj.put("fechaCreacionEf", examenFisico.getFechaCreacionEf());
            obj.put("horaCreacionEf", examenFisico.getHoraCreacionEf());
            objArray.add(obj);
        }
        return objArray;
    }

    private JSONArray traerExamenFisicoFecha(HttpServletRequest request) {
        ExamenFisico examenFisico = ejbExamenFisico.traer(request.getParameter("fecha"));
        obj = new JSONObject();
        objArray = new JSONArray();
        if (examenFisico != null) {
            obj.put("idExamenFisico", examenFisico.getIdExamenFisico());
            obj.put("idPaciente", examenFisico.getIdPaciente().getIdPaciente());
            obj.put("tensionArterial", examenFisico.getTensionArterial());
            obj.put("peso", examenFisico.getPeso());
            obj.put("cintura", examenFisico.getCintura());
            obj.put("pulso", examenFisico.getPulso());
            obj.put("talla", examenFisico.getTalla());
            obj.put("cadera", examenFisico.getCadera());
            obj.put("frecuenciaRespirarotia", examenFisico.getFrecuenciaRespiratoria());
            obj.put("bmi", examenFisico.getBmi());
            obj.put("indiceCintCad", examenFisico.getIndiceCintCad());
            obj.put("piel", examenFisico.getPiel());
            obj.put("pielComentariosEf", examenFisico.getPielComentarioEf());
            obj.put("ojos", examenFisico.getOjos());
            obj.put("ojosComentariosEf", examenFisico.getOjosComentarioEf());
            obj.put("oidosNarizGarganta", examenFisico.getOidosNarizGarganta());
            obj.put("oidosNarizGargantaComentariosEf", examenFisico.getOidosNarizGargantaComentarioEf());
            obj.put("cuello", examenFisico.getCuello());
            obj.put("cuelloComentariosEf", examenFisico.getCuelloComentarioEf());
            obj.put("torax", examenFisico.getTorax());
            obj.put("toraxComentariosEf", examenFisico.getToraxComentarioEf());
            obj.put("cardiovascular", examenFisico.getCardiovascular());
            obj.put("cardiovascularComentariosEf", examenFisico.getCardiovascularComentarioEf());
            obj.put("respiratorios", examenFisico.getRespiratorios());
            obj.put("respiratoriosComentariosEf", examenFisico.getRespiratoriosComentarioEf());
            obj.put("abdomen", examenFisico.getAbdomen());
            obj.put("abdomenComentariosEf", examenFisico.getAbdomenComentarioEf());
            obj.put("genitourinario", examenFisico.getGenitourinario());
            obj.put("genitourinarioComentariosEf", examenFisico.getGenitourinarioComentarioEf());
            obj.put("extremidades", examenFisico.getExtremidades());
            obj.put("extremidadesComentariosEf", examenFisico.getExtremidadesComentarioEf());
            obj.put("sistemaNerviosoCentral", examenFisico.getSistemaNerviosoCentral());
            obj.put("sistemaNerviosoCentralComentariosEf", examenFisico.getSistemaNerviosoCentralComentarioEf());
            obj.put("adenopatias", examenFisico.getAdenopatias());
            obj.put("adenopatiasComentariosEf", examenFisico.getAdenopatiasComentarioEf());
            obj.put("otros", examenFisico.getOtros());
            obj.put("otrosComentariosEf", examenFisico.getOtrosComentarioEf());
            obj.put("comentariosEf", examenFisico.getComentariosEf());
            obj.put("condicionEf", examenFisico.getCondicionEf());
            obj.put("fechaCreacionEf", examenFisico.getFechaCreacionEf());
            obj.put("horaCreacionEf", examenFisico.getHoraCreacionEf());
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
