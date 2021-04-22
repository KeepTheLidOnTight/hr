package com.astontech.hr.domain;

import javax.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleId")
    private Integer id;

    @Version
    private Integer version;

    private String vehicleName;
    private String vehicleYear;
    private String vehicleLicensePlate;
    private String vehicleVin;
    private String vehicleColor;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private VehicleModel vehicleModel;

    public Vehicle() {
    }

    public Vehicle(String vehicleName) {
        this.setVehicleName(vehicleName);
    }

    public Vehicle(String vehicleName, String vehicleYear, String vehicleLicensePlate, String vehicleVin, String vehicleColor) {
        this.vehicleName = vehicleName;
        this.vehicleYear = vehicleYear;
        this.vehicleLicensePlate = vehicleLicensePlate;
        this.vehicleVin = vehicleVin;
        this.vehicleColor = vehicleColor;
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

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(String vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public String getVehicleLicensePlate() {
        return vehicleLicensePlate;
    }

    public void setVehicleLicensePlate(String vehicleLicensePlate) {
        this.vehicleLicensePlate = vehicleLicensePlate;
    }

    public String getVehicleVin() {
        return vehicleVin;
    }

    public void setVehicleVin(String vehicleVin) {
        this.vehicleVin = vehicleVin;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", version=" + version +
                ", vehicleName='" + vehicleName + '\'' +
                ", vehicleYear='" + vehicleYear + '\'' +
                ", vehicleLicensePlate='" + vehicleLicensePlate + '\'' +
                ", vehicleVin='" + vehicleVin + '\'' +
                ", vehicleColor='" + vehicleColor + '\'' +
                ", vehicleModel=" + vehicleModel +
                '}';
    }
}
