package com.logistic.department.service.interfaces;

import com.logistic.department.entity.Driver;

import java.util.List;

public interface DriverService {

    List<Driver> getAllDrivers();

    void saveDriver(Driver driver);

    Driver getDriver(int id);

    void deleteDriver(int id);
}
