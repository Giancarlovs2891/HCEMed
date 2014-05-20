var tabla = "CREATE TABLE IF NOT EXISTS TopografiaDermatologica (";
tabla += "idTopografia INTEGER PRIMARY KEY AUTOINCREMENT, ";
tabla += "idPaciente, ";
tabla += "lesionElementalPrimariaCabeza, ";
tabla += "lesionElementalSecundariaCabeza, ";
tabla += "lesionElementalPrimoSecundariaCabeza, ";
tabla += "lesionEspecialCabeza, ";

tabla += "lesionElementalPrimariaTronco, ";
tabla += "lesionElementalSecundariaTronco, ";
tabla += "lesionElementalPrimoSecundariaTronco, ";
tabla += "lesionEspecialTronco, ";

tabla += "lesionElementalPrimariaBrazos, ";
tabla += "lesionElementalSecundariaBrazos, ";
tabla += "lesionElementalPrimoSecundariaBrazos, ";
tabla += "lesionEspecialBrazos, ";

tabla += "lesionElementalPrimariaPiernas, ";
tabla += "lesionElementalSecundariaPiernas, ";
tabla += "lesionElementalPrimoSecundariaPiernas, ";
tabla += "lesionEspecialPiernas, ";

tabla += "fechaCreacionCp, ";
tabla += "horaCreacionCp";
tabla += ")";



start();

function start() {

    var storage = getModoMedsio();
    if (storage == "local") {
        crearTabla(tabla);
    } 
    
    changeSubTitle("Topografia Dermatologica");
    if(modoMedsio == "local"){
    traerTodoTabla("TopografiaDermatologica WHERE idPaciente='" + getPatientId() + "' ORDER BY idTopografia DESC LIMIT 0,1", cargarCamposTomografiaDermatologica);
    }else{
        //var service = "CirugiaPlastica/traerUltimo";
        //var string= "idPaciente="+getPatientId();
        
        //ajax(service, string, cargarCamposCirugiaPlastica);
    }
}

function cargarCamposTomografiaDermatologica(json){
    var obj = JSON.parse(json);
    if (obj.length > 0) {
        $("div#topografiaDermatologicaContenedor").loadJSON(eval(json));
        deshabilitarCamposTd();
        changeRightBtn("Editar", "habilitarCamposTd", "");
        cargarEstadoPrevio("topografia_dermatologica",cargarEstadoPacienteCargadoTopografiaDermatologica);
    }else{
        iniciarGuardadoTemporal();
        habilitarCamposTd();
        cargarEstadoPrevio("topografia_dermatologica",cargarEstadoPacienteNuevoTopografiaDermatologica);
        changeRightBtn("Guardar", "guardarTopografiaDermatologica", "");
    }
}

function guardarTopografiaDermatologica(){
    pararGuardadoTemporal();
    var stringTd = createString("topografiaDermatologicaContenedor") + "&fechaCreacionCp=" + fechaActual() + "&horaCreacionCp=" + horaActual() + "&idPaciente=" + getPatientId();
    guardarTabla("TopografiaDermatologica", stringTd, deshabilitarCamposTd);
    guardarEvolucionTd();
}

function habilitarCamposTd(){
    iniciarGuardadoTemporal();
    $("input, textarea, select").prop("disabled", false);
    changeRightBtn("Guardar", "guardarTopografiaDermatologica", "");
}

function deshabilitarCamposTd(){
     $("input, textarea, select").prop("disabled", true);
    changeRightBtn("Editar", "habilitarCamposTd", "");
}

function guardarEvolucionTd() {
    var stringTopografiaDermatologica = "nombreModulo=TopografiaDermatologica&evolucion=evolucion de Topografia Dermatologica&fecha=" + fechaActual() + "&hora=" + horaActual() + "&idPaciente=" + getPatientId();
    guardarTabla("Evolucion", stringTopografiaDermatologica, nada);
    function nada() {
    }
}

function cargarEstadoPacienteNuevoTopografiaDermatologica(json){
    var Json = decodeURIComponent(json);
   $("div#topografiaDermatologicaContenedor").loadJSON(eval(Json));
}
function cargarEstadoPacienteCargadoTopografiaDermatologica(json){
    var Json = decodeURIComponent(json);
    if(Json != ""){
        habilitarCamposTd();
        $("div#topografiaDermatologicaContenedor").loadJSON(eval(Json));
    }
}