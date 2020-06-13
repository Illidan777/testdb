package com.gmail.gorbasenko245.entity.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Double size;
    private String country;
    private String pack;
    private String date;
    private Double priceKg;
    private Double pricePack;

    @Transient
    private Integer quantity;

    @ManyToMany(mappedBy = "products")
    private Set<Invoice> invoices = new HashSet<Invoice>();

    @ManyToOne(cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public Product() {
    }

    public Product(String name, Double size, String country, String pack, String date, Double priceKg, Double pricePack, Integer quantity) {
        this.name = name;
        this.size = size;
        this.country = country;
        this.pack = pack;
        this.date = date;
        this.priceKg = priceKg;
        this.pricePack = pricePack;
        this.quantity = quantity;
    }
    public void addOrder(Invoice invoice){
        if(!invoices.contains(invoice)){
            invoices.add(invoice);
            invoice.getProducts().add(this);
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

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getPriceKg() {
        return priceKg;
    }

    public void setPriceKg(Double priceKg) {
        this.priceKg = priceKg;
    }

    public Double getPricePack() {
        return pricePack;
    }

    public void setPricePack(Double pricePack) {
        this.pricePack = pricePack;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }


    @Override
    public String toString() {
        return "Продукт - " +
                "назва - " + name + '\'' +
                ", розмір - " + size +
                ", держава постачальник - " + country + '\'' +
                ", упаковка - " + pack + '\'' +
                ", дата вилову - " + date + '\'' +
                ", ціна за кілограм - " + priceKg +
                ", ціна за упаковку - " + pricePack +
                ", кількість - " + quantity;
    }
}
