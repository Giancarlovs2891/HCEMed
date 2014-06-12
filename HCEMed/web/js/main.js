var idPacienteSeleccionado = "NaN";
var sexoPacienteSeleccionado = "NaN";
var modoMedsio = "local";    //"local" o "central"
var supLang = ["es"];
var fechaEvolucionGeneral = '';

function changeTitle(newTitle) {
    document.getElementById("mainTitle").innerHTML = newTitle;
}
function changeSubTitle(newTitle) {
    document.getElementById("mainSubTitle").innerHTML = newTitle;
}

function changeRightBtn(text, funcion, icon) {
    if (icon == "" && text == "") {
        var boton = '<span onclick="' + funcion + '();" style="display:none;" ontouch="' + funcion + '();"><i class="icon ' + icon + '" style="display=none;"></i>' + text + '</span>';
    } else if (icon == "" && text != "") {
        var boton = '<span onclick="' + funcion + '();"ontouch="' + funcion + '();" style="background-color: #2D8AB0;"><i class="icon ' + icon + '" style="display=none;"></i>' + text + '</span>';
    } else {
        var boton = '<span onclick="' + funcion + '();" ontouch="' + funcion + '();"><i class="icon ' + icon + '"></i>' + text + '</span>';
    }

    document.getElementById("rightbtn").innerHTML = boton;
}

function changeLeftBtn(text, funcion, icon) {
    var boton = '<span onclick="' + funcion + '();" ontouch="' + funcion + '();"><i class="icon ' + icon + '" ></i>' + text + '</span>';
    document.getElementById("leftbtn").innerHTML = boton;
}
function changeRightSubBtn(text, funcion, icon) {
    var boton = '<i class="icon ' + icon + '" onclick="' + funcion + '();"></i>' + text;
    document.getElementById("rightSubbtn").innerHTML = boton;
}
function changeLeftSubBtn(text, funcion, icon) {
    var boton = '<i class="icon ' + icon + '" onclick="' + funcion + '();"></i>' + text;
    document.getElementById("leftSubbtn").innerHTML = boton;
}

var menu = "cerrado"
function toggleMenu() {
    if (menu == "abierto") {
        document.getElementById("medsioMenu").style.webkitTransform = "translate3d(-104px,0,0)";
        menu = "cerrado";
    } else {
        document.getElementById("medsioMenu").style.webkitTransform = "translate3d(0,0,0)";
        menu = "abierto";
    }
}
function activateMenu(x) {
    pararGuardadoTemporal();
    var id = x.getAttribute("id");
    if ((id != "datos_basicos") && (idPacienteSeleccionado == "NaN")) {
        return;
    }

    var lis = document.getElementById("medsioMenu").getElementsByTagName("LI");

    for (var i = 0; i < lis.length; i++) {
        lis[i].className = "";
    }

    var queryEstado = 'UPDATE estadoMedsio SET nombreModulo = "' + id + '", JSONModulo = "" WHERE idEstado = 1';
    crearSql(queryEstado, estado2);

    var li = document.getElementById(id).getElementsByTagName("LI");
    li[0].className = "selected";


    var lang = getLang();
    var dir = "modulos/" + id + "/" + lang + "/index.html";
    var dirjs = "modulos/" + id + "/" + lang + "/js/main.js";
    var dircss = "modulos/" + id + "/" + lang + "/css/main.css";



    //document.getElementById("frame").setAttribute("src",dir);

    var xhr = new XMLHttpRequest();
    xhr.open('GET', dir, true);
    xhr.onreadystatechange = function() {
        if (this.readyState !== 4)
            return;
        if (this.status !== 200)
            return; // or whatever error handling you want
        document.getElementById('medsioContent').innerHTML = this.responseText;
        loadJsFile(dirjs);
        loadCssFile(dircss);
    };
    xhr.send();
}
function activateMenuEstado(idModulo) {
    if ((id != "datos_basicos") && (idPacienteSeleccionado == "NaN")) {
        return;
    }

    var lis = document.getElementById("medsioMenu").getElementsByTagName("LI");

    for (var i = 0; i < lis.length; i++) {
        lis[i].className = "";
    }

    var id = idModulo;

    var li = document.getElementById(id).getElementsByTagName("LI");
    li[0].className = "selected";


    var lang = getLang();
    var dir = "modulos/" + id + "/" + lang + "/index.html";
    var dirjs = "modulos/" + id + "/" + lang + "/js/main.js";
    var dircss = "modulos/" + id + "/" + lang + "/css/main.css";



    //document.getElementById("frame").setAttribute("src",dir);

    var xhr = new XMLHttpRequest();
    xhr.open('GET', dir, true);
    xhr.onreadystatechange = function() {
        if (this.readyState !== 4)
            return;
        if (this.status !== 200)
            return; // or whatever error handling you want
        document.getElementById('medsioContent').innerHTML = this.responseText;
        ocument.getElementById('medsioContent').scrollTop = 0;
        loadJsFile(dirjs);
        loadCssFile(dircss);
    };
    xhr.send();
}


