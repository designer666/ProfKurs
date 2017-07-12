package junit;

import junit.domain.User;

/**
 * Created by IEvgen Boldyr on 21.06.17.
 */
public class FactoryUsers {

    public static User create(String login, String password) {
        return new User(login, password);
    }

    public static User createNull() {
        return null;
    }
}
