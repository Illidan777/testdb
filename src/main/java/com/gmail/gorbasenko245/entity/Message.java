package com.gmail.gorbasenko245.entity;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private String msg;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userMessage;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account accountMessage;

    public Message() {
    }

    public Message(String name, String email, String msg) {
        this.name = name;
        this.email = email;
        this.msg = msg;
    }

    public User getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(User userMessage) {
        this.userMessage = userMessage;
    }

    public Account getAccountMessage() {
        return accountMessage;
    }

    public void setAccountMessage(Account accountMessage) {
        this.accountMessage = accountMessage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Повідомлення від - " +
                "імя - " + name + '\'' +
                ", email - " + email + '\'' +
                ", повідомлення - " + msg + '\'';
    }
}
