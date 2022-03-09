import java.util.Objects;

public class Event {
    String name;
    int size;
    int startTime;
    int endTime;


    Event(int size, int startTime, int endTime) {
        this.size = size;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return this.size;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(name, event.name);
    }

    @Override
    public String toString() {
        return this.name + "(size = " + this.size + ", startTime = " + this.startTime + ", endTime = " + this.endTime + ")";
    }
}
