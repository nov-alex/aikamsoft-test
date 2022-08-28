package test.data.repository.common;


import javax.persistence.EntityManager;

public abstract class BaseRepository implements CommonRepository {

    protected abstract EntityManager getEntityManager();

    @Override
    public void executeQuery(String query) {
        getEntityManager().createNativeQuery(query).executeUpdate();
    }
}
