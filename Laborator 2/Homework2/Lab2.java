import java.util.Arrays;

public class Lab2 {
    public static void main (String[] args){
        Room l1 = new LectureHall(30, "l1",true);
        Room l2 = new LectureHall(50, "l2",true);
        Room l3 = new LectureHall(100, "l3",true);
        Room l4 = new LectureHall(100, "l4",true);
        Room l5 = new ComputerLab(100, "comp1","linux");

        Event C1 = new Event(100,8,10);
        C1.setName("C1");
        Event C2 = new Event(50,8,10);
        C2.setName("C2");
        Event C3 = new Event(120,8,10);
        C3.setName("C3");
        Event C4 = new Event(50,8,10);
        C4.setName("C3");

        Problem problema = new Problem();

        problema.setRooms(l1,l2,l3,l2);
        problema.setEvents(C1,C2,C3,C4);

        System.out.println(problema);

    }
}

    /*
    OUTPUT:
    The room l2 already exists!
    The event C3 already exists!
    allEvents = [C1(size = 100, startTime = 8, endTime = 10), C2(size = 50, startTime = 8, endTime = 10), C3(size = 120, startTime = 8, endTime = 10)]
    allRooms = [l1(capacity = 30, Lecture Hall), l2(capacity = 50, Lecture Hall), l3(capacity = 100, Lecture Hall)]}
     */