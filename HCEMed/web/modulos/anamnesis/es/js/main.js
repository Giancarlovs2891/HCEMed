
var tabla = "CREATE TABLE IF NOT EXISTS Anamnesis (";
tabla += "idAnamnesis INTEGER PRIMARY KEY AUTOINCREMENT, ";
tabla += "idPaciente, ";
tabla += "motivoConsulta, ";
tabla += "historiaEnfermedadActual, ";
tabla += "bajoMedicacion, ";
tabla += "bajoMedicacionComentarios, ";
tabla += "alergia, ";
tabla += "hepatitis, ";
tabla += "vih, ";
tabla += "anemia, ";
tabla += "herpes, ";
tabla += "enfermedadRenal, ";
tabla += "artritis, ";
tabla += "ulcerasOrales, ";
tabla += "asma, ";
tabla += "diabetes, ";
tabla += "hemorragias, ";
tabla += "problemasEndocrinos, ";
tabla += "fiebreReumatica, ";
tabla += "cancer, ";
tabla += "problemasPsicologicos, ";
tabla += "problemasTiroideos, ";
tabla += "problemasCardiacos, ";
tabla += "epilepsia, ";
tabla += "tuberculosis, ";
tabla += "osteoporosis, ";
tabla += "hipertension, ";
tabla += "problemasPsiquiatricos, ";
//ANTECEDENTES PATOLOGICOS
//ALERGIA
tabla += "fechaDiagnosticoAlergia, ";
tabla += "tratamientoAlergia, ";
tabla += "inicioTratamientoAlergia, ";
tabla += "hastaTratamientoAlergia, ";
tabla += "medicacionAlergia, ";
tabla += "comentariosAlergia, ";
//HEPATITIS
tabla += "fechaDiagnosticoHepatitis, ";
tabla += "tratamientoHepatitis, ";
tabla += "inicioTratamientoHepatitis, ";
tabla += "hastaTratamientoHepatitis, ";
tabla += "medicacionHepatitis, ";
tabla += "comentariosHepatitis, ";
//VIH
tabla += "fechaDiagnosticoVih, ";
tabla += "tratamientoVih, ";
tabla += "inicioTratamientoVih, ";
tabla += "hastaTratamientoVih, ";
tabla += "medicacionVih, ";
tabla += "comentariosVih, ";
//ANEMIA
tabla += "fechaDiagnosticoAnemia, ";
tabla += "tratamientoAnemia, ";
tabla += "inicioTratamientoAnemia, ";
tabla += "hastaTratamientoAnemia, ";
tabla += "medicacionAnemia, ";
tabla += "comentariosAnemia, ";
//HERPES
tabla += "fechaDiagnosticoHerpes, ";
tabla += "tratamientoHerpes, ";
tabla += "inicioTratamientoHerpes, ";
tabla += "hastaTratamientoHerpes, ";
tabla += "medicacionHerpes, ";
tabla += "comentariosHerpes, ";
//ENFERMEDAD RENAL
tabla += "fechaDiagnosticoEnfermedadRenal, ";
tabla += "tratamientoEnfermedadRenal, ";
tabla += "inicioTratamientoEnfermedadRenal, ";
tabla += "hastaTratamientoEnfermedadRenal, ";
tabla += "medicacionEnfermedadRenal, ";
tabla += "comentariosEnfermedadRenal, ";
//ARTRITIS
tabla += "fechaDiagnosticoArtritis, ";
tabla += "tratamientoArtritis, ";
tabla += "inicioTratamientoArtritis, ";
tabla += "hastaTratamientoArtritis, ";
tabla += "medicacionArtritis, ";
tabla += "comentariosArtritis, ";
//ULCERAS ORALES
tabla += "fechaDiagnosticoUlcerasOrales, ";
tabla += "tratamientoUlcerasOrales, ";
tabla += "inicioTratamientoUlcerasOrales, ";
tabla += "hastaTratamientoUlcerasOrales, ";
tabla += "medicacionUlcerasOrales, ";
tabla += "comentariosUlcerasOrales, ";
//ASMA
tabla += "fechaDiagnosticoAsma, ";
tabla += "tratamientoAsma, ";
tabla += "inicioTratamientoAsma, ";
tabla += "hastaTratamientoAsma, ";
tabla += "medicacionAsma, ";
tabla += "comentariosAsma, ";
//DIABETES
tabla += "fechaDiagnosticoDiabetes, ";
tabla += "tratamientoDiabetes, ";
tabla += "inicioTratamientoDiabetes, ";
tabla += "hastaTratamientoDiabetes, ";
tabla += "medicacionDiabetes, ";
tabla += "comentariosDiabetes, ";
//HEMORRAGIAS
tabla += "fechaDiagnosticoHemorragias, ";
tabla += "tratamientoHemorragias, ";
tabla += "inicioTratamientoHemorragias, ";
tabla += "hastaTratamientoHemorragias, ";
tabla += "medicacionHemorragias, ";
tabla += "comentariosHemorragias, ";
//PROBLEMAS ENDOCRINOS
tabla += "fechaDiagnosticoProblemasEndocrinos, ";
tabla += "tratamientoProblemasEndocrinos, ";
tabla += "inicioTratamientoProblemasEndocrinos, ";
tabla += "hastaTratamientoProblemasEndocrinos, ";
tabla += "medicacionProblemasEndocrinos, ";
tabla += "comentariosProblemasEndocrinos, ";
//FIEBRE REUMATICA
tabla += "fechaDiagnosticoFiebreReumatica, ";
tabla += "tratamientoFiebreReumatica, ";
tabla += "inicioTratamientoFiebreReumatica, ";
tabla += "hastaTratamientoFiebreReumatica, ";
tabla += "medicacionFiebreReumatica, ";
tabla += "comentariosFiebreReumatica, ";
//CANCER
tabla += "fechaDiagnosticoCancer, ";
tabla += "tratamientoCancer, ";
tabla += "inicioTratamientoCancer, ";
tabla += "hastaTratamientoCancer, ";
tabla += "medicacionCancer, ";
tabla += "comentariosCancer, ";
//PROBLEMAS PSICOLOGICOS
tabla += "fechaDiagnosticoProblemasPsicologicos, ";
tabla += "tratamientoProblemasPsicologicos, ";
tabla += "inicioTratamientoProblemasPsicologicos, ";
tabla += "hastaTratamientoProblemasPsicologicos, ";
tabla += "medicacionProblemasPsicologicos, ";
tabla += "comentariosProblemasPsicologicos, ";
//PROBLEMAS TIROIDEOS
tabla += "fechaDiagnosticoProblemasTiroideos, ";
tabla += "tratamientoProblemasTiroideos, ";
tabla += "inicioTratamientoProblemasTiroideos, ";
tabla += "hastaTratamientoProblemasTiroideos, ";
tabla += "medicacionProblemasTiroideos, ";
tabla += "comentariosProblemasTiroideos, ";
//PROBLEMAS CARDIACOS
tabla += "fechaDiagnosticoProblemasCardiacos, ";
tabla += "tratamientoProblemasCardiacos, ";
tabla += "inicioTratamientoProblemasCardiacos, ";
tabla += "hastaTratamientoProblemasCardiacos, ";
tabla += "medicacionProblemasCardiacos, ";
tabla += "comentariosProblemasCardiacos, ";
//EPILEPSIAS
tabla += "fechaDiagnosticoEpilepsia, ";
tabla += "tratamientoEpilepsia, ";
tabla += "inicioTratamientoEpilepsia, ";
tabla += "hastaTratamientoEpilepsia, ";
tabla += "medicacionEpilepsia, ";
tabla += "comentariosEpilepsia, ";
//TUBERCULOSIS
tabla += "fechaDiagnosticoTuberculosis, ";
tabla += "tratamientoTuberculosis, ";
tabla += "inicioTratamientoTuberculosis, ";
tabla += "hastaTratamientoTuberculosis, ";
tabla += "medicacionTuberculosis, ";
tabla += "comentariosTuberculosis, ";
//OSTEOPOROSIS
tabla += "fechaDiagnosticoOsteoporosis, ";
tabla += "tratamientoOsteoporosis, ";
tabla += "inicioTratamientoOsteoporosis, ";
tabla += "hastaTratamientoOsteoporosis, ";
tabla += "medicacionOsteoporosis, ";
tabla += "comentariosOsteoporosis, ";
//HIPERTENSION
tabla += "fechaDiagnosticoHipertension, ";
tabla += "tratamientoHipertension, ";
tabla += "inicioTratamientoHipertension, ";
tabla += "hastaTratamientoHipertension, ";
tabla += "medicacionHipertension, ";
tabla += "comentariosHipertension, ";
//PROBLEMAS PSIQUIATRICOS
tabla += "fechaDiagnosticoProblemasPsiquiatricos, ";
tabla += "tratamientoProblemasPsiquiatricos, ";
tabla += "inicioTratamientoProblemasPsiquiatricos, ";
tabla += "hastaTratamientoProblemasPsiquiatricos, ";
tabla += "medicacionProblemasPsiquiatricos, ";
tabla += "comentariosProblemasPsiquiatricos, ";
//ANTECEDENTES TRAUMATOLOGICOS
tabla += "fractura, ";
tabla += "fechaFractura, ";
tabla += "cadera, ";
tabla += "tobillo, ";
tabla += "femur, ";
tabla += "muneca, ";
tabla += "antebrazo, ";
tabla += "vertebra, ";
tabla += "columna, ";
tabla += "otraFractura, ";
tabla += "otraFracturaComentarios, ";
tabla += "causaFractura, ";
tabla += "recuperacionPostFractura, ";
tabla += "incapacidadTotal, ";
tabla += "unidadIncapacidadTotal, ";
tabla += "otrosAntecedentesTraumatologicos, ";
//ANTECEDENTES GINECOLOGICOS
tabla += "menarquia, ";
tabla += "menopausia, ";
tabla += "histerectomia, ";
tabla += "embarazos, ";
tabla += "partos, ";
tabla += "abortos, ";
tabla += "hijosVivos, ";
tabla += "ciclos, ";
tabla += "ur, ";
tabla += "infertilidad, ";
tabla += "lactancia, ";
tabla += "totalLactancia, ";
tabla += "edadDeLosHijos, ";
//HABITOS
tabla += "tabaquismo, ";
tabla += "fumadorPasivo, ";
tabla += "fumaDesde, ";
tabla += "frecuenciaTabaquismo, ";
tabla += "licor, ";
tabla += "frecuenciaLicor, ";
tabla += "cerveza, ";
tabla += "vino, ";
tabla += "ron, ";
tabla += "whiskey, ";
tabla += "aguardiente, ";
tabla += "otrosLicores, ";
tabla += "cafe, ";
tabla += "frecuenciaCafe, ";
tabla += "otroCafe, ";
tabla += "inicioCafe, ";
tabla += "lecheDerivados, ";
tabla += "frecuenciaLecheDerivados, ";
tabla += "otroLecheDerivado, ";
tabla += "inicioLecheDerivado, ";
tabla += "frutasFrescas, ";
tabla += "queClasesFrutasFrescas, ";
tabla += "porcionesFrutasFrescas, ";
tabla += "realizaEjercicio, ";
tabla += "frecuenciaEjercicio, ";
tabla += "pescados, ";
tabla += "pescadoRio, ";
tabla += "clasePescadoRio, ";
tabla += "vecesPescadoRio, ";
tabla += "desdePescadoRio, ";
tabla += "frecuenciaPescadoRio, ";
tabla += "hastaPescadoRio, ";
tabla += "pescadoMar, ";
tabla += "blanco, ";
tabla += "clasePescadoMarBlanco, ";
tabla += "vecesPescadoMarBlanco, ";
tabla += "desdePescadoMarBlanco, ";
tabla += "frecuenciaPescadoMarBlanco, ";
tabla += "hastaPescadoMarblanco, ";
tabla += "azules, ";
tabla += "clasePescadoMarAzules, ";
tabla += "vecesPescadoMarAzules, ";
tabla += "desdePescadoMarAzules, ";
tabla += "frecuenciaPescadoMarAzules, ";
tabla += "hastaPescadoMarAzules, ";
tabla += "antecedentesQuirurgicos, ";
tabla += "otrosTratamientosAntecedentesQuirurgicos, ";
tabla += "comentariosAntecedentesQuirurgicos, ";
//ANTECEDENTES FAMILIARES
tabla += "diabetesPadre, ";
tabla += "diabetesMadre, ";
tabla += "diabetesHijo, ";
tabla += "diabetesTioP, ";
tabla += "diabetesTioM, ";
tabla += "diabetesHnos, ";
tabla += "diabetesAbueloP, ";
tabla += "diabetesAbueloM, ";
tabla += "diabetesNinguno, ";
tabla += "obesidadPadre, ";
tabla += "obesidadMadre, ";
tabla += "obesidadHijo, ";
tabla += "obesidadTioP, ";
tabla += "obesidadTioM, ";
tabla += "obesidadHnos, ";
tabla += "obesidadAbueloP, ";
tabla += "obesidadAbueloM, ";
tabla += "obesidadNinguno, ";
tabla += "colesterolPadre, ";
tabla += "colesterolMadre, ";
tabla += "colesterolHijo, ";
tabla += "colesterolTioP, ";
tabla += "colesterolTioM, ";
tabla += "colesterolHnos, ";
tabla += "colesterolAbueloP, ";
tabla += "colesterolAbueloM, ";
tabla += "colesterolNinguno, ";
tabla += "trigliceridosPadre, ";
tabla += "trigliceridosMadre, ";
tabla += "trigliceridosHijo, ";
tabla += "trigliceridosTioP, ";
tabla += "trigliceridosTioM, ";
tabla += "trigliceridosHnos, ";
tabla += "trigliceridosAbueloP, ";
tabla += "trigliceridosAbueloM, ";
tabla += "trigliceridosNinguno, ";
tabla += "infartosPadre, ";
tabla += "infartosMadre, ";
tabla += "infartosHijo, ";
tabla += "infartosTioP, ";
tabla += "infartosTioM, ";
tabla += "infartosHnos, ";
tabla += "infartosAbueloP, ";
tabla += "infartosAbueloM, ";
tabla += "infartosNinguno, ";
tabla += "hipertensionPadre, ";
tabla += "hipertensionMadre, ";
tabla += "hipertensionHijo, ";
tabla += "hipertensionTioP, ";
tabla += "hipertensionTioM, ";
tabla += "hipertensionHnos, ";
tabla += "hipertensionAbueloP, ";
tabla += "hipertensionAbueloM, ";
tabla += "hipertensionNinguno, ";
tabla += "cancerPadre, ";
tabla += "cancerMadre, ";
tabla += "cancerHijo, ";
tabla += "cancerTioP, ";
tabla += "cancerTioM, ";
tabla += "cancerHnos, ";
tabla += "cancerAbueloP, ";
tabla += "cancerAbueloM, ";
tabla += "cancerNinguno, ";
tabla += "osteoporosisPadre, ";
tabla += "osteoporosisMadre, ";
tabla += "osteoporosisHijo, ";
tabla += "osteoporosisTioP, ";
tabla += "osteoporosisTioM, ";
tabla += "osteoporosisHnos, ";
tabla += "osteoporosisAbueloP, ";
tabla += "osteoporosisAbueloM, ";
tabla += "osteoporosisNinguno, ";
tabla += "otrosPadre, ";
tabla += "otrosMadre, ";
tabla += "otrosHijo, ";
tabla += "otrosTioP, ";
tabla += "otrosTioM, ";
tabla += "otrosHnos, ";
tabla += "otrosAbueloP, ";
tabla += "otrosAbueloM, ";
tabla += "otrosNinguno, ";
//CREACION
tabla += "fechaCreacionAn, ";
tabla += "horaCreacionAn";
tabla += ")";
start();
function start() {

    var storage = getModoMedsio();
    if (storage == "local") {
        crearTabla(tabla);
    } else {

    }
    changeSubTitle("Anamnesis");
    traerTodoTabla("Anamnesis WHERE idPaciente='" + getPatientId() + "' ORDER BY idAnamnesis DESC LIMIT 0,1", cargarCamposAnamnesis);
    ocultarGinecologia();

}


