package models;

public class Manager extends KaryawanTetap implements Bonusable {
    private double bonus;

    public Manager(double bonus, double gajiPokok, double tunjangan, String nama, String nip, Departemen departemen) throws InvalidSalaryException {
        super(gajiPokok, tunjangan, nama, nip, departemen);
        this.bonus = bonus;

        if (bonus < 0) {
            throw new InvalidSalaryException("Bonus tidak boleh negatif!");
        }
    }

    public double getBonus() {
        return this.bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double hitungGaji() {
        return super.hitungGaji() + bonus;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " " + this.bonus;
    }

    @Override
    public void hitungBonus() {
        System.out.println("Bonus : " + this.bonus);
    }
}
