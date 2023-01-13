package com.wissen.scheduler.impl;

import com.wissen.entity.Employee;
import com.wissen.model.Email;
import com.wissen.scheduler.Scheduler;
import com.wissen.service.EmailService;
import com.wissen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.*;

/**
 * Method to schedule emails.
 *
 * @author Vishal Tomar
 */
@Component
public class EmailScheduler implements Scheduler {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmailService emailService;

    private static String BIRTHDAY_KEY = "BIRTHDAY_KEY";
    private static String WORK_ANNIVERSARY_KEY = "WORK_ANNIVERSARY_KEY";

    /**
     * Will start sending mails at 1:01:AM daily
     */
    @Scheduled(cron = "0 1 1 * * ?")
    @Override
    public void scheduleEmails() {

        // getting employee map
        Map<String, List<Employee>> employeeMap = getEmployeeMap();

        // sending mails to wish happy birthday
        employeeMap.get(BIRTHDAY_KEY).parallelStream().forEach(employee -> {
            Email email = new Email();
            email.setTo(employee.getEmail());
            email.setFrom("vishal.tomar@wissen.com");
            email.setCc("vishal.tomar@wissen.com");
            email.setSubject("Happy Birthday " + employee.getFirstName());
            email.setTemplate(getTemplateNameByKey(BIRTHDAY_KEY));
            email.getProperties().put("name", employee.getFirstName() + " " + employee.getLastName());
            email.setProperties(email.getProperties());

            try {
                emailService.sendHtmlMessage(email);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        });

        // sending mails to wish happy birthday
        employeeMap.get(WORK_ANNIVERSARY_KEY).parallelStream().forEach(employee -> {
            Email email = new Email();
            email.setTo(employee.getEmail());
            email.setFrom("vishal.tomar@wissen.com");
            email.setCc("vishal.tomar@wissen.com");
            email.setSubject("Happy Work Anniversary " + employee.getFirstName());
            email.setTemplate(getTemplateNameByKey(WORK_ANNIVERSARY_KEY));
            email.getProperties().put("name", employee.getFirstName() + " " + employee.getLastName());
            email.setProperties(email.getProperties());

            try {
                emailService.sendHtmlMessage(email);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        });

    }

    public Map<String, List<Employee> > getEmployeeMap() {
        Map<String, List<Employee>> employeeMap = new HashMap<>();
        employeeMap.put(BIRTHDAY_KEY, new ArrayList<>());
        employeeMap.put(WORK_ANNIVERSARY_KEY, new ArrayList<>());

        List<Employee> employeeList = this.employeeService.getEmployees();

        employeeList.stream().forEach(employee -> {

            if(isTodayBirthday(employee.getDob())) {
                employeeMap.get(BIRTHDAY_KEY).add(employee);
            }

            if(isTodayDateOfJoining(employee.getDoj())) {
                employeeMap.get(WORK_ANNIVERSARY_KEY).add(employee);
            }
        });
        return employeeMap;
    }

    private boolean isTodayBirthday(Date dob) {
        Date date = new Date();
        return date.getMonth() == dob.getMonth()
                && date.getDate() == dob.getDate();
    }

    private boolean isTodayDateOfJoining(Date doj) {
        Date date = new Date();
        return date.getMonth() == doj.getMonth()
                && date.getDate() == doj.getDate();
    }

    public String getTemplateNameByKey(String key) {
        String templateName = "";
        switch (key) {
            case "BIRTHDAY_KEY":
                templateName += "BIRTHDAY_TEMPLATE.html";
                break;
            case "WORK_ANNIVERSARY_KEY":
                templateName += "WORK_ANNIVERSARY_TEMPLATE.html";
                break;
            default:
                break;
        }
        return templateName;
    }
}
