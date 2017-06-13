<%--
  Created by IntelliJ IDEA.
  User: zproo
  Date: 2017/6/12
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>
<h1 align="center">Beer Recommendations JSP</h1>
<br>
<%
    List styles = (List) request.getAttribute("styles");
    Iterator it = styles.iterator();
    while (it.hasNext()) {
        out.print("<br>try: " + it.next());
    }
%>

</body>
</html>
