var dirGeneral = "";

function ajax(service, string, callback)
{
    var dir = dirGeneral+service;

    var xmlhttp;
    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }
    else
    {// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            var respuesta = xmlhttp.responseText;
            callback(respuesta);
            //offLoader();
        }
    }
	
    xmlhttp.open("POST", dir ,true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded; charset=utf-8");
    xmlhttp.send(string);
}

