package jdbc;

import jdbc.domain.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IEvgen Boldyr on 07.07.17.
 */
public class SelectQueryExample {

    private static String url = "jdbc:mysql://localhost:3306/javaee002";
    private static String login    = "root";
    private static String password = "root";

    public static void main(String[] args) {
        try {
            Connection conn =
                    DriverManager.getConnection(url, login, password);

            /*Получение данных из БД
            * SELECT <Поля которые необходимо получить>
            * Для получения данных из всех столбцов
            * достаточно указать *
            * FROM <Таблица из которой мы получаем данные>
            * */

            Statement statement = conn.createStatement();
            //Получаем из таблицы PERSON все записи
            ResultSet result =
                    statement.executeQuery("SELECT * FROM PERSON");
            List<Person> persons = new ArrayList<>();
            //Обработка полученного результата
            while (result.next()) {
                persons.add(new Person(
                   result.getInt("ID"),
                   result.getString("NAME"),
                   result.getString("SURNAME"),
                   result.getInt("AGE")
                ));
            }
            //Выводим результат на экран
            for (Person person : persons) {
                System.out.println(person);
            }





        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
