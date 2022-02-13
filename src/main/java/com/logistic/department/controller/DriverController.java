package com.logistic.department.controller;

import com.logistic.department.entity.Driver;
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
        return driverService.getDriver(id);
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
        driverService.deleteDriver(id);
        return "Водитель с id = " + id + " был удален";
    }
}
