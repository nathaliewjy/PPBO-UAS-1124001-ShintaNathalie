package views;

import controllers.DeviceController;
import models.*;
import utils.CLIUtil;

import java.util.Comparator;
import java.util.List;

import static java.lang.StringUTF16.compareTo;

public class DeviceView {
    private DeviceController deviceController;

    public DeviceView(DeviceController deviceController) {
        this.deviceController = deviceController;
    }

    public void menu() {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah device");
            System.out.println("2. Show semua device");
            System.out.println("3. Show semua device berdasarkan OS");
            System.out.println("0. Exit");
            System.out.print("Pilih menu : ");
            pilihMenu();
        }
    }

    private void pilihMenu() throws InvalidMenuException {
        int pilihMenu = CLIUtil.getInt();
        switch (pilihMenu) {
            case 1:
                menuTambahDevice();
                break;
            case 2:
                menuShowSemuaDevices();
                break;
            case 3:
                menuShowSorted();
                break;
            default:
                throw new InvalidMenuException("MEnu salah");
        }
    }

    // menu1
    public void menuTambahDevice() throws InvalidOSException, InvalidMenuException {
        try {
            String namaPemilik = CLIUtil.askForString("Nama pemilik : ");
            int tipeOS = CLIUtil.askForInt("OS : 1. Windows 2. Ubuntu 3. Fedora");
            if (tipeOS > 3 || tipeOS < 1) {
                throw new InvalidOSException("OS salah");
            }
            CLIUtil.getInt();
            String version = CLIUtil.askForString("Version : ");

            switch (tipeOS) {
                case 1:
                   this.deviceController.addDevice(namaPemilik, "Windows", version);
                   break;
                case 2:
                    this.deviceController.addDevice(namaPemilik, os, version);
            }
        } catch (InvalidMenuException e) {
            System.out.println("Menu salah");
        } catch (InvalidOSException e) {
            System.out.println("OS salah");
        }
    }

    // menu2
    public void menuShowSemuaDevices() {
        var devices = deviceController.showAllDevices();
        menuShowSemuaDevices(devices);
    }
    public void menuShowSemuaDevices(boolean sortByOS) {
        var devices = deviceController.showAllDevices();
        devices.sort(new DeviceComparator(sortByOS));
        menuShowSemuaDevices(devices);
    }
    private void menuShowSemuaDevices(List<Device> devices) {
        for (int i = 0; i < devices.size(); i++) {
            Device d = devices.get(i);
            String namaPemilik = d.getNamaPemilik();
            OperatingSystem os = d.getOs();

            System.out.println("Nama pemilik : " + namaPemilik + ", " + "OS : " + os);

        }
    }

    // menu3
    class DeviceComparator implements Comparator<Device> {
        boolean isAsc;

        public DeviceComparator() {
            this(true);
        }

        public DeviceComparator(boolean isAsc) {
            this.isAsc = false;
        }

        @Override
        public int compare(Device d1, Device d2) {
            boolean isD1HigherThanD2 = d1.compareTo(d2);

            if (isAsc != isD1HigherThanD2) {
                return -1;
            }

            return 1;
        }
    }

    private void menuShowSorted() {
        try {
            System.out.println("List sort OS : ");
            List<Device> sortByOs = deviceController.sortByOs();
            menuShowSemuaDevices(sortByOs);
        } catch (EmptyListException e) {
            System.out.println("List kosong");
        }
    }


}