function cargarCamposAnamnesis(json) {
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

        definirChecksAn("bajoMedicacion", obj[0].bajoMedicacion, "capaBajoMedicacion");
        //ALERGIA
        definirChecksAn("alergia", obj[0].alergia, "capaAlergia");
        definirChecksAn("tratamientoAlergia", obj[0].tratamientoAlergia, "capaTratamientoAlergia");
        //HEPATITIS
        definirChecksAn("hepatitis", obj[0].hepatitis, "capaHepatitis");
        definirChecksAn("tratamientoHepatitis", obj[0].tratamientoHepatitis, "capaTratamientoHepatitis");
        //VIH
        definirChecksAn("vih", obj[0].vih, "capaVih");
        definirChecksAn("tratamientoVih", obj[0].tratamientoVih, "capaTratamientoVih");
        //ANEMIA
        definirChecksAn("anemia", obj[0].anemia, "capaAnemia");
        definirChecksAn("tratamientoAnemia", obj[0].tratamientoAnemia, "capaTratamientoAnemia");
        //HERPES
        definirChecksAn("herpes", obj[0].herpes, "capaHerpes");
        definirChecksAn("tratamientoHerpes", obj[0].tratamientoHerpes, "capaTratamientoHerpes");
        //ENFERMEDAD RENAL
        definirChecksAn("enfermedadRenal", obj[0].enfermedadRenal, "capaEnfermedadRenal");
        definirChecksAn("tratamientoEnfermedadRenal", obj[0].tratamientoEnfermedadRenal, "capaTratamientoEnfermedadRenal");
        //ARTRITIS
        definirChecksAn("artritis", obj[0].artritis, "capaArtritis");
        definirChecksAn("tratamientoArtritis", obj[0].tratamientoArtritis, "capaTratamientoArtritis");
        //ULCERAS ORALES
        definirChecksAn("ulceraOrales", obj[0].ulceraOrales, "capaUlcerasOrales");
        definirChecksAn("tratamientoUlcerasOrales", obj[0].tratamientoUlcerasOrales, "capaTratamientoUlcerasOrales");
        //ASMA
        definirChecksAn("asma", obj[0].asma, "capaAsma");
        definirChecksAn("tratamientoAsma", obj[0].tratamientoAsma, "capaTratamientoAsma");
        //DIABETES
        definirChecksAn("diabetes", obj[0].diabetes, "capaDiabetes");
        definirChecksAn("tratamientoDiabetes", obj[0].tratamientoDiabetes, "capaTratamientoDiabetes");
        //HEMORRAGIAS
        definirChecksAn("hemorragias", obj[0].hemorragias, "capaHemorragias");
        definirChecksAn("tratamientoHemorragias", obj[0].tratamientoHemorragias, "capaTratamientoHemorragias");
        //PROBLEMAS ENDOCRINOS
        definirChecksAn("problemasEndocrinos", obj[0].problemasEndocrinos, "capaProblemasEndocrinos");
        definirChecksAn("tratamientoProblemasEndocrinos", obj[0].tratamientoProblemasEndocrinos, "capaTratamientoProblemasEndocrinos");
        //FIEBRE REUMATICA
        definirChecksAn("fiebreReumatica", obj[0].fiebreReumatica, "capaFiebreReumatica");
        definirChecksAn("tratamientoFiebreReumatica", obj[0].tratamientoFiebreReumatica, "capaTratamientoFiebreReumatica");
        //CANCER
        definirChecksAn("cancer", obj[0].cancer, "capaCancer");
        definirChecksAn("tratamientoCancer", obj[0].tratamientoCancer, "capaTratamientoCancer");
        //PROBLEMAS PSICOLOGICOS
        definirChecksAn("problemasPsicologicos", obj[0].problemasPsicologicos, "capaProblemasPsicologicos");
        definirChecksAn("tratamientoProblemasPsicologicos", obj[0].tratamientoProblemasPsicologicos, "capaTratamientoProblemasPsicologicos");
        //PROBLEMAS TIROIDEOS
        definirChecksAn("problemasTiroideos", obj[0].problemasTiroideos, "capaProblemasTiroideos");
        definirChecksAn("tratamientoProblemasTiroideos", obj[0].tratamientoProblemasTiroideos, "capaTratamientoProblemasTiroideos");
        //PROBLEMAS CARDIACOS
        definirChecksAn("problemasCardiacos", obj[0].problemasCardiacos, "capaProblemasCardiacos");
        definirChecksAn("tratamientoProblemasCardiacos", obj[0].tratamientoProblemasCardiacos, "capaTratamientoProblemasCardiacos");
        //EPILEPSIAS
        definirChecksAn("epilepsia", obj[0].epilepsia, "capaEpilepsia");
        definirChecksAn("tratamientoEpilepsia", obj[0].tratamientoEpilepsia, "capaTratamientoEpilepsia");
        //TUBERCULOSIS
        definirChecksAn("tuberculosis", obj[0].tuberculosis, "capaTuberculosis");
        definirChecksAn("tratamientoTuberculosis", obj[0].tratamientoTuberculosis, "capaTratamientoTuberculosis");
        //OSTEOPOROSIS
        definirChecksAn("osteoporosis", obj[0].osteoporosis, "capaOsteoporosis");
        definirChecksAn("tratamientoOsteoporosis", obj[0].tratamientoOsteoporosis, "capaTratamientoOsteoporosis");
        //HIPERTENSION
        definirChecksAn("hipertension", obj[0].hipertension, "capaHipertension");
        definirChecksAn("tratamientoHipertension", obj[0].tratamientoHipertension, "capaTratamientoHipertension");
        //PROBLEMAS PSIQUIATRICOS
        definirChecksAn("problemasPsiquiatricos", obj[0].problemasPsiquiatricos, "capaProblemasPsiquiatricos");
        definirChecksAn("tratamientoProblemasPsiquiatricos", obj[0].tratamientoProblemasPsiquiatricos, "capaTratamientoProblemasPsiquiatricos");

        //ANTECEDENTES TRAUMATOLOGICOS
        if ($("[name=fractura][value=si]").is(":checked")) {
            mostrarConClase("at");
        }
        checksAt("cadera", obj[0].cadera);
        checksAt("tobillo", obj[0].tobillo);
        checksAt("femur", obj[0].femur);
        checksAt("muneca", obj[0].muneca);
        checksAt("antebrazo", obj[0].antebrazo);
        checksAt("vertebra", obj[0].vertebra);
        checksAt("columna", obj[0].columna);
        checksAt("otraFractura", obj[0].otraFractura);
        definirChecksAn("otraFractura", obj[0].otraFractura, "otraFracturaCapa");
        //ANTECEDENTES GINECOLOGICOS
        $("#edadDeLosHijos").val(obj[0].edadDeLosHijos.split(",").join("\n"));
        ocultarGinecologia();

        //HABITOS
        //TABAQUISMO
        definirChecksAn("tabaquismo", obj[0].tabaquismo, "fumaDesdeFrecuencia");
        //LICOR
        definirChecksAn("licor", obj[0].licor, "capaLicor");
        //CAFE
        definirChecksAn("cafe", obj[0].cafe, "capaCafe");
        //LECHE DERIVADOS
        definirChecksAn("lecheDerivados", obj[0].lecheDerivados, "capaLecheDerivados");
        //FRUTAS FRESCAS
        definirChecksAn("frutasFrescas", obj[0].frutasFrescas, "capaFrutasFrescas");
        //REALIZA EHJERCICIO
        definirChecksAn("realizaEjercicio", obj[0].realizaEjercicio, "capaFrecuenciaEjercicio");
        //PESCADOS
        definirChecksAn("pescados", obj[0].pescados, "capaPescados");
        definirChecksAn("pescadoRio", obj[0].pescadoRio, "capaPescadosRioFrecuencia");
        definirChecksAn("pescadoMar", obj[0].pescadoMar, "capaTipoPescadoMar");
        definirChecksAn("blanco", obj[0].blanco, "capaPescadosMarBlanco");
        definirChecksAn("azules", obj[0].azules, "capaPescadosMarAzules");

        //ANTECEDENTES FAMILIARES
        //DIABETES
        checksAt("diabetesPadre", obj[0].diabetesPadre);
        checksAt("diabetesMadre", obj[0].diabetesMadre);
        checksAt("diabetesHijo", obj[0].diabetesHijo);
        checksAt("diabetesTioP", obj[0].diabetesTioP);
        checksAt("diabetesTioM", obj[0].diabetesTioM);
        checksAt("diabetesHnos", obj[0].diabetesHnos);
        checksAt("diabetesAbueloP", obj[0].diabetesAbueloP);
        checksAt("diabetesAbueloM", obj[0].diabetesAbueloM);
        checksAt("diabetesNinguno", obj[0].diabetesNinguno);
        //OBESIDAD
        checksAt("obesidadPadre", obj[0].obesidadPadre);
        checksAt("obesidadMadre", obj[0].obesidadMadre);
        checksAt("obesidadHijo", obj[0].obesidadHijo);
        checksAt("obesidadTioP", obj[0].obesidadTioP);
        checksAt("obesidadTioM", obj[0].obesidadTioM);
        checksAt("obesidadHnos", obj[0].obesidadHnos);
        checksAt("obesidadAbueloP", obj[0].obesidadAbueloP);
        checksAt("obesidadAbueloM", obj[0].obesidadAbueloM);
        checksAt("obesidadNinguno", obj[0].obesidadNinguno);
        //COLESTEROL
        checksAt("colesterolPadre", obj[0].colesterolPadre);
        checksAt("colesterolMadre", obj[0].colesterolMadre);
        checksAt("colesterolHijo", obj[0].colesterolHijo);
        checksAt("colesterolTioP", obj[0].colesterolTioP);
        checksAt("colesterolTioM", obj[0].colesterolTioM);
        checksAt("colesterolHnos", obj[0].colesterolHnos);
        checksAt("colesterolAbueloP", obj[0].colesterolAbueloP);
        checksAt("colesterolAbueloM", obj[0].colesterolAbueloM);
        checksAt("colesterolNinguno", obj[0].colesterolNinguno);
        //TRIGLICERIDOS
        checksAt("trigliceridosPadre", obj[0].trigliceridosPadre);
        checksAt("trigliceridosMadre", obj[0].trigliceridosMadre);
        checksAt("trigliceridosHijo", obj[0].trigliceridosHijo);
        checksAt("trigliceridosTioP", obj[0].trigliceridosTioP);
        checksAt("trigliceridosTioM", obj[0].trigliceridosTioM);
        checksAt("trigliceridosHnos", obj[0].trigliceridosHnos);
        checksAt("trigliceridosAbueloP", obj[0].trigliceridosAbueloP);
        checksAt("trigliceridosAbueloM", obj[0].trigliceridosAbueloM);
        checksAt("trigliceridosNinguno", obj[0].trigliceridosNinguno);
        //INFARTOS
        checksAt("infartosPadre", obj[0].infartosPadre);
        checksAt("infartosMadre", obj[0].infartosMadre);
        checksAt("infartosHijo", obj[0].infartosHijo);
        checksAt("infartosTioP", obj[0].infartosTioP);
        checksAt("infartosTioM", obj[0].infartosTioM);
        checksAt("infartosHnos", obj[0].infartosHnos);
        checksAt("infartosAbueloP", obj[0].infartosAbueloP);
        checksAt("infartosAbueloM", obj[0].infartosAbueloM);
        checksAt("infartosNinguno", obj[0].infartosNinguno);
        //HIPERTENSION
        checksAt("hipertensionPadre", obj[0].hipertensionPadre);
        checksAt("hipertensionMadre", obj[0].hipertensionMadre);
        checksAt("hipertensionHijo", obj[0].hipertensionHijo);
        checksAt("hipertensionTioP", obj[0].hipertensionTioP);
        checksAt("hipertensionTioM", obj[0].hipertensionTioM);
        checksAt("hipertensionHnos", obj[0].hipertensionHnos);
        checksAt("hipertensionAbueloP", obj[0].hipertensionAbueloP);
        checksAt("hipertensionAbueloM", obj[0].hipertensionAbueloM);
        checksAt("hipertensionNinguno", obj[0].hipertensionNinguno);
        //CANCER
        checksAt("cancerPadre", obj[0].cancerPadre);
        checksAt("cancerMadre", obj[0].cancerMadre);
        checksAt("cancerHijo", obj[0].cancerHijo);
        checksAt("cancerTioP", obj[0].cancerTioP);
        checksAt("cancerTioM", obj[0].cancerTioM);
        checksAt("cancerHnos", obj[0].cancerHnos);
        checksAt("cancerAbueloP", obj[0].cancerAbueloP);
        checksAt("cancerAbueloM", obj[0].cancerAbueloM);
        checksAt("cancerNinguno", obj[0].cancerNinguno);
        //OSTEOPOROSIS
        checksAt("osteoporosisPadre", obj[0].osteoporosisPadre);
        checksAt("osteoporosisMadre", obj[0].osteoporosisMadre);
        checksAt("osteoporosisHijo", obj[0].osteoporosisHijo);
        checksAt("osteoporosisTioP", obj[0].osteoporosisTioP);
        checksAt("osteoporosisTioM", obj[0].osteoporosisTioM);
        checksAt("osteoporosisHnos", obj[0].osteoporosisHnos);
        checksAt("osteoporosisAbueloP", obj[0].osteoporosisAbueloP);
        checksAt("osteoporosisAbueloM", obj[0].osteoporosisAbueloM);
        checksAt("osteoporosisNinguno", obj[0].osteoporosisNinguno);
        //OTROS
        checksAt("otrosPadre", obj[0].otrosPadre);
        checksAt("otrosMadre", obj[0].otrosMadre);
        checksAt("otrosHijo", obj[0].otrosHijo);
        checksAt("otrosTioP", obj[0].otrosTioP);
        checksAt("otrosTioM", obj[0].otrosTioM);
        checksAt("otrosHnos", obj[0].otrosHnos);
        checksAt("otrosAbueloP", obj[0].otrosAbueloP);
        checksAt("otrosAbueloM", obj[0].otrosAbueloM);
        checksAt("otrosNinguno", obj[0].otrosNinguno);

        deshabilitarCamposAn();
        changeRightBtn("Editar", "habilitarCamposAn", "");
    } else {
        $('input[type="radio"][value="no"]').prop("checked", true);
        habilitarCamposAn();
        changeRightBtn("Guardar", "guardarAnamnesis", "");
    }
}

