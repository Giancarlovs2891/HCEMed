/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.web;

import com.saludtec.entidades.Pagos;
import com.saludtec.entidades.PlanesDeTratamiento;
import com.saludtec.jpa.PagosEjb;
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
@WebServlet(name = "PagosWeb", urlPatterns = {"/Pagos/*"})
public class PagosWeb extends HttpServlet {

    @EJB
    PagosEjb ejbPagos;
    @EJB
    PlanesDeTratamientoEjb ejbPlanesDeTratamiento;
    JSONObject obj;
    JSONArray objArray;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String servicio = request.getRequestURI().replace("/HCEMed/Pagos/", "");
            switch (servicio) {
                case "guardar":
                    guardarPago(request).writeJSONString(out);
                    break;

                case "listar":
                    listarPago(request).writeJSONString(out);
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

    private JSONArray guardarPago(HttpServletRequest request) {
        Pagos pago = new Pagos();
        PlanesDeTratamiento planTratamiento = ejbPlanesDeTratamiento.traer(Integer.parseInt(request.getParameter("idPlanTratamiento")));        
        pago.setValorPago(request.getParameter("fechaPlanTratamiento"));
        pago.setFechaPago(request.getParameter("impuestoPlanTratamiento"));
        pago.setIdPlanTratamiento(planTratamiento);
        pago.setIdUsuario(1);//RECORDAR QUE ESTE VALOR ESTA QUEMADO Y HAY QUE CAMBIARLO CUANDO SE CREE LA TABLA USUARIOS
        pago = ejbPagos.crear(pago);
        obj = new JSONObject();
        objArray = new JSONArray();
        if (pago != null) {
            obj.put("idPago", pago.getIdPago());
            objArray.add(obj);
        } else {
            obj.put("error", "no se pudo guardar el pago");
            objArray.add(obj);
        }
        return objArray;
    }

    private JSONArray listarPago(HttpServletRequest request) {
        List<Pagos> pagos = ejbPagos.listar(Integer.parseInt(request.getParameter("idPlanTratamiento")));
        objArray = new JSONArray();
        if (pagos != null) {
            for (Pagos pago : pagos) {
                obj = new JSONObject();
                obj.put("idPlanDeTratamiento", pago.getIdPago());
                obj.put("fechaPlanTratamiento", pago.getValorPago());
                obj.put("impuestoPlanTratamiento", pago.getFechaPago());
                obj.put("valorPlanTratamiento", pago.getIdPlanTratamiento().getIdPlanDeTratamiento());
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
