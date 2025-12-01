package models;

public abstract class Linux extends OperatingSystem {
    private OSNameLinux nameLinux;

    public Linux(OSNameLinux nameLinux, String version) {
        super("Linux", version);
        this.nameLinux = nameLinux;
    }

    public OSNameLinux getNameLinux() {
        return this.nameLinux;
    }

    public void setNameLinux(OSNameLinux nameLinux) {
        this.nameLinux = nameLinux;
    }

    @Override
    public String getBootInfo() {
        return "x";
    }

    public abstract String defaultDesktopEnvironment();
}
