import java.util.Objects;

public abstract class Room {
    String name;
    int capacity;

    Room(int capacity, String name) {
        this.capacity = capacity;
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object newRoom) {
        if (this == newRoom) return true;
        if (newRoom == null || getClass() != newRoom.getClass()) return false;
        Room room = (Room) newRoom;
        return Objects.equals(name, room.name);
    }
}


class LectureHall extends Room {
    String typeOfRoom = "Lecture Hall";
    boolean hasVideoProjector;
    LectureHall(int capacity, String name, boolean hasVideoProjector) {
        super(capacity,name);
        this.hasVideoProjector = hasVideoProjector;
    }
    public String toString() {
        return this.name + "(capacity = " + this.capacity + ", " + this.typeOfRoom + ")";
    }
}

class ComputerLab extends Room {
    String operatingSystem;
    String typeOfRoom = "Computer Lab";

    ComputerLab(int capacity, String name, String operatingSystem){
        super(capacity,name);
        this.operatingSystem = operatingSystem;
    }
    public String toString() {
        return this.name + "(capacity = " + this.capacity + ", " + this.typeOfRoom + ")";
    }
}
