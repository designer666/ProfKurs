package junit;

import java.util.concurrent.TimeUnit;

/**
 * Created by IEvgen Boldyr on 21.06.17.
 */
public class CalcCPU {

    public static int calc(int a, char o, int b) {
        switch (o) {
            case '+' :  return a + b;
            case '-' :  return a - b;
            case '*' :  return a * b;
            case '/' :  return a / b;
        }
        return 0;
    }

    public static void method() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
