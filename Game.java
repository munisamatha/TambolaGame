import java.util.*;

public class Game {
    private final List<Player> players = new ArrayList<>();
    private final Set<Integer> drawnNumbers = new HashSet<>();
    private final Random rand = new Random();
    private final Scanner sc = new Scanner(System.in);

    public Game(List<Player> players) {
        this.players.addAll(players);
    }

    public void start() {
        System.out.println("\n--- Game Started ---");

        // Show all tickets at start
        for (Player p : players) p.showTicket();

        while (true) {
            int number = drawNumber();
            System.out.println("\nNumber drawn: " + number);

            for (Player p : players) {
                if (p.getTicket().strike(number)) {
                    if (p.isBot()) {
                        ((Bot)p).react(number);
                    } else {
                        System.out.print(p.getName() + ", you struck " + number + "! Type something: ");
                        String reaction = sc.nextLine();
                        System.out.println(p.getName() + " says: " + reaction);
                    }

                    if (p.getTicket().isComplete()) {
                        System.out.println("\n🎉 Winner: " + p.getName() + " 🎉"+"Hurrayy Congratulationssss!!!");
                        return;
                    }
                }
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

