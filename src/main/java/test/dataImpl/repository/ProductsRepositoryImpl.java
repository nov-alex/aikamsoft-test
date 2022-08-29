package test.dataImpl.repository;

import org.springframework.stereotype.Repository;
import test.data.entity.Customers;
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

}
