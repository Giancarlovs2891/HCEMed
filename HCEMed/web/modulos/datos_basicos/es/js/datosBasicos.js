//por si quiero agregar hora y minuto a la fecha actual

// + ' ' + dNow.getHours() + ':' + dNow.getMinutes();
var datosCompletos = 0;
function fechaActuall() {
    var dNow = new Date();
    var fechaHoy = (dNow.getMonth() + 1) + '/' + dNow.getDate() + '/' + dNow.getFullYear();
    var fechaPaciente = $("#fechaNacimientoPaciente").val();
    fechaPaciente = new Date(fechaPaciente);

    var edad = dNow.getFullYear() - fechaPaciente.getFullYear();
    if (edad < 18) {
        $("#representante :text").css("border", "1px solid red");
//        $("#representante .form-group").addClass("has-error");
        datosCompletos = 1;
    }
    else {
        datosCompletos = 0;
    }
}

function verificaEdad() {
    if (datosCompletos == 1) {
        alert("complete los campos en rojo");
    }
    else {
        guardarPaciente();
    }
}

function revisaCampo(input) {
    var campo = $(input).val();
    if (campo != "") {
        $(input).css("border", "1px solid #ccc");
//$("input .form-group").removeClass("has-error");
        if ($("#nombreRepresentante").val() == "" || $("#apellidoRepresentante").val() == "" || $("#identificacionRepresentante").val() == "" || $("#telefonoRepresentante").val() == "" || $("#parentescoRepresentante").val() == "") {
            datosCompletos = 1;
        }
        else {
            datosCompletos = 0;
        }
    }
    else {
        $(input).css("border", "1px solid red");
//$("input .form-group").addClass("has-error");
        datosCompletos = 1;
    }
}

function validaCampos(){
    var elementos = new Array();
    elementos[0] = "nombrePaciente";
    elementos[1] = "apellidoPaciente";
    elementos[2] = "fechaNacimientoPaciente";
    elementos[3] = "tipoIdentificacionPaciente";
    elementos[4] = "identificacionPaciente";
    elementos[5] = "estadoPaciente";
    elementos[6] = "estadoCivilPaciente";
    elementos[7] = "sexoPaciente";
    elementos[8] = "razaPaciente";
    elementos[9] = "ocupacionPaciente";
    elementos[10] = "telefonoPaciente";
    elementos[11] = "celularPaciente";
    elementos[12] = "emailPaciente";
    elementos[13] = "paisPaciente";
    elementos[14] = "departamentoPaciente";
    elementos[15] = "ciudadPaciente";
    elementos[16] = "nacionalidadPaciente";
    elementos[17] = "direccionPaciente";
    elementos[18] = "zonaResidencialPaciente";
    elementos[19] = "codigoPostalPaciente";
    elementos[20] = "estratoPaciente";
    elementos[21] = "companiaSeguroPaciente";
    elementos[22] = "tipoVinculacionPaciente";
    
    var problema=0;
    
    for(var i=0;i<elementos.length;i++){
        if(document.getElementById(elementos[i]).value == ""){
            document.getElementById(elementos[i]).className = "form-control error";
            problema = 1;
        }else{
            document.getElementById(elementos[i]).className = "form-control";
        }
    }
    return problema;
    
}