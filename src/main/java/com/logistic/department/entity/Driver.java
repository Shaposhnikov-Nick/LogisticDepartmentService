package com.logistic.department.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "driver_license_category_b")
    private boolean licenseCategoryB = false;

    @Column(name = "driver_license_category_c")
    private boolean licenseCategoryC = false;

    @Column(name = "driver_license_category_d")
    private boolean licenseCategoryD = false;

    @Column(name = "driver_license_validity")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate licenceValidity;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy = "driver_id")
    private List<Transport> transports;

//    @ManyToMany
//    @JoinTable(name = "driver_licenses"
//            , joinColumns = @JoinColumn(name = "driver_id")
//            , inverseJoinColumns = @JoinColumn(name = "driven_license_id"))
//    private List<DrivingLicense> licenses;

//    public void addTransportsToDriver(Transport transport) {
//        if (transports == null)
//            transports = new ArrayList<>();
//
//        transports.add(transport);
//        transport.setDriver(this);
//    }

//    public void addDrivingLicenseToDriver(DrivingLicense drivingLicense) {
//        if (licenses == null)
//            licenses = new ArrayList<>();
//
//        licenses.add(drivingLicense);
//    }
}
