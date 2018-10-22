package com.fyp.tmsapi.controllers;


import com.fyp.tmsapi.models.Config;
import com.fyp.tmsapi.models.ConfigBean;
import com.fyp.tmsapi.models.ConfigReply;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConfigController {
    /* GET

     */
    @RequestMapping(method = RequestMethod.GET, value="/config/all")
    @ResponseBody
    public List<Config> getAllStudents() {
        return ConfigBean.getInstance().getStudentRecords();
    }

    /* POST

     */
    @RequestMapping(method = RequestMethod.POST, value="/register/student")
    @ResponseBody
    public ConfigReply registerStudent(@RequestBody Config student) {
        System.out.println("In registerStudent");
        ConfigReply stdregreply = new ConfigReply();
        ConfigBean.getInstance().add(student);
        //We are setting the below value just to reply a message back to the caller
        stdregreply.setName(student.getName());
        stdregreply.setAge(student.getAge());
        stdregreply.setRegistrationNumber(student.getRegistrationNumber());
        stdregreply.setRegistrationStatus("Successful");
        return stdregreply;
    }

    /* UPDATE

     */
    @RequestMapping(method = RequestMethod.PUT, value="/update/student")
    @ResponseBody
    public String updateStudentRecord(@RequestBody Config stdn) {
        System.out.println("In updateStudentRecord");
        return ConfigBean.getInstance().upDateStudent(stdn);
    }

    /* DELETE

     */
    @RequestMapping(method = RequestMethod.DELETE, value="/delete/student/{regdNum}")
    @ResponseBody
    public String deleteStudentRecord(@PathVariable("regdNum") String regdNum) {
        System.out.println("In deleteStudentRecord");
        return ConfigBean.getInstance().deleteStudent(regdNum);
    }

    /* RUN TASK

     */
    @RequestMapping(method = RequestMethod.GET, value="/run")
    @ResponseBody
    public String runSimulation() {
        System.out.println("In simulation running");
        return SimulationController.getInstance().run();
    }

}
