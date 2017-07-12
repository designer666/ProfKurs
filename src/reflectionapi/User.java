package reflectionapi;

/**
 * Created by IEvgen Boldyr on 05.07.17.
 */
public class User {


    public String login;
    protected Integer age;
    private String password;


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }
}
