import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        List<String> lines = readInputLinesFrom(args[0]);
        for (String line : lines) {
            String[] wordsInLine = wordsOfLine(line);
            capitalizeFirstLetterOfEachWordIn(wordsInLine);
        }
    }
    
    private static List<String> readInputLinesFrom(String filename) {
        Path filePath = Paths.get(filename);
        try {
            return Files.readAllLines(filePath, Charset.forName("UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException("Could not read file: " + filename);
        }
    }

    private static String[] wordsOfLine(String line) {
        return line.split(" ");
    }

    private static void capitalizeFirstLetterOfEachWordIn(String[] words) {
        for (int i=0; i<words.length; i++) {
            StringBuilder builder = new StringBuilder();
            addCapitalizedWordTo(words[i], builder);
            if (i!=words.length-1) builder.append(" ");
            System.out.print(builder.toString());
        }
        System.out.println();
    }

    private static StringBuilder addCapitalizedWordTo(String word, StringBuilder builder) {
        Character lowerCaseFirstChar = word.charAt(0);
        Character upperCaseFirstChar = Character.toUpperCase(lowerCaseFirstChar);
        builder.append(word.replaceFirst(lowerCaseFirstChar.toString(), upperCaseFirstChar.toString()));
        return builder;
    }
}
