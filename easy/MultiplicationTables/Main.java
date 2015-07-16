public class Main {
    public static void main(String[] args) {
        sumNumberOfRows();
    }

    private static void sumNumberOfRows() {
        for (int row=1; row <= 12; row++) {
            for (int column=1; column <= 12; column++) {
                System.out.format("% 4d", row*column);
            }
            System.out.println();
        }
    }
}
