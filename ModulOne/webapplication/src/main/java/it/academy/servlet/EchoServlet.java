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
                +"<br>doGet: name=" + parm2
                +"<br>getRemoteHost: "+req.getRemoteHost()
                +"<br>getServletPath: "+req.getServletPath()
                +"<br>getServerName: "+req.getServerName()
                +"<br>rq.getContextPath: " + req.getContextPath()
                + "<br>rq.getRequestURI: " + req.getRequestURI()
                + "<br>rq.getRequestURL: " + req.getRequestURL()
                + "</body></html>");
        pw.close();
    }
}
