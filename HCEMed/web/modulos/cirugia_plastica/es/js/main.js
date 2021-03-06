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
tabla += "tipoDeTratamientos, ";
tabla += "cortes, ";
tabla += "color, ";
tabla += "comentarioOtroColor, ";
tabla += "espesorCabello, ";
tabla += "estructura, ";
tabla += "otraEstructura, ";
tabla += "poros, ";
tabla += "espesorCueroCabelludo, ";
tabla += "flexibilidadCueroCabelludo, ";
tabla += "cicatrices, ";
tabla += "pullTest, ";
tabla += "componentesPsiquicos, ";
tabla += "otroComponentePsiquico, ";
tabla += "densidadZonaFrontal, ";
tabla += "densidadZonaOccipital, ";
tabla += "densidadZonaTemporal, ";
tabla += "densidadZonaParietal, ";
tabla += "perdidaZona, ";
tabla += "otraPerdidaZona, ";
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
tabla += "otroFormaMamariaDerecha, ";
tabla += "formaMamariaIzquierda, ";
tabla += "otroFormaMamariaIzquierda, ";
tabla += "ptosisMamaria, ";
tabla += "clasificacionPtosisRegnoult, ";
tabla += "gradoPtosisRegnault, ";
tabla += "tipoPielDerecha, ";
tabla += "otroTipoDePielDerecha, ";
tabla += "tipoPielIzquierda, ";
tabla += "otroTipoDePielIzquierda, ";
tabla += "sensibilidadPezonDerecho, ";
tabla += "otraSensibilidadDerechaPezon, ";
tabla += "sensibilidadPezonIzquierdo, ";
tabla += "otraSensibilidadIzquierdaPezon, ";
tabla += "diametroComplejoAreolaDerecho, ";
tabla += "diametroComplejoAreolaIzquierdo, ";
tabla += "diagramaPosicionDerecho, ";
tabla += "baseMamariaDerecho, ";
tabla += "medidaToraxDerecho, ";
tabla += "diagramaPosicionIzquierdo, ";
tabla += "baseMamariaIzquierdo, ";
tabla += "medidaToraxIzquierdo, ";
tabla += "diagnosticoMamario, ";
tabla += "otrosDiagnosticosMamarios, ";
tabla += "pronosticoMamario, ";
tabla += "planTratamientoMamario, ";
//HOMBRES--------------->
tabla += "ginecomastia, ";
tabla += "clasificacionWiesman, ";
tabla += "antecedentesGinecomastia, ";
tabla += "tipoGinecomastia, ";
tabla += "otroTipoGinecomastia, ";
tabla += "comentariosTipoGinecomastia, ";
tabla += "pectorales, ";
tabla += "otrosDiagnosticosGinecomastia, ";
tabla += "pronosticoGinecomastia, ";
tabla += "planTratamientoGinecomastia, ";
//ABDOMEN----------------->
tabla += "abdomen, ";
tabla += "clasificacionMatarasso, ";
tabla += "comentariosAbdomen, ";
tabla += "diagnosticoAbdomen, ";
tabla += "pronosticoAbdomen, ";
tabla += "planTratamientoAbdomen, ";
//VALORACION GENITOURINARIA--------------->
tabla += "valoracionGenitourinaria, ";
tabla += "comentariosValoracionGenitourinaria, ";
//ESPALDA--------------------->
tabla += "espalda, ";
tabla += "comentariosEspalda, ";
tabla += "diagnosticoEspalda, ";
tabla += "pronosticoEspalda, ";
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
tabla += "diagnosticoGluteos, ";
tabla += "pronosticoGluteos, ";
tabla += "planDeTratamientoGluteos, ";
//EXTREMIDADES SUPERIORES--------------------->
tabla += "extremidadesSuperiores, ";
tabla += "depositoGrasaMinimoModeradoMinimaLaxitud, ";
tabla += "depositoGrasaGeneralizadaModeradaLaxitud, ";
tabla += "obesidadGeneralizadaSeveraLaxitud, ";
tabla += "minimaGrasaSubcutaneaExtensaLaxitud, ";
tabla += "comentariosExtremidadesSuperiores, ";
tabla += "diagnosticoExtremidadesSuperiores, ";
tabla += "pronosticoExtremidadesSuperiores, ";
tabla += "planTratamientoExtremidadesSuperiores, ";
//EXTREMIDADES INFERIORES------------------------>
tabla += "extremidadesInferiores, ";
tabla += "comentariosExtremidadesInferiores, ";
tabla += "diagnosticoExtremidadesInferiores, ";
tabla += "pronosticoExtremidadesInferiores, ";
tabla += "planTratamientoExtremidadesInferiores, ";
//-----------------RECONSTRUCTIVA CABEZA CUELLO----------------->
tabla += "reconstructivaCabezaCuello, ";
tabla += "comentariosReconstructivaCabezaCuello, ";
tabla += "diagnosticoReconstructivaCabezaCuello, ";
tabla += "pronosticoReconstructivaCabezaCuello, ";
tabla += "planTratamientoReconstructivaCabezaCuello, ";
//-----------------RECONSTRUCTIVA CORPORAL-------------------->
tabla += "reconstructivaCorporal, ";
tabla += "comentariosReconstructivaCorporal, ";
tabla += "diagnosticoReconstructivaCorporal, ";
tabla += "pronosticoReconstructivaCorporal, ";
tabla += "planTratamientoReconstructivaCorporal, ";
tabla += "fechaCreacionCp, ";
tabla += "horaCreacionCp";
tabla += ")";

