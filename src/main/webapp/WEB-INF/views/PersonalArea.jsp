<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <jsp:useBean id="bids" class="java.util.ArrayList" scope="request"/>
    <table>
        <tbody>
        <tr>
            <th>id</th>
            <th>UserName</th>
            <th>ItemName</th>
        </tr>
        <c:forEach items="${bids}" var="bids">
            <tr>
                <td align="left">${bids.id}</td>
                <td align="left">${bids.user.userName}</td>
                <td align="left">${bids.item.itemName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
