package com.roltek.spring.spring_case.converter;

import com.roltek.spring.spring_case.dto.DeviceRequest;
import com.roltek.spring.spring_case.dto.DeviceResponse;
import com.roltek.spring.spring_case.entity.Device;
import com.roltek.spring.spring_case.entity.Warranty;

public class DeviceDTO {
    public static Device toDevice(DeviceRequest deviceRequest) {
        Device device = new Device();
        device.setSerialNumber(deviceRequest.serialNumber());
        device.setBrand(deviceRequest.brand());
        device.setModel(deviceRequest.model());
        return device;
    }

    public static DeviceResponse toDeviceResponse(Device device) {
        Warranty warranty = device.getWarranty();
        return new DeviceResponse(
                device.getId(),
                device.getSerialNumber(),
                device.getBrand(),
                device.getModel(),
                warranty != null ? warranty.getPurchaseDate() : null,
                warranty != null ? warranty.getWarrantyStatus() : null
        );
    }
}