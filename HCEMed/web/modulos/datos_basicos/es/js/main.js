start();
function start() {
    loadJsFile("modulos/datos_basicos/es/js/datosBasicos.js");
    loadCssFile("modulos/datos_basicos/es/css/main.css");
    crearTabla('CREATE TABLE IF NOT EXISTS Pacientes (idPaciente INTEGER PRIMARY KEY AUTOINCREMENT, foto, alertaMedica, nombrePaciente, apellidoPaciente, fechaNacimientoPaciente, tipoIdentificacionPaciente, identificacionPaciente, estadoPaciente, estadoCivilPaciente, sexoPaciente, razaPaciente, ocupacionPaciente, telefonoPaciente, celularPaciente, emailPaciente, paisPaciente, departamentoPaciente, ciudadPaciente, nacionalidadPaciente, direccionPaciente, zonaResidencialPaciente, codigoPostalPaciente, estratoPaciente, companiaSeguroPaciente, tipoVinculacionPaciente, nombreRepresentante, apellidoRepresentante, tipoIdentificacionRepresentante, identificacionRepresentante, telefonoRepresentante, parentescoRepresentante, nombreEmergencia, telefonoEmergencia, parentescoEmergencia, nombreReferido, fechaCreacion, horaCreacion)');
    var idPaciente = getPatientId();

    var iOS = ( navigator.userAgent.match(/(iPad|iPhone|iPod|Android|IEMobile|BlackBerry)/g) ? true : false );
        if (iOS == "1"){

         document.getElementById("camaraPacienteDatosBasicos").style.display = "none";
         document.getElementById("fotoPickerDatosBasicos").style.backgroundImage = 'url("img/camerabg.png")';

        }
  
    if (idPaciente == "NaN") {
        changeRightBtn("Guardar", "verificaPaciente", "");
    }
    else {
        changeRightBtn("Editar", "habilitarEdicion", "");
        var query = "SELECT * FROM Pacientes WHERE idPaciente = '" + idPaciente + "'";
        traerTabla("Pacientes", "idPaciente="+idPaciente, cargarPacienteInicio);
    }
    changeSubTitle("Datos Basicos");
}


