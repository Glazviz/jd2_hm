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
import java.util.List;

public class ServletShop extends HttpServlet {

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

            List<ServletExpense> data = new ArrayList<>();

            while (result.next()) {
                String paydate = result.getString(1);
                req.setAttribute("paydate", paydate);

                double value = result.getDouble(2);
                req.setAttribute("value", value);

                String name = result.getString(3);
                req.setAttribute("name ", name );

                ServletExpense expense = new ServletExpense();
                expense.setPaydate(paydate);
                expense.setValue(value);
                expense.setName(name);
                data.add(expense);
            }
            req.setAttribute("data", data);
            req.getRequestDispatcher("/jsp/expenses.jsp").forward(req, resp);

            result.close();
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
          out.println("There is no connection to the database");
        } catch (IOException | ServletException e) {
           out.println("Something is wrong.");

        }
    }
}