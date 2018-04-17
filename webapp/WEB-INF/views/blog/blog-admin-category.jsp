<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script src="${pageContext.servletContext.contextPath}/assets/js/jquery/jquery-1.9.0.js" type="text/javascript"></script>
<script>
$(function(){
	
	$.urlParam = function(name){
	    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
	    if (results==null){
	       return null;
	    }
	    else{
	       return results[1] || 0;
	    }
	}

	$('input[type=submit]').on('click', function(){
		
		var name = $('input[name=name]').val();
		var content = $('input[name=content]').val();
		var blogNo = $('input[name=blogNo]').val();
		var allData = {"name" : name, "content" : content, "blogNo" : blogNo};
		var size = $('#admin-cat').find('tr').length;
		
		$.ajax({
            type : "POST",
            url : "${pageContext.servletContext.contextPath}/${id}/admin/category/insert",
            data : allData,
            error : function(){
                alert('통신실패!!');
            },
            success : function(data){
            	$('#admin-cat').append(
            			'<tr>' +
							'<td><input type="hidden" name="no" value="'+ data.vo.no +'"/>' + size +'</td>' +
							'<td>' + data.vo.name + '</td>' +
							'<td> 0 </td>' +
							'<td>' + data.vo.content + '</td>' +
							'<td><img class="delete" src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>' +
						'</tr>'
				); 
                
                $('input[name=name]').val('');
                $('input[name=content]').val('');
              /*   $('#admin-cat').load('${pageContext.servletContext.contextPath}/${id}/admin/category?page=${param.page} #admin-cat'); */
            }
             
        });
		
	});
	
	$(document).on('click', '.delete', function(){
		var target = $(this).parent().parent();
		var no = $(this).parent().parent().children().first().find('input[name=no]').val();
		var allData = {"no" : no};
		$.ajax({
            type : "POST",
            url : "${pageContext.servletContext.contextPath}/${id}/admin/category/delete",
            data : allData,
            error : function(){
                alert('통신실패!!');
            },
            success : function(data){
               target.remove();
            }
             
        });
	});
	
}); 
</script>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"/>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<c:import url="/WEB-INF/views/includes/admin-menu.jsp">
					<c:param name="admin-menu" value="category"/>
				</c:import>
				<input type="hidden" name="blogNo" value="${blog.no}"/> 
		      	<table id="admin-cat" class="admin-cat">
		      		<tr>
		      			<th>번호</th>
		      			<th>카테고리명</th>
		      			<th>포스트 수</th>
		      			<th>설명</th>
		      			<th>삭제</th>      			
		      		</tr>
		      		<c:forEach items="${list}" var="vo" varStatus="status">
			      		<tr>
							<td><input type="hidden" name="no" value="${vo.no}"/>${vo.rowNum}</td>
							<td>${vo.name}</td>
							<td>${vo.postCount}</td>
							<td>${vo.content}</td>
							<td>
								<img class="delete" src="${pageContext.request.contextPath}/assets/images/delete.jpg">
							</td>
						</tr>
		      		</c:forEach>
				</table>
      			
      <%-- 			<div class="pager">
					<ul>
						<c:if test="${pager.leftArrow eq true}">
							<li><a href="${pageContext.servletContext.contextPath}/${id}/admin/category?page=${pager.startPage - 1}">◀</a></li>
						</c:if>
						
						<c:forEach begin="${pager.startPage}" end="${pager.endPage}" varStatus="status">
							<li>
								<c:if test="${param.page == status.index}">	
									<a style="color:red;" href="${pageContext.servletContext.contextPath}/${id}/admin/category?page=${status.index}">${status.index}</a>
								</c:if>
									
								<c:if test="${param.page != status.index}">
									<a href="${pageContext.servletContext.contextPath}/${id}/admin/category?page=${status.index}">${status.index}</a>
								</c:if>
							</li>
						</c:forEach>
						
						<c:forEach begin ="${pager.endPage + 1}" end = '5'  varStatus="status">
							<li style="color:gray;">${status.index}</li>
						</c:forEach>
						
						<c:if test="${pager.rightArrow eq true}">
							<li><a href="${pageContext.servletContext.contextPath}/${id}/admin/category?page=${pager.endPage + 1}">▶</a></li>
						</c:if>
					</ul>
				</div> --%>
      			
      			
      			<h4 class="n-c">새로운 카테고리 추가</h4>
		      	<table id="admin-cat-add">
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" name="name"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" name="content"></td>
		      		</tr>
		      		<tr>
		      			<td class="s">&nbsp;</td>
		      			<td><input type="submit" value="카테고리 추가"></td>
		      		</tr>      		      		
		      	</table> 
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	</div>
</body>
</html>