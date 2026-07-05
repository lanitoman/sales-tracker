package com.lanitoman.salestracker.sales;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sales_invoices")
public class Sales {


    private String description;

    @Id
    @Column(name="reference", unique=true)
    private Integer ref;


    public Sales(){
    }

    public Sales(String description, Integer ref) {
        this.description = description;
        this.ref = ref;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRef() {
        return ref;
    }

    public void setRef(Integer ref) {
        this.ref = ref;
    }
}
