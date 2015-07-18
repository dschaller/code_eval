import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        sumIntegersInFile(args[0]);
    }

    private static void sumIntegersInFile(String filename) {
        List<String> lines = linesFromFile(filename);
        int total = 0;
        for (String line : lines) total += Integer.valueOf(line);
        System.out.println(total);
    }

    private static List<String> linesFromFile(String filename) {
        Path filePath = Paths.get(filename);
        try {
            return Files.readAllLines(filePath, Charset.forName("UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException("Could not read file: " + filename);
        }
    }
}
