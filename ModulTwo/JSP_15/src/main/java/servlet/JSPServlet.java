package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class JSPServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter out = resp.getWriter();
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

            ArrayList<String> data = new ArrayList<>();

            while (result.next()) {
                String paydate = result.getString(1);
                double value = result.getDouble(2);
                String name = result.getString(3);
                String str = (paydate + ", value=" + value + ", name=" + name);
                data.add(str);
            }
            req.setAttribute("data", data);
            req.getRequestDispatcher("/jsp/expenses.jsp").forward(req, resp);

            result.close();
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            out.println("There is no connection to the database.");
        } catch (IOException | ServletException e) {
            out.println("Something went wrong.");

        }
    }
}