package Utils;

import Problem.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LoadCommand extends Command {

    public LoadCommand(String path){
        super(path);
    }
    public  Catalog load(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(new File(path),Catalog.class);
    }

}
