<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/css/jquery.flipster.min.css">

<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/jquery.flipster.min.js"></script>
<style type="text/css">

img{
   width: 100%;
   height: 100%;
}

</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div id="model">
            
            
</div>
<form action="read" id="form"  enctype="multipart/form-data">

<input type="hidden" name="bno" value="${vo.bno}">
<input type="hidden" name="page" value="${param.page}">


<article id="demo-carousel" class="demo">

    <div id="carousel">
        <h2>${vo.title}</h2>
        <!--ui 밑에 개당 이름 지어줄수 있다.  -->
        <!--<ul class="flip-items"> -->
        
        <ul>
        <c:forEach items="${list}" var="list">
        <input type="hidden" name="ino" value="${list.ino}">
         <li class= "imgLi" data-value ="${list.fileName}"  onclick="editMove(${list.ino})">
         <img class="img"  style="width: 300px; height: 300px;" alt="${list.fileName}" src="/upload/showAll?bno=${vo.bno}&fileName=${list.fileName}">
         <a href="/upload/imgDelete?bno=${vo.bno}&fileName=${list.fileName}" style="z-index:1;">X</a> 
         </li>
        </c:forEach>
        
        </ul>
        
        <h2>${vo.content}</h2>
        
    </div>

<script>
/*     var carousel = $("#carousel").flipster({
        style: 'carousel',
        spacing: -0.5,
        nav: true,
        buttons:   true,
    }); */
    var carousel = $("#carousel").flipster({
	    style: 'carousel',
	    spacing: -0.5,
	    buttons:   true,
	});
</script>

</article>
	<ul>
			<li id="fileForm"></li>
			<li>
				<button type="button" id="addBtn">이미지 추가</button>
				<button type="button" id="insertBtn">이미지 등록</button>
			</li>
			
			<li>
			<h5>이미지 모듈 선택</h5>
			<input type="radio" name="imageCk" class="imageCk" value="0" checked="checked">
            <input type="radio" name="imageCk" class="imageCk" value="1" >
			</li>
		</ul>


<button type="button" id="upBtn">수정</button>
<button type="button" id="delBtn">삭제</button>
<button type="button" id="listBtn">확인</button>


</form>

</body>

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">

var obj =$("#form");

function editMove(a){
	var imgeCk = $('input[name=imageCk]:checked').val();

	
	if (imgeCk == 0) {
		 location.href = "/edt/edtUi?ino="+a; 
	}else if(imgeCk == 1 ){
		 location.href = "/edt/edtUi2?ino="+a; 
	}
	
	
/* 	
  
 */
	
	
};


$(document).ready(function(){
	
	$("#upBtn").on("click",function(){
		obj.attr("action","updatePage").attr("method","get").submit();
	});
	
	$("#delBtn").on("click",function(){
		obj.attr("action","delete").attr("method","POST").submit();
	});
	
	$("#listBtn").on("click",function(){
		obj.attr("action","/board/listPage?page=1").attr("method","get").submit();
	
	});
	
	
	var addCheck = 0;
	var addHtml = '';
	

	$("#addBtn").on("click", function() {

		addCheck++;
		
		addHtml += '<input type="file" id="file" name="file">';
		$("#fileForm").html(addHtml);
	
		
	}); 
	
	
	
	$("#insertBtn").on("click", function() {
		obj.attr("action","/upload/insertImage").attr("method","post").submit();
	});
	
	
	
 

	
/*  	$(".imgLi").on("click",function(event){
        var a = $(".imgLi").attr("data-value");
        
		alert(a);
	}); */

});





</script>




</html>