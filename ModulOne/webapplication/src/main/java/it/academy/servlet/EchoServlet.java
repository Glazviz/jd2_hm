package it.academy.servlet;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
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
        UserAgent userAgent = UserAgent.parseUserAgentString(req.getHeader("User-Agent"));
        Browser browser = userAgent.getBrowser();
        String browserName = browser.getGroup().getName();
        pw.println("<html><body>"
                + "<hr>" + message
                +"<hr><br>Sss:doGet: page=" + parm1
                +"<br>doGet: name=" + parm2
                +"<br>getRemoteHost: "+req.getRemoteHost()
                +"<br>getServletPath: "+req.getServletPath()
                +"<br>getServerName: "+req.getServerName()
                +"<br>getContextPath: " + req.getContextPath()
                +"<br>getRequestURI: " + req.getRequestURI()
                +"<br>getRequestURL: " + req.getRequestURL()
                +"<br>getLocalName: " + req.getLocalName()
                +"<br>getSession: " + req.getSession()
                +"<br>getPathInfo: " + req.getPathInfo()
                +"<br>getContentType: " + req.getContentType()
                +"<br>getHttpServletMapping: " + req.getHttpServletMapping()
                +"<br>getServerPort: " + req.getServerPort()
                +"<br>getCookies: " + Arrays.toString(req.getCookies())
                +"<body><h1>Hello browser " + browserName
                +"</body></html>");
        pw.close();
    }
}
