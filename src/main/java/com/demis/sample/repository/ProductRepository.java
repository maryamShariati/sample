package com.demis.sample.repository;



import com.demis.sample.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> getProductById(Long id);

    Optional<Product>findProductsByIdAndDeletedIsFalse(Long id);

    @Query(value = "from Product p where p.category.name=:category")
    List<Product> getProductsByCategory(@Param("category") String category);


}
