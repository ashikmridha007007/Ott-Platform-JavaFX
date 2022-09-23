/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author HP
 */
public class User {
    String name, userType, eid, password, phoneNumber;

    public String getName() {
        return name;
    }

    public String getUserType() {
        return userType;
    }

    public String getEid() {
        return eid;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User(String name, String userType, String eid, String password, String phoneNumber) {
        this.name = name;
        this.userType = userType;
        this.eid = eid;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }
    
}