function guardarAnamnesis() {
    var stringAn = createString("anamnesisContenedor") + "&fechaCreacionAn=" + fechaActual() + "&horaCreacionAn=" + horaActual() + "&idPaciente=" + getPatientId();
    stringAn = stringAn.split("&edadDeLosHijos=" + $("#edadDeLosHijos").val()).join("") + "&edadDeLosHijos=" + $("#edadDeLosHijos").val().split("\n").join(",");
    guardarTabla("Anamnesis", stringAn, deshabilitarCamposAn);
    guardarEvolucionAn();
    guardarDiagnosticosAn();
}

//UTILIDADES----------------------------------------------------------------------------->
function habilitarCamposAn() {
    $("input, textarea, select").prop("disabled", false);
    changeRightBtn("Guardar", "guardarAnamnesis", "");
}
function deshabilitarCamposAn() {
    $("input, textarea, select").prop("disabled", true);
    changeRightBtn("Editar", "habilitarCamposAn", "");
}


function definirChecksAn(nombreCheck, valorCheck, campoParaMostrar) {
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
function checksAt(checkAt, valorCheck) {
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

    ;

    $("#tablaAntecedentesFamiliares tr td input[type='checkbox']").on("click", function() {
        quitarCheckNinguno(this);
    });

    $("#tablaAntecedentesFamiliares tr td:last-child input[type='checkbox']").off("click");

    $("#tablaAntecedentesFamiliares tr td:last-child input[type='checkbox']").on("click", function() {
        chequearNinguno(this);
    });

    function chequearNinguno(x) {
        if ($(x).is(":checked")) {
//            var clase = $(this).parent().parent().get(0).className;
//            $("."+clase+" td input[type='checkbox']").prop("checked", false);
//            $("."+clase+" td:last-child input[type='checkbox']").prop("checked", true);

            var hijos = x.parentNode.parentNode.getElementsByTagName("td");

            for (var i = 1; i < hijos.length - 1; i++) {
                hijos[i].getElementsByTagName("input")[0].checked = false;
            }

        }
    }

    function quitarCheckNinguno(x) {
        var hijos = x.parentNode.parentNode.getElementsByTagName("td");


        hijos[hijos.length-1].getElementsByTagName("input")[0].checked = false;

    }
});

