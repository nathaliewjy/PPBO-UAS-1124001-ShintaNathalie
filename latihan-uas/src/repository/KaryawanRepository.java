package repository;

import models.Karyawan;

import java.util.ArrayList;
import java.util.List;

public class KaryawanRepository implements IKaryawanRepository {
    private List<Karyawan> karyawans;

    public KaryawanRepository() {
        this.karyawans = new ArrayList<>();
    }
    @Override
    public void addKaryawan(Karyawan k) {
        this.karyawans.add(k);
    }

    @Override
    public List<Karyawan> showAllKaryawans() {
        return this.karyawans;
    }
}
