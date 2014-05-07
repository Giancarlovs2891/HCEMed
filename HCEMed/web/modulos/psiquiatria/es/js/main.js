loadJsFile('modulos/examen_fisico/es/js/utils.js');
loadJsFile('modulos/examen_fisico/es/js/crud.js');
loadCssFile('modulos/examen_fisico/es/css/main.css');
var tabla = "CREATE TABLE IF NOT EXISTS ExamenFisico (";
tabla += "idExamenFisico INTEGER PRIMARY KEY AUTOINCREMENT, ";
tabla += "idPaciente, ";
tabla += "tensionArterial, ";
tabla += "peso, ";
tabla += "cintura, ";
tabla += "pulso, ";
tabla += "talla, ";
tabla += "cadera, ";
tabla += "frecuenciaRespiratoria, ";
tabla += "bmi, ";
tabla += "indiceCintCad, ";
tabla += "piel, ";
tabla += "pielComentarioEf, ";
tabla += "ojos, ";
tabla += "ojosComentarioEf, ";
tabla += "oidosNarizGarganta, ";
tabla += "oidosNarizGargantaComentarioEf, ";
tabla += "cuello, ";
tabla += "cuelloComentarioEf, ";
tabla += "torax, ";
tabla += "toraxComentarioEf, ";
tabla += "cardiovascular, ";
tabla += "cardiovascularComentarioEf, ";
tabla += "respiratorios, ";
tabla += "respiratoriosComentarioEf, ";
tabla += "abdomen, ";
tabla += "abdomenComentarioEf, ";
tabla += "genitourinario, ";
tabla += "genitourinarioComentarioEf, ";
tabla += "extremidades, ";
tabla += "extremidadesComentarioEf, ";
tabla += "sistemaNerviosoCentral, ";
tabla += "sistemaNerviosoCentralComentarioEf, ";
tabla += "adenopatias, ";
tabla += "adenopatiasComentarioEf, ";
tabla += "otros, ";
tabla += "otrosComentarioEf, ";
tabla += "comentariosEf, ";
tabla += "condicionEf, ";
tabla += "fechaCreacionEf, ";
tabla += "horaCreacionEf";
tabla += ")";
start();

function start() {
    var storage = getModoMedsio();
    if (storage == "local") {
        crearTabla(tabla);
    } else {

    }
    changeSubTitle("Examen Físico");
    ultimoExamenFisico(getPatientId());
    $("#bmi, #indiceCintCad").prop("disabled", true);
}
function ultimoExamenFisico() {
    var sql = "SELECT * FROM ExamenFisico WHERE idPaciente='" + getPatientId() + "' ORDER BY idExamenFisico DESC LIMIT 0,1";
//    var sql = "SELECT * FROM ExamenFisico WHERE idPaciente='6' ORDER BY idExamenFisico DESC LIMIT 0,1";
    crearSql(sql, definirCamposExamenFisico);
}

function definirCamposExamenFisico(json) {
    var obj = JSON.parse(json);
    if (obj.length > 0) {
        changeRightBtn("Editar", "habilitarCamposEf", "");
        document.getElementById("tensionArterial").value = obj[0].tensionArterial;
        document.getElementById("peso").value = obj[0].peso;
        document.getElementById("cintura").value = obj[0].cintura;
        document.getElementById("pulso").value = obj[0].pulso;
        document.getElementById("talla").value = obj[0].talla;
        document.getElementById("cadera").value = obj[0].cadera;
        document.getElementById("frecuenciaRespiratoria").value = obj[0].frecuenciaRespiratoria;
        document.getElementById("bmi").value = obj[0].bmi;
        document.getElementById("indiceCintCad").value = obj[0].indiceCintCad;
        definirChecks("piel", obj[0].piel);
        definirChecks("ojos", obj[0].ojos);
        definirChecks("oidosNarizGarganta", obj[0].oidosNarizGarganta);
        definirChecks("cuello", obj[0].cuello);
        definirChecks("torax", obj[0].torax);
        definirChecks("cardiovascular", obj[0].cardiovascular);
        definirChecks("respiratorios", obj[0].respiratorios);
        definirChecks("abdomen", obj[0].abdomen);
        definirChecks("genitourinario", obj[0].genitourinario);
        definirChecks("extremidades", obj[0].extremidades);
        definirChecks("sistemaNerviosoCentral", obj[0].sistemaNerviosoCentral);
        definirChecks("adenopatias", obj[0].adenopatias);
        definirChecks("otros", obj[0].otros);
        document.getElementById("pielComentarioEf").value = obj[0].pielComentarioEf;
        document.getElementById("ojosComentarioEf").value = obj[0].ojosComentarioEf;
        document.getElementById("oidosNarizGargantaComentarioEf").value = obj[0].oidosNarizGargantaComentarioEf;
        document.getElementById("cuelloComentarioEf").value = obj[0].cuelloComentarioEf;
        document.getElementById("toraxComentarioEf").value = obj[0].toraxComentarioEf;
        document.getElementById("cardiovascularComentarioEf").value = obj[0].cardiovascularComentarioEf;
        document.getElementById("respiratoriosComentarioEf").value = obj[0].respiratoriosComentarioEf;
        document.getElementById("abdomenComentarioEf").value = obj[0].abdomenComentarioEf;
        document.getElementById("genitourinarioComentarioEf").value = obj[0].genitourinarioComentarioEf;
        document.getElementById("extremidadesComentarioEf").value = obj[0].extremidadesComentarioEf;
        document.getElementById("sistemaNerviosoCentralComentarioEf").value = obj[0].sistemaNerviosoCentralComentarioEf;
        document.getElementById("adenopatiasComentarioEf").value = obj[0].adenopatiasComentarioEf;
        document.getElementById("otrosComentarioEf").value = obj[0].otrosComentarioEf;
        document.getElementById("comentariosEf").value = obj[0].comentariosEf;
        document.getElementById("condicionEf").value = obj[0].condicionEf;
        deshabilitarCamposEf();
    } else {
        changeRightBtn("Guardar", "guardarExamenFisico", "");
    }
}

