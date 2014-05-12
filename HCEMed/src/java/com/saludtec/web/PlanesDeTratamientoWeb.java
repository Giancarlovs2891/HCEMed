/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.web;

import com.saludtec.entidades.Pacientes;
import com.saludtec.entidades.PlanesDeTratamiento;
import com.saludtec.jpa.PacientesEjb;
import com.saludtec.jpa.PlanesDeTratamientoEjb;
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
@WebServlet(name = "PlanesDeTratamientoWeb", urlPatterns = {"/PlanesDeTratamiento/*"})
public class PlanesDeTratamientoWeb extends HttpServlet {

    @EJB
    PlanesDeTratamientoEjb ejbPlanesDeTratamiento;
    PacientesEjb ejbPacientes;
    JSONObject obj;
    JSONArray objArray;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String servicio = request.getRequestURI().replace("/HCEMed/PlanesDeTratamiento/", "");
            switch (servicio) {
                case "guardar":
                    guardarPlanTratamiento(request).writeJSONString(out);
                    break;

                case "editar":
                    editarPlanTratamiento(request).writeJSONString(out);
                    break;

                case "traer":
                    traerPlanTratamiento(request).writeJSONString(out);
                    break;
                case "listar":
                    listarPlanesDeTratamientoPaciente(request).writeJSONString(out);
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

    private JSONArray guardarPlanTratamiento(HttpServletRequest request) {
        PlanesDeTratamiento planTratamiento = new PlanesDeTratamiento();
        Pacientes paciente = ejbPacientes.traer(Integer.parseInt(request.getParameter("idPaciente")));
        planTratamiento.setIdPaciente(paciente);
        planTratamiento.setFechaPlanTratamiento(request.getParameter("fechaPlanTratamiento"));
        planTratamiento.setImpuestoPlanTratamiento(request.getParameter("impuestoPlanTratamiento"));
        planTratamiento.setValorPlanTratamiento(request.getParameter("valorPlanTratamiento"));
        planTratamiento.setPagadoPlanTratamiento(request.getParameter("pagadoPlanTratamiento"));
        planTratamiento.setIdUsuario(1);//RECORDAR QUE ESTE VALOR ESTA QUEMADO Y HAY QUE CAMBIARLO CUANDO SE CREE LA TABLA USUARIOS
        planTratamiento = ejbPlanesDeTratamiento.crear(planTratamiento);
        obj = new JSONObject();
        objArray = new JSONArray();
        if (planTratamiento != null) {
            obj.put("idTratamiento", planTratamiento.getIdPlanDeTratamiento());
            objArray.add(obj);
        } else {
            obj.put("error", "no se pudo guardar el plan de tratamiento");
            objArray.add(obj);
        }
        return objArray;
    }

    private JSONArray editarPlanTratamiento(HttpServletRequest request) {
        PlanesDeTratamiento planTratamiento = ejbPlanesDeTratamiento.traer(Integer.parseInt(request.getParameter("idPlanDeTratamiento")));
        planTratamiento.setPagadoPlanTratamiento(request.getParameter("pagadoPlanTratamiento"));
        planTratamiento.setIdUsuario(1);//RECORDAR QUE ESTE VALOR ESTA QUEMADO Y HAY QUE CAMBIARLO CUANDO SE CREE LA TABLA USUARIOS
        planTratamiento = ejbPlanesDeTratamiento.editar(planTratamiento);
        obj = new JSONObject();
        objArray = new JSONArray();
        if (planTratamiento != null) {
            obj.put("mensaje", "Registro con id " + planTratamiento.getIdPlanDeTratamiento() + " editado");
            objArray.add(obj);
        } else {
            obj.put("error", "no se pudo editar el plan de tratamiento");
            objArray.add(obj);
        }
        return objArray;
    }

    private JSONArray traerPlanTratamiento(HttpServletRequest request) {
        PlanesDeTratamiento planTratamiento = ejbPlanesDeTratamiento.traer(Integer.parseInt(request.getParameter("idPlanDeTratamiento")));
        objArray = new JSONArray();
        if (planTratamiento != null) {
            obj = new JSONObject();
            obj.put("idPlanDeTratamiento", planTratamiento.getIdPlanDeTratamiento());
            obj.put("idPaciente", planTratamiento.getIdPaciente().getIdPaciente());
            obj.put("fechaPlanTratamiento", planTratamiento.getFechaPlanTratamiento());
            obj.put("impuestoPlanTratamiento", planTratamiento.getImpuestoPlanTratamiento());
            obj.put("valorPlanTratamiento", planTratamiento.getValorPlanTratamiento());
            obj.put("pagadoPlanTratamiento", planTratamiento.getPagadoPlanTratamiento());
            objArray.add(obj);
        }
        return objArray;
    }

    private JSONArray listarPlanesDeTratamientoPaciente(HttpServletRequest request) {
        List<PlanesDeTratamiento> planTratamientos = ejbPlanesDeTratamiento.listar(Integer.parseInt(request.getParameter("idPaciente")));
        objArray = new JSONArray();
        if (planTratamientos != null) {
            for (PlanesDeTratamiento planTratamiento : planTratamientos) {
                obj = new JSONObject();
                obj.put("idPlanDeTratamiento", planTratamiento.getIdPlanDeTratamiento());
                obj.put("idPaciente", planTratamiento.getIdPaciente().getIdPaciente());
                obj.put("fechaPlanTratamiento", planTratamiento.getFechaPlanTratamiento());
                obj.put("impuestoPlanTratamiento", planTratamiento.getImpuestoPlanTratamiento());
                obj.put("valorPlanTratamiento", planTratamiento.getValorPlanTratamiento());
                obj.put("pagadoPlanTratamiento", planTratamiento.getPagadoPlanTratamiento());
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
