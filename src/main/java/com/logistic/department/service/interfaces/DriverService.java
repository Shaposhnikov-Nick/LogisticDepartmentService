package com.logistic.department.service.interfaces;

import com.logistic.department.entity.Driver;

import java.util.List;

public interface DriverService {

    // получение списка водителей и закрепленных за ними автомобилей
    List<Driver> getAllDrivers();

    // добавление водителя
    void saveDriver(Driver driver);

    // получение водителя по id
    Driver getDriver(int id);

    // удаление водителя по id
    void deleteDriver(int id);
}
