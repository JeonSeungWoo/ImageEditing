<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login" id="form">
<table>
<tr>
<th>ID : </th>
<td><input type="text" name="userId"></td>

</tr>

<tr>
<th>PW : </th>
<td><input type="password" name="userPw"></td>
</tr>



</table>

<button type="button" id="loginBtn">로그인</button>
<button type="button" id="insertBtn">회원 가입</button>
<button type="button" id="homeBtn">home</button>

</form>



</body>


<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var obj =$("#form");
	
	$("#loginBtn").on("click",function(){
		obj.attr("action","loginProcess").attr("method","post").submit();
	});
	
	$("#insertBtn").on("click",function(){
		window.location.href = "/user/loginCreatePage";
	});
	 
	$("#homeBtn").on("click",function(){
		window.location.href = "/";
	});
	
	
});





</script>





</html>