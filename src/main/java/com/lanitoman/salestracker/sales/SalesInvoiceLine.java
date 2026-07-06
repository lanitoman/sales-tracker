package com.lanitoman.salestracker.sales;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class SalesInvoiceLine {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
    @JsonBackReference
    private Sales salesInvoice;

    @Column(name = "item")
    private String itemName;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "unitCost")
    private Integer unitCost;

    public SalesInvoiceLine(){

    }

    public SalesInvoiceLine(UUID id, String itemName, Integer qty, Sales salesInvoice, Integer unitCOst) {
        this.id = id;
        this.itemName = itemName;
        this.qty = qty;
        this.salesInvoice = salesInvoice;
        this.unitCost = unitCOst;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Sales getSalesInvoice() {
        return salesInvoice;
    }

    public void setSalesInvoice(Sales salesInvoice) {
        this.salesInvoice = salesInvoice;
    }

    public Integer getUnitCOst() {
        return unitCost;
    }

    public void setUnitCOst(Integer unitCOst) {
        this.unitCost = unitCost;
    }
}
