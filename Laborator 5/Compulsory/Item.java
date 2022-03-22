

public abstract class Item {
    String id;
    String title;
    String location;
    String author;
    int year;


    public Item(String id, String title, String location, String author, int year) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.author = author;
        this.year = year;

    }

    public String toString(){
        return "id: " + this.id + " | title: " + this.title + " | location: " + this.location + " | author: " + this.author + " | year: " + year + "\n";
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
