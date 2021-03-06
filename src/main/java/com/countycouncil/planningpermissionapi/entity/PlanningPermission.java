package com.countycouncil.planningpermissionapi.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PlanningPermission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int referenceId ;

    @Column(nullable = false)
    private String applicantFirstName;

    @Column(nullable = false)
    private String applicantLastName;

    @Column(nullable = false)
    private double houseArea;

    @Column(nullable = false)
    private String applicationStatus;

    @Column(nullable = false)
    private int oneOffHousingId; // Rural = 0; Urban = 1

    public PlanningPermission(){

    }

    public PlanningPermission(int referenceId, String applicantFirstName, String applicantLastName, double houseArea, String applicationStatus, int oneOffHousingId) {
        this.referenceId = referenceId;
        this.applicantFirstName = applicantFirstName;
        this.applicantLastName = applicantLastName;
        this.houseArea = houseArea;
        this.applicationStatus = applicationStatus;
        this.oneOffHousingId = oneOffHousingId;
    }

    public int getReferenceId() {
        return referenceId;
    }

    public String getApplicantFirstName() {
        return applicantFirstName;
    }

    public void setApplicantFirstName(String applicantFirstName) {
        this.applicantFirstName = applicantFirstName;
    }

    public String getApplicantLastName() {
        return applicantLastName;
    }

    public void setApplicantLastName(String applicantLastName) {
        this.applicantLastName = applicantLastName;
    }

    public double getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(double houseArea) {
        this.houseArea = houseArea;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public int getOneOffHousingId() {
        return oneOffHousingId;
    }

    public void setOneOffHousingId(int oneOffHousingId) {
        this.oneOffHousingId = oneOffHousingId;
    }
}

