package com.lanitoman.salestracker.sales;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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


    public Sales getSalesById(UUID Id){
        return salesRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Sales invoice not found." + Id));
    }


    public Sales addSales(Sales sales){
        salesRepository.save(sales);
        return sales;
    }

    public Sales addSalesWithLine(Sales sales){
//        if (sales.getLines() != null) {
//            for (SalesInvoiceLine line : sales.getLines()) {
//                line.setSalesInvoice(sales);
//            }
//        }
        salesRepository.save(sales);
        return sales;
    }

    public Sales updateSales(UUID id, Sales salesDetails){
        Sales existing = getSalesById(id);
        existing.setCustomer(salesDetails.getCustomer());
        existing.setDescription(salesDetails.getDescription());
        existing.setIssueDate(salesDetails.getIssueDate());
        return salesRepository.save(existing);
    }

    public void deleteSales(UUID Id){
        salesRepository.deleteById(Id);
    }


    public void deleteAllSales(){
        salesRepository.deleteAll();
    }


}
