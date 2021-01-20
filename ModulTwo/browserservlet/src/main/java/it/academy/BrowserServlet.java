package it.academy;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "browserServlet", urlPatterns = "/browser")

public class BrowserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        UserAgent userAgent = UserAgent.parseUserAgentString(req.getHeader("User-Agent"));
        Browser browser = userAgent.getBrowser();
        String browserName = browser.getGroup().getName();
        final PrintWriter out = resp.getWriter();
        out.println("<html lang=\"en\"><head><title>First Servlet</title></head>");
        out.println("<body><h1>Приветствую пользовалетя "+browserName+" </h1>");
        out.println("</body></html>");
    }

}
