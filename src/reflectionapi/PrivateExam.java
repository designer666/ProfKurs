package reflectionapi;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by IEvgen Boldyr on 05.07.17.
 */
public class PrivateExam {

    public static void main(String[] args) throws IllegalAccessException {
        class SomeClass {
            private /*final*/ String param = "private";

            public String getParam() {
                return param;
            }
        }

        SomeClass someClass = new SomeClass();
        System.out.println(someClass.getParam());
        Field[] fields = someClass.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isPrivate(field.getModifiers()))   {
                field.setAccessible(true);
                field.set(someClass, new String("reflection"));
                field.setAccessible(false);
            }
        }
        System.out.println(someClass.getParam());
    }

}
