package junit.domain;

/**
 * Created by IEvgen Boldyr on 21.06.17.
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

    public boolean equals(User usr) {
        if (login.equals(usr.login)
                && password.equals(usr.password)) {
            return true;
        }
        return false;
    }
}
