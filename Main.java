import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Player> players = new ArrayList<>();

        System.out.println("Welcome to Tambola Game!");
        System.out.println("1. Play with Bot");
        System.out.println("2. Play with Friends");
        System.out.print("Choose option: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        if (choice == 1) {
            players.add(new Player("You"));
            players.add(new Bot("Bot"));
        } else {
            System.out.print("Enter number of players (2-6): ");
            int numPlayers = sc.nextInt();
            sc.nextLine(); // consume newline
            if (numPlayers < 2 || numPlayers > 6) {
                System.out.println("Invalid number of players. Exiting...");
                return;
            }

            for (int i = 1; i <= numPlayers; i++) {
                System.out.print("Enter name for Player " + i + ": ");
                String name = sc.nextLine();
                players.add(new Player(name));
            }

            // Optionally add bots
            System.out.print("Add a bot? (y/n): ");
            String botChoice = sc.nextLine();
            if (botChoice.equalsIgnoreCase("y")) players.add(new Bot("Bot"));
        }

        Game game = new Game(players);
        game.start();
    }
}

