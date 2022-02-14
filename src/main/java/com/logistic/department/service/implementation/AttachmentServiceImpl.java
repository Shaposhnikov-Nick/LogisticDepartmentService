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
    public boolean checkDriverBeforeAttachmentTransport(int transport_id, int driver_id) {
        boolean isChecked = false;

        Transport transport = transportService.getTransport(transport_id);

        Driver driver = driverService.getDriver(driver_id);

        // за водителем закреплено меньше 3 автомобилей и срок действия ВУ не истек
        if (driver.getTransports().size() < 3
                && driver.getLicenceValidity().isAfter(LocalDate.now().plusMonths(1))) {

            // категория автомобиля соответствует категории ВУ
            if ((transport.getTransportCategory().equals("B") && driver.isLicenseCategoryB())
                    || (transport.getTransportCategory().equals("C") && driver.isLicenseCategoryC())
                    || (transport.getTransportCategory().equals("D") && driver.isLicenseCategoryD())) {
                isChecked = true;
            }
        }
        return isChecked;
    }

    @Override
    public void attachmentTransportToDriver(int transport_id, int driver_id) {
        Transport transport = transportService.getTransport(transport_id);

        if (checkDriverBeforeAttachmentTransport(transport_id, driver_id))
            transport.setDriverId(driver_id);

        transportService.saveTransport(transport);
    }

    @Override
    public void detachmentTransportFromDriver(int transport_id, int driver_id) {

    }
}
