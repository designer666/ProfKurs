package lan.sync;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by IEvgen Boldyr on 23.06.17.
 */
public class SyncServer {

    private static ServerSocketChannel server;
    private static SocketChannel channel;

    public static void main(String[] args) throws IOException {
        server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(8090));

        Scanner scan = new Scanner(System.in);
        String output, intput;

        channel = server.accept();

        ByteBuffer buf = ByteBuffer.allocate(256);

        do {
            int bytes = 0;
            while ((bytes = channel.read(buf)) > 0) {
                intput = new String(buf.array(), 0, bytes);
                System.out.println("Входящее сообщение: " + intput);
                buf.clear();
                break;
            }

            System.out.print("Исходящее сообщение: ");
            output = scan.nextLine();

            buf.put(output.getBytes());
            buf.flip();
            channel.write(buf);
            buf.clear();


        } while (!output.equals("exit"));
    }
}
