package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;

public class ServletOneFour extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {

            ServletConfig config = getServletConfig();
            String URL = config.getInitParameter("URL");
            String USER = config.getInitParameter("USER");
            String PASSWORD = config.getInitParameter("PASSWORD");

            Class.forName("com.mysql.cj.jdbc.Driver");
            final Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            final Statement statement = connection.createStatement();
            String query = "select paydate, value, name from expenses, receivers where receiver=receivers.id;";
            final ResultSet result = statement.executeQuery(query);
            final PrintWriter writer = resp.getWriter();
            writer.println("<html><head><title>Expenses</title></head>");
            writer.println(" <body><h2> Information about expenses </h2></body></html>");

            while (result.next()) {
                String paydate = result.getString(1);
                double value = result.getDouble(2);
                String name = result.getString(3);
                writer.println(" <p> "+paydate + ", value=" + value + ", name=" + name+"</p></body></html>");
            }
            result.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }

    }
}
