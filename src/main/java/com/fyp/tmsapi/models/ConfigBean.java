package com.fyp.tmsapi.models;

import java.util.ArrayList;
import java.util.List;

public class ConfigBean {


    private List<Config> studentRecords;
    private static ConfigBean stdregd = null;
    
    private ConfigBean(){
        studentRecords = new ArrayList<Config>();
    }
    public static ConfigBean getInstance() {
        if(stdregd == null) {
            stdregd = new ConfigBean();
            return stdregd;
        }
        else {
            return stdregd;
        }
    }

    public void add(Config std) {
        studentRecords.add(std);
    }


    public String upDateStudent(Config std) {
        for(int i=0; i<studentRecords.size(); i++)
        {
            Config stdn = studentRecords.get(i);
            if(stdn.getRegistrationNumber().equals(std.getRegistrationNumber())) {
                studentRecords.set(i, std);//update the new record
                return "Update successful";
            }
        }
        return "Update un-successful";
    }
    public String deleteStudent(String registrationNumber) {
        for(int i=0; i<studentRecords.size(); i++)
        {
            Config stdn = studentRecords.get(i);
            if(stdn.getRegistrationNumber().equals(registrationNumber)){
                studentRecords.remove(i);//update the new record
                return "Delete successful";
            }
        }
        return "Delete un-successful";
    }
    public List<Config> getStudentRecords() {
        return studentRecords;
    }
}
