package com.roltek.spring.spring_case.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "device", schema = "device_management")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NotBlank(message = "Serial number must not be null, empty or blank")
    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @NotBlank(message = "Brand must not be null, empty or blank")
    @Column(name = "brand", nullable = false)
    private String brand;

    @NotBlank(message = "Model must not be null, empty or blank")
    @Column(name = "model", nullable = false)
    private String model;

    @OneToOne(mappedBy = "device", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Warranty warranty;
}
