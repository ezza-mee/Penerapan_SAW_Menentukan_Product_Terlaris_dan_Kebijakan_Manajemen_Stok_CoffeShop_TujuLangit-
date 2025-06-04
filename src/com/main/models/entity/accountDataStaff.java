package com.main.models.entity;

import com.main.auth.utils.Role;

public class accountDataStaff {
    private Role role;
    private int idAccount, idStaff;
    private String email;
    private String password;
    private String jobdesk;

    public accountDataStaff(int idAccount, int idStaff, String email, String password, String jobdesk) {
        this.idAccount = idAccount;
        this.idStaff = idStaff;
        this.email = email;
        this.password = password;
        this.jobdesk = jobdesk;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getJobdesk() {
        return jobdesk;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        try {
            return Role.valueOf(jobdesk.toUpperCase()); 
        } catch (Exception e) {
            return null;
        }
    }
}
