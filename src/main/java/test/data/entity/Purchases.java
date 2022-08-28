package test.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "purchases")
public class Purchases {
    @Id
    private Integer id;
    @Column(name = "customers_id")
    private Integer customersId;
    @Column(name = "products_id")
    private Integer productsId;
    @Column(name = "created_on")
    private LocalDate createdOn;
}

