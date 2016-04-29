<html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Просмотр резюме</title>
</head>
<body>
<jsp:useBean id="resumeBean" class="ru.javawebinar.webapp.web.ResumeBean"/>
<jsp:setProperty name="resumeBean" property="uuid" param="uuid"/>
<h1>Резюме </h1>
<h4><c:out value="${resumeBean.resume.fullName}"/></h4>
<table>
    <c:forEach items="${resumeBean.resume.contacts}" var="contVar" varStatus="contVarStatus">
        <tr>
            <td>
                <c:out value="${constVar.key.name}"/>
                <c:if test="${constVar.key == resumeBean.contactTypes[3]}">
                    <img src="img/skype.png">
                </c:if>
                <c:if test="${constVar.key == resumeBean.contactTypes[4]}">
                    <img src="img/email.png">
                </c:if>
            </td>
            <td><c:out value="${contVar.key.title}"/></td>
            <td><c:out value="${contVar.value}"/></td>
        </tr>
    </c:forEach>
</table>
<table>
    <tr>
        <td><c:out value="${resumeBean.sectionTypes[0].title}"/></td>
        <td><c:out value="${resumeBean.getTextSection(resumeBean.sectionTypes[0])}"/></td>
    </tr>
</table>
<table>
    <tr style="vertical-align: top;">
        <td><c:out value="${resumeBean.sectionTypes[1].title}"/></td>
        <td>
            <c:forEach items="${resumeBean.getLinesSection(resumeBean.sectionTypes[1])}" var="varL1" varStatus="st1">
                <c:out value="${varL1}"/><br/>
            </c:forEach>
        </td>
    </tr>
    <tr style="vertical-align: top;">
        <td><c:out value="${resumeBean.sectionTypes[2].title}"/></td>
        <td>
            <c:forEach items="${resumeBean.getLinesSection(resumeBean.sectionTypes[2])}" var="varL2" varStatus="st2">
                <c:out value="${varL2}"/><br/>
            </c:forEach>
        </td>
    </tr>
</table>
<table>
    <tr style="vertical-align: top;">
        <td><c:out value="${resumeBean.sectionTypes[3].title}"/></td>
        <td/>
    </tr>
    <c:forEach items="${resumeBean.getOrganizations(resumeBean.sectionTypes[3])}" var="org" varStatus="stOrg">
    <tr style="vertical-align: top;">
        <td>
            <c:out value="${org.homePage.name}"/><br/>
            <a href="${org.homePage.url}"> <c:out value="${org.homePage.url}"/> </a>
        </td>
        <td>
            <c:forEach items="${resumeBean.getOrganizationPositionList(resumeBean.sectionTypes[3], stOrg.index)}"
                       var="pos" varStatus="st3">
                <c:out value="${pos.title}"/><br/>
                <c:out value="${pos.startDate}  -  ${pos.endDate}"/><br/>
                <c:out value="${pos.description}"/><br/>
            </c:forEach>
        </td>
    <tr>
        </c:forEach>
    <tr style="vertical-align: top;">
        <td><c:out value="${resumeBean.sectionTypes[4].title}"/></td>
        <td/>
    </tr>
    <c:forEach items="${resumeBean.getOrganizations(resumeBean.sectionTypes[4])}" var="org" varStatus="stOrg">
    <tr style="vertical-align: top;">
        <td>
            <c:out value="${org.homePage.name}"/><br/>
            <a href="${org.homePage.url}"> <c:out value="${org.homePage.url}"/> </a>
        </td>
        <td>
            <c:forEach items="${resumeBean.getOrganizationPositionList(resumeBean.sectionTypes[4], stOrg.index)}"
                       var="pos" varStatus="st3">
                <c:out value="${pos.title}"/><br/>
                <c:out value="${pos.startDate}  -  ${pos.endDate}"/><br/>
                <c:out value="${pos.description}"/><br/>
            </c:forEach>
        </td>
    <tr>
        </c:forEach>
</table>
<a href="/resume">В список резюме</a>
</body>
</html>
