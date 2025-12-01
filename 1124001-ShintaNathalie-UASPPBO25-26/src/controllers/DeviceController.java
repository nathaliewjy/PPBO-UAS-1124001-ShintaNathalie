package controllers;

import models.*;
import repository.DeviceRepo;
import repository.IDeviceRepo;

import java.util.ArrayList;
import java.util.List;

import static java.lang.StringUTF16.compareTo;

public class DeviceController implements IDeviceController {
    private IDeviceRepo deviceRepo;


    public DeviceController(IDeviceRepo deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    public void addDevice(Device d) {
        this.deviceRepo.addDevice(d);
    }

    public void addWindows(String name, String version) {
        this.addDevice(new Windows("Windows", version));
    }

    public void addUbuntu(String desktopEnvironmentName, String version) {
        this.addDevice(new Device(desktopEnvironmentName, version));
    }

    public void addFedora(String desktopEnvironmentName, String version) {
        this.addDevice(new Device(desktopEnvironmentName, version));
    }

    public List<Device> showAllDevices() throws EmptyListException {
        List<Device> devices = this.deviceRepo.showAllDevices();

        if (devices.isEmpty()) {
            throw new EmptyListException("List device kosong");
        }

        return devices;
    }

    public List<Device> sortByOs() throws EmptyListException {
        List<Device> devices = this.deviceRepo.showAllDevices();

        if (devices.isEmpty()) {
            throw new EmptyListException("List kosong");
        }

        List<Device> sortByOs = new ArrayList<>(devices);
        sortByOs.sort(d1, d2) -> d1.compareTo(d2);

        return sortByOs;
    }


}