function ocultarGinecologia() {
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

function guardarEvolucionAn() {
//    var stringAnamnesis = "nombreModulo=Anamnesis&evolucion=" + encodeURIComponent(document.getElementById("medsioContent").innerHTML) + "&fecha=" + fechaActual() + "&hora=" + horaActual() + "&idPaciente=" + getPatientId();
    var stringAnamnesis = "nombreModulo=Anamnesis&evolucion=evolucion de anamnesis&fecha=" + fechaActual() + "&hora=" + horaActual() + "&idPaciente=" + getPatientId();
    console.log(stringAnamnesis);
    guardarTabla("Evolucion", stringAnamnesis, nada);
    function nada() {
    }
}

function guardarDiagnosticosAn() {
    guardarDiagnosticos("#comentariosAlergia", "Anamnesis", "Alergia");
    guardarDiagnosticos("#comentariosHepatitis", "Anamnesis", "Hepatitis");
    guardarDiagnosticos("#comentariosVih", "Anamnesis", "VIH");
    guardarDiagnosticos("#comentariosAnemia", "Anamnesis", "Anemia");
    guardarDiagnosticos("#comentariosHerpes", "Anamnesis", "Herpes");
    guardarDiagnosticos("#comentariosEnfermedadRenal", "Anamnesis", "Enfermedad renal");
    guardarDiagnosticos("#comentariosArtritis", "Anamnesis", "Artritis");
    guardarDiagnosticos("#comentariosUlcerasOrales", "Anamnesis", "Ulceras orales");
    guardarDiagnosticos("#comentariosAsma", "Anamnesis", "Asma");
    guardarDiagnosticos("#comentariosDiabetes", "Anamnesis", "Diabetes");
    guardarDiagnosticos("#comentariosHemorragias", "Anamnesis", "Hemorragias");
    guardarDiagnosticos("#comentariosProblemasEndocrinos", "Anamnesis", "Problemas endocrinos");
    guardarDiagnosticos("#comentariosFiebreReumatica", "Anamnesis", "Fiebre reumatica");
    guardarDiagnosticos("#comentariosCancer", "Anamnesis", "Cancer");
    guardarDiagnosticos("#comentariosProblemasPsicologicos", "Anamnesis", "Problemas psicologicos");
    guardarDiagnosticos("#comentariosProblemasTiroideos", "Anamnesis", "Problemas tiroideos");
    guardarDiagnosticos("#comentariosProblemasCardiacos", "Anamnesis", "Problemas cardiacos");
    guardarDiagnosticos("#comentariosEpilepsia", "Anamnesis", "Epilepsia");
    guardarDiagnosticos("#comentariosTuberculosis", "Anamnesis", "Tuberculosis");
    guardarDiagnosticos("#comentariosOsteoporosis", "Anamnesis", "Osteoporosis");
    guardarDiagnosticos("#comentariosHipertension", "Anamnesis", "Hipertension");
    guardarDiagnosticos("#comentariosProblemasPsiquiatricos", "Anamnesis", "Problemas psiquiatricos");
}


