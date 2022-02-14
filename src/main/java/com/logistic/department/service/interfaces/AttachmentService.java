package com.logistic.department.service.interfaces;

public interface AttachmentService {

    // проверка водителя перед закрепление автомобиля (открытые категории, дата окончания действия ВУ,
    // количество закрепленных за водителем автомобилей
    boolean checkDriverBeforeAttachmentTransport(int transport_id, int driver_id);

    // закрепление автомобиля за водителем
    void attachmentTransportToDriver(int transport_id, int driver_id);

    // открепление водителя от автомобиля
    void detachmentTransportFromDriver(int transport_id, int driver_id);
}
