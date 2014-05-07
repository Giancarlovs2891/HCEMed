// Funciones Generales
//FUNCION BOTON Esta funcion determina que funcion va a llamar el boton de edicion y que palabra debe decir el boton, ya sea Guardar o Editar
//La manera correcta de llamarlo es funcionBoton("Guardar",guardarDatos); SOLO EL NOMBRE ENTRE COMILLAS
function funcionBoton(nombre,funcion){
	mostrarBoton();
	var boton = document.getElementById('cambiosBoton');
	boton.innerHTML = nombre;
	boton.onclick=funcion;
}
//FUNCION DEFINIR BOTON Es la misma funcion de funcionBoton. Se recomienda usar funcionBoton en vez de definirBoton
function definirBoton(x, y){
document.getElementById("cambiosBoton").setAttribute( "onClick", x );
document.getElementById("cambiosBoton").innerHTML=y;
}

//MOSTRAR BOTON Esta funcion decide si debe mostrar el boton de Edicion, Recibe un parametro : 1 si se desea mostrar y 0 si no se desea mostrar. Si no se pone ningun parametro
//el asigna 1 y muestra el boton. La forma correcta de llamarla es mostrarBoton(1); o mostrarBoton();
function mostrarBoton(bol){
	var boton = document.getElementById('cambiosBoton');
	if(typeof bol == "undefined"){bol = 1;}

	if(bol == 1){
		boton.style.display="block";
	}else{
		boton.style.display="none";
	}
}
//ACTIVAR GALERIA Esta funcion muestra la pestaña de la galeria portable. La forma correcta de llamarla es activarGaleria();
function activarGaleria(){
	document.getElementById("galeriaPortable").style.right="-134px";
	document.getElementById("pestanaGaleriaPortable").style.backgroundImage="url('images/pestanaAbrirGaleriaPortable.png')";
	document.getElementById("galeriaPortableCurtain").style.display="none";
	db.transaction(listarGaleriaPorPaciente);
}
//DESACTIVAR GALERIA Esta funcion muestra la pestaña de la galeria portable. La forma correcta de llamarla es desactivarGaleria();
function desactivarGaleria(){
	document.getElementById("galeriaPortable").style.right="-206px";
	document.getElementById("pestanaGaleriaPortable").style.backgroundImage="url('images/pestanaAbrirGaleriaPortable.png')";
	document.getElementById("galeriaPortableCurtain").style.display="none";
}
//USUARIO ACTIVO Esta funcion determina si hay un paciente elegido. La forma correcta de llamarla es var x= usuarioActivo(); Y la var x tiene 0 si no esa activo y 1 si esta activo
function usuarioActivo(){
	var id = document.getElementById("idPaciente").value;
	
	if(id == ""){
		return 0;
	}else{
		return 1;
	}
}
//GET RADIO VALUE Determina cual es el valor que esta seleccionado en un boton tipo Radio. La forma correcta de llamarla es var x= getRadioValue("anemia");
function getRadioValue(z){
	var x = document.getElementsByName(z);
  	for(var i=0;i<x.length;i++){
   		 if (x[i].checked) {
     		 return x[i].value;
    	}
  	}
}

//FALTA Hay Datos

function traerFoto(id, funcion) {
                var selectedFile = document.getElementById(id).files[0];
                var reader = new FileReader();

                reader.onload = function(event) {
                    var imagen = event.target.result;
                    funcion(imagen);
                };
                reader.readAsDataURL(selectedFile);
            }

