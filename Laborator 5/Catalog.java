import java.util.ArrayList;

public class Catalog implements commands {
    ArrayList<Item> allItems;
    String name;

    public void setAllItems(ArrayList<Item> allItems) {
        this.allItems = allItems;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getAllItems() {
        return allItems;
    }

    public String getName() {
        return name;
    }

    public Catalog(String name) {
        this.name = name;
        this.allItems = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        this.allItems.add(item);
    }

    @Override
    public String toString() {
        return this.allItems.toString();
    }

    @Override
    public Item findById(String id) {
        for (Item item : allItems)
            if (item.getId().equals(id))
                return item;
        return null;
    }

}
