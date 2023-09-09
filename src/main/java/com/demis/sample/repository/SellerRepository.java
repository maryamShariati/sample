package com.demis.sample.repository;

import com.demis.sample.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Long> {
    Optional<Seller> getSellerByNationalCode(String nationalCode);
}
