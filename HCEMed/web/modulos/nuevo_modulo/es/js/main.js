
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
//function start(){
//	loadCssFile("modulos/nuevo_modulo/es/css/main.css");
//	loadJsFile("modulos/nuevo_modulo/es/js/main.js");
//	alert("Lean con Atencion lo que dice ahi");
//}


















