package it.academy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AcssecServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter out = resp.getWriter()) {
            String firstname = req.getParameter("first name");
            String lastname = req.getParameter("last name");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");

            if ((firstname.isEmpty()) & (lastname.isEmpty()) & (phone.isEmpty()) & (email.isEmpty())) {
                out.println("<body><h2>Enter u acsses</h2>");
            } else {
                out.println("<body><p>Hello " + firstname + lastname + "</p>");
                if (!phone.isEmpty())
                    out.println("<p>Your phone number: " + phone + "</p>");
                if (!email.isEmpty())
                    out.println("<p>Your e-mail: " + email + "</p>");
            }
        }
    }

            @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
