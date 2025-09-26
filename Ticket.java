import java.util.*;

public class Ticket {
    private final int[][] grid = new int[3][9];
    private final boolean[][] struck = new boolean[3][9];

    public Ticket() {
        generateTicket();
    }

    private void generateTicket() {
        Random rand = new Random();
        Set<Integer> usedNumbers = new HashSet<>(); // Track all numbers in ticket

        for (int row = 0; row < 3; row++) {
            Set<Integer> colsFilled = new HashSet<>();
            while (colsFilled.size() < 5) {
                int col = rand.nextInt(9);
                if (grid[row][col] == 0) {
                    int start = col * 10 + 1;
                    int end = (col == 8) ? 99 : (col + 1) * 10;

                    int num;
                    do {
                        num = rand.nextInt(end - start + 1) + start;
                    } while (usedNumbers.contains(num)); // ensure uniqueness across ticket

                    grid[row][col] = num;
                    usedNumbers.add(num);
                    colsFilled.add(col);
                }
            }
        }
    }

    public void displayTicket() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    System.out.print(" -- ");
                } else if (struck[i][j]) {
                    System.out.print(" XX ");
                } else {
                    System.out.printf("%2d  ", grid[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean hasNumber(int num) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == num && !struck[i][j]) return true;
            }
        }
        return false;
    }

    public void strikeNumber(int num) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == num) struck[i][j] = true;
            }
        }
    }

    public boolean isComplete() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] != 0 && !struck[i][j]) return false;
            }
        }
        return true;
    }
}
