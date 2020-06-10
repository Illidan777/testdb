package com.gmail.gorbasenko245.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private String nameOfCompany;
    private String country;
    private String city;
    private String region;
    private String phone;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "userOrder", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<Order>();

    @OneToMany(mappedBy = "userMessage", cascade = CascadeType.ALL)
    private List<Message> messages = new ArrayList<Message>();



    public User() {
    }

    public User(String name, String surname, String nameOfCompany, String country, String city, String region, String phone, String email) {
        this.name=name;
        this.surname = surname;
        this.nameOfCompany = nameOfCompany;
        this.country = country;
        this.city = city;
        this.region = region;
        this.phone = phone;
        this.email = email;
    }
    public void addOrder(Order order){
        if(!orders.contains(order)){
            orders.add(order);
            order.setUserOrder(this);
        }
    }
    public void addMessage(Message message){
        if(!messages.contains(message)){
            messages.add(message);
            message.setUserMessage(this);
        }
    }
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Клієнт - " +
                "ім'я- " + name + '\'' +
                ", прізвище- " + surname + '\'' +
                ", назва компанії- " + nameOfCompany + '\'' +
                ", держава- " + country + '\'' +
                ", місто- " + city + '\'' +
                ", регіон- " + region + '\'' +
                ", телефон- " + phone + '\'' +
                ", email- " + email + '\'';
    }
}
