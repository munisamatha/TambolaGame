public class Player {
    protected String name;
    protected Ticket ticket;

    public Player(String name) {
        this.name = name;
        this.ticket = new Ticket();
    }

    public String getName() {
        return name;
    }

    public Ticket getTicket() {
        return ticket;
    }

    // By default, a player is human
    public boolean isBot() {
        return false;
    }

    public void showTicket() {
        System.out.println("\nTicket for " + name + ":");
        ticket.display();
    }
}

