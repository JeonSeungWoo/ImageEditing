<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginConfirm</title>

<style type="text/css">
	body {
	  background-color: black;
	  color: #55ff55;
	  font-family: monospace;
	  font-size:26px;
	}
	.output {
	display:none;
	}
	.active:after {
	  content: '_';
	}

</style>


</head>
<body>

<form action="loginConfirm" id="form">
<input type="hidden" name="check" id="check" value="${param.check}">


<div class="prompt">
   <c:if test="${param.check == 1 }">
       
       <p>로그인에 </p>
       <p>성공하셨습니다 </p>
       
   </c:if>
    
    
    <c:if test="${param.check == 0 }">
 
       <p>로그인에 </p>
       <p>실패하셨습니다 </p>
       
    </c:if>
 </div>
 
 
</form>

</body>

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
var $lines = $('.prompt p');
$lines.hide();
var lineContents = new Array();

var terminal = function() {

  var skip = 0;
  typeLine = function(idx) {
    idx == null && (idx = 0);
    var element = $lines.eq(idx);
    var content = lineContents[idx];
    if(typeof content == "undefined") {
      $('.skip').hide();
      return;
    }
    var charIdx = 0;

    var typeChar = function() {
      var rand = Math.round(Math.random() * 150) + 25;

      setTimeout(function() {
        var a = content[charIdx++];
        element.append(a);
        if(typeof a !== "undefined")
          typeChar();
        else {
          element.append('<br/><span class="output">' + element.text().slice(9, -1) + '</span>');
          element.removeClass('active');
          typeLine(++idx);
        }
      }, skip ? 0 : rand);
    }
    content = '' + content + '';
    element.append(' ').addClass('active');
    typeChar();
  }

  $lines.each(function(i) {
    lineContents[i] = $(this).text();
    $(this).text('').show();
  });

  typeLine();
}

terminal();


$(document).ready(function(){
	//변수선언
	var obj =$("#form");
	var check = $("#check").val();
	
	//check
	if(check == '1'){
		var move = '/';
		time(move);
		
		
	}else if(check == 0){
		var move = '/user/login';
		time(move);
	}
	
	//time 설정.
	function time(move){
		setTimeout(function() {
			window.location.href = move
			}, 4000);

	};


});

</script>


</html>