package it.academy.servlet;

import it.academy.StartServlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class Set extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String cookieName = "testCookie";
        Cookie[] myCookies = req.getCookies();
        PrintWriter out = resp.getWriter();
        StartServlet startServlet = new StartServlet();

        if (myCookies != null) {
            for (int i = 0; i < myCookies.length; i++) {
                Cookie cookie = myCookies[i];
                if (cookie.getName().equals(cookieName)) {
                    startServlet.write();
                    int num = startServlet.getCount();
                    out.println("<html><head><title>Coookie</title></head>");
                    out.println(" <body><h1>You've been here for the last time in 24 hours " + num + " times</h1>");
                    out.println("<h4>Name of cookie: " + cookie.getName() + ", value of cookie:" + cookie.getValue() + "</h4></body></html>");
                }
            }
        } else {
            out.println(" <body><h1>This is your first time here!</h1></body></html>");
            startServlet.clean();
            Cookie myCookie = new Cookie("testCookie", "123");
            myCookie.setMaxAge(24 * 60 * 60);
            resp.addCookie(myCookie);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }}