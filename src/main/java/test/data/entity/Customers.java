package test.data.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * Обертка для данных по покупателям
 */


@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "customers")
public final class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customers customers = (Customers) o;
        return id != null && Objects.equals(id, customers.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
