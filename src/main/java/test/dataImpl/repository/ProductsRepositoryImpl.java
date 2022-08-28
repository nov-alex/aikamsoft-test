package test.dataImpl.repository;

import org.springframework.stereotype.Repository;
import test.data.repository.ProductsRepository;
import test.data.repository.common.BaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public List<Object[]> getCustomersIdsByProductName(String productName, int minTimes) {
        return entityManager
                .createQuery("select p.customersId,count(*) from Purchases p, Products pr where pr.productName=:productName and pr.id = p.productsId group by p.customersId HAVING COUNT(*) >=:minTimes", Object[].class)
                .setParameter("productName", productName)
                .setParameter("minTimes", minTimes)
                .getResultList();
    }
}
