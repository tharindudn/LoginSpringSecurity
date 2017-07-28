<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<body>
<div>

    <security:authorize access="hasAnyRole('ROLE_A','ROLE_T','ROLE_S')">
    <td><a href="hello">User page </a></td><br/>
    </security:authorize>
    <security:authorize access="hasAnyRole('ROLE_A','ROLE_T','ROLE_S')">
        <td><a href="helloT">Teacher page </a></td><br/>
    </security:authorize>
    <security:authorize access="hasAnyRole('ROLE_A','ROLE_S')">
        <td><a href="helloA">Admin page </a></td><br/>
    </security:authorize>
    <td><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></td>
</div>



</body>
</html>