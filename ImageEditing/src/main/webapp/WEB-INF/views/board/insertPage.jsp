<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
.input {
	border: 3px solid;
	
}
#insertBtn{
 
}

</style>


<meta charset="EUC-KR">
<title>Insert title here</title>
</head>


<body>


<form action="insert.do" id="form">
<table border="1" align="centert" cellpadding="3" cellspacing ="8">
<tr>
<td>제목</td>
<td><input  class="input" type="text" name="title"></td>
</tr>

<tr>
<td>내용</td>
<td><input class="input" type="text" name="content"></td>
</tr>

</table>

</form>
<button type="button" id="insertBtn">등록</button>

</body>

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
var form = $("#form");

$("#insertBtn").on("click",function(){
	
	form.attr("action" , "insert.do");
	form.attr("method", "POST");
	form.submit();
});




</script>


</html>