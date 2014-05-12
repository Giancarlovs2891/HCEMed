var idPacienteSeleccionado = "NaN";
var sexoPacienteSeleccionado ="NaN";
var modoMedsio = "central";    //"local" o "central"
var supLang = ["es"];
var fechaEvolucionGeneral = '';

function changeTitle(newTitle){
	document.getElementById("mainTitle").innerHTML = newTitle;
}
function changeSubTitle(newTitle){
	document.getElementById("mainSubTitle").innerHTML = newTitle;
}

function changeRightBtn(text, funcion, icon){
     if(icon == "" && text == ""){
         var boton= '<span onclick="'+funcion+'();" style="display:none;" ontouch="'+funcion+'();"><i class="icon '+icon+'" style="display=none;"></i>'+text+'</span>';
     }else if(icon == "" && text != ""){
         var boton= '<span onclick="'+funcion+'();"ontouch="'+funcion+'();" style="background-color: #2D8AB0;"><i class="icon '+icon+'" style="display=none;"></i>'+text+'</span>';
     }else{
        var boton= '<span onclick="'+funcion+'();" ontouch="'+funcion+'();"><i class="icon '+icon+'"></i>'+text+'</span>'; 
     }
     
        document.getElementById("rightbtn").innerHTML = boton;
}

function changeLeftBtn(text, funcion, icon){
	var boton= '<span onclick="'+funcion+'();" ontouch="'+funcion+'();"><i class="icon '+icon+'" ></i>'+text+'</span>';
	document.getElementById("leftbtn").innerHTML = boton;
}
function changeRightSubBtn(text, funcion, icon){
		var boton= '<i class="icon '+icon+'" onclick="'+funcion+'();"></i>'+text;
		document.getElementById("rightSubbtn").innerHTML = boton;
}
function changeLeftSubBtn(text, funcion, icon){
	var boton= '<i class="icon '+icon+'" onclick="'+funcion+'();"></i>'+text;
	document.getElementById("leftSubbtn").innerHTML = boton;
}

var menu = "cerrado"
function toggleMenu(){
	if(menu == "abierto"){
		document.getElementById("medsioMenu").style.webkitTransform = "translate3d(-104px,0,0)";
                menu = "cerrado";
	}else{
		document.getElementById("medsioMenu").style.webkitTransform = "translate3d(0,0,0)";
                menu = "abierto";
	}
}
function activateMenu(x){
        if((id != "datos_basicos") && (idPacienteSeleccionado == "NaN")){
            return;
        }
        
        var lis = document.getElementById("medsioMenu").getElementsByTagName("LI");

	for(var i=0;i<lis.length;i++){
		lis[i].className="";
	}
        
        var id = x.getAttribute("id");
        
	var li = document.getElementById(id).getElementsByTagName("LI");
	li[0].className = "selected";

	
	var lang = getLang();
	var dir = "modulos/"+id+"/"+lang+"/index.html";
	var dirjs = "modulos/"+id+"/"+lang+"/js/main.js";
        var dircss = "modulos/"+id+"/"+lang+"/css/main.css";

	

  	//document.getElementById("frame").setAttribute("src",dir);
        
        var xhr= new XMLHttpRequest();
        xhr.open('GET', dir, true);
        xhr.onreadystatechange= function() {
            if (this.readyState!==4) return;
            if (this.status!==200) return; // or whatever error handling you want
            document.getElementById('medsioContent').innerHTML= this.responseText;
            loadJsFile(dirjs);
            loadCssFile(dircss);
        };
        xhr.send();
}


