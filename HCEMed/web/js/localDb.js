var db;
function crearDB(nombreDB, version, descripcion, tamano) {
    db = window.openDatabase(nombreDB, version, descripcion, tamano);

    //Ej: crearDB('MEeeDSIO', '1.0', 'Base de Datos de Medsio', 50000000);
}

function crearTabla(query) {
    db.transaction(crearTabla2);

    function crearTabla2(tx) {
        tx.executeSql(query);
    }

    //Ej: crearTabla('CREATE TABLE IF NOT EXISTS Pacientes (idPaciente INTEGER PRIMARY KEY AUTOINCREMENT, nombrePaciente, apellidoPaciente)');
}

function guardarTabla(nombreTabla, string, callback) {
    if(modoMedsio == "central"){
        var x = nombreTabla.split(" ");
        nombreTabla = x[0];
        var servicio = nombreTabla+"/guardar";
        
        ajax(servicio, string, callback);
    }else{
        db.transaction(guardarTabla2);

        function guardarTabla2(tx) {
            var object = string.split("&");
            var columna = new Array();
            var valor = new Array();

            for (var i = 0; i < object.length; i++) {
                var info = object[i].split("=");
                columna[i] = info[0];
                valor[i] = info[1];
            }
            var query = "INSERT INTO " + nombreTabla + " (";
            for (var i = 0; i < columna.length; i++) {
                query += columna[i];
                if (i != columna.length - 1) {
                    query += ", "
                }
            }
            query += ") VALUES (";
            for (var i = 0; i < valor.length; i++) {
                query += "'" + valor[i] + "'";
                if (i != valor.length - 1) {
                    query += ", "
                }
            }
            query += ");";
            tx.executeSql(query, [], guardarTablaSuccess, error);

            function guardarTablaSuccess() {
                callback("Exito");
            }
        }
    }
}

function editarTabla(nombreTabla, string, callback) {
    if(modoMedsio == "central"){
        var x = nombreTabla.split(" ");
        nombreTabla = x[0];
        var servicio = nombreTabla+"/editar";
        
        ajax(servicio, string, callback);
    }else{
        db.transaction(editarTabla2);

        function editarTabla2(tx) {
            var object = string.split("&");
            var columna = new Array();
            var valor = new Array();

            for (var i = 0; i < object.length; i++) {
                var info = object[i].split("=");
                columna[i] = info[0];
                if (!info[1]) {
                    valor[i] = info[1] = "";
                } else {
                    valor[i] = info[1];
                }
            }
            var query = "UPDATE " + nombreTabla + " SET ";

            for (var i = 0; i < columna.length; i++) {
                if (i != columna.length - 1) {
                    query += columna[i] + " = '" + valor[i] + "'";
                    if (i != columna.length - 2) {
                        query += ", "
                    }
                } else {
                    query += " WHERE " + columna[i] + " = " + valor[i];
                }
            }

            query += ";";

            tx.executeSql(query, [], editarTablaSuccess, error);

            function editarTablaSuccess() {
                callback("Exito");
            }

        }
    }
}

function borrarTabla(nombreTabla, string, callback) {
    if(modoMedsio == "central"){
        var x = nombreTabla.split(" ");
        nombreTabla = x[0];
        var servicio = nombreTabla+"/borrar";
        
        ajax(servicio, string, callback);
    }else{
        db.transaction(borrarTabla2);

        function borrarTabla2(tx) {
            var object = string.split("&");
            var columna = new Array();
            var valor = new Array();

            for (var i = 0; i < object.length; i++) {
                var info = object[i].split("=");
                columna[i] = info[0];
                valor[i] = info[1];
            }

            var query = "DELETE FROM " + nombreTabla + " WHERE " + columna[0] + " = " + valor[0] + ";";

            tx.executeSql(query, [], borrarTablaSuccess, error);

            function borrarTablaSuccess() {
                callback("Exito");
            }

        }
    }
}

function traerTabla(nombreTabla, string, callback) {
    if(modoMedsio == "central"){
        var x = nombreTabla.split(" ");
        nombreTabla = x[0];
        var servicio = nombreTabla+"/traer";
        
        ajax(servicio, string, callback);
    }else{
        db.transaction(traerTabla2);

        function traerTabla2(tx) {
            var object = string.split("&");
            var columna = new Array();
            var valor = new Array();

            for (var i = 0; i < object.length; i++) {
                var info = object[i].split("=");
                columna[i] = info[0];
                valor[i] = info[1];
            }

            var query = 'SELECT * FROM ' + nombreTabla + ' WHERE ' + columna[0] + ' = ' + valor[0] + ';';

            tx.executeSql(query, [], traerTablaSuccess, error);

            function traerTablaSuccess(tx, resultado) {
                var len = resultado.rows.length;

                var json = "[";

                for (var i = 0; i < len; i++) {
                    json += '{ ';

                    var result = resultado.rows.item(i);

                    for (var column in result) {
                        json += '"' + column + '" : "' + result[column] + '" , ';
                    }

                    json = json.substring(0, json.length - 2);
                    json += ' },';
                }
                json = json.substring(0, json.length - 1);
                json += "]";

                if (json == "]") {
                    json = "[]";
                }
                callback(json);
            }
        }
    }
}

function traerTodoTabla(nombreTabla, callback) {
    if(modoMedsio == "central"){
        var x = nombreTabla.split(" ");
        nombreTabla = x[0];
        var servicio = nombreTabla+"/listar";
        var string="";
        
        ajax(servicio, string, callback);
    }else{
        db.transaction(traerTodoTabla2);

        function traerTodoTabla2(tx) {

            var query = 'SELECT * FROM ' + nombreTabla + ';';

            tx.executeSql(query, [], traerTodoSuccess, error);

            function traerTodoSuccess(tx, resultado) {
                var len = resultado.rows.length;

                var json = "[";

                for (var i = 0; i < len; i++) {
                    json += '{ ';

                    var result = resultado.rows.item(i);

                    for (var column in result) {
                        json += '"' + column + '" : "' + result[column] + '" , ';
                    }

                    json = json.substring(0, json.length - 2);
                    json += ' },';
                }
                json = json.substring(0, json.length - 1);
                json += "]";
                if (json == "]") {
                    json = "[]";
                }
                callback(json);
            }
        }
    }
}
function error(err) {
    alert("Error en localDB"+err.code);
}
function crearSql(query, callback) {
    db.transaction(crearSql2);

    function crearSql2(tx) {
        tx.executeSql(query, [], crearSqlSuccess, error);

        function crearSqlSuccess(tx, resultado) {
            var len = resultado.rows.length;

            var json = "[";

            for (var i = 0; i < len; i++) {
                json += '{ ';

                var result = resultado.rows.item(i);

                for (var column in result) {
                    json += '"' + column + '" : "' + result[column] + '" , ';
                }

                json = json.substring(0, json.length - 2);
                json += ' },';
            }
            json = json.substring(0, json.length - 1);
            json += "]";
            if (json == "]") {
                json = "[]";
            }
            callback(json);
        }
    }
}
