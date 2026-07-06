package com.lanitoman.salestracker.sales;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/sales")
public class SalesController {


    private final SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService){
        this.salesService = salesService;
    }


    @GetMapping
    public List<Sales> getSales(@RequestParam(required = false) UUID id){
        return salesService.getSales();
    }

    @GetMapping("/{id}")
    public Sales getSalesById(@PathVariable UUID id){
        return salesService.getSalesById(id);
    }

    @PostMapping
    public ResponseEntity<Sales> addSales(@RequestBody Sales sales){
        Sales createdSales = salesService.addSalesWithLine(sales);
        return new ResponseEntity<>(createdSales, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sales> updateSales(@PathVariable UUID id, @RequestBody Sales sales){
        return ResponseEntity.ok(salesService.updateSales(id, sales));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Sales> deleteSales(@PathVariable UUID id){
        salesService.deleteSales(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAllSales(){
        salesService.deleteAllSales();
        return ResponseEntity.noContent().build();
    }


}
