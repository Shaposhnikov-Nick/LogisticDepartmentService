package com.logistic.department.controller;

import com.logistic.department.entity.Driver;
import com.logistic.department.exception_handling.NoSuchDriverException;
import com.logistic.department.service.interfaces.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class DriverController {

    @Autowired
    DriverService driverService;

    //получение списка всех водителей
    @GetMapping("/drivers")
    public List<Driver> showAllDrivers() {
        return driverService.getAllDrivers();
    }


    //получение водителя по id
    @GetMapping("/drivers/{id}")
    public Driver getDriver(@PathVariable int id) {
        Driver driver = driverService.getDriver(id);

        if (driver == null){
            throw new NoSuchDriverException("Водитель с id = " + id + " отсутствует в базе данных");
        }

        return driver;
    }

    //добавление нового водителя
    @PostMapping("/drivers")
    public Driver addNewDriver(@RequestBody Driver driver) {
        driverService.saveDriver(driver);
        return driver;
    }

    // изменение водителя
    @PutMapping("/drivers")
    public Driver updateDriver(@RequestBody Driver driver) {
        driverService.saveDriver(driver);
        return driver;
    }

    // удаление водителя
    @DeleteMapping("/drivers/{id}")
    public String deleteDriver(@PathVariable int id) {
        Driver driver = driverService.getDriver(id);

        if (driver == null){
            throw new NoSuchDriverException("Водитель с id = " + id + " отсутствует в базе данных");
        }

        driverService.deleteDriver(id);
        return "Водитель с id = " + id + " был удален";
    }
}
