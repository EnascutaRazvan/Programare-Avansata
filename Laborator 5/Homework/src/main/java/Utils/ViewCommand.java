package Utils;

import Problem.Item;

import java.awt.*;
import java.io.IOException;

public class ViewCommand extends Command{
    public ViewCommand(String path){
        super(path);
    }
    public  void view(Item item) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.open(item.file);
    }
}
