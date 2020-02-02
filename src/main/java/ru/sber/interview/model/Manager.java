package ru.sber.interview.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String serviceName;
    private String managerLogin;
    private String serviceTimeStart;
    private String serviceTimeEnd;

    public Manager(String serviceName,
                   String managerLogin,
                   String serviceTimeStart,
                   String serviceTimeEnd){

        this.serviceName = serviceName;
        this.managerLogin = managerLogin;
        this.serviceTimeStart = serviceTimeStart;
        this.serviceTimeEnd = serviceTimeEnd;
    }

    public Manager(){

    }

    public String getServiceName() {
        return serviceName;
    }

    public String getManagerLogin() {
        return managerLogin;
    }

    public String getServiceTimeStart() {
        return serviceTimeStart;
    }

    public String getServiceTimeEnd() {
        return serviceTimeEnd;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setManagerLogin(String managerLogin) {
        this.managerLogin = managerLogin;
    }

    public void setServiceTimeStart(String serviceTimeStart) {
        this.serviceTimeStart = serviceTimeStart;
    }

    public void setServiceTimeEnd(String serviceTimeEnd) {
        this.serviceTimeEnd = serviceTimeEnd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