function getLang(){
	var lang;
    if (navigator
            && navigator.userAgent
            && (lang = navigator.userAgent
                    .match(/android.*\W(\w\w)-(\w\w)\W/i))) {
        lang = lang[1];
    }

    if (!lang && navigator) {
        if (navigator.language) {
            lang = navigator.language;
        } else if (navigator.browserLanguage) {
            lang = navigator.browserLanguage;
        } else if (navigator.systemLanguage) {
            lang = navigator.systemLanguage;
        } else if (navigator.userLanguage) {
            lang = navigator.userLanguage;
        }
        lang = lang.substr(0, 2);
    }

   var isLangSupported = 0;

   for(var i=0;i<supLang;i++){
   		if(supLang[i] == lang){
   			isLangSupported = 1;
   		}
   }
   
   if(isLangSupported == 0){
   	lang = "es";
   }
  
   return lang;
}
function getPatientId(){
	return idPacienteSeleccionado;
}
function getPatientSex(){
	return sexoPacienteSeleccionado;
}
function getModoMedsio(){
	return modoMedsio;
}
function loadJsFile(filename){
  var fileref=document.createElement('script');
  fileref.setAttribute("type","text/javascript");
  fileref.setAttribute("src", filename);
  document.getElementById("medsioContent").appendChild(fileref);
}
function loadCssFile(filename){
  var fileref=document.createElement("link");
  fileref.setAttribute("rel", "stylesheet");
  fileref.setAttribute("type", "text/css");
  fileref.setAttribute("href", filename);
  document.getElementsByTagName("head")[0].appendChild(fileref);
}
function createString(id){
var global = document.getElementById(id);
var string = "";

var inputs = global.getElementsByTagName("input");
var textareas = global.getElementsByTagName("textarea");
var selects = global.getElementsByTagName("select");

for(var i=0;i<inputs.length;i++){
    var type = inputs[i].getAttribute("type");


    if(type == "radio" || type == "checkbox"){
        if(inputs[i].checked) {
            string += inputs[i].getAttribute("name")+"="+inputs[i].value+"&";
        }
    }else{
        string += inputs[i].getAttribute("id")+"="+inputs[i].value+"&";
    }

}

for(var i=0;i<textareas.length;i++){
    string += textareas[i].getAttribute("id")+"="+textareas[i].value+"&";
}

for(var i=0;i<selects.length;i++){
    var selectType = selects[i].getAttribute("multiple");

    if(selectType == "multiple"){
       for (var j = 0; j < selects[i].length; j++) {
           if (selects[i][j].selected) {
	       string += selects[i].getAttribute("id")+"="+selects[i][j].value+"&";
           }
       }
    }else{
       string += selects[i].getAttribute("id")+"="+selects[i].value+"&";
    }
    
}
string = string.substring(0, string.length - 1);

return string;


}
var galeriaPortableSw=1;
function toggleGaleriaPortable(){
    if(galeriaPortableSw == 0){
       document.getElementById("galeriaPortable").style.webkitTransform = "translate3d(0,0,0)";
        galeriaPortableSw=1;
    }else{
        document.getElementById("galeriaPortable").style.webkitTransform = "translate3d(-154px,0,0)";
        galeriaPortableSw=0;
    }
}

function login(){
    var servicio="HCEMed/Usuarios/login";
    var string = "usuario="+document.getElementById("usuario").value+"&contrasena="+document.getElementById("contrasena").value;
    
    ajax(servicio, string, login2);
    
    function login2(x){
        inicioMedsio();
        document.getElementById("loginScreen").style.display = "none";
    }
}
function fechaActual(){
    var d = new Date();
    var dia = d.getDate();
    var mes = d.getMonth() +1;
    var anio = d.getFullYear();

    var fecha =  anio+"-"+mes+"-"+dia;
    
    return fecha;
}

function horaActual(){
    var d = new Date();
    var hora = d.getHours();
    var minuto = d.getMinutes();
    var segundos = d.getSeconds();

    var horaReal = hora+":"+minuto+":"+segundos;
    
    return horaReal;
}

function mostrarConClase (clase) {
    $("." + clase).show();
}

function ocultarConClase (clase) {
    $("." + clase).hide();
}

function mostrar(id) {
    $("#" + id).show();
}
function ocultar(id) {
    $("#" + id).hide();
}


function inicioMedsio(){
    
    navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia;
 
    canvas = document.getElementById("canvas");
    context = canvas.getContext("2d");
    video = document.getElementById("video");
    videoObj = {video: true, audio: false};
     traerTodoTabla("Pacientes", inicioMedsio2);
     
     function inicioMedsio2(x){
         var obj = JSON.parse(x);
         
         var directorio = "";
         var inicial = "#";
         for(var i=0;i<obj.length;i++){
             var letraApellido = obj[i].apellidoPaciente.substring(0,1);
             if(letraApellido != inicial){
                directorio += '<li class="divider">'+letraApellido+'</li>';
                incial = letraApellido;
             }
             var foto = decodeURIComponent(obj[i].foto);
             directorio += '<li onclick="loadDatosBasicos('+obj[i].idPaciente+');" ontouch="loadDatosBasicos('+obj[i].idPaciente+');">';
             directorio += '<img src="'+foto+'" />';
             directorio += '<h1>'+obj[i].nombrePaciente+' <span class="apellido">'+obj[i].apellidoPaciente+'</span></h1>';
             directorio += '<h2>'+obj[i].tipoIdentificacionPaciente+': '+obj[i].identificacionPaciente+'</h2>';
             directorio += '</li>';    
         }
         document.getElementById("listaPacientes").innerHTML = directorio;
     }
}

var estado = "vistaPacientes";
function inicio(){
    alert("Error al cargar archivo del modulo");
}
function vistaPrincipal(){
	if(estado == "vistaPrincipal"){
		return;
	}

        menu = "cerrado";
	var estado = "vistaPrincipal";
        document.getElementById("medsioMenu").style.webkitTransform = "translate3d(-104px,0,0)";
	document.body.scrollTop = '0px';

	document.getElementById("mainBody").style.display = "block";
	document.getElementById("mainBody").style.zIndex = "1";
	document.getElementById("listaPacientes").style.zIndex = "2";

	document.getElementById("listaPacientes").style.webkitTransform = "translate3d(-100%,0,0)";	
	document.getElementById("mainBody").style.webkitTransform = "translate3d(0%,0,0)";

	changeTitle("HCE med"); 
	changeLeftBtn('', 'vistaPacientes', 'ion-person-stalker');
	//changeRightBtn('Guardar', 'inicio');

	document.getElementById("subHeader").innerHTML = '<div class="leftSubHeader" id="leftSubbtn"><i  class="icon ion-navicon-round" onclick="toggleMenu();"></i></div>';
	document.getElementById("subHeader").innerHTML += '<h1 id="mainSubTitle">Datos Basicos</h1>';
	document.getElementById("subHeader").innerHTML += '<div class="rightSubHeader" id="rightSubbtn"><i class="icon ion-image" onclick="toggleGaleriaPortable();"></i></div>';

	document.addEventListener('webkitTransitionEnd', cambiaAVistaPrincipal);

	function cambiaAVistaPrincipal(event){
		document.getElementById("listaPacientes").style.display = "none";

		document.removeEventListener('webkitTransitionEnd', cambiaAVistaPrincipal);
	}
	}

