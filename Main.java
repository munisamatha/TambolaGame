import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🎉 Welcome to Tambola Game 🎉");
        System.out.println("1. Play with Bot");
        System.out.println("2. Play with Friends");
        System.out.print("Choose option: ");
        int choice = sc.nextInt();
        sc.nextLine();

        List<Player> players = new ArrayList<>();

        if (choice == 1) {
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            players.add(new HumanPlayer(name));
            players.add(new Bot("Computer"));
        } else {
            System.out.print("Enter number of players (2-6): ");
            int n = sc.nextInt();
            sc.nextLine();
            for (int i = 1; i <= n; i++) {
                System.out.print("Enter name for Player " + i + ": ");
                String name = sc.nextLine();
                players.add(new HumanPlayer(name));
            }
        }

        Game game = new Game(players);
        game.start();
    }
}


