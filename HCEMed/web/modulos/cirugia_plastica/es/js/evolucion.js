function getHistory(fecha) {
    if(modoMedsio == "local"){
        traerTodoTabla("CirugiaPlastica WHERE idPaciente='" + getPatientId() + "' AND fechaCreacionCp='" + fecha + "'  ORDER BY idCirugiaPlastica DESC LIMIT 0,1", cargarCamposCirugiaPlasticaEvo);
    }else{
        var service = "CirugiaPlastica/traerFecha"
        var string = "idPaciente="+getPatientId()+"&fecha="+fecha;
        
        ajax(service, string, cargarCamposCirugiaPlasticaEvo);
    }
}

function cargarCamposCirugiaPlasticaEvo(json) {
    var obj = JSON.parse(json);
    if (obj.length > 0) {
        $("div#cirugiaPlasticaContenedor").loadJSON(eval(json));

        //ESTETICA CABEZA CUELLO
        definirChecks("esteticaCabezaCuello", "si", obj[0].esteticaCabezaCuello, "alopeciaFacial");
        //ALOPECIA
        definirChecks("alopecia", "si", obj[0].alopecia, "capaAlopecia");
        definirSelects("tipoAlopeciaNoCicatricial", "otra", "otroTipoDeAlopeciaNoCicatricial");
        definirSelects("tipoAlopeciaCicatricial", "otra", "otroTipoAlopeciaCicatricial");
        if (obj[0].gradoDeAlopeciaHombre != "" || obj[0].gradoDeAlopeciaMujer != "") {
            $("#" + obj[0].gradoDeAlopeciaHombre).addClass("imagenSeleccionada");
            $("#" + obj[0].gradoDeAlopeciaMujer).addClass("imagenSeleccionada");
        }

        mostrarImgAlopecia();
        //FACIAL
        definirChecks("facial", "si", obj[0].facial, "capaFacial");
        definirChecks("antropometriaFrente", "si", obj[0].antropometriaFrente, "capaComentarioAntropometriaF");
        definirChecks("antropometriaPerfil", "si", obj[0].antropometriaPerfil, "capaComentarioAntropometriaP");
        definirChecks("frente", "si", obj[0].frente, "capaComentarioFrente");
        definirChecks("zonaPeriorbitaria", "si", obj[0].zonaPeriorbitaria, "capaComentarioZonaPeriorbitaria");
        definirChecks("regionMalar", "si", obj[0].regionMalar, "capaComentarioRegionMalar");
        definirChecks("regionMandibular", "si", obj[0].regionMandibular, "capaComentarioRegionMandibular");
        definirChecks("auricular", "si", obj[0].auricular, "capaComentarioAuricular");
        definirChecks("nasal", "si", obj[0].nasal, "capaComentarioNasal");
        definirChecks("periBucal", "si", obj[0].periBucal, "capaComentarioPeriBucal");
        definirChecks("mentoniana", "si", obj[0].mentoniana, "capaComentarioMentoniana");
        definirChecks("cervical", "si", obj[0].cervical, "capaComentarioCervical");
        //ESTETICA CORPORAL
        definirChecks("esteticaCorporal", "si", obj[0].esteticaCorporal, "capaEsteticaCorporal");
        definirChecks("regionToracicaAnterior", "si", obj[0].regionToracicaAnterior, "hombreMujer");
        definirChecks("clasificacionPtosisRegnoult", "si", obj[0].clasificacionPtosisRegnoult, "capaImagenesPtosisRegnault");
        if (obj[0].gradoPtosisRegnault != "") {
            $("#" + obj[0].gradoPtosisRegnault).addClass("imagenSeleccionada");
        }
        if (getPatientSex() == "m") {
            mostrar("hombre");
            ocultar("mujer");
        } else if (getPatientSex() == "f") {
            mostrar("mujer");
            ocultar("hombre");
            definirChecks("antecedentesMamarios", "si", obj[0].antecedentesMamarios, "comentariosAntecedentesMamarios");
            definirChecks("mamografias", "si", obj[0].mamografias, "comentariosMamografias");
            definirChecks("autoexamen", "si", obj[0].autoexamen, "comentariosAutoexamen");
            definirSelects("volumenMamarioDerecho", "hipertrofia", "hipertrofiaVolumenMamarioDerecho");
            definirSelects("volumenMamarioIzquierdo", "hipertrofia", "hipertrofiaVolumenMamarioIzquierdo");
        }
        //ABDOMEN
        definirChecks("abdomen", "si", obj[0].abdomen, "capaAbdomen");
        icc();
        //ESPALDA
        definirChecks("espalda", "si", obj[0].espalda, "capaEspalda");
        //GLUTEOS
        definirChecks("gluteos", "si", obj[0].gluteos, "capaGluteos");
        //EXTREMIDADES SUPERIORES
        definirChecks("extremidadesSuperiores", "si", obj[0].extremidadesSuperiores, "capaExtremidadesSuperiores");
        definirChecks("depositoGrasaMinimoModeradoMinimaLaxitud", "si", obj[0].depositoGrasaMinimoModeradoMinimaLaxitud, "sugerenciaDepositoMinimoGrasa");
        definirChecks("depositoGrasaGeneralizadaModeradaLaxitud", "si", obj[0].depositoGrasaGeneralizadaModeradaLaxitud, "sugerenciaDepositoGrasaGeneralizada");
        definirChecks("obesidadGeneralizadaSeveraLaxitud", "si", obj[0].obesidadGeneralizadaSeveraLaxitud, "sugerenciaObesidadGeneralizada");
        definirChecks("minimaGrasaSubcutaneaExtensaLaxitud", "si", obj[0].minimaGrasaSubcutaneaExtensaLaxitud, "sugerenciaMinimaGrasaSubcutanea");
        //EXTREMIDADES INFERIORES
        definirChecks("extremidadesInferiores", "si", obj[0].extremidadesInferiores, "capaExtremidadesInferiores");
        //RECONSTRUCTIVA CABEZA CUELLO
        definirChecks("reconstructivaCabezaCuello", "si", obj[0].reconstructivaCabezaCuello, "capaRcc");
        //RECONSTRUCTIVA CORPORAL
        definirChecks("reconstructivaCorporal", "si", obj[0].reconstructivaCorporal, "capaRc");
        //
        deshabilitarCamposCp();

    } else {
        $('input[type="radio"][value="no"]').prop('checked', true);
        habilitarCamposCp();
    }


}

