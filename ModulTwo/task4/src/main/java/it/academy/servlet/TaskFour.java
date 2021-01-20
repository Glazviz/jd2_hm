package it.academy.servlet;

import java.sql.*;

public class TaskFour {

    private static final String URL = "jdbc:mysql://localhost:3306/ups?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

        String dateArg = args[0];

        String receiver = args[1];
        int receiverArg = Integer.parseInt(receiver);

        String values = args[2];
        double valueArg = Double.parseDouble(values);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            final Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            final Statement statement = connection.createStatement();


            String dateQuery = "('" + dateArg + "'" + "," + receiverArg + "," + valueArg + ")";
            String query = "insert into ups.expenses (paydate,receiver,value) \n" +
                    "values" + dateQuery + ";";

            final int result = statement.executeUpdate(query);

            final ResultSet resultPrint = statement.executeQuery("select * from expenses;");

            while (resultPrint.next()) {

                String paydate = resultPrint.getString(2);
                double value = resultPrint.getDouble(3);
                String name = resultPrint.getString(4);
                System.out.println("date: " + paydate + ", value=" + value + ", name=" + name);
            }

            resultPrint.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}