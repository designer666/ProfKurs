package reflectionapi;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by IEvgen Boldyr on 05.07.17.
 */
public class StringReflectEx {

    public static void main(String[] args) {
        Class cls = String.class;

        //Количество объявленых полей
        Field[] fields = cls.getDeclaredFields();
        int pub = 0, prot = 0, priv = 0, stat = 0;
        for (Field field : fields) {
            //Делаем подсчет всех объявленых полей класса
            //по основным модификаторам
            if (Modifier.isPublic(field.getModifiers())) {
                pub++;
            } else if (Modifier.isProtected(field.getModifiers())) {
                prot++;
            } else if (Modifier.isPrivate(field.getModifiers())) {
                priv++;
            }

            /*if (Modifier.isStatic(field.getModifiers())) {
                stat++;
            }*/
        }

        System.out.println("public    : " + pub);
        System.out.println("protected : " + prot);
        System.out.println("private   : " + priv);
        /*System.out.println("static   : " + stat);*/

    }
}
