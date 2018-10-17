package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name="users")
public class User {
    private String email;

    //@Id
    public String getEmail() {
        return email;
    }

    public User(String email) {
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
