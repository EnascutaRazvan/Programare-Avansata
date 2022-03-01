class Singleton {
    static Singleton Counter = new Singleton();
    int countRooms;
    int countEvents;

    private Singleton() {
    }

    public static Singleton getInstance() {
        return Counter;
    }

    public void incrementRooms() {
        this.countRooms++;
    }

    public void incrementEvents() {
        this.countEvents++;
    }
}

public class Room {
    String name;
    int capacity;
    Type typeOfRoom;

    public enum Type {LECTUREHALL, LAB}

    Room(int capacity, Type typeOfRoom) {
        this.capacity = capacity;
        this.typeOfRoom = typeOfRoom;
        Singleton.Counter.incrementRooms();
        this.name = "R" + Singleton.Counter.countRooms;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = Type.valueOf(typeOfRoom);
    }

    public int getCapacity() {
        return this.capacity;
    }

    public Type getTypeOfRoom() {
        return this.typeOfRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypeOfRoom(Type typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    @Override
    public String toString() {
        return "The name of room is " + this.name + "\n"
                + "This room is a " + "\"" + typeOfRoom + "\""
                + "\n" + "The capacity of this room = " + this.capacity;
    }


}
