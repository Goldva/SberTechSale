<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Главное меню</title>

    <style type="text/css">
        .item {
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
    <form:form method="post" action="index/addItem" commandName="newItem">
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
</div>
<div>
    <jsp:useBean id="items" class="java.util.ArrayList" scope="request"/>
    <table class="item" id="items_table" lastclickedrowi="0">
        <tbody>
        <tr>
            <th class="item">id</th>
            <th class="item">Name</th>
            <th class="item">Description</th>
            <th class="item">UserName</th>
        </tr>
        <c:forEach items="${items}" var="item">
            <tr>
                <th class="item" align="left">${item.id}</th>
                <td class="item" align="left">${item.name}</td>
                <td class="item" align="left">${item.description}</td>
                <td class="item" align="left">${item.user.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script type="text/javascript">
//    Эта функция copy-paste

    function highlight_Table_Rows(table_Id, hover_Class, click_Class, multiple) {
        var table = document.getElementById(table_Id);
        if (typeof multiple == 'undefined') multiple = true;

        if (hover_Class) {
            var hover_Class_Reg = new RegExp("\\b" + hover_Class + "\\b");
            table.onmouseover = table.onmouseout = function (e) {
                if (!e) e = window.event;
                var elem = e.target || e.srcElement;
                while (!elem.tagName || !elem.tagName.match(/td|th|table/i))
                    elem = elem.parentNode;

                if (elem.parentNode.tagName == 'TR' &&
                        elem.parentNode.parentNode.tagName == 'TBODY') {
                    var row = elem.parentNode;
                    if (!row.getAttribute('clicked_Row'))
                        row.className = e.type == "mouseover" ? row.className +
                        " " + hover_Class : row.className.replace(hover_Class_Reg, " ");
                }
            };
        }

        if (click_Class) table.onclick = function (e) {
            if (!e) e = window.event;
            var elem = e.target || e.srcElement;
            while (!elem.tagName || !elem.tagName.match(/td|th|table/i))
                elem = elem.parentNode;

            if (elem.parentNode.tagName == 'TR' &&
                    elem.parentNode.parentNode.tagName == 'TBODY') {
                var click_Class_Reg = new RegExp("\\b" + click_Class + "\\b");
                var row = elem.parentNode;

                if (row.getAttribute('clicked_Row')) {
                    row.removeAttribute('clicked_Row');
                    row.className = row.className.replace(click_Class_Reg, "");
                    row.className += " " + hover_Class;
                }
                else {
                    if (hover_Class) row.className = row.className.replace(hover_Class_Reg, "");
                    row.className += " " + click_Class;
                    row.setAttribute('clicked_Row', true);

                    if (!multiple) {
                        var lastRowI = table.getAttribute("last_Clicked_Row");
                        if (lastRowI !== null && lastRowI !== '' && row.sectionRowIndex != lastRowI) {
                            var lastRow = table.tBodies[0].rows[lastRowI];
                            lastRow.className = lastRow.className.replace(click_Class_Reg, "");
                            lastRow.removeAttribute('clicked_Row');
                        }
                    }
                    table.setAttribute("last_Clicked_Row", row.sectionRowIndex);
                }
            }
        };
    }
</script>

<script type="text/javascript">
    highlight_Table_Rows("items_table", "hover_Row", "clicked_Row", false);
</script>

</body>
</html>