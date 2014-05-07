
function getHistory(fecha) {
    traerTodoTabla("Anamnesis WHERE idPaciente='" + getPatientId() + "' AND fechaCreacionAn='" + fecha + "' ORDER BY idAnamnesis DESC LIMIT 0,1", cargarCamposAnamnesisEvolucion);
    ocultarGinecologiaEvo();
}

function cargarCamposAnamnesisEvolucion(json) {
    var obj = JSON.parse(json);
    if (obj.length > 0) {
        $("#fechaDiagnosticoAlergia").val(obj[0].fechaDiagnosticoAlergia);
        $("#inicioTratamientoAlergia").val(obj[0].inicioTratamientoAlergia);
        $("#hastaTratamientoAlergia").val(obj[0].hastaTratamientoAlergia);
        $("#fechaDiagnosticoHepatitis").val(obj[0].fechaDiagnosticoHepatitis);
        $("#inicioTratamientoHepatitis").val(obj[0].inicioTratamientoHepatitis);
        $("#hastaTratamientoHepatitis").val(obj[0].hastaTratamientoHepatitis);
        $("#fechaDiagnosticoVih").val(obj[0].fechaDiagnosticoVih);
        $("#inicioTratamientoVih").val(obj[0].inicioTratamientoVih);
        $("#hastaTratamientoVih").val(obj[0].hastaTratamientoVih);
        $("#fechaDiagnosticoAnemia").val(obj[0].fechaDiagnosticoAnemia);
        $("#inicioTratamientoAnemia").val(obj[0].inicioTratamientoAnemia);
        $("#hastaTratamientoAnemia").val(obj[0].hastaTratamientoAnemia);
        $("#fechaDiagnosticoHerpes").val(obj[0].fechaDiagnosticoHerpes);
        $("#inicioTratamientoHerpes").val(obj[0].inicioTratamientoHerpes);
        $("#hastaTratamientoHerpes").val(obj[0].hastaTratamientoHerpes);
        $("#fechaDiagnosticoEnfermedadRenal").val(obj[0].fechaDiagnosticoEnfermedadRenal);
        $("#inicioTratamientoEnfermedadRenal").val(obj[0].inicioTratamientoEnfermedadRenal);
        $("#hastaTratamientoEnfermedadRenal").val(obj[0].hastaTratamientoEnfermedadRenal);
        $("#fechaDiagnosticoArtritis").val(obj[0].fechaDiagnosticoArtritis);
        $("#inicioTratamientoArtritis").val(obj[0].inicioTratamientoArtritis);
        $("#hastaTratamientoArtritis").val(obj[0].hastaTratamientoArtritis);
        $("#fechaDiagnosticoUlcerasOrales").val(obj[0].fechaDiagnosticoUlcerasOrales);
        $("#inicioTratamientoUlcerasOrales").val(obj[0].inicioTratamientoUlcerasOrales);
        $("#hastaTratamientoUlcerasOrales").val(obj[0].hastaTratamientoUlcerasOrales);
        $("#fechaDiagnosticoAsma").val(obj[0].fechaDiagnosticoAsma);
        $("#inicioTratamientoAsma").val(obj[0].inicioTratamientoAsma);
        $("#hastaTratamientoAsma").val(obj[0].hastaTratamientoAsma);
        $("#fechaDiagnosticoDiabetes").val(obj[0].fechaDiagnosticoDiabetes);
        $("#inicioTratamientoDiabetes").val(obj[0].inicioTratamientoDiabetes);
        $("#hastaTratamientoDiabetes").val(obj[0].hastaTratamientoDiabetes);
        $("#fechaDiagnosticoHemorragias").val(obj[0].fechaDiagnosticoHemorragias);
        $("#inicioTratamientoHemorragias").val(obj[0].inicioTratamientoHemorragias);
        $("#hastaTratamientoHemorragias").val(obj[0].hastaTratamientoHemorragias);
        $("#fechaDiagnosticoProblemasEndocrinos").val(obj[0].fechaDiagnosticoProblemasEndocrinos);
        $("#inicioTratamientoProblemasEndocrinos").val(obj[0].inicioTratamientoProblemasEndocrinos);
        $("#hastaTratamientoProblemasEndocrinos").val(obj[0].hastaTratamientoProblemasEndocrinos);
        $("#fechaDiagnosticoFiebreReumatica").val(obj[0].fechaDiagnosticoFiebreReumatica);
        $("#inicioTratamientoFiebreReumatica").val(obj[0].inicioTratamientoFiebreReumatica);
        $("#hastaTratamientoFiebreReumatica").val(obj[0].hastaTratamientoFiebreReumatica);
        $("#fechaDiagnosticoCancer").val(obj[0].fechaDiagnosticoCancer);
        $("#inicioTratamientoCancer").val(obj[0].inicioTratamientoCancer);
        $("#hastaTratamientoCancer").val(obj[0].hastaTratamientoCancer);
        $("#fechaDiagnosticoProblemasPsicologicos").val(obj[0].fechaDiagnosticoProblemasPsicologicos);
        $("#inicioTratamientoProblemasPsicologicos").val(obj[0].inicioTratamientoProblemasPsicologicos);
        $("#hastaTratamientoProblemasPsicologicos").val(obj[0].hastaTratamientoProblemasPsicologicos);
        $("#fechaDiagnosticoProblemasTiroideos").val(obj[0].fechaDiagnosticoProblemasTiroideos);
        $("#inicioTratamientoProblemasTiroideos").val(obj[0].inicioTratamientoProblemasTiroideos);
        $("#hastaTratamientoProblemasTiroideos").val(obj[0].hastaTratamientoProblemasTiroideos);
        $("#fechaDiagnosticoProblemasCardiacos").val(obj[0].fechaDiagnosticoProblemasCardiacos);
        $("#inicioTratamientoProblemasCardiacos").val(obj[0].inicioTratamientoProblemasCardiacos);
        $("#hastaTratamientoProblemasCardiacos").val(obj[0].hastaTratamientoProblemasCardiacos);
        $("#fechaDiagnosticoEpilepsia").val(obj[0].fechaDiagnosticoEpilepsia);
        $("#inicioTratamientoEpilepsia").val(obj[0].inicioTratamientoEpilepsia);
        $("#hastaTratamientoEpilepsia").val(obj[0].hastaTratamientoEpilepsia);
        $("#fechaDiagnosticoTuberculosis").val(obj[0].fechaDiagnosticoTuberculosis);
        $("#inicioTratamientoTuberculosis").val(obj[0].inicioTratamientoTuberculosis);
        $("#hastaTratamientoTuberculosis").val(obj[0].hastaTratamientoTuberculosis);
        $("#fechaDiagnosticoOsteoporosis").val(obj[0].fechaDiagnosticoOsteoporosis);
        $("#inicioTratamientoOsteoporosis").val(obj[0].inicioTratamientoOsteoporosis);
        $("#hastaTratamientoOsteoporosis").val(obj[0].hastaTratamientoOsteoporosis);
        $("#fechaDiagnosticoHipertension").val(obj[0].fechaDiagnosticoHipertension);
        $("#inicioTratamientoHipertension").val(obj[0].inicioTratamientoHipertension);
        $("#hastaTratamientoHipertension").val(obj[0].hastaTratamientoHipertension);
        $("#fechaDiagnosticoProblemasPsiquiatricos").val(obj[0].fechaDiagnosticoProblemasPsiquiatricos);
        $("#inicioTratamientoProblemasPsiquiatricos").val(obj[0].inicioTratamientoProblemasPsiquiatricos);
        $("#hastaTratamientoProblemasPsiquiatricos").val(obj[0].hastaTratamientoProblemasPsiquiatricos);

        $("div#anamnesisContenedor").loadJSON(eval(json));

        definirChecksAnEvo("bajoMedicacion", obj[0].bajoMedicacion, "capaBajoMedicacion");
        //ALERGIA
        definirChecksAnEvo("alergia", obj[0].alergia, "capaAlergia");
        definirChecksAnEvo("tratamientoAlergia", obj[0].tratamientoAlergia, "capaTratamientoAlergia");
        //HEPATITIS
        definirChecksAnEvo("hepatitis", obj[0].hepatitis, "capaHepatitis");
        definirChecksAnEvo("tratamientoHepatitis", obj[0].tratamientoHepatitis, "capaTratamientoHepatitis");
        //VIH
        definirChecksAnEvo("vih", obj[0].vih, "capaVih");
        definirChecksAnEvo("tratamientoVih", obj[0].tratamientoVih, "capaTratamientoVih");
        //ANEMIA
        definirChecksAnEvo("anemia", obj[0].anemia, "capaAnemia");
        definirChecksAnEvo("tratamientoAnemia", obj[0].tratamientoAnemia, "capaTratamientoAnemia");
        //HERPES
        definirChecksAnEvo("herpes", obj[0].herpes, "capaHerpes");
        definirChecksAnEvo("tratamientoHerpes", obj[0].tratamientoHerpes, "capaTratamientoHerpes");
        //ENFERMEDAD RENAL
        definirChecksAnEvo("enfermedadRenal", obj[0].enfermedadRenal, "capaEnfermedadRenal");
        definirChecksAnEvo("tratamientoEnfermedadRenal", obj[0].tratamientoEnfermedadRenal, "capaTratamientoEnfermedadRenal");
        //ARTRITIS
        definirChecksAnEvo("artritis", obj[0].artritis, "capaArtritis");
        definirChecksAnEvo("tratamientoArtritis", obj[0].tratamientoArtritis, "capaTratamientoArtritis");
        //ULCERAS ORALES
        definirChecksAnEvo("ulceraOrales", obj[0].ulceraOrales, "capaUlcerasOrales");
        definirChecksAnEvo("tratamientoUlcerasOrales", obj[0].tratamientoUlcerasOrales, "capaTratamientoUlcerasOrales");
        //ASMA
        definirChecksAnEvo("asma", obj[0].asma, "capaAsma");
        definirChecksAnEvo("tratamientoAsma", obj[0].tratamientoAsma, "capaTratamientoAsma");
        //DIABETES
        definirChecksAnEvo("diabetes", obj[0].diabetes, "capaDiabetes");
        definirChecksAnEvo("tratamientoDiabetes", obj[0].tratamientoDiabetes, "capaTratamientoDiabetes");
        //HEMORRAGIAS
        definirChecksAnEvo("hemorragias", obj[0].hemorragias, "capaHemorragias");
        definirChecksAnEvo("tratamientoHemorragias", obj[0].tratamientoHemorragias, "capaTratamientoHemorragias");
        //PROBLEMAS ENDOCRINOS
        definirChecksAnEvo("problemasEndocrinos", obj[0].problemasEndocrinos, "capaProblemasEndocrinos");
        definirChecksAnEvo("tratamientoProblemasEndocrinos", obj[0].tratamientoProblemasEndocrinos, "capaTratamientoProblemasEndocrinos");
        //FIEBRE REUMATICA
        definirChecksAnEvo("fiebreReumatica", obj[0].fiebreReumatica, "capaFiebreReumatica");
        definirChecksAnEvo("tratamientoFiebreReumatica", obj[0].tratamientoFiebreReumatica, "capaTratamientoFiebreReumatica");
        //CANCER
        definirChecksAnEvo("cancer", obj[0].cancer, "capaCancer");
        definirChecksAnEvo("tratamientoCancer", obj[0].tratamientoCancer, "capaTratamientoCancer");
        //PROBLEMAS PSICOLOGICOS
        definirChecksAnEvo("problemasPsicologicos", obj[0].problemasPsicologicos, "capaProblemasPsicologicos");
        definirChecksAnEvo("tratamientoProblemasPsicologicos", obj[0].tratamientoProblemasPsicologicos, "capaTratamientoProblemasPsicologicos");
        //PROBLEMAS TIROIDEOS
        definirChecksAnEvo("problemasTiroideos", obj[0].problemasTiroideos, "capaProblemasTiroideos");
        definirChecksAnEvo("tratamientoProblemasTiroideos", obj[0].tratamientoProblemasTiroideos, "capaTratamientoProblemasTiroideos");
        //PROBLEMAS CARDIACOS
        definirChecksAnEvo("problemasCardiacos", obj[0].problemasCardiacos, "capaProblemasCardiacos");
        definirChecksAnEvo("tratamientoProblemasCardiacos", obj[0].tratamientoProblemasCardiacos, "capaTratamientoProblemasCardiacos");
        //EPILEPSIAS
        definirChecksAnEvo("epilepsia", obj[0].epilepsia, "capaEpilepsia");
        definirChecksAnEvo("tratamientoEpilepsia", obj[0].tratamientoEpilepsia, "capaTratamientoEpilepsia");
        //TUBERCULOSIS
        definirChecksAnEvo("tuberculosis", obj[0].tuberculosis, "capaTuberculosis");
        definirChecksAnEvo("tratamientoTuberculosis", obj[0].tratamientoTuberculosis, "capaTratamientoTuberculosis");
        //OSTEOPOROSIS
        definirChecksAnEvo("osteoporosis", obj[0].osteoporosis, "capaOsteoporosis");
        definirChecksAnEvo("tratamientoOsteoporosis", obj[0].tratamientoOsteoporosis, "capaTratamientoOsteoporosis");
        //HIPERTENSION
        definirChecksAnEvo("hipertension", obj[0].hipertension, "capaHipertension");
        definirChecksAnEvo("tratamientoHipertension", obj[0].tratamientoHipertension, "capaTratamientoHipertension");
        //PROBLEMAS PSIQUIATRICOS
        definirChecksAnEvo("problemasPsiquiatricos", obj[0].problemasPsiquiatricos, "capaProblemasPsiquiatricos");
        definirChecksAnEvo("tratamientoProblemasPsiquiatricos", obj[0].tratamientoProblemasPsiquiatricos, "capaTratamientoProblemasPsiquiatricos");

        //ANTECEDENTES TRAUMATOLOGICOS
        if ($("[name=fractura][value=si]").is(":checked")) {
            mostrarConClase("at");
        }
        checksAtEvo("cadera", obj[0].cadera);
        checksAtEvo("tobillo", obj[0].tobillo);
        checksAtEvo("femur", obj[0].femur);
        checksAtEvo("muneca", obj[0].muneca);
        checksAtEvo("antebrazo", obj[0].antebrazo);
        checksAtEvo("vertebra", obj[0].vertebra);
        checksAtEvo("columna", obj[0].columna);
        checksAtEvo("otraFractura", obj[0].otraFractura);
        definirChecksAnEvo("otraFractura", obj[0].otraFractura, "otraFracturaCapa");
        //ANTECEDENTES GINECOLOGICOS
        $("#edadDeLosHijos").val(obj[0].edadDeLosHijos.split(",").join("\n"));
        ocultarGinecologiaEvo();

        //HABITOS
        //TABAQUISMO
        definirChecksAnEvo("tabaquismo", obj[0].tabaquismo, "fumaDesdeFrecuencia");
        //LICOR
        definirChecksAnEvo("licor", obj[0].licor, "capaLicor");
        //CAFE
        definirChecksAnEvo("cafe", obj[0].cafe, "capaCafe");
        //LECHE DERIVADOS
        definirChecksAnEvo("lecheDerivados", obj[0].lecheDerivados, "capaLecheDerivados");
        //FRUTAS FRESCAS
        definirChecksAnEvo("frutasFrescas", obj[0].frutasFrescas, "capaFrutasFrescas");
        //REALIZA EHJERCICIO
        definirChecksAnEvo("realizaEjercicio", obj[0].realizaEjercicio, "capaFrecuenciaEjercicio");
        //PESCADOS
        definirChecksAnEvo("pescados", obj[0].pescados, "capaPescados");
        definirChecksAnEvo("pescadoRio", obj[0].pescadoRio, "capaPescadosRioFrecuencia");
        definirChecksAnEvo("pescadoMar", obj[0].pescadoMar, "capaTipoPescadoMar");
        definirChecksAnEvo("blanco", obj[0].blanco, "capaPescadosMarBlanco");
        definirChecksAnEvo("azules", obj[0].azules, "capaPescadosMarAzules");

        //ANTECEDENTES FAMILIARES
        //DIABETES
        checksAtEvo("diabetesPadre", obj[0].diabetesPadre);
        checksAtEvo("diabetesMadre", obj[0].diabetesMadre);
        checksAtEvo("diabetesHijo", obj[0].diabetesHijo);
        checksAtEvo("diabetesTioP", obj[0].diabetesTioP);
        checksAtEvo("diabetesTioM", obj[0].diabetesTioM);
        checksAtEvo("diabetesHnos", obj[0].diabetesHnos);
        checksAtEvo("diabetesAbueloP", obj[0].diabetesAbueloP);
        checksAtEvo("diabetesAbueloM", obj[0].diabetesAbueloM);
        checksAtEvo("diabetesNinguno", obj[0].diabetesNinguno);
        //OBESIDAD
        checksAtEvo("obesidadPadre", obj[0].obesidadPadre);
        checksAtEvo("obesidadMadre", obj[0].obesidadMadre);
        checksAtEvo("obesidadHijo", obj[0].obesidadHijo);
        checksAtEvo("obesidadTioP", obj[0].obesidadTioP);
        checksAtEvo("obesidadTioM", obj[0].obesidadTioM);
        checksAtEvo("obesidadHnos", obj[0].obesidadHnos);
        checksAtEvo("obesidadAbueloP", obj[0].obesidadAbueloP);
        checksAtEvo("obesidadAbueloM", obj[0].obesidadAbueloM);
        checksAtEvo("obesidadNinguno", obj[0].obesidadNinguno);
        //COLESTEROL
        checksAtEvo("colesterolPadre", obj[0].colesterolPadre);
        checksAtEvo("colesterolMadre", obj[0].colesterolMadre);
        checksAtEvo("colesterolHijo", obj[0].colesterolHijo);
        checksAtEvo("colesterolTioP", obj[0].colesterolTioP);
        checksAtEvo("colesterolTioM", obj[0].colesterolTioM);
        checksAtEvo("colesterolHnos", obj[0].colesterolHnos);
        checksAtEvo("colesterolAbueloP", obj[0].colesterolAbueloP);
        checksAtEvo("colesterolAbueloM", obj[0].colesterolAbueloM);
        checksAtEvo("colesterolNinguno", obj[0].colesterolNinguno);
        //TRIGLICERIDOS
        checksAtEvo("trigliceridosPadre", obj[0].trigliceridosPadre);
        checksAtEvo("trigliceridosMadre", obj[0].trigliceridosMadre);
        checksAtEvo("trigliceridosHijo", obj[0].trigliceridosHijo);
        checksAtEvo("trigliceridosTioP", obj[0].trigliceridosTioP);
        checksAtEvo("trigliceridosTioM", obj[0].trigliceridosTioM);
        checksAtEvo("trigliceridosHnos", obj[0].trigliceridosHnos);
        checksAtEvo("trigliceridosAbueloP", obj[0].trigliceridosAbueloP);
        checksAtEvo("trigliceridosAbueloM", obj[0].trigliceridosAbueloM);
        checksAtEvo("trigliceridosNinguno", obj[0].trigliceridosNinguno);
        //INFARTOS
        checksAtEvo("infartosPadre", obj[0].infartosPadre);
        checksAtEvo("infartosMadre", obj[0].infartosMadre);
        checksAtEvo("infartosHijo", obj[0].infartosHijo);
        checksAtEvo("infartosTioP", obj[0].infartosTioP);
        checksAtEvo("infartosTioM", obj[0].infartosTioM);
        checksAtEvo("infartosHnos", obj[0].infartosHnos);
        checksAtEvo("infartosAbueloP", obj[0].infartosAbueloP);
        checksAtEvo("infartosAbueloM", obj[0].infartosAbueloM);
        checksAtEvo("infartosNinguno", obj[0].infartosNinguno);
        //HIPERTENSION
        checksAtEvo("hipertensionPadre", obj[0].hipertensionPadre);
        checksAtEvo("hipertensionMadre", obj[0].hipertensionMadre);
        checksAtEvo("hipertensionHijo", obj[0].hipertensionHijo);
        checksAtEvo("hipertensionTioP", obj[0].hipertensionTioP);
        checksAtEvo("hipertensionTioM", obj[0].hipertensionTioM);
        checksAtEvo("hipertensionHnos", obj[0].hipertensionHnos);
        checksAtEvo("hipertensionAbueloP", obj[0].hipertensionAbueloP);
        checksAtEvo("hipertensionAbueloM", obj[0].hipertensionAbueloM);
        checksAtEvo("hipertensionNinguno", obj[0].hipertensionNinguno);
        //CANCER
        checksAtEvo("cancerPadre", obj[0].cancerPadre);
        checksAtEvo("cancerMadre", obj[0].cancerMadre);
        checksAtEvo("cancerHijo", obj[0].cancerHijo);
        checksAtEvo("cancerTioP", obj[0].cancerTioP);
        checksAtEvo("cancerTioM", obj[0].cancerTioM);
        checksAtEvo("cancerHnos", obj[0].cancerHnos);
        checksAtEvo("cancerAbueloP", obj[0].cancerAbueloP);
        checksAtEvo("cancerAbueloM", obj[0].cancerAbueloM);
        checksAtEvo("cancerNinguno", obj[0].cancerNinguno);
        //OSTEOPOROSIS
        checksAtEvo("osteoporosisPadre", obj[0].osteoporosisPadre);
        checksAtEvo("osteoporosisMadre", obj[0].osteoporosisMadre);
        checksAtEvo("osteoporosisHijo", obj[0].osteoporosisHijo);
        checksAtEvo("osteoporosisTioP", obj[0].osteoporosisTioP);
        checksAtEvo("osteoporosisTioM", obj[0].osteoporosisTioM);
        checksAtEvo("osteoporosisHnos", obj[0].osteoporosisHnos);
        checksAtEvo("osteoporosisAbueloP", obj[0].osteoporosisAbueloP);
        checksAtEvo("osteoporosisAbueloM", obj[0].osteoporosisAbueloM);
        checksAtEvo("osteoporosisNinguno", obj[0].osteoporosisNinguno);
        //OTROS
        checksAtEvo("otrosPadre", obj[0].otrosPadre);
        checksAtEvo("otrosMadre", obj[0].otrosMadre);
        checksAtEvo("otrosHijo", obj[0].otrosHijo);
        checksAtEvo("otrosTioP", obj[0].otrosTioP);
        checksAtEvo("otrosTioM", obj[0].otrosTioM);
        checksAtEvo("otrosHnos", obj[0].otrosHnos);
        checksAtEvo("otrosAbueloP", obj[0].otrosAbueloP);
        checksAtEvo("otrosAbueloM", obj[0].otrosAbueloM);
        checksAtEvo("otrosNinguno", obj[0].otrosNinguno);

        deshabilitarCamposAn();
        
    } else {
        $('input[type="radio"][value="no"]').prop("checked", true);
        habilitarCamposAn();
    }
}


