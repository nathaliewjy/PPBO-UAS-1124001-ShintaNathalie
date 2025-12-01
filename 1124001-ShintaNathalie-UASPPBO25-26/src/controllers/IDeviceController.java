package controllers;

import models.Device;

import java.util.List;

public interface IDeviceController {
    void addDevice(Device d);
    List<Device> showAllDevices();
}
