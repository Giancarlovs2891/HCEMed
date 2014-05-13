/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saludtec.web;

import com.saludtec.entidades.DescripcionPlanDeTratamiento;
import com.saludtec.entidades.PlanesDeTratamiento;
import com.saludtec.jpa.DescripcionPlanDeTratamientoEjb;
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
@WebServlet(name = "DescripcionPlanDeTratamientoWeb", urlPatterns = {"/descripcionPlanDeTratamiento/*"})
public class DescripcionPlanDeTratamientoWeb extends HttpServlet {

    @EJB
    DescripcionPlanDeTratamientoEjb ejbDescripcionPlanTratamiento;
    @EJB
    PlanesDeTratamientoEjb ejbPlanTratamiento;
    JSONObject obj;
    JSONArray objArray;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String servicio = request.getRequestURI().replace("/HCEMed/descripcionPlanDeTratamiento/", "");
            switch (servicio) {
                case "guardar":
                    guardarDescripcionPlanDeTratamiento(request).writeJSONString(out);
                    break;

                case "listar":
                    listarDescripcionPlanDeTratamiento(request).writeJSONString(out);
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

    private JSONArray guardarDescripcionPlanDeTratamiento(HttpServletRequest request) {
        DescripcionPlanDeTratamiento descripcionPlanTratamiento = new DescripcionPlanDeTratamiento();
        PlanesDeTratamiento planTratamiento = ejbPlanTratamiento.traer(Integer.parseInt(request.getParameter("idPlanDeTratamiento"))); 
        descripcionPlanTratamiento.setIdPlanTratamiento(planTratamiento);
        descripcionPlanTratamiento.setTextoDescripcionPlanTratamiento(request.getParameter("textoDescripcionPlanTratamiento"));
        descripcionPlanTratamiento.setValorDescripcionPlanTratamiento(request.getParameter("valorDescripcionPlanTratamiento"));
        descripcionPlanTratamiento.setIdUsuario(1);//RECORDAR QUE ESTE VALOR ESTA QUEMADO Y HAY QUE CAMBIARLO CUANDO SE CREE LA TABLA USUARIOS
        descripcionPlanTratamiento = ejbDescripcionPlanTratamiento.crear(descripcionPlanTratamiento);
        obj = new JSONObject();
        objArray = new JSONArray();
        if (descripcionPlanTratamiento != null) {
            obj.put("idDescripcionPlanDeTratamiento", descripcionPlanTratamiento.getIdDescripcionPlanTratamiento());
            objArray.add(obj);
        } else {
            obj.put("error", "no se pudo guardar la descripcion del tratamiento");
            objArray.add(obj);
        }
        return objArray;
    }

    private JSONArray listarDescripcionPlanDeTratamiento(HttpServletRequest request) {
        List<DescripcionPlanDeTratamiento> descripcionPlanTratamientoes = ejbDescripcionPlanTratamiento.listar(Integer.parseInt(request.getParameter("idPlanTratamiento")));
        objArray = new JSONArray();
        if (descripcionPlanTratamientoes != null) {
            for (DescripcionPlanDeTratamiento descripcionPlanTratamiento : descripcionPlanTratamientoes) {
                obj = new JSONObject();
                obj.put("idDescripcionPlanDeTratamiento", descripcionPlanTratamiento.getIdDescripcionPlanTratamiento());
                obj.put("idPlanTratamiento", descripcionPlanTratamiento.getIdPlanTratamiento().getIdPlanDeTratamiento());
                obj.put("textoDescripcionPlanTratamiento", descripcionPlanTratamiento.getTextoDescripcionPlanTratamiento());
                obj.put("valorDescripcionPlanTratamiento", descripcionPlanTratamiento.getValorDescripcionPlanTratamiento());
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