function definirChecks(nombreCheck, valorCheck) {
    var arrayCheck = document.getElementsByName(nombreCheck);
    for (var i = 0; i < arrayCheck.length; i++) {
        if (arrayCheck[i].value == valorCheck) {
            document.getElementsByName(nombreCheck)[i].checked = true;
            if (valorCheck == "alterado") {
                mostrar(nombreCheck + "Comentario");
            }
        }
    }
}

function guardarExamenFisico(){
    var stringEf = createString("capaExamenFisico")+"&fechaCreacionEf="+fechaActual()+"&horaCreacionEf="+horaActual()+"&idPaciente="+getPatientId();  
    guardarTabla("ExamenFisico", stringEf, ultimoExamenFisico);
    deshabilitarCamposEf();
}

function habilitarCamposEf() {
    $("input, textarea").prop("disabled", false);
    $("#bmi, #indiceCintCad").prop("disabled", true);
    changeRightBtn("Guardar", "guardarExamenFisico", "");
}
function deshabilitarCamposEf() {
    $("input, textarea").prop("disabled", true);
}

$(document).ready(function() {
    $(".txtNumeros").keypress(function(eve) {
        if ((eve.which != 46 || $(this).val().indexOf('.') != -1) && (eve.which < 48 || eve.which > 57) || (eve.which == 46 && $(this).caret().start == 0)) {
            eve.preventDefault();
        }

// this part is when left part of number is deleted and leaves a . in the leftmost position. For example, 33.25, then 33 is deleted
        $(".txtNumeros").keyup(function(eve) {
            if ($(this).val().indexOf('.') == 0) {
                $(this).val($(this).val().substring(1));
            }
        });
    });

    $("#cintura, #cadera").keyup(function(eve) {
        var cintura = 0;
        var cadera = 0;
        cintura = $("#cintura").val();
        cadera = $("#cadera").val();
        if (cintura == "") {
            cintura = 0
        }
        if (cadera == "") {
            cadera = 0
        }
        console.log(cadera + "/" +cintura);
        var indiceCintCad =parseFloat(cintura)/parseFloat(cadera);
        $("#indiceCintCad").val(indiceCintCad.toString().substring(0,8));
        if($("#indiceCintCad").val()=="NaN" || $("#indiceCintCad").val()=="Infinity"){
            $("#indiceCintCad").val("");
        }

    });
    
    $("#peso, #talla").keyup(function(eve) {
        var peso = 0;
        var talla = 0;
        peso = $("#peso").val();
        talla = $("#talla").val();
        if (peso == "") {
            peso = 0
        }
        if (talla == "") {
            talla = 0
        }
        console.log(peso + "/" +talla);
        var bmi =parseFloat(peso)/((parseFloat(talla)/100)*(parseFloat(talla)/100));
        $("#bmi").val(bmi.toString().substring(0,8));
        if($("#bmi").val()=="NaN" || $("#bmi").val()=="Infinity"){
            $("#bmi").val("");
        }

    });
});
















