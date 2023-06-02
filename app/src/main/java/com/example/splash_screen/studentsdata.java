package com.example.splash_screen;

public class studentsdata {
    private String department;
    private String name;
    private String rollno;
    private String year;

    public studentsdata() {
    }

    public studentsdata(String department, String name, String rollno, String year) {
        this.department = department;
        this.name = name;
        this.rollno = rollno;
        this.year = year;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
