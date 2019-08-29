<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form action="read" id="form">

<input type="hidden" name="bno" value="${vo.bno}">
<input type="hidden" name="page" value="${param.page}">


<table border="1">
<tr>
<td>제목</td>
<td> ${vo.title}</td>
</tr>

<tr>
<td>내용</td>
<td>${vo.content}</td>
</tr>

</table>

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
		obj.attr("action","delete").attr("method","post").submit();
	});
	
	$("#listBtn").on("click",function(){
		obj.attr("action","listPage").attr("method","get").submit();
	});
	
	
});





</script>




</html>