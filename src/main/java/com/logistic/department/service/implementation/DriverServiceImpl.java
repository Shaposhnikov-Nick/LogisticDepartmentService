package com.logistic.department.service.implementation;

import com.logistic.department.dao.DriverRepository;
import com.logistic.department.entity.Driver;
import com.logistic.department.entity.Transport;
import com.logistic.department.service.interfaces.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepository driverRepository;

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Driver getDriver(int id) {
        Driver driver = null;
        Optional<Driver> optional = driverRepository.findById(id);
        if (optional.isPresent())
            driver = optional.get();

        return driver;
    }

    @Override
    public void saveDriver(Driver driver) {
        driverRepository.save(driver);
    }

    @Override
    public void deleteDriver(int id) {
        driverRepository.deleteById(id);
    }
}
