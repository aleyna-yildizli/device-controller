package com.roltek.spring.spring_case.services;

import com.roltek.spring.spring_case.entity.Device;
import com.roltek.spring.spring_case.entity.Warranty;
import com.roltek.spring.spring_case.repository.DeviceRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class DeviceServiceImpl implements DeviceService{


    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Device addDevice(Device device, LocalDate purchaseDate) {
        Warranty warranty = new Warranty();
        warranty.setDevice(device);
        warranty.setPurchaseDate(purchaseDate);
        warranty.calculateWarrantyStatus();

        device.setWarranty(warranty);

        return deviceRepository.save(device);
    }

    @Override
    @Transactional
    public Device updateDevice(Device device, LocalDate purchaseDate) {
        Device existingDevice = deviceRepository.findById(device.getId())
                .orElseThrow(() -> new RuntimeException("Device not found"));

        // Update current device information
        existingDevice.setSerialNumber(device.getSerialNumber());
        existingDevice.setBrand(device.getBrand());
        existingDevice.setModel(device.getModel());

        // Update existing warranty registration
        Warranty warranty = existingDevice.getWarranty();
        warranty.setPurchaseDate(purchaseDate);
        warranty.calculateWarrantyStatus();

        return deviceRepository.save(existingDevice);
    }

    @Override
    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }
}
