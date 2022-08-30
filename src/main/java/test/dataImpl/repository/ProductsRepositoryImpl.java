package test.dataImpl.repository;

import org.springframework.stereotype.Repository;
import test.data.entity.Customers;
import test.data.repository.ProductsRepository;
import test.data.repository.common.BaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository
public final class ProductsRepositoryImpl extends BaseRepository implements ProductsRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Object[]> getProductsByDateIntervalDesc(LocalDate startDate, LocalDate endDate) {
        return entityManager
                .createQuery("select pr.productName,sum(pr.productPrice),c.lastName,c.firstName,c.id from Purchases p join p.products pr join p.customers c where p.createdOn between :startDate and :endDate group by pr.productName,pr.productPrice,c.id ORDER BY sum(pr.productPrice) desc", Object[].class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }
}
