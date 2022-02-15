package com.logistic.department.controller;

import com.logistic.department.entity.Transport;
import com.logistic.department.service.interfaces.AttachmentService;
import com.logistic.department.service.interfaces.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @Autowired
    TransportService transportService;

    // закрепление автомобиля за водителем
    @PutMapping("/transports/attachment/{transport_id}/{driver_id}")
    public Transport attachTransportToDriver(@PathVariable int transport_id, @PathVariable int driver_id) {
        Transport transport = transportService.getTransport(transport_id);
        attachmentService.attachmentTransportToDriver(transport, driver_id);
        return transport;
    }

    // открепление автомобиля от водителя
    @PutMapping("/transports/detachment/{transport_id}")
    public Transport detachTransportFromDriver(@PathVariable int transport_id) {
        Transport transport = transportService.getTransport(transport_id);
        attachmentService.detachmentTransportFromDriver(transport);
        return transport;
    }
}
