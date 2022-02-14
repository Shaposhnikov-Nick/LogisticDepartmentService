package com.logistic.department.service.interfaces;


import com.logistic.department.entity.Transport;

import java.util.List;

public interface TransportService {

    // получение списка транспорта
    List<Transport> getAllTransports();

    // добавление транспорта
    void saveTransport(Transport transport);

    // получение транспорта по id
    Transport getTransport(int id);

    // удаление транспорта по id
    void deleteTransport(int id);

}
