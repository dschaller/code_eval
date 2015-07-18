import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.io.IOException;
import java.lang.IllegalArgumentException;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1)
            throw new IllegalArgumentException("Input file should be specified as an argument");
        List<String> lines = linesFromFile(args[0]);
        for (String line : lines) {
            Stack stack = pushOnToStackAllIntegersWithin(line);
            printEveryAlternatePoppedIntegerOf(stack);
            System.out.println();
        }
    }

    private static List<String> linesFromFile(String filename) {
        Path filePath = Paths.get(filename);
        try {
            return Files.readAllLines(filePath, Charset.forName("UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException("Could not read file: " + filename);
        }
    }

    private static Stack pushOnToStackAllIntegersWithin(String line) {
        String[] stackInput = line.split(" ");
        Stack stack = new Main().new Stack(stackInput.length);
        for (int i=0; i<stackInput.length; i++)
            stack.push(Integer.valueOf(stackInput[i]));
        return stack;
    }

    private static void printEveryAlternatePoppedIntegerOf(Stack stack) {
        int stackSize = stack.size();
        for (int j=1; j<=stackSize; j++)
            if (j%2 == 0) stack.pop();
            else System.out.print(String.format("%d ", stack.pop()));
    }

    public class Stack {
        private int head;
        private final int[] stackStorage;

        public Stack(int length) {
            this.head = -1;
            this.stackStorage = new int[length];
        }

        public void push(int value) {
            stackStorage[++head] = value;
        }

        public int pop() {
            return stackStorage[head--];
        }

        public int size() {
            return head+1;
        }
    }
}
