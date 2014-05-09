/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saludtec.web;

import com.saludtec.entidades.Evolucion;
import com.saludtec.entidades.Pacientes;
import com.saludtec.jpa.EvolucionEjb;
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
@WebServlet(name = "EvolucionWeb", urlPatterns = {"/Evolucion/*"})
public class EvolucionWeb extends HttpServlet {

   @EJB
    EvolucionEjb ejbEvolucion;
    PacientesEjb ejbPacientes;
    JSONObject obj;
    JSONArray objArray;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String servicio = request.getRequestURI().replace("/HCEMed/Evolucion/", "");
            switch (servicio) {
                case "guardar":
                    guardarEvolucion(request).writeJSONString(out);
                    break;

                case "listar":
                    listarEvolucion(request).writeJSONString(out);
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

    private JSONArray guardarEvolucion(HttpServletRequest request) {
        Evolucion evolucion = new Evolucion();
        Pacientes paciente = ejbPacientes.traer(Integer.parseInt(request.getParameter("idPaciente"))); 
        evolucion.setIdPaciente(paciente);
        evolucion.setFecha(request.getParameter("fecha"));
        evolucion.setHora(request.getParameter("hora"));
        evolucion.setEvolucion(request.getParameter("evolucion"));
        evolucion.setIdUsuario(1);//RECORDAR QUE ESTE VALOR ESTA QUEMADO Y HAY QUE CAMBIARLO CUANDO SE CREE LA TABLA USUARIOS
        evolucion = ejbEvolucion.crear(evolucion);
        obj = new JSONObject();
        objArray = new JSONArray();
        if (evolucion != null) {
            obj.put("idEvolucion", evolucion.getIdEvolucion());
            objArray.add(obj);
        } else {
            obj.put("error", "no se pudo guardar el evolucion");
            objArray.add(obj);
        }
        return objArray;
    }

    private JSONArray listarEvolucion(HttpServletRequest request) {
        List<Evolucion> evoluciones = ejbEvolucion.listar(Integer.parseInt(request.getParameter("idPaciente")));
        objArray = new JSONArray();
        if (evoluciones != null) {
            for (Evolucion evolucion : evoluciones) {
                obj = new JSONObject();
                obj.put("idEvolucion", evolucion.getIdEvolucion());
                obj.put("idPaciente", evolucion.getIdPaciente().getIdPaciente());
                obj.put("fecha", evolucion.getFecha());
                obj.put("hora", evolucion.getHora());
                obj.put("evolucion", evolucion.getEvolucion());
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
