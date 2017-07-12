package jdbc.domain;

/**
 * Created by IEvgen Boldyr on 07.07.17.
 */
public class Person {

    private Integer id;
    private String name;
    private String surname;
    private Integer age;

    public Person(Integer id, String name, String surname, Integer age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name    : " + name + "\nSurname : " + surname;
    }
}
