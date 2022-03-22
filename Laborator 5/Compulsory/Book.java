public class Book extends Item{
    String id;
    String title;
    String location;
    String author;
    int year;

    public Book(String id, String title, String location, String author, int year) {
        super(id, title, location, author, year);
    }
}