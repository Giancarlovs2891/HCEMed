function getHistory(fecha) {
    traerTodoTabla("CirugiaPlastica WHERE idPaciente='" + getPatientId() + "' AND fechaCreacionCp='" + fecha + "'  ORDER BY idCirugiaPlastica DESC LIMIT 0,1", cargarCamposCirugiaPlasticaEvo);
}

function cargarCamposCirugiaPlasticaEvo(json) {
    var obj = JSON.parse(json);
    if (obj.length > 0) {
        $("div#cirugiaPlasticaContenedor").loadJSON(eval(json));
        //ESTETICA CABEZA CUELLO
        definirChecksCpEvo("esteticaCabezaCuello", "si", obj[0].esteticaCabezaCuello, "alopeciaFacial");
        //ALOPECIA
        definirChecksCpEvo("alopecia", "si", obj[0].alopecia, "capaAlopecia");
        definirSelectsCpEvo("tipoAlopeciaNoCicatricial", "otra", "otroTipoDeAlopeciaNoCicatricial");
        definirSelectsCpEvo("tipoAlopeciaCicatricial", "otra", "otroTipoAlopeciaCicatricial");
        if (obj[0].gradoDeAlopeciaHombre != "" || obj[0].gradoDeAlopeciaMujer !="") {
            $("#" + obj[0].gradoDeAlopeciaHombre).addClass("imagenSeleccionada");
            $("#" + obj[0].gradoDeAlopeciaMujer).addClass("imagenSeleccionada");
        }
        mostrarImgAlopecia();
        //FACIAL
        definirChecksCpEvo("facial", "si", obj[0].facial, "capaFacial");
        definirChecksCpEvo("antropometriaFrente", "si", obj[0].antropometriaFrente, "capaComentarioAntropometriaF");
        definirChecksCpEvo("antropometriaPerfil", "si", obj[0].antropometriaPerfil, "capaComentarioAntropometriaP");
        definirChecksCpEvo("frente", "si", obj[0].frente, "capaComentarioFrente");
        definirChecksCpEvo("zonaPeriorbitaria", "si", obj[0].zonaPeriorbitaria, "capaComentarioZonaPeriorbitaria");
        definirChecksCpEvo("regionMalar", "si", obj[0].regionMalar, "capaComentarioRegionMalar");
        definirChecksCpEvo("regionMandibular", "si", obj[0].regionMandibular, "capaComentarioRegionMandibular");
        definirChecksCpEvo("auricular", "si", obj[0].auricular, "capaComentarioAuricular");
        definirChecksCpEvo("nasal", "si", obj[0].nasal, "capaComentarioNasal");
        definirChecksCpEvo("periBucal", "si", obj[0].periBucal, "capaComentarioPeriBucal");
        definirChecksCpEvo("mentoniana", "si", obj[0].mentoniana, "capaComentarioMentoniana");
        definirChecksCpEvo("cervical", "si", obj[0].cervical, "capaComentarioCervical");
        //ESTETICA CORPORAL
        definirChecksCpEvo("esteticaCorporal", "si", obj[0].esteticaCorporal, "capaEsteticaCorporal");
        definirChecksCpEvo("regionToracicaAnterior", "si", obj[0].regionToracicaAnterior, "hombreMujer");
        if (getPatientSex() == "m") {
            mostrar("hombre");
            ocultar("mujer");
        } else if (getPatientSex() == "f") {
            mostrar("mujer");
            ocultar("hombre");
            definirChecksCpEvo("antecedentesMamarios", "si", obj[0].antecedentesMamarios, "comentariosAntecedentesMamarios");
            definirChecksCpEvo("mamografias", "si", obj[0].mamografias, "comentariosMamografias");
            definirChecksCpEvo("autoexamen", "si", obj[0].autoexamen, "comentariosAutoexamen");
            definirSelectsCpEvo("volumenMamarioDerecho", "hipertrofia", "hipertrofiaVolumenMamarioDerecho");
            definirSelectsCpEvo("volumenMamarioIzquierdo", "hipertrofia", "hipertrofiaVolumenMamarioIzquierdo");
        }
        //ABDOMEN
        definirChecksCpEvo("abdomen", "si", obj[0].abdomen, "capaAbdomen");
        icc();
        //ESPALDA
        definirChecksCpEvo("espalda", "si", obj[0].espalda, "capaEspalda");
        //GLUTEOS
        definirChecksCpEvo("gluteos", "si", obj[0].gluteos, "capaGluteos");
        //EXTREMIDADES SUPERIORES
        definirChecksCpEvo("extremidadesSuperiores", "si", obj[0].extremidadesSuperiores, "capaExtremidadesSuperiores");
        definirChecksCpEvo("depositoGrasaMinimoModeradoMinimaLaxitud", "si", obj[0].depositoGrasaMinimoModeradoMinimaLaxitud, "sugerenciaDepositoMinimoGrasa");
        definirChecksCpEvo("depositoGrasaGeneralizadaModeradaLaxitud", "si", obj[0].depositoGrasaGeneralizadaModeradaLaxitud, "sugerenciaDepositoGrasaGeneralizada");
        definirChecksCpEvo("obesidadGeneralizadaSeveraLaxitud", "si", obj[0].obesidadGeneralizadaSeveraLaxitud, "sugerenciaObesidadGeneralizada");
        definirChecksCpEvo("minimaGrasaSubcutaneaExtensaLaxitud", "si", obj[0].minimaGrasaSubcutaneaExtensaLaxitud, "sugerenciaMinimaGrasaSubcutanea")
        //EXTREMIDADES INFERIORES
        definirChecksCpEvo("extremidadesInferiores", "si", obj[0].extremidadesInferiores, "capaExtremidadesInferiores");
        //RECONSTRUCTIVA CABEZA CUELLO
        definirChecksCpEvo("reconstructivaCabezaCuello", "si", obj[0].reconstructivaCabezaCuello, "capaRcc");
        //RECONSTRUCTIVA CORPORAL
        definirChecksCpEvo("reconstructivaCorporal", "si", obj[0].reconstructivaCorporal, "capaRc");
        //
        deshabilitarCamposCp();
    } else {
        $('input[type="radio"][value="no"]').prop('checked', true);
        habilitarCamposCp();
    }


}

function icc() {
    crearSql("SELECT indiceCintCad FROM ExamenFisico WHERE idPaciente='" + getPatientId() + "' ORDER BY idExamenFisico DESC LIMIT 0,1", iccEsteticaCorporal);
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

