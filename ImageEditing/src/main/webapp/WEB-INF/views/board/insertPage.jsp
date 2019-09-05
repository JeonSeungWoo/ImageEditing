<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<link>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<section class="hero">
		
		<%@ include file="/resources/include/header.jsp"%>
		


		<div class="container">
			<form action="insert" id="form" enctype="multipart/form-data">
				<input type="hidden" name="userid" value="${login.userId}">
				
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">제목</span>
					</div>
					<input class="input" type="text" name="title">
				</div>


	            <div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">내용</span>
					</div>
					<input class="input" type="text" name="content">
				</div>
				


<div id="Form">
<div class="box bs3-primary">
<input type="file" id="file" class="upload-hidden" name="file"> 
</div>

</div>


					<a href="#" id="addBtn">
					<img style="width: 50px; height: 50px;" src="/resources/img/btn/plus.png" class="logo" alt="" titl="">
					</a>
					
					<a href="#" id="removeBtn">
					<img style="width: 50px; height: 50px;" src="/resources/img/btn/minus.png" class="logo" alt="" titl="">
					</a>
			</form>
			<button type="button" class="btn btn-outline-primary" id="insertBtn">등록</button>


		</div>
	</section>



</body>


<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
	var form = $("#form");
	var addCheck = 0;
	
	$("#insertBtn").on("click", function() {
		//이미지의 값 중 빈값이 있으면 등록 되지 않도록 구현한다.
		var Obj = document.getElementById("file").value;
		if (Obj != "") {
			form.attr("action", "insert");
			form.attr("method", "POST");
			form.submit();

		} else {
			alert("이미지를 1개 이상 등록해 주세요.");
		}
	});

	
	
	$("#addBtn").on("click",function() {
		var txt1 = '<div class="box bs3-primary">';
		var txt2 = '<input type="file" id="file" class="upload-hidden" name="file"> ';
		var txt3 = '</div>';
		
		var addHtml = txt1 + txt2 + txt3;
		$("#Form").append(addHtml);
		
	});

	$("#removeBtn").on("click", function() {
		$("#Form *").remove();
	});
</script>
</html>