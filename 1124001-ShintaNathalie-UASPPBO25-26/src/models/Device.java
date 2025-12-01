package models;

public class Device {
    private String namaPemilik;
    private OperatingSystem os;

    public Device(String namaPemilik, OperatingSystem os) {
        this.namaPemilik = namaPemilik;
        this.os = os;
    }

    public String getNamaPemilik() {
        return this.namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public OperatingSystem getOs() {
        return this.os;
    }

    public void setOs(OperatingSystem os) {
        this.os = os;
    }
}
