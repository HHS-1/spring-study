<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>   
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%
    	String search = request.getParameter("search");
   		String data[] = {"삼겹살", "등심", "안심", "갈매기살", "목살", "안창살"};
    %>
    <cr:set var="search" value="<%=search%>"/>
    <cr:set var="no_search" value="false"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL로 SPA 검색기능 사용법</title>
</head>
<body>
<form id="frm" method="post" action="./jstl_search.jsp">
검색어 : <input type="text" id="search" name="search" value="${search}">
<button type="button" onclick="spa_form">검색</button>
<br>
<p>메뉴리스트</p>
<ul>

<cr:forEach var="menu" items="<%=data%>">
<cr:if test="${search eq null or search eq ''}">
<cr:set var="no_search" value="true"/>
<li>${menu}</li>
</cr:if>

<cr:if test="${search ne null }">
<cr:if test="${menu eq search}">
<li>${menu}</li>
<cr:set var="no_search" value="true"/>
</cr:if>
</cr:if>
</cr:forEach>

<cr:if test="${no_search eq 'false' }">
<script>
alert("해당 메뉴는 없습니다.");
location.href='./jstl_search.jsp'
</script>
</cr:if>

</ul>
</form>
</body>
<script>
	function spa_form(){
		frm.submit();
	}
</script>
</html>