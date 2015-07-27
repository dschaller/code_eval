import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.StringBuilder;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        printUniqueElementsIn(linesFromFile(args[0]));
    }

    private static List<String> linesFromFile(String filename) {
        Path filePath = Paths.get(filename);
        try {
            return Files.readAllLines(filePath, Charset.forName("UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException("Could not read file: " + filename);
        }
    }

    private static void printUniqueElementsIn(List<String> lines) {
        for (String line : lines)
            System.out.println(uniqueElementsIn(line));
    }

    private static String uniqueElementsIn(String line) {
            List<String> uniqueElements = new ArrayList<String>();
            List<String> values = Arrays.asList(line.split(SEPARATOR));
            for (String value : values)
                if (!uniqueElements.contains(value)) uniqueElements.add(value);
            StringBuilder builder = new StringBuilder();
            Iterator iterator = uniqueElements.iterator();
            while (iterator.hasNext()) {
                builder.append(iterator.next());
                if (iterator.hasNext()) builder.append(SEPARATOR);
            }
            return builder.toString();
    }

    private static final String SEPARATOR = ",";
}
