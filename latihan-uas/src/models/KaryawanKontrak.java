package models;

public class KaryawanKontrak extends Karyawan {
    private double gajiPerJam;
    private int jumlahJam;

    public KaryawanKontrak(double gajiPerJam, int jumlahJam, String nama, String nip, Departemen departemen) throws InvalidSalaryException {
        super(nama, nip, departemen);
        this.gajiPerJam = gajiPerJam;
        this.jumlahJam = jumlahJam;

        if (gajiPerJam < 0 || jumlahJam < 0) {
            throw new InvalidSalaryException("Gaji per jam dan jumlah jam tidak boleh negatif!");
        }
    }

    public double getGajiPerJam() {
        return this.gajiPerJam;
    }

    public void setGajiPerJam(double gajiPerJam) {
        this.gajiPerJam = gajiPerJam;
    }

    public int getJumlahJam() {
        return this.jumlahJam;
    }

    public void setJumlahJam(int jumlahJam) {
        this.jumlahJam = jumlahJam;
    }

    @Override
    public double hitungGaji() {
        return gajiPerJam * jumlahJam;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " " + this.gajiPerJam + " " + this.jumlahJam;
    }
}
