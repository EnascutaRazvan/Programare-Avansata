import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VirtualDB {
    private static final List<User> users = new ArrayList<>();

    public static String RegisterUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name))
                return "User with this name already exists !";
        }
        User user = new User(name);
        users.add(user);
        return "You were registered successfully";
    }

    public static boolean FindUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name))
                return true;
        }
        return false;
    }

    public static String AddFriends(String name, List<User> friends) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                user.addFriends(friends);
                break;
            }
        }

        return "Friends added successfully !";
    }

    public static String SendMessage(String name, String message) {
        List<User> friends = new ArrayList();
        for (User user : users) {
            if (user.getName().equals(name)) {
                friends = user.getFriends();
                break;
            }
        }

        for (User friend : friends) {
            for (User user : users) {
                if (friend.getName().equals(user.getName())) {
                    user.setMessage(message);
                }
            }
        }
        return "Message sent successfully";
    }

    public static List readMessages(String name) {
        List<String> messages = new ArrayList();
        for (User user : users) {
            if (user.getName().equals(name)) {
                messages = user.getMessages();
                break;
            }
        }
        return messages;
    }

}