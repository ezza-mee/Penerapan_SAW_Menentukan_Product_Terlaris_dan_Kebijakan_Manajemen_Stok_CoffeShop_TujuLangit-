package com.main.models.dataStaff;

public class getterAccountStaff {
    private int idAccount, idStaff;
    private String email;
    private String password;

    public getterAccountStaff(int idAccount, int idStaff, String email, String password) {
        this.idAccount = idAccount;
        this.idStaff = idStaff;
        this.email = email;
        this.password = password;
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
}
