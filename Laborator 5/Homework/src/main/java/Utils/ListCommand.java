package Utils;

import Problem.Catalog;
import Problem.Item;

public class ListCommand extends Command{

    public ListCommand(Catalog catalog){
        super(catalog);
    }
    public void list(Catalog catalog){
        for(Item item : catalog.allItems)
            System.out.print(item.toString());
    }
}
