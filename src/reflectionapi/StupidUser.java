package reflectionapi;

/**
 * Created by IEvgen Boldyr on 05.07.17.
 */
public class StupidUser extends User
        implements Inter1, Inter2 {

    public StupidUser(String login) {
        super(login, login);
    }


}
