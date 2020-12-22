package it.academy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "echoServlet", urlPatterns = "/echo")
public class EchoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw;
        String message = "";
        String parm1 = req.getParameter("page");
        String parm2 = req.getParameter("name");
        message += "Sss:doGet";
        System.out.println("Sss:doGet:page=" + parm1);
        System.out.println("Sss:doGet:name=" + parm2);
        resp.setContentType("text/html");
        pw = resp.getWriter();
        pw.println("<html><body>"
                + "<hr>" + message
                +"<hr><br>Sss:doGet: page=" + parm1
                +"<br>Sss:doGet: name=" + parm2
                +"<br>Sss:getRemoteHost: "+req.getRemoteHost()
                +"<br>Sss:getServletPath: "+req.getServletPath()
                +"<br>Sss:getServerName: "+req.getServerName()
                +"<br>Sss:rq.getContextPath: " + req.getContextPath()
                + "<br>Sss:rq.getRequestURI: " + req.getRequestURI()
                + "<br>Sss:rq.getRequestURL: " + req.getRequestURL()
                + "<img src=\"images/Anime-Wallpapers-16.jpg\"/>"
                + "</body></html>");
        pw.close();
    }
}