function vistaPacientes(){
        idPacienteSeleccionado = "NaN";
        sexoPacienteSeleccionado = "NaN";
	if(estado == "vistaPacientes"){return;}

	var estado = "vistaPacientes";
	document.body.scrollTop = '0px';

	document.getElementById("listaPacientes").style.display = "block";
	document.getElementById("mainBody").style.zIndex = "2";
	document.getElementById("listaPacientes").style.zIndex = "1";

	document.getElementById("listaPacientes").style.webkitTransform = "translate3d(0%,0,0)";
	document.getElementById("mainBody").style.webkitTransform = "translate3d(100%,0,0)";	

	changeTitle("PACIENTES"); 
	changeLeftBtn('', 'logOut', 'ion-log-out');
	changeRightBtn('', 'loadDatosBasicos', 'ion-plus-round');

	document.getElementById("subHeader").innerHTML = '<input type="search" placeholder="Busqueda de Pacientes" id="busquedaPacientes" onkeyup="buscarPaciente(this);"/>';

	document.addEventListener( 'webkitTransitionEnd', cambiaAListaDePacientes);

	function cambiaAListaDePacientes(event){
		document.getElementById("mainBody").style.display = "none";

		document.removeEventListener('webkitTransitionEnd', cambiaAListaDePacientes);
                inicioMedsio();
                document.getElementById("fotoMenuDatosBasicos").setAttribute("src", "modulos/datos_basicos/img/menu.png");
                document.getElementById("nombrePacienteGeneralMedsio").innerHTML = "";
                document.getElementById("alertaMedicaGeneralMedsio").innerHTML = "";
	}
}

crearDB('MEDSIO', '1.0', 'Base de Datos de Medsio', 5000000);
crearTabla('CREATE TABLE IF NOT EXISTS Galeria (idFoto INTEGER PRIMARY KEY AUTOINCREMENT, idPaciente INTEGER, foto LONG TEXT, fecha DATE, hora TIME)');
crearTabla('CREATE TABLE IF NOT EXISTS Pacientes (idPaciente INTEGER PRIMARY KEY AUTOINCREMENT, alertaMedica, nombrePaciente, foto, apellidoPaciente, fechaNacimientoPaciente, tipoIdentificacionPaciente, identificacionPaciente, estadoPaciente, estadoCivilPaciente, sexoPaciente, razaPaciente, ocupacionPaciente, telefonoPaciente, celularPaciente, emailPaciente, paisPaciente, departamentoPaciente, ciudadPaciente, nacionalidadPaciente, direccionPaciente, zonaResidencialPaciente, codigoPostalPaciente, estratoPaciente, companiaSeguroPaciente, tipoVinculacionPaciente, nombreRepresentante, apellidoRepresentante, tipoIdentificacionRepresentante, identificacionRepresentante, telefonoRepresentante, parentescoRepresentante, nombreEmergencia, telefonoEmergencia, parentescoEmergencia, nombreReferido, fechaCreacion, horaCreacion)');
crearTabla('CREATE TABLE IF NOT EXISTS Evolucion (idEvolucion INTEGER PRIMARY KEY AUTOINCREMENT, idPaciente INTEGER, nombreModulo, fecha DATE, hora TIME, evolucion TEXT)');
crearTabla('CREATE TABLE IF NOT EXISTS Diagnosticos (idDiagnostico INTEGER PRIMARY KEY AUTOINCREMENT, idPaciente INTEGER, nombreModulo, nombreDiagnostico, diagnostico LONG TEXT, fecha DATE, hora TIME)');

function guardarDiagnosticos(idCampoD, nombreModuloD, nombreDiagnostico){
    if($(idCampoD).val()!=""){
        var stringDiagnostico = "nombreModulo="+nombreModuloD+"&nombreDiagnostico="+nombreDiagnostico+"&diagnostico="+$(idCampoD).val()+"&idPaciente="+getPatientId()+"&fecha="+fechaActual()+"&hora="+horaActual();
        guardarTabla("Diagnosticos", stringDiagnostico,callbackDiagnostico);
    }
}

function callbackDiagnostico(){
    console.log("diagnostico guardado");
}

