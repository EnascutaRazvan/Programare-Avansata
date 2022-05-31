import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException {

        FileExplorer explorer = new FileExplorer();
        PrototypeMaker prototype = new PrototypeMaker();
        Tester tester = new Tester();

        List<String> classNames = explorer.list("C:\\Users\\Razvan-PC\\Documents\\Programare-Avansata\\Laborator 12\\Homework\\maven\\target\\classes");

        List<String> prototypes = prototype.make(classNames);

        prototypes.forEach(p -> {
            System.out.println(p);
        });

        for (String className : classNames) {
            tester.test(className);
        }
    }
}

