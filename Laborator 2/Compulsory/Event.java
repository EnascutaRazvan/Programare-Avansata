public class Event {
    String name;
    int size;
    int startTime;
    int endTime;

    Event(int size, int startTime, int endTime) {
        this.size = size;
        this.startTime = startTime;
        this.endTime = endTime;
        Singleton.Counter.incrementEvents();
        this.name = "Event" + Singleton.Counter.countEvents;
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
    public String toString() {
        return "The name of this event is " + "\"" + this.name + "\"" + "\n"
                + "The size of the event is " + this.size + "\n"
                + "The startTime is " + this.startTime
                + "\n" + "The endTime is " + this.endTime;
    }
}
