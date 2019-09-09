<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Chobo painter</title>
    
 
    <style>
      canvas {
        border: 1px solid blue;
      }

      .jb_table {
        display: table;
      }

      .row {
        border-radius: 10px;
      }

      .cell {
        display: table-cell;
        vertical-align: top;
      }

      textarea {
        background-color: #fcf3cf;
      }
    </style>
  
    <script type="text/javascript">
    
    
    
    
      var textareaList = ["history"];

      function clearText(idOfTextArea) {
        document.getElementById(idOfTextArea).value = "";
      }

      function SaveAsTxt() {
        var fileName = document.getElementById("title").value;
        if (fileName.length == 0) {
          fileName = "image";
        }
        fileName += ".txt";

        var preData = 'version: V0.617a1\n';
        var postData =  preData + document.getElementById("history").value;

        var link = document.createElement("a");
        link.setAttribute("download", fileName);
        link.setAttribute(
          "href",
          "data:" +
            "application/[txt]" +
            ";charset=utf-8," +
            encodeURIComponent(postData)
        );
        link.click();
      }

      function SaveAsJson() {
        console.log("SaveAsJson");
        var fileName = document.getElementById("title").value;
        if (fileName.length == 0) {
          fileName = "imsge";
        }

        fileName += ".json";

        var preData = {'version':'V0.617a1'};
        textareaList.forEach(function(e) {
          preData[e] = document.getElementById(e).value;
        });

        var jsonData = JSON.stringify(preData);

        var link = document.createElement("a");
        var file = new Blob([jsonData], { type: "text/plain" });
        link.href = URL.createObjectURL(file);
        link.download = fileName;
        link.click();
      }

      function isJsonFile(filename) {
        var ridx = filename.lastIndexOf(".");
        var extension = filename.substring(ridx + 1);

        console.log(extension);

        if (extension.length != 4 || extension.toLowerCase() != "json") {
          return false;
        }
        return true;
      }

      function isTextFile(filename) {
        var ridx = filename.lastIndexOf(".");
        var extension = filename.substring(ridx + 1);

        console.log(extension);

        if (extension.length != 3 || extension.toLowerCase() != "txt") {
          return false;
        }
        return true;
      }


      function loadFile() {
        var loadFile = document.getElementById("load_filename");
        var file = loadFile.files[0];
          
        if (!file) {
          return;
        }

        var fileName = document.getElementById("load_filename").value;
        var ridx = fileName.lastIndexOf("\\");

        fileName = fileName.substring(ridx + 1);

        if (isJsonFile(fileName)) {
          LoadJson(file, fileName);
        } else if(isTextFile(fileName)) {
          LoadText(file, fileName);
        } 
      }

      function LoadJson(file, fileName) {
        document.getElementById("title").value = fileName;

        var reader = new FileReader();
        reader.onload = function(e) {
          var contents = e.target.result;
          displayLoadJsonData(contents);
        };
        reader.readAsText(file);
      }

      function displayLoadJsonData(contents) {
        var noteData = JSON.parse(contents);

        var version = noteData['version'];
        console.log(version);
        document.getElementById('history').value = noteData['history'];
        reDrawCanvas();
      }

      function LoadText(file, fileName) {
        document.getElementById("title").value = fileName;

        var reader = new FileReader();
        reader.onload = function(e) {
          var contents = e.target.result;
          displayLoadTextData(contents);
        };
        reader.readAsText(file);
      }

      function displayLoadTextData(contents) {
        var noteData = contents.split('\n');
        var history = "";
         
        noteData.forEach(function (e){
          if (e[0] != 'v') {
            history += e + "\n";
          }
        }); 
        document.getElementById('history').value = history;
        reDrawCanvas();
      }

    </script>
  </head>

  <body>
  <form id="form" action="edtUi">
  <input type="hidden" name="ino" value="${img.ino}" id="ino">
    <div class="jb_table">
      <div class="row">
        <span class="cell" width="82">
          <div>
            <div class="jb_table">
              <div class="row">
                <span class="cell">
                  <img src="/resources/img/edit2/red.png" onclick="selectColor('red')" />
                  <img src="/resources/img/edit2/orange.png" onclick="selectColor('orange')"/>
                </span>
              </div>
              <div class="row">
                <span class="cell">
                  <img src="/resources/img/edit2/yellow.png" onclick="selectColor('yellow')" />
                  <img src="/resources/img/edit2/green.png" onclick="selectColor('green')"/>
                </span>
              </div>
              <div class="row">
                <span class="cell">
                  <img src="/resources/img/edit2/blue.png" onclick="selectColor('blue')" />
                  <img src="/resources/img/edit2/lightblue.png" onclick="selectColor('lightblue')" />
                </span>
              </div>
              <div class="row">
                <span class="cell">
                  <img src="/resources/img/edit2/lightgreen.png" onclick="selectColor('lightgreen')"/>
                  <img src="/resources/img/edit2/brown.png" onclick="selectColor('brown')"/>
                </span>
              </div>
              <div class="row">
                <span class="cell">
                  <img src="/resources/img/edit2/purple.png" onclick="selectColor('purple')" />
                  <img src="/resources/img/edit2/pink.png" onclick="selectColor('pink')"/>
                </span>
              </div>
              <div class="row">
                <span class="cell">
                  <img src="/resources/img/edit2/gray.png" onclick="selectColor('gray')" />
                  <img src="/resources/img/edit2/lightgray.png" onclick="selectColor('lightgray')"/>
                </span>
              </div>
              <div class="row">
                <span class="cell">
                  <img src="/resources/img/edit2/black.png" onclick="selectColor('black')"/>
                  <img src="/resources/img/edit2/white.png" onclick="selectColor('white')"/>
                </span>
              </div>
              <div class="row">
                <span class="cell">
                  <img src="/resources/img/edit2/pencil.png"  onclick="selectTool('pencil')" />
                  <img src="/resources/img/edit2/line.png"  onclick="selectTool('line')" />
                </span>
              </div>
              <div class="row">
                <span class="cell">
                  <img src="/resources/img/edit2/circle.png" onclick="selectTool('circle')"/>
                  <img src="/resources/img/edit2/filledcircle.png" onclick="selectTool('filledcircle')"/>
                </span>
              </div>
              <div class="row">
                <span class="cell">
                  <img src="/resources/img/edit2/square.png" onclick="selectTool('square')"/>
                  <img src="/resources/img/edit2/filledsquare.png" onclick="selectTool('filledsquare')"/>
                </span>
              </div>
              <div class="row">
                <span class="cell">
                  <img src="/resources/img/edit2/rect.png" onclick="selectTool('rect')" />
                  <img src="/resources/img/edit2/filledrect.png" onclick="selectTool('filledrect')" />
                </span>
              </div>
              <div class="row">
                <span class="cell">
                  <img src="/resources/img/edit2/triangle.png" onclick="selectTool('tri')" />
                  <img src="/resources/img/edit2/filledtriangle.png" onclick="selectTool('filledtri')" />
                </span>
              </div>
              <div class="row">
                  <span class="cell">
                    <img src="/resources/img/edit2/undo.png" onclick="undo()"/>
                    <img src="/resources/img/edit2/redo.png" onclick="redo()"/>
                  </span>
                </div>
            </div>
          </div>
        </span>
        <span class="cell">
          <div>
            <canvas id="canvas" width="720" height="720">
            </canvas>
          </div>
        </span>
        <span class="cell">
          <INPUT type="file" id="load_filename" value="Load" onChange="loadFile()" />
          <div>Title <input id="title" size="15" /></div>
          <div>
            <a id="saveImage" download="image.png">
                <INPUT type="button" value="Save" onClick="saveImage()" />
            </a>
            <INPUT type="button" value="Clear" onClick="initPage()" />
            <INPUT type="button" value="History" onClick="showHistory()" />
          </div>
          <div>
            <input type="button" value="Save as Json" onClick="SaveAsJson()" />
            <input type="button" value="Save as Txt" onClick="SaveAsTxt()" />
          </div>
          <div>
            <textarea id="history" cols="40" rows="37" style="display: none;"></textarea>
          </div>
          <div id="command">
          </div>
              <INPUT type="button" value="Redraw" onClick="reDrawCanvas()" />
          <div>
          </div>
        </span>
      </div>
    </div>
</form>
  </body>
  
  <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
  <script type="text/javascript">

  
  $(document).ready(function(){
	  var ino = $("#ino").val();
	  alert(ino);
	  
  });
  
  
  function onLoadPage() {
 	
 	
   canvas = document.getElementById("canvas");
   cvs = canvas.getContext("2d");

   bufCanvas = document.createElement("canvas");
   bufCanvas.width = canvas.width;
   bufCanvas.height = canvas.height;
   bufCtx = bufCanvas.getContext("2d");

   canvas.addEventListener("mousedown", mouseListener);
   canvas.addEventListener("mousemove", mouseListener);
   canvas.addEventListener("mouseout", mouseListener);
   canvas.addEventListener("mouseup", mouseListener);
   
   cvs.save();
   bufCtx.save();
   img = new Image();
   
   img.src = "/edt//edtShow?ino=" +$("#ino").val();
   img.onload = function(e) {
 	  cvs.drawImage(img, 50, 50);
 	bufCtx.drawImage(img, 50, 50);
   }
   initPage();
   
 }
  </script>
     <script src="/resources/js/edit/painter.js"></script>
    <script src="/resources/js/edit/drawengine.js"></script>
</html>