//UTILIDADES----------------------------------------------------------------------------->
function habilitarCamposAn() {
    $("input, textarea, select").prop("disabled", false);
}
function deshabilitarCamposAn() {
    $("input, textarea, select").prop("disabled", true);
}


function definirChecksAnEvo(nombreCheck, valorCheck, campoParaMostrar) {
    var arrayCheck = document.getElementsByName(nombreCheck);
    for (var i = 0; i < arrayCheck.length; i++) {
        if (arrayCheck[i].value == valorCheck) {
            document.getElementsByName(nombreCheck)[i].checked = true;
            if (valorCheck == "si" || valorCheck == "otraFractura") {
                mostrar(campoParaMostrar);
            }
        }
    }
}
function checksAtEvo(checkAt, valorCheck) {
    if (valorCheck == "null") {
        $("[name=" + checkAt + "]").attr("checked", false);
    } else {
        $("[name=" + checkAt + "]").attr("checked", true);
    }
}

function otraFacturaCheck() {
    var estado = document.getElementById("otraFractura").checked;
    if (estado == true) {
        mostrar("otraFracturaCapa");
    } else {
        ocultar("otraFracturaCapa")
    }
}

$(document).ready(function() {
    var cantidadCheckSi = function() {
        var checkSi = $("#formularioAntecedentesFamiliares input[type=radio][value=si]:checked").length;
        if (checkSi > 0) {
            $("#antecedentesPatologicos").show();
        }
    }

    $("#formularioAntecedentesFamiliares input[type=radio][value=si]").on("click", cantidadCheckSi);

    var cantidadCheckNo = function() {
        var checkNo = $("#formularioAntecedentesFamiliares input[type=radio][value=no]:checked").length;
        if (checkNo == 21) {
            $("#antecedentesPatologicos").hide();
        }
    }

    $("#formularioAntecedentesFamiliares input[type=radio][value=no]").on("click", cantidadCheckNo);


    $("#hijosVivos").blur(function(eve) {
        var valor = parseInt($("#hijosVivos").val());
        if (valor > 0) {
            $("#edadDeLosHijos").show();
            valor = (valor * 4) - 2;
            $("#edadDeLosHijos").attr("maxlength", valor);
        } else {
            $("#edadDeLosHijos").hide();
        }

    });


});

function ocultarGinecologiaEvo() {
    if (getPatientSex() == "m") {
        ocultar("antecedentesG");
    } else if (getPatientSex() == "f") {
        mostrar("antecedentesG");
    }
}

function muestraOcultaElemento(select, capa, comparacion) {
    var valor = $("#" + select).val();
    if (valor === comparacion) {
        $("#" + capa).show();
    }
    else {
        $("#" + capa).hide();
    }
}

getHistory(fechaEvolucionGeneral);
