/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.web;

import com.saludtec.entidades.Diagnosticos;
import com.saludtec.entidades.Pacientes;
import com.saludtec.jpa.DiagnosticosEjb;
import com.saludtec.jpa.PacientesEjb;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "DiagnosticosWeb", urlPatterns = {"/Diagnosticos/*"})
public class DiagnosticosWeb extends HttpServlet {

    @EJB
    DiagnosticosEjb ejbEvolucionComentario;
    @EJB
    PacientesEjb ejbPacientes;
    JSONObject obj;
    JSONArray objArray;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String servicio = request.getRequestURI().replace("/HCEMed/Diagnosticos/", "");
            switch (servicio) {
                case "guardar":
                    guardarEvolucionComentario(request).writeJSONString(out);
                    break;

                case "listar":
                    listarEvolucionComentario(request).writeJSONString(out);
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

    private JSONArray guardarEvolucionComentario(HttpServletRequest request) {
        Diagnosticos diagnostico = new Diagnosticos();
        Pacientes paciente = ejbPacientes.traer(Integer.parseInt(request.getParameter("idPaciente")));
        diagnostico.setIdPaciente(paciente);
        diagnostico.setNombreModulo(request.getParameter("nombreModulo"));
        diagnostico.setNombreDiagnostico(request.getParameter("nombreDiagnostico"));
        diagnostico.setDiagnostico(request.getParameter("diagnostico"));
        diagnostico.setFecha(request.getParameter("fecha"));
        diagnostico.setHora(request.getParameter("hora"));
        diagnostico.setIdUsuario(1);//RECORDAR QUE ESTE VALOR ESTA QUEMADO Y HAY QUE CAMBIARLO CUANDO SE CREE LA TABLA USUARIOS
        diagnostico = ejbEvolucionComentario.crear(diagnostico);
        obj = new JSONObject();
        objArray = new JSONArray();
        if (diagnostico != null) {
            obj.put("idEvolucion", diagnostico.getIdDiagnostico());
            objArray.add(obj);
        } else {
            obj.put("error", "no se pudo guardar el diangnostico");
            objArray.add(obj);
        }
        return objArray;
    }

    private JSONArray listarEvolucionComentario(HttpServletRequest request) {
        List<Diagnosticos> diagnosticos = ejbEvolucionComentario.listar(Integer.parseInt(request.getParameter("idPaciente")), request.getParameter("fecha"));
        objArray = new JSONArray();
        if (diagnosticos != null) {
            for (Diagnosticos diagnostico : diagnosticos) {
                obj = new JSONObject();
                obj.put("idDiagnostico", diagnostico.getIdDiagnostico());
                obj.put("idPaciente", diagnostico.getIdPaciente().getIdPaciente());
                obj.put("nombreModulo", diagnostico.getNombreModulo());
                obj.put("nombreDiagnostico", diagnostico.getNombreDiagnostico());
                obj.put("diagnostico", diagnostico.getDiagnostico());
                obj.put("fecha", diagnostico.getFecha());
                obj.put("hora", diagnostico.getHora());
                objArray.add(obj);
            }
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
