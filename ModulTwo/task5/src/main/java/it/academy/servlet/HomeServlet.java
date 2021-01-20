package it.academy.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet(name = "HomeServlet", urlPatterns = "/expenses")
public class HomeServlet extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/ups?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            final Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            final Statement statement = connection.createStatement();

            String query = "select paydate, value, name from expenses, receivers where receiver=receivers.id;";


            final ResultSet result = statement.executeQuery(query);

            final PrintWriter writer = resp.getWriter();
            while (result.next()) {
                String paydate = result.getString(1);
                double value = result.getDouble(2);
                String name = result.getString(3);
                writer.println("date: " + paydate + ", value=" + value + ", name=" + name);
            }

            result.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }

}
