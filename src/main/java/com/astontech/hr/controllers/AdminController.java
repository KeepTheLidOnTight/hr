package com.astontech.hr.controllers;

import com.astontech.hr.domain.*;
import com.astontech.hr.domain.VO.ElementVO;
import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.services.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

//region AUTOWIRE DIRECT INJECTION
    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleMakeService vehicleMakeService;


//endregion

//regionLOGGER

    private Logger log = Logger.getLogger(AdminController.class);

//endregion

//regionADMIN HOME PAGE

    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public String adminHome() {

        return "admin/adminHome";
    }

//endregion

//    regionADD ELEMENT
    @RequestMapping(value="/admin/element/add", method = RequestMethod.GET)
    public String adminElementGet(Model model) {
        model.addAttribute("elementVO", new ElementVO());
        model.addAttribute("warningAlert","visible");
        return "admin/element/element_add";
    }

    @RequestMapping(value = "/admin/element/add", method = RequestMethod.POST)
    public String adminElementPost(ElementVO elementVO, Model model){
        elementVO.splitNewElementsIntoArray();
        logElementVO(elementVO);

        saveElementTypeAndElementsFromVO(elementVO);


        boolean success = true;
        if(success)
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");

        model.addAttribute("elementVO", new ElementVO());

        return "admin/element/element_add";
    }
    //endregion

//  regionADD VEHICLE
    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.GET)
    public String adminVehicleGet(Model model) {
        model.addAttribute("vehicleVO", new VehicleVO());
        model.addAttribute("warningAlert","visible");
        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.POST)
    public String adminElementPost(VehicleVO vehicleVO, Model model){
        vehicleVO.splitNewVehiclesIntoArray();
        logVehicleVO(vehicleVO);

        saveVehicleFromVO(vehicleVO);

        boolean success = true;
        if(success)
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");

        model.addAttribute("vehicleVO", new VehicleVO());

        return "admin/vehicle/vehicle_add";
    }

//endregion

//  regionLIST ELEMENTS
    @RequestMapping(value="/admin/element/list", method = RequestMethod.GET)
    public String adminElementList(Model model) {
        model.addAttribute("elementTypeList", elementTypeService.listAllElementType());
        return "admin/element/element_list";
    }
    //endregion

//  regionLIST VEHICLES
    @RequestMapping(value = "/admin/vehicle/list", method = RequestMethod.GET)
    public String adminVehicleList(Model model) {
        model.addAttribute("vehicleList", vehicleService.listAllVehicle());
        return "admin/vehicle/vehicle_list";
    }

    //endregion

//  regionEDIT & UPDATE ELEMENTS
    @RequestMapping(value = "/admin/element/edit/{id}", method = RequestMethod.GET)
    public String elementTypeEdit(@PathVariable int id, Model model) {
        ElementType elementType = elementTypeService.getElementTypeById(id);

        model.addAttribute("elementType", elementType);
        return "/admin/element/element_edit";
    }

    @RequestMapping(value = "/admin/element/update", method = RequestMethod.POST)
    public String elementTypeUpdate(ElementType elementType,
                                    Model model,
                                    @RequestParam("inputNewElement") String newElement) {

        //notes:    if newElement (unbound text box) has a value, add it to the list
        if(!newElement.equals("")) {
            if (elementType.getElementList() == null) {
                List<Element> elementList = new ArrayList<Element>();
                elementList.add(new Element(newElement));
                elementType.setElementList(elementList);
            } else {
                elementType.getElementList().add(new Element(newElement));
            }
        }

        //notes:    iterate thru the list of elements
        for(int i=0; i < elementType.getElementList().size(); i++) {
            //notes:        check to see if element name is empty
            if(elementType.getElementList().get(i).getElementName().equals("")) {
                //notes:        element name is blank, remove it from the list!
                elementType.getElementList().remove(i);
            }
        }

        elementTypeService.saveElement(elementType);


        return "redirect:/admin/element/edit/" + elementType.getId();
    }
    //endregion

