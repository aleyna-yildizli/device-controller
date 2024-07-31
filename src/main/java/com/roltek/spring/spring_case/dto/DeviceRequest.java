package com.roltek.spring.spring_case.dto;

import java.time.LocalDate;

public record DeviceRequest(String serialNumber, String brand, String model, LocalDate purchaseDate) {
}
