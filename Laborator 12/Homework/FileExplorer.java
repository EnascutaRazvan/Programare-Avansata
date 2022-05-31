import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileExplorer {
    public List<String> listOfFiles(File dirPath) {
        File filesList[] = dirPath.listFiles();
        List<String> classNames = new ArrayList();
        for (File file : filesList) {
            if (file.isFile() && file.getName().endsWith(".class")) {
                classNames.add(file.getName());
            } else {
                listOfFiles(file);
            }
        }
        return classNames;
    }

    public List<String> list(String path) throws IOException {
        List<String> classNames = new ArrayList();

        Stream<Path> paths = Files.find(Paths.get(path), Integer.MAX_VALUE, (filePath, fileAttr) -> fileAttr.isRegularFile());
                paths.forEach(p -> classNames.add(String.valueOf(p.getFileName()).split("\\.")[0]));
        return classNames;
    }
}
