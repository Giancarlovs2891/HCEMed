/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.web;

import com.saludtec.db.Conexion;
import com.saludtec.entidades.Pacientes;
import com.saludtec.entidades.Usuarios;
import com.saludtec.jpa.PacientesEjb;
import com.saludtec.jpa.UsuariosEjb;
import integracionadminiohcemed.LoginHcemed;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "UsuariosWeb", urlPatterns = {"/Usuarios/*"})
public class UsuariosWeb extends HttpServlet {

    @EJB
    UsuariosEjb ejbUsuarios;
    @EJB
    PacientesEjb ejbPacientes;
    JSONObject obj;
    JSONArray objArray;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String servicio = request.getRequestURI().replace("/HCEMed/Usuarios/", "");
            switch (servicio) {
                case "login":
                    try {
                        login(request).writeJSONString(out);
                    } catch (Exception ex) {
                        Logger.getLogger(UsuariosWeb.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case "logout":
                    logout(request).writeJSONString(out);
                    break;

                case "isLogin":
                    verificarSesion(request).writeJSONString(out);
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

    private JSONArray login(HttpServletRequest request) throws Exception {
        objArray = new JSONArray();
        if (Conexion.Adminio.equals("si")) {
            LoginHcemed hce = new LoginHcemed();
            Integer idUsuario = hce.login(request.getParameter("usuario"), request.getParameter("contrasena"));
            if (idUsuario > 0) {
                request.getSession().setAttribute("usuario", idUsuario);
                obj = new JSONObject();
                obj.put("Exito", "1");
                objArray.add(obj);
            } else {
                obj = new JSONObject();
                obj.put("Error", "datos incorrectos");
                objArray.add(obj);
            }
        } else {
            Usuarios usuario = ejbUsuarios.login(request.getParameter("usuario"), request.getParameter("contrasena"));
            if (usuario != null) {
                request.getSession().setAttribute("usuario", usuario.getIdUsuario());
                obj = new JSONObject();
                obj.put("Exito", "1");
                objArray.add(obj);
            } else {
                obj = new JSONObject();
                obj.put("Error", "datos incorrectos");
                objArray.add(obj);
            }
        }
        return objArray;
    }

    private JSONArray logout(HttpServletRequest request) {
        if (request.getSession().getAttribute("usuario") != null) {
            request.getSession().setAttribute("usuario", null);
            objArray = new JSONArray();
            obj = new JSONObject();
            obj.put("Exito", "1");
            objArray.add(obj);
        }
        return objArray;
    }

    private JSONArray verificarSesion(HttpServletRequest request) {
        objArray = new JSONArray();
        if (request.getSession().getAttribute("usuario") != null) {
            obj = new JSONObject();
            obj.put("Exito", "1");
            objArray.add(obj);
        } else {
            obj = new JSONObject();
            obj.put("Error", "usuario no loegueado");
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
