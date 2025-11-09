package net.siham.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import net.siham.billingservice.model.Customer;

import java.util.Date;
import java.util.List;

@Entity
//la classe d'association
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Bill {
    @Id
    @GeneratedValue
    private Long id;
    private Date billingDate;
    private long customerId;
    //une facture a plusieurs product item, une relation biderectionnelle on met mappedBy
    //mappedBy: veut dire dans la class ProductItem, il y a un attribut qui s'appelle bill
    //qui represente la classe Bill
    @OneToMany(mappedBy="bill")
    private List<ProductItem> productItems;
    @Transient
    private Customer customer;
}
