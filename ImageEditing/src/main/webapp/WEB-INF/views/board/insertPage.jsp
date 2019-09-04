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


</style>

<meta http-equiv="Content-Type" content = "text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<body>


	<form action="insert" id="form" enctype="multipart/form-data">
	<input type="hidden" name="userid" value="${login.userId}">
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
		
		    <li><input type="file" id="file" class="file"  name="file"></li>
			<li id="fileForm">
			</li>
			<li>
			
				<button type="button" id="addBtn">추가</button>
				<button type="button" id="removeBtn">초기화</button>
			</li>
		</ul>

	</form>
	<button type="button" id="insertBtn">등록</button>


</body>

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
	var form = $("#form");

	var addCheck = 0;
	
	var imageCheck = 0;
	
	
	
	$("#insertBtn").on("click", function() {
      //이미지의 값 중 빈값이 있으면 등록 되지 않도록 구현한다.	
        var fileObj = document.getElementById("file").value;
      
         if(fileObj != ""){
        	 form.attr("action", "insert");
      		 form.attr("method", "POST");
      		 form.submit();
        	 
         }else{
        	 alert("이미지를 1개 이상 등록해 주세요.");
         }
         
        
        
        
        
        
        
      
      

		
	});


	

	$("#addBtn").on("click", function() {
		++addCheck;
		var addHtml = '<li id="liFile'+addCheck+'" ><input type="file" id="file" class="file"  name="file"></li>';
		$("#fileForm").append(addHtml);
	}); 
	
	
	$("#removeBtn").on("click",function(){
		$("#fileForm *").remove();
	});


	// 이미지 여러개 생성.

	
	
	
	</script>


</html>