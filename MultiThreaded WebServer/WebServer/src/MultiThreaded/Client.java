package MultiThreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public Runnable getRunnable() {
        return () -> {
            int port = 8080;
            try {
                InetAddress address = InetAddress.getByName("localhost");
                Socket socket = new Socket(address, port);

                try (
                        PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
                        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()))
                ) {
                    // Send message to server
                    toSocket.println("Hello from Client " + socket.getLocalSocketAddress());

                    // Read response from server
                    String line = fromSocket.readLine();
                    System.out.println("Response from Server: " + line);
                }

                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    public static void main(String[] args) {
        Client client = new Client();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(client.getRunnable());
            thread.start();
        }
    }
}
