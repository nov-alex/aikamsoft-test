package test.dataImpl.repository;

import org.springframework.stereotype.Repository;
import test.data.entity.Customers;
import test.data.repository.CustomersRepository;
import test.data.repository.common.BaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public final class CustomersRepositoryImpl extends BaseRepository implements CustomersRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Customers> getAllCustomersByLastName(String lastName) {
        return entityManager.createQuery("select с from Customers с where с.lastName = :lastName", Customers.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    public List<Customers> getCustomersByProductNameAndCount(String productName, Integer minTimes) {
        return entityManager
                .createQuery("select c from Purchases p join p.products pr join p.customers c where pr.productName=:productName group by c having count(c) >=cast(:minTimes as integer)", Customers.class)
                .setParameter("productName", productName)
                .setParameter("minTimes", minTimes)
                .getResultList();
    }

    @Override
    public List<Customers> getCustomersByMinMaxExpenses(Integer min, Integer max) {
        return entityManager
                .createQuery("select c from Purchases p join p.products pr join p.customers c group by c.id having sum(pr.productPrice) >=cast(:min as integer) and sum(pr.productPrice) <= cast(:max as integer)", Customers.class)
                .setParameter("min", min)
                .setParameter("max", max)
                .getResultList();
    }

    @Override
    public List<Customers> getCustomersByMinExpenses(Integer maxCustomersCount) {
        return entityManager
                .createQuery("select c from Purchases p join p.products pr join p.customers c group by c.id ORDER BY sum(pr.productPrice) asc", Customers.class)
                .setMaxResults(maxCustomersCount)
                .getResultList();
    }
}
