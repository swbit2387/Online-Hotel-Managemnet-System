/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

/**
 *
 * @author User
 */
public class admin {
    private String adminEmail,adminPassword,adminAadhar,adminName;

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminAadhar() {
        return adminAadhar;
    }

    public void setAdminAadhar(String adminAadhar) {
        this.adminAadhar = adminAadhar;
    }

    public admin(String adminEmail, String adminPassword, String adminAadhar,String adminName) {
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
        this.adminAadhar = adminAadhar;
        this.adminName=adminName;
    }
    public admin(){
        
    }
}
