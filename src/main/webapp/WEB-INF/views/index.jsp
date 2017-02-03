<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Главное меню</title>
</head>
<body>
<table>
    <tbody>
    <tr>
        <%--<td>--%>
            <%--<form:form method="post" action="addUser" commandName="newUser">--%>
                <%--<table>--%>
                    <%--<tr>--%>
                        <%--<td><form:label path="name">--%>
                            <%--User name--%>
                        <%--</form:label></td>--%>
                        <%--<td><form:input path="name"/></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td colspan="2">--%>
                            <%--<input type="submit" value="Add user"/>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                <%--</table>--%>
            <%--</form:form>--%>
        <%--</td>--%>
        <td>
            <form:form method="post" action="addItem" commandName="newItem">
                <table>
                    <tr>
                        <td><form:label path="name">
                            Item name
                        </form:label></td>
                        <td><form:input path="name"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="description">
                            Description item
                        </form:label></td>
                        <td><form:input path="description"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="user.name">
                            User name
                        </form:label></td>
                        <td><form:input path="user.name"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Add item"/>
                        </td>
                    </tr>
                </table>
            </form:form>
        </td>
        <td>
            <form:form method="post" action="addBid" commandName="newBid">
                <table>
                    <tr>
                        <td><form:label path="item.id">
                            Item id
                        </form:label></td>
                        <td><form:input path="item.id"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="user.id">
                            User id
                        </form:label></td>
                        <td><form:input path="user.id"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Add bid"/>
                        </td>
                    </tr>
                </table>
            </form:form>
        </td>
    </tr>
    <tr>
        <td>
            <jsp:useBean id="users" class="java.util.ArrayList" scope="request"/>
            <table>
                <tbody>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                </tr>
                <c:forEach items="${users}" var="user">
                    <tr onclick="location.href='/index'">
                        <td align="left">${user.id}</td>
                        <td align="left">${user.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </td>
        <td>
            <jsp:useBean id="items" class="java.util.ArrayList" scope="request"/>
            <table>
                <tbody>
                <tr>
                    <th>id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>UserName</th>
                </tr>
                <c:forEach items="${items}" var="item">
                    <tr onclick="location.href='/login'">
                        <td align="left">${item.id}</td>
                        <td align="left">${item.name}</td>
                        <td align="left">${item.description}</td>
                        <td align="left">${item.user.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </td>
        <td>
            <jsp:useBean id="bids" class="java.util.ArrayList" scope="request"/>
            <table>
                <tbody>
                <tr>
                    <th>id</th>
                    <th>UserName</th>
                    <th>ItemName</th>
                </tr>
                <c:forEach items="${bids}" var="bid">
                    <tr onclick="location.href='/login'">
                        <td align="left">${bid.id}</td>
                        <td align="left">${bid.user.name}</td>
                        <td align="left">${bid.item.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </td>
    </tbody>
</table>

<jsp:useBean id="error" class="java.lang.String" scope="request"/>
<c:if test="${error}">
    <jsp:useBean id="messageError" class="java.lang.String" scope="request"/>
    <script LANGUAGE="JavaScript">
        alert("${messageError}");
    </script>
</c:if>


</body>
</html>