function getLang() {
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

    for (var i = 0; i < supLang; i++) {
        if (supLang[i] == lang) {
            isLangSupported = 1;
        }
    }

    if (isLangSupported == 0) {
        lang = "es";
    }

    return lang;
}
function getPatientId() {
    return idPacienteSeleccionado;
}
function getPatientSex() {
    return sexoPacienteSeleccionado;
}
function getModoMedsio() {
    return modoMedsio;
}
function loadJsFile(filename) {
    var fileref = document.createElement('script');
    fileref.setAttribute("type", "text/javascript");
    fileref.setAttribute("src", filename);
    document.getElementById("medsioContent").appendChild(fileref);
}
function loadCssFile(filename) {
    var fileref = document.createElement("link");
    fileref.setAttribute("rel", "stylesheet");
    fileref.setAttribute("type", "text/css");
    fileref.setAttribute("href", filename);
    document.getElementsByTagName("head")[0].appendChild(fileref);
}
function createString(id) {
    var global = document.getElementById(id);
    var string = "";

    var inputs = global.getElementsByTagName("input");
    var textareas = global.getElementsByTagName("textarea");
    var selects = global.getElementsByTagName("select");

    for (var i = 0; i < inputs.length; i++) {
        var type = inputs[i].getAttribute("type");


        if (type == "radio" || type == "checkbox") {
            if (inputs[i].checked) {
                string += inputs[i].getAttribute("name") + "=" + inputs[i].value + "&";
            }
        } else {
            string += inputs[i].getAttribute("id") + "=" + inputs[i].value + "&";
        }

    }

    for (var i = 0; i < textareas.length; i++) {
        string += textareas[i].getAttribute("id") + "=" + textareas[i].value + "&";
    }

    for (var i = 0; i < selects.length; i++) {
        var selectType = selects[i].getAttribute("multiple");

        if (selectType == "multiple") {
            for (var j = 0; j < selects[i].length; j++) {
                if (selects[i][j].selected) {
                    string += selects[i].getAttribute("id") + "=" + selects[i][j].value + "&";
                }
            }
        } else {
            string += selects[i].getAttribute("id") + "=" + selects[i].value + "&";
        }

    }
    string = string.substring(0, string.length - 1);

    return string;


}
var guardadoTemporal;
function iniciarGuardadoTemporal() {
    guardadoTemporal = window.setInterval(createJSON, 5 * 1000);
}
function pararGuardadoTemporal() {
    clearInterval(guardadoTemporal);
    var queryEstado = "UPDATE estadoMedsio SET JSONModulo = '' WHERE idEstado = 1";
    crearSql(queryEstado, estado2);
}
function cargarEstadoPrevio(nombreModulo, callBack) {
    var queryEstado = "SELECT * FROM estadoMedsio WHERE idEstado = 1";
    crearSql(queryEstado, getEstadoGuardado2);

    function getEstadoGuardado2(x) {
        var obj = JSON.parse(x);
        if (obj.length != 0) {
            if (obj[0].nombreModulo == nombreModulo) {
                callBack(obj[0].JSONModulo);
            }
        }
    }
}
function createJSON() {
    var global = document.getElementById("medsioContent");
    var string = "[{";

    var inputs = global.getElementsByTagName("input");
    var textareas = global.getElementsByTagName("textarea");
    var selects = global.getElementsByTagName("select");

    for (var i = 0; i < inputs.length; i++) {
        var type = inputs[i].getAttribute("type");


        if (type == "radio" || type == "checkbox") {
            if (inputs[i].checked) {
                string += '"' + inputs[i].getAttribute("name") + '":"' + inputs[i].value + '", ';
            }
        } else {
            string += '"' + inputs[i].getAttribute("id") + '":"' + inputs[i].value + '", ';
        }

    }

    for (var i = 0; i < textareas.length; i++) {
        string += '"' + textareas[i].getAttribute("id") + '":"' + textareas[i].value + '", ';
    }

    for (var i = 0; i < selects.length; i++) {
        var selectType = selects[i].getAttribute("multiple");

        if (selectType == "multiple") {
            for (var j = 0; j < selects[i].length; j++) {
                if (selects[i][j].selected) {
                    string += '"' + selects[i].getAttribute("id") + '":"' + selects[i][j].value + '", ';
                }
            }
        } else {
            string += '"' + selects[i].getAttribute("id") + '":"' + selects[i].value + '", ';
        }

    }
    string = string.slice(0, -2);
    string += "}]";
    string = encodeURIComponent(string);

    var queryEstado = "UPDATE estadoMedsio SET JSONModulo = '" + string + "' WHERE idEstado = 1";
    crearSql(queryEstado, estado2);
}


