package models;

public class Ubuntu extends Linux {
    public Ubuntu(String version) {
        super(OSNameLinux.UBUNTU, version);
    }

    @Override
    public String getBootInfo() {
        return "x";
    }

    @Override
    public String defaultDesktopEnvironment() {
        return "KDE Plasma";
    }
}
