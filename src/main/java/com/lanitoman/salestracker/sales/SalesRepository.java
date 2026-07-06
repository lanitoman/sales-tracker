package com.lanitoman.salestracker.sales;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Ref;
import java.util.Optional;
import java.util.UUID;

public interface SalesRepository extends JpaRepository<Sales, UUID> {

    void deleteByRef(Integer Ref);
    Optional<Ref> findByRef(Integer Ref);
}
