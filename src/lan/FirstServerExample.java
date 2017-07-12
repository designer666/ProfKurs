package lan;

import java.io.IOException;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by IEvgen Boldyr on 23.06.17.
 */
public class FirstServerExample {

    /* Серверная часть отличается от клиентской части
    * на этапе создания.
    * Когда мы создаем приложение клиент, нам нужен IP + Port
    * В сучае с сервером нам необходимо указать
    * порт, который будет прослушивать компьютер
    *
    * Порты с 1-1029 - зарезервированы системой
    * Рекомендуется к использованию
    * 8081 ... 65536
    *
    * localhost - 127.0.0.1 */

    public static void main(String[] args) throws IOException {
        //Класс ServerSocketChannel - позволяет подготовить канал
        //для прослушивания и получения данных из сети
        ServerSocketChannel channel = ServerSocketChannel.open();
        //Метод bind() - позволяет произвести настройку порта
        channel.bind(new InetSocketAddress(8089));
        //Метод accept() - отвечает за захват соеденения с клиентом
        System.out.println("Создаем серевер и ждем соеденение с" +
                "клиентом");
        SocketChannel sc = channel.accept();
        System.out.println("Соеденение установлено.");

        ByteBuffer buffer = ByteBuffer.allocate(128);
        int bytes = 0;
        while ((bytes = sc.read(buffer)) > 0) {
            buffer.flip();
            String input = new String(buffer.array(), 0, bytes);
            System.out.println(input);
        }
    }
}
