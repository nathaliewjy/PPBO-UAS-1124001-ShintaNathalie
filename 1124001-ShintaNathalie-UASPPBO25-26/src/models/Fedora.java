package models;

public class Fedora extends Linux{
    public Fedora(String desktopEnvironmentName, String version) {
        super(desktopEnvironmentName, OSNameLinux.FEDORA, version);
    }

    @Override
    public String getBootInfo() {
        return "x";
    }

    @Override
    public String defaultDesktopEnvironment() {
        return "GNome";
    }
}
