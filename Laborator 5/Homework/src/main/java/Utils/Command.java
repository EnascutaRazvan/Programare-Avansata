package Utils;

import Problem.Catalog;
import Problem.Item;

public abstract class Command{
    protected Item item;
    protected Catalog catalog;
    protected String path;

    protected Command(Catalog catalog, Item item){
        this.catalog = catalog;
        this.item = item;
    }

    protected Command(Item item){
        this.item = item;
    }

    protected Command(Catalog catalog){
        this.catalog = catalog;
    }

    protected Command(Catalog catalog, String path){
        this.catalog = catalog;
        this.path = path;
    }

    protected Command(String path){
        this.path = path;
    }
    protected Command(){}

    public void setItem(Item item) {
        this.item = item;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Item getItem() {
        return item;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public String getPath() {
        return path;
    }




}
