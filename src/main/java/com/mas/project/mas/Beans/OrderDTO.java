package com.mas.project.mas.Beans;

import com.mas.project.mas.Entity.Mechanic;
import com.mas.project.mas.Entity.Service;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * Created by Janusz on 11.06.2017.
 */
@Component(value = "OrderCollector")
public class OrderDTO {

    private String brand;
    private String model;
    private String registration;
    private String engineType;
    private String prodYear;
    private String extraInfo;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    private List<String> serviceList;
    private String total;

    private String mechanicEmail;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getProdYear() {
        return prodYear;
    }

    public void setProdYear(String prodYear) {
        this.prodYear = prodYear;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfor(String extraInfor) {
        this.extraInfo = extraInfor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<String> serviceList) {
        this.serviceList = serviceList;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getMechanic() {
        return mechanicEmail;
    }

    public void setMechanic(String mechanicEmail) {
        this.mechanicEmail = mechanicEmail;
    }
}
