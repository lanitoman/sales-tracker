package com.lanitoman.salestracker.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SalesService {

    private final SalesRepository salesRepository;

    @Autowired
    public SalesService(SalesRepository salesRepository){
        this.salesRepository = salesRepository;
    }

    public List<Sales> getSales(){
        return salesRepository.findAll();
    }

    public Optional<Sales> getSalesById(Integer ref){
        return salesRepository.findById(ref);
    }

    public Sales addSales(Sales sales){
        salesRepository.save(sales);
        return sales;
    }



}
