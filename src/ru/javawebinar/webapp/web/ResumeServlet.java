package ru.javawebinar.webapp.web;

import ru.javawebinar.webapp.model.Resume;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.javawebinar.webapp.Config.STORAGE;

/**
 * GKislin
 * 22.04.2016
 */
public class ResumeServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String uuid = req.getParameter("uuid");
        req.setAttribute("uuid", uuid);
        String ta = req.getParameter("action");
        String action = ta!=null ? ta : "";
        switch (action) {
            case "edit" :
            case "view" : {
                Resume res = STORAGE.get(uuid);
                req.setAttribute("res", res);
                req.getRequestDispatcher("WEB-INF/jsp/view.jsp").forward(req, resp);
                break;
            }
            case "delete" : STORAGE.delete(uuid);
            default: {
                req.setAttribute("resumeList", STORAGE.getAllSorted());
                req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, resp);
            }
        }
    }
}