var galeriaPortableSw = 1;
function toggleGaleriaPortable() {
    if (galeriaPortableSw == 0) {
        document.getElementById("galeriaPortable").style.webkitTransform = "translate3d(0,0,0)";
        galeriaPortableSw = 1;
    } else {
        document.getElementById("galeriaPortable").style.webkitTransform = "translate3d(-154px,0,0)";
        galeriaPortableSw = 0;
    }
}
function isLogin() {
    if (modoMedsio == "local") {
        loginLocal();
        return;
    }
    var servicio = "Usuarios/isLogin";
    var string = "";

    ajax(servicio, string, login3);
}
function login() {
    if (modoMedsio == "central") {
        var servicio = "Usuarios/login";
        var string = "usuario=" + document.getElementById("usuario").value + "&contrasena=" + document.getElementById("contrasena").value;

        ajax(servicio, string, login2);
    } else {
        var iOSLogin = (navigator.userAgent.match(/(iPad|iPhone|iPod)/g) ? true : false);
        if (iOSLogin == "1" && !window.navigator.standalone) {
            alert("Debe instalar la aplicacion antes de ingresar el codigo, para hacer esto haga click en el boton localizado a la izquierda de la barra de navegacion y seleccione Añadir a la pantalla de inicio.");
            return;
        }

        var dir = "http://saintec.co/hcemed/services.php";
        var email = document.getElementById("usuario").value;
        var codigo = document.getElementById("contrasena").value;
        var string = "servicio=activarApp&email=" + email + "&codigo=" + codigo;

        ajax(dir, string, comprobarCodigo);
    }
}
function comprobarCodigo(x) {
    var obj = JSON.parse(x);
    if (obj[0].estado == "activo") {
        guardarTabla("Estado", "estado=activo&codigo=" + document.getElementById("contrasena").value, loginLocal);
    } else if (obj[0].estado == "usado") {
        alert("Este codigo ya ha sido utilizado");
        document.getElementById("contrasena").value = "";
    } else if (obj[0].estado == "invalido") {
        alert("Este codigo esta errado");
        document.getElementById("contrasena").value = "";
    } else if (obj[0].estado == "bloqueado") {
        alert("Este codigo ha sido bloqueado");
        document.getElementById("contrasena").value = "";
    } else {
        alert("Hubo un error, por favor intente nuevamente");
    }
}
function revisarCodigo() {
    traerTabla("Estado", "idEstado=1", revisarCodigo2);
}
function revisarCodigo2(x) {
    var obj = JSON.parse(x);

    var dir = "http://saintec.co/hcemed/services.php";
    var string = "servicio=verificarEstado&codigo=" + obj[0].codigo;

    ajax(dir, string, revisarCodigo3);
}
function revisarCodigo3(x) {
    var obj = JSON.parse(x);

    if (obj[0].estado == "bloqueado") {
        editarTabla("Estado", "estado=bloqueado&idEstado=1", revisarCodigo4);
    }
}
function revisarCodigo4(x) {
    alert("Este codigo ha sido bloqueado");
    document.getElementById("loginScreen").style.display = "block";

}
function login2(x) {
    var obj = JSON.parse(x);

    if (obj[0].Exito == "1") {
        inicioMedsio();
        document.getElementById("loginScreen").style.display = "none";
        document.getElementById("usuario").value = "";
        document.getElementById("contrasena").value = "";
    } else {
        alert("Error a ingresar, verifique sus credenciales.");
    }

}
function login3(x) {
    var obj = JSON.parse(x);

    if (obj[0].Exito == "1") {
        inicioMedsio();
        document.getElementById("loginScreen").style.display = "none";
        document.getElementById("usuario").value = "";
        document.getElementById("contrasena").value = "";
    }

}