function buscarPaciente(x){
    if(x.value == ""){
        traerTodoTabla("Pacientes", buscarPaciente2);
     
     function buscarPaciente2(x){
         var obj = JSON.parse(x);
         
         var directorio = "";
         var inicial = "#";
         for(var i=0;i<obj.length;i++){
             var letraApellido = obj[i].apellidoPaciente.substring(0,1);
             if(letraApellido != inicial){
                directorio += '<li class="divider">'+letraApellido+'</li>';
                incial = letraApellido;
             }
             var foto = decodeURIComponent(obj[i].foto);
             directorio += '<li onclick="loadDatosBasicos('+obj[i].idPaciente+');" ontouch="loadDatosBasicos('+obj[i].idPaciente+');">';
             directorio += '<img src="'+foto+'" />';
             directorio += '<h1>'+obj[i].nombrePaciente+' <span class="apellido">'+obj[i].apellidoPaciente+'</span></h1>';
             directorio += '<h2>'+obj[i].tipoIdentificacionPaciente+': '+obj[i].identificacionPaciente+'</h2>';
             directorio += '</li>';    
         }
         document.getElementById("listaPacientes").innerHTML = directorio;
     }
    }else{
        var string = 'SELECT * FROM Pacientes WHERE nombrePaciente LIKE "%'+x.value+'%" OR apellidoPaciente LIKE "%'+x.value+'%" OR identificacionPaciente LIKE "%'+x.value+'%"'
        
        crearSql(string, buscarPacienteSuccess);
        
        function buscarPacienteSuccess(x){
            var directorio = "";
            var inicial = "#";
            
            var obj = JSON.parse(x);

            if(obj.length == 0){
                directorio += '<li class="divider">N</li>';
                directorio += '<li onclick="loadDatosBasicos();" ontouch="loadDatosBasicos();">';
                directorio += '<img src="modulos/datos_basicos/img/menu.png" />';
                directorio += '<h1>+ <span class="apellido">Nuevo Paciente</span></h1>';
                directorio += '<h2>El paciente no existe en Base de Datos, haga click aqui para agregar un nuevo Paciente</h2>';
                directorio += '</li>'; 
                
                document.getElementById("listaPacientes").innerHTML = directorio;
            }else{

                
                for(var i=0;i<obj.length;i++){
                    var letraApellido = obj[i].apellidoPaciente.substring(0,1);
                    if(letraApellido != inicial){
                       directorio += '<li class="divider">'+letraApellido+'</li>';
                       incial = letraApellido;
                    }
                    var foto = decodeURIComponent(obj[i].foto);
                    directorio += '<li onclick="loadDatosBasicos('+obj[i].idPaciente+');" ontouch="loadDatosBasicos('+obj[i].idPaciente+');">';
                    directorio += '<img src="'+foto+'" />';
                    directorio += '<h1>'+obj[i].nombrePaciente+' <span class="apellido">'+obj[i].apellidoPaciente+'</span></h1>';
                    directorio += '<h2>'+obj[i].tipoIdentificacionPaciente+': '+obj[i].identificacionPaciente+'</h2>';
                    directorio += '</li>';    
                }
                document.getElementById("listaPacientes").innerHTML = directorio;
            }
           }
    }
}


function loadDatosBasicos(id){
        if(!id){id="NaN";}
        galeriaPortableSw=1;
        fotoCarreteSw=1;
        loadGaleriaPortable(id);
        document.getElementById("galeriaPortable").style.webkitTransform = "translate3d(0px,0,0)";
        
        
        vistaPrincipal();
        
        

        idPacienteSeleccionado=id;
        
        
	var lis = document.getElementById("medsioMenu").getElementsByTagName("LI");

	for(var i=0;i<lis.length;i++){
		lis[i].className="";
	}
        
	var li = document.getElementById("datos_basicos").getElementsByTagName("LI");
	li[0].className = "selected";

	var lang = getLang();
	var dir = "modulos/datos_basicos/"+lang+"/index.html";
	var dirjs = "modulos/datos_basicos/"+lang+"/js/main.js";
        var dircss = "modulos/datos_basicos/"+lang+"/css/main.css";

	loadJsFile(dirjs);
        loadCssFile(dircss);
        

  	var xhr= new XMLHttpRequest();
        xhr.open('GET', dir, true);
        xhr.onreadystatechange= function() {
        if (this.readyState!==4) return;
        if (this.status!==200) return; // or whatever error handling you want
        document.getElementById('medsioContent').innerHTML= this.responseText;
        document.getElementById("medsioContent").scrollTop = 0;
        };
        xhr.send();
}

