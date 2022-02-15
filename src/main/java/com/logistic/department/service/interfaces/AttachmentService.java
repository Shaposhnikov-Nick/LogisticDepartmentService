package com.logistic.department.service.interfaces;

import com.logistic.department.entity.Transport;

public interface AttachmentService {

    // проверка водителя перед закрепление автомобиля (открытые категории, дата окончания действия ВУ,
    // количество закрепленных за водителем автомобилей
    boolean checkDriverBeforeAttachmentTransport(Transport transport, int driver_id);

    // закрепление автомобиля за водителем
    void attachmentTransportToDriver(Transport transport, int driver_id);

    // открепление водителя от автомобиля
    void detachmentTransportFromDriver(Transport transport);
}
