package com.fyp.tmsapi.tms;

public class ServiceProvider {
    private int serviceID;
    private double capability;

    public ServiceProvider(int serviceID, double capability) {
        this.serviceID = serviceID;
        this.capability = capability;
    }

    double getCapability() {
        return capability;
    }

    @Override
    public String toString() {
        return "SP: " + serviceID;
    }
}
