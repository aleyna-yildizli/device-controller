package com.roltek.spring.spring_case.repository;

import com.roltek.spring.spring_case.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository  extends JpaRepository<Device, Long> {
}
