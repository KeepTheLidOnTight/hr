package com.astontech.hr.domain.VO;

public class VehicleVO {

    private String newVehicleName;
    private String newVehicleYear;
    private String newVehicleLicensePlate;
    private String newVehicleVin;
    private String newVehicleColor;
    private String newVehicleMake;
    private String newVehicleModel;
    private String[] newVehicleArray;

    public VehicleVO() {
    }

    public void splitNewVehiclesIntoArray(){
        this.setNewVehicleArray(this.getNewVehicleMake().split("\\r?\\n"));
    }

    public String getNewVehicleName() {
        return newVehicleName;
    }

    public void setNewVehicleName(String newVehicleName) {
        this.newVehicleName = newVehicleName;
    }

    public String getNewVehicleYear() {
        return newVehicleYear;
    }

    public void setNewVehicleYear(String newVehicleYear) {
        this.newVehicleYear = newVehicleYear;
    }

    public String getNewVehicleLicensePlate() {
        return newVehicleLicensePlate;
    }

    public void setNewVehicleLicensePlate(String newVehicleLicensePlate) {
        this.newVehicleLicensePlate = newVehicleLicensePlate;
    }

    public String getNewVehicleVin() {
        return newVehicleVin;
    }

    public void setNewVehicleVin(String newVehicleVin) {
        this.newVehicleVin = newVehicleVin;
    }

    public String getNewVehicleColor() {
        return newVehicleColor;
    }

    public void setNewVehicleColor(String newVehicleColor) {
        this.newVehicleColor = newVehicleColor;
    }

    public String getNewVehicleMake() {
        return newVehicleMake;
    }

    public void setNewVehicleMake(String newVehicleMake) {
        this.newVehicleMake = newVehicleMake;
    }

    public String getNewVehicleModel() {
        return newVehicleModel;
    }

    public void setNewVehicleModel(String newVehicleModel) {
        this.newVehicleModel = newVehicleModel;
    }

    public String[] getNewVehicleArray() {
        return newVehicleArray;
    }

    public void setNewVehicleArray(String[] newVehicleArray) {
        this.newVehicleArray = newVehicleArray;
    }
}
