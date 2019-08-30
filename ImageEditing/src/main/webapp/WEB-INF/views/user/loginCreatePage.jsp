<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginCreatePage</title>

</head>
<body>
<form action="loginCreatePage" id="form">
<table>

<tr>
<th>이름 : </th>
<td><input type="text" name="userNm" id="userNm"></td>
</tr>


<tr>
<th>ID : </th>
<td><input type="text" name="userId" id="userId"> 
<input type="button" value="Id체크"  id="checkId">
<span id="idCk"></span>
</td>



</tr>

<tr>
<th>PW : </th>
<td><input type="text" name="userPw" id="userPw"></td>
</tr> 



</table>

<button type="button" id="insertBtn">등록</button>
<button type="button" id="homeBtn">홈</button>

</form>


<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">



$(document).ready(function(){
	
	var obj =$("#form");
	// 입력값 설정
	var checkedId = false;
	
    //등록 버튼 
	 $("#insertBtn").on("click",function(event){
		
		 var userNm  = $("#userNm").val(); 
	     var userId  = $("#userId").val(); 
		 var userPw  = $("#userPw").val(); 
		 
		 
		if(userNm == "" || userId == ""  || userPw == ""){
			alert("데이터를 입력해주세요/");
	    }else{
	    	if(checkedId == true){
	    		alert("회원가입 되었습니다.");
	    		obj.attr("action","loginCreate").attr("method","POST").submit();
	    		return true;
	    	}else{
	    		alert("아이디를 체크를 확인해 주세요!!!!");
	    		return false;
	    	}
	    	
	    }

	}); 
	 
	 
	//홈 버튼  
	$("#homeBtn").on("click",function(){
		obj.attr("action","/").attr("method","get").submit();
	});
	
	
	//
	
	
	
	 //id check 
	 $("#checkId").on("click",function(){
		var userId  = $("#userId").val(); 
		
		$.ajax({
			type : "POST",
			url : "/user/checkId",
			data : {"userId" :  userId},
			
			success : function(data){
				if($.trim(data) == 0){
					$("#idCk").html('<b style ="font-size:18xp; color:blue">사용가능</b>');
					checkedId = true;
				}else{
					$("#idCk").html('<b style ="font-size:18xp; color:red">사용불가</b>');
					checkedId = false;
				}
			}
			
			
		});
		 return false;
		 
	 });
	 
	 
	 
	 
	
});
</script>



</body>
</html>