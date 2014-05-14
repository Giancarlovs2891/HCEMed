
//changeTitle(newTitle)
//Esta funcion se puede usar para cambiar el titulo que aparece en el Header
//Ejemplo: changeTitle("Nuevo Modulo");

//changeRightBtn(text, funcion, icon)
//Esta funcion se usa para cambiar el boton derecho del header. Se puede cambair el icono, poner texto y la funcion que ejecutara al hacer click. Deben guiarse de las clases de Ionicons
//Ejemplo: changeRightBtn("Guardar", "guardarPaciente", "ion-navicon-round");

//changeLeftBtn(text, funcion, icon)
//Esta funcion se usa para cambiar el boton izquierdo del header. Se puede cambair el icono, poner texto y la funcion que ejecutara al hacer click. Deben guiarse de las clases de Ionicons
//Ejemplo: changeLeftBtn("Guardar", "guardarPaciente", "ion-navicon-round");

//createString(id)
//Crea automaticamente un string poniendo el id de los campos como el nombre de la variable y el valor del campo como el valor de la variable. LOS ID'S DEBEN LLAMARSE IGUAL QUE LAS COLUMNAS DE LA TABLA EN BASE DE DATOS
//Recibe como parametro el id del div que contiene el formulario.
//Ejemplo: var string = createString("datosBasicosForm");

//getLang()
//Regresa el codigo del idioma en cual esta la aplicacion. Los codigos son (es, en, rus .....)
//Ejemplo: var lenguaje = getLang();

//getPatientId()
//Retorna el id del paciente seleccionado, si no hay un paciente seleccionado el resultado es NaN
//Ejemplo: var id = getPatientId();

//loadJsFile(filename)
//Cuando se carga el modulo, debe cargar los archivos Js necesarios para su funcionamiento
//Ejemplo: loadJsFile("modulos/nuevo_modulo/es/js/main.js");

//loadCssFile()
//Cuando se carga el modulo, debe cargar los archivos Css necesarios para su funcionamiento
//Ejemplo: loadCssFile("modulos/nuevo_modulo/es/css/main.css");

//FUNCIONES DE BASE DE DATOS
//Es importante que el nombre de las variables en el string tenga el mismo nombre que las columnas en la base de datos. La respuesta sera en formato JSON
//crearTabla(query)
//Con esta funcion ustedes pueden crear la tabla en base de datos local que van a usar para el modulo
//Ejemplo: crearTabla('CREATE TABLE IF NOT EXISTS Pacientes (idPaciente INTEGER PRIMARY KEY AUTOINCREMENT, nombrePaciente, apellidoPaciente)');

//guardarTabla(nombreTabla, string, callback)
//Esta funcion les permite guardar en la tabla. El string es igual al usado para enviar la informacion al servicio REST
//Ejemplo: guardarTabla('Pacientes', 'nombrePaciente=Luis&apellidoPaciente=Escudero&edadPaciente=27', guardarSuccess);

//editarTabla(nombreTabla, string, callback)
//Esta funcion les permite editar la tabla en la base de datos local. El string es igual al usado para enviar la informacion al servicio REST. Si necesitan saber el id del paciente pueden usar la funcion getPatientId()
//Ejemplo: editarTabla('Pacientes', 'nombrePaciente=Marta&apellidoPaciente=Gomez&edadPaciente=24&idPaciente=2', editarSuccess);

//borrarTabla(nombreTabla, string, callback)
//Esta funcion les permite borrar en la tabla de base de datos local. El string es igual al usado para enviar la informacion al servicio REST. Si necesitan saber el id del paciente pueden usar la funcion getPatientId
//Ejemplo: borrarTabla('Pacientes', 'idPaciente=3', borrarSuccess);