function cargarPacienteInicio(x) {
    var obj = JSON.parse(x);
    var foto = decodeURIComponent(obj[0].foto);
    $("#alertaMedica").val(obj[0].alertaMedica);
    $("#nombrePaciente").val(obj[0].nombrePaciente);
    $("#apellidoPaciente").val(obj[0].apellidoPaciente);
    $("#fechaNacimientoPaciente").val(obj[0].fechaNacimientoPaciente);
    $("#tipoIdentificacionPaciente").val(obj[0].tipoIdentificacionPaciente);
    $("#identificacionPaciente").val(obj[0].identificacionPaciente);
    $("#estadoPaciente").val(obj[0].estadoPaciente);
    $("estadoCivilPaciente").val(obj[0].estadoCivilPaciente);
    $("#sexoPaciente").val(obj[0].sexoPaciente);
    $("#razaPaciente").val(obj[0].razaPaciente);
    $("#ocupacionPaciente").val(obj[0].ocupacionPaciente);
    $("#telefonoPaciente").val(obj[0].telefonoPaciente);
    $("#celularPaciente").val(obj[0].celularPaciente);
    $("#emailPaciente").val(obj[0].emailPaciente);
    $("#paisPaciente").val(obj[0].paisPaciente);
    $("#departamentoPaciente").val(obj[0].departamentoPaciente);
    $("#ciudadPaciente").val(obj[0].ciudadPaciente);
    $("#nacionalidadPaciente").val(obj[0].nacionalidadPaciente);
    $("#direccionPaciente").val(obj[0].direccionPaciente);
    $("#zonaResidencialPaciente").val(obj[0].zonaResidencialPaciente);
    $("#codigoPostalPaciente").val(obj[0].codigoPostalPaciente);
    $("#estratoPaciente").val(obj[0].estratoPaciente);
    $("#companiaSeguroPaciente").val(obj[0].companiaSeguroPaciente);
    $("#tipoVinculacionPaciente").val(obj[0].tipoVinculacionPaciente);
    $("#nombreRepresentante").val(obj[0].nombreRepresentante);
    $("#apellidoRepresentante").val(obj[0].apellidoRepresentante);
    $("#tipoIdentificacionRepresentante").val(obj[0].tipoIdentificacionRepresentante);
    $("#identificacionRepresentante").val(obj[0].identificacionRepresentante);
    $("#telefonoRepresentante").val(obj[0].telefonoRepresentante);
    $("#parentescoRepresentante").val(obj[0].parentescoRepresentante);
    $("#nombreEmergencia").val(obj[0].nombreEmergencia);
    $("#telefonoEmergencia").val(obj[0].telefonoEmergencia);
    $("#parentescoEmergencia").val(obj[0].parentescoEmergencia);
    $("#nombreReferido").val(obj[0].nombreReferido);
    $("#fotoPrincipalDatosBasicos").attr("src", foto);
    $("#fotoMenuDatosBasicos").attr("src", foto);
 
    document.getElementById("nombrePacienteGeneralMedsio").innerHTML = obj[0].nombrePaciente+" "+obj[0].apellidoPaciente+" - "+obj[0].sexoPaciente.toUpperCase();
    document.getElementById("alertaMedicaGeneralMedsio").innerHTML = obj[0].alertaMedica;
    sexoPacienteSeleccionado = obj[0].sexoPaciente;
    changeRightBtn("Editar", "habilitarEdicion", "");

    $("input, textarea").prop("disabled", true);
    $("select").prop("disabled", true);
}
function cargarPaciente(x) {
    var obj = JSON.parse(x);
    var foto = decodeURIComponent(obj[0].foto);
    $("#alertaMedica").val(obj[0].alertaMedica);
    $("#nombrePaciente").val(obj[0].nombrePaciente);
    $("#apellidoPaciente").val(obj[0].apellidoPaciente);
    $("#fechaNacimientoPaciente").val(obj[0].fechaNacimientoPaciente);
    $("#tipoIdentificacionPaciente").val(obj[0].tipoIdentificacionPaciente);
    $("#identificacionPaciente").val(obj[0].identificacionPaciente);
    $("#estadoPaciente").val(obj[0].estadoPaciente);
    $("estadoCivilPaciente").val(obj[0].estadoCivilPaciente);
    $("#sexoPaciente").val(obj[0].sexoPaciente);
    $("#razaPaciente").val(obj[0].razaPaciente);
    $("#ocupacionPaciente").val(obj[0].ocupacionPaciente);
    $("#telefonoPaciente").val(obj[0].telefonoPaciente);
    $("#celularPaciente").val(obj[0].celularPaciente);
    $("#emailPaciente").val(obj[0].emailPaciente);
    $("#paisPaciente").val(obj[0].paisPaciente);
    $("#departamentoPaciente").val(obj[0].departamentoPaciente);
    $("#ciudadPaciente").val(obj[0].ciudadPaciente);
    $("#nacionalidadPaciente").val(obj[0].nacionalidadPaciente);
    $("#direccionPaciente").val(obj[0].direccionPaciente);
    $("#zonaResidencialPaciente").val(obj[0].zonaResidencialPaciente);
    $("#codigoPostalPaciente").val(obj[0].codigoPostalPaciente);
    $("#estratoPaciente").val(obj[0].estratoPaciente);
    $("#companiaSeguroPaciente").val(obj[0].companiaSeguroPaciente);
    $("#tipoVinculacionPaciente").val(obj[0].tipoVinculacionPaciente);
    $("#nombreRepresentante").val(obj[0].nombreRepresentante);
    $("#apellidoRepresentante").val(obj[0].apellidoRepresentante);
    $("#tipoIdentificacionRepresentante").val(obj[0].tipoIdentificacionRepresentante);
    $("#identificacionRepresentante").val(obj[0].identificacionRepresentante);
    $("#telefonoRepresentante").val(obj[0].telefonoRepresentante);
    $("#parentescoRepresentante").val(obj[0].parentescoRepresentante);
    $("#nombreEmergencia").val(obj[0].nombreEmergencia);
    $("#telefonoEmergencia").val(obj[0].telefonoEmergencia);
    $("#parentescoEmergencia").val(obj[0].parentescoEmergencia);
    $("#nombreReferido").val(obj[0].nombreReferido);
    $("#fotoPrincipalDatosBasicos").attr("src", foto);

    document.getElementById("nombrePacienteGeneralMedsio").innerHTML = obj[0].nombrePaciente+" "+obj[0].apellidoPaciente+" - "+obj[0].sexoPaciente.toUpperCase();
    document.getElementById("alertaMedicaGeneralMedsio").innerHTML = obj[0].alertaMedica;
    
    sexoPacienteSeleccionado = obj[0].sexoPaciente;
    changeRightBtn("Editar", "habilitarEdicion", "");
}

