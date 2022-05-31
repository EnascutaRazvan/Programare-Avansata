import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8101;
    public static Boolean serverStop = false;
    public Server() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (!serverStop) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();

                socket.setSoTimeout(1000 * 60);

                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            assert serverSocket != null;
            serverSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
    }
}