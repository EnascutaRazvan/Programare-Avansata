package Utils;

import Problem.Catalog;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;

public class SaveCommand extends Command {
    public SaveCommand(Catalog catalog, String path){
        super(catalog, path);
    }
    public  void save(Catalog catalog, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());

        writer.writeValue(new File(path), catalog);
    }
}
