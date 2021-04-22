package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.repositories.VehicleRepository;
import com.astontech.hr.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Iterable<Vehicle> listAllVehicle() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Integer id) {
        return vehicleRepository.findOne(id);
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicle(Integer id) {
        vehicleRepository.delete(id);
    }

}
