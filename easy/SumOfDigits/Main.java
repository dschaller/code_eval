
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        sumNumberOfRowsIn(linesFromFile(args[0]));
    }

    private static List<String> linesFromFile(String filename) {
        Path filePath = Paths.get(filename);
        try {
            return Files.readAllLines(filePath, Charset.forName("UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException("Could not read file: " + filename);
        }
    }

    private static void sumNumberOfRowsIn(List<String> lines) {
        for (String line : lines)
            System.out.println(totalOfNumbersIn(line));
    }

    private static int totalOfNumbersIn(String line) {
        int lineLength = line.length();
        if (lineLength == 1) return Character.getNumericValue(line.charAt(0));
        return totalOfNumbersIn(line.substring(0, lineLength-1)) + Character.getNumericValue(line.charAt(lineLength-1));
    }
}
