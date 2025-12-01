package repository;

import models.Device;

import java.util.ArrayList;
import java.util.List;

public class DeviceRepo implements IDeviceRepo {
    private List<Device> devices;

    public DeviceRepo() {
        this.devices = new ArrayList<>();
    }

    @Override
    public void addDevice(Device d) {
        this.devices.add(d);
    }

    @Override
    public List<Device> showAllDevices() {
        return this.devices;
    }
}
