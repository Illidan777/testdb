package com.gmail.gorbasenko245.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;
    private String pass;
    private String email;



    @OneToOne(mappedBy = "account")
    private User user;

    @OneToMany(mappedBy = "accountOrder", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<Order>();

    @OneToMany(mappedBy = "accountMessage", cascade = CascadeType.ALL)
    private List<Message> messages = new ArrayList<Message>();


    public Account() {
    }

    public Account(String login, String pass, String email) {

        this.login = login;
        this.pass = pass;
        this.email = email;
    }
    private void addOrder(Order order){
        if(!orders.contains(order)){
            orders.add(order);
            order.setAccountOrder(this);
        }
    }

    private void addMessage(Message message){
        if(!messages.contains(message)){
            messages.add(message);
            message.setAccountMessage(this);
        }
    }




    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
