package com.astontech.hr.domain;

import javax.persistence.*;

@Entity
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleModelId")
    private Integer id;

    @Version
    private Integer version;

    private String vehicleModelName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private VehicleMake vehicleMake;

    public VehicleModel() {
    }

    public VehicleModel(String vehicleModelName) {
        this.setVehicleModelName(vehicleModelName);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    public VehicleMake getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(VehicleMake vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }

    @Override
    public String toString() {
        return "VehicleModel{" +
                "id=" + id +
                ", version=" + version +
                ", vehicleModelName='" + vehicleModelName + '\'' +
                ", vehicleMake=" + vehicleMake +
                '}';
    }
}
