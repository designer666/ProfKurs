package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by IEvgen Boldyr on 07.07.17.
 */
public class ConnectionDriverTest {

    private static String url = "jdbc:mysql://localhost:3306/javaee002";
    private static String login    = "root";
    private static String password = "root";

    private static Connection connection;

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Драйвер найден! Попытка установки соеденения...");
        } catch (ClassNotFoundException e) {
            System.out.println("Драйвер не подключен!");
        }

        try {
            connection = DriverManager.getConnection(url, login, password);

        } catch (SQLException e) {
            System.out.println("Соеденение не установлено!");
        } finally {
            if (connection != null) {
                System.out.println("Соеденение установлено!");
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
