package az.iktlab.util.Commands;

public enum LoginPageCommands {
    Login("1"),
    Registration("2"),
    Exit("3");

    private final String commandNumber;

    LoginPageCommands(String commandNumber) {
        this.commandNumber = commandNumber;
    }

    public String getCommandNumber() {
        return commandNumber;
    }
}

