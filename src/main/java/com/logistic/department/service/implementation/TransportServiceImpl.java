package com.logistic.department.service.implementation;

import com.logistic.department.dao.TransportRepository;
import com.logistic.department.entity.Transport;
import com.logistic.department.service.interfaces.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportServiceImpl implements TransportService {

    @Autowired
    private TransportRepository transportRepository;

    @Override
    public List<Transport> getAllTransports() {
        return transportRepository.findAll();
    }

    @Override
    public Transport getTransport(int id) {
        Transport transport = null;
        Optional<Transport> optional = transportRepository.findById(id);
        if (optional.isPresent())
            transport = optional.get();
        return transport;
    }

    @Override
    public void saveTransport(Transport transport) {
        transportRepository.save(transport);
    }


    @Override
    public void deleteTransport(int id) {
        transportRepository.deleteById(id);
    }

    @Override
    public void attachmentTransportToDriver(Transport transport) {

    }

    @Override
    public void detachmentTransportFromDriver(Transport transport) {

    }
}
