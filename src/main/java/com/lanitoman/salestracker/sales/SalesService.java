package com.lanitoman.salestracker.sales;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private SalesInvoiceLineRepository lineRepository;


    public List<Sales> getSales(){
        return salesRepository.findAll();
    }


    public Optional<Sales> getSalesById(UUID Id){
        return salesRepository.findById(Id);
    }


    public Sales addSales(Sales sales){
        salesRepository.save(sales);
        return sales;
    }




}
