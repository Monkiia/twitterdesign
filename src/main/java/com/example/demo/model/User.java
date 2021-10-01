package com.example.demo.model;

import com.example.demo.DAO.UseriDAO;
import com.example.demo.repository.UserRepository;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Users")
// 问题 UserDAO Repository 都是接口 实际实现 class model?
public class User {
    @Id
    @Column(name = "uid", nullable = false)
    private int id;

    @Column(name = "last_login_time")
    private Date last_login_time;

    @Column(name = "activestatus")
    private Boolean activeStatus;

    @Column(name = "blackliststatus")
    private Boolean blackliststatus;

    @Column(name = "email", nullable = false, length = 30)
    private String email;

    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @Column(name = "location", nullable = false, length = 30)
    private String location;

    @Column(name = "username", nullable = false, length = 30)
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getBlackliststatus() {
        return blackliststatus;
    }

    public void setBlackliststatus(Boolean blackliststatus) {
        this.blackliststatus = blackliststatus;
    }

    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User [id =" + id + ",username = " + username;
    }


}
