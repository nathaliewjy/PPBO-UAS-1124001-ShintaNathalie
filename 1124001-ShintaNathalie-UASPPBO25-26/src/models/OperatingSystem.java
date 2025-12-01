package models;

public abstract class OperatingSystem {
    private String name;
    private String version;

    public OperatingSystem(String name, String version) {
        this.name =  name;
        this.version = version;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public abstract String getBootInfo();
}
