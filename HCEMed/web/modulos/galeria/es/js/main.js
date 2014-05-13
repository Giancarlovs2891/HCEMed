
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
        changeSubTitle("Galeria");
	loadCssFile("modulos/galeria/es/css/main.css");
	changeRightBtn("", "", "");
	crearTabla('CREATE TABLE IF NOT EXISTS Galeria (idFoto INTEGER PRIMARY KEY AUTOINCREMENT, idPaciente INTEGER, foto LONGTEXT, fecha DATE, hora TIME)');
	listarFotos();
         var iOS = ( navigator.userAgent.match(/(iPad|iPhone|iPod|Android|IEMobile|BlackBerry)/g) ? true : false );
        if (iOS == "1"){

         document.getElementById("camaraPacienteGaleria").style.display = "none";
         document.getElementById("fotoPickerGaleria").style.backgroundImage = 'url("img/camerabg.png")';

        }
}

function seleccionarArchivo() {
    document.getElementById('filesGaleria').click();
}

function subirFotoGaleria(){
	traerFoto("filesGaleria", subirFotoGaleria2);
}

function subirFotoGaleria2(img){
	
	var d = new Date();
	var dia = d.getDate();
	var mes = d.getMonth() +1;
	var anio = d.getFullYear();
	var hora = d.getHours();
	var minuto = d.getMinutes();

	var fecha =  anio+"-"+mes+"-"+dia;
	var horaReal = hora+":"+minuto;
	var idPaciente = getPatientId();
	var foto = img;
        foto = encodeURIComponent(foto);

	var string = "idPaciente="+idPaciente+"&foto="+foto+"&fecha="+fecha+"&hora="+horaReal;
	
	guardarTabla("Galeria", string, guardarSuccess);
}
function guardarSuccess(x){
	listarFotos();
        loadGaleriaPortable(idPacienteSeleccionado);
}
function traerFoto(id, funcion) {
    var selectedFile = document.getElementById(id).files[0];
    var reader = new FileReader();

    reader.onload = function(event) {
        var imagen = event.target.result;
        funcion(imagen);
    };

    reader.readAsDataURL(selectedFile);
}
function listarFotos(){
	var idPaciente = getPatientId();
	
        traerTabla("Galeria", "idPaciente="+idPaciente, listarFotosSuccess);
}
function listarFotosSuccess(x){
	var obj = JSON.parse(x);
	var html = "";

	for(var i=0;i<obj.length;i++){
            var foto = decodeURIComponent(obj[i].foto);
		html += '<div onmouseover="mostrarX(this);" onmouseout="esconderX(this);">';
                html += '<a href="javascript:void(0);" class="botonParaBorrar" onclick="borrarFoto('+obj[i].idFoto+');" ontouch="borrarFoto('+obj[i].idFoto+');"></a>';
                html += '<div class="cell"  ontouchstart="activarBorrar();" ontouchend="desactivarBorrar('+obj[i].idFoto+');" onclick="desplegarFoto('+obj[i].idFoto+');" style="background-image:url('+foto+');">';
                html += '<span class="fecha">'+obj[i].fecha+'</span>';
                html += '</div></div>';
	}

	document.getElementById("showRoom").innerHTML = html;
}
function mostrarX(x){
    var links = x.getElementsByTagName("a");
    links[0].style.display="block";
}
function esconderX(x){
    var links = x.getElementsByTagName("a");
    links[0].style.display="none";
}
function borrarFoto(x){
        var r= confirm("Esta seguro que desea borrar la foto?")
        if(r == true){
            var string = "idFoto="+x;
            borrarTabla('Galeria', string, listarFotos);
            loadGaleriaPortable(idPacienteSeleccionado);
        }
}
var cancelarMostrarFoto=0;

function activarBorrar(){
	cancelarMostrarFoto=0;
	event.preventDefault();
	pressTimer = window.setTimeout(function() {

		var numeroImagenes = document.getElementById("showRoom").getElementsByTagName("div");

		for(var i=0;i<numeroImagenes.length;i++){
			numeroImagenes[i].className = 'cell shaky';
		}

		var numerox = document.getElementById("showRoom").getElementsByTagName("a");

		for(var i=0;i<numerox.length;i++){
			numerox[i].style.display="block";
		}

		document.getElementById("outerImgCurtain").addEventListener("touchstart",cancelarBorrado,false);
		cancelarMostrarFoto=1;
		document.getElementById("outerImgCurtain").style.display="block";
	},500)
	
}

function desactivarBorrar(x){
clearTimeout(pressTimer);
	if(cancelarMostrarFoto==0){
	desplegarFoto(x);
   }
}

function cancelarBorrado(){
	var numerox = document.getElementById("showRoom").getElementsByTagName("a");
	for(var i=0;i<numerox.length;i++){
		numerox[i].style.display="none";
	}
	var numeroImagenes = document.getElementById("showRoom").getElementsByTagName("div");
	for(var i=0;i<numeroImagenes.length;i++){
		numeroImagenes[i].className = 'cell';
	}
	document.getElementById("outerImgCurtain").style.display="none";
}


       













