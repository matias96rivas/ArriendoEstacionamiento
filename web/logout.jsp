<%-- 
    Document   : logout
    Created on : 03-sep-2018, 19:18:38
    Author     : Duoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
session.invalidate();
response.sendRedirect("index.jsp"); 
%>