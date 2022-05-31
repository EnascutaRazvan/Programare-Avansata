import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private final static String EXIT = "exit";
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        int PORT = 8101;
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))) {
            String request = "";
            String response = "";

            Scanner scanner = new Scanner(System.in);

            while (!request.equals("exit")) {
                System.out.print("Command: ");

                request = scanner.nextLine();
                out.println(request);

                response = in.readLine();
                System.out.println(response);
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}