function loadGaleriaPortable(x){
    if(x == "NaN"){return;}
    document.getElementById("galeriaPortable").innerHTML = "";
    crearSql('SELECT * FROM Galeria WHERE idPaciente="'+x+'"', traerGaleriaSuccess);
}
function traerGaleriaSuccess(x){
    var obj = JSON.parse(x);
    if(obj.length == 0){return;}
    var html = "";
    for(var i=0;i<obj.length;i++){
        var foto = decodeURIComponent(obj[i].foto);
        html += '<a href="javascript:void(0);" onclick="desplegarFoto('+obj[i].idFoto+')"><img src="'+foto+'" /><span>'+obj[i].fecha+'</span></a>';
    }
    document.getElementById("galeriaPortable").innerHTML = html;
}

var fotoCarreteSw=1;
function toggleFotoCarrete(){
    if(fotoCarreteSw == 0){
       document.getElementById("fotoCarrete").style.webkitTransform = "translate3d(0,0,0)";
       fotoCarreteSw=1;
    }else{
        document.getElementById("fotoCarrete").style.webkitTransform = "translate3d(-100%,0,0)";
        fotoCarreteSw=0;
    }
}
var evolucionCarreteSw=1;
function toggleEvolucionCarrete(){
    if(evolucionCarreteSw == 0){
       document.getElementById("evolucionCarrete").style.webkitTransform = "translate3d(0,0,0)";
       evolucionCarreteSw=1;
       document.getElementById("nuevaEvolucion").disabled=false;
       document.getElementById("evolucionCarrete").innerHTML = "";
    }else{
        document.getElementById("evolucionCarrete").style.webkitTransform = "translate3d(-100%,0,0)";
        evolucionCarreteSw=0;
    }
}

function desplegarFoto(x){
    traerTabla("Galeria", "idFoto="+x, desplegarFoto2);
    
    function desplegarFoto2(y){
        var obj = JSON.parse(y);

        document.getElementById("fotoCarreteContainer").innerHTML = "";
        document.getElementById("nextFotoCarrete").setAttribute("onclick", "nextFoto("+obj[0].idFoto+");" );
        document.getElementById("previousFotoCarrete").setAttribute("onclick", "previousFoto("+obj[0].idFoto+");" );
        var image = document.createElement('img');

        image.addEventListener('load', function() {
             var desireHeight = document.getElementById("fotoCarreteContainer").clientHeight;
             var desireWidth = document.getElementById("fotoCarreteContainer").clientWidth;
             var actualWidth = image.width;
             var actualHeight = image.height;
             
             var newWidth = desireWidth;
             var newHeight = (actualHeight*newWidth)/actualWidth;
             
             if(newHeight > desireHeight){
                 newHeight = desireHeight;
                 newWidth = (actualWidth*newHeight)/actualHeight;
             }
             image.width = newWidth;
             image.height = newHeight;
             
             document.getElementById("fotoCarreteContainer").appendChild(image);
             var myScroll;
             myScroll = new iScroll('fotoCarreteContainer', {zoom:true, onBeforeScrollStart: null, zoomMin:1, useTransform:true, useTransition:true});

             toggleFotoCarrete();
        });
        var foto = decodeURIComponent(obj[0].foto);
        image.src = foto; 
    }
}

