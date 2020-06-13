package com.gmail.gorbasenko245.entity.entity;

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
    private String company;
    private String country;
    private String city;
    private String region;
    private String phone;
    private String email;



    @OneToMany(mappedBy = "userOrder", cascade = CascadeType.ALL)
    private List<Invoice> invoices = new ArrayList<Invoice>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserIP> IPList = new ArrayList<UserIP>();

    public User() {
    }

    public User(String name, String surname, String company, String country, String city, String region, String phone, String email) {
        this.name=name;
        this.surname = surname;
        this.company=company;
        this.country = country;
        this.city = city;
        this.region = region;
        this.phone = phone;
        this.email = email;
    }
    public void addOrder(Invoice invoice){
        if(!invoices.contains(invoice)){
            invoices.add(invoice);
            invoice.setUserOrder(this);
        }
    }

    public void addIP(UserIP userIP){
        if(!IPList.contains(userIP)){
            IPList.add(userIP);
            userIP.setUser(this);
        }
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<UserIP> getIPList() {
        return IPList;
    }

    public void setIPList(List<UserIP> IPList) {
        this.IPList = IPList;
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
                ", назва компанії- " + company + '\'' +
                ", держава- " + country + '\'' +
                ", місто- " + city + '\'' +
                ", регіон- " + region + '\'' +
                ", телефон- " + phone + '\'' +
                ", email- " + email + '\'';
    }
}
