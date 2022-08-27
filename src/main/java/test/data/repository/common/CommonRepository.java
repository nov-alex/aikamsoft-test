package test.data.repository.common;

/**
 * Общий интерфейс для репозитория
 */
public interface CommonRepository {
    /**
     * Метод выполнения переданного sql-запроса
     *
     * @param query sql-запрос
     */
    void executeQuery(String query);
}
