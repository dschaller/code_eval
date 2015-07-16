import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        List<String> lines = readInputLinesFrom(args[0]);
        printFibonacciNumberForRowsIn(lines);
    }

    private static List<String> readInputLinesFrom(String filename) {
        Path filePath = Paths.get(filename);
        try {
            return Files.readAllLines(filePath, Charset.forName("UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException("Could not read file: " + filename);
        }
    }

    private static void printFibonacciNumberForRowsIn(List<String> lines) {
        for (String line : lines) {
            int seriesIndex = Integer.valueOf(line);
            System.out.println(fibonacciValueAtIndex(seriesIndex));
        }
    }

    private static int fibonacciValueAtIndex(int seriesIndex) {
        if (seriesIndex <1) return 0;
        if (seriesIndex == 1) return 1;
        return fibonacciValueAtIndex(seriesIndex-1) + fibonacciValueAtIndex(seriesIndex-2);
    }
}
