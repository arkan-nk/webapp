package ru.javawebinar.webapp.web;

import ru.javawebinar.webapp.Config;
import ru.javawebinar.webapp.model.*;
import ru.javawebinar.webapp.storage.Storage;
import ru.javawebinar.webapp.util.HtmlUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * GKislin
 * 22.04.2016
 */
public class ResumeServlet extends HttpServlet {
    private Storage storage;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        if (storage==null) {
            Config.get(
                    getServletContext().getInitParameter("storage.dir"),
                    getServletContext().getInitParameter("db.url"),
                    getServletContext().getInitParameter("db.user"),
                    getServletContext().getInitParameter("db.password"));
        }
        storage = Config.getStorage();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");
        String action = request.getParameter("action");
        if (action == null) {
            request.setAttribute("resumeList", storage.getAllSorted());
            request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
            return;
        }

        Resume r;
        switch (action) {
            case "delete":
                storage.delete(uuid);
                response.sendRedirect("resume");
                return;
            case "create":
                r = Resume.EMPTY;
                break;
            case "view":
            case "edit":
                r = storage.get(uuid);
                break;
            default:
                throw new IllegalArgumentException("Action " + action + " is illegal");
        }
        request.setAttribute("resume", r);
        request.getRequestDispatcher(
                ("view".equals(action) ? "/WEB-INF/jsp/view.jsp" : "/WEB-INF/jsp/edit.jsp")
        ).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String uuid = request.getParameter("uuid");
        String name = request.getParameter("name");
        String about = request.getParameter("about");

        final Resume r;
        if (uuid == null) {
            r = new Resume(name, about);
        } else {
            r = storage.get(uuid);
            r.setFullName(name);
            r.setAbout(about);
        }

        for (ContactType type : ContactType.values()) {
            String value = request.getParameter(type.name());
            if (HtmlUtil.isEmpty(value)) {
                r.getContacts().remove(type);
            } else {
                r.addContact(type, value);
            }
        }
        for (SectionType type : SectionType.values()) {
            String value = request.getParameter(type.name());
            if (type == SectionType.EDUCATION || type == SectionType.EXPERIENCE) {
                continue;
            }
            if (HtmlUtil.isEmpty(value)) {
                r.getSections().remove(type);
            } else {
                r.addSection(type, type == SectionType.OBJECTIVE ? new TextSection(value) : new ListSection(value.split("\\n")));
            }
        }
        if (uuid == null) {
            storage.save(r);
        } else {
            storage.update(r);
        }
        response.sendRedirect("resume");
    }
}
