/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saludtec.web;

import com.saludtec.entidades.Galeria;
import com.saludtec.entidades.Pacientes;
import com.saludtec.jpa.GaleriaEjb;
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
@WebServlet(name = "GaleriaWeb", urlPatterns = {"/Galeria/*"})
public class GaleriaWeb extends HttpServlet {

    @EJB
    GaleriaEjb ejbGaleria;
    PacientesEjb ejbPaciente;
    JSONObject obj;
    JSONArray objArray;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String servicio = request.getRequestURI().replace("/HCEMed/Galeria/", "");
            switch (servicio) {
                case "guardar":
                    guardarGaleria(request).writeJSONString(out);
                    break;
                
                case "editar":
                    editarGaleria(request).writeJSONString(out);
                    break;
                
                case "eliminar":
                    eliminarGaleria(request).writeJSONString(out);
                    break;
                
                case "traer":
                    traerGaleria(request).writeJSONString(out);
                    break;
                
                case "listar":
                    listarGaleria(request).writeJSONString(out);
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
    
    private JSONArray guardarGaleria(HttpServletRequest request) {
        Galeria galeria = new Galeria();
        Pacientes paciente = new Pacientes();
        paciente.setIdPaciente(Integer.parseInt(request.getParameter("idPaciente")));
        galeria.setIdPaciente(paciente);
        galeria.setFoto(request.getParameter("parentescoEmergencia"));
        galeria.setFecha(request.getParameter("nombreReferido"));
        galeria.setHora(request.getParameter("fechaCreacion"));
        galeria.setIdUsuario(1);//RECORDAR QUE ESTE VALOR ESTA QUEMADO Y HAY QUE CAMBIARLO CUANDO SE CREE LA TABLA USUARIOS
        galeria = ejbGaleria.crear(galeria);
        obj = new JSONObject();
        objArray = new JSONArray();
        if (galeria != null) {
            obj.put("idFoto", galeria.getIdFoto());
            objArray.add(obj);
        } else {
            obj.put("error", "no se pudo guardar la foto");
            objArray.add(obj);
        }
        return objArray;
    }
    
    private JSONArray editarGaleria(HttpServletRequest request) {
        Galeria galeria = new Galeria();
        Pacientes paciente = ejbPaciente.traer(Integer.parseInt(request.getParameter("idPaciente")));
        galeria.setIdPaciente(paciente);
        galeria.setFoto(request.getParameter("parentescoEmergencia"));
        galeria.setFecha(request.getParameter("nombreReferido"));
        galeria.setHora(request.getParameter("fechaCreacion"));
        galeria.setIdUsuario(1);//RECORDAR QUE ESTE VALOR ESTA QUEMADO Y HAY QUE CAMBIARLO CUANDO SE CREE LA TABLA USUARIOS
        galeria = ejbGaleria.editar(galeria);
        obj = new JSONObject();
        objArray = new JSONArray();
        if (galeria != null) {
            obj.put("mensaje", "Registro con id " + galeria.getIdFoto()+ " editado");
            objArray.add(obj);
        } else {
            obj.put("error", "no se pudo editar la foto");
            objArray.add(obj);
        }
        return objArray;
    }
    
    private JSONObject eliminarGaleria(HttpServletRequest request) {
        ejbGaleria.eliminar(Integer.parseInt(request.getParameter("idFoto")));
        obj = new JSONObject();
        obj.put("menasaje", "eliminado");
        return obj;
    }
    
    private JSONArray traerGaleria(HttpServletRequest request) {
        Galeria galeria = ejbGaleria.traer(Integer.parseInt(request.getParameter("idFoto")));
        obj = new JSONObject();
        objArray = new JSONArray();
        if (galeria != null) {
            obj.put("idPaciente", galeria.getIdPaciente());
            
            objArray.add(obj);
        }
        return objArray;
    }
    
    private JSONArray listarGaleria(HttpServletRequest request) {
        List<Galeria> galerias = ejbGaleria.listar(Integer.parseInt(request.getParameter("idPaciente")));
        objArray = new JSONArray();
        if (galerias != null) {
            for (Galeria galeria : galerias) {
                obj = new JSONObject();
                obj.put("idPaciente", galeria.getIdPaciente());
                obj.put("foto", galeria.getFoto());
                obj.put("nombrePaciente", galeria.getFoto());
                obj.put("fecha", galeria.getFecha());
                obj.put("hora", galeria.getHora());
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
