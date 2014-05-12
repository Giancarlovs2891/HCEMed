/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saludtec.web;

import com.saludtec.entidades.Pacientes;
import com.saludtec.jpa.PacientesEjb;
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
@WebServlet(name = "NewServlet", urlPatterns = {"/Pacientes/*"})
public class PacientesWeb extends HttpServlet {

    @EJB
    PacientesEjb ejbPacientes;
    UsuariosEjb ejbUsuarios;
    JSONObject obj;
    JSONArray objArray;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String servicio = request.getRequestURI().replace("/HCEMed/Pacientes/", "");
            switch (servicio) {
                case "guardar":
                    guardarPaciente(request).writeJSONString(out);
                    break;

                case "editar":
                    editarPaciente(request).writeJSONString(out);
                    break;

                case "traer":
                    traerPaciente(request).writeJSONString(out);
                    break;

                case "listar":
                    listarPacientesUsuario(request).writeJSONString(out);
                    break;

                case "like":
                    listarPacientesLike(request).writeJSONString(out);
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

    private JSONArray guardarPaciente(HttpServletRequest request) {
        Pacientes paciente = new Pacientes();
        paciente.setFoto(request.getParameter("foto"));
        paciente.setAlertaMedica(request.getParameter("alertaMedica"));
        paciente.setNombrePaciente(request.getParameter("nombrePaciente"));
        paciente.setApellidoPaciente(request.getParameter("apellidoPaciente"));
        paciente.setFechaNacimientoPaciente(request.getParameter("fechaNacimientoPaciente"));
        paciente.setTipoIdentificacionPaciente(request.getParameter("tipoIdentificacionPaciente"));
        paciente.setIdentificacionPaciente(request.getParameter("identificacionPaciente"));
        paciente.setEstadoPaciente(request.getParameter("estadoPaciente"));
        paciente.setEstadoCivilPaciente(request.getParameter("estadoCivilPaciente"));
        paciente.setSexoPaciente(request.getParameter("sexoPaciente"));
        paciente.setRazaPaciente(request.getParameter("razaPaciente"));
        paciente.setOcupacionPaciente(request.getParameter("ocupacionPaciente"));
        paciente.setTelefonoPaciente(request.getParameter("telefonoPaciente"));
        paciente.setCelularPaciente(request.getParameter("celularPaciente"));
        paciente.setEmailPaciente(request.getParameter("emailPaciente"));
        paciente.setPaisPaciente(request.getParameter("paisPaciente"));
        paciente.setDepartamentoPaciente(request.getParameter("departamentoPaciente"));
        paciente.setCiudadPaciente(request.getParameter("ciudadPaciente"));
        paciente.setNacionalidadPaciente(request.getParameter("nacionalidadPaciente"));
        paciente.setDireccionPaciente(request.getParameter("direccionPaciente"));
        paciente.setZonaResidencialPaciente(request.getParameter("zonaResidencialPaciente"));
        paciente.setCodigoPostalPaciente(request.getParameter("codigoPostalPaciente"));
        paciente.setEstratoPaciente(request.getParameter("estratoPaciente"));
        paciente.setCompaniaSeguroPaciente(request.getParameter("companiaSeguroPaciente"));
        paciente.setTipoVinculacionPaciente(request.getParameter("tipoVinculacionPaciente"));
        paciente.setNombreRepresentante(request.getParameter("nombreRepresentante"));
        paciente.setApellidoRepresentante(request.getParameter("apellidoRepresentante"));
        paciente.setTipoIdentificacionRepresentante(request.getParameter("tipoIdentificacionRepresentante"));
        paciente.setIdentificacionRepresentante(request.getParameter("identificacionRepresentante"));
        paciente.setTelefonoRepresentante(request.getParameter("telefonoRepresentante"));
        paciente.setParentescoRepresentante(request.getParameter("parentescoRepresentante"));
        paciente.setNombreEmergencia(request.getParameter("nombreEmergencia"));
        paciente.setTelefonoEmergencia(request.getParameter("telefonoEmergencia"));
        paciente.setParentescoEmergencia(request.getParameter("parentescoEmergencia"));
        paciente.setNombreReferido(request.getParameter("nombreReferido"));
        paciente.setFechaCreacion(request.getParameter("fechaCreacion"));
        paciente.setHoraCreacion(request.getParameter("horaCreacion"));
        paciente.setIdUsuario(ejbUsuarios.traer(Integer.parseInt(request.getSession().getAttribute("usuario").toString())));//RECORDAR QUE ESTE VALOR ESTA QUEMADO Y HAY QUE CAMBIARLO CUANDO SE CREE LA TABLA USUARIOS
        paciente = ejbPacientes.crear(paciente);
        obj = new JSONObject();
        objArray = new JSONArray();
        if (paciente != null) {
            obj.put("idPaciente", paciente.getIdPaciente());
            obj.put("nombrePaciente", paciente.getNombrePaciente());
            obj.put("apellidoPaciente", paciente.getApellidoPaciente());
            objArray.add(obj);
        } else {
            obj.put("error", "no se pudo guardar la categoria");
            objArray.add(obj);
        }
        return objArray;
    }

    private JSONArray editarPaciente(HttpServletRequest request) {
        Pacientes paciente = new Pacientes();
        paciente.setIdPaciente(Integer.parseInt(request.getParameter("idPaciente")));
        paciente.setFoto(request.getParameter("foto"));
        paciente.setAlertaMedica(request.getParameter("alertaMedica"));
        paciente.setNombrePaciente(request.getParameter("nombrePaciente"));
        paciente.setApellidoPaciente(request.getParameter("apellidoPaciente"));
        paciente.setFechaNacimientoPaciente(request.getParameter("fechaNacimientoPaciente"));
        paciente.setTipoIdentificacionPaciente(request.getParameter("tipoIdentificacionPaciente"));
        paciente.setIdentificacionPaciente(request.getParameter("identificacionPaciente"));
        paciente.setEstadoPaciente(request.getParameter("estadoPaciente"));
        paciente.setEstadoCivilPaciente(request.getParameter("estadoCivilPaciente"));
        paciente.setSexoPaciente(request.getParameter("sexoPaciente"));
        paciente.setRazaPaciente(request.getParameter("razaPaciente"));
        paciente.setOcupacionPaciente(request.getParameter("ocupacionPaciente"));
        paciente.setTelefonoPaciente(request.getParameter("telefonoPaciente"));
        paciente.setCelularPaciente(request.getParameter("celularPaciente"));
        paciente.setEmailPaciente(request.getParameter("emailPaciente"));
        paciente.setPaisPaciente(request.getParameter("paisPaciente"));
        paciente.setDepartamentoPaciente(request.getParameter("departamentoPaciente"));
        paciente.setCiudadPaciente(request.getParameter("ciudadPaciente"));
        paciente.setNacionalidadPaciente(request.getParameter("nacionalidadPaciente"));
        paciente.setDireccionPaciente(request.getParameter("direccionPaciente"));
        paciente.setZonaResidencialPaciente(request.getParameter("zonaResidencialPaciente"));
        paciente.setCodigoPostalPaciente(request.getParameter("codigoPostalPaciente"));
        paciente.setEstratoPaciente(request.getParameter("estratoPaciente"));
        paciente.setCompaniaSeguroPaciente(request.getParameter("companiaSeguroPaciente"));
        paciente.setTipoVinculacionPaciente(request.getParameter("tipoVinculacionPaciente"));
        paciente.setNombreRepresentante(request.getParameter("nombreRepresentante"));
        paciente.setApellidoRepresentante(request.getParameter("apellidoRepresentante"));
        paciente.setTipoIdentificacionRepresentante(request.getParameter("tipoIdentificacionRepresentante"));
        paciente.setIdentificacionRepresentante(request.getParameter("identificacionRepresentante"));
        paciente.setTelefonoRepresentante(request.getParameter("telefonoRepresentante"));
        paciente.setParentescoRepresentante(request.getParameter("parentescoRepresentante"));
        paciente.setNombreEmergencia(request.getParameter("nombreEmergencia"));
        paciente.setTelefonoEmergencia(request.getParameter("telefonoEmergencia"));
        paciente.setParentescoEmergencia(request.getParameter("parentescoEmergencia"));
        paciente.setNombreReferido(request.getParameter("nombreReferido"));
        paciente.setFechaCreacion(request.getParameter("fechaCreacion"));
        paciente.setHoraCreacion(request.getParameter("horaCreacion"));
        paciente.setIdUsuario(ejbUsuarios.traer(Integer.parseInt(request.getSession().getAttribute("usuario").toString())));//RECORDAR QUE ESTE VALOR ESTA QUEMADO Y HAY QUE CAMBIARLO CUANDO SE CREE LA TABLA USUARIOS
        paciente = ejbPacientes.editar(paciente);
        obj = new JSONObject();
        objArray = new JSONArray();
        if (paciente != null) {
            obj.put("mensaje", "Registro con id " + paciente.getIdPaciente() + " editado");
            objArray.add(obj);
        } else {
            obj.put("error", "no se pudo editar la categoria");
            objArray.add(obj);
        }
        return objArray;
    }

    private JSONObject eliminarPaciente(HttpServletRequest request) {
        ejbPacientes.eliminar(Integer.parseInt(request.getParameter("idPaciente")));
        obj = new JSONObject();
        obj.put("menasaje", "eliminado");
        return obj;
    }

    private JSONArray traerPaciente(HttpServletRequest request) {
        Pacientes paciente = ejbPacientes.traer(Integer.parseInt(request.getParameter("idPaciente")));
        obj = new JSONObject();
        objArray = new JSONArray();
        if (paciente != null) {
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
        return objArray;
    }

    private JSONArray listarPacientes() {
        List<Pacientes> pacientes = ejbPacientes.listar();
        objArray = new JSONArray();
        if (pacientes != null) {
            for (Pacientes paciente : pacientes) {
                obj = new JSONObject();
                obj.put("idPaciente", paciente.getIdPaciente());
                obj.put("foto", paciente.getFoto());
                obj.put("nombrePaciente", paciente.getNombrePaciente());
                obj.put("apellidoPaciente", paciente.getApellidoPaciente());
                obj.put("tipoIdentificacionPaciente", paciente.getTipoIdentificacionPaciente());
                obj.put("identificacionPaciente", paciente.getIdentificacionPaciente());
                objArray.add(obj);
            }
        }
        return objArray;
    }
    
    private JSONArray listarPacientesUsuario(HttpServletRequest request) {
        List<Pacientes> pacientes = ejbPacientes.listar(Integer.parseInt(request.getSession().getAttribute("usuario").toString()));
        objArray = new JSONArray();
        if (pacientes != null) {
            for (Pacientes paciente : pacientes) {
                obj = new JSONObject();
                obj.put("idPaciente", paciente.getIdPaciente());
                obj.put("foto", paciente.getFoto());
                obj.put("nombrePaciente", paciente.getNombrePaciente());
                obj.put("apellidoPaciente", paciente.getApellidoPaciente());
                obj.put("tipoIdentificacionPaciente", paciente.getTipoIdentificacionPaciente());
                obj.put("identificacionPaciente", paciente.getIdentificacionPaciente());
                objArray.add(obj);
            }
        }
        return objArray;
    }

    private JSONArray listarPacientesLike(HttpServletRequest request) {
        Pacientes like = new Pacientes();
        like.setNombrePaciente(request.getParameter("nombrePaciente"));
        like.setApellidoPaciente(request.getParameter("apellidoPaciente"));
        like.setIdentificacionPaciente(request.getParameter("identificacionPaciente"));
        List<Pacientes> pacientes = ejbPacientes.listar(like);
        objArray = new JSONArray();
        if (pacientes != null) {
            for (Pacientes paciente : pacientes) {
                obj = new JSONObject();
                obj.put("idCategoria", paciente.getIdPaciente());
                obj.put("categoriaProcedimiento", paciente.getNombrePaciente());
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
