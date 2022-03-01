package com.example.rentacarapptestphase;

public class Manager
{
    String name;
    String username;
    String passwrod;
    String email;
    String mobileNo;
    String address;
    String status;

    public Manager() {
    }

    public Manager(String name, String username, String passwrod, String email, String mobileNo, String address, String status)
    {
        this.name = name;
        this.username = username;
        this.passwrod = passwrod;
        this.email = email;
        this.mobileNo = mobileNo;
        this.address = address;
        this.status = status;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
