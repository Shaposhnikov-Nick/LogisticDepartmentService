package com.logistic.department.dao;

import com.logistic.department.entity.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportRepository extends JpaRepository<Transport, Integer> {
}
