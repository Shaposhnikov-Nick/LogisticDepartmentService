package com.logistic.department.service.interfaces;


import com.logistic.department.entity.Transport;

import java.util.List;

public interface TransportService {

    List<Transport> getAllTransports();

    void saveTransport(Transport transport);

    Transport getTransport(int id);

    void deleteTransport(int id);

    void attachmentTransportToDriver(Transport transport);

    void detachmentTransportFromDriver(Transport transport);
}
