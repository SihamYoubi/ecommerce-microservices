package net.siham.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import net.siham.billingservice.model.Product;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductItem {
    @Id @GeneratedValue
    private Long id;
    private Long productId;
    private int quantity;
    private double price;
    @ManyToOne //Plusieurs product item peuvent se trouver dans une facture
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)//Desactiver Read
    private Bill bill;
    @Transient
    private Product product;
}

