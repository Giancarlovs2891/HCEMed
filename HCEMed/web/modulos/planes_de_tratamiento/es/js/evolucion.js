function getHistory(fecha) {
    listarTratamientosActivos();
    crearSql('SELECT * FROM Tratamientos WHERE fechaTratamiento="'+fecha+'" AND idPaciente="'+getPatientId()+'"', traerCostosSuccess);
    
    function traerCostosSuccess(x){
        var obj = JSON.parse(x);
        var html="";
        for(var i=0;i<obj.length;i++){
           html += '<div class="row paddingRow">'; 
           html += '<div class="col-xs-8 col-xs-offset-1 costosRow descripcion">'+obj[i].desTratamiento+'</div>';
           html += '<div class="col-xs-2 costosRow">';
           html += '<div class="input-group">';
           html += '<span class="input-group-addon">$</span>';
           html += '<input type="number" class="form-control camposValor" id="miniTotal'+i+'" onkeyup="" value="0" disabled>';
           html += '</div></div>';
           html += '<div class="col-xs-1 costosRow"><img src="modulos/planes_de_tratamiento/img/eliminarTratamiento.png" onclick=""/></div></div>';
        }

        document.getElementById("costosDesc").innerHTML = html;
        document.getElementById("total").value = 0;
        document.getElementById("tax").value = 0;
    }
    
    function listarTratamientosActivos(){
    document.getElementById("listaDeTratamientos").innerHTML = "";
    var html = '<div  class="row"><div  class="col-xs-6 col-xs-offset-1 costosTitle"><h5>Tratamientos Generados</h5></div><div  class="col-xs-2 costosTitle"><h5>Cargos</h5></div><div  class="col-xs-2 costosTitle"><h5>Abonos</h5></div></div>';
    html += '<div  class="row"><div  class="col-xs-6 col-xs-offset-1"></div><div  class="col-xs-2"><h5 id="totalCargos"></h5></div><div  class="col-xs-2"><h5 id="totalAbonos"></h5></div></div>';
    
    var idPaciente = getPatientId();
    var sql = 'SELECT * FROM PlanesDeTratamiento WHERE idPaciente="'+idPaciente+'"';
    crearSql(sql, listarTratamientosActivos2);
    var totalDebe = 0;
    totalDebe = parseInt(totalDebe);
    var totalPagado = 0;
    totalPagado = parseInt(totalPagado);
    function listarTratamientosActivos2(x){
        var obj = JSON.parse(x);
        
        for(var i=0;i<obj.length;i++){
               var debe = parseInt(obj[i].valorPlanTratamiento);
               totalDebe += debe;
               var pagado = parseInt(obj[i].pagadoPlanTratamiento);
               totalPagado += pagado;
               html += '<div  class="row paddingRow" onclick="">';
               html += '<div  class="col-xs-6 col-xs-offset-1 costosRow">';
               html += '<p>'+obj[i].fechaPlanTratamiento+'</p>';
               html += '</div>';
               html += '<div  class="col-xs-2 costosRow">';
               html += '<h5>$ '+obj[i].valorPlanTratamiento+'</h5>';
               html += '</div>';
               html += '<div  class="col-xs-2 costosRow">';
               html += '<h5>$ '+obj[i].pagadoPlanTratamiento+'</h5>';
               html += '</div>';
               html += '</div>';
               
        }
        document.getElementById("listaDeTratamientos").innerHTML = html;
        document.getElementById("tax").setAttribute("disabled", true);
        document.getElementById("totalCargos").innerHTML = "$ "+totalDebe;
        document.getElementById("totalAbonos").innerHTML = "$ "+totalPagado;
    }
}
}
getHistory(fechaEvolucionGeneral);