var identificacionPaciente = "";
function guardarPaciente() {
    var diaCreacion = fechaActual();
    var horaCreacion = horaActual();
    var alertaMedica = $("#alertaMedica").val();
    var nombrePaciente = $("#nombrePaciente").val();
    var apellidoPaciente = $("#apellidoPaciente").val();
    var fechaNacimientoPaciente = $("#fechaNacimientoPaciente").val();
    var tipoIdentificacionPaciente = $("#tipoIdentificacionPaciente").val();
    identificacionPaciente = $("#identificacionPaciente").val();
    var estadoPaciente = $("#estadoPaciente").val();
    var estadoCivilPaciente = $("#estadoCivilPaciente").val();
    var sexoPaciente = $("#sexoPaciente").val();
    var razaPaciente = $("#razaPaciente").val();
    var ocupacionPaciente = $("#ocupacionPaciente").val();
    var telefonoPaciente = $("#telefonoPaciente").val();
    var celularPaciente = $("#celularPaciente").val();
    var emailPaciente = $("#emailPaciente").val();
    var paisPaciente = $("#paisPaciente").val();
    var departamentoPaciente = $("#departamentoPaciente").val();
    var ciudadPaciente = $("#ciudadPaciente").val();
    var nacionalidadPaciente = $("#nacionalidadPaciente").val();
    var direccionPaciente = $("#direccionPaciente").val();
    var zonaResidencialPaciente = $("#zonaResidencialPaciente").val();
    var codigoPostalPaciente = $("#codigoPostalPaciente").val();
    var estratoPaciente = $("#estratoPaciente").val();
    var companiaSeguroPaciente = $("#companiaSeguroPaciente").val();
    var tipoVinculacionPaciente = $("#tipoVinculacionPaciente").val();
    var nombreRepresentante = $("#nombreRepresentante").val();
    var apellidoRepresentante = $("#apellidoRepresentante").val();
    var tipoIdentificacionRepresentante = $("#tipoIdentificacionRepresentante").val();
    var identificacionRepresentante = $("#identificacionRepresentante").val();
    var telefonoRepresentante = $("#telefonoRepresentante").val();
    var parentescoRepresentante = $("#parentescoRepresentante").val();
    var nombreEmergencia = $("#nombreEmergencia").val();
    var telefonoEmergencia = $("#telefonoEmergencia").val();
    var parentescoEmergencia = $("#parentescoEmergencia").val();
    var nombreReferido = $("#nombreReferido").val();
    var foto = $("#inputImagen").val();
    if (foto == "") {
        foto = "modulos/datos_basicos/img/fotoPerfil.png";
    }
    foto = encodeURIComponent(foto);
    sexoPacienteSeleccionado = $("#sexoPaciente").val();
    var string = 'foto=' + foto + '&alertaMedica=' + alertaMedica + '&nombrePaciente=' + nombrePaciente + '&apellidoPaciente=' + apellidoPaciente + '&fechaNacimientoPaciente=' + fechaNacimientoPaciente + '&tipoIdentificacionPaciente=' + tipoIdentificacionPaciente + '&identificacionPaciente=' + identificacionPaciente + '&estadoPaciente=' + estadoPaciente + '&estadoCivilPaciente=' + estadoCivilPaciente + '&sexoPaciente=' + sexoPaciente + '&razaPaciente=' + razaPaciente + '&ocupacionPaciente=' + ocupacionPaciente + '&telefonoPaciente=' + telefonoPaciente + '&celularPaciente=' + celularPaciente + '&emailPaciente=' + emailPaciente + '&paisPaciente=' + paisPaciente + '&departamentoPaciente=' + departamentoPaciente + '&ciudadPaciente=' + ciudadPaciente + '&nacionalidadPaciente=' + nacionalidadPaciente + '&direccionPaciente=' + direccionPaciente + '&zonaResidencialPaciente=' + zonaResidencialPaciente + '&codigoPostalPaciente=' + codigoPostalPaciente + '&estratoPaciente=' + estratoPaciente + '&companiaSeguroPaciente=' + companiaSeguroPaciente + '&tipoVinculacionPaciente=' + tipoVinculacionPaciente + '&nombreRepresentante=' + nombreRepresentante + '&apellidoRepresentante=' + apellidoRepresentante + '&tipoIdentificacionRepresentante=' + tipoIdentificacionRepresentante + '&identificacionRepresentante=' + identificacionRepresentante + '&telefonoRepresentante=' + telefonoRepresentante + '&parentescoRepresentante=' + parentescoRepresentante + '&nombreEmergencia=' + nombreEmergencia + '&telefonoEmergencia=' + telefonoEmergencia + '&parentescoEmergencia=' + parentescoEmergencia + '&nombreReferido=' + nombreReferido + '&fechaCreacion=' + diaCreacion + '&horaCreacion=' + horaCreacion;

    guardarTabla('Pacientes', string, guardarSuccess);
    
    document.getElementById("nombrePacienteGeneralMedsio").innerHTML = nombrePaciente+" "+apellidoPaciente+" - "+sexoPaciente.toUpperCase();
    document.getElementById("alertaMedicaGeneralMedsio").innerHTML = alertaMedica;
}

