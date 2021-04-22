package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleModel;

public interface VehicleModelService {

    Iterable<VehicleModel> listAllVehicleModel();

    VehicleModel getVehicleModelById(Integer id);

    VehicleModel saveVehicleModel(VehicleModel vehicleModel);

    void deleteVehicleModel(Integer id);
}
