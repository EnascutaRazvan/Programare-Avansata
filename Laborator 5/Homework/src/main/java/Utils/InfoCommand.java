package Utils;


import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class InfoCommand extends Command{

    public InfoCommand(){}

    public void info() {
        try {
            File file = new File("C:\\Users\\Razvan-PC\\Desktop\\Faculta\\Anul 2\\Sem2\\PA\\Lab5\\Homework\\src\\main\\Json\\JsonCatalog.json");
            Parser parser = new AutoDetectParser();
            BodyContentHandler handler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            FileInputStream inputStream = new FileInputStream(file);
            ParseContext context = new ParseContext();

            parser.parse(inputStream, handler, metadata, context);

            System.out.println(handler);

            String[] metadataNames = metadata.names();

            for(String name: metadataNames)
                System.out.println(name + ":" + metadata.get(name));



        } catch (IOException | SAXException | TikaException err){
            System.out.println(err);
        }


    }
}
