import java.util.*;

public class Game {
    private final List<Player> players = new ArrayList<>();
    private final Set<Integer> drawnNumbers = new HashSet<>();
    private final Random rand = new Random();
    private final Scanner sc = new Scanner(System.in);

    // Colors
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    public Game(List<Player> players) {
        this.players.addAll(players);
    }

    public void start() {
        System.out.println("\n--- Game Started ---");

        // Show tickets at start
        for (Player p : players) p.showTicket();

        while (true) {
            int number = drawNumber();
            System.out.println("\n" + YELLOW + "🎲 Number called: " + number + RESET + "\n");

            for (Player player : players) {
                System.out.println(BLUE + player.getName() + "'s Ticket:" + RESET);
                player.getTicket().displayTicket();

                if (player instanceof Bot) {
                    if (player.getTicket().hasNumber(number)) {
                        player.getTicket().strikeNumber(number);
                        System.out.println(GREEN + player.getName() + " (Bot) struck " + number + "!" + RESET + "\n");
                    }
                } else {
                    // Human player: always asked
                    System.out.print(player.getName() + ", do you want to strike number " + number + "? (yes/no): ");
                    String choice = sc.nextLine().trim();
                    if (choice.equalsIgnoreCase("yes")) {
                        if (player.getTicket().hasNumber(number)) {
                            player.getTicket().strikeNumber(number);
                            System.out.println(GREEN + player.getName() + " struck " + number + "!" + RESET + "\n");
                        } else {
                            System.out.println(RED + "Number " + number + " is not on your ticket!" + RESET + "\n");
                        }
                    } else {
                        System.out.println(RED + player.getName() + " did not strike " + number + "." + RESET + "\n");
                    }
                }

                // Check for winner
                if (player.getTicket().isComplete()) {
                    System.out.println(GREEN + "🏆 " + player.getName() + " has completed their ticket and WON!" + RESET);
                    return;
                }
            }

            if (drawnNumbers.size() == 99) {
                System.out.println(RED + "⚠ No winner! All numbers drawn." + RESET);
                return;
            }
        }
    }

    private int drawNumber() {
        int num;
        do { num = rand.nextInt(99) + 1; } while (drawnNumbers.contains(num));
        drawnNumbers.add(num);
        return num;
    }
}
