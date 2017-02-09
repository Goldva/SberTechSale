<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Главное меню</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <%--<link href="css/style.css" rel="stylesheet" type="text/css">--%>
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
<span style="float: right">
    <a href="?lang=en">en</a>
    <a href="?lang=ru">ru</a>
</span>

<div>
    <form:form method="get" action="/personalArea">
        <input type="submit" value="<spring:message code="button.personalArea"/>"/>
    </form:form>
    <form:form method="get" action="/index/exit">
        <input type="submit" value="<spring:message code="button.exit"/>"/>
    </form:form>
</div>
<div>
    <form:form method="post" action="/index/" commandName="newItem">
        <div>
            <div>
                <form:label path="itemName">
                    <spring:message code="label.itemName"/>
                </form:label>
                <form:input path="itemName"/>
            </div>
            <div>
                <form:label path="description">
                    <spring:message code="label.description"/>
                </form:label>
                <form:input path="description"/>
            </div>
            <div>
                <input type="submit" value="<spring:message code="button.add"/>"/>
            </div>
        </div>
    </form:form>
</div>
<div>
    <jsp:useBean id="items" class="java.util.ArrayList" scope="request"/>
    <table id="items_table">
        <tbody>
        <tr>
            <th><spring:message code="label.id"/></th>
            <th><spring:message code="label.itemName"/></th>
            <th><spring:message code="label.description"/></th>
            <th><spring:message code="label.userName"/></th>
        </tr>
        <c:forEach items="${items}" var="item">
            <tr>
                <th align="left">${item.id}</th>
                <td align="left">${item.itemName}</td>
                <td align="left">${item.description}</td>
                <td align="left">${item.user.userName}</td>
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
            buyItem(elem.parentNode);
        };
    }
</script>

<script type="text/javascript">
    function buyItem(row) {
        var r = confirm("<spring:message code="message.doYouWantToBuyThisProduct"/>");
        if (r == true) {
            var id = row.children.item(0).innerText;
            $.ajax({
                url: '/index/' + id,
                method: 'PUT',
                success: function () {
                    alert('<spring:message code="error.thankYouForYourPurchase"/>');
                    window.location = "/index"
                },
                error: function () {
                    alert('<spring:message code="error.thisProductDoesNotHaveInStock"/>');
                    window.location = "/index"
                }

            });
        }
    }
</script>

<script type="text/javascript">
    highlight_Table_Rows("items_table", "hover_Row", "clicked_Row", false);
</script>

</body>
</html>