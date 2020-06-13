package com.gmail.gorbasenko245.entity.entity;

import javax.persistence.*;

@Entity
public class UserIP {
    @Id
    @GeneratedValue
    private Long id;

    private String ip;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public UserIP(String ip) {
        this.ip = ip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
