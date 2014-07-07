/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.web;

import com.saludtec.entidades.hcemed.Evolucion;
import com.saludtec.entidades.hcemed.PacientesHcemed;
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
    @EJB
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
                    out.println(listarEvolucion(request));
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
        PacientesHcemed paciente = ejbPacientes.traer(Integer.parseInt(request.getParameter("idPaciente")));
        evolucion.setIdPaciente(paciente);
        evolucion.setNombreModulo(request.getParameter("nombreModulo"));
        evolucion.setFecha(request.getParameter("fecha"));
        evolucion.setHora(request.getParameter("hora"));
        evolucion.setEvolucion(request.getParameter("evolucion"));
        evolucion.setIdUsuario(Integer.parseInt(request.getSession().getAttribute("usuario").toString()));//RECORDAR QUE ESTE VALOR ESTA QUEMADO Y HAY QUE CAMBIARLO CUANDO SE CREE LA TABLA USUARIOS
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
    
    private JSONArray listarEvolucion1(HttpServletRequest request) {
        List<Evolucion> evoluciones = ejbEvolucion.listar(Integer.parseInt(request.getParameter("idPaciente")));
        objArray = new JSONArray();
        if (evoluciones != null) {
            for (Evolucion evolucion : evoluciones) {
                obj = new JSONObject();
                obj.put("idEvolucion", evolucion.getIdEvolucion());
                obj.put("idPaciente", evolucion.getIdPaciente().getIdPaciente());
                obj.put("nombreModulo", evolucion.getNombreModulo());
                obj.put("fecha", evolucion.getFecha());
                obj.put("hora", evolucion.getHora());
                obj.put("evolucion", evolucion.getEvolucion());
                objArray.add(obj);
            }
        }
        return objArray;
    }

    private String listarEvolucion(HttpServletRequest request) {
        List<Evolucion> evoluciones = ejbEvolucion.listar(Integer.parseInt(request.getParameter("idPaciente")));
        String arrayJson = "[";
        if (evoluciones != null) {
            for (Evolucion evolucion : evoluciones) {
                arrayJson += "{";
                arrayJson += "\"idEvolucion\":" + evolucion.getIdEvolucion() + ",";
                arrayJson += "\"idPaciente\":" + evolucion.getIdPaciente().getIdPaciente() + ",";
                arrayJson += "\"nombreModulo\":\"" + evolucion.getNombreModulo() + "\",";
                arrayJson += "\"fecha\":\"" + evolucion.getFecha() + "\",";
                arrayJson += "\"hora\":\"" + evolucion.getHora() + "\",";
                arrayJson += "\"evolucion\":\"" + evolucion.getEvolucion() + "\"";
                arrayJson += "},";
            }
        }
        arrayJson += "]";
        arrayJson = arrayJson.replaceAll("},]", "}]");
        return arrayJson;
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
