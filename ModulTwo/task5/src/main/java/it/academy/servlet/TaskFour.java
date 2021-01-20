package it.academy.servlet;

import java.sql.*;

import static javax.servlet.SessionTrackingMode.URL;
import static sun.net.ftp.FtpDirEntry.Permission.USER;

public class TaskFour {

    public static void main(String[] args) {
        String num = args[0];

        String date = args[1];

        String receiver = args[2];

        String value = args[3];

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            final Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            final Statement statement = connection.createStatement();


            String dateQuery = "('" + date + "'" + "," + receiver + "," + value + ")";
            String query = "insert into usp.expenses (num, paydate, receiver, value) \n" +
                    "values" + dateQuery + ";";

            final int result = statement.executeUpdate(query);

            final ResultSet resultPrint = statement.executeQuery("select * from expenses;");

            while (resultPrint.next()) {
                String num = resultPrint.getInt(1);
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
