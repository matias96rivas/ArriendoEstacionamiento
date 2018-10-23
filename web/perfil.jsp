<%-- 
    Document   : perfil
    Created on : 03-sep-2018, 17:03:49
    Author     : Duoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${user == null}">
        <%
            response.sendRedirect("index.jsp");
        %>
    </c:when>
    <c:when test="${user != null}">
        <c:if test="${user.getTipoUsu().equals(1)}">
            <!DOCTYPE html>
            <html>
                <head>
                    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                    <title>JSP Page</title>
                </head>
                <body>
                    <h1>Hello World! admin</h1>
                    <a href="logout.jsp">Salir</a>
                </body>
            </html>
        </c:if>
        <c:if test="${user.getTipoUsu().equals(2)}">
            <!DOCTYPE html>
            <html>
                <head>
                    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                    <title>JSP Page</title>
                </head>
                <body>
                    <h1>Hello World! arrendatario</h1>
                    <a href="logout.jsp">Salir</a>
                </body>
            </html>
        </c:if>
        <c:if test="${user.getTipoUsu.equals(3)}">
            <!DOCTYPE html>
            <html>
                <head>
                    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                    <title>JSP Page</title>
                </head>
                <body>
                    <h1>Hello World! arrendador</h1>
                    <a href="logout.jsp">Salir</a>
                </body>
            </html>
        </c:if>

    </c:when>
</c:choose>

