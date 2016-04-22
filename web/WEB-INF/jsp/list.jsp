<%@ page import="ru.javawebinar.webapp.model.ContactType" %>
<%@ page import="ru.javawebinar.webapp.model.Resume" %>
<%@ page import="java.util.Collection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Список всех резюме</title>
</head>
<body>
<section>
    <table>
        <tr>
            <td>
                <table border="1" cellpadding="8" cellspacing="0">
                    <tr>
                        <th>Имя</th>
                        <th>Email</th>
                        <th></th>
                        <th></th>
                    </tr>
                    <%
                        for (Resume resume : (Collection<Resume>) request.getAttribute("resumeList")) {
                    %>
                    <tr>
                        <td><a href="resume?uuid=<%=resume.getUuid()%>&action=view"><%=resume.getFullName()%>
                        </a></td>
                        <td><%=resume.getContact(ContactType.MAIL)%>
                        </td>
                        <td><a href="resume?uuid=<%=resume.getUuid()%>&action=delete"><img src="img/delete.png"></a>
                        </td>
                        <td><a href="resume?uuid=<%=resume.getUuid()%>&action=edit"><img src="img/pencil.png"></a></td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </td>
        </tr>
    </table>
</section>
</body>
</html>