//traerTabla(nombreTabla, string, callback)
//Esta funcion les permite traer un objeto de la base de datos local. El string es igual al usado para enviar la informacion al servicio REST. La respuesta es en formato JSON y el nombre de la variable es el nombre de la columna de base de datos
//Ejemplo: traerTabla('Pacientes', 'idPaciente=2', traerSuccess);

// traerTodoTabla(nombreTabla, callback)
//Esta funcion les permite traer todos los objetos de la base de datos local. El string es igual al usado para enviar la informacion al servicio REST. La respuesta es en formato JSON y el nombre de la variable es el nombre de la columna de base de datos
//Ejemplo: traerTodoTabla('Pacientes', traerTodoSuccess)

//crearSql(query, callback)
//Esta funcion les permite traer todos los objetos de la base de datos local dependiendo de un query personalizado. El string es igual al usado para enviar la informacion al servicio REST. La respuesta es en formato JSON y el nombre de la variable es el nombre de la columna de base de datos
//Ejemplo: crearSql('SELECT * FROM Pacientes WHERE apellido="Gotera"', crearSqlSuccess);

//RECUERDEN QUE DEBEN CAMBIAR EL MENU EN EL INDEX.HTML
start();
function start(){
    changeSubTitle("Costos");
    changeRightBtn("Guardar", "guardarPlanDeTratamiento", "");
    if(modoMedsio == "local"){
        crearTabla('CREATE TABLE IF NOT EXISTS Tratamientos (idTratamiento INTEGER PRIMARY KEY AUTOINCREMENT, desTratamiento, fechaTratamiento, horaTratamiento, idPaciente)');
        crearTabla('CREATE TABLE IF NOT EXISTS PlanesDeTratamiento (idPlanDeTratamiento INTEGER PRIMARY KEY AUTOINCREMENT, idPaciente, fechaPlanTratamiento, impuestoPlanTratamiento, valorPlanTratamiento, pagadoPlanTratamiento)');
        crearTabla('CREATE TABLE IF NOT EXISTS descripcionPlanDeTratamiento (idDescripcionPlanTratamiento INTEGER PRIMARY KEY AUTOINCREMENT, idPlanTratamiento, textoDescripcionPlanTratamiento, valorDescripcionPlanTratamiento)');
        crearTabla('CREATE TABLE IF NOT EXISTS Pagos (idPago INTEGER PRIMARY KEY AUTOINCREMENT, valorPago, fechaPago, idPlanTratamiento)');
    }
    
    listarTratamientosActivos();
    var hoy = fechaActual();
    var idPaciente = getPatientId();
    if(modoMedsio == "local"){
        crearSql('SELECT * FROM Tratamientos WHERE fechaTratamiento="'+hoy+'" AND idPaciente="'+idPaciente+'"', traerCostosSuccess);
    }else{
        var service = "Tratamientos/listar"
        var string = "fecha="+hoy+"&idPaciente="+idPaciente;
        
        ajax(service, string, traerCostosSuccess);
    }
    
}
function traerCostosSuccess(x){
    var obj = JSON.parse(x);
    var html="";
    for(var i=0;i<obj.length;i++){
       html += '<div class="row paddingRow">'; 
       html += '<div class="col-xs-8 col-xs-offset-1 costosRow descripcion">'+obj[i].desTratamiento+'</div>';
       html += '<div class="col-xs-2 costosRow">';
       html += '<div class="input-group">';
       html += '<span class="input-group-addon">$</span>';
       html += '<input type="number" class="form-control camposValor" id="miniTotal'+i+'" onkeyup="addCost(this);" value="0">';
       html += '</div></div>';
       html += '<div class="col-xs-1 costosRow"><img src="modulos/planes_de_tratamiento/img/eliminarTratamiento.png" onclick="quitarEsteProcedimiento('+i+');"/></div></div>';
    }
    
    document.getElementById("costosDesc").innerHTML = html;
    document.getElementById("total").value = 0;
    document.getElementById("tax").value = 0;
    cargarEstadoPrevio("planes_de_tratamiento",cargarEstadoPacienteNuevoPlanesDeTratamiento);
    
}
function quitarEsteProcedimiento(x){
    var filas = document.getElementById("costosDesc").getElementsByClassName("row paddingRow");
    
    document.getElementById("costosDesc").removeChild(filas[x]);
    addCost(x);
}
function addCost(x){
    if(x.value == ""){x.value = 0;}
  var number = parseInt(x.value);

  x.value = number;
  
  var total=0;
  
  var elements = document.getElementsByClassName("camposValor");
  
  for(var i=0;i<elements.length;i++){
      var m = parseInt(elements[i].value);
      total += m;
  }
  var impuestos = document.getElementById("tax").value;
  impuestos = parseInt(impuestos);
  total += impuestos;
  
  document.getElementById("total").value = total;
  
}

