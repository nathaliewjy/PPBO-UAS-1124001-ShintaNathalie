package repository;

import models.Device;

import java.util.List;

public interface IDeviceRepo {
    void addDevice(Device d);
    List<Device> showAllDevices();
}
