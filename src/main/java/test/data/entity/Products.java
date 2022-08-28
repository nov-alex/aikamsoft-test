package test.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public final class Products {
    @Id
    private Integer id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_price")
    private String productPrice;
}
