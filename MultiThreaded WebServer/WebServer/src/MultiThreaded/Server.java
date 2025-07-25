package MultiThreaded;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.function.Consumer;

public class Server {

    public Consumer<Socket> getConsumer() {
        return (clientSocket) -> {
            try (
                    PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true)
            ) {
                System.out.println("Handling client " + clientSocket.getRemoteSocketAddress());
                toClient.println("Hello from the server");
            } catch (IOException ex) {
                System.out.println("Error communicating with client: " + clientSocket);
                ex.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.out.println("Failed to close socket: " + clientSocket);
                }
            }
        };
    }

    public static void main(String[] args) {
        int port = 8080;
        Server server = new Server();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setSoTimeout(10000);  // 10 seconds timeout
            System.out.println("Server is listening on port " + port);

            while (true) {
                try {
                    Socket acceptedSocket = serverSocket.accept();
                    Thread thread = new Thread(() -> server.getConsumer().accept(acceptedSocket));
                    thread.start();
                } catch (SocketTimeoutException e) {
                    System.out.println("No client connected in the last 10 seconds. Continuing...");
                }
            }
        } catch (IOException ex) {
            System.out.println("Server failed to start or crashed unexpectedly.");
            ex.printStackTrace();
        }
    }
}
