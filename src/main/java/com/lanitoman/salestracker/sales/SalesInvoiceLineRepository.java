package com.lanitoman.salestracker.sales;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SalesInvoiceLineRepository extends JpaRepository<SalesInvoiceLine, UUID> {



}