function loginLocal() {
    traerTodoTabla("Pacientes", inicioMedsio2);
    traerTabla("Estado", "idEstado=1", loginLocal2);
}
function loginLocal2(x) {
    var obj = JSON.parse(x);
    if (obj.length == 0) {
        return;
    }
    if (obj[0].estado == "activo") {
        document.getElementById("loginScreen").style.display = "none";
        document.getElementById("usuario").value = "";
        document.getElementById("contrasena").value = "";
        cargueTemporal();
        inicioMedsio();
    } else if (obj[0].estado == "bloqueado") {
        alert("Su aplicacion ha sido bloqueada, por favor comuniquese con su proveedor");
    }
}
function logOut() {
    if (modoMedsio == "central") {
        var service = "Usuarios/logout";
        var string = "";

        ajax(service, string, logOut2);
    } else {
        return;
    }

    function logOut2(x) {
        document.getElementById("loginScreen").style.display = "block";
        document.getElementById("usuario").value = "";
        document.getElementById("contrasena").value = "";
    }
}
function fechaActual() {
    var d = new Date();
    var dia = d.getDate();
    var mes = d.getMonth() + 1;
    var anio = d.getFullYear();

    var fecha = anio + "-" + mes + "-" + dia;

    return fecha;
}

function horaActual() {
    var d = new Date();
    var hora = d.getHours();
    var minuto = d.getMinutes();
    var segundos = d.getSeconds();

    var horaReal = hora + ":" + minuto + ":" + segundos;

    return horaReal;
}

function mostrarConClase(clase) {
    $("." + clase).show();
}

function ocultarConClase(clase) {
    $("." + clase).hide();
}

function mostrar(id) {
    $("#" + id).show();
}
function ocultar(id) {
    $("#" + id).hide();
}


function inicioMedsio() {

    navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia;

    canvas = document.getElementById("canvas");
    context = canvas.getContext("2d");
    video = document.getElementById("video");
    videoObj = {video: true, audio: false};
    traerTodoTabla("Pacientes", inicioMedsio2);


}
function inicioMedsio2(x) {
    var obj = JSON.parse(x);

    var directorio = "";
    var inicial = "#";
    for (var i = 0; i < obj.length; i++) {
        var letraApellido = obj[i].apellidoPaciente.substring(0, 1);
        if (letraApellido != inicial) {
            directorio += '<li class="divider">' + letraApellido + '</li>';
            incial = letraApellido;
        }
        var foto = decodeURIComponent(obj[i].foto);
        directorio += '<li onclick="loadDatosBasicos(' + obj[i].idPaciente + ');" ontouch="loadDatosBasicos(' + obj[i].idPaciente + ');">';
        directorio += '<img src="' + foto + '" />';
        directorio += '<h1>' + obj[i].nombrePaciente + ' <span class="apellido">' + obj[i].apellidoPaciente + '</span></h1>';
        directorio += '<h2>' + obj[i].tipoIdentificacionPaciente + ': ' + obj[i].identificacionPaciente + '</h2>';
        directorio += '</li>';
    }
    document.getElementById("listaPacientes").innerHTML = directorio;
}

