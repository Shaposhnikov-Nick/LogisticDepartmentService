package com.logistic.department.repository;

import com.logistic.department.entity.Driver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DriverRepositoryTest {

    @Autowired
    private DriverRepository driverRepository;

    @Test
    public void testDriverRepo_found() {
        Driver driver = new Driver();
        LocalDate localDate = LocalDate.of(2022, 01, 01);
        driver.setName("Name");
        driver.setSurname("Surname");
        driver.setLicenseCategoryB(true);
        driver.setLicenseCategoryC(true);
        driver.setLicenseCategoryD(false);
        driver.setLicenceValidity(localDate);
        driverRepository.save(driver);

        Optional<Driver> driverOptional = driverRepository.findById(driver.getId());
        assertTrue(driverOptional.isPresent());
        assertEquals("Name", driverOptional.get().getName());
        assertEquals("Surname", driverOptional.get().getSurname());
        assertTrue(driverOptional.get().isLicenseCategoryB());
        assertTrue(driverOptional.get().isLicenseCategoryC());
        assertFalse(driverOptional.get().isLicenseCategoryD());
        assertEquals(localDate, driverOptional.get().getLicenceValidity());

        driverRepository.deleteById(driver.getId());
    }

}