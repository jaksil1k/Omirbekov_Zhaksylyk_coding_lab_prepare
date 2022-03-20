package com.company;

public class Customer {
    private int id;
    private String fname;
    private String lname;
    private String phone;
    private float balance;

    public Customer() {
    }

    public Customer(int id, String fname, String lname, String phone, float balance) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "id: " + id +
               ", FirstName: '" + fname + '\'' +
               ", LastName: '" + lname + '\'' +
               ", Phone: '" + phone + '\'' +
               ", Balance: " + balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFname() {
        return fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLname() {
        return lname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }

}
