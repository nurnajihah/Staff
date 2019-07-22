package sg.edu.rp.c346.user;

import java.io.Serializable;

public class Staff implements Serializable {
    private int id;
    private String name;
    private int contact;
    private String email;
    private Boolean status;
    private String username;
    private String password;
    private String role_name;

    public Staff() {
    }

    public Staff(String name, int contact, String email, Boolean status, String role_name) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.status = status;
        this.role_name = role_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
