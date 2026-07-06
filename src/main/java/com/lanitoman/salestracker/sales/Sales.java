package com.lanitoman.salestracker.sales;


import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="sales_invoices")
public class Sales {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
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

    public Sales(String customer, String description, UUID id, LocalDate issueDate, List<SalesInvoiceLine> lines, Integer ref) {
        this.customer = customer;
        this.description = description;
        this.id = id;
        this.issueDate = issueDate;
        this.lines = lines;
        this.ref = ref;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public List<SalesInvoiceLine> getLines() {
        return lines;
    }

    public void setLines(List<SalesInvoiceLine> lines) {
        this.lines = lines;
    }

    public Integer getRef() {
        return ref;
    }

    public void setRef(Integer ref) {
        this.ref = ref;
    }
}
