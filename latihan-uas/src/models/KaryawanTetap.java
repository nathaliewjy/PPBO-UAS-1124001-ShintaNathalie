package models;

public class KaryawanTetap extends Karyawan {
    private double gajiPokok;
    private double tunjangan;

    public KaryawanTetap(double gajiPokok, double tunjangan, String nama, String nip, Departemen departemen) throws InvalidSalaryException {
        super(nama, nip, departemen);
        this.gajiPokok = gajiPokok;
        this.tunjangan = tunjangan;

        if (gajiPokok < 0 || tunjangan < 0) {
            throw new InvalidSalaryException("Gaji dan tunjangan tidak boleh negatif!");
        }
    }

    public double getGajiPokok() {
        return this.gajiPokok;
    }

    public  void setGajiPokok(double gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public double getTunjangan() {
        return this.tunjangan;
    }

    public void setTunjangan(double tunjangan) {
        this.tunjangan = tunjangan;
    }

    @Override
    public double hitungGaji() {
        return gajiPokok + tunjangan;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " " + this.gajiPokok + " " + this.tunjangan;
    }
}
