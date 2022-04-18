package Problem;



import java.util.ArrayList;
import java.util.List;

public class Catalog {
    public List<Item> allItems;
    String name;

    public Catalog(String name) {
        this.name = name;
        this.allItems = new ArrayList<>();
    }

    public Catalog(){
        super();
    }

    public void setAllItems(List<Item> allItems) {
        this.allItems = allItems;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getAllItems() {
        return allItems;
    }

    public void add(Item item){this.allItems.add(item);}

    public String getName() {
        return name;
    }



}
