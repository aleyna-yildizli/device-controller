package com.roltek.spring.spring_case.dto;

import java.time.LocalDate;

public record DeviceResponse(Long id, String serialNumber, String brand, String model, LocalDate purchaseDate, String warrantyStatus) {
}
