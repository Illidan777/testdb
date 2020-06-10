package com.gmail.gorbasenko245.entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    private String date;
    private String number;
    private Double sum;
    private String msg;

    @OneToMany(mappedBy = "order")
    private List<Product> products = new ArrayList<Product>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userOrder;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account accountOrder;




    public Order() {
    }

    public Order(String date, String number, Double sum, List<Product> products) {
        this.number = number;
        this.date = date;
        this.sum = sum;
        this.products = products;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(User userOrder) {
        this.userOrder = userOrder;
    }

    public Account getAccountOrder() {
        return accountOrder;
    }

    public void setAccountOrder(Account accountOrder) {
        this.accountOrder = accountOrder;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

