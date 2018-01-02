package javaa.Beans;

import java.io.Serializable;
import java.util.*;

public class EmployeeBean implements Serializable {
    private int id;
    private String role;
    private int salary;
    private String Suprevisor_ID;
    private String username;
    private String password;
    private Date datejoined;

    public Date getDatejoined() {
        return datejoined;
    }

    public void setDatejoined(Date datejoined) {
        this.datejoined = datejoined;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSupervisor_id() {
        return Suprevisor_ID;
    }

    public void setSupervisor_id(String supervisor_id) {
        this.Suprevisor_ID = supervisor_id;
    }


}

