import java.util.Arrays;

public class Lab2 {
    public static void main(String args[]) {
        Room room1 = new Room(30, Room.Type.LAB);
        Room room2 = new Room(30, Room.Type.LAB);
        Room room3 = new Room(30, Room.Type.LAB);
        Room room4 = new Room(100, Room.Type.LECTUREHALL);

        Event C1 = new Event(100, 8, 10);
        Event C2 = new Event(100, 10, 12);
        Event C3 = new Event(30, 8, 10);
        Event C4 = new Event(30, 8, 10);
        Event C5 = new Event(30, 10, 12);

        Room[] rooms = new Room[Singleton.Counter.countRooms];

        rooms[0] = room1;
        rooms[1] = room2;
        rooms[2] = room3;
        rooms[3] = room4;

        Event[] events = new Event[Singleton.Counter.countEvents];

        events[0] = C1;
        events[1] = C2;
        events[2] = C3;
        events[3] = C4;
        events[4] = C5;

        for (Room room : rooms) {
            System.out.println(room + "\n");
        }

        System.out.println("\n");

        for (Event event : events) {
            System.out.println(event + "\n");
        }
    }

}
