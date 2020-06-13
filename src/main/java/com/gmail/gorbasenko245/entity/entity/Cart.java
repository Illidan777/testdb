package com.gmail.gorbasenko245.entity.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue
    private Long id;

    private String ip;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Product>products=new ArrayList<Product>();

    public Cart(String ip, List<Product> products) {
        this.ip = ip;
        this.products = products;
    }

    public void addToCart(Product product){
        if(!products.contains(product)){
            products.add(product);
            product.setCart(this);
        }
    }

    public Cart() {
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
