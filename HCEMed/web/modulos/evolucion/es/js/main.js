
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
var jsonGeneral ="";
function start(){
    crearTabla('CREATE TABLE IF NOT EXISTS EvolucionComentarios (idEvolucionComentario INTEGER PRIMARY KEY AUTOINCREMENT, idPaciente INTEGER, firma LONGTEXT, comentario, fecha DATE, hora TIME)');
    changeSubTitle("Evolucion");
    changeRightBtn("Guardar", "guardarEvolucion", "");
    definirModulosActivos();
    
}
function definirModulosActivos(){
    var x = document.getElementById("medsioMenu").getElementsByTagName("a");
    
    var modulo = new Array();
    var moduloDB = new Array();
    
    for(var i=0; i<x.length;i++){
        var n = x[i].id;
        var n2 = n.split("_");
        var nombre = "";
        for(var j=0; j<n2.length;j++){
            nombre += n2[j].charAt(0).toUpperCase() + n2[j].slice(1);
        }
        modulo[i] = x[i].id;
        moduloDB[i] = nombre;
    }
    definirNumeroEvoluciones(modulo, moduloDB);
}

function definirNumeroEvoluciones(modulo, moduloDB){
    var idPaciente = getPatientId();
    var query = "SELECT * FROM Evolucion WHERE idPaciente = '"+idPaciente+"' ORDER BY fecha";
    crearSql(query, definirNumeroEvolucionesSuccess);
    
    function definirNumeroEvolucionesSuccess(x){
        jsonGeneral = x;
        var items = JSON.parse(x);
        var fechas = new Array();//Este var es el numero de evoluciones que debe haber
        fechas[0] = fechaActual();
        for(var i=0;i<items.length;i++){
            if(fechas.indexOf(items[0].fecha) == -1){
              fechas[fechas.length] = items[i].fecha;
             }
        }
        pintarEvoluciones(modulo, moduloDB, fechas);
    }
}

function pintarEvoluciones(modulo, moduloDB, fechas){
    var html = '';
    var i = 0;
    var hoy = fechaActual();
    pintarEvolucion();
    function pintarEvolucion(){
        html += '<div class="evolutionStory"><div class="evolutionHeader"><div class="fechaEvolucion">Fecha: '+fechas[i]+'</div><ul class="historiaEvolucion">';
        
        for(var j=0;j<modulo.length;j++){
            if(modulo[j] == "datos_basicos" || modulo[j] == "evolucion" || modulo[j] == "galeria"){
            
            }else{
                var busquedaJson = '"nombreModulo" : "'+moduloDB[j]+'" , "fecha" : "'+fechas[i]+'"';
                var existe = jsonGeneral.indexOf(busquedaJson);
                if(existe == -1){
                    html += '<a href="javascript:void(0);" onclick=""><li><img src="modulos/'+modulo[j]+'/img/menu.png" /></li></a>';
                }else{
                    html += '<a href="javascript:void(0);" onclick="cargarEvolucionModulo(&#39;'+modulo[j]+'&#39;, &#39;'+fechas[i]+'&#39;)"><li class="filled"><img src="modulos/'+modulo[j]+'/img/menu.png" /></li></a>';
                }
            }
        }
        html += '</ul></div>';
        
        if(fechas[i] == hoy){
            html += '<textarea id="nuevaEvolucion"></textarea><canvas id="firmaEvolucion"></canvas><a href="javascript:void(0);" id="clearCanvas" onclick="clearCanvas();">Borrar Firma</a>';
        }
        
        var query = "SELECT * FROM EvolucionComentarios WHERE idPaciente = '"+idPacienteSeleccionado+"' AND fecha = '"+fechas[i]+"' ORDER BY idEvolucionComentario DESC";
        crearSql(query, pintarEvoluciones2);
        
        function pintarEvoluciones2(z){
            var obj3 = JSON.parse(z);
            for(var o=0;o<obj3.length;o++){
                var firma = decodeURIComponent(obj3[o].firma);
                html += '<h1>Hora: '+obj3[o].hora+'</h1>';
                html += '<p class="descripcionEvolucion">'+obj3[o].comentario+'</p>';
                html += '<img src="'+firma+'" class="imagenFirma" />';
            }
            
            html += '</div>';
            
            if(i<fechas.length-1){
                i +=1;
                pintarEvolucion();
            }else{
                document.getElementById('evolucionScreen').innerHTML = html;
                canvas = new fabric.Canvas('firmaEvolucion', {isDrawingMode: true});
                canvas.isDrawingMode = true; 
                canvas.freeDrawingBrush.color = "#000";
                canvas.freeDrawingBrush.width = "1";
            }
        }
        
    }
    
}

function guardarEvolucion(){
    var hoy = fechaActual();
    var hora = horaActual();
    var idPaciente = getPatientId();
    var comentario = document.getElementById("nuevaEvolucion").value;
    var firma = canvas.toDataURL('jpg');
    firma = encodeURIComponent(firma);
    
    var string = 'idPaciente='+idPaciente+'&firma='+firma+'&comentario='+comentario+'&fecha='+hoy+'&hora='+hora;
    guardarTabla('EvolucionComentarios', string, guardarEvolucionSuccess);
    
    function guardarEvolucionSuccess(x){
        document.getElementById("nuevaEvolucion").value = "";
        canvas.clear();
        definirModulosActivos();
    }
}

function cargarEvolucionModulo(nombreModulo, fecha){
    fechaEvolucionGeneral = fecha;
    var lang = getLang();
    var dir = "modulos/"+nombreModulo+"/"+lang+"/index.html";
    var dirjs = "modulos/"+nombreModulo+"/"+lang+"/js/evolucion.js";
    var dircss = "modulos/"+nombreModulo+"/"+lang+"/css/main.css";
    
    var xhr= new XMLHttpRequest();
    xhr.open('GET', dir, true);
    xhr.onreadystatechange= function() {
        if (this.readyState!==4) return;
        if (this.status!==200) return; // or whatever error handling you want
        document.getElementById('evolucionCarrete').innerHTML = '<a href="javascript:toggleEvolucionCarrete()" id="cerrarEvolucionCarrete">Cerrar</a>';
        document.getElementById('evolucionCarrete').innerHTML += this.responseText;
        loadCssEvolucionFile(dircss);
        loadJsEvolucionFile(dirjs);
        toggleEvolucionCarrete();
    };
    xhr.send();
}
function loadJsEvolucionFile(filename){
  var fileref=document.createElement('script');
  fileref.setAttribute("type","text/javascript");
  fileref.setAttribute("src", filename);
  document.getElementById("evolucionCarrete").appendChild(fileref);
}

function loadCssEvolucionFile(filename){
  var fileref=document.createElement("link");
  fileref.setAttribute("rel", "stylesheet");
  fileref.setAttribute("type", "text/css");
  fileref.setAttribute("href", filename);
  document.getElementsByTagName("head")[0].appendChild(fileref);
}
function clearCanvas(){
    canvas.clear();
}
  










