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
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"/>
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<input type="hidden" name="no" value="${blog.no}"/>
					<c:if test="${postList ne null}">
						<h4>${postList[postNo].title}</h4>
						<p>
							${postList[postNo].content}
						</p>
					</c:if>
				</div>
				<ul class="blog-list">
					<c:forEach items="${postList}" var="vo" varStatus="status">
						<li>
							<a href="${pageContext.request.contextPath}/${id}/${vo.categoryNo}/${vo.no}">${vo.title}</a>
							<span><fmt:formatDate value="${vo.regDate}" pattern="yyyy-MM-dd"/></span>	
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${blog.imagePath}">
			</div>
		</div>

		<c:import url="/WEB-INF/views/includes/navigation.jsp"/>
		<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	</div>
</body>
</html>