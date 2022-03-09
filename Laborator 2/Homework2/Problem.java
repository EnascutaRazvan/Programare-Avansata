import java.util.Arrays;

public class Problem {
    public Room[] rooms;

    public Event[] events;

    public void setRooms(Room... newRoom){
        int position = 0;
        boolean foundTwice = false;
        // Creating a temporary array for verifying if there are duplicated rooms
        Room[] tempRooms = new Room[newRoom.length];
        for(int i = 0; i < newRoom.length; i++){
            foundTwice = false;
            for(int j = 0; j < i; j++){
                if(newRoom[i].equals(newRoom[j])) {
                    foundTwice = true;
                    System.out.println("The room " + newRoom[j].name + " already exists!");
                    break;
                }
            }
            if(!foundTwice)
               tempRooms[i] =  newRoom[i];
        }
        int notNullObj = 0;
        for(Room room : tempRooms)
            if(room != null)
                notNullObj++;
        Room[] removeNullObj = new Room[notNullObj];

        for(int i = 0; i< tempRooms.length; i++)
            if(tempRooms[i] != null)
                removeNullObj[i] = tempRooms[i];

            rooms = removeNullObj;

    }
    public void setEvents(Event... newEvent){
        Event[] tempEvents = new Event[newEvent.length];
        boolean foundTwice;
        for(int i = 0; i < newEvent.length; i++){
            foundTwice = false;
            for(int j = 0; j < i; j++){
                if(newEvent[i].equals(newEvent[j])) {
                    foundTwice = true;
                    System.out.println("The event " + newEvent[j].name + " already exists!");
                    break;
                }
            }
            if(!foundTwice)
                tempEvents[i] = newEvent[i];
        }
        int notNullObj = 0;
        for(Event event : tempEvents)
            if(event != null)
                notNullObj++;
        Event[] removeNullObj = new Event[notNullObj];

        for(int i = 0; i< tempEvents.length; i++)
            if(tempEvents[i] != null)
                removeNullObj[i] = tempEvents[i];

        events = removeNullObj;


    }

    public void addRoom (Room newRoom){
        boolean theRoomsAreEqual = false;
        Room[] auxRooms = new Room[rooms.length + 1];


        for (int i = 0; i < rooms.length; i++){
            if (rooms[i].equals(newRoom)) {
                theRoomsAreEqual = true;
                break;
            }
            auxRooms[i] = this.rooms[i];
        }


        if (!theRoomsAreEqual) {
            auxRooms[rooms.length] = newRoom;
            rooms = auxRooms;
        }

    }

    public void addEvent (Event newEvent){
        boolean theEventsAreEqual = false;
        Event[] auxEvents = new Event[events.length + 1];


        for (int i = 0; i < events.length; i++){
            if (events[i].equals(newEvent)) {
                theEventsAreEqual = true;
                break;
            }
            auxEvents[i] = this.events[i];
        }


        if (!theEventsAreEqual) {
            auxEvents[events.length] = newEvent;
            events = auxEvents;
        }
    }
    public String toString() {
        return "allEvents = " + Arrays.toString(events) +
                "\nallRooms = " + Arrays.toString(rooms) +
                '}';
    }


}
