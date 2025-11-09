package net.siham.billingservice.web;


import jakarta.ws.rs.PathParam;
import net.siham.billingservice.entities.Bill;
import net.siham.billingservice.feign.CustomerServiceRestClient;
import net.siham.billingservice.feign.InventoryServiceRestClient;
import net.siham.billingservice.model.Customer;
import net.siham.billingservice.repository.BillRepository;
import net.siham.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BillRestController {
    /*declaration des interfaces par private NomRepository........
    et l'injection de dependances par @Autowired
    */
    @Autowired
        private BillRepository billRepository;
    @Autowired
        private ProductItemRepository productItemRepository;
    @Autowired
        private CustomerServiceRestClient customerServiceRestClient;
    @Autowired
        private InventoryServiceRestClient inventoryServiceRestClient;

        @GetMapping("/bills/{id}")
        public Bill getBillById(@PathVariable Long id){
           Bill bill =  billRepository.findById(id).get();
           Customer customer = customerServiceRestClient.findCustomerById(bill.getCustomerId());
           bill.setCustomer(customer);
           bill.getProductItems().forEach(productItem -> {
               productItem.setProduct(inventoryServiceRestClient.getProduct(productItem.getProductId()));
           });
            return bill;
        }
}

