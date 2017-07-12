package reflectionapi;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by IEvgen Boldyr on 05.07.17.
 */
public class ReflectPractice {

    public static void main(String[] args) {
        reflectObj(new Thread());
    }

    public static void reflectObj(Object object) {
        System.out.println("*************** " + object.getClass().getName() + " ***************");
        int pub = 0, pro = 0, pri = 0;
        for (Field field : object.getClass().getDeclaredFields()) {
            if (Modifier.isPublic(field.getModifiers())) pub++;
            else if (Modifier.isProtected(field.getModifiers())) pro++;
            else if (Modifier.isPrivate(field.getModifiers())) pri++;
        }
        System.out.println("Fields - public :" + pub + " protected : " + pro + " private : " + pri);
        System.out.println("Constructors (amount) :" + object.getClass().getConstructors().length);
        for (Method method : object.getClass().getMethods()) {
            System.out.println("Method name: " + method.getName() + " Params : " + method.getParameterCount());
        }
        System.out.println("Interfaces (amount) : " + object.getClass().getInterfaces().length);
        for (Class inter : object.getClass().getInterfaces()) {
            System.out.println("Interface : " + inter.getName());
        }
        System.out.println("Superclass (name) : " + object.getClass().getSuperclass().getName());
    }
}
