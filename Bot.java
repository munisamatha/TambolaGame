public class Bot extends Player {

    public Bot(String name) {
        super(name);
    }

    @Override
    public boolean isBot() {
        return true;
    }

    // Bot reacts automatically when striking numbers
    public void react(int number) {
        int remaining = ticket.remainingNumbers();
        System.out.println(name + " struck " + number + "! Remaining numbers: " + remaining);
        if (remaining <= 5 && remaining > 0) {
            System.out.println(name + " says: I'm so close! Only " + remaining + " left!");
        } else if (remaining == 0) {
            System.out.println(name + " says: I WON!!!");
        }
    }
}

