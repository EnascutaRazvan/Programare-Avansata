import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class ClientThread extends Thread {
    private Socket socket = null;
    private User user = null;

    private String loginUser(String username) {
        User user = new User(username);
        this.user = user;
        return "Logged in successfully !";
    }

    private boolean isLoggedIn() {
        return user != null;
    }

    private String getUsername() {
        return this.user.getName();
    }

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            String request = "";
            String response = "";

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            while (!socket.isClosed()) {
                request = in.readLine();
                String[] requestList;

                if (request != null) {
                    requestList = request.split(" ");

                    switch (requestList[0]) {

                        case "register":
                            if (requestList.length < 2) {
                                response = "Please provide an username !";
                            } else {
                                String username = requestList[1];
                                response = VirtualDB.RegisterUser(username);
                            }
                            break;

                        case "login":
                            if (requestList.length < 2) {
                                response = "Please provide an username !";
                            } else {
                                String username = requestList[1];
                                boolean userExists = VirtualDB.FindUser(username);
                                if (userExists) {
                                    response = loginUser(username);
                                } else {
                                    response = "User with such name not found !";
                                }
                            }
                            break;
                        case "friend":
                            if (requestList.length < 2) {
                                response = "Please provide a list of friends !";
                            } else {
                                List<User> friends = new ArrayList();
                                for (int i = 1; i < requestList.length; ++i) {
                                    User friend = new User(requestList[i]);
                                    friends.add(friend);
                                }

                                if (this.isLoggedIn()) {
                                    response = VirtualDB.AddFriends(getUsername(), friends);
                                    List<User> mainFriend = new ArrayList();
                                    mainFriend.add(new User(getUsername()));
                                    for(int i = 1; i < requestList.length; ++i) {
                                        VirtualDB.AddFriends(requestList[i], mainFriend);
                                    }
                                } else {
                                    response = "You are not logged in !";
                                }
                            }
                            break;
                        case "send":
                            if (requestList.length < 2) {
                                response = "Please provide a message !";
                            } else {
                                if (this.isLoggedIn()) {

                                    for (int i = 1; i < requestList.length; ++i) {
                                        VirtualDB.SendMessage(getUsername(), requestList[i]);
                                    }
                                    response = "Messages sent successfully !";
                                } else {
                                    response = "You are not logged in !";
                                }
                            }
                            break;
                        case "read":
                            List<String> messages = new ArrayList();
                            if (this.isLoggedIn()) {

                                messages = VirtualDB.readMessages(getUsername());

                                StringBuilder temp = new StringBuilder();
                                for (int i = 0; i < messages.size(); ++i) {
                                    temp.append(messages.get(i)).append(" ");
                                }
                                response = String.valueOf(temp);
                            } else {
                                response = "You are not logged in !";
                            }
                            break;
                        case "stop":
                            response = "Server will stop once all clients disconnect";
                            Server.serverStop = true;
                            break;
                        case "exit":
                            response = "Client quit";
                            socket.close();
                            break;
                        default:
                            response = "Wrong command, try again!";
                            break;
                    }
                }
                out.println(response);
                out.flush();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}