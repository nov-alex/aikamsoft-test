package test.dataImpl.repository;

import org.springframework.stereotype.Repository;
import test.api.dto.response.CustomersResponseDto;
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
    public List<Customers> allByLastName(String lastName) {
        return entityManager.createQuery("select с from Customers с where last_name = :lastName", Customers.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    public List<Customers> allByIds(List<Integer> ids) {
        return entityManager.createQuery("select с from Customers с where id in (:ids)", Customers.class)
                .setParameter("ids", ids)
                .getResultList();
    }
}
