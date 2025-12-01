package models;

public class Windows extends OperatingSystem {
    public Windows(String name, String version) {
        super("Windows", version);
    }

    @Override
    public String getBootInfo() {
        return "x";
    }
}
