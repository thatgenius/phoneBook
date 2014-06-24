<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Phone book</title>
</head>
<body>
<h1>Phone book</h1>

<form:form action="search" method="post" commandName="searchForm">
    <b>Search</b><br/>
    key word:<br/>
    <form:input path="lineToSearch" value=""/><br/>
    field:<br/>
    <form:select path="fieldToSearch" items="${fieldList}"/><br/>
    <input type="submit" value="Search"/><br/><br/>
</form:form>
<c:if test="${resultList != null}">
    <c:if test="${resultList.size() > 0}">
        <table border="1">
            <c:forEach var="p" items="${resultList}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.lastName}</td>
                    <td>${p.patronymicName}</td>
                    <td> ${p.cellPhoneNum}</td>
                    <td> ${p.officePhoneNum}</td>
                    <td> ${p.homePhoneNum}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</c:if>
</body>
</html>