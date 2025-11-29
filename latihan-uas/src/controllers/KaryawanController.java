package controllers;

import models.*;
import repository.IKaryawanRepository;
import repository.KaryawanRepository;

import java.util.ArrayList;
import java.util.List;

public class KaryawanController {
    private IKaryawanRepository karyawanRepository;

    public KaryawanController(IKaryawanRepository karyawanRepository) {
        this.karyawanRepository = karyawanRepository;
    }

    public Karyawan findByNip(String nip) throws EmployeeNotFoundException {
        List<Karyawan> karyawans = this.karyawanRepository.showAllKaryawans();
        for (Karyawan k : karyawans) {
            if (k.getNip().equals(nip)) {
                return k;
            }
        }
        throw new EmployeeNotFoundException("Kayawan ga ketemu");
    }

    public void addKaryawan(Karyawan k) {
        this.karyawanRepository.addKaryawan(k);
    }

    public void addKaryawanTetap(double gajiPokok, double tunjangan, String nama, String nip, Departemen departemen) throws InvalidSalaryException {
        this.addKaryawan(new KaryawanTetap(gajiPokok, tunjangan, nama, nip, departemen));
    }

    public void addKaryawanKontrak(double gajiPerJam, int jumlahJam, String nama, String nip, Departemen departemen) throws InvalidSalaryException {
        this.addKaryawan(new KaryawanKontrak(gajiPerJam, jumlahJam, nama, nip, departemen));
    }

    public void addManager(double bonus, double gajiPokok, double tunjangan, String nama, String nip, Departemen departemen) throws InvalidSalaryException {
        this.addKaryawan(new Manager(bonus, gajiPokok, tunjangan, nama, nip, departemen));
    }

    public List<Karyawan> showAllKaryawans() {
        return this.karyawanRepository.showAllKaryawans();
    }

    public double hitungTotalGaji() {
        double totalGaji = 0;
        for (Karyawan k : this.karyawanRepository.showAllKaryawans()) {
            totalGaji += k.hitungGaji();
        }
        return totalGaji;
    }

    public List<Karyawan> sortByGaji() throws EmployeeNotFoundException {
        List<Karyawan> karyawans = this.karyawanRepository.showAllKaryawans();

        if (karyawans.isEmpty()) {
            throw new EmployeeNotFoundException("Tidak ada karyawan dalam database!");
        }

        List<Karyawan> sortGaji = new ArrayList<>(karyawans);
        sortGaji.sort((k1, k2) -> Double.compare(k2.hitungGaji(), k1.hitungGaji()));
        return sortGaji;
    }

    public Karyawan gajiTertinggi() throws EmployeeNotFoundException {
        List<Karyawan> karyawans = this.karyawanRepository.showAllKaryawans();

        if (karyawans.isEmpty()) {
            throw new EmployeeNotFoundException("Tidak ada karyawan dalam database!");
        }

        Karyawan maxGaji = karyawans.get(0);
        for (Karyawan k : karyawans) {
            if (k.hitungGaji() > maxGaji.hitungGaji()) {
                maxGaji = k;
            }
        }

        return maxGaji;
    }

}
