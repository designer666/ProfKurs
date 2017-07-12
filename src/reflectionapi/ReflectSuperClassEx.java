package reflectionapi;

/**
 * Created by IEvgen Boldyr on 05.07.17.
 */
public class ReflectSuperClassEx {

    public static void main(String[] args) {
        Class cls = StupidUser.class;

        Class spr = cls.getSuperclass();
        System.out.println(spr.getName());
        System.out.println(spr.getPackage());

        Class[] interfaces = cls.getInterfaces();
        for (Class inter : interfaces) {
            System.out.println(inter.getName());
            System.out.println(inter.getPackage());
        }
    }
}
