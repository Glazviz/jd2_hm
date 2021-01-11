package it.academy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleCountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try
        {
            PrintWriter out = resp.getWriter();
            DataInputStream output = new DataInputStream(new BufferedInputStream(new FileInputStream("/count.txt")));
            int count = output.readInt() + 1;
            if (output != null)
                output.close();
            out.println("<html>"
                    + "<head>"
                    + "<title>CountServlet</title>"
                    + "</head>"
                    + "<body>"
                    + "<h3>You visited this page " + count + " times</h3>"
                    + "</body>"
                    + "</html>");
            DataOutputStream input = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("/count.txt")));
            getServletContext().getRealPath("/count.txt");
            input.writeInt(count);
            input.flush();
            input.close();
        } catch (IOException e)
        {
            Logger.getLogger(SimpleCountServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
