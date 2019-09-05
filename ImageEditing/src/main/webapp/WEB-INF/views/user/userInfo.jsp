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
		
			<form action="userUpdate" id="form" enctype="multipart/form-data">
				<input type="hidden" name="userId" value="${login.userId}">

				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">이름</span>
					</div>
					<input class="input" type="text" name="userName" value="${info.userName}">
				</div>


				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">PW</span>
					</div>
					<input class="input" type="text" name="userPw"  value="${info.userPw}">
				</div>

			
                 <button type="button" class="btn btn-outline-primary" id="updateBtn">변경</button>

			</form>
			


		</div>
	</section>



</body>


<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
	var form = $("#form");
	
	$("#updateBtn").on("click",function(){
		form.attr("action","/user/userUpdate").attr("method","POST").submit();
	});
	
	
	
	
	
</script>



</html>


