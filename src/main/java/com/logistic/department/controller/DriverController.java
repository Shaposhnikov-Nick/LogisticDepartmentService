package com.logistic.department.controller;

import com.logistic.department.entity.Driver;
import com.logistic.department.exception_handling.NoSuchDriverException;
import com.logistic.department.service.interfaces.DriverService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "Driver Rest Controller")
public class DriverController {

    @Autowired
    DriverService driverService;

    //получение списка всех водителей
    @ApiOperation(value = "Show all drivers")
    @GetMapping("/drivers")
    public List<Driver> showAllDrivers() {
        return driverService.getAllDrivers();
    }


    //получение водителя по id
    @ApiOperation(value = "Show driver")
    @GetMapping("/drivers/{id}")
    public Driver getDriver(@PathVariable int id) {
        Driver driver = driverService.getDriver(id);

        if (driver == null) {
            throw new NoSuchDriverException("Водитель с id = " + id + " отсутствует в базе данных");
        }

        return driver;
    }

    //добавление нового водителя
    @ApiOperation(value = "Add driver")
    @PostMapping("/drivers")
    public Driver addNewDriver(@RequestBody Driver driver) {
        driverService.saveDriver(driver);
        return driver;
    }

    // изменение водителя
    @ApiOperation(value = "Change driver")
    @PutMapping("/drivers")
    public Driver updateDriver(@RequestBody Driver driver) {
        driverService.saveDriver(driver);
        return driver;
    }

    // удаление водителя
    @ApiOperation(value = "Delete driver")
    @DeleteMapping("/drivers/{id}")
    public String deleteDriver(@PathVariable int id) {
        Driver driver = driverService.getDriver(id);

        if (driver == null) {
            throw new NoSuchDriverException("Водитель с id = " + id + " отсутствует в базе данных");
        }

        driverService.deleteDriver(id);
        return "Водитель с id = " + id + " был удален";
    }
}
