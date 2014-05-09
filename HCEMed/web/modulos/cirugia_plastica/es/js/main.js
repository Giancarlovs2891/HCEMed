var tabla = "CREATE TABLE IF NOT EXISTS CirugiaPlastica (";
tabla += "idCirugiaPlastica INTEGER PRIMARY KEY AUTOINCREMENT, ";
tabla += "idPaciente, ";
//-----------------ESTETICA CABEZA CUELLO----------------->
tabla += "esteticaCabezaCuello, ";
//ALOPECIA----->
tabla += "alopecia, ";
tabla += "caidaDeCabello, ";
tabla += "edadInicioDebilitamientoCapilar, ";
tabla += "edadInicioCaidaCapilar, ";
tabla += "estabilizada, ";
tabla += "antecedentesFamiliares, ";
tabla += "tratamientosPrevios, ";
tabla += "cortes, ";
tabla += "color, ";
tabla += "espesorCabello, ";
tabla += "estructura, ";
tabla += "poros, ";
tabla += "espesorCueroCabelludo, ";
tabla += "flexibilidadCueroCabelludo, ";
tabla += "cicatrices, ";
tabla += "pullTest, ";
tabla += "componentesPsiquicos, ";
tabla += "densidadZonaFrontal, ";
tabla += "densidadZonaOccipital, ";
tabla += "densidadZonaTemporal, ";
tabla += "densidadZonaParietal, ";
tabla += "perdidaZona, ";
tabla += "tipoAlopeciaNoCicatricial, ";
tabla += "otroTipoDeAlopeciaNoCicatricial, ";
tabla += "tipoAlopeciaCicatricial, ";
tabla += "otroTipoAlopeciaCicatricial, ";
tabla += "expectativasPaciente, ";
tabla += "propuestasTerapeuticas, ";
tabla += "gradoDeAlopeciaHombre, ";
tabla += "gradoDeAlopeciaMujer, ";
//FACIAL------------->
tabla += "facial, ";
tabla += "antropometriaFrente, ";
tabla += "comentariosAntropometriaFrente, ";
tabla += "antropometriaPerfil, ";
tabla += "comentariosAntropometriaPerfil, ";
tabla += "frente, ";
tabla += "comentariosFrente, ";
tabla += "zonaPeriorbitaria, ";
tabla += "comentariosZonaPeriorbitaria, ";
tabla += "regionMalar, ";
tabla += "comentariosRegionMalar, ";
tabla += "regionMandibular, ";
tabla += "comentariosRegionMandibular, ";
tabla += "auricular, ";
tabla += "comentariosAuricular, ";
tabla += "nasal, ";
tabla += "comentariosNasal, ";
tabla += "periBucal, ";
tabla += "comentariosPeriBucal, ";
tabla += "mentoniana, ";
tabla += "comentariosMentoniana, ";
tabla += "cervical, ";
tabla += "comentariosCervical, ";
//-----------------ESTETICA CORPORAL----------------->
tabla += "esteticaCorporal, ";
//REGION TORACICA ANTERIOR---------->
tabla += "regionToracicaAnterior, ";
//MUJER--------------->
tabla += "antecedentesMamarios, ";
tabla += "comentariosAntecedentesMamarios, ";
tabla += "mamografias, ";
tabla += "comentariosMamografias, ";
tabla += "autoexamen, ";
tabla += "comentariosAutoexamen, ";
tabla += "volumenMamarioDerecho, ";
tabla += "hipertrofiaVolumenMamarioDerecho, ";
tabla += "volumenMamarioIzquierdo, ";
tabla += "hipertrofiaVolumenMamarioIzquierdo, ";
tabla += "formaMamariaDerecha, ";
tabla += "formaMamariaIzquierda, ";
tabla += "ptosisMamaria, ";
tabla += "clasificacionPtosisRegnoult, ";
tabla += "tipoPielDerecha, ";
tabla += "tipoPielIzquierda, ";
tabla += "sensibilidadPezonDerecho, ";
tabla += "sensibilidadPezonIzquierdo, ";
tabla += "diametroComplejoAreola, ";
tabla += "diagramaPosicionDerecho, ";
tabla += "baseMamariaDerecho, ";
tabla += "medidaToraxDerecho, ";
tabla += "diagramaPosicionIzquierdo, ";
tabla += "baseMamariaIzquierdo, ";
tabla += "medidaToraxIzquierdo, ";
tabla += "diagnosticoMamario, ";
tabla += "otrosDiagnosticosMamarios, ";
tabla += "planTratamientoMamario, ";
//HOMBRES--------------->
tabla += "ginecomastia, ";
tabla += "clasificacionWiesman, ";
tabla += "antecedentesGinecomastia, ";
tabla += "tipoGinecomastia, ";
tabla += "comentariosTipoGinecomastia, ";
tabla += "pectorales, ";
tabla += "otrosDiagnosticosGinecomastia, ";
tabla += "planTratamientoGinecomastia, ";
//ABDOMEN----------------->
tabla += "abdomen, ";
tabla += "clasificacionMatarasso, ";
tabla += "comentariosAbdomen, ";
tabla += "diagnosticoAbdomen, ";
tabla += "planTratamientoAbdomen, ";
//ESPALDA--------------------->
tabla += "espalda, ";
tabla += "comentariosEspalda, ";
tabla += "diagnosticoEspalda, ";
tabla += "planTratamientoEspalda, ";
//GLUTEOS---------------------->
tabla += "gluteos, ";
tabla += "volumenGluteos, ";
tabla += "posicionGluteos, ";
tabla += "formaGluteos, ";
tabla += "caracteristicasPielGluteos, ";
tabla += "asimetria, ";
tabla += "secuelasTrauma, ";
tabla += "comentariosGluteos, ";
//EXTREMIDADES SUPERIORES--------------------->
tabla += "extremidadesSuperiores, ";
tabla += "depositoGrasaMinimoModeradoMinimaLaxitud, ";
tabla += "depositoGrasaGeneralizadaModeradaLaxitud, ";
tabla += "obesidadGeneralizadaSeveraLaxitud, ";
tabla += "minimaGrasaSubcutaneaExtensaLaxitud, ";
tabla += "comentariosExtremidadesSuperiores, ";
//EXTREMIDADES INFERIORES------------------------>
tabla += "extremidadesInferiores, ";
tabla += "comentariosExtremidadesInferiores, ";
tabla += "diagnosticoExtremidadesInferiores, ";
tabla += "planTratamientoExtremidadesInferiores, ";
//-----------------RECONSTRUCTIVA CABEZA CUELLO----------------->
tabla += "reconstructivaCabezaCuello, ";
tabla += "comentariosReconstructivaCabezaCuello, ";
tabla += "diagnosticoReconstructivaCabezaCuello, ";
tabla += "planTratamientoReconstructivaCabezaCuello, ";
//-----------------RECONSTRUCTIVA CORPORAL-------------------->
tabla += "reconstructivaCorporal, ";
tabla += "comentariosReconstructivaCorporal, ";
tabla += "diagnosticoReconstructivaCorporal, ";
tabla += "planTratamientoReconstructivaCorporal, ";
tabla += "fechaCreacionCp, ";
tabla += "horaCreacionCp";
tabla += ")";
start();

