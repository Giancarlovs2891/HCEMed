/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.web;

import com.saludtec.entidades.Pacientes;
import com.saludtec.entidades.Usuarios;
import com.saludtec.jpa.UsuariosEjb;
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
@WebServlet(name = "UsuariosWeb", urlPatterns = {"/Usuarios/*"})
public class UsuariosWeb extends HttpServlet {

    @EJB
    UsuariosEjb ejbUsuarios;
    JSONObject obj;
    JSONArray objArray;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String servicio = request.getRequestURI().replace("/HCEMed/Usuarios/", "");
            switch (servicio) {
                case "login":
                    login(request).writeJSONString(out);
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

    private JSONArray login(HttpServletRequest request) {
        Usuarios usuario = ejbUsuarios.login(request.getParameter("usuario"), request.getParameter("contrasena"));
        if (usuario != null) {
            request.getSession().setAttribute("usuario", usuario.getIdUsuario());
            List<Pacientes> pacientes = usuario.getPacientesList();
            objArray = new JSONArray();
            if (pacientes != null) {
                for (Pacientes paciente : pacientes) {
                    obj = new JSONObject();
                    obj.put("idPaciente", paciente.getIdPaciente());
                    obj.put("foto", paciente.getFoto());
                    obj.put("alertaMedica", paciente.getAlertaMedica());
                    obj.put("nombrePaciente", paciente.getNombrePaciente());
                    obj.put("apellidoPaciente", paciente.getApellidoPaciente());
                    obj.put("fechaNacimientoPaciente", paciente.getFechaNacimientoPaciente());
                    obj.put("tipoIdentificacionPaciente", paciente.getTipoIdentificacionPaciente());
                    obj.put("identificacionPaciente", paciente.getIdentificacionPaciente());
                    obj.put("estadoPaciente", paciente.getEstadoPaciente());
                    obj.put("estadoCivilPaciente", paciente.getEstadoCivilPaciente());
                    obj.put("sexoPaciente", paciente.getSexoPaciente());
                    obj.put("razaPaciente", paciente.getRazaPaciente());
                    obj.put("ocupacionPaciente", paciente.getOcupacionPaciente());
                    obj.put("telefonoPaciente", paciente.getTelefonoPaciente());
                    obj.put("celularPaciente", paciente.getCelularPaciente());
                    obj.put("emailPaciente", paciente.getEmailPaciente());
                    obj.put("paisPaciente", paciente.getPaisPaciente());
                    obj.put("departamentoPaciente", paciente.getDepartamentoPaciente());
                    obj.put("ciudadPaciente", paciente.getCiudadPaciente());
                    obj.put("nacionalidadPaciente", paciente.getNacionalidadPaciente());
                    obj.put("direccionPaciente", paciente.getDireccionPaciente());
                    obj.put("zonaResidencialPaciente", paciente.getZonaResidencialPaciente());
                    obj.put("codigoPostalPaciente", paciente.getCodigoPostalPaciente());
                    obj.put("estratoPaciente", paciente.getEstratoPaciente());
                    obj.put("companiaSeguroPaciente", paciente.getCompaniaSeguroPaciente());
                    obj.put("tipoVinculacionPaciente", paciente.getTipoVinculacionPaciente());
                    obj.put("nombreRepresentante", paciente.getNombreRepresentante());
                    obj.put("apellidoRepresentante", paciente.getApellidoRepresentante());
                    obj.put("tipoIdentificacionRepresentante", paciente.getTipoIdentificacionRepresentante());
                    obj.put("getIdentificacionRepresentante", paciente.getIdentificacionRepresentante());
                    obj.put("telefonoRepresentante", paciente.getTelefonoRepresentante());
                    obj.put("parentescoRepresentante", paciente.getParentescoRepresentante());
                    obj.put("nombreEmergencia", paciente.getNombreEmergencia());
                    obj.put("telefonoEmergencia", paciente.getTelefonoEmergencia());
                    obj.put("parentescoEmergencia", paciente.getParentescoEmergencia());
                    obj.put("nombreReferido", paciente.getNombreReferido());
                    obj.put("fechaCreacion", paciente.getFechaCreacion());
                    obj.put("horaCreacion", paciente.getHoraCreacion());
                    objArray.add(obj);
                }
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