function guardarPlanDeTratamiento(){
    var hoy = fechaActual();
    hoy = encodeURIComponent(hoy);
    var valorTotalTratamiento = document.getElementById("total").value;
    var impuestoTratamiento = document.getElementById("tax").value;
    var idPaciente = getPatientId();
    
    var string = "fechaPlanTratamiento="+hoy+"&impuestoPlanTratamiento="+impuestoTratamiento+"&valorPlanTratamiento="+valorTotalTratamiento+"&idPaciente="+idPaciente+"&pagadoPlanTratamiento=0";
    
    guardarTabla('PlanesDeTratamiento', string, guardarPlanDeTratamiento2);
    
    function guardarPlanDeTratamiento2(x){
        var string = 'fechaPlanTratamiento='+hoy;
        if(modoMedsio == "local"){
        crearSql('SELECT * FROM PlanesDeTratamiento WHERE fechaPlanTratamiento="'+hoy+'"', guardarPlanDeTratamiento3);
        }else{
             var service = "PlanesDeTratamiento/listarFecha"
            var string = "idPaciente="+idPaciente+"&fecha="+hoy;

            ajax(service, string, guardarPlanDeTratamiento3);
        }
        
        function guardarPlanDeTratamiento3(y){
            var obj = JSON.parse(y);
            var idTratamiento = obj[obj.length-1].idPlanDeTratamiento;
            
            var descripciones = document.getElementById("costosDesc").getElementsByClassName("paddingRow");
            var i=0;
            guardarDescripciones();
            function guardarDescripciones(){
                var descripcion = descripciones[i].getElementsByClassName("descripcion")[0].innerHTML;
                var valor = document.getElementById("costosDesc").getElementsByClassName("col-xs-2 costosRow")[i].getElementsByClassName("input-group")[0].getElementsByClassName("form-control camposValor")[0].value;
                
                var string = "idPlanTratamiento="+idTratamiento+"&textoDescripcionPlanTratamiento="+descripcion+"&valorDescripcionPlanTratamiento="+valor;
               
                guardarTabla('descripcionPlanDeTratamiento', string, guardarPlanDeTratamiento4);
                
                function guardarPlanDeTratamiento4(z){
                    i++;
                    
                    if(i<descripciones.length){
                        guardarDescripciones();
                    }else{
                        listarTratamientosActivos();
                        guardarEvolucionCo();
                        pararGuardadoTemporal();
                    }
                }
                
            }
        }
    }
}
function listarTratamientosActivos(){
    document.getElementById("listaDeTratamientos").innerHTML = "";
    var html = '<div  class="row"><div  class="col-xs-6 col-xs-offset-1 costosTitle"><h5>Tratamientos Generados</h5></div><div  class="col-xs-2 costosTitle"><h5>Cargos</h5></div><div  class="col-xs-2 costosTitle"><h5>Abonos</h5></div></div>';
    html += '<div  class="row"><div  class="col-xs-6 col-xs-offset-1"></div><div  class="col-xs-2"><h5 id="totalCargos"></h5></div><div  class="col-xs-2"><h5 id="totalAbonos"></h5></div></div>';
    
    var idPaciente = getPatientId();
    if(modoMedsio == "local"){
        var sql = 'SELECT * FROM PlanesDeTratamiento WHERE idPaciente="'+idPaciente+'"';
        crearSql(sql, listarTratamientosActivos2);
    }else{
        var service = "PlanesDeTratamiento/listar"
        var string = "idPaciente="+idPaciente;
        
        ajax(service, string, listarTratamientosActivos2);
    }
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
               html += '<div  class="row paddingRow" onclick="verDetalleTratamiento('+obj[i].idPlanDeTratamiento+');">';
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
        //document.getElementById("valorAPagarTratamiento").value = "";
        document.getElementById("totalCargos").innerHTML = "$ "+totalDebe;
        document.getElementById("totalAbonos").innerHTML = "$ "+totalPagado;
    }
}
function verDetalleTratamiento(x){
    var html = "";
    if(modoMedsio == "local"){
        var sql = 'SELECT * FROM PlanesDeTratamiento WHERE idPlanDeTratamiento='+x;
        crearSql(sql, verDetalleTratamiento2);
    }else{
        var service="PlanesDeTratamiento/traer";
        var string = "idPlanDeTratamiento="+x;
        
        ajax(service, string, verDetalleTratamiento2);
    }
    
    function verDetalleTratamiento2(y){
        var obj = JSON.parse(y);
        html += '<a href="javascript:void(0);" onclick="cerrarTratamientoDetalle();" id="tratamientoDetalleCerrar">Cerrar</a>';
        html += '<div class="row">';
        html += '<div class="col-xs-6 col-xs-offset-1 costosTitle"><h5>Tratamiento '+obj[0].fechaPlanTratamiento+'</h5></div>';
        html += '<div class="col-xs-2 costosTitle"><h5>Costo Tratamiento</h5></div>';
        html += '<div class="col-xs-2 costosTitle"><h5>Abono Tratamiento</h5></div></div>';
        
        html += '<div class="row"><div class="col-xs-6 col-xs-offset-1"></div>';
        html += '<div class="col-xs-2"><h5 id="totalCargoTratamiento">$ '+obj[0].valorPlanTratamiento+'</h5></div>';
        html += '<div class="col-xs-2"><h5 id="totalAbonoTratamiento">$ '+obj[0].pagadoPlanTratamiento+'</h5></div></div>';
        html += '<div class="row paddingRow"><div class="col-xs-11 col-xs-offset-1"><h2>Procedimientos</h2></div></div>';
        
        if(modoMedsio == "local"){
            var sql = 'SELECT * FROM descripcionPlanDeTratamiento WHERE idPlanTratamiento="'+x+'"';
            crearSql(sql, verDetalleTratamiento3);
        }else{
            var service = "descripcionPlanDeTratamiento/listar";
            var string = "idPlanTratamiento="+x;
            
            ajax(service, string, verDetalleTratamiento3);
        }
        
        function verDetalleTratamiento3(z){
            var obj2 = JSON.parse(z);
            for(var i=0;i<obj2.length;i++){
                html += '<div class="row paddingRow"><div class="col-xs-6 col-xs-offset-1 costosRow">';
                html += '<p>'+obj2[i].textoDescripcionPlanTratamiento+'</p></div><div class="col-xs-2 costosRow">';
                html += '<h5>$ '+obj2[i].valorDescripcionPlanTratamiento+'</h5></div><div class="col-xs-2 costosRow"><h5>-</h5></div></div>';
            }
            
            html += '<div class="row paddingRow"><div class="col-xs-6 col-xs-offset-1 costosRow">';
            html += '<input type="number" class="form-control" id="valorAPagarTratamiento"/></div><div class="col-xs-2 costosRow">';
            html += '<button type="button" class="btn btn-primary" onclick="agregarPago('+x+');">Agregar Pago</button></div><div class="col-xs-2 costosRow"><h5 style="color:#FFF;">-</h5></div></div>';
            
            html += '<div class="row paddingRow"><div class="col-xs-11 col-xs-offset-1"><h2>Pagos</h2></div></div>';
            
            if(modoMedsio == "local"){
                var sql = 'SELECT * FROM Pagos WHERE idPlanTratamiento="'+x+'"';
                crearSql(sql, verDetalleTratamiento4);
            }else{
                var service = "Pagos/listar"
                var string = "idPlanTratamiento="+x;
                
                ajax(service, string, verDetalleTratamiento4);
            }
            
            function verDetalleTratamiento4(t){
                var obj3 = JSON.parse(t);
                for(var i=0;i<obj3.length;i++){
                    html += '<div class="row paddingRow"><div class="col-xs-6 col-xs-offset-1 costosRow">';
                    html += '<p>'+obj3[i].fechaPago+'</p></div><div class="col-xs-2 costosRow"><h5>-</h5>';
                    html += '</div><div class="col-xs-2 costosRow"><h5>$ '+obj3[i].valorPago+'</h5></div></div>';
                }
                document.getElementById("detalleTratamientoPopUp").innerHTML = html;
                document.getElementById("detalleTratamientoPopUp").style.display = "block";
            }        
        }   
    }  
}

