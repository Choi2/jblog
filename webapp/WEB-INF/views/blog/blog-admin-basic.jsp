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
	function readURL(input) {
		if (input.files && input.files[0]) {
	          var reader = new FileReader();
	          reader.onload = function (e) {
	                $('#image_upload_preview').attr('src', e.target.result);
	          }
	          reader.readAsDataURL(input.files[0]);
	     }
	 }

	 $("#logo-file").change(function () {
	         readURL(this);
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
					<c:param name="admin-menu" value="basic"/>
				</c:import>
				<form id=blog-form 
					action="${pageContext.request.contextPath}/${sessionScope.authUser.id}/admin/basic" 
					enctype="multipart/form-data"
					method="post">
					<input type="hidden" name="no" value="${blog.no}"/>
	 		      	<table class="admin-config">
			      		<tr>
			      			<td class="t">블로그 제목</td>
			      			<td><input type="text" size="40" name="title"></td>
			      		</tr>
			      		<tr>
			      			<td class="t">로고이미지</td>
			      			<td><img id="image_upload_preview"/></td>      			
			      		</tr>      		
			      		<tr>
			      			<td class="t">&nbsp;</td>
			      			<td><input type="file" id="logo-file" name="logo-file"></td>      			
			      		</tr>           		
			      		<tr>
			      			<td class="t">&nbsp;</td>
			      			<td class="s"><input type="submit" value="기본설정 변경"></td>      			
			      		</tr>           		
			      	</table>
				</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	</div>
</body>
</html>