var tabla2 = "CREATE TABLE IF NOT EXISTS ExamenFisico (";
tabla2 += "idExamenFisico INTEGER PRIMARY KEY AUTOINCREMENT, ";
tabla2 += "idPaciente, ";
tabla2 += "tensionArterial, ";
tabla2 += "peso, ";
tabla2 += "cintura, ";
tabla2 += "pulso, ";
tabla2 += "talla, ";
tabla2 += "cadera, ";
tabla2 += "frecuenciaRespiratoria, ";
tabla2 += "bmi, ";
tabla2 += "indiceCintCad, ";
tabla2 += "piel, ";
tabla2 += "pielComentarioEf, ";
tabla2 += "ojos, ";
tabla2 += "ojosComentarioEf, ";
tabla2 += "oidosNarizGarganta, ";
tabla2 += "oidosNarizGargantaComentarioEf, ";
tabla2 += "cuello, ";
tabla2 += "cuelloComentarioEf, ";
tabla2 += "torax, ";
tabla2 += "toraxComentarioEf, ";
tabla2 += "cardiovascular, ";
tabla2 += "cardiovascularComentarioEf, ";
tabla2 += "respiratorios, ";
tabla2 += "respiratoriosComentarioEf, ";
tabla2 += "abdomen, ";
tabla2 += "abdomenComentarioEf, ";
tabla2 += "genitourinario, ";
tabla2 += "genitourinarioComentarioEf, ";
tabla2 += "extremidades, ";
tabla2 += "extremidadesComentarioEf, ";
tabla2 += "sistemaNerviosoCentral, ";
//tabla2 += "sistemaNerviosoCentralComentarioEf, ";
tabla2 += "adenopatias, ";
tabla2 += "adenopatiasComentarioEf, ";
tabla2 += "otros, ";
tabla2 += "otrosComentarioEf, ";
tabla2 += "comentariosEf, ";
tabla2 += "condicionEf, ";
tabla2 += "fechaCreacionEf, ";
tabla2 += "horaCreacionEf";
tabla2 += ")";
start();

function start() {

    var storage = getModoMedsio();
    if (storage == "local") {
        crearTabla(tabla);
        crearTabla(tabla2);
        function alter(tx) {
            tx.executeSql("ALTER TABLE CirugiaPlastica ADD COLUMN gradoPtosisRegnault");
            tx.executeSql("ALTER TABLE CirugiaPlastica ADD COLUMN tipoDeTratamientos");
            tx.executeSql("ALTER TABLE CirugiaPlastica ADD COLUMN diagnosticoGluteos");
            tx.executeSql("ALTER TABLE CirugiaPlastica ADD COLUMN pronosticoGluteos");
            tx.executeSql("ALTER TABLE CirugiaPlastica ADD COLUMN planDeTratamientoGluteos");
        }
        db.transaction(alter);

    } else {

    }
    function nada() {
        console.log("alter");
    }
    mostrarImgAlopecia();
    changeSubTitle("Cirugía Plastica");
    if (modoMedsio == "local") {
        traerTodoTabla("CirugiaPlastica WHERE idPaciente='" + getPatientId() + "' ORDER BY idCirugiaPlastica DESC LIMIT 0,1", cargarCamposCirugiaPlastica);
    } else {
        var service = "CirugiaPlastica/traerUltimo";
        var string = "idPaciente=" + getPatientId();

        ajax(service, string, cargarCamposCirugiaPlastica);
    }
}

