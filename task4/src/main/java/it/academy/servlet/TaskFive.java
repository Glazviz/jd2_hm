package it.academy.servlet;

import java.sql.*;

public class TaskFive {

    private static final String URL = "jdbc:mysql://localhost:3306/usp?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        String num = args[0];

        String date = args[1];

        String receiver = args[2];

        String values = args[3];

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            final Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            final Statement statement = connection.createStatement();

            String template = "insert into usp.expenses (num, paydate,receiver,value) \n" +
                    "values (?, ?, ?, ?)";

            PreparedStatement pStatement = connection.prepareStatement(template);
            pStatement.setInt(1, Integer.parseInt(num));
            pStatement.setString(2, date);
            pStatement.setInt(3, Integer.parseInt(receiver));
            double value = 0;
            pStatement.setDouble(4, value);

            final int result = pStatement.executeUpdate();

            final ResultSet resultPrint = statement.executeQuery("select * from expenses;");

            while (resultPrint.next()) {

                num = resultPrint.getString(1);
                String paydate = resultPrint.getString(2);
                value = resultPrint.getDouble(3);
                String name = resultPrint.getString(4);
                System.out.println("num" + num + "date: " + paydate + ", value=" + value + ", name=" + name);
            }
            pStatement.close();
            resultPrint.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}