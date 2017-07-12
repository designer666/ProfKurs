package reflectionapi;

import java.lang.reflect.*;

/**
 * Created by IEvgen Boldyr on 05.07.17.
 */

public class ReflectionExam {

    public static void main(String[] args) {

        try {
            //Получение ссылки на класс.
            //1-й способ, создаем объект и по его имени
            //подключаем класс
            User user = new User("testLogin", "test");
            //getClass().getName() - возвращает полный путь
            //к месторасположению класса. (включая пакеты)
            Class cls = Class.forName(user.getClass().getName());
            //2-й способ
            Class cls2 = String.class;
            Class cls3 = User.class;

            //Получение всех объявленых полей
            //getFields() - вернет массив всех public-полей
            Field[] fields = cls.getFields();
            for (Field field : fields) {
                System.out.println(field.getName());
                System.out.println(field.getType());
            }
            System.out.println("*********************");
            //getDeclaredFields() - все объявленые поля
            Field[] fields2 = cls.getDeclaredFields();
            for (Field field : fields2) {
                System.out.println(Modifier.isPrivate(field.getModifiers()));

                System.out.println(field.getName());
                System.out.println(field.getType());
            }

            //Получение описаных методов
            //Method[] methods = cls.getMethods();
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Имя метода :" + method.getName());
                System.out.println("Кол-во параметров: :" + method.getParameterCount());
                if (method.getParameterCount() > 0) {
                    Parameter[] parameters = method.getParameters();
                    for (Parameter parameter : parameters) {
                        System.out.println(parameter.getName());
                        System.out.println(parameter.getType());
                    }
                }
                System.out.println("Тип возвр. рез.  : :" + method.getReturnType());
            }

            Constructor[] constructors = cls.getConstructors();
            for (Constructor constructor : constructors) {
                System.out.println(constructor.getParameterCount());
            }




        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void refObj(Object object) {

    }
}
