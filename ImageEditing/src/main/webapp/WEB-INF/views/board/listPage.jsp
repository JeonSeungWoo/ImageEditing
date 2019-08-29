<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<div align="center">
		<form action="listPage" method="get" id="form">
			<input id="pageHidden" type="hidden" name="page" value="${param.page}"> 
				<select id="sType" name="sType">
				<option value="null" ${param.sType == "null" ? "selected" : ""}>--</option>
				<option value="title" ${param.sType == "title" ? "selected" : ""}>제목</option>
				<option value="content" ${param.sType == "content" ? "selected" : ""}>내용</option>
				<option value="userid" ${param.sType == "userid" ? "selected" : ""}>유저</option>
			</select>
             <input type="text" name="keyword" id="keyword" value="${param.keyword}">
             <button id="sBtn">검색 </button>
		</form>

</div>
       <table>
         <c:forEach items="${list}" var="list">
         <tr>
         <td><a href="/board/read?bno=${list.bno}&page=${param.page}">${list.bno}</a></td>
         <td>${list.title}</td>
         <td>${list.content}</td>
         <td>${list.userid}</td>
         </tr>
         </c:forEach>



      </table>
<div class="text-center">
	<ul class="pagination">

		<c:if test="${Paging.prev}">
			<a href="listPage?page=${(Paging.startPage - 1)}">이전</a>
		</c:if>

		<c:forEach begin="${Paging.startPage}" end="${Paging.endPage}"   var="idx">
           <h1>
           <c:out value="${Paging.page == idx ? '':''}"/>
           <a href="listPage?page=${idx}">${idx}</a>
           
           </h1>   				
		</c:forEach>

		<c:if test="${Paging.next && Paging.endPage > 0}">
			<h1>
			<a href="listPage?page=${Paging.endPage +1}">다음</a>
			</h1>
		</c:if>

	</ul>
</div>



</body>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
	$("#sBtn").on("click",function(event){
		event.preventDefault();
		$("#pageHidden").val(1);
		$("#form").submit();
	});
	
});


</script>



</html>






