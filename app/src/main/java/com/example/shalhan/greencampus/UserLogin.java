package com.example.shalhan.greencampus;

/**
 * Created by shalhan on 16/12/15.
 */
public class UserLogin {
    private String user;
    private String status;
    private String pass;


    public UserLogin(){

    }

    public UserLogin(String usr, String stat, String pass){
        setUser(usr);
        setStatus(stat);
        setPass(pass);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public String getPass(){
        return pass;
    }
}
