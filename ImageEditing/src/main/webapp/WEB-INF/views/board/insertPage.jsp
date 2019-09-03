<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.1.2/css/material-design-iconic-font.min.css">
    

<style>
@import url(https://fonts.googleapis.com/css?family=Roboto:400,500);
#img{
   width: 100%;
   height: 100%;
}
body {
  background: #B4B4DC;
}

h1 {
  font-family: 'Roboto', sans-serif;
  font-weight: 500;
  font-size: 32px;
  color: #212121;
  padding: 50px;
  text-align: center;
  line-height: 135%;
}

.menu-button {
  -webkit-transition: 0.4s;
  -moz-transition: 0.4s;
  transition: 0.4s;
  position: absolute;
  right: 30px;
  bottom: 30px;
  width: 60px;
  height: 60px;
  text-align: center;
  line-height: 60px;
  border-radius: 50%;
  background-color: #E91E63;
  color: #FFFFFF;
  font-size: 24px;
  box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.26), 0 2px 10px 0 rgba(0, 0, 0, 0.22);
  cursor: pointer;
}
.menu-button:hover {
  background: #d81557;
  box-shadow: 0 5px 11px 0 rgba(0, 0, 0, 0.28), 0 4px 15px 0 rgba(0, 0, 0, 0.25);
}
.menu-button a {
  -webkit-transition: 0.4s;
  -moz-transition: 0.4s;
  transition: 0.4s;
  opacity: 0;
  width: 0px;
  height: 0px;
  text-align: center;
  line-height: 50px;
  border-radius: 50%;
  color: #FFFFFF;
  font-size: 24px;
  box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.26), 0 2px 10px 0 rgba(0, 0, 0, 0.22);
  cursor: pointer;
}
.menu-button a:hover {
  box-shadow: 0 5px 11px 0 rgba(0, 0, 0, 0.28), 0 4px 15px 0 rgba(0, 0, 0, 0.25);
}
.menu-button a:nth-child(2) {
  -webkit-transition-delay: 0.3s;
  -moz-transition-delay: 0.3s;
  transition-delay: 0.3s;
  position: absolute;
  right: 30px;
  bottom: 30px;
  background: #55acee;
}
.menu-button a:nth-child(3) {
  -webkit-transition-delay: 0.4s;
  -moz-transition-delay: 0.4s;
  transition-delay: 0.4s;
  position: absolute;
  right: 30px;
  bottom: 30px;
  background: #dc4e41;
}
.menu-button a:nth-child(4) {
  -webkit-transition-delay: 0.5s;
  -moz-transition-delay: 0.5s;
  transition-delay: 0.5s;
  position: absolute;
  right: 30px;
  bottom: 30px;
  background: #3F3F3F;
}
.menu-button:hover a {
  opacity: 1;
  width: 50px;
  height: 50px;
}
.menu-button:hover a:nth-child(2) {
  right: 80px;
  bottom: 0px;
}
.menu-button:hover a:nth-child(2):hover {
  -webkit-transition-delay: 0s;
  -moz-transition-delay: 0s;
  transition-delay: 0s;
  background: #3ea1ec;
}
.menu-button:hover a:nth-child(3) {
  right: 65px;
  bottom: 65px;
}
.menu-button:hover a:nth-child(3):hover {
  -webkit-transition-delay: 0s;
  -moz-transition-delay: 0s;
  transition-delay: 0s;
  background: #d83a2b;
}
.menu-button:hover a:nth-child(4) {
  right: 0px;
  bottom: 80px;
}
.menu-button:hover a:nth-child(4):hover {
  -webkit-transition-delay: 0s;
  -moz-transition-delay: 0s;
  transition-delay: 0s;
  background: #323232;
}

</style>

<meta http-equiv="Content-Type" content = "text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<body>


	<form action="insert" id="form" enctype="multipart/form-data">
		<table border="1" align="centert" cellpadding="3" cellspacing="8">
			<tr>
				<td>제목</td>
				<td><input class="input" type="text" name="title"></td>
			</tr>

			<tr>
				<td>내용</td>
				<td><input class="input" type="text" name="content"></td>
			</tr>
	  
		</table>

		<ul>
			<li id="fileForm"></li>
			<li>
				<button type="button" id="addBtn">추가</button>
				
			</li>
		</ul>

	</form>
	<button type="button" id="insertBtn">등록</button>
	<button type="button" id="homeBtn">홈</button>

<!--하단 박스 추가 start  -->
<div class="menu-button"><i class="zmdi zmdi-share"></i>
	
	<a href="/"><img alt="home" src="resources/img/home.jpg"></a>
	<a href="/user/logout"><img alt="resources/img/logout.png" src=""></a>
	<!-- <a href="#" target="blank"></a> -->
</div>
<!--하단 박스 추가 end  -->

</body>

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
	var form = $("#form");

	$("#insertBtn").on("click", function() {

		form.attr("action", "insert");
		form.attr("method", "POST");
		form.submit();
	});

	var addCheck = 0;
	var addHtml = '';
	

	$("#addBtn").on("click", function() {

		addCheck++;
		
		addHtml += '<input type="file" id="file" name="file">';
		$("#fileForm").html(addHtml);
	
		
	}); 

	// 이미지 여러개 생성.

	
	$("#homeBtn").on("click",function(){
		obj.attr("action","/").attr("method","get").submit();
	});
	
	
	</script>


</html>