package net.siham.billingservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.siham.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient (name="inventory-service")
@CircuitBreaker(name = "inv-service", fallbackMethod = "getDefaultProduct")
public interface InventoryServiceRestClient {
    @GetMapping("/products/{id}")
    Product getProduct (@PathVariable Long id);

    default Product getDefaultProduct(Long id , Exception e){
        return Product.builder().id(id).build();
    }
}




