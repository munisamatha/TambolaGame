public abstract class Player {
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

    public void showTicket() {
        System.out.println("\n" + name + "'s Ticket:");
        ticket.displayTicket();
    }
}


