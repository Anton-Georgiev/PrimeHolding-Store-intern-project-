package repositories;

import java.util.Map;

public interface CartRepository<T> {
    Map<T, Double> getCollection();

    void add(T entity, Double quantity);

}
