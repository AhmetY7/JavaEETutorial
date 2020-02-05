<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSTL Demo</title>
</head>
<body>
<%-- Bildiğimiz split işlemi. ayırdığı elemanları vardaki değişkene atılıyor. --%>
<c:set var="elements" value="${fn:split('www.studyeasy.org','.') }"/>
<c:forEach var="element" items="${elements}">
${element}
<br/>
</c:forEach>
<br/>
<%-- Bu da arraydeki stringleri verilen ifade ile birleştirir. --%>
Elements: ${fn:join(elements,'.')}
</body>
</html>









