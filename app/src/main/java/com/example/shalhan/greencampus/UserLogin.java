package com.example.shalhan.greencampus;

/**
 * Created by shalhan on 16/12/15.
 */
public class UserLogin {
    private String user;
    private String status;


    public UserLogin(){

    }

    public UserLogin(String usr, String stat){
        setUser(usr);
        setStatus(stat);
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
}
