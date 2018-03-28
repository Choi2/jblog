<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<h1 class="logo">JBlog</h1>
<ul class="menu">
	<c:if test="${sessionScope.authUser eq null}">
		<li><a href="${pageContext.request.contextPath}/user/auth">로그인</a></li>
		<li><a href="${pageContext.request.contextPath}/user/join">회원가입</a></li>
	</c:if>
	<c:if test="${sessionScope.authUser ne null}">
		<li>${sessionScope.authUser.name}님 환영합니다.</li>
		<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
		<li><a href="${pageContext.request.contextPath}/${sessionScope.authUser.id}">내블로그</a></li>
	</c:if>
</ul>