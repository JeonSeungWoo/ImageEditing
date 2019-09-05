<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<style>


#img{
   width: 100%;
   height: 100%;
}

*{
  margin:0;
  padding:0;
  box-sizing: border-box;
  font-family: 'Open Sans', sans-serif;
}

.container{
  padding: 2rem;
}
.gallery{
  width: 100%;
  max-width: 960px;
  min-height: 100vh;
  margin: 2rem auto;
  
  display: -webkit-box;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  
  -webkit-flex-wrap: wrap;
      -ms-flex-wrap: wrap;
          flex-wrap: wrap;
  
  -webkit-box-pack: center;
  -webkit-justify-content: center;
      -ms-flex-pack: center;
          justify-content: center;
}

.gallery-item{
  box-shadow: 2px 2px 8px -1px #3498DB;
  width: 300px;
  height: 300px;
  margin: 10px;
  background: #000;
  position: relative;
  cursor: pointer;
  overflow: hidden;
}

.gallery-item-image{
  position: absolute;
  width: 100%;
  height: 100%;
  background: lightblue;
  z-index:20;
  -webkit-transition:all .5s ease;
  transition: all .5s ease;
  bottom:0;
  overflow: hidden;

}

.gallery-item:hover .gallery-item-image{
  bottom: 80px;
}

.gallery-item-description{
  color:white;
  font-size: .8rem;
  width: 100%;
  height: 80px;
  padding: .5rem .8rem;
  background: #3498DB;
  position: absolute;
  bottom:0;
}


/*paging Img  */
.pagingNum{
  background:#1AAB8A;
  color:#fff;
  border:none;
  position:relative;
  padding:5px;
  cursor:pointer;
  transition:800ms ease all;
  outline:none;
}
.pagingNum:hover{
  background:#fff;
  color:#1AAB8A;
}
.pagingNum:before,.pagingNum:after{
  content:'';
  position:absolute;
  top:0;
  right:0;
  height:2px;
  width:0;
  background: #1AAB8A;
  transition:400ms ease all;
}
.pagingNum:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}
.pagingNum:hover:before,.pagingNum:hover:after{
  width:100%;
  transition:800ms ease all;
}



</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<!--검색 STA  -->
	<section class="hero">
		<%@ include file="/resources/include/header.jsp"%>
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
             
             <select id="pageSelect" name="pageSize">
                 <option value="10" ${param.pageSize == "10" ? "selected" : ""}>10</option>
                 <option value="20" ${param.pageSize == "20" ? "selected" : ""}>20</option>
                 <option value="30" ${param.pageSize == "30" ? "selected" : ""}>30</option>
                 <option value="50" ${param.pageSize == "50" ? "selected" : ""}>50</option>
                 <option value="100" ${param.pageSize == "100" ? "selected" : ""}>100</option>
             </select>
             
             <button id="inPageBtn">이미지 등록하기</button>
		</form>
		

</div>
<!--검색 End  -->


<div class="container">

 <div class="gallery">
 <c:forEach items="${list}" var="list">
  <a href="/board/read?page=${param.page}&bno=${list.bno}">
    <div class="gallery-item">
      <div class="gallery-item-image">
       
        <img id="img" alt="image" src="/upload/show?bno=${list.bno}">
       
        </div>
      <div class="gallery-item-description">
        <h3>${list.title}</h3>
        <span>${list.content}</span>
        </div>
    </div>
  </a>
  </c:forEach>
</div>
</div>

      
      
      
<p class="paging">
		<c:if test="${Paging.prev}">
			<a  class="page_btn btn_prev" href="listPage?page=${(Paging.startPage - 1)}">이전</a>
		</c:if>

		<c:forEach begin="${Paging.startPage}" end="${Paging.endPage}"   var="idx">
           
           <c:out value="${Paging.page == idx ? '':''}"/>
           <a  class="pagingNum" href="listPage?page=${idx}">${idx}</a>
          			
		</c:forEach>

		<c:if test="${Paging.next && Paging.endPage > 0}">
			<a class="page_btn btn_next" href="listPage?page=${Paging.endPage +1}">다음</a>
		</c:if>

</p>


</section>
</body>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
	$("#sBtn").on("click",function(event){
		event.preventDefault();
		$("#pageHidden").val(1);
		$("#form").submit();
	});
	
	var form = $("#form");
	
	$("#pageSelect").change(function(){
		form.attr("action","listPage").attr("method","get").submit();
	});
	
	
	$("#inPageBtn").on("click",function(){
		form.attr("action","insertPage").attr("method","get").submit();
	});

	
});


</script>



</html>






