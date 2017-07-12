package jdbc;

import jdbc.domain.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IEvgen Boldyr on 07.07.17.
 */
public class InsertQueryExample {

    private static String url = "jdbc:mysql://localhost:3306/javaee002";
    private static String login    = "root";
    private static String password = "root";

    public static void main(String[] args) {
        try (Connection conn =
                     DriverManager.getConnection(url, login, password)) {
            List<Person> persons = new ArrayList<>();
            persons.add(new Person(null, "test1", "test1", 1000));
            persons.add(new Person(null, "test2", "test2", 1000));
            persons.add(new Person(null, "test3", "test3", 1000));

            PreparedStatement statement =
                    conn.prepareStatement(
                            "INSERT INTO PERSON (NAME, SURNAME, AGE)" +
                            "VALUES (?, ?, ?)");

            for (Person person : persons) {
                statement.setString(1, person.getName());
                statement.setString(2, person.getSurname());
                statement.setInt(3, person.getAge());
                statement.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