function verificaPaciente() {
    var x = validaCampos();
    if (x == 1) {
        alert("Debe llenar los campos en rojo");
        return;
    }
    var documentoPaciente = $("#identificacionPaciente").val();


    var query = "SELECT * FROM Pacientes WHERE identificacionPaciente = '" + documentoPaciente + "'";
    crearSql(query, verificaPacienteSuccess);

    function verificaPacienteSuccess(x) {
        if (x != "[]") {
            alert("Este paciente ya existe en nuestros registros");
        }
        else {
            verificaEdad();
        }

    }
}

function guardarSuccess() {
    $("input, textarea").prop("disabled", true);
    $("select").prop("disabled", true);
    changeRightBtn("Editar", "habilitarEdicion", "");
    if(modoMedsio == "local"){
        var query = "SELECT idPaciente FROM Pacientes WHERE identificacionPaciente = '" + identificacionPaciente + "'";
        crearSql(query, guardarSuccess2);
    }else{
        var service = "Pacientes/traerIdentificacion";
        var string = "identificacionPaciente="+identificacionPaciente;
        
        ajax(service, string, guardarSuccess2);
    }
}

function guardarSuccess2(x) {
    var obj = JSON.parse(x);
    idPacienteSeleccionado = obj[0].idPaciente;
    sexoPacienteSeleccionado = obj[0].sexoPaciente;
}

function habilitarEdicion() {
    $("input").prop("disabled", false);
    $("textarea").prop("disabled", false);
    $("select").prop("disabled", false);
    changeRightBtn("Guardar", "editarPaciente", "");
}

