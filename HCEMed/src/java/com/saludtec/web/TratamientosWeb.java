/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.web;

import com.saludtec.entidades.Pacientes;
import com.saludtec.entidades.Tratamientos;
import com.saludtec.jpa.PacientesEjb;
import com.saludtec.jpa.TratamientosEjb;
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
@WebServlet(name = "TratamientosWeb", urlPatterns = {"/Tratamientos/*"})
public class TratamientosWeb extends HttpServlet {

    @EJB
    TratamientosEjb ejbTratamientos;
    @EJB
    PacientesEjb ejbPacientes;
    JSONObject obj;
    JSONArray objArray;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String servicio = request.getRequestURI().replace("/HCEMed/Tratamientos/", "");
            switch (servicio) {
                case "guardar":
                    guardarTratamiento(request).writeJSONString(out);
                    break;

                case "eliminar":
                    eliminarTratamiento(request).writeJSONString(out);
                    break;

                case "listar":
                    listarTratamientosPaciente(request).writeJSONString(out);
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

    private JSONArray guardarTratamiento(HttpServletRequest request) {
        Tratamientos tratamiento = new Tratamientos();
        Pacientes paciente = ejbPacientes.traer(Integer.parseInt(request.getParameter("idPaciente")));
        tratamiento.setIdPaciente(paciente);
        tratamiento.setDesTratamiento(request.getParameter("desTratamiento"));
        tratamiento.setFechaTratamiento(request.getParameter("fechaTratamiento"));
        tratamiento.setHoraTratamiento(request.getParameter("horaTratamiento"));
        tratamiento.setIdUsuario(1);//RECORDAR QUE ESTE VALOR ESTA QUEMADO Y HAY QUE CAMBIARLO CUANDO SE CREE LA TABLA USUARIOS
        tratamiento = ejbTratamientos.crear(tratamiento);
        obj = new JSONObject();
        objArray = new JSONArray();
        if (tratamiento != null) {
            obj.put("idTratamiento", tratamiento.getIdTratamiento());
            objArray.add(obj);
        } else {
            obj.put("error", "no se pudo guardar el tratamiento");
            objArray.add(obj);
        }
        return objArray;
    }

    private JSONObject eliminarTratamiento(HttpServletRequest request) {
        ejbTratamientos.eliminar(Integer.parseInt(request.getParameter("idTratamiento")));
        obj = new JSONObject();
        obj.put("menasaje", "eliminado");
        return obj;
    }

    private JSONArray listarTratamientosPaciente(HttpServletRequest request) {
        List<Tratamientos> tratamientos = ejbTratamientos.listar(Integer.parseInt(request.getParameter("idPaciente")), request.getParameter("fecha"));
        objArray = new JSONArray();
        if (tratamientos != null) {
            for (Tratamientos tratamiento : tratamientos) {
                obj = new JSONObject();
                obj.put("idTratamiento", tratamiento.getIdTratamiento());
                obj.put("idPaciente", tratamiento.getIdPaciente().getIdPaciente());
                obj.put("desTratamiento", tratamiento.getDesTratamiento());
                obj.put("fechaTratamiento", tratamiento.getFechaTratamiento());
                obj.put("horaTratamiento", tratamiento.getHoraTratamiento());
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