function guardarCirugiaPlastica() {
    pararGuardadoTemporal();
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
        definirChecks("tratamientosPrevios", "si", obj[0].tratamientosPrevios, "capaTipoTratamiento");
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
        changeRightBtn("Editar", "habilitarCamposCp", "");
        cargarEstadoPrevio("cirugia_plastica", cargarEstadoPacienteCargadoCirugiaPlastica);

    } else {
        iniciarGuardadoTemporal();
        $('input[type="radio"][value="no"]').prop('checked', true);
        habilitarCamposCp();
        cargarEstadoPrevio("cirugia_plastica", cargarEstadoPacienteNuevoCirugiaPlastica);
        changeRightBtn("Guardar", "guardarCirugiaPlastica", "");
    }


}
function cargarEstadoPacienteNuevoCirugiaPlastica(json) {
    var Json = decodeURIComponent(json);
    //$("div#medsioContent").loadJSON(eval(Json));
    var obj = JSON.parse(Json);
    $("div#cirugiaPlasticaContenedor").loadJSON(eval(Json));

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
}
function cargarEstadoPacienteCargadoCirugiaPlastica(json) {
    var Json = decodeURIComponent(json);
    if (Json != "") {
        habilitarCamposCp();
        //$("div#medsioContent").loadJSON(eval(Json));
        var obj = JSON.parse(Json);
        $("div#cirugiaPlasticaContenedor").loadJSON(eval(Json));

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
    }
}
function icc() {
    if (modoMedsio == "local") {
        crearSql("SELECT indiceCintCad FROM ExamenFisico WHERE idPaciente='" + getPatientId() + "' ORDER BY idExamenFisico DESC LIMIT 0,1", iccEsteticaCorporal);
    } else {
        var service = "ExamenFisico/traerUltimo";
        var string = "idPaciente=" + getPatientId();

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
    if (getPatientSex() == "m") {
        mostrar("imagenesAlopeciaHombre");
        ocultar("imagenesAlopeciaMujer");
    } else {
        mostrar("imagenesAlopeciaMujer");
        ocultar("imagenesAlopeciaHombre");
    }
}
function habilitarCamposCp() {
    iniciarGuardadoTemporal();
    $("input, textarea, select").prop("disabled", false);
    changeRightBtn("Guardar", "guardarCirugiaPlastica", "");
    var imagenes = document.getElementById("capaAlopecia").getElementsByTagName('img');
    var imgSenos = document.getElementById("capaImagenesPtosisRegnault").getElementsByTagName('img');
    var sexo = getPatientSex();

    for (var i = 0; i < imgSenos.length; i++) {
        if (sexo === "f") {
            imgSenos[i].setAttribute("onclick", "gradoAlopecia(this, 'capaImagenesPtosisRegnault', 'gradoPtosisRegnault')");
        }
    }

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
    var imgSenos = document.getElementById("capaImagenesPtosisRegnault").getElementsByTagName('img');
    for (var i = 0; i < imagenes.length; i++) {
//        imagenes[i].onclick = function() {
//            return false;
//        };
        imagenes[i].setAttribute("onclick", "");
    }

    for (var i = 0; i < imgSenos.length; i++) {
        imgSenos[i].setAttribute("onclick", "");
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
    guardarDiagnosticos("#diagnosticoExtremidadesSuperiores", "Cirugia plastica", "Extremidades superiores");
    guardarDiagnosticos("#diagnosticoReconstructivaCabezaCuello", "Cirugia plastica", "Reconstructiva cabeza cuello");
    guardarDiagnosticos("#diagnosticoReconstructivaCorporal", "Cirugia plastica", "Reconstructiva corporal");
    guardarDiagnosticos("#diagnosticoGluteos", "Cirugia plastica", "Gluteos");
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