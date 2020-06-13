package com.gmail.gorbasenko245.entity.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Invoice {

    @Id

    @GeneratedValue
    private String id;

    private String date;
    private Double sum;
    private String msg;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userOrder;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "product_catalog",
        joinColumns = @JoinColumn(name = "invoice_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<Product>();

    @OneToOne(cascade = CascadeType.ALL,
        fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_status_id")
    private InvoiceStatus invoiceStatus;

    public Invoice() {
    }


     public Invoice(String date, Double sum, Set<Product> products) {
        this.date = date;
        this.sum = sum;
        this.products = products;

    }
    public void addProduct(Product product){
        if(!products.contains(product)){
            products.add(product);
            product.getInvoices().add(this);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Set<Product> getProducts() {
    return products;
    }

     public void setProducts(Set<Product> products) {
     this.products = products;
    }

    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }
}

