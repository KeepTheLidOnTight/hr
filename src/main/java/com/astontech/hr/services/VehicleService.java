package com.astontech.hr.services;

import com.astontech.hr.domain.Vehicle;

public interface VehicleService {

    Iterable<Vehicle> listAllVehicle();

    Vehicle getVehicleById(Integer id);

    Vehicle saveVehicle(Vehicle vehicle);

    void deleteVehicle(Integer id);
}
