<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title></title>
    <%--<link href="css/style.css" rel="stylesheet" type="text/css" >--%>
    <style type="text/css">
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        table th {
            background-color: lightblue;
        }
        .hover_Row {
            background-color: yellow;
        }
        .clicked_Row {
            background-color: lightgreen;
        }
    </style>
</head>
<body>
<div>
    <jsp:useBean id="bids" class="java.util.ArrayList" scope="request"/>
    <table>
        <tbody>
        <tr>
            <th><spring:message code="lable.id"/></th>
            <th><spring:message code="lable.userName"/></th>
            <th><spring:message code="lable.itemName"/></th>
        </tr>
        <c:forEach items="${bids}" var="bids">
            <tr>
                <th align="left">${bids.id}</th>
                <td align="left">${bids.user.userName}</td>
                <td align="left">${bids.item.itemName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
