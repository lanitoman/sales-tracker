package com.lanitoman.salestracker.sales;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="sales_invoices")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="reference", unique=true)
    private Integer ref;

    @Column(name="description")
    private String description;

    @Column(name="customer")
    private String customer;

    @Column(name="issueDate")
    private LocalDate issueDate;

    @OneToMany(mappedBy = "salesInvoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SalesInvoiceLine> lines = new ArrayList<>();


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
