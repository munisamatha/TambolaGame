import java.util.*;

public class Ticket {
    private final int[][] grid = new int[3][9];
    private final boolean[][] marked = new boolean[3][9];

    public Ticket() {
        generateTicket();
    }

    private void generateTicket() {
        Random rand = new Random();

        for (int row = 0; row < 3; row++) {
            Set<Integer> chosenCols = new HashSet<>();
            while (chosenCols.size() < 5) {
                chosenCols.add(rand.nextInt(9));
            }

            for (int col : chosenCols) {
                int min = (col == 0) ? 1 : col * 10;
                int max = (col == 8) ? 99 : (col * 10 + 9);
                int num = rand.nextInt(max - min + 1) + min;

                while (columnContains(col, num)) {
                    num = rand.nextInt(max - min + 1) + min;
                }
                grid[row][col] = num;
            }
        }
    }

    private boolean columnContains(int col, int num) {
        for (int row = 0; row < 3; row++) {
            if (grid[row][col] == num) return true;
        }
        return false;
    }

    public boolean strike(int num) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == num) {
                    marked[row][col] = true;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isComplete() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] != 0 && !marked[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Count how many numbers remain unstruck
    public int remainingNumbers() {
        int count = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] != 0 && !marked[row][col]) {
                    count++;
                }
            }
        }
        return count;
    }

    public void display() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == 0) {
                    System.out.print(" -- ");
                } else if (marked[row][col]) {
                    System.out.print(" XX ");
                } else {
                    System.out.printf("%2d  ", grid[row][col]);
                }
            }
            System.out.println();
        }
    }
}
