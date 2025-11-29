package models;

public abstract class Karyawan {
    private String nama;
    private String nip;
    private Departemen departemen;

    public abstract double hitungGaji();

    public String getDetails() {
        return this.nama + " " + this.nip + " " + this.departemen;
    }

    public Karyawan(String nama, String nip, Departemen departemen) {
        this.nama = nama;
        this.nip = nip;
        this.departemen = departemen;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNip() {
        return this.nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public Departemen getDepartemen() {
        return this.departemen;
    }

    public void setDepartemen(Departemen departemen) {
        this.departemen = departemen;
    }

    @Override
    public String toString() {
        return this.nama + " " + this.nip + " " + this.departemen;
    }
}
