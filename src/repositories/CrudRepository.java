package repositories;

import domain.Entity;

import java.util.Collection;

/**
 * CRUD operations repository interface
 * @param <ID> - type E must have an attribute of type ID
 * @param <E> - type of entities saved in repository
 */
public interface CrudRepository<ID, E extends Entity<ID>> {
    /**
     *
     * @return all entities
     */
    //Iterable<E> findAll();
    Collection<E> findAll();
}