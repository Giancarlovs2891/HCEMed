function getHistory(fecha) {
    document.getElementById("nombreTratamiento").setAttribute("disabled", true);
    document.getElementById("nombreTratamiento").setAttribute("onchange", "");
    document.getElementById("nombreTratamiento").setAttribute("onkeyup", "");
    if(modoMedsio == "local"){
        var sql = 'SELECT * FROM Tratamientos WHERE fechaTratamiento="'+fecha+'" AND idPaciente="'+getPatientId()+'"';
        crearSql(sql, traerTratamientosSuccess);
    }else{
        var service = "Tratamientos/traerFecha";
         var string = "idPaciente="+getPatientId()+"&fecha="+fecha;
        
        ajax(service, string, traerTratamientosSuccess);
    }

    function traerTratamientosSuccess(x){
        var obj = JSON.parse(x);
        var html="";
        for(var i=0;i<obj.length;i++){
            html += '<div class="row" id="row'+obj[i].idTratamiento+'">';
            html += '<div class="col-xs-10">';
            html += '<input class="form-control desTratamiento" id="'+obj[i].idTratamiento+'" type="text" id="nombreTratamiento" value="'+obj[i].desTratamiento+'" disabled/>';
            html += '</div>'; 
            html += '<div class="col-xs-2">';
            html += '<a href="javascript:void(0);" class="eliminarTratamientoBtn desTratamiento" onclick=""></a>';
            html += '</div>';     
            html += '</div>';
        }


        document.getElementById("descripcionesTratamiento").innerHTML = html;
        var hoy = fechaActual();
        var idPaciente = getPatientId();
        
        if(modoMedsio == "local"){
            var sql = 'SELECT * FROM Diagnosticos WHERE fecha="'+fecha+'" AND idPaciente="'+idPaciente+'"';
            crearSql(sql, traerTratamientosSuccess2);
        }else{
            var service = "Diagnosticos/listar";
            var string = "fecha="+fecha+"&idPaciente="+idPaciente;
                
            ajax(service, string, traerTratamientosSuccess2);

        }

        function traerTratamientosSuccess2(y){
            var obj2 = JSON.parse(y);

            var html = "";

            for(var i=0;i<obj2.length;i++){
                html += "<li>"+obj2[i].nombreModulo+" - "+obj2[i].diagnostico+"</li>";
            }
            document.getElementById("listaDeDiagnoticos").innerHTML = html;
        }
    }
}

getHistory(fechaEvolucionGeneral);
 


