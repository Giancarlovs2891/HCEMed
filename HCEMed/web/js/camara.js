var localMediaStream, canvas, context, video, videoObj;


function activarCamara(callBack) {
  navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia;
  document.getElementById("popUpVideo").style.display = "block";

  if (navigator.getUserMedia) {
    navigator.getUserMedia(videoObj, function(stream) {              
    video.src = (navigator.webkitGetUserMedia) ? window.webkitURL.createObjectURL(stream) : stream;
    localMediaStream = stream;
  }, 
    function(error) {console.error("Video capture error: ", error.code);/*offLoader();*/});
  }

  document.getElementById("tomarFoto").setAttribute("onclick", "tomarFoto("+callBack+");");
}

function detenerCamara(){
  //offLoader();
  localMediaStream.stop();
  document.getElementById("popUpVideo").style.display = "none";
}

function tomarFoto(callBack) {
  //onLoader();
  localMediaStream.stop();

  canvas.width = video.videoWidth;
  canvas.height = video.videoHeight;
        
  context.drawImage(video, 0, 0);
        
  var fotoString = canvas.toDataURL('image/jpeg', 0.8);
  document.getElementById("popUpVideo").style.display = "none";
  //offLoader();
  callBack(fotoString);
}
function activarInput(callBack){
  document.getElementById("fotoParaSubir").setAttribute("onchange", "getPhotoMobile(event, "+callBack+", this);");
  document.getElementById("fotoParaSubir").disabled=false;
  document.getElementById('fotoParaSubir').click();
}

var deviceOrientation = "";
function getPhotoMobile(evt,callBack, esto){
  var idf = esto.getAttribute("id");
  //onLoader();
  var file = document.getElementById(idf).files[0];  // file
  fr   = new FileReader; // 

  fr.onloadend = function() {
        var exif = EXIF.readFromBinaryFile(new BinaryFile(this.result));

        deviceOrientation = exif.Orientation;

        handleFileSelect(evt, callBack, idf);
    };

fr.readAsBinaryString(file); // read the file
}

function handleFileSelect(evt, callBack, idf) {
 
  var g = document.getElementById(idf).files[0];
  var files = evt.target.files; 
 
  for (var i = 0, f; f = files[i]; i++) {
   if (!f.type.match('image.*')) {
        continue;
    }
    var reader = new FileReader();

    reader.onload = (function(theFile) {
      return function(e) {
      var myCanvas = document.getElementById('canvas');
      var ctx = myCanvas.getContext('2d');

      var img = new Image;
      img.src = e.target.result;
      img.onload = function(){
       

        if(deviceOrientation == 3){
          myCanvas.width = img.width;
          myCanvas.height = img.height;

          ctx.translate(img.width, img.height);
          ctx.rotate(180*Math.PI/180);
          ctx.drawImage(img, 0, 0);

        }else if(deviceOrientation == 6){
          myCanvas.width = img.height;
          myCanvas.height = img.width;

          ctx.translate(img.height, 0);
          ctx.rotate(90*Math.PI/180);
          ctx.drawImage(img, 0, 0);

        }else if(deviceOrientation == 8){
          myCanvas.width = img.height;
          myCanvas.height = img.width;
          ctx.translate(0, img.width);
          ctx.rotate(-90*Math.PI/180);
          ctx.drawImage(img, 0, 0);

        }else{
          myCanvas.width = img.width;
          myCanvas.height = img.height;
          ctx.drawImage(img,0, 0);
        }
  

        var fotoString = myCanvas.toDataURL('image/jpeg', 0.8);
        //offLoader();
        callBack(fotoString);
      };
     
    };
      })(f);
  
      // Read in the image file as a data URL.
      reader.readAsDataURL(f);
    
    }
  }
 

