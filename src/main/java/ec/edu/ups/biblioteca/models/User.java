package ec.edu.ups.biblioteca.models;

import java.util.Date;

public class User extends Person{
    private String mail;
    private String password;
    private boolean restrictions;
    private boolean canRequest;

    public User() {
    }

    public User(String mail, String password, boolean restrictions,String name, int iD, Date birthday,boolean canRequest) {
        super(name,iD,birthday);
        this.mail = mail;
        this.password = password;
        this.restrictions = restrictions;
        this.canRequest = canRequest;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRestrictions() {
        return restrictions;
    }

    public void setRestrictions(boolean restrictions) {
        this.restrictions = restrictions;
    }

    public boolean isCanRequest() {
        return canRequest;
    }

    public void setCanRequest(boolean canRequest) {
        this.canRequest = canRequest;
    }
}
