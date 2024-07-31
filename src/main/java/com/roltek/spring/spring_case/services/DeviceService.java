package com.roltek.spring.spring_case.services;

import com.roltek.spring.spring_case.entity.Device;

import java.time.LocalDate;
import java.util.List;

public interface DeviceService {

    List<Device> getAllDevices();
    Device getDeviceById(Long id);
    Device addDevice(Device device, LocalDate purchaseDate);
    Device updateDevice(Device device, LocalDate purchaseDate);
    void deleteDevice(Long id);
}
