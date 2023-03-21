package com.example.flendzzemp;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class EmployeeModel {
    @SerializedName("body")
    int id;
    String name;
    String email;
    Map<String,Object> address;
    String phone;
    String website;
    Map<String,Object> company;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Map<String, Object> getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Map<String, Object> getCompanyAddress() {
        return company;
    }
}
