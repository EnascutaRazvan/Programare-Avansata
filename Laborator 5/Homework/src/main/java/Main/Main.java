package Main;

import Problem.Catalog;
import Problem.Item;
import Problem.Book;
import Utils.*;

import javax.swing.text.View;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        List<Item> allItems = new ArrayList<>();

        Catalog catalog = new Catalog("MyCatalog");

        Item item1 = new Book("1", "Taboos_and_Issues", "C:\\Users\\Razvan-PC\\Desktop\\Faculta\\Anul 2\\Sem2\\PA\\Lab5\\Homework\\src\\main\\resources\\Taboos_and_Issues.pdf", "Thomson Heinle", 1965);
        Item item2 = new Book("2", "Taboos_and_Issues", "C:\\Users\\Razvan-PC\\Desktop\\Faculta\\Anul 2\\Sem2\\PA\\Lab5\\Homework\\src\\main\\resources\\Taboos_and_Issues.pdf", "Thomson Heinle", 1965);

        String path = "C:\\Users\\Razvan-PC\\Desktop\\Faculta\\Anul 2\\Sem2\\PA\\Lab5\\Homework\\src\\main\\Json\\JsonCatalog.json";
        Command listCommand = new ListCommand(catalog);
        Command loadCommand = new LoadCommand(path);
        Command saveCommand = new SaveCommand(catalog, path);
        Command viewCommand = new ViewCommand(item1.getLocation());
        Command infoCommand = new InfoCommand();

       // catalog.add(item1);
       // catalog.add(item2);

        catalog = ((LoadCommand) loadCommand).load(path);
        ((ListCommand) listCommand).list(catalog);
        //((InfoCommand) infoCommand).info();
        //((ViewCommand) viewCommand).view(item1);
        //((ViewCommand) viewCommand).view(item2);
        //((SaveCommand) saveCommand).save(catalog,path);
    }
}
