<html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="ru.javawebinar.webapp.model.Resume" %>
<%@ page import="ru.javawebinar.webapp.model.ContactType" %>
<%@ page import="java.util.Map" %>
<%@ page import="ru.javawebinar.webapp.model.Section" %>
<%@ page import="ru.javawebinar.webapp.model.SectionType" %>
<%--
  Created by IntelliJ IDEA.
  User: GKislin
  Date: 22.04.2016
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>


<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Просмотр резюме</title>
</head>
<body>
<jsp:useBean id="resumeBean" class="ru.javawebinar.webapp.web.ResumeBean"/>
<jsp:setProperty name="resumeBean" property="uuid" param="uuid"/>
<h1>Резюме </h1>
<h3><c:out value="${resumeBean.resume.fullName}" /></h3>
<table>
    <tr>
        <td><c:out value="${resumeBean.sectionTypes[0].title}"/></td>
        <td><c:out value="${resumeBean.positionSection}"/></td>
    </tr>
</table>
<table>
    <tr>
        <td><c:out value="${resumeBean.sectionTypes[1].title}"/></td>
        <td>
            <c:forEach items="${resumeBean.getLinesSection(resumeBean.sectionTypes[1])}" var="varL1" varStatus="st1">
                <c:out value="${varL1}"/><br/>
            </c:forEach>
        </td>
    </tr>
    <tr>
        <td><c:out value="${resumeBean.sectionTypes[2].title}"/></td>
        <td>
            <c:forEach items="${resumeBean.getLinesSection(resumeBean.sectionTypes[2])}" var="varL2" varStatus="st2">
                <c:out value="${varL2}"/><br/>
            </c:forEach>
        </td>
    </tr>
</table>

<table>
<c:forEach items="${resumeBean.resume.sections}" var="varSect" varStatus="st">
    <c:choose>
        <c:when test="${varSect.key eq resumeBean.sectionTypes[0]}">
            <tr>
            <td><c:out value="${varSect.key.title}"/></td>
            <td><c:out value="${varSect.value}"/></td>
            </tr>
        </c:when>
        <c:otherwise/>
    </c:choose>
</c:forEach>
<c:forEach items="${resumeBean.resume.sections}" var="varSect" varStatus="st">
    <c:choose>
        <c:when test="${varSect.key eq resumeBean.sectionTypes[1] or varSect.key eq resumeBean.sectionTypes[2]}">
                <tr>
                    <td><c:out value="${varSect.key.title}"/></td>
                    <td><c:out value="${varSect.value}"/></td>
                </tr>
        </c:when>
        <c:otherwise/>
    </c:choose>
</c:forEach>
</table>



<a href="/resume">Список резюме</a>
</body>
</html>
