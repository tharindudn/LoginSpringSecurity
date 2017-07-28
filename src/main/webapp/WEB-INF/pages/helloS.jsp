<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
<h3>SuperUser Page : ${message}</h3>
<h3>Username : ${username}</h3>
<jsp:include page="navigate.jsp"></jsp:include>


<c:url var="updateAction" value="/update"></c:url>
<form:form method="POST" commandName="user" action="${updateAction}">
    <table>
        <tr>
            <td><form:label path="Name">Name:</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="Role">Role:</form:label></td>
            <td><form:input path="role"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <td>
                <td>
                <td>
                <input type="submit" name="add" value="add">
                <input type="submit" name="delete" value="delete">
                    <%--<input type="submit" value="edit"/>--%>
            </td>
                </td>
                </td>
            </td>
            <td></td>
            <td></td>
        </tr>
    </table>
</form:form>
<h3>User List</h3>
<c:if test="${!empty listUser}">
    <table class="tg">
        <tr>
            <th width="120">User name</th>
            <th width="120">User role</th>

        </tr>
        <c:forEach items="${listUser}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.role}</td>
            </tr>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