function agregarPago(x){
   var pago = document.getElementById("valorAPagarTratamiento").value;
   if(pago == ""){
       alert("Debe agregar un valor primero.");
       return;
   }
   if(pago < 0){
       alert("Debe agregar un valor positivo.");
       return;
   }
   pago = parseInt(pago);
   var fecha = fechaActual();
   
   var string = "valorPago="+pago+"&fechaPago="+fecha+"&idPlanTratamiento="+x;
   
   guardarTabla('Pagos', string, agregarPago2);
   
   function agregarPago2(y){
       traerTabla('PlanesDeTratamiento', 'idPlanDeTratamiento='+x, agregarPago3);
       
       function agregarPago3(z){
           var obj = JSON.parse(z);
           
           var pagado = obj[0].pagadoPlanTratamiento;
           pagado = parseInt(pagado);
           pagado += pago;
           
           var string = "pagadoPlanTratamiento="+pagado+"&idPlanDeTratamiento="+x;
           editarTabla('PlanesDeTratamiento', string, agregarPago4);
           
           function agregarPago4(t){
               verDetalleTratamiento(x);
               guardarEvolucionCo();
           }
           
       }
   }
}
function cerrarTratamientoDetalle(){
    listarTratamientosActivos();
    document.getElementById("detalleTratamientoPopUp").style.display = "none"; 
}
function guardarEvolucionCo() {
//    var stringAnamnesis = "nombreModulo=Anamnesis&evolucion=" + encodeURIComponent(document.getElementById("medsioContent").innerHTML) + "&fecha=" + fechaActual() + "&hora=" + horaActual() + "&idPaciente=" + getPatientId();
    var stringCostos = "nombreModulo=PlanesDeTratamiento&evolucion=evolucion de Planes de Tratamiento&fecha=" + fechaActual() + "&hora=" + horaActual() + "&idPaciente=" + getPatientId();
    console.log(stringCostos);
    guardarTabla("Evolucion", stringCostos, nadaCostos);
    function nadaCostos() {
    }
}

function cargarEstadoPacienteNuevoPlanesDeTratamiento(json){
    iniciarGuardadoTemporal();
    var Json = decodeURIComponent(json);
    if(Json != ""){
       
        Json = Json.slice(2);
        Json = Json.slice(0, -2);
        Json = Json.replace(/"/g, '');
        var objetos = Json.split(",");
        
        for(var i=0;i<objetos.length;i++){
            var x = objetos[i].split(":");
            document.getElementById(x[0]).value = x[1];
        }
        
        
    }
    
}









