package com.adamantsystems.adamantecommerce.repo;

import com.adamantsystems.adamantecommerce.models.Product;
import com.adamantsystems.adamantecommerce.models.ProductEnumCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends CrudRepository<Product,Long>{
    public List<Product> findAllByCategory(ProductEnumCategory category);
    public boolean existsByCategory(ProductEnumCategory category);

    public Product getProductById(Long id);
}
