package com.astontech.hr.bootstrap;

import com.astontech.hr.domain.*;
import com.astontech.hr.services.ElementService;
import com.astontech.hr.services.ElementTypeService;
import com.astontech.hr.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ElementService elementService;

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private EmployeeService employeeService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        generateElementAndElementTypes();
//          generateEmployees();
    }

    private void generateElementAndElementTypes() {

        //laptop
        ElementType laptopType = new ElementType("Laptop");

        List<Element> elementList = new ArrayList<>();
        elementList.add(new Element("Acer"));
        elementList.add(new Element("Dell"));
        elementList.add(new Element("Samsung"));
        elementList.add(new Element("Apple"));
        elementList.add(new Element("Asus"));

        laptopType.setElementList(elementList);

        elementTypeService.saveElement(laptopType);

        //email
        ElementType emailType = new ElementType("Email");

        List<Element> emailList = new ArrayList<>();
        emailList.add(new Element("Work"));
        emailList.add(new Element("Personal"));
        emailList.add(new Element("Delegated"));

        emailType.setElementList(emailList);

        elementTypeService.saveElement(emailType);

//        Vehicle vehicle = new Vehicle("Ryans");
//        VehicleMake make = new VehicleMake();
//        VehicleModel model = new VehicleModel();
//        model.setVehicleList(new ArrayList<Vehicle>());
//        model.getVehicleList().add(vehicle);
//        make.setVehicleModelList(new ArrayList<>());
//        make.getVehicleModelList().add(model);
//        vehicleMakeService.saveVehicleMake(make);
    }

    private void generateEmployees() {

        Employee employee = new Employee();
        employee.setFirstName("Ryan");
        employee.setLastName("Freese");
        employee.setBackground("Java Developer");
        employeeService.saveEmployee(employee);

        Employee employee1 = new Employee();
        employee1.setFirstName("Bipin");
        employee1.setLastName("Butala");
        employee1.setBackground("Java Developer");
        employeeService.saveEmployee(employee1);

        Employee employee2 = new Employee();
        employee2.setFirstName("Taylor");
        employee2.setLastName("Thurman");
        employee2.setBackground("DotNet Developer");
        employeeService.saveEmployee(employee2);

        Employee employee3 = new Employee();
        employee3.setFirstName("Eric");
        employee3.setLastName("Holm");
        employee3.setBackground("Contact Center Engineer");
        employeeService.saveEmployee(employee3);

    }
}
