package com.example.splash_screen;

public class User {
    private String eaddress_s;
    private String ename_s;
    private String oaddress_s;
    private String oname_s;
    private String phone_s;

    public User(String eaddress_s, String ename_s, String oaddress_s, String oname_s, String phone_s) {
        this.eaddress_s = eaddress_s;
        this.ename_s = ename_s;
        this.oaddress_s = oaddress_s;
        this.oname_s = oname_s;
        this.phone_s = phone_s;
    }

    public User() {
    }

    public String getEaddress_s() {
        return eaddress_s;
    }

    public void setEaddress_s(String eaddress_s) {
        this.eaddress_s = eaddress_s;
    }

    public String getEname_s() {
        return ename_s;
    }

    public void setEname_s(String ename_s) {
        this.ename_s = ename_s;
    }

    public String getOaddress_s() {
        return oaddress_s;
    }

    public void setOaddress_s(String oaddress_s) {
        this.oaddress_s = oaddress_s;
    }

    public String getOname_s() {
        return oname_s;
    }

    public void setOname_s(String oname_s) {
        this.oname_s = oname_s;
    }

    public String getPhone_s() {
        return phone_s;
    }

    public void setPhone_s(String phone_s) {
        this.phone_s = phone_s;
    }
}
