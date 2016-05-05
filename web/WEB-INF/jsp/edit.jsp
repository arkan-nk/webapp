<%@ page import="ru.javawebinar.webapp.model.ContactType" %>
<%@ page import="ru.javawebinar.webapp.model.ListSection" %>
<%@ page import="ru.javawebinar.webapp.model.SectionType" %>
<%@ page import="ru.javawebinar.webapp.model.TextSection" %>
<%@ page import="ru.javawebinar.webapp.util.HtmlUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/resume.css">
    <jsp:useBean id="resume" type="ru.javawebinar.webapp.model.Resume" scope="request"/>
    <title>Резюме ${resume.fullName}</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section>
    <form id="resume" method="post" action="resume" enctype="application/x-www-form-urlencoded">
        <input type="hidden" name="uuid" value="${resume.uuid}">
        <dl>
            <dt>Имя:</dt>
            <dd><input type="text" name="name" size=50 value="${resume.fullName}"></dd>
        </dl>
        <dl>
            <dt>Обо мне:</dt>
            <dd><textarea name='about' cols=50 rows=4>${resume.about}</textarea>
            </dd>
        </dl>
        <h3>Контакты:</h3>
        <p>
            <c:forEach var="type" items="<%=ContactType.values()%>">
        <dl>
            <dt>${type.title}</dt>
            <dd><input type="text" name="${type.name()}" size=30 value="${HtmlUtil.getContact(resume, type)}"></dd>
        </dl>
        </c:forEach>

        <c:forEach var="type" items="<%=SectionType.values()%>">
            <h3><a>${type.title}</a></h3>
            <c:set var="section" value="${HtmlUtil.getSection(resume, type)}"/>
            <jsp:useBean id="section" type="ru.javawebinar.webapp.model.Section"/>

            <c:choose>
                <c:when test="${type=='OBJECTIVE'}">
                    <input type='text' name='${type}' size=75 value='<%=((TextSection) section).getContent()%>'>
                </c:when>
                <c:when test="${type=='QUALIFICATIONS' || type=='ACHIEVEMENT'}">
                    <textarea name='${type}' cols=75
                              rows=6><%=String.join("\n", ((ListSection) section).getLines())%></textarea>
                </c:when>
            </c:choose>
        </c:forEach>
        <hr>
        <button type="submit">Сохранить</button>
        <button onclick="window.history.back()">Отменить</button>
    </form>

</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
