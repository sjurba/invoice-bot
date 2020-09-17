import java.io.*;
import java.util.*;

public class FileParser<T> {

    private final LineHandler<T> lineHandler;

    public FileParser(LineHandler<T> lineHandler) {
        this.lineHandler = lineHandler;
    }

    public List<T> parseFile(File folder, String filename) {
        List<T> list = new ArrayList<T>();
        try {
            File file = new File(filename);
            BufferedReader reader = new BufferedReader(new FileReader(new File(folder, filename)));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) continue;
                String[] split = line.split(";");
                list.add(lineHandler.handleLine(split));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
