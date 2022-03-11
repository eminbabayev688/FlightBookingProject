package az.iktlab.util.Commands;

public enum AppMenuCommands {
    OnlineBoard("1"),
    ShowFlightInfo("2"),
    SearchAndBooking("3"),
    CancelBooking("4"),
    MyFlights("5"),
    Logout("6");

    private final String commandNumber;

    AppMenuCommands(String commandNumber) {
        this.commandNumber = commandNumber;
    }

    public String getCommandNumber() {
        return commandNumber;
    }
}
