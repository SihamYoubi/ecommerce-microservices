package net.siham.inventoryservice.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import net.siham.inventoryservice.entities.Product;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
}