//region EDIT & UPDATE VEHICLES
    @RequestMapping(value = "/admin/vehicle/edit/{id}", method = RequestMethod.GET)
    public String vehicleEdit(@PathVariable int id, Model model) {
        Vehicle vehicle = vehicleService.getVehicleById(id);

        model.addAttribute("vehicle", vehicle);
        return "/admin/vehicle/vehicle_edit";

    }
    @RequestMapping(value = "/admin/vehicle/update", method = RequestMethod.POST)
    public String vehicleUpdate(Vehicle vehicle) {
        System.out.println(vehicle.toString());
        VehicleMake savedMake = vehicleMakeService
                    .getVehicleMakeById(vehicle
                                    .getVehicleModel()
                                    .getVehicleMake().getId());
        savedMake.setVehicleMakeName(vehicle
                                    .getVehicleModel()
                                    .getVehicleMake()
                                    .getVehicleMakeName());
        VehicleModel savedModel = vehicleModelService
                    .getVehicleModelById(vehicle
                                    .getVehicleModel()
                                    .getId());
        savedModel.setVehicleModelName(vehicle
                                    .getVehicleModel()
                                    .getVehicleModelName());

        vehicleService.saveVehicle(vehicle);

        return "redirect:/admin/vehicle/edit/" + vehicle.getId();
    }

    //endregion

//regionDELETE ELEMENTS
    @RequestMapping(value = "/admin/element/delete/{id}", method = RequestMethod.GET)
    public String elementTypeDelete(@PathVariable int id) {
        elementTypeService.deleteElementType(id);

        return "redirect:/admin/element/list";
    }
    //endregion

//regionDELETE VEHICLES
    @RequestMapping(value = "/admin/vehicle/delete/{id}", method = RequestMethod.GET)
    public String vehicleDelete(@PathVariable int id) {
//        vehicleMakeService.deleteVehicleMake(id);
//        vehicleModelService.deleteVehicleModel(id);
        vehicleService.deleteVehicle(id);

        return "redirect:/admin/vehicle/list";
    }

    //endregion

//region HELPER METHODS

    private void saveElementTypeAndElementsFromVO(ElementVO elementVO) {
        List<Element> newElementList = new ArrayList<>();
        for(String str : elementVO.getNewElementArray()) {
            newElementList.add(new Element(str));
        }
        ElementType newElementType = new ElementType(elementVO.getNewElementType());
        newElementType.setElementList(newElementList);

        elementTypeService.saveElement(newElementType);

    }

    private void logElementVO(ElementVO elementVO) {
        log.info("New Element Type: " + elementVO.getNewElementType());

        for(String str : elementVO.getNewElementArray()) {
            log.info("New Element: " + str);
        }

    }

    private void saveVehicleFromVO(VehicleVO vehicleVO) {
        Vehicle newVehicle = new Vehicle(
                vehicleVO.getNewVehicleName(),
                vehicleVO.getNewVehicleYear(),
                vehicleVO.getNewVehicleLicensePlate(),
                vehicleVO.getNewVehicleVin(),
                vehicleVO.getNewVehicleColor());

        String newVehicleModel = vehicleVO.getNewVehicleModel();
        String newVehicleMake = vehicleVO.getNewVehicleMake();

        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setVehicleModelName(newVehicleModel);

        VehicleMake vehicleMake = new VehicleMake();
        vehicleMake.setVehicleMakeName(newVehicleMake);
        vehicleModel.setVehicleMake(vehicleMake);
        newVehicle.setVehicleModel(vehicleModel);

        vehicleModelService.saveVehicleModel(vehicleModel);
        vehicleMakeService.saveVehicleMake(vehicleMake);
        vehicleService.saveVehicle(newVehicle);


    }

    private void logVehicleVO(VehicleVO vehicleVO) {
        log.info("New Vehicle Name: " + vehicleVO.getNewVehicleName());

        for(String str : vehicleVO.getNewVehicleArray()) {
            log.info("New Vehicle: " + str);
        }
    }


    //endregion
}
