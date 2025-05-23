package com.main.models.dataStaff;

public class getterDataStaff {
    private int idStaff;
    private String name, email, phoneNumber, gender, jobdesk, address, password;

    public getterDataStaff(int idStaff, String name, String email, String phoneNumber, String gender,
            String jobdesk,
            String address) {
        this.idStaff = idStaff;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.jobdesk = jobdesk;
        this.address = address;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getJobdesk() {
        return jobdesk;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }
}
