import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        List<String> lines = readLinesFrom(args[0]);
        for (String line : lines) {
            String[] inputs = splitInput(line);
            printLastIndexOfCharacterToLookForWithin(inputs);
        }
    }

    private static void printLastIndexOfCharacterToLookForWithin(String[] line) {
        System.out.println(line[0].lastIndexOf(line[1]));
    }

    private static List<String> readLinesFrom(String filename) {
        Path filePath = Paths.get(filename);
        try {
            return Files.readAllLines(filePath, Charset.forName("UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException("Could not open file: " + filename);
        }
    }

    private static String[] splitInput(String line) {
        int separatorIndex = line.lastIndexOf(SEPARATOR);
        String searchPhrase = line.substring(0, line.lastIndexOf(SEPARATOR));
        String characterToLookFor = String.valueOf(line.charAt(separatorIndex+1));
        String[] inputs = {searchPhrase, characterToLookFor};
        return inputs;
    }

    private static final String SEPARATOR = ",";
}
