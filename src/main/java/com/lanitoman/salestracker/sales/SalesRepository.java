package com.lanitoman.salestracker.sales;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Ref;
import java.util.Optional;

public interface SalesRepository extends JpaRepository<Sales, Integer> {

    void deleteByRef(Integer Ref);
    Optional<Ref> findByRef(Integer Ref);

}
