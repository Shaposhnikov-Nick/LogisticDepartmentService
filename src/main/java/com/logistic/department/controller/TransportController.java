package com.logistic.department.controller;

import com.logistic.department.entity.Transport;
import com.logistic.department.service.interfaces.TransportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Transport Rest Controller")
@RestController
@RequestMapping("/api")
public class TransportController {

    @Autowired
    TransportService transportService;

    //получение списка всех автомобилей
    @ApiOperation(value = "Show all transports")
    @GetMapping("/transports")
    public List<Transport> showAllTransport() {
        return transportService.getAllTransports();
    }


    //получение автомобиля по id
    @ApiOperation(value = "Show transport")
    @GetMapping("/transports/{id}")
    public Transport getTransport(@PathVariable int id) {
        return transportService.getTransport(id);
    }

    //добавление нового автомобиля
    @ApiOperation(value = "Add transport")
    @PostMapping("/transports")
    public Transport addNewTransport(@RequestBody Transport transport) {
        transportService.saveTransport(transport);
        return transport;
    }

    // изменение автомобиля
    @ApiOperation(value = "Change transport")
    @PutMapping("/transports")
    public Transport updateTransport(@RequestBody Transport transport) {
        transportService.saveTransport(transport);
        return transport;
    }

    // удаление автомобиля
    @ApiOperation(value = "Delete transport")
    @DeleteMapping("/transports/{id}")
    public String deleteTransport(@PathVariable int id) {
        transportService.deleteTransport(id);
        return "Автомобиль с id = " + id + " был удален";
    }
}
