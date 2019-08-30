<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">



<title>Insert title here</title>
</head>
<body>

<form id="form">
<table>
<caption>회원가입</caption>
<tr>
<th>이름</th>
<td><input type="text" id="name" name="name" class="wdp_90"></td>
</tr>
<tr>
<th>아이디</th>
<td><input type="text" id="id" name="id" class="wdp_90"></td>
<td><a href="#" id="checkBtn" class="btn">중복확인</a></td>
</tr><tr>
<th>비밀번호</th>
<td><input type="password" id="pw" name="pw" class="wdp_90"></td>
</tr>

<tr>
<td>
<a href="#" class="btn" id="signUpBtn">회원가입</a>
<a href="#" class="btn" id="homrBtn">취소</a>
</td>
</tr>



</table>

</form>
</body>
</html>