function start() {

    var storage = getModoMedsio();
    if (storage == "local") {
        crearTabla(tabla);
    } else {

    }
    mostrarImgAlopecia();
    changeSubTitle("Cirugía Plastica");
    traerTodoTabla("CirugiaPlastica WHERE idPaciente='" + getPatientId() + "' ORDER BY idCirugiaPlastica DESC LIMIT 0,1", cargarCamposCirugiaPlastica);
}

function guardarCirugiaPlastica() {
    var stringCp = createString("cirugiaPlasticaContenedor") + "&fechaCreacionCp=" + fechaActual() + "&horaCreacionCp=" + horaActual() + "&idPaciente=" + getPatientId();
    guardarTabla("CirugiaPlastica", stringCp, deshabilitarCamposCp);
    guardarEvolucionCp();
    guardarDiagnosticosCp();
}
function cargarCamposCirugiaPlastica(json) {
    console.log(json);
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
        changeRightBtn("Editar", "habilitarCamposCp", "");

    } else {
        $('input[type="radio"][value="no"]').prop('checked', true);
        habilitarCamposCp();
        changeRightBtn("Guardar", "guardarCirugiaPlastica", "");
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

function definirChecks(nombresChecks, respuestaParaMostrar, valorCheck, campoParaMostrar) {
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
function definirSelects(nombreSelect, valorParaMostrar, campoParaMostrar) {
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

function mostrarImgAlopecia() {
    alert(getPatientSex());
    if (getPatientSex() == "m") {
        mostrar("imagenesAlopeciaHombre");
        ocultar("imagenesAlopeciaMujer");
    } else {
        mostrar("imagenesAlopeciaMujer");
        ocultar("imagenesAlopeciaHombre");
    }
}
function habilitarCamposCp() {
    $("input, textarea, select").prop("disabled", false);
    changeRightBtn("Guardar", "guardarCirugiaPlastica", "");
    var imagenes = document.getElementById("capaAlopecia").getElementsByTagName('img');
    var sexo = getPatientSex();
    for (var i = 0; i < imagenes.length; i++) {
        if (sexo === "m") {
            imagenes[i].setAttribute("onclick", "gradoAlopecia(this, 'imagenesAlopeciaHombre', 'gradoDeAlopeciaHombre')");
        }
        else {
            imagenes[i].setAttribute("onclick", "gradoAlopecia(this, 'imagenesAlopeciaMujer', 'gradoDeAlopeciaMujer')");
        }
    }
}
function grado(id) {
    alert(id);
}
function deshabilitarCamposCp() {
    $("input, textarea, select").prop("disabled", true);
    changeRightBtn("Editar", "habilitarCamposCp", "");
    var imagenes = document.getElementById("capaAlopecia").getElementsByTagName('img');
    for (var i = 0; i < imagenes.length; i++) {
//        imagenes[i].onclick = function() {
//            return false;
//        };
        imagenes[i].setAttribute("onclick", "");
    }
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

function guardarEvolucionCp() {
    var stringCirugiaPlastica = "nombreModulo=CirugiaPlastica&evolucion=evolucion de cirugia plastica&fecha=" + fechaActual() + "&hora=" + horaActual() + "&idPaciente=" + getPatientId();
    guardarTabla("Evolucion", stringCirugiaPlastica, nada);
    function nada() {
    }
}

function guardarDiagnosticosCp() {
    guardarDiagnosticos("#diagnosticoMamario", "Cirugia plastica", "Antecedentes mamarios");
    guardarDiagnosticos("#otrosDiagnosticosGinecomastia", "Cirugia plastica", "Ginecomastia");
    guardarDiagnosticos("#diagnosticoAbdomen", "Cirugia plastica", "Abdomen");
    guardarDiagnosticos("#diagnosticoEspalda", "Cirugia plastica", "Espalda");
    guardarDiagnosticos("#diagnosticoExtremidadesInferiores", "Cirugia plastica", "Extremidades inferiores");
    guardarDiagnosticos("#diagnosticoReconstructivaCabezaCuello", "Cirugia plastica", "Reconstructiva cabeza cuello");
    guardarDiagnosticos("#diagnosticoReconstructivaCorporal", "Cirugia plastica", "Reconstructiva corporal");
}

function gradoAlopecia(imagen, capaContenedor, campo) {
    var gradoAlopecia = imagen.id;
    $("#" + campo).val(gradoAlopecia);
    var imagenes = document.getElementById(capaContenedor).getElementsByTagName('img');
    for (var i = 0; i < imagenes.length; i++) {
        imagenes[i].className = 'imagenDeseleccionada';
    }
    $(imagen).removeClass('imagenDeseleccionada');
    $(imagen).addClass('imagenSeleccionada');
}