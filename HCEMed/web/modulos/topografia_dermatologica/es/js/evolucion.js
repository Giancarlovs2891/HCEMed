function getHistory(fecha) {
    if(modoMedsio == "local"){
    traerTodoTabla("TopografiaDermatologica WHERE idPaciente='" + getPatientId() + "' ORDER BY idTopografia DESC LIMIT 0,1", cargarCamposTomografiaDermatologicaEvo);
    }else{
        //var service = "CirugiaPlastica/traerUltimo";
        //var string= "idPaciente="+getPatientId();
        
        //ajax(service, string, cargarCamposCirugiaPlastica);
    }
}

function cargarCamposTomografiaDermatologicaEvo(json){
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

function habilitarCamposTd(){
    iniciarGuardadoTemporal();
    $("input, textarea, select").prop("disabled", false);
    changeRightBtn("Guardar", "guardarTopografiaDermatologica", "");
}

function deshabilitarCamposTd(){
     $("input, textarea, select").prop("disabled", true);
    changeRightBtn("Editar", "habilitarCamposTd", "");
}

getHistory(fechaEvolucionGeneral);

