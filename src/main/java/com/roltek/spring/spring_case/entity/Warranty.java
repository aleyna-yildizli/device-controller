package com.roltek.spring.spring_case.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "warranty", schema = "device_management")
public class Warranty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    private Device device;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "warranty_status")
    private String warrantyStatus;

    // Method to calculate warranty status
    @PrePersist
    @PreUpdate
    public void calculateWarrantyStatus() {
        LocalDate endDate = purchaseDate.plusYears(2);
        if (LocalDate.now().isAfter(endDate)) {
            this.warrantyStatus = " Expired";
        } else {
            this.warrantyStatus = " Active";
        }
    }
}

