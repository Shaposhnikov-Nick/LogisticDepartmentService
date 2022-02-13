package com.logistic.department.controller;

import com.logistic.department.entity.Driver;
import com.logistic.department.entity.Transport;
import com.logistic.department.service.interfaces.DriverService;
import com.logistic.department.service.interfaces.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransportController {

    @Autowired
    TransportService transportService;

    //получение списка всех автомобилей
    @GetMapping("/transports")
    public List<Transport> showAllTransport() {
        return transportService.getAllTransports();
    }


    //получение автомобиля по id
    @GetMapping("/transports/{id}")
    public Transport getTransport(@PathVariable int id) {
        return transportService.getTransport(id);
    }

    //добавление нового автомобиля
    @PostMapping("/transports")
    public Transport addNewTransport(@RequestBody Transport transport) {
        transportService.saveTransport(transport);
        return transport;
    }

    // изменение автомобиля
    @PutMapping("/transports")
    public Transport updateTransport(@RequestBody Transport transport) {
        transportService.saveTransport(transport);
        return transport;
    }

    // удаление автомобиля
    @DeleteMapping("/transports/{id}")
    public String deleteTransport(@PathVariable int id) {
        transportService.deleteTransport(id);
        return "Автомобиль с id = " + id + " был удален";
    }
}
