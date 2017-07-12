package javafx.listviewex.entity;

/**
 * Created by IEvgen Boldyr on 07.06.17.
 */
public class User {

    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Login : " + login + " Password : " + password;
    }
}
