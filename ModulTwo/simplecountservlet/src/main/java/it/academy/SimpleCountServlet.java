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
    private static final String path = "D:\\jd2_hm\\simplecountservlet\\src\\main\\resources\\counter.txt";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            line = bufferedReader.readLine();
        }
        int count = 0;
        count = Integer.parseInt(line);
        count++;
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Count</title></head>");
        out.println(" <body><h1>" + "Count of visits: " + count + "</h1></body></html>");

        try (final FileWriter writer = new FileWriter(path, false)) {
            final String str = Integer.toString(count);
            writer.write(str);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
