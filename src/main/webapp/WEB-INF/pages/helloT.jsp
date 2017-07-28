<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<body>
<h3>Teacher Page : ${message}</h3>
<h3>Username : ${username}</h3>
<jsp:include page="navigate.jsp"></jsp:include>
</body>
</html>