function editarPaciente() {
    var diaCreacion = fechaActual();
    var horaCreacion = horaActual();
    var alertaMedica = $("#alertaMedica").val();
    var nombrePaciente = $("#nombrePaciente").val();
    var apellidoPaciente = $("#apellidoPaciente").val();
    var fechaNacimientoPaciente = $("#fechaNacimientoPaciente").val();
    var tipoIdentificacionPaciente = $("#tipoIdentificacionPaciente").val();
    var identificacionPaciente = $("#identificacionPaciente").val();
    var estadoPaciente = $("#estadoPaciente").val();
    var estadoCivilPaciente = $("#estadoCivilPaciente").val();
    var sexoPaciente = $("#sexoPaciente").val();
    var razaPaciente = $("#razaPaciente").val();
    var ocupacionPaciente = $("#ocupacionPaciente").val();
    var telefonoPaciente = $("#telefonoPaciente").val();
    var celularPaciente = $("#celularPaciente").val();
    var emailPaciente = $("#emailPaciente").val();
    var paisPaciente = $("#paisPaciente").val();
    var departamentoPaciente = $("#departamentoPaciente").val();
    var ciudadPaciente = $("#ciudadPaciente").val();
    var nacionalidadPaciente = $("#nacionalidadPaciente").val();
    var direccionPaciente = $("#direccionPaciente").val();
    var zonaResidencialPaciente = $("#zonaResidencialPaciente").val();
    var codigoPostalPaciente = $("#codigoPostalPaciente").val();
    var estratoPaciente = $("#estratoPaciente").val();
    var companiaSeguroPaciente = $("#companiaSeguroPaciente").val();
    var tipoVinculacionPaciente = $("#tipoVinculacionPaciente").val();
    var nombreRepresentante = $("#nombreRepresentante").val();
    var apellidoRepresentante = $("#apellidoRepresentante").val();
    var tipoIdentificacionRepresentante = $("#tipoIdentificacionRepresentante").val();
    var identificacionRepresentante = $("#identificacionRepresentante").val();
    var telefonoRepresentante = $("#telefonoRepresentante").val();
    var parentescoRepresentante = $("#parentescoRepresentante").val();
    var nombreEmergencia = $("#nombreEmergencia").val();
    var telefonoEmergencia = $("#telefonoEmergencia").val();
    var parentescoEmergencia = $("#parentescoEmergencia").val();
    var nombreReferido = $("#nombreReferido").val();
    var foto = $("#inputImagen").val();
    foto = encodeURIComponent(foto);
    

    sexoPacienteSeleccionado = $("#sexoPaciente").val();
    var string = 'alertaMedica=' + alertaMedica + '&nombrePaciente=' + nombrePaciente + '&apellidoPaciente=' + apellidoPaciente + '&fechaNacimientoPaciente=' + fechaNacimientoPaciente + '&tipoIdentificacionPaciente=' + tipoIdentificacionPaciente + '&identificacionPaciente=' + identificacionPaciente + '&estadoPaciente=' + estadoPaciente + '&estadoCivilPaciente=' + estadoCivilPaciente + '&sexoPaciente=' + sexoPaciente + '&razaPaciente=' + razaPaciente + '&ocupacionPaciente=' + ocupacionPaciente + '&telefonoPaciente=' + telefonoPaciente + '&celularPaciente=' + celularPaciente + '&emailPaciente=' + emailPaciente + '&paisPaciente=' + paisPaciente + '&departamentoPaciente=' + departamentoPaciente + '&ciudadPaciente=' + ciudadPaciente + '&nacionalidadPaciente=' + nacionalidadPaciente + '&direccionPaciente=' + direccionPaciente + '&zonaResidencialPaciente=' + zonaResidencialPaciente + '&codigoPostalPaciente=' + codigoPostalPaciente + '&estratoPaciente=' + estratoPaciente + '&companiaSeguroPaciente=' + companiaSeguroPaciente + '&tipoVinculacionPaciente=' + tipoVinculacionPaciente + '&nombreRepresentante=' + nombreRepresentante + '&apellidoRepresentante=' + apellidoRepresentante + '&tipoIdentificacionRepresentante=' + tipoIdentificacionRepresentante + '&identificacionRepresentante=' + identificacionRepresentante + '&telefonoRepresentante=' + telefonoRepresentante + '&parentescoRepresentante=' + parentescoRepresentante + '&nombreEmergencia=' + nombreEmergencia + '&telefonoEmergencia=' + telefonoEmergencia + '&parentescoEmergencia=' + parentescoEmergencia + '&nombreReferido=' + nombreReferido + '&fechaCreacion=' + diaCreacion + '&horaCreacion=' + horaCreacion + '&idPaciente=' + idPacienteSeleccionado;
    var foto = encodeURIComponent(document.getElementById("fotoPrincipalDatosBasicos").src);
        string = "foto="+foto+"&"+string;
    
    editarTabla('Pacientes', string, editarSuccess);
    document.getElementById("nombrePacienteGeneralMedsio").innerHTML = nombrePaciente+" "+apellidoPaciente+" - "+sexoPaciente.toUpperCase();
    document.getElementById("alertaMedicaGeneralMedsio").innerHTML = alertaMedica;
}

function editarSuccess() {
    $("input, textarea").prop("disabled", true);
    $("select").prop("disabled", true);
    changeRightBtn("Editar", "habilitarEdicion", "");
}


function seleccionarArchivoDatosBasicos() {
    document.getElementById('filesDatosBasicos').click();
}

function traerFoto(id, funcion) {
    var selectedFile = document.getElementById(id).files[0];
    var reader = new FileReader();

    reader.onload = function(event) {
        var imagen = event.target.result;
        funcion(imagen);

    };

    reader.readAsDataURL(selectedFile);
}
function subirFotoDatosBasicos() {
    traerFoto("filesDatosBasicos", subirFotoDatosBasicos2);
}
function subirFotoDatosBasicos2(img) {
    $("#fotoPrincipalDatosBasicos").attr("src", img);
    $("#fotoMenuDatosBasicos").attr("src", img);
    $("#inputImagen").val(img);
}
















