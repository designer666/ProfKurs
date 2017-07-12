package lan;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by IEvgen Boldyr on 23.06.17.
 *
 * Cетевое взаимодейтвие
 *
 * Понятие протокола - набор правил, для интерактивного
 * обмена информацией между компьютерами в пределах
 * локальной либо глобальной сети.
 *
 * Протокол TCP/IP:
 *
 * Transmission Control Protocol - гарантирует передачу данных
 * Internet Protocol - решает задачу коммуникации между сетями
 *
 * IPv4 - по маске ХХХ.ХХХ.ХХХ.ХХХ
 * данная маска является форматом адреса.
 * 192.168.0.1
 *
 */

public class LAN {

    public static void main(String[] args) throws IOException {
        //Класс SocketChannel - позволяет организовать
        //передачу данных между компьютерами внутри
        //локальной сети
        SocketChannel channel =
                SocketChannel.open(
                        new InetSocketAddress(
                                "127.0.0.1", 8089));

        String message = "Первое текстовое сообщение";
        //Класс ByteBuffer - позволяет нам преобразовать информацию
        //в поток байтов для передачи данных по сети
        ByteBuffer buffer = ByteBuffer.allocate(128);
        //Методом put() помещаем информацию в буфер для дальнейшей
        //отправки
        buffer.put(message.getBytes());
        //Подготавливаем данные для отправки
        buffer.flip();
        //Отправляем данные на сервер
        channel.write(buffer);
        //Очищаем данные в буфере
        buffer.clear();
    }
}
