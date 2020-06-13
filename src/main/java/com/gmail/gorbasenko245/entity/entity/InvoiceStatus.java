package com.gmail.gorbasenko245.entity.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class InvoiceStatus {
    @Id
    @GeneratedValue
    private Long id;
    private String status;

    @OneToOne(mappedBy = "invoiceStatus")
    private Invoice invoice;

    public InvoiceStatus() {
    }

    public InvoiceStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
