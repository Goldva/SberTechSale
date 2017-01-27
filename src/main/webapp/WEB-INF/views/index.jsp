<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Главное меню</title>
</head>
<body>
<form:form method="post" action="/" commandName="newUser">
    <table>
        <tr>
            <td><form:label path="name">
                User name
            </form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Add user"/>
            </td>
        </tr>
    </table>
</form:form>

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

<table>
    <tr>
        <td align="right">Item name</td>
        <td><input type="text" name="item_itemname" size="10"></td>
    </tr>
    <tr>
        <td align="right">Description item</td>
        <td><input type="text" name="item_description" size="10"></td>
    </tr>
    <tr>
        <td align="right">User name</td>
        <td><input type="text" name="item_username" size="10"></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Add item"/>
        </td>
    </tr>
</table>

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

<table>
    <tr>
        <td align="right">Item name</td>
        <td><input type="text" name="bid_itemname" size="10"></td>
    </tr>
    <tr>
        <td align="right">User name</td>
        <td><input type="text" name="bid_username" size="10"></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Add bid"/>
        </td>
    </tr>
</table>

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

<%--<script LANGUAGE="JavaScript">--%>
<%--<!----%>
<%--function enter()--%>
<%--{--%>
<%--}--%>
<%--function register()--%>
<%--{--%>
<%--}--%>
<%--// -->--%>
<%--</script>--%>

</body>
</html>