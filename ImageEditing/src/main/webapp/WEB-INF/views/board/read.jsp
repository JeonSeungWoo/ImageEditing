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

<form action="read" id="form">

<input type="hidden" name="bno" value="${vo.bno}">
<input type="hidden" name="page" value="${param.page}">



<article id="demo-carousel" class="demo">

    <div id="carousel">
        <h2>${vo.title}</h2>
        <!--ui 밑에 개당 이름 지어줄수 있다.  -->
        <!--<ul class="flip-items"> -->
        <ul>
        <c:forEach items="${list}" var="list">
        <li>
         <img style="width: 50%; height: 50%;"  alt="image" src="/upload/showAll?bno=${vo.bno}&fileName=${list.fileName}">
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



<button type="button" id="upBtn">수정</button>
<button type="button" id="delBtn">삭제</button>
<button type="button" id="listBtn">목록</button>


</form>

</body>

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var obj =$("#form");
	$("#upBtn").on("click",function(){
		obj.attr("action","updatePage").attr("method","get").submit();
	});
	
	$("#delBtn").on("click",function(){
		obj.attr("action","delete").attr("method","POST").submit();
	});
	
	$("#listBtn").on("click",function(){
		obj.attr("action","listPage").attr("method","get").submit();
	});
	
	
});





</script>




</html>