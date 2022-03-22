import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main (String[] args) throws IOException {
        ArrayList<Item> allItems = new ArrayList<>();

        Catalog catalog = new Catalog("MyCatalog");

        Item item1 = new Book("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps", "Donald E. Knuth", 1965);

        catalog.add(item1);

        CatalogUtil.save(catalog,"C:\\Users\\Razvan-PC\\Desktop\\Lab5\\src\\main\\Json\\JsonCatalog.json");
        System.out.println(catalog.allItems.toString());
    }
}
