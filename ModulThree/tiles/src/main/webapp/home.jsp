<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page contentType="text/html; UTF-8" %>
<html>
<head>
    <title>Tiles</title>
    <style type="text/css">
        table {
            width: 100%;
        }

        td.col1 {
            background: Pink;
        }

        td.col2 {
            background: Blue;
        }

        td.col3 {
            background: Black;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <td class="col1" colspan="2">
            <tiles:insertAttribute name="header"/>
        </td>
    </tr>
    <tr>
        <td class="col2" width="20%">
            <tiles:insertAttribute name="menu"/>
        </td>
        <td class="col3">
            <tiles:insertAttribute name="body"/>
        </td>
    </tr>
    <tr>
        <td class="col1" colspan="2">
            <tiles:insertAttribute name="footer"/>
        </td>
    </tr>
</table>
</body>
</html>