var estado = "vistaPacientes";
function inicio() {
    alert("Error al cargar archivo del modulo");
}
function vistaPrincipal() {
    if (estado == "vistaPrincipal") {
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

    function cambiaAVistaPrincipal(event) {
        document.getElementById("listaPacientes").style.display = "none";

        document.removeEventListener('webkitTransitionEnd', cambiaAVistaPrincipal);
    }
}

function vistaPacientes() {
    pararGuardadoTemporal();
    idPacienteSeleccionado = "NaN";
    sexoPacienteSeleccionado = "NaN";
    var queryEstado = 'DELETE FROM estadoMedsio WHERE idEstado = 1';
    crearSql(queryEstado, estado2);
    if (estado == "vistaPacientes") {
        return;
    }

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

    document.addEventListener('webkitTransitionEnd', cambiaAListaDePacientes);

    function cambiaAListaDePacientes(event) {
        document.getElementById("mainBody").style.display = "none";

        document.removeEventListener('webkitTransitionEnd', cambiaAListaDePacientes);
        inicioMedsio();
        document.getElementById("fotoMenuDatosBasicos").setAttribute("src", "modulos/datos_basicos/img/menu.png");
        document.getElementById("nombrePacienteGeneralMedsio").innerHTML = "";
        document.getElementById("alertaMedicaGeneralMedsio").innerHTML = "";
    }
}

crearDB('MEDSIO', '1.0', 'Base de Datos de Medsio', 5000000);
crearTabla('CREATE TABLE IF NOT EXISTS Estado (idEstado INTEGER PRIMARY KEY AUTOINCREMENT, estado, codigo)');
crearTabla('CREATE TABLE IF NOT EXISTS EstadoMedsio (idEstado INTEGER PRIMARY KEY AUTOINCREMENT, idPaciente INTEGER, nombreModulo, JSONModulo LONG TEXT )');
crearTabla('CREATE TABLE IF NOT EXISTS Galeria (idFoto INTEGER PRIMARY KEY AUTOINCREMENT, idPaciente INTEGER, foto LONG TEXT, fecha DATE, hora TIME)');
crearTabla('CREATE TABLE IF NOT EXISTS Pacientes (idPaciente INTEGER PRIMARY KEY AUTOINCREMENT, alertaMedica, nombrePaciente, foto, apellidoPaciente, fechaNacimientoPaciente, tipoIdentificacionPaciente, identificacionPaciente, estadoPaciente, estadoCivilPaciente, sexoPaciente, razaPaciente, ocupacionPaciente, telefonoPaciente, celularPaciente, emailPaciente, paisPaciente, departamentoPaciente, ciudadPaciente, nacionalidadPaciente, direccionPaciente, zonaResidencialPaciente, codigoPostalPaciente, estratoPaciente, companiaSeguroPaciente, tipoVinculacionPaciente, nombreRepresentante, apellidoRepresentante, tipoIdentificacionRepresentante, identificacionRepresentante, telefonoRepresentante, parentescoRepresentante, nombreEmergencia, telefonoEmergencia, parentescoEmergencia, nombreReferido, fechaCreacion, horaCreacion)');
crearTabla('CREATE TABLE IF NOT EXISTS Evolucion (idEvolucion INTEGER PRIMARY KEY AUTOINCREMENT, idPaciente INTEGER, nombreModulo, fecha DATE, hora TIME, evolucion TEXT)');
crearTabla('CREATE TABLE IF NOT EXISTS Diagnosticos (idDiagnostico INTEGER PRIMARY KEY AUTOINCREMENT, idPaciente INTEGER, nombreModulo, nombreDiagnostico, diagnostico LONG TEXT, fecha DATE, hora TIME)');

function guardarDiagnosticos(idCampoD, nombreModuloD, nombreDiagnostico) {
    if ($(idCampoD).val() != "") {
        var stringDiagnostico = "nombreModulo=" + nombreModuloD + "&nombreDiagnostico=" + nombreDiagnostico + "&diagnostico=" + $(idCampoD).val() + "&idPaciente=" + getPatientId() + "&fecha=" + fechaActual() + "&hora=" + horaActual();
        guardarTabla("Diagnosticos", stringDiagnostico, callbackDiagnostico);
    }
}

function callbackDiagnostico() {
    console.log("diagnostico guardado");
}

function buscarPaciente(x) {
    if (x.value == "") {
        traerTodoTabla("Pacientes", buscarPaciente2);

        function buscarPaciente2(x) {
            var obj = JSON.parse(x);

            var directorio = "";
            var inicial = "#";
            for (var i = 0; i < obj.length; i++) {
                var letraApellido = obj[i].apellidoPaciente.substring(0, 1);
                if (letraApellido != inicial) {
                    directorio += '<li class="divider">' + letraApellido + '</li>';
                    incial = letraApellido;
                }
                var foto = decodeURIComponent(obj[i].foto);
                directorio += '<li onclick="loadDatosBasicos(' + obj[i].idPaciente + ');" ontouch="loadDatosBasicos(' + obj[i].idPaciente + ');">';
                directorio += '<img src="' + foto + '" />';
                directorio += '<h1>' + obj[i].nombrePaciente + ' <span class="apellido">' + obj[i].apellidoPaciente + '</span></h1>';
                directorio += '<h2>' + obj[i].tipoIdentificacionPaciente + ': ' + obj[i].identificacionPaciente + '</h2>';
                directorio += '</li>';
            }
            document.getElementById("listaPacientes").innerHTML = directorio;
        }
    } else {
        var string = 'SELECT * FROM Pacientes WHERE nombrePaciente LIKE "%' + x.value + '%" OR apellidoPaciente LIKE "%' + x.value + '%" OR identificacionPaciente LIKE "%' + x.value + '%"'

        crearSql(string, buscarPacienteSuccess);

        function buscarPacienteSuccess(x) {
            var directorio = "";
            var inicial = "#";

            var obj = JSON.parse(x);

            if (obj.length == 0) {
                directorio += '<li class="divider">N</li>';
                directorio += '<li onclick="loadDatosBasicos();" ontouch="loadDatosBasicos();">';
                directorio += '<img src="modulos/datos_basicos/img/menu.png" />';
                directorio += '<h1>+ <span class="apellido">Nuevo Paciente</span></h1>';
                directorio += '<h2>El paciente no existe en Base de Datos, haga click aqui para agregar un nuevo Paciente</h2>';
                directorio += '</li>';

                document.getElementById("listaPacientes").innerHTML = directorio;
            } else {


                for (var i = 0; i < obj.length; i++) {
                    var letraApellido = obj[i].apellidoPaciente.substring(0, 1);
                    if (letraApellido != inicial) {
                        directorio += '<li class="divider">' + letraApellido + '</li>';
                        incial = letraApellido;
                    }
                    var foto = decodeURIComponent(obj[i].foto);
                    directorio += '<li onclick="loadDatosBasicos(' + obj[i].idPaciente + ');" ontouch="loadDatosBasicos(' + obj[i].idPaciente + ');">';
                    directorio += '<img src="' + foto + '" />';
                    directorio += '<h1>' + obj[i].nombrePaciente + ' <span class="apellido">' + obj[i].apellidoPaciente + '</span></h1>';
                    directorio += '<h2>' + obj[i].tipoIdentificacionPaciente + ': ' + obj[i].identificacionPaciente + '</h2>';
                    directorio += '</li>';
                }
                document.getElementById("listaPacientes").innerHTML = directorio;
            }
        }
    }
}


function loadDatosBasicos(id) {
    if (!id) {
        id = "NaN";
    }
    var queryInicialEstado = 'SELECT * FROM estadoMedsio WHERE idEstado = 1';
    crearSql(queryInicialEstado, existeEstadoInicial);
    function existeEstadoInicial(x) {
        var obj = JSON.parse(x);
        if (obj.length == 1) {
            var queryEstado = 'UPDATE estadoMedsio SET idPaciente = "' + id + '", nombreModulo = "datos_basicos" WHERE idEstado = 1';
            crearSql(queryEstado, estado2);
        } else {
            var queryEstado = 'INSERT INTO estadoMedsio (idEstado, idPaciente, nombreModulo, JSONModulo) VALUES ("1", "' + id + '", "datos_basicos", "")';
            crearSql(queryEstado, estado2);
        }
    }

    galeriaPortableSw = 1;
    fotoCarreteSw = 1;
    loadGaleriaPortable(id);
    document.getElementById("galeriaPortable").style.webkitTransform = "translate3d(0px,0,0)";


    vistaPrincipal();



    idPacienteSeleccionado = id;


    var lis = document.getElementById("medsioMenu").getElementsByTagName("LI");

    for (var i = 0; i < lis.length; i++) {
        lis[i].className = "";
    }

    var li = document.getElementById("datos_basicos").getElementsByTagName("LI");
    li[0].className = "selected";

    var lang = getLang();
    var dir = "modulos/datos_basicos/" + lang + "/index.html";
    var dirjs = "modulos/datos_basicos/" + lang + "/js/main.js";
    var dircss = "modulos/datos_basicos/" + lang + "/css/main.css";

    loadJsFile(dirjs);
    loadCssFile(dircss);


    var xhr = new XMLHttpRequest();
    xhr.open('GET', dir, true);
    xhr.onreadystatechange = function() {
        if (this.readyState !== 4)
            return;
        if (this.status !== 200)
            return; // or whatever error handling you want
        document.getElementById('medsioContent').innerHTML = this.responseText;
        document.getElementById("medsioContent").scrollTop = 0;
    };
    xhr.send();
}
function estado2(x) {
}
function loadGaleriaPortable(x) {
    if (x == "NaN") {
        return;
    }
    document.getElementById("galeriaPortable").innerHTML = "";
    if (modoMedsio == "local") {
        crearSql('SELECT * FROM Galeria WHERE idPaciente="' + x + '"', traerGaleriaSuccess);
    }
    else {
        var service = "Galeria/listar";
        var string = "idPaciente=" + x;

        ajax(service, string, traerGaleriaSuccess);
    }
}
function traerGaleriaSuccess(x) {
    var obj = JSON.parse(x);
    if (obj.length == 0) {
        return;
    }
    var html = "";
    for (var i = 0; i < obj.length; i++) {
        var foto = decodeURIComponent(obj[i].foto);
        html += '<a href="javascript:void(0);" onclick="desplegarFoto(' + obj[i].idFoto + ')"><img src="' + foto + '" /><span>' + obj[i].fecha + '</span></a>';
    }
    document.getElementById("galeriaPortable").innerHTML = html;
}

var fotoCarreteSw = 1;
function toggleFotoCarrete() {
    if (fotoCarreteSw == 0) {
        document.getElementById("fotoCarrete").style.webkitTransform = "translate3d(0,0,0)";
        fotoCarreteSw = 1;
    } else {
        document.getElementById("fotoCarrete").style.webkitTransform = "translate3d(-100%,0,0)";
        fotoCarreteSw = 0;
    }
}
var evolucionCarreteSw = 1;
function toggleEvolucionCarrete() {
    if (evolucionCarreteSw == 0) {
        document.getElementById("evolucionCarrete").style.webkitTransform = "translate3d(0,0,0)";
        evolucionCarreteSw = 1;
        document.getElementById("nuevaEvolucion").disabled = false;
        document.getElementById("evolucionCarrete").innerHTML = "";
    } else {
        document.getElementById("evolucionCarrete").style.webkitTransform = "translate3d(-100%,0,0)";
        evolucionCarreteSw = 0;
    }
}

function desplegarFoto(x) {
    traerTabla("Galeria", "idFoto=" + x, desplegarFoto2);

    function desplegarFoto2(y) {
        var obj = JSON.parse(y);

        document.getElementById("fotoCarreteContainer").innerHTML = "";
        document.getElementById("nextFotoCarrete").setAttribute("onclick", "nextFoto(" + obj[0].idFoto + ");");
        document.getElementById("previousFotoCarrete").setAttribute("onclick", "previousFoto(" + obj[0].idFoto + ");");
        var image = document.createElement('img');

        image.addEventListener('load', function() {
            var desireHeight = document.getElementById("fotoCarreteContainer").clientHeight;
            var desireWidth = document.getElementById("fotoCarreteContainer").clientWidth;
            var actualWidth = image.width;
            var actualHeight = image.height;

            var newWidth = desireWidth;
            var newHeight = (actualHeight * newWidth) / actualWidth;

            if (newHeight > desireHeight) {
                newHeight = desireHeight;
                newWidth = (actualWidth * newHeight) / actualHeight;
            }
            image.width = newWidth;
            image.height = newHeight;

            document.getElementById("fotoCarreteContainer").appendChild(image);
            var myScroll;
            myScroll = new iScroll('fotoCarreteContainer', {zoom: true, onBeforeScrollStart: null, zoomMin: 1, useTransform: true, useTransition: true});

            toggleFotoCarrete();
        });
        var foto = decodeURIComponent(obj[0].foto);
        image.src = foto;
    }
}

function nextFoto(x) {
    if (modoMedsio == "local") {
        crearSql('SELECT * FROM Galeria WHERE idPaciente="' + idPacienteSeleccionado + '" ORDER BY idFoto DESC', nextFoto2);
    } else {
        var service = "Galeria/listar";
        var string = "idPaciente=" + idPacienteSeleccionado;

        ajax(service, string, nextFoto2);
    }

    function nextFoto2(y) {
        var obj = JSON.parse(y);

        var sw = 0;
        for (var i = 0; i < obj.length; i++) {
            if (sw == 1) {
                document.getElementById("fotoCarreteContainer").innerHTML = "";
                document.getElementById("nextFotoCarrete").setAttribute("onclick", "nextFoto(" + obj[i].idFoto + ");");
                document.getElementById("previousFotoCarrete").setAttribute("onclick", "previousFoto(" + obj[i].idFoto + ");");

                var image = document.createElement('img');

                image.addEventListener('load', function() {
                    var desireHeight = document.getElementById("fotoCarreteContainer").clientHeight;
                    var desireWidth = document.getElementById("fotoCarreteContainer").clientWidth;
                    var actualWidth = image.width;
                    var actualHeight = image.height;

                    var newWidth = desireWidth;
                    var newHeight = (actualHeight * newWidth) / actualWidth;

                    if (newHeight > desireHeight) {
                        newHeight = desireHeight;
                        newWidth = (actualWidth * newHeight) / actualHeight;
                    }
                    image.width = newWidth;
                    image.height = newHeight;

                    document.getElementById("fotoCarreteContainer").appendChild(image);
                    var myScroll;
                    myScroll = new iScroll('fotoCarreteContainer', {zoom: true, onBeforeScrollStart: null, zoomMin: 1, useTransform: true, useTransition: true});
                });
                var foto = decodeURIComponent(obj[i].foto);
                image.src = foto;
                return;
            }
            if (obj[i].idFoto == x) {
                sw = 1;
            }
        }
    }
}

function previousFoto(x) {
    if (modoMedsio == "local") {
        crearSql('SELECT * FROM Galeria WHERE idPaciente="' + idPacienteSeleccionado + '" ORDER BY idFoto DESC', previousFoto2);
    } else {
        var service = "Galeria/listar";
        var string = "idPaciente=" + idPacienteSeleccionado;

        ajax(service, string, previousFoto2);
    }

    function previousFoto2(y) {
        var obj = JSON.parse(y);

        var sw = 0;
        for (var i = obj.length - 1; i >= 0; i--) {
            if (sw == 1) {
                document.getElementById("fotoCarreteContainer").innerHTML = "";
                document.getElementById("nextFotoCarrete").setAttribute("onclick", "nextFoto(" + obj[i].idFoto + ");");
                document.getElementById("previousFotoCarrete").setAttribute("onclick", "previousFoto(" + obj[i].idFoto + ");");

                var image = document.createElement('img');

                image.addEventListener('load', function() {
                    var desireHeight = document.getElementById("fotoCarreteContainer").clientHeight;
                    var desireWidth = document.getElementById("fotoCarreteContainer").clientWidth;
                    var actualWidth = image.width;
                    var actualHeight = image.height;

                    var newWidth = desireWidth;
                    var newHeight = (actualHeight * newWidth) / actualWidth;

                    if (newHeight > desireHeight) {
                        newHeight = desireHeight;
                        newWidth = (actualWidth * newHeight) / actualHeight;
                    }
                    image.width = newWidth;
                    image.height = newHeight;

                    document.getElementById("fotoCarreteContainer").appendChild(image);
                    var myScroll;
                    myScroll = new iScroll('fotoCarreteContainer', {zoom: true, onBeforeScrollStart: null, zoomMin: 1, useTransform: true, useTransition: true});
                });
                var foto = decodeURIComponent(obj[i].foto);
                image.src = foto;
                return;
            }
            if (obj[i].idFoto == x) {
                sw = 1;
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
    document.getElementById("cacheProgress").innerHTML = event.loaded + " de " + event.total;
    console.log(event.loaded + " of " + event.total + " downloaded.");
}, false);

appCache.addEventListener('cached', function(event) {
    document.getElementById("cacheMensaje").style.visibility = "hidden";
}, false);

function scrollUp() {
    document.getElementById("MedsioContent").scrollTop = 0;
}

function cargueTemporal() {
    var sql = "SELECT * FROM estadoMedsio WHERE idEstado = 1";
    crearSql(sql, cargueTemporal2);

    function cargueTemporal2(x) {
        var obj = JSON.parse(x);

        if (obj.length == 1) {
            var moduloPrevio = obj[0].nombreModulo;
            idPacienteSeleccionado = obj[0].idPaciente;
            if (obj[0].idPaciente == "NaN") {
                cargueTemporal3("NaN");
            } else {
                traerTabla("Pacientes", "idPaciente=" + idPacienteSeleccionado, cargueTemporal3);
            }

            function cargueTemporal3(y) {
                if (y == "NaN") {
                    sexoPacienteSeleccionado = "NaN";
                } else {
                    var obj2 = JSON.parse(y);
                    sexoPacienteSeleccionado = obj2[0].sexoPaciente;
                    document.getElementById("fotoMenuDatosBasicos").src = decodeURIComponent(obj2[0].foto);
                    document.getElementById("nombrePacienteGeneralMedsio").innerHTML = obj2[0].nombrePaciente + " " + obj2[0].apellidoPaciente + " - " + obj2[0].sexoPaciente.toUpperCase();
                    document.getElementById("alertaMedicaGeneralMedsio").innerHTML = obj2[0].alertaMedica;
                }

                galeriaPortableSw = 1;
                fotoCarreteSw = 1;
                loadGaleriaPortable(idPacienteSeleccionado);
                document.getElementById("galeriaPortable").style.webkitTransform = "translate3d(0px,0,0)";


                vistaPrincipal();

                var lis = document.getElementById("medsioMenu").getElementsByTagName("LI");

                for (var i = 0; i < lis.length; i++) {
                    lis[i].className = "";
                }

                var li = document.getElementById(moduloPrevio).getElementsByTagName("LI");
                li[0].className = "selected";

                var lang = getLang();
                var dir = "modulos/" + moduloPrevio + "/" + lang + "/index.html";
                var dirjs = "modulos/" + moduloPrevio + "/" + lang + "/js/main.js";
                var dircss = "modulos/" + moduloPrevio + "/" + lang + "/css/main.css";

                loadJsFile(dirjs);
                loadCssFile(dircss);

                var xhr = new XMLHttpRequest();
                xhr.open('GET', dir, true);
                xhr.onreadystatechange = function() {
                    if (this.readyState !== 4)
                        return;
                    if (this.status !== 200)
                        return; // or whatever error handling you want
                    document.getElementById('medsioContent').innerHTML = this.responseText;
                    document.getElementById("medsioContent").scrollTop = 0;
                };
                xhr.send();
            }
        }
    }
}

function ponerComas(c) {
    c = c + "";
    var result = "";
    for (var j, i = c.length - 1, j = 0; i >= 0; i--, j++) {
        result = c.charAt(i) + ((j > 0) && (j % 3 == 0) ? "," : "") + result;
    }
    return result;
}
