package views;

import controllers.KaryawanController;
import models.*;
import repository.IKaryawanRepository;
import utils.CLIUtil;

import java.util.Comparator;
import java.util.List;

public class KaryawanView {
    private KaryawanController karyawanController;

    public KaryawanView(KaryawanController karyawanController) {
        this.karyawanController = karyawanController;
    }

    public void menu() {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah karyawan");
            System.out.println("2. Show semua karyawan");
            System.out.println("3. Hitung total gaji");
            System.out.println("4. Sort karyawan berdasarkan gaji");
            System.out.println("5. Show karyawan gaji tertinggi");
            System.out.println("0. Exit");
            System.out.print("Pilih menu : ");
            pilihMenu();
        }
    }

    private void pilihMenu() {
        int pilihMenu = CLIUtil.getInt();
        switch (pilihMenu) {
            case 1:
                menuTambahKaryawan();
                break;
            case 2:
                menuShow();
                break;
            case 3:
                menuHitungTotalGaji();
                break;
            case 4:
                menuShowSorted();
                break;
            case 5:
                showGajiTertinggi();
                break;
            case 0:
                System.out.println("Terima kasih!");
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }
    }

    //menu 1
    public void menuTambahKaryawan() {
        System.out.println("1. Tetap");
        System.out.println("2. Kontrak");
        System.out.println("3. Manager");
        System.out.print("Pilih karyawan : ");
        int pilihKaryawan = CLIUtil.getInt();

        switch (pilihKaryawan) {
            case 1:
                menuKaryawanTetap();
                break;
            case 2:
                menuKaryawanKontrak();
                break;
            case 3:
                menuManager();
                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }
    }

    //karyawan
    private String[] menuKaryawan() {
        System.out.println("Nama : ");
        String nama = CLIUtil.getString();
        System.out.println("NIP : ");
        String nip = CLIUtil.getString();
        System.out.println("Departemen : ");
        String dept = CLIUtil.getString().toUpperCase();
        Departemen departemen = Departemen.valueOf(dept);

        return new String[]{nama, nip, departemen.name()};
    }
    //karyawan tetap
    private void menuKaryawanTetap() {
        try {
            System.out.println("Gaji pokok : ");
            double gajiPokok = CLIUtil.getDouble();
            System.out.println("Tunjangan : ");
            double tunjangan = CLIUtil.getDouble();

            String[] karyawan = menuKaryawan();

            karyawanController.addKaryawanTetap(gajiPokok, tunjangan, karyawan[0], karyawan[1], Departemen.valueOf(karyawan[2]));
        } catch (InvalidSalaryException e) {
            System.out.print("Gagal tambah kartap : " + e.getMessage());
        }
    }
    //karyawan kontrak
    private void menuKaryawanKontrak() {
        try {
            System.out.print("Gaji per jam : ");
            double gajiPerJam = CLIUtil.getDouble();
            System.out.print("Jumlah jam : ");
            int jumlahJam = CLIUtil.getInt();

            String[] karyawan = menuKaryawan();

            karyawanController.addKaryawanKontrak(gajiPerJam, jumlahJam, karyawan[0], karyawan[1], Departemen.valueOf(karyawan[2]));
            System.out.println("Add karyawan kontrak done");
        } catch (InvalidSalaryException e) {
            System.out.println("Gagal add karyawan kontrak : " + e.getMessage());
        }
    }
    //manager
    private void menuManager() {
        try {
            System.out.print("Gaji pokok : ");
            double gajiPokok = CLIUtil.getDouble();
            System.out.print("Tunjangan : ");
            double tunjangan = CLIUtil.getDouble();
            System.out.print("Bonus : ");
            double bonus = CLIUtil.getDouble();

            String[] karyawan = menuKaryawan();

            karyawanController.addManager(bonus, gajiPokok, tunjangan, karyawan[0], karyawan[1], Departemen.valueOf(karyawan[2]));
            System.out.println("Add manager done");
        } catch (InvalidSalaryException e) {
            System.out.println("Gagal add manager : " + e.getMessage());
        }
    }

    //menu 2
    public void menuShow() {
        var karyawans = karyawanController.showAllKaryawans();
        menuShow(karyawans);
    }
    public void menuShow(boolean sortByGaji) {
        var karyawans = karyawanController.showAllKaryawans();
        karyawans.sort(new KaryawanComparator(sortByGaji));
        menuShow(karyawans);
    }
    private void menuShow(List<Karyawan> karyawans) {
        for (int i = 0; i < karyawans.size(); i++) {
             Karyawan k = karyawans.get(i);
             String nama = k.getNama();
             double gaji = k.hitungGaji();
            System.out.println("Nama : " + nama + ", " + "Gaji : " + gaji);
        }
    }

    //menu 3
    private void menuHitungTotalGaji() {
        double totalGaji = karyawanController.hitungTotalGaji();
        System.out.println("Total gaji : " + totalGaji);
    }
    //menu 4
    class KaryawanComparator implements Comparator<Karyawan> {
        boolean isAsc;

        public KaryawanComparator() {
            this(true);
        }

        public KaryawanComparator(boolean isAsc) {
            this.isAsc = isAsc;
        }

        @Override
        public int compare(Karyawan k1, Karyawan k2) {
            boolean isK1HigherThanK2 = k1.hitungGaji() > k2.hitungGaji();
            if (isAsc != isK1HigherThanK2) {
                return -1;
            }
            return 1;
        }
    }

    private void menuShowSorted() {
        try {
            System.out.println("List sort karyawan : ");
            List<Karyawan> sortGaji = karyawanController.sortByGaji();
            menuShow(sortGaji);
        } catch (EmployeeNotFoundException e) {
            System.out.printf("Gagal show sorted : " + e.getMessage());
        }
    }

    //menu 5
    private void showGajiTertinggi() {
        try {
            Karyawan maxGaji = karyawanController.gajiTertinggi();
            System.out.println("Total gaji tertinggi : " + maxGaji.hitungGaji());
        } catch (EmployeeNotFoundException e) {
            System.out.println("Gagal show gaji tertinggi : " + e.getMessage());
        }
    }
}