function nextFoto(x){
    crearSql('SELECT * FROM Galeria WHERE idPaciente="'+idPacienteSeleccionado+'"', nextFoto2);
    
    function nextFoto2(y){
        var obj = JSON.parse(y);
        
        var sw = 0;
        for(var i=0;i<obj.length;i++){
            if(sw == 1){
                document.getElementById("fotoCarreteContainer").innerHTML = "";
                document.getElementById("nextFotoCarrete").setAttribute("onclick", "nextFoto("+obj[i].idFoto+");" );
                document.getElementById("previousFotoCarrete").setAttribute("onclick", "previousFoto("+obj[i].idFoto+");" );
                
                var image = document.createElement('img');

                image.addEventListener('load', function() {
                     var desireHeight = document.getElementById("fotoCarreteContainer").clientHeight;
                     var desireWidth = document.getElementById("fotoCarreteContainer").clientWidth;
                     var actualWidth = image.width;
                     var actualHeight = image.height;

                     var newWidth = desireWidth;
                     var newHeight = (actualHeight*newWidth)/actualWidth;

                     if(newHeight > desireHeight){
                         newHeight = desireHeight;
                         newWidth = (actualWidth*newHeight)/actualHeight;
                     }
                     image.width = newWidth;
                     image.height = newHeight;

                     document.getElementById("fotoCarreteContainer").appendChild(image);
                     var myScroll;
                     myScroll = new iScroll('fotoCarreteContainer', {zoom:true, onBeforeScrollStart: null, zoomMin:1, useTransform:true, useTransition:true});
                });
                var foto = decodeURIComponent(obj[i].foto);
                image.src = foto; return;
            }
            if(obj[i].idFoto == x){
                sw=1;
            }
        }
    }
}

function previousFoto(x){
     crearSql('SELECT * FROM Galeria WHERE idPaciente="'+idPacienteSeleccionado+'"', previousFoto2);
    
    function previousFoto2(y){
        var obj = JSON.parse(y);
        
        var sw = 0;
        for(var i=obj.length-1;i>=0;i--){
            if(sw == 1){
                 document.getElementById("fotoCarreteContainer").innerHTML = "";
                document.getElementById("nextFotoCarrete").setAttribute("onclick", "nextFoto("+obj[i].idFoto+");" );
                document.getElementById("previousFotoCarrete").setAttribute("onclick", "previousFoto("+obj[i].idFoto+");" );
                
                var image = document.createElement('img');

                image.addEventListener('load', function() {
                     var desireHeight = document.getElementById("fotoCarreteContainer").clientHeight;
                     var desireWidth = document.getElementById("fotoCarreteContainer").clientWidth;
                     var actualWidth = image.width;
                     var actualHeight = image.height;

                     var newWidth = desireWidth;
                     var newHeight = (actualHeight*newWidth)/actualWidth;

                     if(newHeight > desireHeight){
                         newHeight = desireHeight;
                         newWidth = (actualWidth*newHeight)/actualHeight;
                     }
                     image.width = newWidth;
                     image.height = newHeight;

                     document.getElementById("fotoCarreteContainer").appendChild(image);
                     var myScroll;
                     myScroll = new iScroll('fotoCarreteContainer', {zoom:true, onBeforeScrollStart: null, zoomMin:1, useTransform:true, useTransition:true});
                });
                var foto = decodeURIComponent(obj[i].foto);
                image.src = foto; return;
            }
            if(obj[i].idFoto == x){
                sw=1;
            }
        }
    }
}

var appCache = window.applicationCache;

appCache.addEventListener('checking', function(event) {
    console.log("Checking for updates.");
}, false);


appCache.addEventListener('downloading', function(event) {
    document.getElementById("cacheMensaje").style.visibility = "visible";
}, false);


appCache.addEventListener('progress', function(event) {
    document.getElementById("cacheProgress").innerHTML = event.loaded+" de "+event.total;
    console.log(event.loaded + " of " + event.total + " downloaded.");
}, false);

appCache.addEventListener('cached', function(event) {
    document.getElementById("cacheMensaje").style.visibility = "hidden";
}, false);

function scrollUp(){
    document.getElementById("MedsioContent").scrollTop = 0;
}
