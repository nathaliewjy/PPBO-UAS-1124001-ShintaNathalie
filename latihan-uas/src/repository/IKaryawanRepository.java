package repository;

import models.Karyawan;

import java.util.List;

public interface IKaryawanRepository {
    void addKaryawan(Karyawan k);
    List<Karyawan> showAllKaryawans();
}
