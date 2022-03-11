package az.iktlab.util.Commands;

public enum SearchBookingCommands {
    Search("3.1"),
    Booking("3.2");

    private final String commandNumber;

    SearchBookingCommands(String commandNumber) {
        this.commandNumber = commandNumber;
    }

    public String getCommandNumber() {
        return commandNumber;
    }
}
