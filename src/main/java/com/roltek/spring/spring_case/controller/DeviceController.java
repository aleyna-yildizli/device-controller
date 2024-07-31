package com.roltek.spring.spring_case.controller;
import com.roltek.spring.spring_case.converter.DeviceDTO;
import com.roltek.spring.spring_case.dto.DeviceRequest;
import com.roltek.spring.spring_case.dto.DeviceResponse;
import com.roltek.spring.spring_case.entity.Device;
import com.roltek.spring.spring_case.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/devices")
@CrossOrigin(origins = "http://localhost:5173")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping
    public ResponseEntity<DeviceResponse> addDevice(@RequestBody DeviceRequest deviceRequest) {
        System.out.println("Received DeviceRequest: " + deviceRequest);
        Device device = DeviceDTO.toDevice(deviceRequest);
        Device createdDevice = deviceService.addDevice(device, deviceRequest.purchaseDate());
        DeviceResponse response = DeviceDTO.toDeviceResponse(createdDevice);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<DeviceResponse>> getAllDevices() {
        List<Device> devices = deviceService.getAllDevices();
        List<DeviceResponse> responses = devices.stream()
                .map(DeviceDTO::toDeviceResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviceResponse> updateDevice(@PathVariable Long id, @RequestBody DeviceRequest deviceRequest) {
        Device device = DeviceDTO.toDevice(deviceRequest);
        device.setId(id);  // Ensuring that the device has the correct ID
        Device updatedDevice = deviceService.updateDevice(device, deviceRequest.purchaseDate());
        DeviceResponse response = DeviceDTO.toDeviceResponse(updatedDevice);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceResponse> getDeviceById(@PathVariable Long id) {
        Device device = deviceService.getDeviceById(id);
        DeviceResponse response = DeviceDTO.toDeviceResponse(device);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }
}