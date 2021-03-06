package com.logistic.department.service.implementation;

import com.logistic.department.entity.Driver;
import com.logistic.department.entity.Transport;
import com.logistic.department.service.interfaces.AttachmentService;
import com.logistic.department.service.interfaces.DriverService;
import com.logistic.department.service.interfaces.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    TransportService transportService;

    @Autowired
    DriverService driverService;

    @Override
    public boolean checkDriverBeforeAttachmentTransport(Transport transport, int driver_id) {
        boolean isChecked = false;

        Driver driver = driverService.getDriver(driver_id);

        // за водителем закреплено меньше 3 автомобилей и срок действия ВУ не истек
        if (driver.getTransports().size() < 3
                && driver.getLicenceValidity().isAfter(LocalDate.now().plusMonths(1))) {

            // категория автомобиля соответствует категории ВУ
            switch (transport.getTransportCategory()) {
                case "B": {
                    if (driver.isLicenseCategoryB())
                        isChecked = true;
                }
                break;
                case "C": {
                    if (driver.isLicenseCategoryC())
                        isChecked = true;
                }
                break;
                case "D": {
                    if (driver.isLicenseCategoryD())
                        isChecked = true;
                }
                break;
            }
        }
        return isChecked;
    }

    @Override
    public void attachmentTransportToDriver(Transport transport, int driver_id) {
        if (checkDriverBeforeAttachmentTransport(transport, driver_id))
            transport.setDriverId(driver_id);

        transportService.saveTransport(transport);
    }

    @Override
    public void detachmentTransportFromDriver(Transport transport) {
        transport.setDriverId(0);

        transportService.saveTransport(transport);
    }
}