function icc() {
    if(modoMedsio == "local"){
        crearSql("SELECT indiceCintCad FROM ExamenFisico WHERE idPaciente='" + getPatientId() + "' ORDER BY idExamenFisico DESC LIMIT 0,1", iccEsteticaCorporal);
    }else{
        var service = "ExamenFisico/traerUltimo";
        var string = "idPaciente="+getPatientId();
        
        ajax(service, string, iccEsteticaCorporal);
    }
}
function iccEsteticaCorporal(json) {
    var obj = JSON.parse(json);
    if (obj.length > 0) {
        $("#icc").html(obj[0].indiceCintCad);
    } else {
        $("#icc").html("0");
    }
}


//UTILIDADES-------------------------------------------------------------------------------------------------->

function definirChecksCpEvo(nombresChecks, respuestaParaMostrar, valorCheck,  campoParaMostrar) {
    var arrayCheck = document.getElementsByName(nombresChecks);
    for (var i = 0; i < arrayCheck.length; i++) {
        if (arrayCheck[i].value == valorCheck) {
            document.getElementsByName(nombresChecks)[i].checked = true;
            if (valorCheck == respuestaParaMostrar) {
                mostrar(campoParaMostrar);
            }
        }
    }
}
function definirSelectsCpEvo(nombreSelect, valorParaMostrar, campoParaMostrar) {
    if ($("#" + nombreSelect).val() == valorParaMostrar) {
        mostrar(campoParaMostrar);
    }
}
function mostrarEc(id) {
    $("#" + id).show();
    if (getPatientSex() == "m") {
        mostrar("hombre");
        ocultar("mujer");
    } else if (getPatientSex() == "f") {
        mostrar("mujer");
        ocultar("hombre");
    }
}
function ocultarEc(id) {
    $("#" + id).hide();
    if (getPatientSex() == "m") {
        mostrar("hombre");
        ocultar("mujer");
    } else if (getPatientSex() == "f") {
        mostrar("mujer");
        ocultar("hombre");
    }
}
function mostrarImgAlopecia(){
    if(getPatientSex()=="m"){
            mostrar("imagenesAlopeciaHombre");
            ocultar("imagenesAlopeciaMujer");
        }else{
            mostrar("imagenesAlopeciaMujer");
            ocultar("imagenesAlopeciaHombre");
        }
}
function habilitarCamposCp() {
    $("input, textarea, select").prop("disabled", false);
}
function deshabilitarCamposCp() {
    $("input, textarea, select").prop("disabled", true);

}
function muestraOcultaEscala() {
    var texto = $("#muestraOcultaEscala").text();
    if (texto == "Mostrar escala") {
        $("#escala").show();
        $("#muestraOcultaEscala").text("Ocultar escala");
    }
    else {
        $("#escala").hide();
        $("#muestraOcultaEscala").text("Mostrar escala");
    }
}

function muestraOcultaElemento(select, capa, comparacion) {
    var valor = $("#" + select).val();
    if (valor == comparacion) {
        $("#" + capa).show();
    }
    else {
        $("#" + capa).hide();
    }
}

getHistory(fechaEvolucionGeneral);

