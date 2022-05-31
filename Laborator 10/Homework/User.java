import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<User> friends = new ArrayList();
    private List<String> messages = new ArrayList();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
    public void addFriends(List<User> friendsList) {
        this.friends.addAll(friendsList);
    }

    public List getMessages() {
        return messages;
    }

    public void setMessage(String message) {
        this.messages.add(message);
    }
}
