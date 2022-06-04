/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

/**
 *
 * @author User
 */
public class user2 {
    private String email,pass,sq,sa,mobile,aadhar,name;

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getSq() {
        return sq;
    }

    public String getSa() {
        return sa;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAadhar() {
        return aadhar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAadhar(String aadhar) {
        if(aadhar=="" || aadhar==null)
            this.aadhar="null";
        else
            this.aadhar = aadhar;
    }
    
    public void setEmail(String email) {
        this.email=email;
    }

    public void setPass(String pass) {
        this.pass=pass;
    }

    public void setSq(String sq) {
        this.sq=sq;
    }

    public void setSa(String sa) {
        this.sa=sa;
    }
    public void setMobile(String mobile) {
        if(mobile=="" || mobile==null)
            this.mobile="null";
        else
            this.mobile = mobile;
    }

    public user2(String email, String pass, String sq, String sa, String mobile, String aadhar, String name) {
        setEmail(email);
        setPass(pass);
        setSq(sq);
        setSa(sa);
        setMobile(mobile);
        setAadhar(aadhar);
        setName(name);
    }
    public user2(){
    }
    
}
